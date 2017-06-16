package com.out.dao;

import com.out.model.CheckDate;

import java.util.List;

/**
 * Created by lmy on 2017/6/15.
 */
public interface CheckDateDao {
    CheckDate dao = new CheckDate();
    void update(Object... objects);

    List<CheckDate> findByName(String username);

    void checkin(int u_id,String checkDate);

    List<CheckDate> listCheckedDays(int id);
}
