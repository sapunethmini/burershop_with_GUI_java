/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.OrderController;
import Model.OrderDetails;
import javax.swing.*;
import java.awt.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Search_order_Details extends JFrame {

    private JLabel lblHome;
    private JLabel lblOrderID;
    private JLabel lblCustomerID;
    private JLabel lblName;
    private JLabel lblQuantity;
    private JLabel lblTotal;
    private JLabel lblStatus;
    private JButton btnExit;
    private JButton btnSearch;
    private JButton btnBackToHome;

    private JTextField txtOrderID;
    private JTextField txtCustomerID;
    private JTextField txtName;
    private JTextField txtQuantity;
    private JTextField txtTotal;
    private JTextField txtStatus;

    public Search_order_Details() {


        lblHome = new JLabel();
        lblHome.setText("Search Order Details");
        lblHome.setFont(new Font("", Font.BOLD, 40));
        lblHome.setForeground(Color.white);
        lblHome.setBounds(0, 0, 800, 70);
        lblHome.setVerticalAlignment(JLabel.CENTER);
        lblHome.setHorizontalAlignment(JLabel.CENTER);
        lblHome.setBackground(new Color(183, 21, 64));
        lblHome.setOpaque(true);


        lblOrderID = new JLabel("Enter Order ID:");
        lblOrderID.setBounds(50, 100, 120, 20);
        txtOrderID = new JTextField();
        txtOrderID.setBounds(180, 100, 120, 20);

        lblCustomerID = new JLabel("Customer ID:");
        lblCustomerID.setBounds(50, 150, 120, 20);
        txtCustomerID = new JTextField();
        txtCustomerID.setBounds(180, 150, 120, 20);

        lblName = new JLabel("Name:");
        lblName.setBounds(50, 200, 120, 20);
        txtName = new JTextField();
        txtName.setBounds(180, 200, 120, 20);

        lblQuantity = new JLabel("Quantity:");
        lblQuantity.setBounds(50, 250, 120, 20);
        txtQuantity = new JTextField();
        txtQuantity.setBounds(180, 250, 120, 20);

        lblTotal = new JLabel("Total:");
        lblTotal.setBounds(50, 300, 120, 20);
        txtTotal = new JTextField();
        txtTotal.setBounds(180, 300, 120, 20);

        lblStatus = new JLabel("Status:");
        lblStatus.setBounds(50, 350, 120, 20);
        txtStatus = new JTextField();
        txtStatus.setBounds(180, 350, 120, 20);

        btnExit = new JButton("EXIT");
        btnExit.setFont(new Font("", Font.PLAIN, 15));
        btnExit.setBounds(450, 400, 100, 30);
        btnExit.setBackground(new Color(183, 21, 64));
        btnExit.setForeground(Color.white);
        btnExit.setFocusable(false);
        btnExit.addActionListener(evt -> {
            System.exit(0);
        });

        btnSearch = new JButton("Search");
        btnSearch.setFont(new Font("", Font.PLAIN, 12));
        btnSearch.setBounds(350, 100, 120, 30);
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
                txtStatus.setText(String.valueOf(order.getOrderStatus()));
            } else {
                JOptionPane.showMessageDialog(this, "Order not found!");
            }
        });
        
        
        btnBackToHome = new JButton("Back to Home");
        btnBackToHome.setBounds(350, 300, 120, 30);
        btnBackToHome.setBackground(new Color(183, 21, 64));
        btnBackToHome.setForeground(Color.white);
        btnBackToHome.addActionListener(evt -> {
             try {
                    HomePage BTM = new HomePage();
                    dispose(); // Dispose of the current frame (HomePage)
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            
        });

        
        setTitle("Search Order Details");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);
        
        add(btnExit);
        add(btnBackToHome);
        add(btnSearch);
        add(lblHome);
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
        add(lblStatus);
        add(txtStatus);
        add(btnSearch);
    }
}
