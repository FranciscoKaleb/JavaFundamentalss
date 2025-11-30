package EntryPoint;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Admin.AdminWindow;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Inventory.InventoryWindow;
import Cashier.CashierWindow;

public class EntryPoint extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EntryPoint frame = new EntryPoint();
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
	public EntryPoint() {
		setTitle("Entry Point");
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 372);
		setLocationRelativeTo(null); // center the Jframe on the screen
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		// inventory button
		InventoryWindow InventoryFrame = new InventoryWindow();
		JButton btnNewButton = new JButton("Inventory");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			    InventoryFrame.setVisible(true);
			    InventoryFrame.loadTableData();
			    dispose();
			    
			}
		});
		btnNewButton.setBounds(40, 135, 111, 51);
		contentPane.add(btnNewButton);
		
		
		
		// cashier button
		CashierWindow cashierFrame = new CashierWindow();
		JButton btnCashier = new JButton("Cashier");
		btnCashier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cashierFrame.setVisible(true);
				dispose();
				
			}
		});
		btnCashier.setBounds(206, 135, 111, 51);
		contentPane.add(btnCashier);
		
		
		
		
		// admin button
		AdminWindow adminFrame = new AdminWindow();
		JButton btnAdmin = new JButton("Admin");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				adminFrame.setVisible(true);
				dispose();
				
			}
		});
		btnAdmin.setBounds(378, 135, 111, 51);
		contentPane.add(btnAdmin);

	}
}
