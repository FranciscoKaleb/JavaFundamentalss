package Inventory;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import DB.DBConnection;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import EntryPoint.EntryPoint;

public class InventoryWindow extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private JButton btnNewButton;
    private JButton btnNewButton_1;



    public InventoryWindow() {
        setTitle("Inventory System");
//        EntryPoint e = new EntryPoint();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 802, 500);
        setLocationRelativeTo(null);

        // ✅ Initialize contentPane first
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // ✅ Then create your components
        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(265, 27, 460, 302);
        contentPane.add(scrollPane);
        
        
        btnNewButton = new JButton("Load table");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		loadTableData();
        		
        	}
        });
        btnNewButton.setBounds(264, 378, 94, 27);
        contentPane.add(btnNewButton);
        
        btnNewButton_1 = new JButton("Add Product");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		AddProduct a = new AddProduct();
        		a.setVisible(true);
        		
        		
        	}
        });
        btnNewButton_1.setBounds(385, 378, 94, 27);
        contentPane.add(btnNewButton_1);
        
        
        
        
       
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                
                EntryPoint inv = new EntryPoint();
                inv.setVisible(true);
            }
        });
    }
    
    public void loadTableData() {
        Connection conn = DBConnection.getConnection();
        if (conn != null) {
            try {
                String query = "SELECT * FROM products"; // example
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery();

                ResultSetMetaData rsmd = rs.getMetaData();
                int columns = rsmd.getColumnCount();

                DefaultTableModel model = new DefaultTableModel();

                // Add column names
                for (int i = 1; i <= columns; i++) {
                    model.addColumn(rsmd.getColumnName(i));
                }

                // Add rows
                while (rs.next()) {
                    Object[] row = new Object[columns];
                    for (int i = 1; i <= columns; i++) {
                        row[i - 1] = rs.getObject(i);
                    }
                    model.addRow(row);
                }

                table.setModel(model);

                stmt.close();
                conn.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
