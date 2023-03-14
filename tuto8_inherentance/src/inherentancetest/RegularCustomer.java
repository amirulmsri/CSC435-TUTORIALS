package inherentancetest;

	public class RegularCustomer extends Example1
	{
	   private double discount;  
	   public RegularCustomer(int id, double bal, double disc)
	   {     super(id, bal);
	         discount = disc;
	    }
	   
	    public void display()
	    {
	         super.display();
	         System.out.println("Discount is " + discount);
	    }
	   }


