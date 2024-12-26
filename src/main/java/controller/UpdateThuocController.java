package controller;

import model.Thuoc;
import model.Thuocdao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/updateThuoc")
public class UpdateThuocController extends HttpServlet {
  
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        Thuocdao thuocDao = new Thuocdao();
        Thuoc thuoc = thuocDao.getThuocById(id);

        request.setAttribute("thuoc", thuoc);
        request.getRequestDispatcher("editThuoc.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8"); // Đảm bảo mã hóa UTF-8
        int id = Integer.parseInt(request.getParameter("id"));
        String tenThuoc = request.getParameter("tenThuoc");
        Date ngayNhap = Date.valueOf(request.getParameter("ngayNhap"));
        String loaiThuoc = request.getParameter("loaiThuoc");
        int soLuong = Integer.parseInt(request.getParameter("soLuong"));
        
        String donGiaStr = request.getParameter("donGia").replace(",", "");
        long donGia = Long.parseLong(donGiaStr);

        Thuoc thuoc = new Thuoc();
        thuoc.setId(id);
        thuoc.setTenThuoc(tenThuoc);
        thuoc.setNgayNhap(ngayNhap);
        thuoc.setLoaiThuoc(loaiThuoc);
        thuoc.setSoLuong(soLuong);
        thuoc.setDonGia(donGia);

        Thuocdao thuocDao = new Thuocdao();
        thuocDao.updateThuoc(thuoc);

        response.sendRedirect("listThuoc");
    }
}