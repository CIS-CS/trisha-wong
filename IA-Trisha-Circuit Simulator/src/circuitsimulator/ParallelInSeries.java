package circuitsimulator;
import java.lang.Math;

/**
 * parallel in series
 * @author tklw06
 */
public class ParallelInSeries extends Circuit {
    
    private int numberOfResistorsAtA;
    private int resistancePerResistorAtA;
    
    private int numberOfResistorsAtC;
    private int resistancePerResistorAtC;
    
    public ParallelInSeries(int numberOfBatteries, int voltagePerBattery, int 
            numberOfResistorsAtA, int resistancePerResistorAtA, int numberOfResistorsAtC,
            int resistancePerResistorAt) throws Exception{
            
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
        double resistanceAtA = numberOfResistorsAtA * resistancePerResistorAtA;
        return resistanceAtA;
    }
    
    public double getResistanceAtC(){
        // ACROSS The point only
        double resistanceAtC = numberOfResistorsAtC * resistancePerResistorAtC;
        return resistanceAtC;
    }
    
    public double getTotalResistance(){
        double a = getResistanceAtA();
        double c = getResistanceAtC();
        double tot = (a * c) / (a + c);
        return tot;
        // the resistance formula simplified
    }
    
    public double getTotalCurrent(){
        int v = getTotalVoltage();
        double r = getResistanceAtA();
        double tot = v / r;
        return tot;
    }
    
    public double getVoltageAtA(){
        // ACROSS the entire loop; needs total current and total box resistance
        double resis = getResistanceAtA();
        double r = (Math.pow(resis, 2)) / (resis * 2);
        double i = getTotalCurrent();
        return r * i;
    }
    
    public double getVoltageAtB(){
        // total?
        return 0;
    }
    
    public double getVoltageAtC(){
        // across the entire loop; itot and box resis
        double resis = getResistanceAtC();
        double r = (Math.pow(resis, 2)) / (resis * 2);
        double i = getTotalCurrent();
        return r * i;
    }
    
    // this is where things get complicated...
    public double getCurrentAtA(){
        //requires voltage at a
        double v = getVoltageAtA();
        double r = getResistanceAtA();
        double i = v / r;
        return i;
    }
    
    public double getCurrentAtB(){
        // essentially the total current
        double current = getTotalCurrent();
        return current;
    }
    
    public double getCurrentAtC(){
        //requires voltage at b
        double v = getVoltageAtC();
        double r = getResistanceAtA();
        double i = v / r;
        return i; 
    }
    
    public double getPowerAtA(){
        
    }
    
    public double getPowerAtB(){
        
    }
    
    public double getPowerAtC(){
        
    }
}
