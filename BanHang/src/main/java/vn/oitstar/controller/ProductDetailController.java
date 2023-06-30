package vn.oitstar.controller;

import java.io.IOException;
import java.util.List;

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

@WebServlet(urlPatterns = {"/productdetail"})
public class ProductDetailController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//setting tiếng việt
				resp.setContentType("text/html");
				resp.setCharacterEncoding("utf-8");
				req.setCharacterEncoding("utf-8");
				//lấy tham số từ jsp
				String pid = req.getParameter("pid");
				//b1: khởi tạo DAO
				ProductDaoImpl productDao = new ProductDaoImpl();		
				CategoryDAO cateDao	= new CategoryDAO();
				//b2: sử dụng đối list để chứa danh sách từ productdao
				
				
				ProductModel list1 = productDao.getProductByID(pid);
				
				List<CategoryModel> listC = cateDao.getALLCategory();

				
				req.setAttribute("pdetail", list1);
				req.setAttribute("listcate", listC);
				//b4: chojn trang jsp trả về
				RequestDispatcher rq= req.getRequestDispatcher("/views/productdetail.jsp");
				rq.forward(req, resp);
			}
		
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
