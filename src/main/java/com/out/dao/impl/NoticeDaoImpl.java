package com.out.dao.impl;

import com.out.dao.NoticeDao;
import com.out.model.Notice;
import com.out.service.NoticeService;

import java.util.List;

/**
 * Created by lmy on 2017/6/12.
 */
public class NoticeDaoImpl implements NoticeDao {


    public List<Notice> list() {
        List<Notice> notices = dao.find("SELECT * FROM t_notice");
        return notices;
    }
}
