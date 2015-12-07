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
    
    private final String   filename;  // in root of jar  
    private FileWriter     fileWriter;          // write to
    private PrintWriter    printWriter;
    private FileReader     fileReader;        // read from
    private BufferedReader bufferedReader;

    public Persistor() {
        filename = "save.txt";   
        fileWriter = null;                
        printWriter = null;
        fileReader = null;                
        bufferedReader = null;  
    }
    
    public void initiate() throws IOException {
        String errorMessage = "Persistor error: ";
        
        try{
            fileWriter = new FileWriter(filename);
            printWriter = new PrintWriter(fileWriter);
                    
            fileReader = new FileReader(filename);
            bufferedReader = new BufferedReader(fileReader);
        }
        catch(FileNotFoundException e) {
            throw new FileNotFoundException(errorMessage + e);
        }
        catch(IOException e){
            throw new IOException(errorMessage + e);
        }
    }
    
    public void write(CircuitBucket bucket){
        
        Circuit[] bucketArray = bucket.getBucket();
        Circuit c = null;
        
        for(int i = 0; i < bucketArray.length; i++){
            c = bucketArray[i];
            if (c != null) {
                printWriter.println(c.getState());
            }
        }
    }
    
    public Circuit read(CircuitBucket cb) throws IOException, Exception{
        String lastState = null;
        Circuit c = null;
        
        int batteries = 0;
        int voltage = 0;
        int resistorsA = 0;
        int resistanceA = 0;
        int resistorsB = 0;
        int resistanceB = 0;
        int resistorsC = 0;
        int resistanceC = 0;
        int resistorsD = 0;
        int resistanceD = 0;
        
        try {
            lastState = bufferedReader.readLine();
            
            while (lastState != null) {
                String[] fields = lastState.split(" ");
                
                int circuitType = Integer.parseInt(fields[0]);
                switch(circuitType) {
                    case UI.SERIES:
                        batteries = Integer.parseInt(fields[1]);
                        voltage = Integer.parseInt(fields[2]);
                        resistorsA = Integer.parseInt(fields[3]);
                        resistanceA = Integer.parseInt(fields[4]);
                        cb.add(new Series(batteries, voltage, resistorsA, resistanceA));

                    case UI.PARALLEL:
                        batteries = Integer.parseInt(fields[1]);
                        voltage = Integer.parseInt(fields[2]);
                        resistorsA = Integer.parseInt(fields[3]);
                        resistanceA = Integer.parseInt(fields[4]);
                        resistorsB = Integer.parseInt(fields[5]);
                        resistanceB = Integer.parseInt(fields[6]);
                        cb.add(new Parallel(batteries, voltage, resistorsA, resistanceA,
                                             resistorsB, resistanceB));
                    case UI.PARALLEL_IN_SERIES:
                        batteries = Integer.parseInt(fields[1]);
                        voltage = Integer.parseInt(fields[2]);
                        resistorsA = Integer.parseInt(fields[3]);
                        resistanceA = Integer.parseInt(fields[4]);
                        resistorsC = Integer.parseInt(fields[5]);
                        resistanceC = Integer.parseInt(fields[6]);
                        cb.add(new ParallelInSeries(batteries, voltage, resistorsA, resistanceA,
                                                     resistorsC, resistanceC));
                    case UI.MULTI_LOOP:
                        batteries = Integer.parseInt(fields[1]);
                        voltage = Integer.parseInt(fields[2]);
                        resistorsA = Integer.parseInt(fields[3]);
                        resistanceA = Integer.parseInt(fields[4]);
                        resistorsB = Integer.parseInt(fields[5]);
                        resistanceB = Integer.parseInt(fields[6]);
                        resistorsC = Integer.parseInt(fields[7]);
                        resistanceC = Integer.parseInt(fields[8]);
                        resistorsD = Integer.parseInt(fields[9]);
                        resistanceD = Integer.parseInt(fields[10]);
                        cb.add(new MultiLoop(batteries, voltage, resistorsA, resistanceA,
                                              resistorsB, resistanceB, resistorsC, resistanceC,
                                              resistorsD, resistanceD));
                    }
                }
            }
        
        catch(IOException e) {
            throw new IOException("Error with file: " + e);
        }
        catch(NoSuchElementException e) {
            throw new NoSuchElementException("Error with file: " + e);
        }
        catch(NumberFormatException e) {
            throw new NumberFormatException("Error with file: " + e);
        }
        return c;
    }
    
    public void close(){
        printWriter.close();
    }
    
}
