package com.out.service.impl;

import com.out.dao.FileDao;
import com.out.dao.impl.FileDaoImpl;
import com.out.service.FileService;

/**
 * Created by lmy on 2017/6/15.
 */
public class FileServiceImpl implements FileService {
    FileDao dao = new FileDaoImpl();
}
