package circuitsimulator;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.BufferedReader;

//for exceptioning
import java.io.IOException;
import java.util.NoSuchElementException;
import java.io.FileNotFoundException;

/**
 * IN WHICH I try to data storage and fail to catch exceptions
 * @author tklw06
 */
public class Persistor {
    
    private String         filename = "save.txt";   //USE FILEPICKER?     
    private FileWriter     fileWriter = null;                // write to
    private PrintWriter    printWriter = null;
    private FileReader     fileReader = null;                // read from
    private BufferedReader bufferedReader = null;    

    //method
    public void initiate() throws IOException {
        String errorMessage = "Persistor error: ";
        
        try{
            fileWriter = new FileWriter(filename, true);
            printWriter = new PrintWriter(fileWriter);
                    
            fileWriter = new FileWriter(filename);
            bufferedReader = new BufferedReader(fileReader);
        }
        catch (FileNotFoundException e) {
            
        }
    }
    
}
