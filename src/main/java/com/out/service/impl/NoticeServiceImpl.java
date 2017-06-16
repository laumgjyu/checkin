package com.out.service.impl;

import com.out.dao.NoticeDao;
import com.out.dao.impl.NoticeDaoImpl;
import com.out.model.Notice;
import com.out.service.NoticeService;

import java.util.List;

/**
 * Created by lmy on 2017/6/15.
 */
public class NoticeServiceImpl implements NoticeService {
    NoticeDao dao = new NoticeDaoImpl();

    public List<Notice> listNotices() {
        return dao.list();
    }

    public Notice findById(int id) {
        return NoticeDao.dao.findById(id);
    }

    public void deleteById(int id) {
        NoticeDao.dao.deleteById(id);
    }


}
