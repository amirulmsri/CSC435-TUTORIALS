package assigment2q2;

import java.util.Scanner;

class Employee{
	private String name;
	private double monthlySalary;
	
	public Employee(String name,double monthlySalary) {
		this.name = name;
		this.monthlySalary = monthlySalary;
	}
	
	public String getName() {return name;}
	public double getmonthlySalary() {return monthlySalary;}
	
	public void print() {
		
	}
}

class Programmer extends Employee{

	private double extraPay;
	
	public Programmer(String name, double monthlySalary) {
		super(name, monthlySalary);
		extraPay = 0.0;
	}
	
	public double getextraPay() {return extraPay;}
	public void setextraPay(double extraPay) {this.extraPay = extraPay;}
	
	public String toString() {return "Name: "+super.getName()+ "\nMonthly Salary: "+String.format("RM%.2f", super.getmonthlySalary())
	+ "\nExtra Pay: "+String.format("RM%.2f", getextraPay());}
	//return String.format("%-20s %-26s %-19s %-13.2f RM%-19.2f", icNumber, name, program,fCgpa,loanAmount);
	
	public void calcXtraPay( int numLines) {
		double totalXtraPay = 0.00;
		
		if(numLines <= 1000)
			totalXtraPay = (2.00*numLines);
		else if (numLines >1000 && numLines <2000)
			totalXtraPay = (2.30*numLines);
		else if (numLines > 2000)
			totalXtraPay = (2.50*numLines);
		
		this.setextraPay(totalXtraPay);
		//return totalXtraPay;
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Scanner db = new Scanner(System.in);
		boolean  Cont = true;
		Programmer prog [] = new Programmer[15];
		int ctr=0;
		while(Cont) {
			boolean valid = true;
			while(valid){
				int numLines =0;
			
					System.out.print("Name: ");
					String name = sc.nextLine();
					System.out.print("Montly Salary: ");
					double monthlySalary = db.nextDouble();
					System.out.print("Number of lines of codes: ");
					numLines = db.nextInt();
					
					prog[ctr] = new Programmer(name, monthlySalary);
					prog[ctr].calcXtraPay(numLines);
				
				ctr++;
				
				//System.out.print(ctr);
				System.out.print("Continue?[Y/N]");
				char YN = Character.toUpperCase(sc.nextLine().charAt(0));
				if(YN == 'N')
					valid = false;
				else if(YN == 'Y')
					valid = true;
			}
			
			
			double highestIncome = prog[0].getmonthlySalary() + prog[0].getextraPay();
			int idx =0;
			for(int i = 1; i<ctr; i++) {
				double newHigh = prog[i].getmonthlySalary() + prog[i].getextraPay();
				if(highestIncome < newHigh) {
					highestIncome = newHigh;
					idx = i;
				}
					
			}
			//System.out.println(idx);
			
			  System.out.println("\nThe details of employee with highest income ");
			  System.out.println(prog[idx].toString());
			  System.out.println("Total income is : "+String.format("RM%.2f",highestIncome));
			 
		System.out.print("\nQuit[Y/N]: ");
		char quit = Character.toUpperCase(sc.nextLine().charAt(0));
		
		if(quit == 'Y')
			Cont = false;
		else
			Cont = true;
		}
		sc.close();
		db.close();
		
	}
	

}
