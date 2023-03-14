package example2;

public class CircleInheritApp {
	public static void main (String[] args)
	{
	  Circle cir = new Circle (2.50);
	  Cylinder cyl = new Cylinder (3, 4);
	   System.out.println("The area of circle : " + cir.calcArea());
	   System.out.println("The area of cylinder : " + cyl.calcArea());
	   System.out.println("The volume of a cylinder : " + cyl.calcVal());
	   cir.display();
	   cyl.display();
	  
	 }

}
