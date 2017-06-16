package com.out.service.impl;

import com.out.dao.AdminDao;
import com.out.dao.impl.AdminDaoImpl;
import com.out.model.Admin;
import com.out.service.AdminService;
import com.out.util.MD5Util;

/**
 * Created by lmy on 2017/6/15.
 */
public class AdminServiceImpl implements AdminService {
    AdminDao dao = new AdminDaoImpl();

    public boolean exist(String adminname) {
        Admin admin = dao.find(adminname);
        return admin != null;
    }


    public boolean passwordCorrect(String adminname, String adminpassword) throws Exception {
        Admin admin = dao.find(adminname);

        String adminpasswordInDb = admin.getStr("adminpassword");

        return  MD5Util.md5Encode(adminname).equals(adminpasswordInDb);
    }
}