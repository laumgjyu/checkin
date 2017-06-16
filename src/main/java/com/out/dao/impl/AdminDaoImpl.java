package com.out.dao.impl;

import com.out.dao.AdminDao;
import com.out.model.Admin;

/**
 * Created by lmy on 2017/6/11.
 */
public class AdminDaoImpl implements AdminDao {

    //根据管理员查找
    public Admin find(String adminname) {
        return dao.findFirst("SELECT * FROM t_admin WHERE adminname=?", adminname);
    }
}
