package model;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Thuocdao {
    private Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/hieuthuoc_tranquangtien", "root", "");
    }

    public List<Thuoc> getAllThuocs() {
        List<Thuoc> thuocs = new ArrayList<>();
        String sql = "SELECT * FROM thuoc_tranquangtien";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Thuoc thuoc = new Thuoc();
                thuoc.setId(rs.getInt("ID"));
                thuoc.setTenThuoc(rs.getString("TenThuoc"));
                thuoc.setNgayNhap(rs.getDate("NgayNhap"));
                thuoc.setLoaiThuoc(rs.getString("LoaiThuoc"));
                thuoc.setSoLuong(rs.getInt("SoLuong"));
                thuoc.setDonGia(rs.getLong("DonGia")); // Đảm bảo gọi là setLong
                thuocs.add(thuoc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return thuocs;
    }

    public Thuoc getThuocById(int id) {
        String sql = "SELECT * FROM thuoc_tranquangtien WHERE ID = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Thuoc thuoc = new Thuoc();
                thuoc.setId(rs.getInt("ID"));
                thuoc.setTenThuoc(rs.getString("TenThuoc"));
                thuoc.setNgayNhap(rs.getDate("NgayNhap"));
                thuoc.setLoaiThuoc(rs.getString("LoaiThuoc"));
                thuoc.setSoLuong(rs.getInt("SoLuong"));
                thuoc.setDonGia((long) rs.getFloat("DonGia"));
                return thuoc;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteThuoc(int id) {
        String sql = "DELETE FROM thuoc_tranquangtien WHERE ID = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateThuoc(Thuoc thuoc) {
        String sql = "UPDATE thuoc_tranquangtien SET TenThuoc = ?, NgayNhap = ?, LoaiThuoc = ?, SoLuong = ?, DonGia = ? WHERE ID = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, thuoc.getTenThuoc());
            pstmt.setDate(2, new java.sql.Date(thuoc.getNgayNhap().getTime()));
            pstmt.setString(3, thuoc.getLoaiThuoc());
            pstmt.setInt(4, thuoc.getSoLuong());
            pstmt.setLong(5, thuoc.getDonGia()); 
            pstmt.setInt(6, thuoc.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}