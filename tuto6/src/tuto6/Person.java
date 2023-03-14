package tuto6;


import java.util.Scanner;

public class Person {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		final int size = 50;
		Info[]personList = new Info[size];
		Info []backupList = new Info[size];
		boolean YN =true;
		int ctr =0;
		while(YN == true) {
				System.out.print("enter name: ");
				String name=sc.nextLine();
				
				System.out.print("enter weight: ");
				double weight=sc.nextDouble();
				
				System.out.print("enter height: ");
				double height=sc.nextDouble();
				sc.nextLine();
				personList[ctr]= new Info(name,weight,height);
				backupList [ctr] = new Info (personList[ctr]);
				System.out.print("Do u want to continue: ");
				char stop=Character.toUpperCase(sc.next().charAt(0)); 
				ctr++;
				if(stop == 'N') {
					YN = false;
				}else if(stop == 'Y'){
					YN = true;
				}
				sc.nextLine();
			
		}
		int PSunderweight=0,Punderweight=0,normal=0,obese=0,VSobese=0;
		
		for(int i=0;i<ctr;i++) {
			if(personList[i].bmiCategory().equalsIgnoreCase("very severely underweight"))
				PSunderweight++;
			else if(personList[i].bmiCategory().equalsIgnoreCase("underweight"))
				Punderweight++;
			else if(personList[i].bmiCategory().equalsIgnoreCase("Normal"))
				normal++;
			else if(personList[i].bmiCategory().equalsIgnoreCase("obese"))
				obese++;
			else if(personList[i].bmiCategory().equalsIgnoreCase("very severely obese"))
				VSobese++;
		}
		
		
		System.out.println("*************************");
		System.out.println("Very severely underweight: "+
				PSunderweight);
		System.out.println("Underweightt: "+
				Punderweight);
		System.out.println("Normal: "+
				normal);
		System.out.println("Obese: "+
				obese);
		System.out.println("Very severely obese: "+
				VSobese);
		

	}

}
