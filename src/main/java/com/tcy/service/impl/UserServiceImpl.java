package com.tcy.service.impl;

import com.tcy.dao.UserDao;
import com.tcy.domain.User;
import com.tcy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author tongchengyu
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> listUser() {
        return userDao.listUser();
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveUser(User user) {
        return userDao.saveUser(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int removeUser(Long id) {
        return userDao.removeUser(id);
    }
}
