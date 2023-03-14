package test;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
Scanner ateng = new Scanner (System.in);
        
        String name;
        String catCode = new String ();
        String prodDes = new String ();
        char proCode;
        int quantity, j;
        double distance, disPrice, prodPrice=0, totalPrice=0;
        
        do{
        System.out.print ("Enter name: ");
        name = ateng.next();
    
        System.out.print ("Choose category code: ");
        catCode = ateng.next();
        
        System.out.print ("Choose product code: ");
        proCode= ateng.next().charAt(0);
         
        if (catCode.equalsIgnoreCase ("NP456")){
        if ((proCode=='p') || (proCode=='P')){
                prodDes= "Promising Love " ;
                prodPrice= 158.50 ;
            }
            
            else if ((proCode=='e') || (proCode=='E')){
                prodDes= "Endless Love ";
                prodPrice = 198.50;
            }
            else 
                System.out.print ("Your code is not available.");
            }
            
            
        if  (catCode.equalsIgnoreCase("BS123")) {  
        if ((proCode=='f') || (proCode=='F')){
                prodDes= "Ferrero Chocolate Foil Balloon ";
                prodPrice = 158.50;
            }
            
            else if ((proCode=='b') || (proCode=='B')){
                prodDes= "Birthday Cake Mania";
                prodPrice = 188.50;
            }
        
            else 
                System.out.print ("Your code is not available.");
            }
           
                
            System.out.print ("Number of quantity you would like to purchase :  ");
            quantity= ateng.nextInt();
        
            System.out.print ("Distance(KM): ");
            distance= ateng.nextDouble();
            
            if (distance<=20){
                disPrice=distance*1;
            }
            
            else if (distance<=100 && distance>20){
                disPrice=distance*1.5;
            }
            
            else {
                disPrice=distance*2;
            }
            System.out.println(prodPrice);

            totalPrice= disPrice + (quantity*prodPrice);
            
            System.out.println ("WELCOME TO HARMONY GIFT SHOP  - " + name);
            System.out.print ("\n");
            System.out.println ("You have purchased  : " + prodDes );
            System.out.println ("You should pay : " + totalPrice);
            
                        
            System.out.println("Press 1 to continue, 0 to stop : ");
            j=ateng.nextInt();
            
            
        }while (j!=0);
	    

	}

}
