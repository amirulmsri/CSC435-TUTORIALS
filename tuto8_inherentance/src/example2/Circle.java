package example2;

public class Circle
{
//class variable declaration section
   public final static double PI = 3.142;
   protected double radius;
// constructor   
   public Circle(double r)
   {     radius = r;     }
   
// calculate the area of a circle   
   public double calcArea() 
  {    return (PI * radius * radius);    }
// display information
public void display()
{
    System.out.println( PI + " " + radius);
 }
}
