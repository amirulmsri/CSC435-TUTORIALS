package tuto5;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int quantity=0;
	
		int ctr =0,ContinueYN=1;
		
		while(ContinueYN ==1) {
			System.out.print("Enter order code: ");
			String ordercode=sc.nextLine();
			
			System.out.print("Enter order Type: ");
			char type=Character.toUpperCase(sc.next().charAt(0));
			
			System.out.print("Enter order Quantity: ");
			quantity=sc.nextInt();

			OnlineMagazine magazine = new OnlineMagazine(ordercode,type,quantity);
			double price = magazine.Calcprice();
			
			ctr++;
			
			System.out.print("Do u want to continue:" );
			ContinueYN=sc.nextInt();
			sc.nextLine();
		}
		
		
		//System.out.println(magazine[0].getorder());
		if(quantity>=10) {
			System.out.println(magazine.getorder());
		}

	}

}
