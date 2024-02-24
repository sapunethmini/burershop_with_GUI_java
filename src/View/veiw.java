/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.awt.*;
import static java.awt.PageAttributes.MediaType.E;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author acer
 */
public class veiw extends JFrame{
    private JButton btnDeliverdOrder;
    private JButton btnPreparingOrder;
    private JButton btnCalnceledOrder;
    private JLabel lblImage;

    private JLabel lblHome;
    public veiw() {
        
        

        

        btnDeliverdOrder = new JButton("Deliverd Orders");
        btnDeliverdOrder.setFont(new Font("", Font.PLAIN, 15));
        btnDeliverdOrder.setBounds(500, 200, 200, 40);
        btnDeliverdOrder.setBackground(new Color(183, 21, 64));
        btnDeliverdOrder.setForeground(Color.white);
        btnDeliverdOrder.setFocusable(false);
        btnDeliverdOrder.addActionListener(evt -> {
               new DeliverdOrder();
               dispose();
            
        });
        


        btnPreparingOrder = new JButton("Preparing Orders");
        btnPreparingOrder.setFont(new Font("", Font.PLAIN, 15));
        btnPreparingOrder.setBounds(500, 280, 200, 40);
        btnPreparingOrder.setBackground(new Color(183, 21, 64));
        btnPreparingOrder.setForeground(Color.white);
        btnPreparingOrder.setFocusable(false);
        btnPreparingOrder.addActionListener(evt -> {
              new PreparingOrders();
              dispose();
        });

        btnCalnceledOrder = new JButton("Calnceled Order");
        btnCalnceledOrder.setFont(new Font("", Font.PLAIN, 15));
        btnCalnceledOrder.setBackground(new Color(183, 21, 64));
        btnCalnceledOrder.setForeground(Color.white);
        btnCalnceledOrder.setBounds(500, 360, 200, 40);
        btnCalnceledOrder.setFocusable(false);
        btnCalnceledOrder.addActionListener(evt -> {
            try {
                    canceledOrders AP_O = new canceledOrders();
                    dispose(); // Dispose of the current frame (HomePage)
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            dispose();
        });
        


        lblHome = new JLabel();
        lblHome.setText("View Orders");
        lblHome.setFont(new Font("", Font.PLAIN, 40));
        lblHome.setForeground(Color.white);
        lblHome.setBounds(0, 0, 800, 70);
        

        lblHome.setVerticalAlignment(JLabel.CENTER);
        lblHome.setHorizontalAlignment(JLabel.CENTER);
        lblHome.setBackground(new Color(183, 21, 64));
        lblHome.setOpaque(true);
        lblImage = new JLabel();
        lblImage.setBounds(0, 28, 400, 600);
        lblImage.setIcon(new ImageIcon(getClass().getResource("../img/im02.png")));


        JPanel jPanel1 = new JPanel();
        jPanel1.setBounds(0, 0, 400, 600);
        jPanel1.setBackground(Color.WHITE);
        JPanel jPanel2 = new JPanel();
        jPanel2.setBounds(450, 100, 225, 367);
        jPanel2.setLayout(new GridLayout(5, 1, 10, 10));
        
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);
        
        
        add(lblHome);
        add(btnDeliverdOrder);
        add(btnPreparingOrder);
        add(btnCalnceledOrder);
        add(lblImage);
      
    }

    
}

