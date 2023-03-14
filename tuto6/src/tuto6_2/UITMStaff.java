package tuto6_2;

public class UITMStaff {
	private String id;			
	private String name;
	private double salary;
	private char department; // ‘A’ = Academic, ‘M’ = Management
	static int staffA;
	static int totalstaff;
	static double totalsalary;

	//normal constructor
	public UITMStaff(String id,String name,double salary,char department) {
		this.setid(id);
		this.setname(name);
		this.setsalary(salary);
		this.setdepart(department);
		totalstaff ++;
		totalsalary+=this.salary;
		NumofStaff();
	}
	//retrivers
	
	public String getid(){return id;}
	public String getname(){return name;}
	public double getsalary(){return salary;}
	public char getdepart(){return department;}
	
	public void setid(String id){this.id =id;}
	public void setname(String name){this.name =name;}
	public void setsalary(double salary){this.salary =salary;}
	public void setdepart(char department){this.department =department;}

	
	//toString
	 @Override
	public String toString() {
		return "\nStaff ID: "+this.id+"\n"+"Staff Name: "+this.name+
				"\n"+"Staff Salary: RM"+this.salary+"\n"
				+"Staff Department: "+this.department;
	}
	
	public double Calctotalsalary() {return totalsalary;}
	
	public void NumofStaff() {
		if(this.department == 'A')
			staffA++;
	}
	
	
	
}

