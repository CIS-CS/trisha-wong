package circuitsimulator;
import java.lang.Math;

/**
 * The parallel in series circuit, subclass of Circuit. 
 * @author tklw06
 */
public class ParallelInSeries extends Circuit {
    
    private int numberOfResistorsAtA;
    private int resistancePerResistorAtA;
    
    private int numberOfResistorsAtC;
    private int resistancePerResistorAtC;
    
    public ParallelInSeries(int numberOfBatteries, 
                            int voltagePerBattery, int 
            numberOfResistorsAtA, int resistancePerResistorAtA, int numberOfResistorsAtC,
            int resistancePerResistorAtC) throws Exception{
            
            super(numberOfBatteries, voltagePerBattery);
    
        if(numberOfResistorsAtA >= 1){
            this.numberOfResistorsAtA = numberOfResistorsAtA;
        }
        else{
            throw new Exception("Error: You can't have a negative number of resistors!");
        }
        //at B
        if(numberOfResistorsAtC >= 1){
            this.numberOfResistorsAtC = numberOfResistorsAtC;
        }
        else{
            throw new Exception("Error: You can't have a negative number of resistors!");
        }
        
        //to check if resistance per resistor is valid at A
        if(resistancePerResistorAtA >= 1 && resistancePerResistorAtA <= 9000){
            this.resistancePerResistorAtA = resistancePerResistorAtA;
        }
        else{
            throw new Exception("Error: One resistor with over 9000 ohms? That's ridiculous!");
        }
        //at c
                
        if(resistancePerResistorAtC >= 1 && resistancePerResistorAtC <= 9000){
            this.resistancePerResistorAtC = resistancePerResistorAtC;
        }
        else{
            throw new Exception("Error: One resistor with over 9000 ohms? That's ridiculous!");
        }
    }
    
    public double getResistanceAtA(){
        // ACROSS THE point only
        return numberOfResistorsAtA * resistancePerResistorAtA;
    }
    
    public double getResistanceAtC(){
        // ACROSS The point only
        return numberOfResistorsAtC * resistancePerResistorAtC;
    }
    
    public double getTotalResistance(){
        double a = getResistanceAtA();
        double c = getResistanceAtC();
        return (a * c) / (a + c);
        // the resistance formula simplified
    }
    
    public double getTotalCurrent(){
        return getTotalVoltage() / getResistanceAtA();
    }
    
    public double getVoltageAtA(){
        // ACROSS the entire loop; needs total current and total box resistance
        double resis = getResistanceAtA();
        double r = (Math.pow(resis, 2)) / (resis * 2);
        return getTotalCurrent() * r;
    }
    
    public double getVoltageAtB(){
        // total? across BOTH loops?
        return getTotalResistance();
    }
    
    public double getVoltageAtC(){
        // across the entire loop; itot and box resis
        double resis = getResistanceAtC();
        double r = (Math.pow(resis, 2)) / (resis * 2);
        return r * getTotalCurrent();
    }
    
    // this is where things get complicated...
    public double getCurrentAtA(){
        //requires voltage at a
        return getVoltageAtA() / getResistanceAtA();
    }
    
    public double getCurrentAtB(){
        // essentially the total current
        return getTotalCurrent();
    }
    
    public double getCurrentAtC(){
        //requires voltage at ??
        return getVoltageAtC() / getResistanceAtA(); 
    }
    
    public double getPowerAtA(){
        return getCurrentAtA() * getVoltageAtA();
    }
    
    public double getPowerAtB(){
        return 0; // ?
    }
    
    public double getPowerAtC(){
        return getCurrentAtC() * getVoltageAtC();
    }
    
    public double getTotalPower(){
        return getPowerAtA() + getPowerAtC();
    }
    
    /**
     * Concatenates the fields as a string, and separates them by spaces.
     * @return The fields as a concatenated string, separated by spaces.
     */
    public String getState() {
        return UI.PARALLEL_IN_SERIES + " " +
               Integer.toString(getBatteries()) + " " + 
               Integer.toString(getVoltage()) + " " +
               Integer.toString(numberOfResistorsAtA) + " " +
               Integer.toString(resistancePerResistorAtA) + " " +
               Integer.toString(numberOfResistorsAtC) + " " +
               Integer.toString(resistancePerResistorAtC);
    }
}
