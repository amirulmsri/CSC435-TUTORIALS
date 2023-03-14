package assigment2;

import java.util.*;

abstract class Competitor{
	private String name;
	private String university;

	//normal constructor
	public Competitor(String name,String university) {
		this.setData(name, university);
	}
	public String getName() {return name;}
	public String getUniversity() {return university;}
	
	public void setData(String name,String university) {
		this.name = name;
		this.university = university;
	}
	
	public abstract int calculateTotalPoints();
}

class ChessComp extends Competitor{

	private int numWin;
	private int numLoss;
	private int numDraw;

	public ChessComp(String name, String university,int numWin,int numLoss,int numDraw) {
		super(name, university);
		this.setInfo(numWin, numLoss, numDraw);
	}

	public int getNumWin() {return numWin;}
	public int getNumLoss() {return numLoss;}

	public void setInfo(int numWin,int numLoss,int numDraw) {
		this.numWin = numWin;
		this.numLoss = numLoss;
		this.numDraw = numDraw;
	}
	@Override
	public int calculateTotalPoints() {
		int totalPoints = (numWin*2) + (numLoss*0) +(numDraw*1);
		return totalPoints;
	}
	
}
class ScrabbleComp extends Competitor{

	//Declare the constants for the points awarded for each letter by using HashMap
	private static final HashMap<Character, Integer> scores = new HashMap<>();
	private static final char[] letters = {'A','E','I','L','N','O','R','S','T','U','D',
			'G','B','C','M','P','F','H','V','W','Y','K','J','X','Q','Z'};
	private static final int[] points = {1,1,1,1,1,1,1,1,1,1,2,2,3,3,3,3,4,4,4,4,4,5,8,8,10,10};
	private ArrayList<String> wordUsed = new ArrayList<>() ;
	private int numWords;

	
	public ScrabbleComp(String name, String university,int numWords, ArrayList<String> wordUsed) {
		super(name, university);
		this.setNumWords(numWords);
		this.wordUsed = wordUsed;
		for (int i = 0; i < letters.length; i++) {
			scores.put(letters[i], points[i]);
		  }
	}

	public int getNumWords() {return numWords;}
	public ArrayList<String> getArrayListwordUsed(){return wordUsed;}

	public void setNumWords(int numWords) {this.numWords = numWords;}

	@Override
	public int calculateTotalPoints() {
		int totalpoints=0;
		for(int i =0; i< this.getNumWords();i++) {
			String word = (String)wordUsed.get(i);
			for(int j =0; j<word.length(); j++) {
				char letter = word.charAt(j);
				totalpoints += scores.get(letter);
			}
		}
		return totalpoints;
	}
	
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner (System.in);
		Scanner db = new Scanner (System.in);
	
		//use arrayList bc it is dynamic 
        ArrayList<String> wordUsed = new ArrayList<>() ;
		boolean Cont = true;
		int ctr=0;
		Competitor comp [] = new Competitor[100];

		
			while(Cont) {
				boolean valid = true;
				while(valid) {
					System.out.print("Enter your name: ");
					String name = sc.nextLine();
					System.out.print("Enter yout University: ");
					String uni = sc.nextLine();
					
					System.out.println("\nList of University Indoor Games");
					System.out.println("1. Chess");
					System.out.println("2. Scrabble");
					System.out.print("\nChoose one game:");
					int choice = db.nextInt();
					
					if(choice == 1) {
						System.out.print("Enter number of win: ");
						int numWin = db.nextInt();
						System.out.print("Enter number of loss: ");
						int numLoss = db.nextInt();
						System.out.print("Enter number of draw: ");
						int numDraw = db.nextInt();
						
						comp[ctr]= new ChessComp (name,uni,numWin,numLoss,numDraw);
						}
					else if(choice == 2) {
						System.out.print("Enter number of words: ");
						int numWords = db.nextInt();
						System.out.println("Enter words used: ");
						for(int i =0; i<numWords;i++) {
							String word = sc.nextLine().toUpperCase();
							wordUsed.add(word);
						}
						
						comp[ctr]= new ScrabbleComp (name,uni,numWords,wordUsed);
					}
					ctr++;
					
					//System.out.print(ctr);
					System.out.print("Continue?[Y/N]");
					char YN = Character.toUpperCase(sc.nextLine().charAt(0));
					if(YN == 'N')
						valid = false;
					else if(YN == 'Y')
						valid = true;
				}
			
				
				//Get the name of a university from the user and display the total 
				//points of the university from those competitions.
				System.out.print("\nFind total points of your university from both games [Y/N]: ");
				char disp = Character.toUpperCase(sc.nextLine().charAt(0));
				 int totalChessPoints=0;
					int totalScrabblePoints=0;
					int finalTotalPoints=0;
				 //ChessComp temp = null;
				  if (disp == 'Y') { 
					 
					  System.out.print("\nEnter your university name: ");
					  String uniName = sc.nextLine(); 
					 
				  for(int i =0; i<ctr; i++) {

						  if(uniName.equalsIgnoreCase(comp[i].getUniversity())) {
							  
							  if(comp[i] instanceof ChessComp) {
								  ChessComp temp = (ChessComp) comp[i];
								  totalChessPoints += temp.calculateTotalPoints(); 
							  }
							  if(comp[i] instanceof ScrabbleComp) {
								  ScrabbleComp temp = (ScrabbleComp) comp[i];
								  totalScrabblePoints +=temp.calculateTotalPoints();
							  }
								  
						  }	    
						  finalTotalPoints = (totalScrabblePoints + totalChessPoints);
				  } 
				  System.out.println("Total points for "+ uniName+": "+finalTotalPoints);
				  System.out.println("Scrabble: "+totalScrabblePoints);
				  System.out.println("Chess: "+totalChessPoints);
				}
				  //Display the name of competitors participating in the Scrabble Competition 
				  //and the total number of words formed by the competitor.
				 for(int i = 0; i< ctr; i++) {
					 if(comp[i] instanceof ScrabbleComp) {
						 ScrabbleComp temp = (ScrabbleComp) comp[i];
						 System.out.println("\nDetails of competitors in the Scrabble Competition");
						 System.out.println("Name: "+temp.getName());
						 System.out.println("Total Number of words formed: "+temp.getNumWords());
					 }
				 }
				 Cont = false;

			}
		sc.close();
		db.close();
	}

}
