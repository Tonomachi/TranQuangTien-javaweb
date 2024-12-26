<%@ page import="model.Thuoc" %>
<%@ page import="model.Thuocdao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    Thuocdao thuocDao = new Thuocdao();
    Thuoc thuoc = thuocDao.getThuocById(id); 
%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <title>Sửa Thuốc</title>
</head>
<body>
<div class="container">
    <h2>Sửa Thuốc</h2>
    <form action="updateThuoc" method="post">
        <input type="hidden" name="id" value="<%= thuoc.getId() %>">
        <div class="form-group">
            <label>Tên Thuốc</label>
            <input type="text" class="form-control" name="tenThuoc" value="<%= thuoc.getTenThuoc() %>" required>
        </div>
        <div class="form-group">
            <label>Ngày Nhập</label>
            <input type="date" class="form-control" name="ngayNhap" value="<%= thuoc.getNgayNhap() %>" required>
        </div>
        <div class="form-group">
            <label>Loại Thuốc</label>
            <input type="text" class="form-control" name="loaiThuoc" value="<%= thuoc.getLoaiThuoc() %>" required>
        </div>
        <div class="form-group">
            <label>Số Lượng</label>
            <input type="number" class="form-control" name="soLuong" value="<%= thuoc.getSoLuong() %>" required>
        </div>
 <div class="form-group">
    <label for="donGia">Đơn Giá</label>
    <input type="number" class="form-control" name="donGia" id="donGia" value="<%= thuoc.getDonGia() %>" required>
</div>
        <button type="submit" class="btn btn-primary">Cập Nhật</button>
    </form>
</div>
</body>
</html>