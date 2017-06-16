package com.out.dao;

import com.out.model.Admin;

/**
 * Created by lmy on 2017/6/15.
 */
public interface AdminDao {
    Admin dao = new Admin();
    Admin find(String adminname);
}
