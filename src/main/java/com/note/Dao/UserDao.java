package com.note.Dao;

import java.util.List;

import com.note.Model.User;

/**
 * ����:�û�mapper�ӿ�
 * 
 */
public interface UserDao {
	

    //登录
	User Login(User user);

	//注册
    void Register(User user);
    //根据userId查询用户信息
    User selectUserByUserId(Integer userId);

    //根据username查询用户信息
    User selectUserByUserName(String username);

    int AddUser(User user);
    /**
     * 
     * @param user
     * @return
     */
    int updateUserByUsername(User user);
    /**
     * 
     * @param startRow
     * @param pageSize
     * @return
     */
    List getAllUserInfo(String startRow,String pageSize);

    //根据userId查询所有
    User getOrderInfo(Integer userId);
}
