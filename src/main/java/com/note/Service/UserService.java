package com.note.Service;

import com.note.Model.User;

import java.util.List;

public interface UserService {
	//登录
	User Login(User user);
	//注册
	void Register(User user);

	//通过用户userId查询
	User selectUserByUserId(Integer userId);
	
	int AddUser(User user);
	
	int updateUserByUsername(User user);

	//根据userId查询所有
	User getOrderInfo(Integer userId);
}
