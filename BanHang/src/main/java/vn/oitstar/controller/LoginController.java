package vn.oitstar.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.oitstar.dao.LoginDAO;
import vn.oitstar.model.AccountModel;

@WebServlet(urlPatterns ={"/login"})
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		req.getRequestDispatcher("/decorator/logins.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("user");
		String password = req.getParameter("pass");
		
		LoginDAO loginDao = new LoginDAO();
		AccountModel account = loginDao.login(username, password);
		
		if(account == null) {
			req.setAttribute("mess", "Sai ID/Pass rồi anh bạn ơi!!");
			req.getRequestDispatcher("/decorator/logins.jsp").forward(req, resp);
		}else {
			HttpSession session = req.getSession();
			session.setAttribute("acc", account);
			/* session.setMaxInactiveInterval(1000); */
			resp.sendRedirect("home");
		}
		
	}
}
