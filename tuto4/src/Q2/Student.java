package Q2;

import java.util.Scanner;


class Second{
	private String matricID;
	private String programmeCode;
	private int part;
	private double cgpa;
	
	//Constructor
	Second( String matricID,String programmeCode,int part,
			double cgpa){
		
		this.matricID = matricID;
		this.programmeCode = programmeCode;
		this.part = part;
		this.cgpa = cgpa;
	}
	
	//Accesssor
	public String GetmatricID() {
		return matricID;
	}
	public String GetprogrammeCode() {
		return programmeCode;
	}
	public int Getpart() {
		return part;
	}
	public double Getcgpa() {
		return cgpa;
	}
	
	//Processor
	public  String faculty(Second myStudent ) {
	
		
		if (myStudent.programmeCode.substring(0,2).equalsIgnoreCase("AM"))
			return("Faculty of Administrative Science and Policy Studies");
		else if(myStudent.programmeCode.substring(0,2).equalsIgnoreCase("BM"))
			return("Faculty of Business and Management");
		else if(myStudent.programmeCode.substring(0,2).equalsIgnoreCase("CS"))
			return("Faculty of Computer and Mathematical Sciences");
		else
		return "XXX";
	}
	
}
public class Student {
	
	
		

	public static void main(String[] args) {
		
		//String[] programmeCode = {"AM110","BM111","BM119","CS110","CS111"};		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("matricID: ");
		String matricID=sc.nextLine();
		
		System.out.print("programmeCode: ");
		String programmeCode=sc.nextLine();
		
		System.out.print("Part: ");
		int part=sc.nextInt();
		
		System.out.print("Cgpa: ");
		double cgpa=sc.nextDouble();
		
		Second myStudent = new Second(matricID,programmeCode,part,cgpa);
		String faculty_name = myStudent.faculty(myStudent);
		System.out.println("\nMatric ID : "+matricID);
		System.out.println("Faculty name : "+faculty_name);

	}

	

}
