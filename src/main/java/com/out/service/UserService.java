package com.out.service;

import com.out.model.User;
import com.out.model.UserDetail;

import java.util.List;

/**
 * Created by lmy on 2017/6/15.
 */
public interface UserService {
    boolean exist(String imgPath, String username, User user, UserDetail detail) throws Exception;

    boolean exist(String username);

    boolean passwordCorrect(String username, String password) throws Exception;

    List<User> listByPage(int pageNumber);

    void deleteById(int id);

    User findById(int id);

    void update(User user);

    User findByName(String username);

    List<User> list();

    void register();

    int changPassword(String username,String password) throws Exception;

    int getId(String username);

}
