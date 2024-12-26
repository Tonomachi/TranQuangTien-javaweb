package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet("/addThuoc")
public class AddThuocController extends HttpServlet {
 
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8"); 
        
        String tenThuoc = request.getParameter("tenThuoc");
        String ngayNhap = request.getParameter("ngayNhap");
        String loaiThuoc = request.getParameter("loaiThuoc");
        int soLuong = Integer.parseInt(request.getParameter("soLuong"));
        float donGia = Float.parseFloat(request.getParameter("donGia"));

        String sql = "INSERT INTO thuoc_tranquangtien (TenThuoc, NgayNhap, LoaiThuoc, SoLuong, DonGia) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hieuthuoc_tranquangtien", "root", "");
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setString(1, tenThuoc);
            pstmt.setDate(2, Date.valueOf(ngayNhap));
            pstmt.setString(3, loaiThuoc);
            pstmt.setInt(4, soLuong);
            pstmt.setFloat(5, donGia);
            pstmt.executeUpdate();
            
            response.sendRedirect("listThuoc"); 
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Có lỗi xảy ra khi thêm thuốc");
        }
    }
}