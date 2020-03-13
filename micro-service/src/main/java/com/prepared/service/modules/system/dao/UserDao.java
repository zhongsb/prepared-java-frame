package com.prepared.service.modules.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.prepared.service.modules.system.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户dao
 *
 * @author z
 * @date 2019/12/22
 */
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {

}
