package vn.oitstar.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.oitstar.service.CategoryService;
import vn.oitstar.service.CategoryServiceImpl;

@WebServlet(urlPatterns = {"/admin/category/delete"})

public class CategoryDeleteController extends HttpServlet{
	CategoryService cateService = new CategoryServiceImpl();

	protected void doGet(HttpServletRequest req, HttpServletResponse resq)throws ServletException, IOException{
		String id = req.getParameter("id");
		cateService.delete(Integer.parseInt(id));
		resp.sendRedirect(req.getContextPath() + "/admin/category/list");
	}
}
