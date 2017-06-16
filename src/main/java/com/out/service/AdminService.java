package com.out.service;

import com.out.model.Admin;

/**
 * Created by lmy on 2017/6/15.
 */
public interface AdminService {
    boolean exist(String adminname);

    boolean passwordCorrect(String adminname,String adminpassword) throws Exception;
}
