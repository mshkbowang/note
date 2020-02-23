package com.note.Service.impl;


import com.note.Dao.OrderDao;
import com.note.Model.Order;
import com.note.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    //添加订单记录
    public void addOrder(Order order) {
      orderDao.addOrder(order);
    }

    public List<Order> getAllOrder() {
        return null;
    }

    public List<Order> getAllRegister() {
        return null;
    }

    public int UpdateghStatus(Order reg) {
        return 0;
    }

    public int UpdateStatus(Order reg) {
        return 0;
    }

    public Order getOrderById(Integer orderId) {
        return null;
    }

    public List<Order> getAllOrderById(Order order) {
        return null;
    }


    public List<Order> getOrderByUserId(Integer userId) {
        return orderDao.getOrderByUserId(userId);
    }

    //根据orderId查询doctorId
    public int getDoctorId(Integer orderId){
        return orderDao.getDoctorId(orderId);
    }


    //查询所有的预约订单
    public List<Order> getAllOrderList(){
        return orderDao.getAllOrderList();
    }


}
