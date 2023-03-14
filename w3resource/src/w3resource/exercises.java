package w3resource;

import java.util.Scanner;

public class exercises {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] elements = { 
                { 60, 80, 75, 33 }, 
                { 47, 21, 23, 7, 19 }, 
                { 66, 91, 15, 18, 3 } 
                };
		
		for (int i=0;i<elements.length;i++) {
			System.out.println();
			
			for(int j=0;j<elements[i].length; j++) {
				System.out.print(elements[i][j] + " ");
			}
		}
	
	}


}
