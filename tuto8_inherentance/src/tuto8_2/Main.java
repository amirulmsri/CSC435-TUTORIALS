package tuto8_2;

import java.util.Scanner;

abstract class Rental{
	private String name;
	private String plateNum;
	
	public Rental(String name,String plateNum) {
		
	}
	
	public String getName() {return name;}
	public String getplateNum() {return plateNum;}
	
	public void setdata(String name,String plateNum) {
		this.name = name;
		this.plateNum = plateNum;
	}
	
	public String toString() {
		return name + plateNum;
	}
	
	//abstract method
	public abstract double calCharge();
	
}

class MPV extends Rental{
	private int day;
	private String model;
	
	public MPV(String name,String plateNum, int day,String model) {
		super(name,plateNum);
		
	}
	
	public String getModel() {return model;}
	public int getDay() {return day;}
	
	public String toStirng() {return day+model;}

	@Override
	public double calCharge() {
		double charges=0.0;
		double totalcharges=0.00;
		if(getModel().equalsIgnoreCase("Toyota Estima"))
			charges = 400.00;
		else if (getModel().equalsIgnoreCase("Kia Nazaria"))
			charges = 350.0;
		
		totalcharges = getDay()* charges;
		return totalcharges;
	}
	
}

class Limo extends Rental {

	private boolean chauffer;
	private int hour;
	private final double HOURLY = 200.00;
	
	public Limo(String name, String plateNum, boolean chauffer,int hour ) {
		super(name, plateNum);
		
	}
	
	public int getHour() {return hour;}
	public boolean getChauffer() {return chauffer;}
	
	//public String toString() {return hour + chauffer ;}

	@Override
	public double calCharge() {
		double charges = 0.00;
		if(getChauffer()== true)
		charges = hour * HOURLY + (100*hour);
		else
			charges = hour * HOURLY 
			;
		return charges;
	}
	
}

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Scanner db = new Scanner(System.in);
		Scanner bl = new Scanner(System.in);
		Rental rent[] = new Rental[50];
		
		boolean Continue = true;
		int ctr =0;
		while(Continue) {
			boolean CYN = true;
			//while(CYN) {
				System.out.print("Name: ");
				String name = sc.nextLine();
				System.out.print("plateNum: ");
				String plateNum = sc.nextLine();
				
				System.out.println("Please choose 1 option");
				System.out.println("1. Rental");
				System.out.println("2. Limo");
				int option = db.nextInt();
				
				if(option ==1) {
					System.out.print("Day: ");
					int day = db.nextInt();
					System.out.print("Model: ");
					String model = sc.nextLine();
					
				    rent[ctr] = new MPV(name, plateNum, day, model);
				}
				else if (option == 2 ) {
					System.out.print("Chauffer: ");
					boolean chauffer = bl.nextBoolean();
					System.out.print("Hour: ");
					int hour = db.nextInt();
					
					rent[ctr] = new Limo(name, plateNum, chauffer, hour);
					
				}
			//}
			
			if(rent[ctr] instanceof MPV) {
				MPV temp = (MPV) rent[ctr];
				if(temp.getDay() >7) {
					System.out.print("Name    : "+temp.getName());
					System.out.print("PlateNum: "+temp.getplateNum());
				}
					
			}
			
			Continue = false;
		}
	
	}

}
