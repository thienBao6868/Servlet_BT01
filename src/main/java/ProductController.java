
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Config.MySQLConfig;
import emtity.Product;

import javax.servlet.*;
import java.sql.*;

@WebServlet(name = "Product", urlPatterns = { "/product" })
public class ProductController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Product> products = new ArrayList<Product>();

		String sql = "SELECT * FROM products";
		Connection connection = MySQLConfig.getConnection();

		try {

			// Execute a query
			PreparedStatement stmt = connection.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery(sql);

			// Process the ResultSet
			while (rs.next()) {
				String name = rs.getString("name");
				int quantity = rs.getInt("quantity");
				String price = rs.getString("price");
				Product pr = new Product(name, quantity, price);
				products.add(pr);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
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

		String price = req.getParameter("price");

		// xử lý chuyển thành tiền tệ VN

		// NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(new
		// Locale("vi", "VN"));

		// Chuyển đổi số double thành chuỗi đại diện cho số tiền

		// String currencyString = currencyFormatter.format(price);

		// Thêm product mới vào danh sách các product

		// Execute a query
		// Tạo câu truy vấn SQL với các tham số ?
		String sql = "INSERT INTO products (name, quantity, price) VALUES (?, ?, ?)";
		Connection connection = MySQLConfig.getConnection();

		try {

			// Tạo một PreparedStatement thay vì Statement
			PreparedStatement pstmt = connection.prepareStatement(sql);

			// Đặt các giá trị cho các tham số trong câu truy vấn
			pstmt.setString(1, name); // Giả sử biến name đã được khai báo và gán giá trị từ nơi khác
			pstmt.setInt(2, quantity); // Giả sử biến quantity đã được khai báo và gán giá trị từ nơi khác
			pstmt.setString(3, price); // Giả sử biến price đã được khai báo và gán giá trị từ nơi khác

			// Thực thi truy vấn INSERT
			int rowsAffected = pstmt.executeUpdate();

			// Kiểm tra số hàng đã được thêm vào
			if (rowsAffected > 0) {
				System.out.println("Insertion successful");
			} else {
				System.out.println("Insertion failed");
			}

			// Đóng PreparedStatement
			pstmt.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Lỗi bé ơi");
		}

		// chuyển hướng yêu cầu sang servlet Product với phương thức get

		resp.sendRedirect(req.getContextPath() + "/product");

	}
}
