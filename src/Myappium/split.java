package Myappium;
import java.io.*;  
import java.util.Scanner;  
public class split
{
	public static void main(String[] args) throws IOException {
        int split;      
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("\n Enter The count to split each file :-----------");
        int  s = reader.nextInt();
        File folder = new File("D://user credentials//combine.csv");                                //*** Location of your file 
        int filecount = 0;
            for (File fo :
            folder.listFiles()) {
                    if (fo.isFile()) {
                            filecount++;}
                        }
        System.out.println("Total source file count is :-----------------------    "+filecount+"\n");  //*** Total Orginal file of the mentioned folder
        String path = folder.getAbsolutePath();
       // System.out.println("location=-----------"+path);
        File[] listOfFiles = folder.listFiles();
        for (int l = 0; l < listOfFiles.length; l++) {
         if (listOfFiles[l].isFile()) {
           System.out.println("File name Is :--------------------------   " + listOfFiles[l].getName());  //*** File name
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path+"/"+listOfFiles[l].getName()));   // Read a souce file
            String input;
            int count = 0;
            while((input = bufferedReader.readLine()) != null)
            {
             count++;
            }  
     System.out.println("File total rows count is :--------------   "+count);   //*** Number of row count in the file
     split= count/s;
    
     int n = split,z=0;
     if(n!=z)
     {
      System.out.println("Each splitted file line count is :------   "+split+"\n"); //*** After splitted  file have the rows count
      FileInputStream fstream = new FileInputStream(path+"/"+listOfFiles[l].getName()); DataInputStream in = new DataInputStream(fstream);  
      BufferedReader br = new BufferedReader(new InputStreamReader(in)); String strLine;  
      for (int j=1;j<=s;j++)  
       {  
        File dir = new File(path+"/"+"CSV_DATA_"+j);
        dir.mkdir(); 
        File filefolder = new File(path+"/"+"CSV_DATA_"+j);
        String folderpath = filefolder.getAbsolutePath();         
        //********Destination File Location******
        FileWriter fstream1 = new FileWriter(folderpath+"/"+listOfFiles[l].getName()+".csv");   //*** Splitted files  and file format(.txt/csv.....)
        BufferedWriter out = new BufferedWriter(fstream1);   
        for (int i=1;i<=n;i++)  
         {  
         strLine = br.readLine();   
         if (strLine!= null)  
           {  
           out.write(strLine);   
            if(i!=n)  
             {  
             out.newLine();  
             } 
            }     
          }  
          out.close(); 
              } 
  in.close();  
    }  
    else
    	{// Below N number of row in this file
            System.out.println("\n******************************* Mentioned this file have below - "+s+" rows   ******************************   "+listOfFiles[l].getName()+" \n");}
       }
}
System.out.println("\n Splitted_CSV_files stored location is :     "+path);
 }
}
 

