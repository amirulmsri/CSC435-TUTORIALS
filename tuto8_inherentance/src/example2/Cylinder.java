package example2;

public class Cylinder extends Circle
{
//class variable declaration section
// additional data member
	 private double height;  
	// constructor   
	   public Cylinder(double r, double h)
	   {     super(r);
		   height = h;
	    }
	   
	// calculate a volume of cylinder   
	   public double calcVal() 
	  {    return (calcArea() * height);   }
	// display information
	public void display()
	{
	    System.out.println( super.PI + " " +   radius + " " + height);
	 }
	}