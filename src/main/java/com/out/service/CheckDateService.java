package com.out.service;

import com.out.model.CheckDate;

import java.util.List;

/**
 * Created by lmy on 2017/6/15.
 */
public interface CheckDateService {

    boolean idChecked(String username);

    List<CheckDate> listCheckedDays(int id);
}
