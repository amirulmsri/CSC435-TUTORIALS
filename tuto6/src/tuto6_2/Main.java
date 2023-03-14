package tuto6_2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int size = 50;
		Scanner sc = new Scanner (System.in);
		UITMStaff[] UITMStaffList = new UITMStaff[size];
		int ctr=0;
		boolean ike =true , cont =true;
		
		while(cont == true) {
			//menu
			System.out.println("\n\n1. Enter Staff information");
			System.out.println("2. Calculate and display the total salary of all staffs");
			System.out.println("3. Search Staff information");
			System.out.println("4. Exit the program");
			System.out.print("Choose your option: ");
			int option=sc.nextInt();
			sc.nextLine();
			if(option == 1) {
				while(ike==true) {
					System.out.print("\nEnter staffID: ");
					String id = sc.nextLine();
					System.out.print("Enter name: ");
					String name = sc.nextLine();
					System.out.print("Enter salary: ");
					double salary = sc.nextDouble();
					System.out.print("Enter department: ");
					char department = Character.toUpperCase(sc.next().charAt(0));
					
					UITMStaffList[ctr] = new UITMStaff(id,name,salary,department);
					
					System.out.print("Do u want to stop: ");
					char stop = Character.toUpperCase(sc.next().charAt(0));
					if(stop == 'Y')
						ike = false;
					else if(stop == 'N')
						ctr++;
					sc.nextLine();
				}
				
			}else if (option == 2) {
				System.out.println("Total salary for all staffs is RM"+UITMStaff.totalsalary);
				System.out.println("Number of staff from Academic department is "+UITMStaff.staffA);
			}
			else if (option == 3) {
				System.out.print("Enter the Staff ID: ");
				String findID=sc.nextLine();
				//System.out.println(ctr);
				searchID(UITMStaffList,findID,ctr);
			}else if (option == 4) {
				cont = false;
			}
			
		}

	}
	public static void searchID(UITMStaff[] UITMStaffList,String findID,int ctr) {
		
		for(int i =0;i< UITMStaff.totalstaff;i++) {
			if(UITMStaffList[i].getid().equals(findID))
				System.out.print (UITMStaffList[i].toString()); 
		}
		
			
	}

	
}
