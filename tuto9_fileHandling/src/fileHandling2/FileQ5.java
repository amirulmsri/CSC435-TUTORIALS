package fileHandling2;

import java.io.*;
import java.util.StringTokenizer;

public class FileQ5
{
   public static void main(String[]args)
   {
    
      
      try
      {
         FileReader fr = new FileReader("Flight.txt");
         BufferedReader br = new BufferedReader(fr);
         
         FileWriter fw = new FileWriter("Indonesia.txt");
         BufferedWriter bw = new BufferedWriter(fw);
         PrintWriter pw = new PrintWriter(bw);
         
        // String code, Captname, dest;
         int adult=0,numchild=0, child=0, numadult=0, count=0, avgadult=0, avgchild=0;
         String input = null;
         while((input=br.readLine())!=null)
         {
            StringTokenizer st = new StringTokenizer(input, "/");
            
            String code = st.nextToken();
            String Captname = st.nextToken();
            String dest = st.nextToken();
            adult = Integer.parseInt(st.nextToken());
            child = Integer.parseInt(st.nextToken());
            
            if (Captname.equalsIgnoreCase("Ahmad Hasif"))
            {
               System.out.println("FLIGHT CODE : " + code);
               System.out.println("CAPTAIN : " + Captname);
               System.out.println("DESTINATION : " + dest);
               System.out.println("ADULT : " + adult);
               System.out.println("CHILD : " + child);        
            }
            
            if (dest.indexOf("[Indonesia]") != -1)
            {
               pw.println(code + "/" + Captname + "/" + dest + "/" + adult + "/" + child);
               numadult = numadult + adult;
               numchild = numchild + child;
               count++;
            }
            
         }
         avgadult = numadult/count;
         avgchild = numadult/count;
         pw.println("Average Number of Adults per flight : " + avgadult);
         pw.println("Average Number of Children per flight : " + avgchild);
         
         bw.close();
         br.close();
         pw.close();
                
      }
      catch(FileNotFoundException e)
      { 
         System.out.println("Problem : " + e.getMessage());
      }
      catch(IOException io)
      {
         System.out.println("Problem : " + io.getMessage()); 
      }
   }
}
