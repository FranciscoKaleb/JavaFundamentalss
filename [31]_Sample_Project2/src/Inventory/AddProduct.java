package Inventory;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddProduct extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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
		textField_2.setBounds(142, 186, 96, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Product name");
		lblNewLabel.setBounds(52, 91, 45, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(52, 138, 45, 13);
		contentPane.add(lblPrice);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(52, 189, 45, 13);
		contentPane.add(lblQuantity);
		
		
		
		
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String name = textField.getText();
				double price = Double.parseDouble(textField_1.getText());
				int quantity = Integer.parseInt(textField_2.getText());
				
				
				if(price > 0 && quantity > 0) {
					Products p = new Products(name, price, quantity);
					boolean results = ProductDAO.insertProduct(p);
					
					if(results == true) {
						JOptionPane.showMessageDialog(null, 
	                            "INSERT SUCCESS!", 
	                            "INSERT SUCCESSFUL", 
	                            JOptionPane.PLAIN_MESSAGE);
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
		});
		btnNewButton.setBounds(78, 321, 85, 21);
		contentPane.add(btnNewButton);
		
		
		
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(233, 321, 85, 21);
		contentPane.add(btnCancel);

	}
}
