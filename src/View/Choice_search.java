/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


public class Choice_search extends JFrame {
    public int quantity;
    private JLabel lblTitle;
    private JButton btnSearchBestCustomer;
    private JButton btnSearchOrderDetails;
    private JButton btnSearchCustomer;
    private JButton btnExit;
    private JButton backhome;
    private JPanel pannel;

    public Choice_search() {
        
      
        pannel = new JPanel();
        pannel.setBounds(0, 0, 800, 600);
        pannel.setBackground(Color.WHITE);
        lblTitle = new JLabel();
        lblTitle.setText("Let's Search");
        lblTitle.setFont(new Font("", Font.PLAIN, 24));
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setBounds(0, 0, 800, 70);
        
        lblTitle.setVerticalAlignment(JLabel.CENTER);
        lblTitle.setHorizontalAlignment(JLabel.CENTER);
        lblTitle.setBackground(new Color(183, 21, 64));
        lblTitle.setOpaque(true);
       
//
        btnSearchBestCustomer = new JButton("Search Best Customer");
        btnSearchBestCustomer.setFont(new Font("", Font.PLAIN, 15));
        btnSearchBestCustomer.setBackground(new Color(183, 21, 64));
        btnSearchBestCustomer.setForeground(Color.WHITE);
        btnSearchBestCustomer.setBounds(280, 150, 240, 40);
        btnSearchBestCustomer.setFocusable(false);
        btnSearchBestCustomer.addActionListener(evt ->{
            new Serach_best_customer();
            dispose();
        });
        
        btnSearchOrderDetails = new JButton("Search Order Details");
        btnSearchOrderDetails.setFont(new Font("", Font.PLAIN, 15));
        btnSearchOrderDetails.setBackground(new Color(183, 21, 64));
        btnSearchOrderDetails.setForeground(Color.WHITE);
        btnSearchOrderDetails.setBounds(280, 210, 240, 40);
        btnSearchOrderDetails.setFocusable(false);
        btnSearchOrderDetails.addActionListener(evt -> {
             try {
                    Search_order_Details BTM = new Search_order_Details();
                    dispose(); // Dispose of the current frame (HomePage)
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
             dispose();
            
        });

        btnSearchCustomer = new JButton("Search Customer");
        btnSearchCustomer.setFont(new Font("", Font.PLAIN, 15));
        btnSearchCustomer.setBackground(new Color(183, 21, 64));
        btnSearchCustomer.setForeground(Color.WHITE);
        btnSearchCustomer.setBounds(280, 270, 240, 40);
        btnSearchCustomer.setFocusable(false);
        btnSearchCustomer.addActionListener(evt -> {
             try {
                    Search_cus_Details BTM = new Search_cus_Details();
                    dispose(); // Dispose of the current frame (HomePage)
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            dispose();
        });
        

        btnExit = new JButton("Exit");
        btnExit.setFont(new Font("", Font.PLAIN, 15));
        btnExit.setBackground(new Color(183, 21, 64));
        btnExit.setForeground(Color.WHITE);
        btnExit.setBounds(220, 400, 100, 40);
        btnExit.setFocusable(false);
        btnExit.addActionListener(evt -> {
            System.exit(0);
        });
       
        backhome = new JButton("Back to home");
        backhome.setFont(new Font("", Font.PLAIN, 15));
        backhome.setBackground(new Color(183, 21, 64));
        backhome.setForeground(Color.WHITE);
        backhome.setBounds(440, 400, 140, 40);
        backhome.setFocusable(false);
        backhome.addActionListener(evt -> {
            new HomePage();
        });
        

        setTitle("Place Order");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);

        add(lblTitle);
        add(btnSearchBestCustomer);
        add(btnSearchOrderDetails);
        add(btnSearchCustomer);
        add(btnExit);
        add(backhome);
        add(pannel);
    }

   
}
