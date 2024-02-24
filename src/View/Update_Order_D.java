/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.OrderController;
import Model.OrderDetails;

import javax.swing.*;
import java.awt.*;

public class Update_Order_D extends JFrame {

    private JLabel lblHome;
    private JLabel lblOrderStatus;
    private JLabel lblOrderID;
    private JLabel lblCustomerID;
    private JLabel lblName;
    private JLabel lblQuantity;
    private JLabel lblTotal;
    private JTextField TEXTOrderStatus_Ccancel;

    private JComboBox<String> cmbOrderStatus;
    private JTextField txtOrderID;
    private JTextField txtCustomerID;
    private JTextField txtName;
    private JTextField txtQuantity;
    private JTextField txtTotal;

    private JButton btnUpdate;
    private JButton btnBack;
    private JButton btnSearch;

    public Update_Order_D() {
        setTitle("Update Order");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(null);

        lblHome = new JLabel("Update Order");
        lblHome.setFont(new Font("", Font.BOLD, 40));
        lblHome.setForeground(Color.white);
        lblHome.setBounds(0, 0, 800, 70);
        lblHome.setVerticalAlignment(JLabel.CENTER);
        lblHome.setHorizontalAlignment(JLabel.CENTER);
        lblHome.setBackground(new Color(183, 21, 64));
        lblHome.setOpaque(true);

        lblOrderStatus = new JLabel("Order Status:");
        lblOrderStatus.setBounds(50, 270, 80, 20);
        cmbOrderStatus = new JComboBox<>(new String[]{"Preparing", "Cancelled", "Delivered"});
        cmbOrderStatus.setBounds(150, 270, 100, 20);
        
        TEXTOrderStatus_Ccancel = new JTextField();
        TEXTOrderStatus_Ccancel.setBounds(20, 150, 70, 20);
        TEXTOrderStatus_Ccancel.setForeground(Color.RED);

        lblOrderID = new JLabel("Order ID:");
        lblOrderID.setBounds(50, 130, 80, 20);
        txtOrderID = new JTextField();
        txtOrderID.setBounds(150, 130, 100, 20);

        lblCustomerID = new JLabel("Customer ID:");
        lblCustomerID.setBounds(50, 190, 80, 20);
        txtCustomerID = new JTextField();
        txtCustomerID.setEditable(false);
        txtCustomerID.setBounds(150, 190, 100, 20);

        lblName = new JLabel("Name:");
        lblName.setBounds(50, 230, 80, 20);
        txtName = new JTextField();
        txtName.setEditable(false);
        txtName.setBounds(150, 230, 100, 20);

        lblQuantity = new JLabel("Quantity:");
        lblQuantity.setBounds(400, 190, 80, 20);
        txtQuantity = new JTextField();
        txtQuantity.setBounds(500, 190, 100, 20);

        lblTotal = new JLabel("Total:");
        lblTotal.setBounds(400, 230, 80, 20);
        txtTotal = new JTextField();
        txtTotal.setEditable(false);
        txtTotal.setBounds(500, 230, 100, 20);

        btnUpdate = new JButton("Update");
        btnUpdate.setBounds(250, 350, 100, 30);
        btnUpdate.setBackground(new Color(183, 21, 64));
        btnUpdate.setForeground(Color.white);
        btnUpdate.addActionListener(evt -> {
            String orderId = txtOrderID.getText();
            OrderDetails order = OrderController.getOrderDetails(orderId);
            if (order != null) {
                String status = order.getOrderStatus();
                if (!status.equalsIgnoreCase("Cancelled")) {
                    cmbOrderStatus.setEnabled(true);
                    status = cmbOrderStatus.getSelectedItem().toString();
                    String customerId = txtCustomerID.getText();
                    String customerName = txtName.getText();
                    String quantityText = txtQuantity.getText();
                    try {
                        int quantity = Integer.parseInt(quantityText);
                        double totalPrice = quantity * 500.0;

                        OrderDetails updatedOrder = new OrderDetails(orderId, customerId, customerName, status, quantity, totalPrice);
                        OrderController.updateOrder(updatedOrder);

                        JOptionPane.showMessageDialog(this, "Order updated successfully!");
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(this, "Please enter a valid quantity.");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "This order has been canceled. You cannot update it.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Order not found!");
            }
            
            new HomePage();
        });

        btnBack = new JButton("Back to Home");
        btnBack.setBounds(380, 350, 150, 30);
        btnBack.setBackground(new Color(183, 21, 64));
        btnBack.setForeground(Color.white);
        btnBack.addActionListener(evt -> {
          new  HomePage();
            // Add code to go back to the main menu
        });

        btnSearch = new JButton("Search");
        btnSearch.setFont(new Font("", Font.PLAIN, 12));
        btnSearch.setBounds(400, 130, 100, 30);
        btnSearch.setBackground(new Color(183, 21, 64));
        btnSearch.setForeground(Color.white);
        btnSearch.setFocusable(false);
        btnSearch.addActionListener(evt -> {
            String orderId = txtOrderID.getText();
            OrderDetails order = OrderController.getOrderDetails(orderId);
            if (order != null) {
                txtCustomerID.setText(order.getCustomerId());
                txtName.setText(order.getCustomerName());
                txtQuantity.setText(String.valueOf(order.getOrderQTY()));
                txtTotal.setText(String.valueOf(order.getOrderValue()));
                String status = order.getOrderStatus();
                cmbOrderStatus.setSelectedItem(status);
                cmbOrderStatus.setEnabled(!status.equalsIgnoreCase("Cancelled"));
                String warning="Already canclled ,cant change now !";
                TEXTOrderStatus_Ccancel.setText(warning);
                txtQuantity.setEditable(!status.equalsIgnoreCase("Cancelled"));
            } else {
                JOptionPane.showMessageDialog(this, "Order not found!");
            }
        });

        add(lblHome);
        add(lblOrderStatus);
        add(cmbOrderStatus);
        add(lblOrderID);
        add(txtOrderID);
        add(lblCustomerID);
        add(txtCustomerID);
        add(lblName);
        add(txtName);
        add(lblQuantity);
        add(txtQuantity);
        add(lblTotal);
        add(txtTotal);
        add(btnUpdate);
        add(btnBack);
        add(btnSearch);

        setVisible(true);
    }
}