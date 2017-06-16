package com.out.service;

import com.out.model.Notice;

import java.util.List;

/**
 * Created by lmy on 2017/6/15.
 */
public interface NoticeService {

    List<Notice> listNotices();

    Notice findById(int id);

    void deleteById(int id);

}
