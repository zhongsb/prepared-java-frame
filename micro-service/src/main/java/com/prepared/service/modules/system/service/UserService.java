package com.prepared.service.modules.system.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.prepared.service.modules.system.entity.UserEntity;

/**
 * 用户登录接口service
 *
 * @author z
 * @date 2019/12/22
 */
public interface UserService extends IService<UserEntity> {

	/**
	 * 根据用户名和所属平台查询用户id
	 *
	 * @param userName 用户名
	 * @return
	 */
	String getUserIdByUserName(String userName);

	/**
	 * 验证用户名、密码是否有效
	 *
	 * @param userName
	 * @param password
	 * @return
	 */
	boolean isValidPassword(String userName, String password);

}
