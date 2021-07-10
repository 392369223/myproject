package com.project.dao;

import com.project.bean.Book;

import java.util.List;

public interface IBookDao {
    //通过不同的类型查找图书信息
    public List<Book> findBookByTag(String tag);
    //插入图书信息
    public int insertIntoBook(Book book);

    //public int delBookById(int id);
    //实现对卖书的操作，根据用户名和书名和买书的数量对书本数量更新
    public int update(String uname,String bookname,int count);
    //根据用户名查找上传图书的信息
    public List<Book> findBookByName(String uname);
    //根据id书的id查找书籍
    public Book findBookById(int id);
    public List<Book> findBookByIdList(List<Integer> ids);
    //根据输入的关键字进行模糊匹配
    public List<Book> findBooksByFuzzyname(String name);
    //实现上架和下架的切换
    public int updateLabel(int id,int label);
    //修改书本的数量
    public int updateCount(int id,int count);
}
