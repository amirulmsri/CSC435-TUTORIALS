package tuto5;

import java.util.Scanner;

public class OnlineMagazine {
	
	private String Ordercode;		// Example : “S001” , “W007”, “H018”
	private char Type;			// S - SPORT , W - WOMAN, and H - HEALTH
	private int Quantity;          		// 1,2,3,…

	//normal constructor
	OnlineMagazine(String Ordercode, char Type, int Quantity){
		
		this.Ordercode=Ordercode;
		this.Type=Type;
		this.Quantity=Quantity;
	}
	//ACcessor
	public String getorder() {
		return Ordercode;
	}
	public char getype(){
		return Type;
	}
	public int getQuantity() {
		return Quantity;
	}
	
	//toString
	public String toString() {
		return "Order code:"+Ordercode +"Type: "+ Type 
				+"Quantity: " +Quantity;
	}
	
	//Processor
	public  double Calcprice() {
		
		if(Type == 'S') 
			return 3.50*Quantity;
		else if(Type == 'W')
			return 4.00*Quantity;
		else if(Type =='H')
		    return 3.00*Quantity;
		else {
			return 0.00;
		}
	}
	
}

