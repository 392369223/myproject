package com.project.test;

import com.project.bean.Book;
import com.project.bean.Order;
import com.project.bean.User;
import com.project.dao.BookDao;
import com.project.dao.OrderDao;
import com.project.dao.UserDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test5 {
    public static void main(String[] args) {
        UserDao dao=new UserDao();
        //OrderDao dao=new OrderDao();
        /*Book book=new Book();
        book.setName("武林外传");
        book.setAuthor("李明");
        book.setPrise(10.0);
        book.setPath("./img/mycat.jpg");
        book.setTag("生活");
        book.setCount(2);
        book.setSaler("admin");
        int i=dao.insertIntoBook(book);
        if(i==0){
            System.out.println("插入失败");
        }else{
            System.out.println("插入成功");
        }*/
        /*int i=dao.delBookById(3);
        if(i==0){
            System.out.println("删除失败");
        }else{
            System.out.println("删除成功");
        }*/
       /*
       int i=dao.update("admin","我们的中国",2);
        if(i==0){
            System.out.println("更新失败");
        }else {
            System.out.println("更新成功");
        }*/
        /*List<Book> lst=dao.findBookByName("admin");
        for(Book b:lst) {
            System.out.println(b);
        }*/
       /* Order order=new Order();
        order.setBuyname("admin");
        order.setSalername("123");
        order.setName("我们的中国");
        order.setCount(10);
        order.setPrise(18);
       int i= dao.insertIntoOrder(order);
        if(i==0){
            System.out.println("插入失败");
        }else{
            System.out.println("插入成功");
        }*/
       /* List<Order> lst=dao.findOrderByName("123");
        System.out.println(lst);*/
      /*List<Order> lst= dao.findOrder2ByName("admin");
      for(Order o:lst){
          System.out.println(o);*/
        /*UserDao dao1=new UserDao();
       int i= dao1.recharge(100,"aa");
       if(i==0){
           System.out.println("充值失败");
       }else{
           System.out.println("充值成功");
       }*/
        /*Book book=new Book();
        book.setName("武林外传");
        book.setAuthor("李明");
        book.setPrise(10.0);
        book.setPath("./img/mycat.jpg");
        book.setTag("生活");
        book.setCount(2);
        book.setSaler("admin");
        int i=dao.insertIntoBook(book);
        if(i==0){
            System.out.println("失败");
        }else{
            System.out.println("成功");
        }*/
        /*UserDao dao1=new UserDao();
        Map<String,String> map=new HashMap<>();
        map.put("uname","aa");
        List<User> u=dao1.findUserInfoByArgs(map);
        System.out.println(u);*/

        /*int i=dao.updateUserByUname("aa","男","112","123");
        if(i==0){
            System.out.println("修改失败");
        }else{
            System.out.println("修改成功");
        }*/
        BookDao dao1=new BookDao();
        String name="";
        List<Book> lst=dao1.findBookByTag("生活");
        for (Book b:lst) {
            System.out.println(b);
        }
    }
}
