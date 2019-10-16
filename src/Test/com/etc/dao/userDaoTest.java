package com.etc.dao;

import com.etc.test.BaseTest;
import com.note.Dao.DeptDao;
import com.note.Dao.DoctorDao;
import com.note.Dao.OrderDao;
import com.note.Dao.UserDao;
import com.note.Model.Dept;
import com.note.Model.Doctor;
import com.note.Model.Order;
import com.note.Model.User;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.SimpleTimeZone;

public class userDaoTest extends BaseTest {
    @Autowired
    private UserDao userDao;
    @Autowired
    private DeptDao deptDao;
    @Autowired
    private DoctorDao doctorDao;
    @Autowired
    private OrderDao orderDao;

    @Test
    public void testLogin(){
        User user=new User("admin","admin");
        System.out.println(user);
        User ll=userDao.Login(user);
        System.out.println("$$$$"+ll);
    }

    @Test
    public void testRegister(){
        User user=new User("12","12","12","12","12");
        user.setLevel(1);
        userDao.Register(user);

    }
    @Test
    public void testShow(){
     //Dept dept1=new Dept("1");
        Dept dept=new Dept();
        dept.setStatus("1");
        System.out.println(dept);
       List<Dept> list=deptDao.getAllDeptInfo(dept);
       for(Dept k:list){
           System.out.println(k);
       }


    }
    @Test
    public void testShow2(){
        Doctor doctor=new Doctor();
        System.out.println("@"+doctor);
       List<Doctor> ll= doctorDao.getAllDoctorInfo(doctor);
       for(Doctor k:ll){
           System.out.println(k);
       }
    }
    @Test
    public void testShow3(){
        Doctor doctor=new Doctor();
        System.out.println("@"+doctor);
        List<Doctor> kk=doctorDao.getAllDoctorInfo1(doctor);
        for(Doctor h:kk){
            System.out.println(h);
        }
    }
    @Test
    public void testShow4(){
        Dept dept=new Dept();
        System.out.println("%%%%%%%%%%%%%%%%%"+dept);
        //dept.setDeptName("外科");
        Dept dept1=deptDao.getDeptByName("外科");
        System.out.println(dept1.getDeptId());
    }
    @Test
    public void testShow5(){
        Doctor doctor=new Doctor();
        doctor = doctorDao.getDoctorById(11);
        System.out.println(doctor);
    }
    @Test
    public void testShow6(){
        Doctor doctor=new Doctor();
      //  doctor.setDoctorId(13);
        doctorDao.deleteDoctorInfo(19);
    }
    @Test
    public void testShow7(){
        Dept dept=new Dept("fawfwefw","fwefewfwefwe","1","fewfewf");
       deptDao.AddDept(dept);
    }
    @Test
    public void testShow8(){
        Doctor doctor=new Doctor();
        doctor.setDoctorId(6);
        Doctor aa=doctorDao.selectDoctorInfo(doctor.getDoctorId());
        System.out.println(aa);
    }

    @Test
    public void testShow9(){
        Doctor doctor=new Doctor();
        Doctor d=doctorDao.getDoctorById(6);
        System.out.println("#################"+d);
    }
    @Test
    public void testShow10(){
        Dept dept=new Dept();
        Dept d=deptDao.getDeptById(10);
        System.out.println(d);
    }
    @Test
    public void testShow11(){
        User user=new User(1);
        System.out.println(user);

        User u=userDao.selectUserByUserId(user.getUserId());
        System.out.println(u);
    }

    @Test
    public void testShow12(){
//        Date date=new Date();
//        DateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String punchTime=simpleDateFormat.format(date);//格式化后的时间
//        System.out.println(punchTime);
//        System.out.println(punchTime.getClass().getName());
//         String date2="2019-09-03 12:12:12";
//        System.out.println(date2);
//        System.out.println(date2.getClass().getName());

//        Order order=new Order(2,8, new Date(),new Date());
//        order.setWStatus(1);
//    System.out.println(order);
//    orderDao.addOrder(order);
    }
    @Test
    public void testShow13(){
       List<Order> list =orderDao.getOrderByUserId(2);
        for (Order o:list) {
            System.out.println(o);
        }
    }

    @Test
    public void testShow14(){
        int o=orderDao.getDoctorId(3);
        System.out.println(o);
    }
    @Test
    public void testShow15(){
        Doctor d=doctorDao.getAllDoctorInfo2(3);
        System.out.println(d);
    }

    @Test
    public void testShow16(){
        List<Order> list =orderDao.getAllOrderList();
        for (Order o:list) {
            System.out.println(o);
        }
    }

    @Test
    public void testShow17(){
        User user=userDao.getOrderInfo(2);
        System.out.println(user);
    }
    @Test
    public void testShow18(){
        Dept dept=new Dept();
        dept.setDeptId(15);
        dept.setDeptName("liuwu");
        dept.setDeptArea("酒客12");
        dept.setDeptDes("很不错");
        int d=deptDao.updateDept(dept);
        System.out.println(d);
    }

}
