package com.out.dao.impl;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.out.dao.UserDao;
import com.out.model.User;
import com.out.model.UserDetail;
import com.out.util.AESUtil;
import com.out.util.MD5Util;

import java.util.List;


/**
 * Created by lmy on 2017/6/11.
 */
public class UserDaoImpl implements UserDao {
    //根据用户名查找
    public User find(String username) {
        return dao.findFirst("SELECT * FROM t_user WHERE username=?", username);
    }

    public List list(int pageNumber) {
        if (pageNumber == 0) {
            return null;
        } else {
            final int PAGE_SIZE = 10;
            List count = dao.find("SELECT count(*) FROM t_user");
            User user = (User) count.get(0);
            long totalRecords = user.get("count(*)");
            long totalPage = (totalRecords + PAGE_SIZE - 1) / PAGE_SIZE;
            if (pageNumber >= totalPage) {
                pageNumber = (int) totalPage;
            }
            if (pageNumber <= 0) {
                pageNumber = 1;
            }
            Page page = dao.paginate(pageNumber, PAGE_SIZE, "SELECT * ", "FROM t_user u INNER JOIN t_userdetail d ON u.id = d.u_id");
            return page.getList();
        }
    }

    public List list() {

        List<User> users = dao.find("SELECT * FROM t_user u INNER JOIN t_userdetail d ON u.id = d.u_id");
        return users;
    }

    public User findById(int id) {
        return dao.findFirst("SELECT * FROM t_user u INNER JOIN t_userdetail d ON u.id = d.u_id WHERE u.id=?", id);
    }

    public User findByName(String name) {
        return dao.findFirst("SELECT * FROM t_user u INNER JOIN t_userdetail d ON u.id = d.u_id WHERE d.name=?", name);
    }

    public void saveUser(String imgPath, User user, UserDetail detail) throws Exception {
        detail.set("head", imgPath);
        String password = user.get("password");
        user.set("password", AESUtil.encrypt(password));
        user.save();
        detail.set("u_id", user.get("id"));
        detail.save();
        Db.update("INSERT INTO t_checkdate SET u_id=?", user.getInt("id"));
    }

    public int changPassword(String username, String password) throws Exception {
        String sql = "UPDATE t_user SET password=? WHERE username=?";
        return Db.update(sql, MD5Util.md5Encode(password), username);
    }

    public int getId(String username) {
        User user = dao.findFirst("SELECT id FROM t_user WHERE username=?", username);
        return user.getInt("id");
    }
}
