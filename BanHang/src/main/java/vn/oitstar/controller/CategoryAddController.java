package vn.oitstar.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.taglibs.standard.lang.jstl.Constants;

import vn.oitstar.service.CategoryService;

@WebServlet(urlPatterns = {"/admin/catefory/add"})

public class CategoryAddController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	CategoryService cateService = new CategoryServiceImpl();
	protected void doGetdoGet(HttpServletRequest req, HttpServletResponse resq)throws ServletException, IOException{
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/add-category/jsp");
		dispatcher.forward(req, resq);
		}
	protected void doPost(HttpServletRequest req, HttpServletResponse resq)throws ServletException, IOException{
		Category category = new Category();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("utf-8");
		try {
			resp.setContetxType("text/html");
			resp.setCharaterEncoding("utf-8");
			req.setCharacterEncoding("utf-8");
			List<FileItem> Items = servletFileUpload.parseParameterMap(req);
			for (FileItem item:itens) {
				if(item.getFieldName().equals("name")) {
					category.setName(item.getString("utf-8"));		
				}else if (item.getFieldName().equals("icon")) {
					String originalFileName = item.getName();
					int index = originalFileName.lastIndexOf(".");
					String ext = originalFileName.substring(index + 1);
					String fileName = System.currentTimeMillis() +"." + ext;
					File file = new File(Constants.DIR +"/catefory/" + fileName);
					item.write(file);
					category.setIcon("category/" +fileName);
				}
			}
			cateService.insert(category);
			resp.sendRedirect(req.getContextPath() + "/admin/category/list");
		}catch (FileUploadException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
