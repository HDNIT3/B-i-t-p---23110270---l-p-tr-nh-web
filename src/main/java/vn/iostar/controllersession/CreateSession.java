package vn.iostar.controllersession;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class CreateSession extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Khởi tạo session
        HttpSession s = req.getSession();
        // Gán dữ liệu vào session
        s.setAttribute("ten", "HuynhDuyNguyen");
        s.setAttribute("tuoi", 18);
        // Thiết lập thời gian tồn tại session (giây)
        s.setMaxInactiveInterval(30);
        // Hiển thị thông báo lên web
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("Xin chào bạn session đã được tạo");
        out.close();
    }
}
