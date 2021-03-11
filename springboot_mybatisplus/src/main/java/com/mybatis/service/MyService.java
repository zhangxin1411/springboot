package com.mybatis.service;

import com.mybatis.pojo.User;
import org.springframework.stereotype.Service;

@Service
public interface MyService {

    User findUserById(String userId);
    String transactional();
}
