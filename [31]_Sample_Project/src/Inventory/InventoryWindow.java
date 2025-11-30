package Inventory;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.*;
import DB.DBConnection;
import EntryPoint.EntryPoint;

public class InventoryWindow extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    public static JTable table;
    private JButton btnLoadTable;
    public static JButton btnAddProduct;
    private JButton btnDelete;
    private JLabel lblSelectedId;

    public InventoryWindow() {
        setTitle("Inventory System");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 802, 500);
        setLocationRelativeTo(null);

        // ======================
        // PANEL SETUP
        // ======================
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        // ======================
        // COMPONENT CREATION
        // ======================

        // Table
        table = new JTable() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // all cells are non-editable
            }
        };
        table.setFocusable(false);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(265, 27, 460, 302);
        contentPane.add(scrollPane);

        // Buttons
        btnLoadTable = new JButton("Load Table");
        btnLoadTable.setBounds(264, 378, 94, 27);
        contentPane.add(btnLoadTable);

        btnAddProduct = new JButton("Add Product");
        btnAddProduct.setBounds(385, 378, 94, 27);
        contentPane.add(btnAddProduct);

        btnDelete = new JButton("Delete");
        btnDelete.setBounds(507, 378, 94, 27);
        contentPane.add(btnDelete);

        // Labels
        lblSelectedId = new JLabel("New label");
        lblSelectedId.setBounds(32, 63, 100, 13);
        contentPane.add(lblSelectedId);

        // ======================
        // EVENT LISTENERS
        // ======================

        // Load table button
        btnLoadTable.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadTableData();
            }
        });

        // Add product button
        btnAddProduct.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddProduct addProductWindow = new AddProduct();
                addProductWindow.setVisible(true);
                btnAddProduct.setEnabled(false);
            }
        });

        // Delete button
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(
                    null,
                    "Are you sure you want to delete this item?",
                    "Confirm Delete",
                    JOptionPane.YES_NO_OPTION
                );

                if (confirm == JOptionPane.YES_OPTION) {
                    ProductDAO.delete(Integer.parseInt(lblSelectedId.getText()));
                    JOptionPane.showMessageDialog(
                        null,
                        "Item deleted!",
                        "Item deleted!",
                        JOptionPane.PLAIN_MESSAGE
                    );
                }
            }
        });

        // Table click
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                if (row != -1) {
                    Object value = table.getValueAt(row, 0);
                    lblSelectedId.setText(value.toString());
                }
            }
        });

        // Window close
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                EntryPoint entryPoint = new EntryPoint();
                entryPoint.setVisible(true);
            }
        });
    }

    // ======================
    // DATABASE TABLE LOADER
    // ======================
    public static void loadTableData() {
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
