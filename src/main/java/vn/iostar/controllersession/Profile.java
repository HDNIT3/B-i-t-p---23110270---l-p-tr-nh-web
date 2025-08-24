package vn.iostar.controllersession;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;


@WebServlet(urlPatterns = {"/profile"})
public class Profile extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);
        if (session != null) {
            String name = (String) session.getAttribute("name");
            out.print("Chào bạn, " + name + " đến với trang quản lý tài khoản");
        } else {
            out.print("Xin vui lòng đăng nhập");
            response.sendRedirect("loginsession.html");
        }
        out.close();
    }
}