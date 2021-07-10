package com.project.action;

import com.project.bean.Book;
import com.project.dao.BookDao;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
//负责上传图片等信息
@WebServlet("/upload")
public class upload extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //得到上传文件的保存目录，将上传的文件存放于WEB-INF目录下，不允许外界直接访问，保证上传文件的安全
        req.setCharacterEncoding("utf-8");
        String[] content=new String[6];
        int i=0;
        String savePath="D:\\IdeaProjects\\JavaSEProject\\myproject\\web\\userimages\\"+req.getSession().getAttribute("uname");
        File file = new File(savePath);
        boolean ret=false;
        boolean ret2=true;
        //System.out.println(savePath);
        if(!file.exists()&&!file.isDirectory()){
            //System.out.println(file.getAbsoluteFile());
            ret=file.mkdir();
        }
        /*if(ret){
            //System.out.println("文件上传成功");
        }*/
        //1、创建一个DiskFileItemFactory工厂
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        //2、创建一个文件上传解析器
        ServletFileUpload fileUpload = new ServletFileUpload(diskFileItemFactory);
        String path="";
        //解决上传文件名的中文乱码
        fileUpload.setHeaderEncoding("UTF-8");
        if(!fileUpload.isMultipartContent(req)){
            //按照传统方式获取数据
            req.getRequestDispatcher("/error.jsp").forward(req,resp);
        }else {
            HashMap<String,String> map=new HashMap<>();
            path="userimages/"+req.getSession().getAttribute("uname")+"/";
            //4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
            try {
                List<FileItem> list = fileUpload.parseRequest(req);
                for (FileItem item : list) {
                    //如果fileitem中封装的是普通输入项的数据
                    if (item.isFormField()) {
                        String name = item.getFieldName();
                        //解决普通输入项的数据的中文乱码问题
                        String value = item.getString("UTF-8");
                        //System.out.println(name + "  " + value);
                        map.put(name,value);
                        content[i]=value;
                        i++;
                    } else {
                        //如果fileitem中封装的是上传文件，得到上传的文件名称，
                        String fileName = item.getName();
                        //System.out.println(fileName);
                        if (fileName == null || fileName.trim().equals("")) {
                            continue;
                        }
                        fileName = fileName.substring(fileName.lastIndexOf(File.separator) + 1);
                        path=path+fileName;
                        //获取item中的上传文件的输入流
                        InputStream is = item.getInputStream();
                        //创建一个文件输出流F
                        File f = new File(savePath + File.separator + fileName);
                        if (!f.exists()) {
                            FileOutputStream fos = new FileOutputStream(savePath + File.separator + fileName);
                            //创建一个缓冲区
                            byte buffer[] = new byte[1024];
                            //判断输入流中的数据是否已经读完的标识
                            int length = 0;
                            //循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
                            while ((length = is.read(buffer)) > 0) {
                                //使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
                                fos.write(buffer, 0, length);
                            }
                            //关闭输入流
                            is.close();
                            //关闭输出流
                            fos.close();
                            //删除处理文件上传时生成的临时文件
                            item.delete();
                        } else {
                            ret2=false;
                            break;
                        }
                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
        }
        if(ret2) {
            BookDao dao=new BookDao();
            Book book=new Book();
            book.setPath(path);
            book.setSaler(req.getSession().getAttribute("uname").toString());
            book.setName(content[0]);
            book.setAuthor(content[1]);
            book.setPrise(Double.parseDouble(content[2]));
            book.setTag(content[3]);
            book.setCount(Integer.parseInt(content[4]));
            //System.out.println(content);
            int j=dao.insertIntoBook(book);
            if(j!=0) {
                req.getRequestDispatcher("/Main.jsp").forward(req, resp);
            }else{
                req.getRequestDispatcher("/error.jsp").forward(req,resp);
            }
        }else{
            req.getRequestDispatcher("/error.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
