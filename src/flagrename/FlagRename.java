/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flagrename;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 *
 * @author Dipon
 */
public class FlagRename {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        int count =0;
        File file = new File("ourflag.txt");
	FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
	String line;
	while ((line = bufferedReader.readLine()) != null) {
            String temp = line.substring(line.indexOf("(")+1, line.lastIndexOf(")"));
            temp = temp.substring(temp.indexOf("(")+1,temp.indexOf(")"));
            String[]data = temp.split(",");
            String country = data[0].substring(1,data[0].length()-1);
            String flag;
            flag = data[3].substring(data[3].lastIndexOf(".")+1);
            //tempflag = tempFlag.substring()
            //String targetFlag = tempFlag[0];
            if(flag.contains("599")){
                flag="flag_bonaire_sint_eustatius_and_saba";
            }
            
            File file2 = new File("given.txt");
            FileReader fileReader2 = new FileReader(file2);
            BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
            String targetLine;
            String errorCountry;
            String targetCountry=new String("");
            String targetFlag= new String("");
            while ((targetLine = bufferedReader2.readLine()) != null) {
                String [] tempData = targetLine.split(",");
                if(tempData[0].equals(country)){
                    targetCountry = tempData[0];
                    targetFlag = tempData[1];
                    break;
                }
                else if(tempData[0].contains(country)){
                    targetCountry = tempData[0];
                    targetFlag = tempData[1];
                    break;
                }
                
            }
            targetFlag = targetFlag;
           flag = flag+".png";
            
           
            
//          
           if(targetCountry.equals("")){
               count++;
               System.out.println("Error");
               System.out.println(country);
               System.out.println(flag);
               System.out.println(temp);
               System.out.println("===============");
              continue;
           }
           
            File oldName = new File(targetFlag);
            File newName = new File(flag);

            if(oldName.renameTo(newName)) {
               System.out.println("renamed");
            } else {
               System.out.println("Error");
            }
               
//            System.out.println(targetFlag);
//            System.out.println(flag);
//            System.out.println("==================");
            
            fileReader2.close();
            //System.out.println(flag);
	}
	fileReader.close();
	       System.out.println("count: "+count);
		
    }
    
}
