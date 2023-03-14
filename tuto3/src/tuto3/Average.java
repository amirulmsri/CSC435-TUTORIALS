package tuto3;

import java.util.Scanner;

public class Average
{
	
	static double calculate (char pc, int numItem, int dist) {
		double price=0;
		String productName = new String();
		if(Character.toUpperCase(pc)=='P') {
			price=158.50*numItem;
			productName = "Promising Love";
		}
		else if(Character.toUpperCase(pc)=='E') {
			price=198.50*numItem;
			productName = "Endless Love";
		}
		else if(Character.toUpperCase(pc)=='F') {
			price=158.50*numItem;
			productName = "Ferrero Chocolate Foil Balloon";
		}
		else if(Character.toUpperCase(pc)=='B') {
			price=188.50*numItem;
			productName = "Birthday Cake Mania";
		}
		//product(productName);	
		double fee=shippingFee(dist);
	return( fee + price);
	}
	
	/*static void product(string PN) {
		
	}*/
	
	static double shippingFee(int d) {
		double fee=0;
		if(d<=20)
		fee = 20.00;
		if(d>20 && d<=100)
		fee = (d-20)*1.50 + 20 ;	
		if(d>100)
		fee = (d-100)*2.00 + 140;
		return(fee);
		
	}
	static void DisplayReceipt(String name,String CD,int Qty,double tp) {
		
		System.out.println("WELCOME TO HARMNOY GIFT SHOP-"+ name);
		System.out.println("\nYou have purchased : ");
		System.out.println("Category             :" + CD);
		System.out.println("Quantity             :" + Qty);
		System.out.println("You should pay       :RM" + tp);
	
	
	}
    public static void main (String[] args)
    {
    	char ProductCode ;
    	String name = new String();
    	String Catcode = new String();
    	String CatDesc = new String();
    	
    	int numItem = 0,dist=0,YN=0;
    	double totalprice=0;
    	Scanner sc = new Scanner(System.in);
    	
    	
    	
    	while(YN == 0) {
    		
    	
        System.out.print("Enter your name: ");
        name = sc.nextLine();
        
        //sc.nextLine();
    	
    		System.out.print("Enter category code: ");
            Catcode = sc.nextLine();
            
            if(Catcode.equalsIgnoreCase("NP456")) {
            	CatDesc = "New Product";
               System.out.print("Enter the product code: ");
               ProductCode = sc.next().charAt(0);
                
               System.out.println("How many item you want to buy: ");
           	   numItem= sc.nextInt();
                
               System.out.print("Enter the distance: ");
               dist = sc.nextInt();
               
              totalprice= calculate(ProductCode,numItem,dist);
            }
            else if (Catcode.equalsIgnoreCase("BS123")){
            	CatDesc = "Best Seller";
            	System.out.print("Enter the product code: ");
                ProductCode = sc.next().charAt(0);
                
                System.out.print("How many item you want to buy: ");
            	numItem= sc.nextInt();
                 
                System.out.print("Enter the distance in km: ");
                dist = sc.nextInt();
                
                totalprice=calculate(ProductCode,numItem,dist);
            }
            
    	
    	//System.out.println(totalprice);
           
          System.out.println("\n\n\n\n\n");
    	DisplayReceipt(name,CatDesc,numItem,totalprice);
        
        System.out.println("Do you want to exit the program?[1-Y/0-N]");
        YN = sc.nextInt();
    }
       
    }
}


