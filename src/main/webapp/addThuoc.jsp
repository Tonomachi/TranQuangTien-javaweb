<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <title>Thêm Thuốc</title>
</head>
<body>
<div class="container">
    <h2>Thêm Thuốc Mới</h2>
    <form action="addThuoc" method="post">
        <div class="form-group">
            <label for="tenThuoc">Tên Thuốc</label>
            <input type="text" class="form-control" name="tenThuoc" id="tenThuoc" required>
        </div>
        <div class="form-group">
            <label for="ngayNhap">Ngày Nhập</label>
            <input type="date" class="form-control" name="ngayNhap" id="ngayNhap" required>
        </div>
        <div class="form-group">
            <label for="loaiThuoc">Loại Thuốc</label>
            <input type="text" class="form-control" name="loaiThuoc" id="loaiThuoc" required>
        </div>
        <div class="form-group">
            <label for="soLuong">Số Lượng</label>
            <input type="number" class="form-control" name="soLuong" id="soLuong" required>
        </div>
        <div class="form-group">
            <label for="donGia">Đơn Giá</label>
            <input type="number" class="form-control" name="donGia" id="donGia" required>
        </div>
        <button type="submit" class="btn btn-primary">Thêm</button>
    </form>
</div>
</body>
</html>