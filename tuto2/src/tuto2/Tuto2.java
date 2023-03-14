package tuto2;

import java.util.Scanner;

public class Tuto2 {
	

//b.Calculate the sum of even numbers from 100 to 200
static int FindSum(){
		
		int sum=0;
	for(int i=100;i<=200;i++) {
		if(i%2==0)
			sum+=i;	
	}
		return sum;
	}
//a.Get two numbers from the user and print the larger number
static void largerNum(Scanner sc) {
	int num1,num2;
	//sc = new Scanner(System.in);
		System.out.print("Enter first number: ");
		num1 = sc.nextInt();
		
		System.out.print("Enter second number: ");
		num2 = sc.nextInt();
	
	
	if(num1 > num2)
		System.out.println("Result: "+num1 +" is the larger number ");
	else if(num2 > num1)
		System.out.println("Result: "+num2 +" is the larger number ");
	else if(num1 == num2)
		System.out.println("Both numbers are equal");
	else {
		System.out.println("Invalid output");
	}
	

}
//c.
static void displayNum(Scanner sc) {
	System.out.println("Enter a number: ");
	//sc2 = new Scanner(System.in);
	int inputNum=sc.nextInt();
	
	if (inputNum %2 ==0)
		System.out.println("The number "+ inputNum +" is an even number");
	else if(inputNum %2 != 0) {
		inputNum++;
		System.out.println("The new number is "+ inputNum);
	}
	
	
		
}
//d.
public void patient(Scanner sc,int[] bloodPressure, int[] sugarLevel, int numP) {
	
	int bpCtr=0,slCtr=0, HPCtr=0;
	for(int i =0;i<numP;i++) {
		if(bloodPressure[i] > 130 && sugarLevel[i] >=10) {
			bpCtr++;
			slCtr++;
			HPCtr++;
		}
		else if(sugarLevel[i] >= 10 && bloodPressure[i]<=130)
		    slCtr++;
		else if(bloodPressure[i]>130 && sugarLevel[i]<10)
			bpCtr++;
	}
	
	System.out.println("\nNumber of patient with high blood pressure: "+bpCtr); 
	System.out.println("\nNumber of patient with diabetes: "+slCtr); 
	System.out.println("\nNumber of patient with serious health problems: "+HPCtr); 
} 


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//largerNum(sc);
		//int total = FindSum();
		//System.out.println(total);
		//displayNum(sc);
		
		
		
		Tuto2 info = new Tuto2();
		int numPatient=0;
		int []bloodPressure = new int[10],sugarLevel= new int[10];
		boolean continueYN=true;
		int input,i=0,j=0;
		
		
		
		while(continueYN == true) {
			System.out.print("Enter number of patient: ");
			numPatient += sc.nextInt();
			
			for(i=j;i<numPatient;i++) {
			System.out.print("Enter your Blood Pressure for patient["+(i+1)+"]: ");
			bloodPressure[i] = sc.nextInt();
			System.out.print("Enter your Sugar Level for patient["+(i+1)+"]: ");
			sugarLevel [i]= sc.nextInt();
			
		}
		//System.out.print(bloodPressure[1]);
		info.patient(sc, bloodPressure, sugarLevel,numPatient);
		
		System.out.println("\nDo you want to continue?[0-No/1-Yes]");
		input = sc.nextInt();
		if(input == 1) {
			continueYN = true;
			j+=numPatient;
		}
			
		else if (input == 0)
			continueYN = false;
		}
		
		


	}
	
	

}
