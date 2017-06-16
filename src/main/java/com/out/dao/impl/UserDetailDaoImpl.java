package com.out.dao.impl;

import com.jfinal.plugin.activerecord.Db;
import com.out.dao.UserDetailDao;
import com.out.model.UserDetail;
import com.out.service.UserDetailService;


/**
 * Created by lmy on 2017/6/11.
 */
public class UserDetailDaoImpl implements UserDetailDao {

    public int update(String sql,Object... paras) {
        return Db.update(sql,paras);
    }
}
