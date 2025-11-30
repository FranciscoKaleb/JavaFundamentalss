import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("Books Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new FlowLayout());

        // Labels + text fields
        JLabel lblId = new JLabel("Book ID:");
        JTextField txtId = new JTextField(10);

        JLabel lblTitle = new JLabel("Title:");
        JTextField txtTitle = new JTextField(20);

        JLabel lblFName = new JLabel("Author First Name:");
        JTextField txtFName = new JTextField(15);

        JLabel lblLName = new JLabel("Author Last Name:");
        JTextField txtLName = new JTextField(15);

        JLabel lblYear = new JLabel("Released Year:");
        JTextField txtYear = new JTextField(6);

        JLabel lblStock = new JLabel("Stock:");
        JTextField txtStock = new JTextField(6);

        JLabel lblPages = new JLabel("Pages:");
        JTextField txtPages = new JTextField(6);

        // Buttons
        JButton btnInsert = new JButton("Insert");
        JButton btnUpdate = new JButton("Update");
        JButton btnDelete = new JButton("Delete");

        // Add components
        frame.add(lblId); frame.add(txtId);
        frame.add(lblTitle); frame.add(txtTitle);
        frame.add(lblFName); frame.add(txtFName);
        frame.add(lblLName); frame.add(txtLName);
        frame.add(lblYear); frame.add(txtYear);
        frame.add(lblStock); frame.add(txtStock);
        frame.add(lblPages); frame.add(txtPages);

        frame.add(btnInsert);
        frame.add(btnUpdate);
        frame.add(btnDelete);

        // Actions
        btnInsert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String title = txtTitle.getText();
                String fname = txtFName.getText();
                String lname = txtLName.getText();
                int year = Integer.parseInt(txtYear.getText());
                int stock = Integer.parseInt(txtStock.getText());
                int pages = Integer.parseInt(txtPages.getText());

                Main.insertBook(title, fname, lname, year, stock, pages);
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(txtId.getText());
                String title = txtTitle.getText();
                String fname = txtFName.getText();
                String lname = txtLName.getText();
                int year = Integer.parseInt(txtYear.getText());
                int stock = Integer.parseInt(txtStock.getText());
                int pages = Integer.parseInt(txtPages.getText());

                Main.updateBook(id, title, fname, lname, year, stock, pages);
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(txtId.getText());
                Main.deleteBook(id);
            }
        });

        // Show frame
        frame.setVisible(true);
    }
}
