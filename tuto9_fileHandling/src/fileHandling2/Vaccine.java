package fileHandling2;

import java.io.*;
import java.util.StringTokenizer;

public class Vaccine {

	public static void main(String[] args) {

			try {
				FileReader fr = new FileReader("vaccination.txt");
				BufferedReader bf = new BufferedReader(fr);
				FileWriter fw = new FileWriter("comorbid.txt");
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter pw = new PrintWriter(bw);
				
				FileWriter fw1 = new FileWriter("non_comorbid.txt");
				BufferedWriter bw1 = new BufferedWriter(fw1);
				PrintWriter pw1 = new PrintWriter(bw1);
				
				pw.println("List of Comorbid\n");
				pw.println(String.format("%-25s", "Vaccination Center")+String.format("%15s", "IC Number")+String.format("%20s", "Vaccine Type")
				+String.format("%10s", "Dose"));
				pw.println("=====================================================================");
				
				pw1.println("List of non-Comorbid\n");
				pw1.println(String.format("%-25s", "Vaccination Center")+String.format("%15s", "IC Number")+String.format("%20s", "Vaccine Type")
				+String.format("%10s", "Dose"));
				pw1.println("=====================================================================");
				String input = null;
				while((input = bf.readLine())!= null) {
					
					StringTokenizer st = new StringTokenizer(input,":");
					String vc = new String(st.nextToken());
					String ic = new String(st.nextToken());
					String cat = new String (st.nextToken());
					String type = new String (st.nextToken());
					int dose = Integer.parseInt(st.nextToken());
					
					
					if ((ic.substring(8,10)).equalsIgnoreCase("01")&& dose == 3) {
						System.out.println(vc+""+ic+""+cat+""+type+""+dose);
					}
					if(type.equalsIgnoreCase("comorbid"))
					pw.println(String.format("%-25s", vc)+String.format("%15s", ic)+String.format("%20s",type )+String.format("%10s", dose));	
					
					else
						pw1.println(String.format("%-25s", vc)+String.format("%15s", ic)+String.format("%20s",type )+String.format("%10s", dose));	
				
					
				}
				bf.close();
				pw.close();
				pw1.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

}
