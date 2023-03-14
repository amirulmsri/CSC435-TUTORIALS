package q2;

import java.util.Scanner;

public class Q2 {
	
	
	public static void displayImprove(String[] id, int[] score1, int[] score2,int player) {
		int k =0;
	for(int i =0; i<player; i++) {
		
		if(score1[i]<score2[i]) {
			k=i;
			//k++;
			System.out.println("player ID that improve their score in the second round: "+id[k]);//k is already 1
		}
		}
	}
	
	public static void averageScore(int[] score1, int[] score2, int player) {
		int round1=0,round2=0;
		
		for(int i =0; i< player; i++) {
			round1+=score1[i];
			round2+=score2[i];
		}
		round1/=player;
		round2/=player;
		System.out.println("The average score for round 1 : "+ round1 );
		System.out.println("The average score for round 2 : "+ round2);

		}
	
	public static void winner(String[] id, int[] score1, int[] score2, int player) {
		int [] totalscore = new int[50];
		
		for(int i = 0; i< player; i++) {
			totalscore[i]= score1[i]+score2[i];	
			}
		int k =0;
		int max = totalscore[0];
		for(int i =1; i< (player+1) ; i++) {
			if(totalscore[i]>max) {
				max=totalscore[i];
				k=i;
			}
		}
		System.out.println("Highest score is " + max);
		System.out.println("Player ID is "+id[k]);
	}
	
	public static void main(String[] args) {
		
	String[] ID = new String [20];
	int size = 50 ;
	int Score1[] = new int [size];
	int Score2[] = new int [size];
	int YN =1,player=0;
	Scanner sc = new Scanner(System.in);
	
	for(int i =0;i<=player;i++) {
		System.out.println("Enter your ID : ");
		ID [i]= sc.nextLine();
		
		System.out.println("Enter your 1st score : ");
		Score1[i]= sc.nextInt();
		
		System.out.println("Enter your 2nd score : ");
		Score2[i]= sc.nextInt();
		
		System.out.println("Do you want to continue : ");
		YN = sc.nextInt();
		player++;
		sc.nextLine();
		if (YN == 0)
			break;
	}
	//displayImprove(ID,Score1,Score2,player);
	
	//averageScore(Score1,Score2,player);
	//winner(ID,Score1,Score2,player);

	}

}
