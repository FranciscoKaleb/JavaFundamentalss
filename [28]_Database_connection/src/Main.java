import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
//import com.sun.tools.javac.util.List;

public class Main {

	public static void main(String[] args) {
		
		insertProduct("Keyboard", "instrument", 700, 15);
		selectSample();
	}
	
	public static void selectSample() {
		
		Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Get connection
            conn = DBConnection.getConnection();

            // Query
            String sql = "SELECT * FROM products";
            stmt = conn.prepareStatement(sql); // for security, to prevent SQL injection
            rs = stmt.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();
            int columns = rsmd.getColumnCount();

            // Store rows in memory (so we can compute widths first)
            ArrayList<Object[]> rows = new ArrayList<>();
            int[] colWidths = new int[columns];

            // Initialize widths with column name lengths
            for (int i = 1; i <= columns; i++) {
                colWidths[i - 1] = rsmd.getColumnName(i).length();
            }

            // Read rows and find max width per column
            while (rs.next()) {
                Object[] row = new Object[columns];
                for (int i = 1; i <= columns; i++) {
                    Object value = rs.getObject(i);
                    String str = (value == null) ? "NULL" : value.toString();
                    row[i - 1] = str;
                    if (str.length() > colWidths[i - 1]) {
                        colWidths[i - 1] = str.length();
                    }
                }
                rows.add(row);
            }

            // Print header
            for (int i = 1; i <= columns; i++) {
                System.out.printf("%-" + (colWidths[i - 1] + 2) + "s", rsmd.getColumnName(i));
            }
            System.out.println();

            // Print rows
            for (Object[] row : rows) {
                for (int i = 0; i < columns; i++) {
                    System.out.printf("%-" + (colWidths[i] + 2) + "s", row[i]);
                }
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (SQLException ignored) {}
            try { if (stmt != null) stmt.close(); } catch (SQLException ignored) {}
            try { if (conn != null) conn.close(); } catch (SQLException ignored) {}
        }
	    
	}
	
	public static void insertProduct(String product_name, String category, double price, int stock) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DBConnection.getConnection();
			String sql = "INSERT INTO products (product_name, category, price, stock ) "
			 + "VALUES ( ?, ?, ?, ?)";
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, product_name);
			stmt.setString(2, category);
			stmt.setDouble(3, price);
			stmt.setInt(4, stock);
	
			
			int rowsInserted = stmt.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("✅ Product inserted successfully!");
			}
		
		} 
		catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			try { if (stmt != null) stmt.close(); } catch (SQLException ignored) {}
			try { if (conn != null) conn.close(); } catch (SQLException ignored) {}
		}
	}
	
	public static void updateBook(int bookId, String title, String authorFname, String authorLname, int releasedYear, int stockQuantity, int pages) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DBConnection.getConnection();
			String sql = "UPDATE books SET title = ?, author_fname = ?, author_lname = ?, " +
			   "released_year = ?, stock_quantity = ?, pages = ? WHERE book_id = ?";
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, title);
			stmt.setString(2, authorFname);
			stmt.setString(3, authorLname);
			stmt.setInt(4, releasedYear);
			stmt.setInt(5, stockQuantity);
			stmt.setInt(6, pages);
			stmt.setInt(7, bookId);
			
			int rowsUpdated = stmt.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("✅ Book updated successfully!");
			} 
			else {
				System.out.println("⚠️ No book found with ID: " + bookId);
			}
		
		} 
		catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			try { if (stmt != null) stmt.close(); } catch (SQLException ignored) {}
			try { if (conn != null) conn.close(); } catch (SQLException ignored) {}
		}
	
	}
	
    public static void deleteBook(int bookId) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DBConnection.getConnection();
            String sql = "DELETE FROM books WHERE book_id = ?";

            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, bookId);

            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("✅ Book deleted successfully!");
            } else {
                System.out.println("⚠️ No book found with ID: " + bookId);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try { if (stmt != null) stmt.close(); } catch (SQLException ignored) {}
            try { if (conn != null) conn.close(); } catch (SQLException ignored) {}
        }
    }
	


}
