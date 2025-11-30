package Admin;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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

import Cashier.CashierDAO;
import DB.DBConnection;
import EntryPoint.EntryPoint;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	

	public AdminWindow() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 802, 508);
		setLocationRelativeTo(null);
		
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(119, 46, 436, 310);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(39, 90, 45, 13);
		contentPane.add(lblNewLabel);
		
		btnNewButton = new JButton("void");
		btnNewButton.setBounds(119, 394, 85, 21);
		contentPane.add(btnNewButton);
		
		loadTableData();
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(
	                    null,
	                    "Are you sure you want to void this transaction?",
	                    "Confirm",
	                    JOptionPane.YES_NO_OPTION
	                );

                if (confirm == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(
                        null,
                        "transaction voided",
                        "transaction voided",
                        JOptionPane.PLAIN_MESSAGE
                        
                    );
                    
                    AdminDAO.voidTransaction(Integer.parseInt(lblNewLabel.getText()));
            		loadTableData();
            		
                    
                }
			}
		});
		
		
		table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                if (row != -1) {
                    Object value = table.getValueAt(row, 0);
                    lblNewLabel.setText(value.toString());
                }
            }
        });
		
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
	                String query = "SELECT * FROM transactions;";
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
