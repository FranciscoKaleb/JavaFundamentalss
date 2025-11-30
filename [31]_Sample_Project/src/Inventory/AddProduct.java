package Inventory;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import EntryPoint.EntryPoint;


import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AddProduct extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	public AddProduct() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 386, 433);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(142, 85, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(142, 135, 96, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(142, 233, 96, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(142, 182, 96, 19);
		contentPane.add(textField_3);
		
		
		JLabel lblNewLabel = new JLabel("Product name");
		lblNewLabel.setBounds(52, 91, 45, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(52, 138, 45, 13);
		contentPane.add(lblPrice);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(52, 236, 45, 13);
		contentPane.add(lblQuantity);
		
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setBounds(52, 185, 45, 13);
		contentPane.add(lblCategory);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(233, 321, 85, 21);
		contentPane.add(btnCancel);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBounds(78, 321, 85, 21);
		contentPane.add(btnNewButton);
		
		
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					insertProduct(textField.getText(), Double.parseDouble(textField_1.getText()) ,textField_3.getText(), Integer.parseInt(textField_2.getText()));
				}
			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertProduct(textField.getText(), Double.parseDouble(textField_1.getText()) ,textField_3.getText(), Integer.parseInt(textField_2.getText()));
			}
		});
		
		
		
		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                
            	InventoryWindow.btnAddProduct.setEnabled(true);
            }
        });

	}
	
	public void insertProduct(String name, double price, String category, int quantity) {
		if(price > 0 && quantity > 0) {
			
			boolean results = ProductDAO.insertProduct(name, price, category, quantity);
			
			if(results == true) {
				JOptionPane.showMessageDialog(null, 
                        "INSERT SUCCESS!", 
                        "INSERT SUCCESSFUL", 
                        JOptionPane.PLAIN_MESSAGE);
						InventoryWindow.loadTableData();
						textField.setText("");
						textField_1.setText("");
						textField_2.setText("");
						textField_3.setText("");
						textField.requestFocus();
			}
			else {
				JOptionPane.showMessageDialog(null, 
                        "Insert Failed", 
                        "Failed to insert", 
                        JOptionPane.PLAIN_MESSAGE);
			}
			
		}
		else {
			JOptionPane.showMessageDialog(null, 
                    "price or quantity cant be negative", 
                    "Failed", 
                    JOptionPane.PLAIN_MESSAGE);
		}
	}
}
