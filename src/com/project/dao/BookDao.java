package com.project.dao;

import com.project.bean.Book;
import com.project.tools.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
    Connection con=null;
    PreparedStatement sta=null;
    ResultSet st=null;
    //通过tag获得所有的满足条件的图书
    public List<Book> findBookByTag(String tag){
        List<Book> lst=new ArrayList<>();
        Book book=null;
        String sql="select * from book where tag=? and label=1";
        con=JDBCUtils.getConnection();
        try {
            sta=con.prepareStatement(sql);
            sta.setString(1,tag);
            st=sta.executeQuery();
            while(st.next()){
                book=new Book();
                book.setId(st.getInt(1));
                book.setName(st.getString(2));
                book.setAuthor(st.getString(3));
                book.setPrise(st.getDouble(4));
                book.setPath(st.getString(5));
                book.setTag(tag);
                book.setCount(st.getInt(7));
                book.setSaler(st.getString(8));
                book.setLabel(1);
                lst.add(book);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(con,sta,st);
            return lst;
        }
    }
    //插入除了id之外的所有属性
     public int insertIntoBook(Book book){
         String sql="insert into book(name,author,prise,img,tag,coun,saler,label) values(?,?,?,?,?,?,?,?)";
         con= JDBCUtils.getConnection();
         int i=0;
         try {
             sta=con.prepareStatement(sql);
             sta.setString(1,book.getName());
             sta.setString(2,book.getAuthor());
             sta.setDouble(3,book.getPrise());
             sta.setString(4,book.getPath());
             sta.setString(5,book.getTag());
             sta.setInt(6,book.getCount());
             sta.setString(7,book.getSaler());
             sta.setInt(8,1);
             i=sta.executeUpdate();
         } catch (SQLException throwables) {
             throwables.printStackTrace();
         } finally {
             JDBCUtils.close(con,sta,null);
             return i;
         }
     }
    public int delBookById(int id){
         con=JDBCUtils.getConnection();
         String sql="delete from book where id=?";
         int i=0;
        try {
            sta= con.prepareStatement(sql);
            sta.setInt(1,id);
            i=sta.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(con,sta,null);
            return i;
        }
    }
    //根据卖家名和书籍类型更新改变书的数量等基本信息
    public int update(String uname,String bookname,int count){
         con=JDBCUtils.getConnection();
         String sql="update book set coun=coun-? where name=? and saler=?";
         int i=0;
        try {
            sta=con.prepareStatement(sql);
            sta.setInt(1,count);
            sta.setString(2,bookname);
            sta.setString(3,uname);
            i=sta.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(con,sta,null);
            return i;
        }
    }
    //根据用户名查找相应的书籍信息
    public List<Book> findBookByName(String uname){
         Book book=null;
        List<Book> u=new ArrayList<>();
        String sql="select * from book where saler=?";
        con=JDBCUtils.getConnection();
        try {
            sta=con.prepareStatement(sql);
            sta.setString(1,uname);
            st=sta.executeQuery();
            while(st.next()){
                book=new Book();
                book.setId(st.getInt(1));
                book.setName(st.getString(2));
                book.setAuthor(st.getString(3));
                book.setPrise(st.getDouble(4));
                book.setPath(st.getString(5));
                book.setTag(st.getString(6));
                book.setCount(st.getInt(7));
                book.setSaler(uname);
                book.setLabel(st.getInt(9));
                u.add(book);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(con,sta,st);
            return u;
        }
    }
    public Book findBookById(int id){
        String sql="select * from book where id=?";
        Book book=null;
        con=JDBCUtils.getConnection();
        try {
            sta=con.prepareStatement(sql);
            sta.setInt(1,id);
            st=sta.executeQuery();
            if(st.next()){
                book=new Book();
                book.setId(id);
                book.setName(st.getString(2));
                book.setAuthor(st.getString(3));
                book.setPrise(st.getDouble(4));
                book.setPath(st.getString(5));
                book.setTag(st.getString(6));
                book.setCount(st.getInt(7));
                book.setSaler(st.getString(8));
                book.setLabel(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(con,sta,st);
            return book;
        }
    }
    public List<Book> findBookByIdList(List<Integer> ids){
        List<Book> idbooks=new ArrayList<>();
        for(int id:ids) {
            idbooks.add(findBookById(id));
        }
        return idbooks;
    }
    public List<Book> findBooksByFuzzyname(String name){
        List<Book> books=new ArrayList<>();
        Book book=null;
        String name1="%"+name;
        String name2=name+"%";
        String name3="%"+name+"%";
        String sql="select * from book where (name like ? or name like ? or name like ? or name like ?) and label=1";
        con=JDBCUtils.getConnection();
        try {
            sta=con.prepareStatement(sql);
            sta.setString(1,name);
            sta.setString(2,name1);
            sta.setString(3,name2);
            sta.setString(4,name3);
            st=sta.executeQuery();
            while(st.next()){
                book=new Book();
                book.setId(st.getInt(1));
                book.setName(st.getString(2));
                book.setAuthor(st.getString(3));
                book.setPrise(st.getDouble(4));
                book.setPath(st.getString(5));
                book.setTag(st.getString(6));
                book.setCount(st.getInt(7));
                book.setSaler(st.getString(8));
                book.setLabel(1);
                books.add(book);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(con,sta,st);
            return books;
        }
    }
    public int updateLabel(int id,int label){
        int i=0;
        con=JDBCUtils.getConnection();
        String sql="update book set label=? where id=?";
        try {
            sta=con.prepareStatement(sql);
            sta.setInt(1,label);
            sta.setInt(2,id);
            i=sta.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(con,sta,null);
            return i;
        }
    }
    public int updateCount(int id,int count){
        int i=0;
        con=JDBCUtils.getConnection();
        String sql="update book set coun=? where id=?";
        try {
            sta=con.prepareStatement(sql);
            sta.setInt(1,count);
            sta.setInt(2,id);
            i=sta.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.close(con,sta,null);
            return i;
        }
    }
}
