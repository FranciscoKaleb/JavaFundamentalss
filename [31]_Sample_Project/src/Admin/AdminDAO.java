package Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DB.DBConnection;

public class AdminDAO {

	public static boolean voidTransaction(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		boolean status = false;

		
		try {
			conn = DBConnection.getConnection();
			String sql = "UPDATE transactions SET transaction_status = 'void' WHERE transaction_id = ?";
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);

			
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
