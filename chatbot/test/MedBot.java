package chatbot.test;
//Written by James Thurlow  
//Oct 2023
// This class contains the main method for the chatbot program

import java.util.Scanner;

class MedBot{
    

    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        String input;

        System.out.println("Hello! I am a medical chatbot. I can help you with your medical needs. Please enter your symptoms and" 
        +" I will see if I can help you. If you are finished, you can type 'done'.");
        
        while(true){
            input = keyboard.nextLine();
            if(input.equalsIgnoreCase("done")){
                System.out.println("Thank you for using this chatbot. I hope I was able to assist you. Goodbye!");
                break;
            }
            else{
                String diagnosis = DiseaseSearch.getDisease(input);
                if(diagnosis.equals("no result")){
                    System.out.println("I'm sorry, I was unable to find a disease that matched your symptoms. Please try again.");
                }
                else{
                    System.out.println("I believe you have " + diagnosis + ". I recommend you see a doctor as soon as possible.");
                }
                System.out.println("If you are finished, you can type 'done', or you are welcome to ask another question.");
            }
        }//end while
    } 

}