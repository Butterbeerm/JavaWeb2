package com.atguigu.updownload;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author Riddle
 * @description
 * @time 2021-08-24 14:03
 */
public class UploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(ServletFileUpload.isMultipartContent(req)){
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
            ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
            try {
                List<FileItem> list = servletFileUpload.parseRequest(req);
                for(FileItem f:list){
                    if(f.isFormField()){
                        System.out.println(f.getFieldName());
                        System.out.println(f.getString("UTF-8"));
                    }else{
                        System.out.println(f.getFieldName());
                        System.out.println(f.getName());
                        f.write(new File(f.getName()));
                    }
                }
            } catch (FileUploadException e) {

                    e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
