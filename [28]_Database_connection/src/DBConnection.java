
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    // Change these values to your MySQL setup
    private static final String URL = "jdbc:mysql://localhost:3306/product_inventory";
    private static final String USER = "Kaleb"; // user is root in your case
    private static final String PASSWORD = "1234";

    // Method to establish connection
    public static Connection getConnection() {
        Connection conn = null;
        try {
            // Load MySQL JDBC driver (optional in modern Java but safe to include)
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Create connection
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database connected successfully!");

        } 
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        } 
        catch (SQLException e) {
       
            e.printStackTrace();
        }
        return conn;
    }
}
