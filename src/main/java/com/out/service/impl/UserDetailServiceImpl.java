package com.out.service.impl;

import com.out.dao.UserDetailDao;
import com.out.dao.impl.UserDetailDaoImpl;
import com.out.model.UserDetail;
import com.out.service.UserDetailService;

/**
 * Created by lmy on 2017/6/15.
 */
public class UserDetailServiceImpl implements UserDetailService {
    UserDetailDao dao = new UserDetailDaoImpl();

    public void update(UserDetail detail) {
        detail.update();
    }

    public void update(Object... objects) {
        String sql = "update t_checkdate a inner join t_user b on b.username=? AND a.u_id=b.id set a.checkDate=?";
        dao.update(sql, objects);
    }
}
