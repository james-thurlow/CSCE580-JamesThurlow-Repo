package chatbot.test;
//Written by James Thurlow
//Oct 2023

//This is the search class for the chatbot program
//This program uses an exhaustive search to find the disease that matches the symptoms

import java.io.*;


class DiseaseSearch{
    
    static String[][] data;
    static int numOfDiseases;
    static int numOfSymptoms;

    public static void load(){

        //This method will load the data from the csv file into the data array
        FileInputStream in = null;

        try{
            in = new FileInputStream("Testing.csv");
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String line = null;
        try{
            line = br.readLine();
        }
        catch(IOException e){
            System.out.println("IO Exception");
        }
        numOfDiseases = 0;
        while(line != null){
            numOfDiseases++;
            String[] temp = line.split(",");
            numOfSymptoms = temp.length;
            try{
                line = br.readLine();
            }
            catch(IOException e){
                System.out.println("IO Exception");
            }
        }

        //Resetting the input stream
        try{
            in.getChannel().position(0);
        }
        catch(IOException e){
            System.out.println("IO Exception");
        }
        br = new BufferedReader(new InputStreamReader(in));

        //Initializing the data array
        data = new String[numOfSymptoms][numOfDiseases];

        //Reading again to load data into an array
        try{
            line = br.readLine();
        }
        catch(IOException e){
            System.out.println("IO Exception");
        }
        int i = 0;
        
        while(line != null){
            String[] temp = line.split(",");
            for(int j = 0; j < temp.length; j++){
                data[j][i] = temp[j];
            }
            i++;
            try{
                line = br.readLine();
            }
            catch(IOException e){
                System.out.println("IO Exception");
            }
        }
    }

    public static int max(int[] arr){
        int max = arr[0];
        int address = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
                System.out.println("I: "+i);
                address = i;
            }
        }
        System.out.println("MAX: "+max);
        System.out.println("ADDRESS: "+address);    
        return address;
    }

    public static String getDisease(String symptoms){
        //This method will use the data array to find the disease
        System.out.println("Loading Data...");
        load(); 
        
        String result;

        System.out.println("Comparing your symmptoms to our database...done");
        String[] symptomList = symptoms.split("\\s+");
        String[] Diseases = new String[numOfDiseases];
        int[] symptomCount = new int[numOfDiseases];

        for(int i=0;i<numOfDiseases; i++){
            Diseases[i]= data[numOfSymptoms-1][i];
        }

        for(int i=0;i<symptomList.length;i++){
            for(int j=0;j<numOfDiseases;j++){
                for(int k=0;k<data.length;k++){
                    if(data[k][j].contains(symptomList[i])){
                        dsymptomCount[j]++;
                }
                }
            }
        }
        
        if(Diseases[max(symptomCount)].equals("prognosis")){
           result = "no result";
        }
        else{
            result = Diseases[max(symptomCount)];
        } 
        
        return result;
    }
}