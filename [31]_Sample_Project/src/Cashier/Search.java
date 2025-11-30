package Cashier;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DB.DBConnection;
import EntryPoint.EntryPoint;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Search extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	private CashierWindow cashierWindow;

    public Search(CashierWindow cashierWindow) {
        this.cashierWindow = cashierWindow;
        initComponents(); // ✅ VERY IMPORTANT
        loadTableData();
    }


    private void initComponents() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 527, 464);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(74, 75, 351, 272);
        contentPane.add(scrollPane);
        
        textField = new JTextField();
        textField.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyPressed(KeyEvent e) {
        		
        		searchName();
        		
        	}
        });
        
        textField.setBounds(129, 24, 101, 19);
        contentPane.add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyPressed(KeyEvent e) {
        		
        		
        		
        	}
        	@Override
        	public void keyReleased(KeyEvent e) {
        		searchProductId();
        	}
        });
        textField_1.setColumns(10);
        textField_1.setBounds(324, 24, 101, 19);
        contentPane.add(textField_1);
        
        JLabel lblNewLabel = new JLabel("name");
        lblNewLabel.setBounds(74, 27, 45, 13);
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("barcode");
        lblNewLabel_1.setBounds(269, 27, 45, 13);
        contentPane.add(lblNewLabel_1);
        
        JButton btnNewButton = new JButton("to pending");
        btnNewButton.setBounds(74, 376, 109, 21);
        contentPane.add(btnNewButton);
        
        JLabel lblNewLabel_2 = new JLabel("New label");
        lblNewLabel_2.setBounds(10, 161, 45, 13);
        contentPane.add(lblNewLabel_2);
        
        textField_2 = new JTextField();
        textField_2.setText("1");
        textField_2.setBounds(432, 158, 71, 19);
        contentPane.add(textField_2);
        textField_2.setColumns(10);
        
        JLabel lblNewLabel_2_1 = new JLabel("quantity");
        lblNewLabel_2_1.setBounds(435, 135, 45, 13);
        contentPane.add(lblNewLabel_2_1);
        
        
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
  		
        		CashierDAO.insertToPending(Integer.parseInt(lblNewLabel_2.getText()),Integer.parseInt(textField_2.getText()));
        		cashierWindow.loadTableData();
                cashierWindow.lblNewLabel_1_1.setText(CashierDAO.getPendingTotal());
                
                // optional: close Search window after adding
//                dispose();
        		
        	}
        });
        
        
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                if (row != -1) {
                    Object value = table.getValueAt(row, 0);
                    lblNewLabel_2.setText(value.toString());
                }
            }
        });
        
        
        

	}
	
	public void searchName() {
        Connection conn = DBConnection.getConnection();
        if (conn != null) {
            try {
            	String query = "SELECT * FROM products WHERE product_name LIKE ?";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, "%" + textField.getText() + "%");  // Proper wildcard syntax
                
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
	
	public void searchProductId() {
		String input = textField_1.getText().trim();

	    // ✅ If empty, clear table or just return (so it won’t throw)
	    if (input.isEmpty()) {
	        return;
	    }

	    // ✅ Only continue if the input is a valid number
	    int id;
	    try {
	        id = Integer.parseInt(input);
	    } catch (NumberFormatException e) {
	        return; // ignore invalid input like letters
	    }
        Connection conn = DBConnection.getConnection();
        if (conn != null) {
            try {
            	String query = "SELECT * FROM products WHERE product_id = ?";
            	PreparedStatement stmt = conn.prepareStatement(query);
            	stmt.setInt(1,Integer.parseInt(textField_1.getText()) );
                
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
	
	 public void loadTableData() {
	        Connection conn = DBConnection.getConnection();
	        if (conn != null) {
	            try {
	                String query = "SELECT * FROM products";
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
