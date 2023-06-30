package vn.oitstar.controller;

import java.util.List;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.oitstar.dao.CategoryDAO;
import vn.oitstar.dao.ProductDaoImpl;
import vn.oitstar.model.CategoryModel;
import vn.oitstar.model.ProductModel;

@WebServlet(urlPatterns = {"/home","/trang-chu"})

public class HomeController extends HttpServlet{
	
	private static final long serialVersionUID = 4916110328503874794L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//setting tiếng việt
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		//b1: khởi tạo DAO
		ProductDaoImpl productDao = new ProductDaoImpl();		
		CategoryDAO cateDao	= new CategoryDAO();
		//b2: sử dụng đối list để chứa danh sách từ productdao
		List<ProductModel> list = productDao.getTop4Product();
		List<CategoryModel> listC = cateDao.getALLCategory();
		//b3: thiết lập dữ liệu lên jsp
		req.setAttribute("list4product", list);
		req.setAttribute("listcate", listC);
		//b4: chojn trang jsp trả về
		RequestDispatcher rq= req.getRequestDispatcher("/views/home.jsp");
		rq.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
