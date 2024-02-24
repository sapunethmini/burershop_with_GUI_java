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

public class Serach_best_customer extends JFrame{
     private JLabel lblHeader;
     private JLabel lblHome;
    private JTextField txtCustomerID;
  

    private JPanel panelOrderDetails;
    private JLabel lblOrderDetails;
    private JTable tblOrderDetails;
    private JScrollPane scrollPaneOrderDetails;

    private JButton btnBack;
    private JButton btnBackToHome;
    private JButton btnSearch;
    private JTable ordersTable;
    private DefaultTableModel dtm;

    public Serach_best_customer() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);
      

        lblHeader = new JLabel("The Best Customer___!");
        lblHeader.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        lblHeader.setBounds(0, 0, 600, 70);
        lblHeader.setForeground(Color.white);
        lblHeader.setBounds(0, 0, 800, 70);
        lblHeader.setVerticalAlignment(JLabel.CENTER);
        lblHeader.setHorizontalAlignment(JLabel.CENTER);
        lblHeader.setBackground(new Color(183, 21, 64));
        lblHeader.setOpaque(true);


        btnBack = new JButton("Back");
        btnBack.setBounds(500, 400, 100, 30);
        btnBack.setForeground(Color.white);
        btnBack.setBackground(new Color(183, 21, 64));
        btnBack.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        
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
        
        
        String [] columnNames ={"Customer Id","Customer Name","Total"};
        dtm= new DefaultTableModel(columnNames,0);
        ordersTable=new JTable(dtm);
        ordersTable.setBackground(new Color(183, 21, 64)); 
        ordersTable.setForeground(Color.white);

        
        JScrollPane tblPane=new JScrollPane(ordersTable);
        tblPane.setBounds(100, 150, 550, 300);
        loadTable();
        add(tblPane);
        add(lblHeader);
      add(btnBackToHome);
        add(btnBack);

        repaint();
    }

     private void loadTable() {
    OrderDetails[] orderArray = OrderController.toArray();
    dtm.setRowCount(0);
    String staus  = "Preparing";
    OrderDetails[] sortedOrderArray = OrderController.sortArray(orderArray);
    for (int i = 0; i < sortedOrderArray.length; i++) {
        OrderDetails order = sortedOrderArray[i];
        if (order != null) {
            Object[] rowdata = {
                
                order.getCustomerId(),
                order.getCustomerName(),
                order.getOrderValue()
            };
            dtm.addRow(rowdata);
        }
    }
}

}

    

