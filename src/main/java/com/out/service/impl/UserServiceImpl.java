package com.out.service.impl;

import com.out.dao.UserDao;
import com.out.dao.impl.UserDaoImpl;
import com.out.model.User;
import com.out.model.UserDetail;
import com.out.service.UserService;
import com.out.util.AESUtil;

import java.util.List;

/**
 * Created by lmy on 2017/6/15.
 */
public class UserServiceImpl implements UserService {
    UserDao dao = new UserDaoImpl();

    public boolean exist(String imgPath, String username, User user, UserDetail detail) throws Exception {
        User usernameInDb = dao.find(username);
        if (usernameInDb == null) {
            dao.saveUser(imgPath, user, detail);
            return false;
        } else {
            return true;
        }
    }

    public boolean exist(String username) {
        return dao.find(username) != null;
    }

    public boolean passwordCorrect(String username, String password) throws Exception {

        User user = dao.find(username);
        String passwordInDb = user.getStr("password");
        return AESUtil.encrypt(password).equals(passwordInDb);
    }

    public List<User> listByPage(int pageNumber) {
        List<User> users = dao.list(pageNumber);
        for (User user : users) {
            String password = user.get("password");
            System.out.println(password);
            System.out.println(AESUtil.decrypt(password));

            user.set("password", AESUtil.decrypt(password));
        }
        return users;
    }

    public void deleteById(int id) {
        UserDao.dao.deleteById(id);
    }

    public User findById(int id) {
        return UserDao.dao.findById(id);
    }

    public void update(User user) {
        user.update();
    }

    public User findByName(String username) {
        return dao.findByName(username);
    }


    public List<User> list() {
        return dao.list();
    }

    public void register() {

    }

    public int changPassword(String username,String password) throws Exception {
        return dao.changPassword(username, password);
    }

    public int getId(String username) {
        return dao.getId(username);
    }


}
