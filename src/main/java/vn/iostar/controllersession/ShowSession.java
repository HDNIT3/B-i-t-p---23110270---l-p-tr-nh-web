package vn.iostar.controllersession;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

public class ShowSession extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Hiển thị session lên web
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        String ten = "";
        HttpSession s = req.getSession(); // Khởi tạo session
        Object obj = s.getAttribute("ten"); // Truy xuất dữ liệu từ session
        // Kiểm tra đối tượng Object có null không
        if (obj != null) {
            ten = String.valueOf(obj); // Ép kiểu về String
        } else {
            resp.sendRedirect("creatsession"); // Nếu null thì chuyển về trang tạo session
        }
        int tuoi = (Integer) s.getAttribute("tuoi"); // Ép kiểu
        // Hiển thị session lên web
        out.println("Xin chào bạn: " + ten + " tuổi: " + tuoi);
        out.close();
    }
}