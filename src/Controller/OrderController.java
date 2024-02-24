/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DB.OrderList;
import Model.OrderDetails;
import javax.swing.text.View;

/**
 *
 * @author acer
 */
public class OrderController {
    
    	// orders array
	public static OrderList list  = new OrderList();
        public static OrderDetails orders=new OrderDetails();
        public int number=0;
        

	
	// generate order Id
	public static String generateOrderId() {
    if (list.isEmpty()) {
        return "O001"; // If the list is empty, return the first order ID
    } else {
        String lastOrderId = list.get(list.size() - 1).getOrderId();
        int number = Integer.parseInt(lastOrderId.substring(1)) + 1; // Increment the order number
        return String.format("O%03d", number); // Format the order ID
    }
}

               public static String generateCustomerId() {
    if (list.isEmpty()) {
        return "C001";
    }
    String lastCustomerId = list.get(list.size() - 1).getCustomerId();
    int number = Integer.parseInt(lastCustomerId.substring(1)) + 1;
    return String.format("C%03d", number);
}



	// validation Customer ID
//	public static boolean validationcustomerId(String customerId) {
//        if (customerId.length() == 10) {
//            if (customerId.startsWith("0")) {
//                try {
//                    int i = Integer.parseInt(customerId);
//                    return true;
//                } catch (NumberFormatException e) {
//                    return false;
//                }
//            }
//        }
//        return false;
//    }
    
    // view orders details
	public static String viewOrderDetails(int i){
		String line = String.format("%1s%-10s%-15s%-15s%-10d%8.2f", " ", list.get(i).getOrderId(), list.get(i).getCustomerId(),
									list.get(i).getCustomerName(), list.get(i).getOrderQTY(), list.get(i).getOrderValue());
		return line;
	}
	
	//searching for customer ID
	public static String isExistCustomer(String customerId){
		String name="";
		for(int i=0 ; i < list.size() ; i++){
			if(customerId.equals(list.get(i).getCustomerId())){
				name=list.get(i).getCustomerName();
				break;
			}
		}
		return name;
	}
	
	//add order
	public static void add(OrderDetails data){
		list.add(data);
	}
	
	public static OrderDetails[] toArray(){
		return (OrderDetails[]) list.toArray();
	}
//	
//	public static OrderDetails[] addUniqueValuesToArray(OrderDetails[] orderArray){
//		OrderDetails[] sortOrderArray = new OrderDetails[0];
//		for (int i = 0; i < orderArray.length; i++) {
//			boolean isExist = false;
//			for (int j = 0; j < sortOrderArray.length; j++) {
//                if (sortOrderArray[j].getCustomerId().equals(orderArray[i].getCustomerId())) {
//                    if (orderArray[i].getOrderStatus()!=View.CANCEL){
//						sortOrderArray[j].setOrderValue(sortOrderArray[j].getOrderValue()+orderArray[i].getOrderValue());
//					}
//                    isExist = true;
//                }
//            }
//            if (!isExist) {
//				OrderDetails[] tempSortOrderArray = new OrderDetails[sortOrderArray.length+1];
//                for (int j = 0; j < sortOrderArray.length; j++) {
//					tempSortOrderArray[j]=new OrderDetails(
//						sortOrderArray[j].getOrderId(),
//						sortOrderArray[j].getCustomerId(),
//						sortOrderArray[j].getCustomerName(),
//						sortOrderArray[j].getOrderStatus(),
//						sortOrderArray[j].getOrderQTY(),
//						sortOrderArray[j].getOrderValue()
//					);
//                }
//                tempSortOrderArray[tempSortOrderArray.length-1]= new OrderDetails(
//					orderArray[i].getOrderId(),
//					orderArray[i].getCustomerId(),
//					orderArray[i].getCustomerName(),
//					orderArray[i].getOrderStatus(),
//					orderArray[i].getOrderQTY(),
//					orderArray[i].getOrderValue()	
//                );
//                sortOrderArray=tempSortOrderArray;
//            }
//        }
//        return sortOrderArray;
//	}
//	
        
        
	public static OrderDetails[] sortArray(OrderDetails[] sortOrderArray){
		for (int i = 1; i < sortOrderArray.length; i++) {
            for (int j = 0; j < i; j++) {
                if (sortOrderArray[j].getOrderValue() < sortOrderArray[i].getOrderValue()) {
					String temp = sortOrderArray[j].getCustomerId();
					sortOrderArray[j].setCustomerId(sortOrderArray[i].getCustomerId());
					sortOrderArray[i].setCustomerId(temp);
                    
					temp = sortOrderArray[j].getCustomerName();
					sortOrderArray[j].setCustomerName(sortOrderArray[i].getCustomerName());
					sortOrderArray[i].setCustomerName(temp);
                    
					double tempd = sortOrderArray[j].getOrderValue();
					sortOrderArray[j].setOrderValue(sortOrderArray[i].getOrderValue());
					sortOrderArray[i].setOrderValue(tempd);
				}
			}
		}
		return sortOrderArray;
	}
	
//	public static String getOrderDetail(String orderId){
//		String line="";
//		for (int i = 0; i < list.size() ; i++) {
//			if (orderId.equals(list.get(i).getOrderId())) {
//				String status = "Preparing";
////                switch (list.get(i).getOrderStatus()) {
////					case View.CANCEL:
////						status = "Cancel";
////						break;
////					case View.PREPARING:
////						status = "Preparing";
////						break;
////					case View.DELIVERED:
////						status = "Delivered";
////						break;
////				}
//                line = String.format("%1s%-10s%-14s%-15s%-10d%-14.2f%-10s", " ", list.get(i).getOrderId(), list.get(i).getCustomerId(), 
//								list.get(i).getCustomerName(), list.get(i).getOrderQTY(), list.get(i).getOrderValue(),status);
//                break;
//			}
//		}
//		return line;
//	}
	public static OrderDetails getOrderDetails(String orderId) {
        for (int i = 0; i < list.size(); i++) {
            if (orderId.equals(list.get(i).getOrderId())) {
                return list.get(i);
            }
        }
        return null; // Return null if order not found
    }
        
        
        public static OrderDetails getOrderDetails_cus(String cusId) {
        for (int i = 0; i < list.size(); i++) {
            if (cusId.equals(list.get(i).getCustomerId())) {
                return list.get(i);
            }
        }
        return null; // Return null if order not found
    }
        
         public static OrderDetails getOrderDetails_status(String status) {
        for (int i = 0; i < list.size(); i++) {
            if (status.equals(list.get(i).getOrderStatus())) {
                return list.get(i);
            }
        }
        return null; // Return null if order not found
    }
	public static OrderDetails getOrder(int index){
		return (OrderDetails) list.get(index);
	}
	
	//size of linked list
	public static int size(){
		return list.size();
	}
        
        public static OrderDetails[] getCustomerOrders(String customerId) {
        OrderList customerOrders = new OrderList();
        for (int i = 0; i < list.size(); i++) {
            if (customerId.equals(list.get(i).getCustomerId())) {
                customerOrders.add(list.get(i));
            }
        }
        return customerOrders.toArray();
    }
        
       public static boolean updateOrder(OrderDetails updatedOrder) {
       for (int i = 0; i < list.size(); i++) {
        OrderDetails order = list.get(i);
            if (order.getOrderId().equals(updatedOrder.getOrderId())) {
                order.setCustomerName(updatedOrder.getCustomerName());
                order.setCustomerId(updatedOrder.getCustomerId());
                order.setOrderStatus(updatedOrder.getOrderStatus());
                order.setOrderQTY(updatedOrder.getOrderQTY());
                order.setOrderValue(updatedOrder.getOrderValue());
                return true; // Order updated successfully
            }
        }
        return false; // Order not found
    }
	
    
}
