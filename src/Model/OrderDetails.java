/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class OrderDetails {
    private String orderId;
    private String customerId;
    private String customerName;
    private String orderStatus;
    private int orderQTY;
    private double orderValue;

    public static final String STATUS_PREPARING = "Preparing";
    public static final String STATUS_DELIVERED = "Delivered";
    public static final String STATUS_CANCELLED = "Cancelled";

    public OrderDetails() {}
    

    public OrderDetails(String orderId, String customerId, String customerName, String orderStatus, int orderQTY, double orderValue) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.customerName = customerName;
        this.orderStatus = orderStatus;
        this.orderQTY = orderQTY;
        this.orderValue = orderValue;
    }
    
     

    public String getOrderId() { return orderId; }
    public String getCustomerId() { return customerId; }
    public String getCustomerName() { return customerName; }
    public String getOrderStatus() { return orderStatus; }
    public int getOrderQTY() { return orderQTY; }
    public double getOrderValue() { return orderValue; }

    public void setOrderId(String orderId) { this.orderId = orderId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public void setOrderStatus(String orderStatus) { this.orderStatus = orderStatus; }
    public void setOrderQTY(int orderQTY) { this.orderQTY = orderQTY; }
    public void setOrderValue(double orderValue) { this.orderValue = orderValue; }

    @Override
    public String toString() {
        return "{ " + getOrderId() + " - " + getCustomerId() + " - " + getCustomerName() + " - " + getOrderStatus() + " - " + getOrderQTY() + " - " + getOrderValue() + " }";
    }
}
