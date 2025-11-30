package Cashier;


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

import DB.DBConnection;
import EntryPoint.EntryPoint;
import Inventory.ProductDAO;

import java.awt.Component;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CashierWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnNewButton;
	private JTextField textField_1;
	private JLabel lblNewLabel_1_3;
	private JTextField textField_2;
	private JTextField textField;
	public JLabel lblNewLabel_1_1;
	
	
	public CashierWindow() {
		initComponents();
	}
	
	
	private void initComponents() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 804, 503);
		setLocationRelativeTo(null);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(32, 48, 280, 302);
        contentPane.add(scrollPane);
        
        btnNewButton = new JButton("remove");
        btnNewButton.setBounds(32, 384, 105, 21);
        contentPane.add(btnNewButton);
        
        textField = new JTextField();
        textField.setBounds(118, 19, 96, 19);
        contentPane.add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.setText("0");
        textField_1.setBounds(639, 101, 96, 19);
        contentPane.add(textField_1);
        textField_1.setColumns(10);
        
        JLabel lblNewLabel = new JLabel("Cash");
        lblNewLabel.setBounds(574, 104, 45, 13);
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("total");
        lblNewLabel_1.setBounds(574, 50, 45, 13);
        contentPane.add(lblNewLabel_1);
        
        lblNewLabel_1_1 = new JLabel("0");
        lblNewLabel_1_1.setBounds(644, 50, 45, 13);
        contentPane.add(lblNewLabel_1_1);
        
        JLabel lblNewLabel_1_2 = new JLabel("change");
        lblNewLabel_1_2.setBounds(574, 169, 45, 13);
        contentPane.add(lblNewLabel_1_2);
        
        lblNewLabel_1_3 = new JLabel("0");
        lblNewLabel_1_3.setBounds(644, 169, 45, 13);
        contentPane.add(lblNewLabel_1_3);
        
        JButton btnProceed = new JButton("Finish Transaction");
        btnProceed.setBounds(588, 415, 132, 21);
        contentPane.add(btnProceed);
        
        JButton btnCancel = new JButton("cancel");
        btnCancel.setBounds(493, 415, 85, 21);
        contentPane.add(btnCancel);
        
        textField_2 = new JTextField();
        textField_2.setText("1");
        textField_2.setColumns(10);
        textField_2.setBounds(377, 101, 54, 19);
        contentPane.add(textField_2);
        
        JLabel lblNewLabel_1_3_1 = new JLabel("quantity");
        lblNewLabel_1_3_1.setBounds(322, 104, 45, 13);
        contentPane.add(lblNewLabel_1_3_1);
        
        JLabel lblNewLabel_1_4 = new JLabel("barcode num");
        lblNewLabel_1_4.setBounds(32, 22, 76, 13);
        contentPane.add(lblNewLabel_1_4);
        
        JButton btnRemoveAll = new JButton("remove all");
        btnRemoveAll.setBounds(32, 415, 105, 21);
        contentPane.add(btnRemoveAll);
        
        JButton btnSearch = new JButton("search");
        btnSearch.setBounds(346, 18, 85, 21);
        contentPane.add(btnSearch);
        
        JLabel lblNewLabel_2 = new JLabel("-1");
        lblNewLabel_2.setBounds(169, 388, 45, 13);
        contentPane.add(lblNewLabel_2);
        
      
        btnSearch.addActionListener(new ActionListener() {
        	

			public void actionPerformed(ActionEvent e) {
				Search s = new Search(CashierWindow.this); // ✅ pass current instance
		        s.setVisible(true);
        	}
        });
        
        textField.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyPressed(KeyEvent e) {
        		if(e.getKeyCode() == KeyEvent.VK_ENTER) { // enter keycode is 13
        			if(textField.getText().length() != 0) {
        				CashierDAO.insertToPending(Integer.parseInt(textField.getText()),Integer.parseInt(textField_2.getText()));
            			loadTableData();
            			lblNewLabel_1_1.setText(CashierDAO.getPendingTotal());
            			textField.setText("");
            			textField_2.setText("1");
            			table.scrollRectToVisible(table.getCellRect(table.getRowCount() - 1, 0, true));
        			}
        			else {
        				
        			}
        			
        			
        		}
        	}
        });
        
        btnRemoveAll.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(
                    null,
                    "Are you sure you want to cancel this transaction?",
                    "Confirm",
                    JOptionPane.YES_NO_OPTION
                );

                if (confirm == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(
                        null,
                        "transaction cancelled",
                        "transaction cancelled",
                        JOptionPane.PLAIN_MESSAGE
                        
                    );
                    
                    CashierDAO.emptyPendingTable();
            		loadTableData();
            		lblNewLabel_1_1.setText("0");
            		textField_1.setText("0");
            		lblNewLabel_1_3.setText("0");
            		lblNewLabel_2.setText("-1");
                    
                }
            }
        	
        });
        
        
        textField_1.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyReleased(KeyEvent e) {
        		if(textField_1.getText().length() != 0) {
        			double a = (Double.parseDouble(textField_1.getText()) - Double.parseDouble(lblNewLabel_1_1.getText()));
            		lblNewLabel_1_3.setText(Double.toString(a));
        		}
        		else {
        			
        		}
        		
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
        

        btnNewButton.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent e) {
        		if(lblNewLabel_2.getText() == "-1") {
        			 JOptionPane.showMessageDialog(
                             null,
                             "nothing to delete",
                             "nothing to delete",
                             JOptionPane.PLAIN_MESSAGE
                             
                         );
        		}
        		else {
        			int confirm = JOptionPane.showConfirmDialog(
                            null,
                            "Are you sure you want to delete this item?",
                            "Confirm Delete",
                            JOptionPane.YES_NO_OPTION
                        );

                    if (confirm == JOptionPane.YES_OPTION) {
                        CashierDAO.delete(Integer.parseInt(lblNewLabel_2.getText()));
                        JOptionPane.showMessageDialog(
                            null,
                            "Item deleted!",
                            "Item deleted!",
                            JOptionPane.PLAIN_MESSAGE
                            
                        );
                        lblNewLabel_2.setText("-1");
                        
                        
                        if(CashierDAO.countPending() == null) {  
                        	lblNewLabel_1_1.setText("0");
                			
                		}
                		else { // if pending is not empty, compute total
                			lblNewLabel_1_1.setText(CashierDAO.getPendingTotal());
                			double a = (Double.parseDouble(textField_1.getText()) - Double.parseDouble(lblNewLabel_1_1.getText()));
                    		lblNewLabel_1_3.setText(Double.toString(a));
                		}
                        
                        loadTableData();
                    }
        		}
                
            }
        });
        
        btnProceed.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent e) {
        		if(Double.parseDouble(lblNewLabel_1_1.getText()) == 0) {
        			JOptionPane.showMessageDialog(
                            null,
                            "cannot proceed, no items",
                            "cannot proceed, no items",
                            JOptionPane.PLAIN_MESSAGE
                            
                        );
        		}
        		
        		else {
        			if(Double.parseDouble(textField_1.getText()) > Double.parseDouble(lblNewLabel_1_1.getText()) ) {
            			int confirm = JOptionPane.showConfirmDialog(
                                null,
                                "Are you sure you want to proceed?",
                                "Confirm Proceed",
                                JOptionPane.YES_NO_OPTION
                        );

                        if (confirm == JOptionPane.YES_OPTION) {
                            JOptionPane.showMessageDialog(
                                null,
                                "Transaction finished",
                                "Transaction finished",
                                JOptionPane.PLAIN_MESSAGE
                                
                            );
                            
                            double cash = Double.parseDouble(textField_1.getText());
                            double change = Double.parseDouble(lblNewLabel_1_3.getText());
                            
                            CashierDAO.insertPendingToTransaction(cash, change);
                    		CashierDAO.insertPendingToTransactionItems();
                    		CashierDAO.emptyPendingTable();
                    		loadTableData();
                    		
                    		lblNewLabel_1_1.setText("0");
                    		textField_1.setText("0");
                    		lblNewLabel_1_3.setText("0");
                    		lblNewLabel_2.setText("-1");
                    		

                        }
                	}
            		
            		else {
            			JOptionPane.showMessageDialog(
                                null,
                                "Cash insufficient",
                                "Cash insufficient",
                                JOptionPane.PLAIN_MESSAGE
                                
                            );
            		}
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
                String query = "SELECT pending_items.id, products.product_name, pending_items.quantity, pending_items.price, pending_items.subtotal \r\n"
                		+ "FROM products JOIN pending_items ON products.product_id = pending_items.product_id "
                		+ "ORDER BY pending_items.id ASC"; // example
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
