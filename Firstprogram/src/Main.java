import java.util.Scanner;

import javax.swing.JOptionPane;
//import java.lang.Math;
public class Main {

	public static void main(String[] args) {
		
		double x,y,z;
		
		/*Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter side x: ");
		x = scanner.nextDouble();
		
		System.out.println("Enter side y: ");
		y = scanner.nextDouble();*/
		
		
		
		x = Double.parseDouble(JOptionPane.showInputDialog("Enter value foe side x: "));
		
		y = Double.parseDouble(JOptionPane.showInputDialog("Enter value foe side y: "));
		
		
		z = Math.sqrt((Math.pow(x, 2) + Math.pow(y, 2)));
		
		JOptionPane.showMessageDialog(null, "The value of side z is " + z);
		//System.out.print(z);
		
		secondtest obj = new secondtest();
		System.out.print(obj.abc);
		}

}
