package fileHandling;

import java.io.*;
import java.util.StringTokenizer;

public class ReadFile {

	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("juz30.txt");
			BufferedReader br = new BufferedReader(fr);
			FileWriter fw = new FileWriter("above20juz30.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			int verseU20=0;
			int verseM20=0;
			int numrecord =0;
			String input = null;
			
			System.out.println("List of Surah that less than or equal to 20");
			System.out.println("Name of Surah"+"\t\t\t"+"Verses");
			while((input = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(input,";");
				//while(st.hasMoreTokens()) {
				    int noSurah = Integer.parseInt(st.nextToken());
					String nameSurah = st.nextToken();
					int verses = Integer.parseInt(st.nextToken());
					String nuzul = st.nextToken();
					
					if(verses <= 20) {
						System.out.println(nameSurah+"\t\t\t\t"+ verses);
						verseU20 += verses;
					}
					else {
						pw.println(noSurah+";"+nameSurah+";"+verses+";"+nuzul);
						numrecord++;
						verseM20 +=verses;
					}
				//}
			}
			System.out.println("Total verse for all surah: "+ verseU20);
			br.close();
			System.out.println("Total verse for all Surah: "+ verseM20);
			System.out.println("Number of record: "+ numrecord);
			pw.close();
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		

	}

}
