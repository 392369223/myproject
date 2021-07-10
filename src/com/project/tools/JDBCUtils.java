package com.project.tools;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.File;
import java.sql.*;
import java.util.Iterator;

public class JDBCUtils {
    private static String url;
    private static String user;
    private static String passwd;
    private static String driver;
    public static Connection getConnection() {
        getSource();

        Connection con = null;
        try {
            //加载驱动
            Class.forName(driver);//反射
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            //System.out.println(url+"===="+user+"====="+passwd+"===="+driver);
            con = DriverManager.getConnection(url,user,passwd);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            return con;
        }
    }
    public static void close(Connection con, Statement sta, ResultSet s) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        try {
            if (s != null) {
                s.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (sta != null) {
            try {
                sta.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    public static void getSource(){
        SAXReader sax=new SAXReader();
        try {
            Document document=sax.read(new File(JDBCUtils.class.getClassLoader().getResource("application.xml").getPath()));
            //获取文档的根节点
            Element rootElement = document.getRootElement();
            //获取根节点下的所有子节点
            Iterator i = rootElement.elementIterator();
            //循环获取子节点
            for (;i.hasNext();) {
                //得到每一个子节点Element
                Element element = (Element) i.next();
                if(element.getName().equals("url")){
                    url=element.getStringValue();
                }
                if(element.getName().equals("username")){
                    user=element.getStringValue();
                }
                if(element.getName().equals("password")){
                    passwd=element.getStringValue();
                }
                if(element.getName().equals("driver")){
                    driver=element.getStringValue();
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
