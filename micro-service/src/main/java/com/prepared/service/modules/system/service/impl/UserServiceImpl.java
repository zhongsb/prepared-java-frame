package com.prepared.service.modules.system.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.prepared.service.modules.system.dao.UserDao;
import com.prepared.service.modules.system.entity.UserEntity;
import com.prepared.service.modules.system.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

/**
 * 用户service实现类
 *
 * @author z
 * @Date 2019/12/07
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

	@Override
	public String getUserIdByUserName(String userName) {
		if(StringUtils.isEmpty(userName)) {
			return null;
		}
		QueryWrapper<UserEntity> userEntityQueryWrapper = new QueryWrapper<>();
		userEntityQueryWrapper.eq("username", userName);
		UserEntity userEntity = getOne(userEntityQueryWrapper);
		if(userEntity != null) {
			return userEntity.getId();
		}
		return null;
	}

	@Override
	public boolean isValidPassword(String userName, String password) {
		if(StringUtils.isEmpty(userName)) {
			return false;
		}
		QueryWrapper<UserEntity> userEntityQueryWrapper = new QueryWrapper<>();
		userEntityQueryWrapper.eq("username", userName);
		userEntityQueryWrapper.eq("password", password);
		UserEntity userEntity = getOne(userEntityQueryWrapper);
		if(userEntity != null) {
			return true;
		}
		return false;
	}

}
