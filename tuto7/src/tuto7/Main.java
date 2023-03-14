package tuto7;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int size=10;
		Fruit [] fruit = new Fruit [size];
		Fruit [] copyfruit = new Fruit [size];
		Scanner sc = new Scanner(System.in);
		Scanner db = new Scanner(System.in);
		int ctr=2;

		for(int i=0;i<ctr;i++) {
			System.out.print("Enter fruit type["+(i+1)+"]: ");
			String type=sc.nextLine();
			System.out.print("Enter fruit weigh["+(i+1)+"]: ");
			double weight=db.nextDouble();
			System.out.print("Enter fruit price["+(i+1)+"]: ");
			double price = db.nextDouble();
			fruit[i] = new Fruit(type,weight,price);
			copyfruit[i]=new Fruit (fruit[i]);
			boolean local= fruit[i].isLocal();
			System.out.println(copyfruit[i].pricePerKg);
			//ctr++;
			}
		
		
		
		sc.close();
		db.close();
	}
}
