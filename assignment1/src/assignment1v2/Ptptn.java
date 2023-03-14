package assignment1v2;

import java.util.Scanner;

public class Ptptn {
	static int numStudent;
	static int numScholarship;

	public static class Student{
		//data fields
		private String icNumber;
		private String name;
		private String program;
		private double fCgpa;
		private double loanAmount;
		double totalAmount;
		
		
		//default
		Student(){
		 icNumber="";
         name="";
		 program="";
		 fCgpa=0.00;
		 loanAmount=0.00;
		}
		
		//Normal Constructor
		public Student(String icNumber,String name,String program,double fCgpa,double loanAmount) {
			this.seticNumber(icNumber);
			this.setname(name);
			this.setprogram(program);
			this.setfCgpa(fCgpa);
			this.setloanAmount(loanAmount);
			this.calcScholarship();
			numStudent++;
		}
		// Copy
		
		//Mutator
		public void seticNumber(String icNumber) {this.icNumber=icNumber;}
		public void setname(String name) {this.name=name;}
		public void setprogram(String program) {this.program=program;}
		public void setfCgpa(double fCgpa) {this.fCgpa=fCgpa;}
		public void setloanAmount(double loanAmount) {this.loanAmount=loanAmount;}
		
		//Accessor
		public String geticNumber() {return icNumber;}
		public String getname() {return name;}
		public String getprogram() {return program;}
		public double getfCgpa() {return fCgpa;}
		public double getloanAmount() {return loanAmount;}
		
		//Processor
		public double calcAmountPaid() {
			if (fCgpa > 3.50 && fCgpa <= 4.00) 
				totalAmount = (loanAmount *1.01);
			else if (fCgpa <= 3.50) 
				totalAmount = (loanAmount *1.04);
			return totalAmount;
		}
		//toString
		//use String.format to align the outputs & format double to 2 decimal places
	    public String toString() {
			return String.format("%-20s %-26s %-19s %-13.2f RM%-19.2f", icNumber, name, program,fCgpa,loanAmount);
		}
		//Count number of students that got scholarship.
		public void calcScholarship() {
			if(fCgpa == 4.00)
				numScholarship++;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Scanner db = new Scanner(System.in);
		final String color[] = {"\u001B[54;36m","\u001b[54;31m","\u001b[51;97m","\033[1;33m"};//blue framed off,red framed off,white framed,yellow
		final String reset ="\u001B[0m";//reset style to default
		final int size =100;
		Student ptptnLoan []= new Student[size];
		ptptnLoan[0] = new Student("830211-01-6898","Ain Mardhiah Arif","Diploma",2.80,25000.00);
		ptptnLoan[1] = new Student("800329-05-4555","Faiz Nasir","Degree",3.00,40000.00);
		ptptnLoan[2]= new Student("861121-04-8562","Farisah Farid","Degree",4.00,40000.00);
		ptptnLoan[3] = new Student("850625-06-5781","Nik Syarif Nik Azam","Diploma",3.56,25000.00);
		ptptnLoan[4] = new Student("811014-01-8528","Maria Mariana Mahat","Diploma",2.15,25000.00);
		ptptnLoan[5] = new Student("841230-01-9895","Faisal Abdul Halim","Degree",4.00,40000.00);
		int ctr=6;
			boolean stop = false;
			while(stop==false) {
				
				System.out.println("1. Insert new student informations");
				System.out.println("2. Display the information of all Students");
				System.out.println("3. Exit the program");
				System.out.print("\nPlease choose your option: ");
				int choice = db.nextInt();
				
				if(choice == 1) {
					
					System.out.print("\n"+color[3]+"IC Number: ");
					String icNumber=sc.nextLine();
					System.out.print("Student Name: ");
					String studName=sc.nextLine();
					System.out.print("Student Program: ");
					String studProg=sc.nextLine();
					System.out.print("Final Cgpa :");
					double fCgpa=db.nextDouble();
					System.out.print("Loan Amount :");
					double loanAmount=db.nextDouble();
					ptptnLoan[ctr]=new Student(icNumber,studName,studProg,fCgpa,loanAmount);
					ctr++;
					//Student.numStudent++;
					System.out.print("\n"+reset);
				}
				else if (choice == 2) {
					System.out.println("\n\t\t\t\t"+color[2]+"\t\tStudent Informations\t\t\n");
					System.out.println(String.format("%-20s", "IC NUMBER")+String.format("%10s","NAME")+String.format("%25s","PROGRAM")+String.format("%20s","FINAL CGPA")+
							String.format("%20s", "LOAN AMOUNT(RM)")+String.format("%20s","TOTAL LOAN(RM)"));
					for(int i=0;i<ctr;i++) {
						System.out.println(color[0]+ptptnLoan[i].toString()+String.format("RM%-10.2f", ptptnLoan[i].calcAmountPaid())+"\n");
					}
					System.out.println(reset+"-------------------------------------------------------------------------------------------------------------------");
					System.out.println("\n"+color[2]+"The number of students whose loan was converted to scholarship:"+""+color[1]+numScholarship+reset);
					System.out.print("\n");
				}
				else if (choice == 3) {
					System.out.print("Do you want to stop the program[Y/N]: ");
					char YN = Character.toUpperCase(sc.nextLine().charAt(0));
					System.out.println("");
					if(YN == 'Y')
					   stop=true;
					else if(YN == 'N')
						stop = false;
				}
			}
		
		sc.close();
		db.close();
	}

}

