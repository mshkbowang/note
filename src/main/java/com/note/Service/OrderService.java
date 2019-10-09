package com.note.Service;

import com.note.Model.Order;


import java.util.List;
public interface OrderService {
    //新增订单记录
    void addOrder(Order order);
    //获取所有预约信息
    List<Order> getAllOrder();
    //更新预约状态
    int UpdateghStatus(Order order);
    //删除预约记录
    int UpdateStatus(Order order);
    //根据id查看预约信息
    Order getOrderById(Integer orderId);

    List<Order> getAllOrderById(Order order);

    //根据userId查询订单记录
    List<Order> getOrderByUserId(Integer userId);

    //查询所有的预约订单
    List<Order> getAllOrderList();

    //根据orderId查询doctorId
    int getDoctorId(Integer orderId);


}
