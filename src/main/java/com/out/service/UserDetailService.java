package com.out.service;

import com.out.model.UserDetail;

/**
 * Created by lmy on 2017/6/15.
 */
public interface UserDetailService {

    void update(UserDetail detail);

    void update(Object... objects);
}
