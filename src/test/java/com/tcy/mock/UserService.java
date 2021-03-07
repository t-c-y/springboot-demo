package com.tcy.mock;

import com.tcy.domain.User;

public interface UserService {
    User findUserById(Long id);
    boolean addUser(User user);
}
