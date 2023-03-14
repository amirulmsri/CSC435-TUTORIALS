package q2;

import java.util.Scanner;

public class Main {
	
	public static class Cinema {

		private String cinCode;
		private String movieTitle;
		private double price;
		private String modePayment;
		private boolean membership;
		double Discountrate;
		double totalpayment;
		
		//normal constructor
		public Cinema(String cinCode,String movieTitle,double price,String modePayment
				,boolean membership) {
			this.setcincode(cinCode);
			this.setmovieTitle(movieTitle);
			this.setprice(price);
			this.setmodePayment(modePayment);
			this.setmembership(membership);
			//call methods every time values are passed
			DiscountRate();
			calcTotalpayment();
		}
		
		//accessor
		public String getcincode() {return cinCode;}
		public String getmovieTitle() {return movieTitle;}
		public double getprice() {return price;}
		public String getmodePayemnt() {return modePayment;}
		public boolean getmembership() {return membership;}
		//mutator
		public void setcincode(String cinCode) {
			this.cinCode=cinCode;}
		public void setmovieTitle(String movieTitle) {
			this.movieTitle=movieTitle;}
		public void setprice(double price) {
			this.price=price;}
		public void setmodePayment(String modePayment) {
			this.modePayment=modePayment;}
		public void setmembership(boolean membership) {
			this.membership=membership;}
		
		//discount rate ( after divided by 100).
		public double DiscountRate() {
			if (modePayment.equalsIgnoreCase("Credit card")) {
				if(membership == true)
					Discountrate= 0.05;
				else if (membership == false)
					Discountrate=0.03;
			}
			else if (modePayment.equalsIgnoreCase("Cash")) {
				if(membership == true)
					Discountrate= 0.10;
				if (membership == false)
					Discountrate= 0.00;
			}
			else {
				System.out.println("invalid");
			}//store value to attribute
			return Discountrate;
		}
		//toString
		public String toString() {
			return "\nCinema code:"+cinCode+"\nMovie title:"+movieTitle
					+"\nPrice:RM"+price+"\nPayment mode:"+modePayment+"\nStatus:"+membership+
					"\nDiscount Rate:"+Discountrate+"%"+"\nTotal price:" ;
		}
		//calculate price after discount
		public double calcTotalpayment() {
			totalpayment= price-(Discountrate*price);
			//store value to attribute
			return totalpayment;
		}

}
	public static void main(String[] args) {
	
		final int size =100;
		int ctr=1;
		Cinema cinViewer[] = new Cinema[size];
		Scanner sc = new Scanner(System.in);
		Scanner db = new Scanner(System.in);
		
		for(int i=0;i<ctr;i++) {
			System.out.print("Cinema code: ");
			String code=sc.nextLine();
			System.out.print("Movie title: ");
			String title=sc.nextLine();
			System.out.print("Price: ");
			double price =db.nextDouble();
			System.out.print("Payment mode: ");
			String mode = sc.nextLine();
			System.out.print("Membership: ");
			boolean status =db.nextBoolean();
			cinViewer[i]= new Cinema(code,title,price,mode,status);
			//System.out.println(cinViewer[i].DiscountRate());
			System.out.print(cinViewer[i].toString());
			System.out.println("RM"+(String.format("%,.2f",cinViewer[i].totalpayment)));
			System.out.print(cinViewer[i].Discountrate);
			
			System.out.print("Do you want to Stop[1-Yes/0-No]:");
			int CN = db.nextInt();
			if(CN==1)
				ctr--;
			if(CN==0)
			   ctr++;
		}
		sc.close();
		db.close();
	}
	}
