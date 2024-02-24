/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;
import Controller.OrderController;
import Model.OrderDetails;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;



public class Place_Order extends JFrame {
      
    public int quantity;
    private JLabel lblHeader;
    private JLabel lblOrderID;
    private JLabel lblCustomerID;
    private JLabel lblName;
    private JLabel lblQuantity;
    private JLabel lblNetTotal;
    private JLabel lblHome;

    private JTextField txtName;
    private JTextField txtQuantity;
    private JTextField txtOrderid;
    private JTextField textCusid;
    private JTextField textNetTotal;

    private JButton btnPlaceOrder;
    private JButton btnBackToHome;
    private JButton btnCancel;
//
//    private ViewShop view = new ViewShop();
//    private int quantity;

    public Place_Order() {
        
        setTitle("Place Order");
        OrderDetails order=new OrderDetails();
        OrderController control=new OrderController();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);
        
        lblHome = new JLabel();
        lblHome.setText("Place Order");
        lblHome.setFont(new Font("", Font.BOLD, 40));
        lblHome.setForeground(Color.white);
        lblHome.setBounds(0, 0, 800, 70);
        lblHome.setVerticalAlignment(JLabel.CENTER);
        lblHome.setHorizontalAlignment(JLabel.CENTER);
        lblHome.setBackground(new Color(183, 21, 64));
        lblHome.setOpaque(true);


        lblOrderID = new JLabel("Order ID:");
        lblOrderID.setBounds(50, 120, 80, 40);
        lblOrderID.setFont(new Font("", Font.PLAIN, 15));
        
        txtOrderid = new JTextField(OrderController.generateOrderId());
        txtOrderid.setEditable(false);
        txtOrderid.setBounds(150, 130, 100,25);
       

        lblCustomerID = new JLabel("Customer ID:");
        lblCustomerID.setFont(new Font("", Font.PLAIN, 15));
        lblCustomerID.setBounds(50, 190, 180, 20);
        textCusid = new JTextField(OrderController.generateCustomerId());
        textCusid.setEditable(false);
        textCusid.setBounds(150, 190, 100, 25);
        lblName = new JLabel("Name:");
        lblName.setFont(new Font("", Font.PLAIN, 15));
        lblName.setBounds(50, 250, 80, 20);
        txtName = new JTextField(); 
        txtName.setText(order.getCustomerName());
        txtName.setBounds(150, 250, 100, 25);
        

        lblQuantity = new JLabel("Quantity:");
        lblQuantity.setFont(new Font("", Font.PLAIN, 15));
        lblQuantity.setBounds(50, 310, 100, 20);	 
        txtQuantity = new JTextField(String.valueOf(order.getOrderQTY()));
        double total_2=order.getOrderQTY();
        txtQuantity.setBounds(150, 310, 100, 25);

        lblNetTotal = new JLabel("Net Total:");
        lblNetTotal.setBounds(50, 450, 80, 20);
        lblNetTotal.setFont(new Font("", Font.PLAIN, 18));

        textNetTotal = new JTextField();
        textNetTotal.setBounds(150, 450, 100, 25);
        
         
        btnPlaceOrder = new JButton("Place Order");
        btnPlaceOrder.setBackground(new Color(183, 21, 64));
        btnPlaceOrder.setForeground(Color.WHITE);
        btnPlaceOrder.setBounds(240, 380, 120, 30);
        btnPlaceOrder.addActionListener(evt -> {
//    OrderDetails order = new OrderDetails(); // Create a new instance of OrderDetails for each order
    
    String quantityText = txtQuantity.getText();
    int quantity = Integer.parseInt(quantityText);
    double totalPrice = quantity * 500.0;
    textNetTotal.setText(String.valueOf(totalPrice));

    order.setOrderId(txtOrderid.getText());
    order.setCustomerId(textCusid.getText());
    order.setCustomerName(txtName.getText());
    order.setOrderStatus(OrderDetails.STATUS_PREPARING);
    order.setOrderQTY(quantity);
    order.setOrderValue(totalPrice);

    OrderController.add(order);
    
    JOptionPane.showMessageDialog(this, "Order placed successfully!");
     new HomePage();
});



        

        btnBackToHome = new JButton("Back to Home");
        btnBackToHome.setBackground(new Color(183, 21, 64));
        btnBackToHome.setForeground(Color.WHITE);
        btnBackToHome.setBounds(470, 480, 120, 30);
        btnBackToHome.addActionListener(evt -> {
             try {
                    HomePage BTM = new HomePage();
                    dispose(); // Dispose of the current frame (HomePage)
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            
        });

        btnCancel = new JButton("Cancel");
        btnCancel.setBackground(new Color(183, 21, 64));
        btnCancel.setForeground(Color.WHITE);
        btnCancel.setBounds(610, 480, 120, 30);
        btnCancel.addActionListener(evt -> {
            System.exit(0);
        });

        add(lblHome);
        add(lblOrderID);
        add(txtOrderid);
        add(lblCustomerID);
        add(textCusid);
        add(lblName);
        add(txtName);
        add(lblQuantity);
        add(txtQuantity);
        add(lblNetTotal);
        add(textNetTotal);
        add(btnPlaceOrder);
        add(btnBackToHome);
        add(btnCancel);

repaint();
    }

   
}

