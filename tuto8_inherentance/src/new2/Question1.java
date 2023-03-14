package new2;

import java.util.Scanner;



 abstract class Hospital{
	protected String name;
	protected String gender;
	protected int age;
	
	Hospital(String name, String gender, int age){
		this.setName(name);
		this.setGender(gender);
		this.setAge(age);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public abstract double calcCharges();
}

class Inpatient extends Hospital{
	private int wardType;
	private int day;
	private double treatmentFee;
	
	Inpatient(String name, String gender, int age, int wardType, int day, double treatmentFee){
		super(name, gender, age);
		this.setWardType(wardType);
		this.setDay(day);
		this.setTreatmentFee(treatmentFee);
	}

	public int getWardType() {
		return wardType;
	}

	public void setWardType(int wardType) {
		this.wardType = wardType;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public double getTreatmentFee() {
		return treatmentFee;
	}

	public void setTreatmentFee(double treatmentFee) {
		this.treatmentFee = treatmentFee;
	}
	
	public double calcCharges() {
		double charges;
		if(wardType == 1) {
			charges = 350;
		}
		else if(wardType == 2) {
			charges = 250;
		}
		else
			charges = 100;
		
		if(getAge() > 60) {
			charges/=2;
		}
		
		return charges + getTreatmentFee();
	}
}

class Outpatient extends Hospital{
	private double consultationFee;
	private double medicineFee;
	private String consultationDate;
	
	Outpatient(String name, String gender, int age, double consultationFee, double medicineFee, String consultationDate) {
		super(name, gender, age);
		this.setConsultationFee(consultationFee);
		this.setMedicineFee(medicineFee);
		this.setConsultationDate(consultationDate);
	}

	public double getConsultationFee() {
		return consultationFee;
	}

	public void setConsultationFee(double consultationFee) {
		this.consultationFee = consultationFee;
	}

	public double getMedicineFee() {
		return medicineFee;
	}

	public void setMedicineFee(double medicineFee) {
		this.medicineFee = medicineFee;
	}

	public String getConsultationDate() {
		return consultationDate;
	}

	public void setConsultationDate(String consultationDate) {
		this.consultationDate = consultationDate;
	}
	
	public double calcCharges() {
		if(getAge() > 60)
			return (consultationFee + medicineFee)/2;
		else
			return consultationFee + medicineFee;
	}
}

public class Question1 {

	public static void main(String[] args) {
		Scanner scanS = new Scanner(System.in);
		Scanner scanD = new Scanner(System.in);
		
		boolean Continue = true;
		while(Continue) {
			boolean invalid = true;
			char ptype = 0;
			
			while(invalid) {
				System.out.print("Which type? \n[I]npatient \n[O]utPatient \n>>");
				ptype = Character.toUpperCase(scanS.nextLine().charAt(0));
				
				if(ptype == 'I' || ptype == 'O') {
					invalid = false;
				}
				else
					System.out.println("Invalid input! Please Try again.");
			}
			
			System.out.print("Enter patient name: ");
			String name = scanS.nextLine();
			
			String gender = "Unknown";
			invalid = true;
			while(invalid) {
				System.out.print("Gender? [M]ale [F]emale: ");
				char g = Character.toUpperCase(scanS.nextLine().charAt(0));
				
				if(g == 'M') {
					invalid = false;
					gender = "Male";
				}
				else if(g == 'F') {
					invalid = false;
					gender = "Female";
				}
				else
					System.out.println("Invalid input! Please try again.");
			}
			
			System.out.print("Enter age: ");
			int age = scanD.nextInt();
			
			if(ptype == 'I') {
				Inpatient ipatient = new Inpatient(name, gender, age, 0, 0, 0);
				
				invalid = true;
				while(invalid) {
					System.out.print("Enter ward type: ");
					ipatient.setWardType(scanD.nextInt());
					
					if(ipatient.getWardType() == 0 || ipatient.getWardType() > 3) {
						System.out.println("Invalid input! Please try again.");
					}
					else
						invalid = false;
				}
				
				
				System.out.print("Enter day in ward: ");
				ipatient.setDay(scanD.nextInt());
				
				System.out.print("Enter treatmentFee: RM");
				ipatient.setTreatmentFee(scanD.nextDouble());
				
				System.out.println("The total charges is RM" + ipatient.calcCharges());		
			}
			else {
				Outpatient opatient = new Outpatient(name, gender, age, 0, 0, "Unknown");
				
				System.out.print("Enter consultation fee: RM");
				opatient.setConsultationFee(scanD.nextDouble());
				
				System.out.print("Enter medicine fee: RM");
				opatient.setMedicineFee(scanD.nextDouble());
				
				System.out.print("Enter consultation date: ");
				opatient.setConsultationDate(scanS.nextLine());
				
				System.out.println("The total charges is RM" + opatient.calcCharges());
			}
			
			invalid = true;
			while(invalid) {
				System.out.print("\nDo you want to continue next patient? [Y]es [N]o: ");
				char yesorno = Character.toUpperCase(scanS.nextLine().charAt(0));
				
				if(yesorno == 'Y') {
					invalid = false;
				}
				else if(yesorno == 'N') {
					invalid = false;
					Continue = false;
				}
				else
					System.out.println("Invalid input! Please try again.");
			}
			
			  Hospital [] patient = new Hospital[100]; 
			  for(int i=0; i<patient.length; i++)
			  { if (patient[i] instanceof Inpatient) { 
				  Inpatient temp =(Inpatient)patient[i];
				  temp.getGender().equalsIgnoreCase("Female");
			  System.out.println("Female :" + temp.getGender()); } }
			  
			  for(int i=0;i<patient.length; i++) {
				  if (patient[i] instanceof Inpatient) {
					  Inpatient temp = (Inpatient)patient[i];
					  if(temp.getDay()>10) {
						  //countPa++;
						  //SOP
					  }
				  }
			  }
			  double totcharges=0.00;
			  for(int i=0; i<patient.length;i++) {
				  if(patient[i] instanceof Outpatient) {
					  Outpatient temp =(Outpatient)patient[i];
					 if(temp.getConsultationDate().substring(3,10).equalsIgnoreCase("10/2018"))
						  totcharges += temp.calcCharges();
				  }
			  }
			  System.out.print("Total :RM"+totcharges);
			 
		}
		
		scanS.close();
		scanD.close();
	}
}