package Inventory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DB.DBConnection;

public class ProductDAO {
	
	public static boolean insertProduct(Products p) {
		Connection conn = null;
		PreparedStatement stmt = null;
		boolean status = false;
		
		String name = p.getName();
		double price = p.getPrice();
		int quantity = p.getQuantity();
		
		try {
			conn = DBConnection.getConnection();
			String sql = "INSERT INTO products (product_name, price, quantity) "
			 + "VALUES ( ?, ?, ?)";
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setDouble(2, price);
			stmt.setInt(3, quantity);
			
			int rowsInserted = stmt.executeUpdate();
			if (rowsInserted > 0) {
				status = true;
			}
		
		} 
		catch (SQLException e) {
			e.printStackTrace();
			status = false;
		} 
		finally {
			try { if (stmt != null) stmt.close(); } catch (SQLException ignored) {}
			try { if (conn != null) conn.close(); } catch (SQLException ignored) {}
		}
		return status;
	}

}
