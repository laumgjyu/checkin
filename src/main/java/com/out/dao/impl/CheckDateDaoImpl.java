package com.out.dao.impl;

import com.jfinal.plugin.activerecord.Db;
import com.out.dao.CheckDateDao;
import com.out.model.CheckDate;

import java.util.List;

/**
 * Created by lmy on 2017/6/15.
 */
public class CheckDateDaoImpl implements CheckDateDao {
    public void update(Object... objects) {
        String sql = "update t_checkdate a inner join t_user b on b.username=? AND a.u_id=b.id set a.checkDate=?";
        Db.update(sql, objects);
    }

    public List<CheckDate> findByName(String username) {
        String sql = "SELECT * FROM t_checkdate c INNER JOIN t_user u ON u.id = c.u_id WHERE u.username=?";
        List<CheckDate> checkDates = dao.find(sql, username);
        return checkDates;
    }

    public void checkin(int u_id,String checkDate) {
        String sql = "INSERT INTO t_checkdate SET u_id=?,checkDate=?";
        Db.update(sql, u_id,checkDate);
    }

    public List<CheckDate> listCheckedDays(int id) {
        String sql = "SELECT checkDate FROM t_checkdate c INNER JOIN t_user u ON u.id = c.u_id WHERE u.id=?";
        List<CheckDate> checkDates=dao.find(sql, id);
        return checkDates;
    }
}
