package vn.oitstar.controller;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import vn.oitstar.model.CartItemModel;
import vn.oitstar.model.ProductModel;
import vn.oitstar.service.ProductService;
import vn.oitstar.service.impl.ProductServiceImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/cart-add"})
public class CartAddController extends HttpServlet{
	
	
	ProductService productService = new ProductServiceImpl();		

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
			String pId = req.getParameter("pId");
			String quantity = req.getParameter("quantity");
			/*
			 * ProductModel product = (ProductModel) productService.getAllProductByCID(pId);
			 * CartItemModel cartItem = new CartItemModel();
			 * cartItem.setQuantity(Integer.parseInt(quantity));
			 * cartItem.setUnitPrice(product.getPrice()); cartItem.setProduct(product);
			 */

			HttpSession httpSession = req.getSession();
			Object obj = httpSession.getAttribute("cart");
			if (obj == null) {
				Map<Integer, CartItemModel> map = new HashMap<Integer, CartItemModel>();
				//map.put(cartItem.getProduct().getId(), cartItem);
				httpSession.setAttribute("Cart", map);
			}else {
				Map<Integer, CartItemModel> map = extracted(obj);
				CartItemModel existedCartItem = map.get(Integer.valueOf(pId));
				if (existedCartItem == null ){
					//map.put(product.getId(), existedCartItem);
				}else {
					existedCartItem.setQuantity(existedCartItem.getQuantity() + Integer.parseInt(quantity));
				}
				httpSession.setAttribute("cart",map);
			}
			RequestDispatcher rq= req.getRequestDispatcher("/views/cart-list.jsp");
			rq.forward(req, resp);
	
	}
	@SuppressWarnings("unchecked")
	private Map<Integer, CartItemModel> extracted(Object obj){
		return (Map<Integer, CartItemModel>) obj;
	}
}
