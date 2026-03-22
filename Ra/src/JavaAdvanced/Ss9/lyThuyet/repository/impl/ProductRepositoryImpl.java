package JavaAdvanced.Ss9.lyThuyet.repository.impl;

import Session11.lyThuyet.entity.Product;
import Session11.lyThuyet.repository.ProductRepository;
import Session11.lyThuyet.utility.DBUtility;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {
    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();

        Connection con;
        Statement stmt = null;
        ResultSet rs = null;

        con = DBUtility.connectMySql();

        try {
            stmt = con.createStatement();
            String sql = "SELECT * FROM product";
            rs = stmt.executeQuery(sql);

            while (rs.next()){
                Product product = new Product();
                product.setProId(rs.getInt("product_id"));
                product.setProName(rs.getString("product_name"));
                product.setProducer(rs.getString("producer"));
                product.setYearMaking(rs.getInt("year_making"));
                product.setExpiryDate(rs.getDate("expire_date"));
                product.setPrice(rs.getDouble("price"));
                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtility.closeAll(con, stmt, rs);
        }

        return products;
    }

    @Override
    public boolean addProduct(Product product) {
        boolean blInsert = false;

        Connection con;
        PreparedStatement stmt = null;

        con = DBUtility.connectMySql();

        try {
            String sql = "INSERT INTO product(product_name, producer, year_making, expire_date, price) VALUES (?, ?, ?, ?, ?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, product.getProName());
            stmt.setString(2, product.getProducer());
            stmt.setInt(3, product.getYearMaking());
            stmt.setDate(4, new Date(product.getExpiryDate().getTime()));
            stmt.setDouble(5, product.getPrice());

            int i = stmt.executeUpdate();
            if(i > 0){
                blInsert = true;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtility.closeAll(con, stmt, null);
        }

        return blInsert;
    }

    @Override
    public boolean updateProduct(Integer proId, Product product) {
        boolean blUpdate = false;

        Connection con;
        PreparedStatement stmt = null;

        con = DBUtility.connectMySql();

        try {
            String sql = "UPDATE product SET product_name = ?, producer = ?, year_making = ?, expire_date = ?, price = ? WHERE product_id = ?";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, product.getProName());
            stmt.setString(2, product.getProducer());
            stmt.setInt(3, product.getYearMaking());
            stmt.setDate(4, new Date(product.getExpiryDate().getTime()));
            stmt.setDouble(5, product.getPrice());
            stmt.setInt(6, proId);

            int i = stmt.executeUpdate();
            if(i > 0){
                blUpdate = true;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtility.closeAll(con, stmt, null);
        }

        return blUpdate;
    }

    @Override
    public boolean deleteProduct(Integer proId) {
        boolean blDelete = false;

        Connection con;
        Statement stmt = null;

        con = DBUtility.connectMySql();

        try {
            stmt = con.createStatement();
            String sql = "DELETE FROM product WHERE product_id = " + proId;

            int i = stmt.executeUpdate(sql);
            if(i > 0){
                blDelete = true;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtility.closeAll(con, stmt, null);
        }

        return blDelete;
    }
}
