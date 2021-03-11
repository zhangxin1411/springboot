package com.mybatis.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mybatis.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper extends BaseMapper<User> {
    List selectByPer(String name);


}
