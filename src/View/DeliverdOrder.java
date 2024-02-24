/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.OrderController;
import Model.OrderDetails;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author acer
 */
public class DeliverdOrder extends JFrame{
     private JLabel lblHome;
  
    private JTextField txtCustomerID;
  

    private JPanel panelOrderDetails;
    private JLabel lblOrderDetails;
    private JTable tblOrderDetails;
    private JScrollPane scrollPaneOrderDetails;

    private JButton btnBack;
    private JButton btnSearch;
    private JTable ordersTable;
    private DefaultTableModel dtm;

    public DeliverdOrder() {
        setTitle("Search Customer Details");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);
      

        lblHome = new JLabel("Deliver Orders ");
        lblHome.setText("Deliver Orders ");
        lblHome.setFont(new Font("", Font.BOLD, 40));
        lblHome.setForeground(Color.white);
        lblHome.setBounds(0, 0, 800, 70);
        lblHome.setVerticalAlignment(JLabel.CENTER);
        lblHome.setHorizontalAlignment(JLabel.CENTER);
        lblHome.setBackground(new Color(183, 21, 64));
        lblHome.setOpaque(true);

        btnBack = new JButton("Back");
        btnBack.setBackground(new Color(183, 21, 64));
        btnBack.setForeground(Color.white);
        btnBack.setBounds(450, 500, 100, 30);
        btnBack.addActionListener(evt -> {
            new HomePage();
        });
       
        
        
         String [] columnNames ={"Order Id","Customer Id","Customer Name","Order Status","QTY","Total"};
        dtm= new DefaultTableModel(columnNames,0);
        ordersTable=new JTable(dtm);
        
        JScrollPane tblPane=new JScrollPane(ordersTable);
        tblPane.setBounds(100, 150, 600, 200);
        loadTable();
        add(tblPane);
        add(lblHome);
//        add(btnSearch);
//        add(panelOrderDetails);
        add(btnBack);

        repaint();
    }

    private void loadTable() {
    OrderDetails[] orderArray = OrderController.toArray();
    dtm.setRowCount(0); 
    String status = "Delivered";
    int deliveredOrderCount = 0;

    for (OrderDetails order : orderArray) {
        if (order.getOrderStatus().equals(status)) {
            deliveredOrderCount++;
        }
    }

    for (OrderDetails order : orderArray) {
        if (order.getOrderStatus().equals(status)) {
            Object[] rowdata = {
                order.getOrderId(),
                order.getCustomerId(),
                order.getCustomerName(),
                order.getOrderStatus(),
                order.getOrderQTY(),
                order.getOrderValue()
            };
            dtm.addRow(rowdata);
            deliveredOrderCount--; 
            if (deliveredOrderCount == 0) {
                break; 
            }
        }
    }
}

}

    

