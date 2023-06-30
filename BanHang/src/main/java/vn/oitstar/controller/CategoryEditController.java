package vn.oitstar.controller;

import java.io.IOException;
import java.util.List;
import java.util.Locale.Category;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import vn.oitstar.service.CategoryService;
import vn.oitstar.service.CategoryServiceImpl;

@WebServlet(urlPatterns = {"/admin/category/edit"})
public class CategoryEditController {
	CategoryService cateService = new CategoryServiceImpl();
	
protected void doGet(HttpServletRequest req, HttpServletResponse resq)throws ServletException, IOException{
	String id = req.getParameter("id");
	Category category = cateService.get(Integer.parseInt(id));
	req.setAttribute("category", category);
	RequestDispatcher dispatcher = req.getRequestDispatcher("/views/edit-category.jsp");
	dispatcher.forward(req, resq);
}

protected void doPost(HttpServletRequest req, HttpServletResponse resq)throws ServletException, IOException{
	Category category = new Category();
	DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
	ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
	servletFileUpload.setHeaderEncoding("utf-8");
	try {
		resp.setContentType("text/html");
		resp.serCharacterEncoding("utf-8");
		req.setCharaterEncoding("utf-8");
		List<FileItem> items = servletFileUpload.parseRequest(req);
		for (FileItem item:items) {
			if(item.getFieldName().equals("id")) {
				category.setId(Integer.parseInt(item.getString()));
			}else if(item.getFieldName().equals("name")) {
				category.setName(item.getString("utf-8"));
			}else if (item.getFieldName().equals("icon")) {
				if (item.getSize()>0){
					String originalFileName = item.getName();
					int index = originalFileName.lastIndexOf(".");
					String ext = originalFileName.substring(index + 1);
					String fileName = System.currentTimeMillis() +"." + ext;
					String file = new File(Constant.dir + "/category/" + fileName);
					item.write(file);
					category.setIcon("category/"+fileName);
				}else {
					category.setIcon(null);		}}}
		cateService.edit(category);
		resp.sendRedirect(rq.getContextPath() + "/admin/category/list");
}catch (FileUploadException e) {
	e.printStackTrace();
}catch (Exception e) {e.printStackTrace();}
	
	
}
}
