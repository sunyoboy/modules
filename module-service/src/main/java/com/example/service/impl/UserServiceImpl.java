package com.example.service.impl;
/**
 * @version 1.0
 * @author <a> href="mailto:sunyoboy@gmail.com">sunyoboy</a>
 * @since 2019/1/26 下午10:28
 */

import com.example.dao.UserDao;
import com.example.entity.User;
import com.example.service.UserService;
import java.lang.invoke.MethodHandles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory
        .getLogger(MethodHandles.lookup().lookupClass());

    @Autowired
    private UserDao userDao;

    @Override
    public User getUser() {
        return userDao.getUser();
    }
}
