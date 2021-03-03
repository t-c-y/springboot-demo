package com.tcy.service;

import com.tcy.domain.User;

import java.util.List;

public interface UserService {

    List<User> listUser();

    User getUserById(Long id);

    int saveUser(User user);

    int updateUser(User user);

    int removeUser(Long id);
}
