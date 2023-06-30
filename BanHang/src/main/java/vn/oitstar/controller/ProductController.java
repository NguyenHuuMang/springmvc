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
import vn.oitstar.model.CategoryModel;
import vn.oitstar.model.ProductModel;
import vn.oitstar.service.ProductService;
import vn.oitstar.service.impl.ProductServiceImpl;

@WebServlet(urlPatterns = {"/product","/san-pham"})
public class ProductController extends HttpServlet{
	//b1: khởi tạo DAO
			ProductService productService = new ProductServiceImpl();		
			CategoryDAO cateDao	= new CategoryDAO();
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//setting tiếng việt
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		//lấy tham số từ jsp
		String cid = req.getParameter("cid");

		//b2: sử dụng đối list để chứa danh sách từ productdao
		//List<ProductModel> list = productService.getAllProduct();
		List<CategoryModel> listC = cateDao.getALLCategory();
		List<ProductModel> listPC = productService.getAllProductByCID(cid);
		
		String indexPage = req.getParameter("index");
		//khoi tao trang dau
		if(indexPage == null){
			indexPage ="1";
		}
		int index = Integer.parseInt(indexPage);
		int count = productService.countAll();
		//chia trang cho count
		int endPage = count/3;
		if (count %3 !=0) {
			endPage ++;
		}
		List<ProductModel> list = productService.pagingProduct(index);
		
		req.setAttribute("endP", endPage);
		//b3: thiết lập dữ liệu lên jsp
		if ("0".equals(cid)) {
		req.setAttribute("listAllproduct", list);
		}else {
		req.setAttribute("listAllproduct", listPC);
		}
		req.setAttribute("listcate", listC);
		req.setAttribute("tagactive", cid);
		req.setAttribute("tag", index);
		//b4: chojn trang jsp trả về
		RequestDispatcher rq= req.getRequestDispatcher("/views/product.jsp");
		rq.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
