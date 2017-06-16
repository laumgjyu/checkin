package com.out.dao;

import com.out.model.Notice;

import java.util.List;

/**
 * Created by lmy on 2017/6/15.
 */
public interface NoticeDao {
    Notice dao = new Notice();

    List<Notice> list();

}
