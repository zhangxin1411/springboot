package com.mybatis.service.impl;

import com.mybatis.mapper.UserMapper;
import com.mybatis.pojo.User;
import com.mybatis.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MyServiceImpl implements MyService {


    @Autowired
    UserMapper userMapper;


    @Override
    public User findUserById(String userId) {
        return  userMapper.selectById(userId);
    }

    @Override
    public String transactional() {

        Long [] longArray={4L,6L,5L};
        for (int i=0;i<3;i++){
            User user = new User();
            user.setUTel("15344303040");
            user.setUAddr("长春市宽城区柳影路");
            user.setUAge(23);
            if (i==1){
                System.out.println(6/0);
            }
            user.setUName("小张");
            user.setUId(longArray[i]);
            int insertNum = userMapper.updateById(user);
            System.out.println("id:"+longArray[i]+"已经被成功修改");
        }
        return "ok";
    }
}
