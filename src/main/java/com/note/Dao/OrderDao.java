package com.note.Dao;

import com.note.Model.Order;

import java.util.List;



public interface OrderDao {
	
	//新增订单记录
	 void addOrder(Order order);
	//��ȡ����ԤԼ��Ϣ
	List<Order> getAllOrder();
	//����ԤԼ״̬
	int UpdateghStatus(Order order);
	//ɾ��ԤԼ��¼
	int UpdateStatus(Order order);
	//����id�鿴ԤԼ��Ϣ
	Order getRegById(Integer orderId);
	List<Order> getAllOderByName(Order order);
	//根据orderId查询doctorId
	int getDoctorId(Integer orderId);

	//根据userId查询订单记录
	List<Order> getOrderByUserId(Integer userId);
	//查询所有的预约订单
    List<Order> getAllOrderList();


}
