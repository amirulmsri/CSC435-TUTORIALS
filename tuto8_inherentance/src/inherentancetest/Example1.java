package inherentancetest;

public class Example1 {
	private int idNum;
	private double balance;
	
	public Example1(int id, double bal)
	{
	     idNum = id;
	     balance = bal;
	}
	public void display()
	{
	    System.out.println("Customer Num "+ idNum + "\nBalance RM " + balance);
	 }

}

