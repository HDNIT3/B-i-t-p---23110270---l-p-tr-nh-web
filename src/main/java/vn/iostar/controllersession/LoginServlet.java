package vn.iostar.controllersession;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns= {"/login1"})
public class LoginServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		PrintWriter out = resp.getWriter();
		if (username.equals("trung")&& password.equals("123")) {
		
		out.print("Chào mừng bạn, " + username);
		HttpSession session = req.getSession();
		session.setAttribute("name", username);
		} else {
		out.print("Tài khoản hoặc mật khẩu không chính xác");
		req.getRequestDispatcher("loginsession.html").include(req,
		resp);
		}
	}
}
