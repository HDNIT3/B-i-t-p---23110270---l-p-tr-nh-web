package vn.iostar.controllersession;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class Logout extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Hủy Session
        HttpSession session = request.getSession();
        session.invalidate();
        request.getRequestDispatcher("loginsession.html").include(request, response);
    }
}