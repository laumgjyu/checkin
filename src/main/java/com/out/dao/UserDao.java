package com.out.dao;

import com.out.model.User;
import com.out.model.UserDetail;

import java.util.List;

/**
 * Created by lmy on 2017/6/15.
 */
public interface UserDao {

    User dao = new User();

    User find(String username);

    List list(int pageNumber);

    List list();

    User findById(int id);

    User findByName(String name);

    void saveUser(String imgPath, User user, UserDetail detail) throws Exception;
}
