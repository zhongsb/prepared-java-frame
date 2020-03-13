package com.prepared.service.modules.system.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户实体类
 *
 * @author: z
 * @Date: 2019/12/7 09:52
 */
@Data
@TableName("t_user")
public class UserEntity implements Serializable {

    /**
     * 主键id
     */
    @TableId
    private String id;

    /**
     * 用户
     */
    @TableField("username")
    private String userName;

    /**
     * 密码
     */
    @TableField("password")
    private String password;


    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 状态 1:启用 2:注销
     */
    @TableField("account_state")
    private String accountState;

}
