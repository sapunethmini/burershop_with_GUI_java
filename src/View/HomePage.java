/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.*;
import static java.awt.PageAttributes.MediaType.E;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;



public class HomePage extends JFrame {

    private JButton btnAddCustomer;
    private JButton btnPlaceOrder;
    private JButton btnSearch;
    private JButton btnViewOrder;
    private JButton btnUpdateOrder;
    private JButton btnExit;
    private JLabel lblImage;

    private JLabel lblHome;
    private JPanel jPanel1;

    public HomePage() {
        

        btnAddCustomer = new JButton("Add Customer");
        btnAddCustomer.setFont(new Font("", Font.PLAIN, 18));
        btnAddCustomer.setBounds(500, 150, 200, 40);
        btnAddCustomer.setBackground(new Color(183, 21, 64));
        btnAddCustomer.setForeground(Color.WHITE);
        btnAddCustomer.setFocusable(false);
        btnAddCustomer.addActionListener(evt -> {
            // Add Customer rgba(111, 30, 81,1.0)rgba(181, 52, 113,1.0)
        });

        btnPlaceOrder = new JButton("Place Order");
        btnPlaceOrder.setFont(new Font("", Font.PLAIN, 18));
        btnPlaceOrder.setBounds(500, 200, 200, 40);
        btnPlaceOrder.setBackground(new Color(183, 21, 64));
        btnPlaceOrder.setForeground(Color.WHITE);
        btnPlaceOrder.setFocusable(false);
        btnPlaceOrder.addActionListener(evt -> {
               try {
                    Place_Order placeOrderFrame = new Place_Order();
                    dispose(); // Dispose of the current frame (HomePage)
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            
        });
        

        btnSearch = new JButton("Search");
        btnSearch.setFont(new Font("", Font.PLAIN, 18));
        btnSearch.setBounds(500, 250, 200, 40);
        btnSearch.setBackground(new Color(183, 21, 64));
        btnSearch.setForeground(Color.WHITE);
        btnSearch.setFocusable(false);
        btnSearch.addActionListener(evt -> {
            try {
                    Choice_search CS = new Choice_search();
                    dispose(); // Dispose of the current frame (HomePage)
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
        });

        btnViewOrder = new JButton("View Orders");
        btnViewOrder.setFont(new Font("", Font.PLAIN, 18));
        btnViewOrder.setBounds(500, 300, 200, 40);
        btnViewOrder.setBackground(new Color(183, 21, 64));
        btnViewOrder.setForeground(Color.WHITE);
        btnViewOrder.setFocusable(false);
        btnViewOrder.addActionListener(evt -> {
            new veiw();
        });

        btnUpdateOrder = new JButton("Update Order");
        btnUpdateOrder.setFont(new Font("", Font.PLAIN, 18));
        btnUpdateOrder.setBounds(500, 350, 200, 40);
        btnUpdateOrder.setFocusable(false);
        btnUpdateOrder.setBackground(new Color(183, 21, 64));
        btnUpdateOrder.setForeground(Color.WHITE);
        btnUpdateOrder.addActionListener(evt -> {
            try {
                    Update_Order_D AP_O = new Update_Order_D();
                    dispose(); // Dispose of the current frame (HomePage)
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
        });

        btnExit = new JButton("EXIT");
        btnExit.setFont(new Font("", Font.PLAIN, 15));
        btnExit.setBounds(540, 450, 100, 40);
        btnExit.setBackground(new Color(183, 21, 64));
        btnExit.setForeground(Color.WHITE);
        btnExit.setFocusable(false);
        btnExit.addActionListener(evt -> {
            System.exit(0);
        });

        lblHome = new JLabel();
        lblHome.setText("Burger King");
        lblHome.setFont(new Font("", Font.BOLD, 40));
        lblHome.setForeground(Color.white);
        lblHome.setBounds(0, 0, 800, 70);
        lblHome.setVerticalAlignment(JLabel.CENTER);
        lblHome.setHorizontalAlignment(JLabel.CENTER);
        lblHome.setBackground(new Color(183, 21, 64));
        lblHome.setOpaque(true);
        lblImage = new JLabel();
        lblImage.setBounds(0, 71, 400, 600);
//        lblImage.setIcon(new ImageIcon("E:\\ICET\\OOP\\day 04\\coursework\\part 02\\burgershop_application\\src\\img\\your_image_file.jpg")); 
        lblImage.setIcon(new ImageIcon(getClass().getResource("../img/IMG.png")));


        jPanel1 = new JPanel();
        jPanel1.setBounds(0, 70, 400, 600);
        jPanel1.setBackground(Color.WHITE);
        jPanel1.add(lblImage, BorderLayout.CENTER); 

        JPanel jPanel2 = new JPanel();
        jPanel2.setBounds(405, 70, 400, 600);
        jPanel2.setBackground(Color.WHITE);
        jPanel2.setLayout(new GridLayout(5, 1, 10, 10));
        
        setTitle("Home Page");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
        
        
        add(lblHome);
        add(jPanel1);
        add(btnPlaceOrder);
        add(btnSearch);
        add(btnViewOrder);
        add(btnUpdateOrder);
        add(btnExit);
        add(jPanel2);
   
    }
   
}
