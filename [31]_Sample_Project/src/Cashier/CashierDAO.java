package Cashier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import DB.DBConnection;

public class CashierDAO {
	public static boolean insertToPending(int id, int quantity) {
		Connection conn = null;
		PreparedStatement stmt = null;
		boolean status = false;
			
		try {
			conn = DBConnection.getConnection();
			String sql = "INSERT INTO pos_db.pending_items(product_id, quantity, price) \r\n"
					+ "SELECT product_id, ?, price FROM products WHERE product_id = ?;";
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, quantity);
			stmt.setInt(2, id);

			
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
	
	public static String getPendingTotal() {
		Connection conn = DBConnection.getConnection();
		if (conn != null) {
		    try {
		        String query = "SELECT SUM(subtotal) FROM pending_items;"; // example
		        PreparedStatement stmt = conn.prepareStatement(query);
		        ResultSet rs = stmt.executeQuery();

		        Object resultValue = null;

		        if (rs.next()) {
		            resultValue = rs.getObject(1); // get first column value
		        }

		        
		        
		        rs.close();
		        stmt.close();
		        conn.close();
		        if(resultValue != null) {
		        	return resultValue.toString();
		        }
		        else {
		        	return null;
		        }
		       

		    } catch (SQLException e) {
		        e.printStackTrace();
		        
		    }
		    
		}
		return null;
	}
	
	public static String countPending() {
		Connection conn = DBConnection.getConnection();
		if (conn != null) {
		    try {
		        String query = "SELECT COUNT(*) FROM pending_items;"; // example
		        PreparedStatement stmt = conn.prepareStatement(query);
		        ResultSet rs = stmt.executeQuery();

		        Object resultValue = null;

		        if (rs.next()) {
		            resultValue = rs.getObject(1); // get first column value
		        }

		        
		        
		        rs.close();
		        stmt.close();
		        conn.close();
		        if(resultValue != null) {
		        	return resultValue.toString();
		        }
		        else {
		        	return null;
		        }
		       

		    } catch (SQLException e) {
		        e.printStackTrace();
		        
		    }
		    
		}
		return null;
	}
	
	
	public static boolean emptyPendingTable() {
		Connection conn = null;
		PreparedStatement stmt = null;
		boolean status = false;
			
		try {
			conn = DBConnection.getConnection();
			String sql = "TRUNCATE pending_items";
			
			stmt = conn.prepareStatement(sql);


			
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
			String sql = "DELETE FROM pending_items WHERE id = ?";
			
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
	
	public static boolean insertPendingToTransaction(double cash, double change) {
		Connection conn = null;
		PreparedStatement stmt = null;
		boolean status = false;
			
		try {
			conn = DBConnection.getConnection();
			String sql = "INSERT INTO transactions(date, total_amount,cash_ ,change_, transaction_status) \r\n"
					+ "VALUES(NOW(),(SELECT SUM(subtotal) FROM pending_items), ?, ?, 'Complete');";
			
			stmt = conn.prepareStatement(sql);
			stmt.setDouble(1, cash);
			stmt.setDouble(2, change);


			
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
	
	public static boolean insertPendingToTransactionItems() {
		Connection conn = null;
		PreparedStatement stmt = null;
		boolean status = false;
			
		try {
			conn = DBConnection.getConnection();
			String sql = "INSERT INTO transaction_items(transaction_id, product_id, quantity, price)\r\n"
					+ "SELECT (SELECT MAX(transaction_id) FROM transactions), product_id, quantity, price FROM pending_items;";
			
			stmt = conn.prepareStatement(sql);

			
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
