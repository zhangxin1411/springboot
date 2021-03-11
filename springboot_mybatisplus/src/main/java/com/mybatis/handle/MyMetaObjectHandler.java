package com.mybatis.handle;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert exeute ... ");
        this.setFieldValByName("createTime",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill.....");
        this.setFieldValByName("updateTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()), metaObject);
    }
}
