package com.note.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.note.Dao.UserDao;
import com.note.Model.User;
import com.note.Service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Autowired  
	private UserDao userDao;
	public User Login(User user) {
		return  userDao.Login(user);
	}
	public void Register(User user){
		userDao.Register(user);
	}

	public User selectUserByUserId(Integer userId){
		return userDao.selectUserByUserId(userId);
	}

	public User selectUserByUserName(String username){
		return userDao.selectUserByUserName(username);
	}
	public int AddUser(User user){
	      return userDao.AddUser(user);
	 }
	 
	 public int updateUserByUsername(User user) {
		 return userDao.updateUserByUsername(user);
	 }

	//根据userId查询所有
	public User getOrderInfo(Integer userId){
		return userDao.getOrderInfo(userId);
	}
}
