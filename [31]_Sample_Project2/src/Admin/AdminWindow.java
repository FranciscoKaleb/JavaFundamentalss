package Admin;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import EntryPoint.EntryPoint;

public class AdminWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	public AdminWindow() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 802, 508);
		setLocationRelativeTo(null);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                
                EntryPoint inv = new EntryPoint();
                inv.setVisible(true);
            }
        });

	}

}
