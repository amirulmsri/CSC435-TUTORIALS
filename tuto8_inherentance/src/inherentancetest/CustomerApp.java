package inherentancetest;

	public class CustomerApp
	{
	public static void main (String[] args)
	{
	  Example1 C = new Example1(123, 25.00);
	  RegularCustomer R = new RegularCustomer(111, 37.50, 0.25);
	   C.display();
	   R.display();
	   }
	}


