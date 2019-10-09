package com.note.Controller;
import java.util.List;

import javax.annotation.Resource;

import com.note.Model.Doctor;
import com.note.Model.User;
import com.note.Service.DoctorService;
import com.note.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.note.Model.Order;
import com.note.Service.OrderService;

@Controller
public class OrderController {

    @Resource
    private OrderService orderService;
    @Resource
	private DoctorService doctorService;
    @Resource
    private UserService userService;

    //用户预约，产生预约单
	@RequestMapping("addOrder.do")
	@ResponseBody
	public String addOrder(@RequestBody Order order) {
		System.out.println(order);
		order.setWStatus(1);
		String result = "";
		try{
			orderService.addOrder(order);
			result = "success";
		}catch(Exception e) {
			result = "error";
		}
		return result;
	}
//
//    @RequestMapping("getRegList.do")
//    @ResponseBody
//    public List<Order> getOrderLists() {
//        List<Order> regList = null;
//        try{
//            regList = regService.getAllOrder();
//            Integer length = regList.size();
//            //查询到数据 返回前台账号已存在
//            if(length > 0) {
//                return regList;
//            }
//        }catch(Exception e) {
//        }
//        System.out.println(regList);
//        return regList;
//    }
	//根据userId查询用户的所有预约订单
    @RequestMapping("getOrderListByUserId.do")
    @ResponseBody
    public List<Order> getOrderListByUserId(Integer userId) {
		System.out.println(userId);
		List<Order> result=null;
		try{
        List<Order> orders=orderService.getOrderByUserId(userId);
        for(Order order :orders) {
            int a = orderService.getDoctorId(order.getOrderId());
            Doctor b = doctorService.getAllDoctorInfo2(a);
            order.setDoctorName(b.getDoctorName());
            order.setDeptName(b.getDeptName());

//			Integer doc
//			Doctor doc = docS....
//			order.setDoctorName(doc.getDoctorName());
        }


            result=orders;
		}catch(Exception e){
		}
        return result;
    }

    //查询所有的预约订单
    @RequestMapping("getAllOrderList.do")
    @ResponseBody
    public List<Order> getAllOrderList(){
            List<Order> orders=orderService.getAllOrderList();
                for (Order order:orders){
                int a=orderService.getDoctorId(order.getOrderId());
                Doctor b=doctorService.getAllDoctorInfo2(a);
                order.setDoctorName(b.getDoctorName());
                order.setDeptName(b.getDeptName());
               User user=userService.getOrderInfo(order.getUserId());
               order.setAddress(user.getAddress());
               order.setTel(user.getTel());
            }
        for(Order o:orders){
            System.out.println(o);
        }

        return orders;
    }
//    @RequestMapping("getRegById.do")
//    @ResponseBody
//    public Order getRegById(Order reg) {
//
//        Integer OrderId=reg.getOrderId();
//        Order reg1 = regService.getOrderById(OrderId);
//        return reg1;
//    }
//
//    @RequestMapping("updateghStatus.do")
//    @ResponseBody
//    public String updateghStatus(Order reg) {
//        String result = "";
//
//        try{
//            int id = regService.UpdateghStatus(reg);
//
//            if(id > 0) {
//                result = "success";
//            }
//        }catch(Exception e) {
//            result = "error";
//        }
//        return result;
//    }
//
//    @RequestMapping("updateStatus.do")
//    @ResponseBody
//    public String updateStatus(Order reg) {
//        String result = "";
//
//        try{
//            int id = regService.UpdateStatus(reg);
//
//            if(id > 0) {
//                result = "success";
//            }
//        }catch(Exception e) {
//            result = "error";
//        }
//        return result;
//    }
}

