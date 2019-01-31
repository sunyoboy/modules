package com.example.dao;
/**
 * @version 1.0
 * @author <a> href="mailto:sunyoboy@gmail.com">sunyoboy</a>
 * @since 2019/1/26 下午9:53
 */

import com.example.entity.User;
import java.lang.invoke.MethodHandles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    private static final Logger logger = LoggerFactory
        .getLogger(MethodHandles.lookup().lookupClass());

    public User getUser() {
        return User.builder().age(12).username("sunyoboy").build();
    }
}
