package tuto8;

class Student{
	
	protected String stdId;
	protected String stdName;
	protected String stdPrg;
	protected double stdCgpa;
	
	public Student(String stdId, String stdName, String stdPrg, double stdCgpa) {
		this.stdId = stdId;
	}
	
    //mutator
	public void setdata(String stdId, String stdName, String stdPrg, double stdCgpa) {
		this.stdId = stdId;
		this.stdName = stdName;
		this.stdPrg = stdPrg;
		this.stdCgpa = stdCgpa;
	}
	//retriever 
	public String getstdId() {return stdId;}
	public String getstdName() {return stdName;}
	public String getstdPrg() {return stdPrg;}
	public double getstdCgpa() {return stdCgpa;}
	
	//printer
	public String toString() {
		return "\nID: "+getstdId()+ "\nName: "+getstdName()+"\nProgramt: "+getstdPrg()+
				"\nCgpa: "+String.format("%.2f",getstdCgpa());
	}
}

class ExcellStudent extends Student{
	boolean mppComitee;
	boolean debator;
	
	public ExcellStudent(String stdId,String stdName,String stdPrg,double stdCgpa,boolean mppComitee,
	boolean debator) {
		super(stdId,stdName,stdPrg,stdCgpa);
		this.setdata(mppComitee, debator);
	}
	//mutator
	public void setdata(boolean mppComitee,boolean debator) {
		this.mppComitee = mppComitee;
		this.debator = debator;
	}
	//retriever 
	public boolean getmppComitee() {return mppComitee;}
	public boolean getdebator() {return debator;}
}

class WeakStudent extends Student{
	private String academicAdvisor;
	private double totalSalary;
	private boolean accomodation;

	public WeakStudent(String stdId2, String stdName2, String stdPrg2, double stdCgpa2,String academicAdvisor,
			double totalSalary,boolean accomodation) {
		super(stdId2, stdName2, stdPrg2, stdCgpa2);
		this.setinfo(academicAdvisor, totalSalary, accomodation);
	}
	//mutator
	public void setinfo(String academicAdvisor,double totalSalary,boolean accomodation) {
		this.academicAdvisor = academicAdvisor;
		this.totalSalary = totalSalary;
		this.accomodation = accomodation;
	}
	//retriever 
	public String getacademicAdvisor() {return academicAdvisor;}
	public double gettotatlSalry() {return totalSalary; }
	public boolean getaccomodation() {return accomodation;}
}
public class Main {

	public static void main(String[] args) {
		
		Student stud[]= new Student[50];
		boolean YN = true;
		//int ctr = 0;
		//Display the student’s id, name and cgps for those who are obtained cgpa more than or equal to 3.75.
		//while(YN) {
			for(int i =0; i<stud.length; i++) {
				if(stud[i].stdCgpa >= 3.75) {
					System.out.print("Student Details");
					System.out.print(stud[i].toString());
				}
			}
			
		//Display the student’s id, name, and program for those who are involved in debate competition and not member of MPP committee.	
			System.out.println("Student Details");
			for(int i=0; i<stud.length; i++) {
				if(stud[i] instanceof ExcellStudent ) {
					ExcellStudent temp = (ExcellStudent) stud[i];
					if(temp.getdebator()== true && temp.getmppComitee() == false) {
						System.out.println("ID      : "+temp.getstdId());
						System.out.println("Name    : "+temp.getstdName());
						System.out.println("Program : "+temp.getstdPrg());
						
					}
				}
			}
		//}
		
	
	}

}
