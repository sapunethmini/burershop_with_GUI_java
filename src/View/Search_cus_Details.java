/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.OrderController;
import Model.OrderDetails;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

public class Search_cus_Details extends JFrame {
    private JLabel nameLabel, idLabel, mainLabel, mainLabel_2;
    private JTextField nameField, idField;
    private JButton searchButton, backButton;
    private JPanel panel;
    private JTable dataTable; // Declare JTable variable
    private DefaultTableModel tableModel;

    public Search_cus_Details() {
        setTitle("Search Customer Details");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);

        mainLabel = new JLabel("Search Customer");
        mainLabel.setBounds(0, 0, 800, 40);
        mainLabel.setFont(new Font("", Font.PLAIN, 30));
        mainLabel.setForeground(Color.WHITE);
        mainLabel.setVerticalAlignment(JLabel.CENTER);
        mainLabel.setHorizontalAlignment(JLabel.CENTER);
        mainLabel.setBackground(new Color(183, 21, 64));
        mainLabel.setOpaque(true);

        mainLabel_2 = new JLabel("Order Details");
        mainLabel_2.setBounds(0, 160, 800, 20);
        mainLabel_2.setFont(new Font("", Font.PLAIN, 15));
        mainLabel_2.setForeground(Color.WHITE);
        mainLabel_2.setVerticalAlignment(JLabel.CENTER);
        mainLabel_2.setHorizontalAlignment(JLabel.CENTER);
        mainLabel_2.setBackground(new Color(183, 21, 64));
        mainLabel_2.setOpaque(true);

        idLabel = new JLabel("Customer ID:");
        idLabel.setBounds(50, 50, 100, 30);

        idField = new JTextField();
        idField.setBounds(150, 50, 200, 30);

        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 100, 100, 30);

        nameField = new JTextField();
        nameField.setBounds(150, 100, 200, 30);

        searchButton = new JButton("Search");
        searchButton.setBounds(455, 127, 100, 30);
        searchButton.addActionListener(evt -> {
    
        String customerId = idField.getText(); // Get the customer ID from the text field

        OrderDetails[] customerOrders = OrderController.getCustomerOrders(customerId);

        tableModel.setRowCount(0);

        for (OrderDetails order : customerOrders) {
            Object[] rowData = {order.getOrderId(), order.getOrderQTY(), order.getOrderValue()};
            tableModel.addRow(rowData);
        }
    
});

        backButton = new JButton("Back");
        backButton.setBounds(455, 315, 100, 30);
        backButton.addActionListener(evt -> {
            new Choice_search();
        });

        // Table initialization
        String[] columnNames = {"Order ID", "Order QYT", "Total"};
        Object[][] data = {};
        tableModel = new DefaultTableModel(data, columnNames);
        dataTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(dataTable);
        scrollPane.setBounds(100, 190, 600, 100);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        panel.add(mainLabel);
        panel.add(mainLabel_2);
        panel.add(scrollPane);
        panel.add(idLabel);
        panel.add(idField);
        panel.add(searchButton);
        panel.add(backButton);

        getContentPane().add(panel);
    }

}
