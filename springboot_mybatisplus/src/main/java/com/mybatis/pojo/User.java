package com.mybatis.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

@Data
public class User {
    //知识点：将数据库字段设置成bigint 且自增，IdType.ID_WORKER == uuid ，IdType.AUTO == 自增
    @TableId(type = IdType.ID_WORKER)
    private Long uId;
    private String uName;
    private Integer uAge;
    private String uTel;
    private String uAddr;
    private String uDesc;
    @TableField(fill = FieldFill.INSERT)
    private String createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateTime;
    @TableLogic
    private Integer delState;

    public User(Long uId, String uName, Integer uAge, String uTel, String uAddr, String uDesc) {
        this.uId = uId;
        this.uName = uName;
        this.uAge = uAge;
        this.uTel = uTel;
        this.uAddr = uAddr;
        this.uDesc = uDesc;
    }

    public User() {
    }
}
