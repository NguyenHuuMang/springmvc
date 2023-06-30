package vn.oitstar.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.oitstar.model.CategoryModel;
import vn.oitstar.model.ProductModel;
import vn.oitstar.service.CategoryService;
import vn.oitstar.service.CategoryServiceImpl;
import vn.oitstar.service.ProductService;
import vn.oitstar.service.impl.ProductServiceImpl;
@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/cart"})
public class CartController extends HttpServlet implements Serializable {

	ProductService productService = new ProductServiceImpl();
	CategoryService cateService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
				resp.setContentType("text/html");
				resp.setCharacterEncoding("utf-8");
				req.setCharacterEncoding("utf-8");
					
				List<ProductModel> list = productService.getAllProduct();
				//List<CategoryModel> listC = cateDa
				
				req.setAttribute("list4product", list);
				//req.setAttribute("listcate", listC);
				
				RequestDispatcher dispatcher= req.getRequestDispatcher("/views/cart-list.jsp");
				dispatcher.forward(req, resp);
	}
}
