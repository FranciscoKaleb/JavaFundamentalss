import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 372, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("insert data");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String title = textField.getText();
				String first_name = textField_1.getText();
				String last_name = textField_2.getText();
				int released_year = Integer.parseInt(textField_3.getText());
				int quantity = Integer.parseInt(textField_4.getText());
				int pages = Integer.parseInt(textField_5.getText());
				
				boolean status = Queries.insertBook(title, first_name, last_name, released_year, quantity, pages);
				if(status == true) {
					JOptionPane.showMessageDialog(null, 
                            "INSERT SUCCESS!", 
                            "INSERT SUCCESSFUL", 
                            JOptionPane.PLAIN_MESSAGE);
				}
				else {
					
				}
			}
		});
		btnNewButton.setBounds(180, 284, 116, 37);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(157, 91, 139, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("title");
		lblNewLabel.setBounds(41, 94, 45, 13);
		contentPane.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(157, 120, 139, 19);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(157, 149, 139, 19);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(157, 178, 139, 19);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(157, 207, 139, 19);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(157, 236, 139, 19);
		contentPane.add(textField_5);
		
		JLabel lblAuthorFirstName = new JLabel("author first name");
		lblAuthorFirstName.setBounds(41, 123, 96, 13);
		contentPane.add(lblAuthorFirstName);
		
		JLabel lblAuthorLastName = new JLabel("author last name");
		lblAuthorLastName.setBounds(41, 152, 84, 13);
		contentPane.add(lblAuthorLastName);
		
		JLabel lblStockQuantity = new JLabel("stock quantity");
		lblStockQuantity.setBounds(41, 210, 96, 13);
		contentPane.add(lblStockQuantity);
		
		JLabel lblReleasedYear = new JLabel("released year");
		lblReleasedYear.setBounds(41, 181, 96, 13);
		contentPane.add(lblReleasedYear);
		
		JLabel lblPages = new JLabel("pages");
		lblPages.setBounds(41, 239, 45, 13);
		contentPane.add(lblPages);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				NewWindow n1 = new NewWindow();
				n1.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(40, 29, 85, 21);
		contentPane.add(btnNewButton_1);

	}
}
