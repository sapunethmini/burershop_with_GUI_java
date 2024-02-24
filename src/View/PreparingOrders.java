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

public class PreparingOrders extends JFrame{
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

    public PreparingOrders() {
        setTitle("Preparing Details");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);
      

        
        lblHome = new JLabel("Preparing Orders ");
        lblHome.setText("Preparing Orders");
        lblHome.setFont(new Font("", Font.BOLD, 40));
        lblHome.setForeground(Color.white);
        lblHome.setBounds(0, 0, 800, 70);
        lblHome.setVerticalAlignment(JLabel.CENTER);
        lblHome.setHorizontalAlignment(JLabel.CENTER);
        lblHome.setBackground(new Color(183, 21, 64));
        lblHome.setOpaque(true);

        panelOrderDetails = new JPanel();
        panelOrderDetails.setLayout(new BorderLayout());
        panelOrderDetails.setBounds(50, 150, 250, 20);
        lblOrderDetails = new JLabel("Order Details");
        panelOrderDetails.add(lblOrderDetails, BorderLayout.NORTH);

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
        add(btnBack);

        repaint();
    }

    private void loadTable() {
    OrderDetails[] orderArray = OrderController.toArray();
    dtm.setRowCount(0);
    int preparingOrderCount = 0;
    String status = "Preparing";
    
    for (OrderDetails order : orderArray) {
        if (order.getOrderStatus().equals(status)) {
            preparingOrderCount++;
        }
    }
    
    for (OrderDetails order : orderArray) {
        if (order.getOrderStatus().equals(status)) {
            Object[] rowData = {
                order.getOrderId(),
                order.getCustomerId(),
                order.getCustomerName(),
                order.getOrderStatus(),
                order.getOrderQTY(),
                order.getOrderValue()
            };
            dtm.addRow(rowData);
            preparingOrderCount--;
            if (preparingOrderCount == 0) {
                break;
            }
        }
    }
}


}

    

