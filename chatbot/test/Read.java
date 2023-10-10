package chatbot.test;

import java.io.*;  
import java.util.Scanner;  
public class Read  
{  
    public static void main(String[] args) throws Exception{  
    //parsing a CSV file into Scanner class constructor  
    Scanner sc = new Scanner(new File("C:\\Users\\james\\OneDrive\\Documents\\csce\\580\\quizzes\\chatbot\\test\\data.csv"));  
    sc.useDelimiter(",");   //sets the delimiter pattern  
    while (sc.hasNext()){  
         System.out.print(sc.next());  //find and returns the next complete token from this scanner  
    }   
sc.close();  //closes the scanner  
}  
}  