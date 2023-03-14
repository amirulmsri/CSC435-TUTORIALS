package q3;

import java.util.Scanner;

abstract class EZTravelApplicant{
	private String name;
	private String ICNumber;
	private char fligt; // 'M','A'
	private double deposit;
	
	//normal constructor
	public EZTravelApplicant(String name,String ICNumber,char fligt,double deposit) {
		this.setname(name);
		this.setICNumber(ICNumber);
		this.setfligt(fligt);
		this.setdeposit(deposit);
	}
	
	public void setname(String name) {this.name=name;}
	public void setICNumber(String ICNumber) {this.ICNumber=ICNumber;}
	public void setfligt(char fligt) {this.fligt=fligt;}
	public void setdeposit(double deposit) {this.deposit=deposit;}
	
	public String getname() {return name;}
	public String getICNumber() {return ICNumber;}
	public char getfligt() {return fligt;}
	public double getdeposit() {return deposit;}
	
	public abstract double caclulateCharge();
}


class HajApplicant extends EZTravelApplicant{
	private boolean firstTime;
	private char room; // A-2p, B-4p, C-6p
	
	public HajApplicant(String name,String ICNumber,char fligt,double deposit,
			boolean firstTime,char room) {
		super(name,ICNumber,fligt,deposit);
		this.setfirstTime(firstTime);
		this.setroom(room);
	}
	
	public void setfirstTime(boolean firstTime) {this.firstTime=firstTime;}
	public void setroom(char room) {this.room=room;}
	
	public boolean getfirstTime() {return firstTime;}
	public char getroom() {return room;}

	public String toString() {
		return "\nName: "+getname()+ "\nIC Number: "+getICNumber()+"\nFlight: "+getfligt()+
				"\nDeposit: "+String.format("RM%.2f",getdeposit())+ "\nFirst timer: "+this.getfirstTime()+"\nRoom: "+this.getroom();
	}
	@Override
	public double caclulateCharge() {
		double charge=0.00;
		double totalcharge=0.00;
		if(room == 'A')
			charge=3000;
		else if(room == 'B')
			charge = 2000;
		else if(room == 'C')
			charge = 1000;
		
		totalcharge=charge+10000;
		return totalcharge ;
	}
}
class UmrahApplicant extends EZTravelApplicant{
	private char umrahPackage;
	static int numofapplicant;
	
	public UmrahApplicant(String name,String ICNumber,char fligt,double deposit,char umrahPackage) {
		super(name,ICNumber,fligt,deposit);
		this.setumrahPackage(umrahPackage);
		numofapplicant++;
	}
	
	public void setumrahPackage(char umrahPackage) {this.umrahPackage=umrahPackage;}
	public char getumrahPackage() {return umrahPackage;}
	
	public String toString() {
		return "\nName: "+getname()+ "\nIC Number: "+getICNumber()+"\nFlight: "+getfligt()+
				"\nDeposit: "+String.format("RM%.2f",getdeposit())+"\nUmrah Package: "+getumrahPackage();

	}

	@Override
	public double caclulateCharge() {
		double charge=0.00;
		
		if(umrahPackage == '1')
			charge = 8000;
		else if (umrahPackage == '2')
			charge = 9000;
		else if (umrahPackage == '3')
			charge = 10000;
		return charge;
	}
	
}

public class Main {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EZTravelApplicant applicant [] = new EZTravelApplicant [100];
	    Scanner sc = new Scanner(System.in);
	    Scanner db = new Scanner(System.in);
	    
		int numofapplicant = 0;

	    boolean Continue=true;
	    while(Continue) {
	    boolean CNYN= true;
	    int ctr =0;
	    char cont=' ';
	    while(CNYN) {
	    	
	    	
				System.out.print("Enter name: ");
				String name = sc.nextLine();
				System.out.print("Enter ICNumber: ");
				String ICNumber = sc.nextLine();
				System.out.print("Enter fligt: ");
				char fligt = Character.toUpperCase(sc.next().charAt(0));
				System.out.print("Enter deposit: ");
				double deposit = db.nextDouble();
				System.out.print("Enter your choice(Hajj-1/Umrah-2):");
				int choice = db.nextInt();
				
				if(choice == 1) {
					System.out.print("Are you first timer?(true/false): ");
					boolean firstTimer = sc.nextBoolean();
					System.out.print("Please pick a room: ");
					char room = Character.toUpperCase(sc.next().charAt(0));
					sc.nextLine();
					applicant [ctr] = new HajApplicant(name,ICNumber,fligt,deposit,firstTimer,room);
				}
				else if (choice == 2 ) {
					System.out.println("1- Umrah Direct Flight");
					System.out.println("2- Umrah Ramadhan");
					System.out.println("3- Umrah School Holiday");
					
					System.out.print("\nChoose a umrah package: ");
					char umrahpackage = Character.toUpperCase(sc.next().charAt(0));
					sc.nextLine();
					applicant [ctr] = new UmrahApplicant(name,ICNumber,fligt,deposit,umrahpackage);
				}
				
				
				
				System.out.print("Do you want to continue[Y/N]:");
				cont= Character.toUpperCase(sc.next().charAt(0));
				System.out.println("\n");
				if(cont =='Y' ) {
					CNYN = true;
					ctr++;
				}
					
				else if(cont == 'N') {
					CNYN = false;
				}
					
				
				 sc.nextLine();
			
	    }//use static field of UmrahApplicant class
	    if(UmrahApplicant.numofapplicant>0) {
	    //Display each applicant’s name and total applicant who want to go Umrah during Ramadan.
	    System.out.println("Applicant that want go Umrah during Ramadan ");
	    System.out.println("Applicant's Name ");
	   ctr=1;
	    for(int i =0;i<applicant.length;i++) {
	    	//UmrahApplicant temp = (UmrahApplicant) applicant[i];//cast down
	    	if(applicant[i] instanceof UmrahApplicant) {
	    	if(((UmrahApplicant) applicant[i]).getumrahPackage()== '2') {
	    		System.out.println(ctr+". "+applicant[i].getname());
	    		ctr++;
	    		//numofapplicant ++;
	    	}
	    	}
	    }
	    }
	    System.out.println("\nNumber of applicant who want to go Umrah during Ramadan: "+UmrahApplicant.numofapplicant);//use static field of UmrahApplicant class
	    
	    //Find and display the applicant’s detail based on IC number given by the user. Display also the balance he/she needs to pay.
	    System.out.print("\nFind applicant's details?[Y/N]: ");
		cont= Character.toUpperCase(sc.next().charAt(0));
		if(cont == 'Y') {
			sc.nextLine();
			System.out.print("Enter applicant's Ic Number : ");
			String findIC = sc.nextLine();
		ctr=1;
		double balance=0.00;
		//int k=0;
			for(int i=0;i<applicant.length;i++) {
				if(findIC.equalsIgnoreCase(applicant[i].getICNumber())) {
					//k=i;
					if(applicant[i] instanceof UmrahApplicant) {
					System.out.println(""+applicant[i].toString());
					balance=applicant[i].caclulateCharge()-applicant[i].getdeposit();
					System.out.print("The balance that needs to pay: "+String.format("RM%.2f", balance));
					}
					else if(applicant[i] instanceof HajApplicant) {
						System.out.println(""+applicant[i].toString());
						balance=applicant[i].caclulateCharge()-applicant[i].getdeposit();
						System.out.print("The balance that needs to pay: "+String.format("RM%.2f", balance));
					}
				}
			}
		}
		
	    Continue = false;

	    }
	    }

}
