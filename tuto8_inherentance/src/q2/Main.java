package q2;

class Person{
	protected String name;
	protected String ic;
	protected double salary;
	
	public Person(String name, String ic, double salary) {
		this.name=name;
		this.ic=ic;
		this.salary=salary;
	}
	
}
class Instructor extends Person{
	private String fieldName;
	private int LevelofExpertise;
	
	
	public Instructor(String name,String ic,double salary,String fieldName,
			int LevelofExpertise ) 
	{
		super(name,ic,salary);
		this.fieldName=fieldName;
		this.LevelofExpertise=LevelofExpertise;
		
	}
	
	public void setdata(String fieldName,int LevelofExpertise) {
		this.fieldName=fieldName;
		this.LevelofExpertise=LevelofExpertise;
	}
	
	public String getfieldName() {return fieldName;}
	public int getLevelofExpertise() {return LevelofExpertise;}
	
	public boolean fromTerengganu() {
		if(super.ic.substring(6,8).equals("11"))
		return true;
		else 
			return false;
		
	}
	
	public char detCategory() {
		char detCategory='I';
		if(fieldName.equalsIgnoreCase("Computer Science")) {
			if(LevelofExpertise>=1 && LevelofExpertise<=3)
				detCategory= 'B';
			else if(LevelofExpertise>=4 && LevelofExpertise<=5)	
				detCategory= 'A';
		}
		else if(fieldName.equalsIgnoreCase("Mathematic")) {
			if(LevelofExpertise>=1 && LevelofExpertise<=3)	
				detCategory= 'A';
			else if(LevelofExpertise>=4 && LevelofExpertise<=5)	
				detCategory= 'A';
			}
		else if(fieldName.equalsIgnoreCase("Bussiness")) {
			if(LevelofExpertise>=1 && LevelofExpertise<=4)
				detCategory= 'B';
			else if (LevelofExpertise==5)
				detCategory= 'A';
		}
		else 
			detCategory= 'I';
		
		return detCategory;
	}
	
}

class Manager extends Person{
	private String department;
	private double sales;
	
	  public Manager(){ 
		  super("anonymous","xxxxxxxxxxxx",600.00);
		  department = "Financial";
		  sales = 10000.00;
	  }
	 
	public Manager(String name2, String ic2, double salary2,String department,double sales) {
		super(name2, ic2, salary2);
		this.department=department;
		this.sales=sales;
	}
	
	public void setdata(String department,double sales) {
		this.department=department;
		this.sales=sales;
	}
	public String getdepartment() {return department;}
	public double getsales() {return sales;}
}
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

}
