package vn.oitstar.controller;

import java.io.IOException;
import java.util.List;
import java.util.Locale.Category;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.oitstar.service.CategoryService;
import vn.oitstar.service.CategoryServiceImpl;

@WebServlet(urlPatterns = {"/admin/category"})
public class CategoryController {
	CategoryService cateService = new CategoryServiceImpl();
	
protected void doGet(HttpServletRequest req, HttpServletResponse resq)throws ServletException, IOException{
	List<Category> cateList = cateService.getAll();
	req.setAttribute("cateList", cateList);
	RequestDispatcher dispatcher = req.getRequestDispatcher("/views/list-category.jsp");
	dispatcher.forward(req, resq);
}

}
