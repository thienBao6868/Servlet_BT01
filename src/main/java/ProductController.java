
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Product", urlPatterns = { "/product" })
public class ProductController extends HttpServlet {

	List<Product> products = new ArrayList<Product>();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// set dữ liệu các product vào key products để file product.jsp lấy dữ liệu
		req.setAttribute("products", products);
		// Trả về file product.jsp cho người dùng
		req.getRequestDispatcher("product.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Lấy dữ liệu được gửi từ form
		String name = req.getParameter("name");
		Integer quantity = Integer.parseInt(req.getParameter("quantity"));
		Double price = Double.parseDouble(req.getParameter("price"));

		// xử lý chuyển thành tiền tệ VN 
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));

		// Chuyển đổi số double thành chuỗi đại diện cho số tiền
		String currencyString = currencyFormatter.format(price);

		// Thêm product mới vào danh sách các product
		products.add(new Product(name, quantity,  currencyString));

		// chuyển hướng yêu cầu sang servlet Product với phương thức get
		resp.sendRedirect(req.getContextPath() + "/product");

	}
}
