package Inventory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import DB.DBConnection;

public class ProductDAO {
	
	
	public static boolean insertProduct(String name, double price, String category, int quantity) {
		Connection conn = null;
		PreparedStatement stmt = null;
		boolean status = false;

		
		try {
			conn = DBConnection.getConnection();
			String sql = "INSERT INTO products (product_name, price, category, stock) "
			 + "VALUES ( ?, ?, ?, ?)";
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setDouble(2, price);
			stmt.setString(3, category);
			stmt.setInt(4, quantity);
			
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
	
	public static boolean delete(int id) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		boolean status = false;

		
		try {
			conn = DBConnection.getConnection();
			String sql = "DELETE FROM products WHERE product_id = ?";
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);

			stmt.executeUpdate();
			status = true;
		
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
