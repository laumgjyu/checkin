package com.out.dao;

import com.out.model.UserDetail;

/**
 * Created by lmy on 2017/6/15.
 */
public interface UserDetailDao {
    UserDetail dao = new UserDetail();

    int update(String sql, Object... paras);
}
