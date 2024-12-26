<%@ page import="java.util.List" %>
<%@ page import="model.Thuoc" %>
<%@ page import="model.Thuocdao" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <title>Danh Sách Thuốc</title>
</head>
<body>
<div class="container">
    <h2>Danh Sách Thuốc của bác sĩ Trần Quang Tiến</h2>
    <a href="addThuoc.jsp" class="btn btn-primary mb-3">Thêm Thuốc</a> 

    <table class="table table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Tên Thuốc</th>
            <th>Ngày Nhập</th>
            <th>Loại Thuốc</th>
            <th>Số Lượng</th>
            <th>Đơn Giá</th>
            <th>Chức Năng</th>
        </tr>
        </thead>
        <tbody>
        <% 
            Thuocdao dao = new Thuocdao();
            List<Thuoc> thuocs = dao.getAllThuocs();
            for (Thuoc thuoc : thuocs) {
        %>
            <tr>
                <td><%= thuoc.getId() %></td>
                <td><%= thuoc.getTenThuoc() %></td>
                <td><%= thuoc.getNgayNhap() %></td>
                <td><%= thuoc.getLoaiThuoc() %></td>
                <td><%= thuoc.getSoLuong() %></td>
                <td><%= String.format("%,d", thuoc.getDonGia()) %></td> <!-- Đảm bảo định dạng đúng -->
                <td>
                    <a href="updateThuoc?id=<%= thuoc.getId() %>" class="btn btn-warning btn-sm">Sửa</a>
                    <a href="deleteThuoc?id=<%= thuoc.getId() %>" class="btn btn-danger btn-sm">Xóa</a>
                </td>
            </tr>
        <% } %>
        </tbody>
    </table>
</div>
</body>
</html>