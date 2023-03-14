package test;

import java.util.Scanner;

public class Test {
 
 public static class OnlineMagazine {
  private String orderCode;
  private char type;
  private int quantity;
  private double totalprice;
  
  public OnlineMagazine(String orderCode, char type, int quantity) {
   this.orderCode = orderCode;
   this.type = type;
   this.quantity = quantity;
  }
  
  public String getOrderCode() {
   return orderCode;
  }
  
  public char getType() {
   return type;
  }
  
  public int getQuantity() {
   return quantity;
  }
  
  public String toString() {
   return "Order code: " + orderCode + "\nType: " + type + "\nQuantity: " + quantity;
  }
  
  public double totalPrice() {
   if(type == 'S') {
    totalprice = quantity*3.5;
   }
   else if(type == 'W') {
    totalprice = quantity*4;
   }
   else if(type == 'H') {
    totalprice = quantity*3;
   }
   return totalprice;
  }
 }

 public static void main(String[] args) {
  Scanner scanS = new Scanner(System.in);
  Scanner scanI = new Scanner(System.in);
  
  String orderCode;
  char type = 0;
  int quantity = 0;
  boolean Continue = true;
  
  while(Continue) {
   System.out.print("Enter order code: ");
   orderCode = scanS.nextLine();
   
   boolean invalid = true;
   while(invalid) {
    System.out.print("Enter type: ");
    type = Character.toUpperCase(scanS.nextLine().charAt(0));
    
    if(type == 'S'|| type == 'W' || type == 'H') {
     invalid = false;
    }
    else
     System.out.println("\nInvalid type! Please try again.");
   }
   
   System.out.print("Enter quantity: ");
   quantity = scanI.nextInt();
   
   OnlineMagazine order = new OnlineMagazine(orderCode,type, quantity);
   System.out.println("Total price: RM" + order.totalPrice());
   
   if(quantity > 10) {
    System.out.println("\nThe order quantity is more than 10 orders");
    System.out.println("Order code: " + order.quantity);
    System.out.println("Type: " + order.getType());
    System.out.println("Quantity: " + order.getQuantity());
    System.out.println("Total price: RM" + order.totalprice);
   }
   
   invalid = true;
   System.out.println("");
   
   while(invalid) {
    System.out.print("Continue with next order? [Y]es [N]o: ");
    char yesorno = Character.toUpperCase(scanS.nextLine().charAt(0));
    
    if(yesorno == 'N') {
     Continue = false;
     invalid = false;
    }
    else if(yesorno == 'Y') {
     invalid = false;
    }
    else
     System.out.println("\nInvalid input! Please try again.");
   }
  }
  
  scanS.close();
  scanI.close();
 }
}
