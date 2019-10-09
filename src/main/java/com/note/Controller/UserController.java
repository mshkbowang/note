package com.note.Controller;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.note.Model.Order;
import com.note.Service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.note.Model.User;
import com.note.Service.UserService;


@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	@RequestMapping("login.do")
	@ResponseBody
	public String login(HttpSession session,User user){
		String result = "";
			User user1 = userService.Login(user);
			if(user1==null){
				result="error";
			}else if(user1.getLevel()==1){
				result="1";

			}else{
				result="2";
			}
	    return result;
	}
	@RequestMapping("/addReg.do")
	@ResponseBody
	public String addRegister(User user,HttpSession session) {
		System.out.println("@#@#@############"+user);
		String result = "";
		if(user!=null){
			userService.Register(user);
			result="success";
		}
		return result;
	}
	/**
	 * �˳���½
	 * @param session
	 * @return
	 */
//	@RequestMapping("loginout.do")
//	public String loginout(HttpSession session){
//		//���session
//		session.invalidate();
//		return "redirect:index.do";
//	}
	
	/**
	 * ע��
	 * @param user
	 * @return
	 */
//	@RequestMapping("register.do")
//	@ResponseBody
//	public String add(User user) {
//		String result = "";
//
//		String username = user.getUsername();
//		String password = user.getPassword();
//		String name = user.getwName();
//		System.out.println("��ǰ�˻�ȡ����Ϣ��" + username +"__"+ password +"__"+name);
//
//		try{
//			System.out.println("��ʼ����insert");
//			User db_user = userService.selectUserByUsername(username);
//			Integer id = db_user.getUserId();
//			//��ѯ������ ����ǰ̨�˺��Ѵ���
//			if(id != null) {
//				result = "exists";
//			}
//		}catch(Exception e) {
//			//��ѯ��������ʱ ��������
//			System.out.println("��ʼinsert�����ݿ�");
//			userService.AddUser(user);
//			int pid = user.getUserId();
//			System.out.println(pid);
//			result = "success";
//		}
//
//		System.out.println(result);
//		return result;
//	}
	
	@RequestMapping("getUserData.do")
	@ResponseBody
	public User getUserData(Integer userId) {
		User result = null;
		try{
			User user=userService.selectUserByUserId(userId);
			result=user;

		}catch(Exception e) {
		}

		return result;
	}

//	@RequestMapping("index.do")
//	public String index() {
//		return "note";
//	}
//
//	/**
//	 * ��������
//	 * @param user
//	 * @return
//	 */
//	@RequestMapping("/changePassword.do")
//	@ResponseBody
//	public String changePassword(User user) {
//		String result = "";
//
//		String username = user.getUsername();
//		String password = user.getPassword();
//		String name = user.getName();
//
//		System.out.println("��ǰ�˻�ȡ����Ϣ��" + username +"__"+ password +"__"+name);
//
//		try {
//			System.out.println("��ʼ����update");
//			int id = userService.updateUserByUsername(user);
//			System.out.println(id);
//			result = "success";
//		}catch(Exception e) {
//			//��ѯ��������ʱ ��������
//			result = "error";
//
//		}
//		return result;
//	}
}

