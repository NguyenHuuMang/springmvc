package vn.oitstar.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.oitstar.dao.CategoryDAO;
import vn.oitstar.dao.ProductDaoImpl;
import vn.oitstar.model.CategoryModel;
import vn.oitstar.model.ProductModel;

@WebServlet(urlPatterns = {"/search"})

public class SearchController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		
		
		String txt1 = req.getParameter("txt");
		String cid = req.getParameter("cid");
		
		
		ProductDaoImpl dao = new ProductDaoImpl();
		CategoryDAO cateDao = new CategoryDAO();
		
		
		List<ProductModel> list = dao.searchByProductName(txt1);
		List<CategoryModel> listC = cateDao.getALLCategory();
		
		req.setAttribute("listAllproduct", list);
		req.setAttribute("listcate", listC);
		req.setAttribute("tagactive", cid);
		req.setAttribute("txtS", txt1);
		req.getRequestDispatcher("/views/product.jsp").forward(req, resp);
	}
	
	
}
