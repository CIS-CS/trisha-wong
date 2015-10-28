package circuitsimulator;

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
        double resistanceAtA = (2 * ((numberOfResistorsAtA * resistancePerResistorAtA)^(-1)))^ (-1);
        return resistanceAtA;
    }
    
    public double getResistanceAtC(){
        double resistanceAtC = (2 * ((numberOfResistorsAtC * resistancePerResistorAtC)^(-1)))^ (-1);
        return resistanceAtC;
    }
    
    public double getTotalResistance(){
        double a = getResistanceAtA();
        double c = getResistanceAtC();
        double tot = a + c;
        return tot;
    }
    
    /*public double getCurrentAtA(){
        
    }
    
    public double getCurrentAtB(){
        int v = getTotalVoltage();
        double r = getResistanceAtA();
        double currentAtA = v / r;
        return currentAtA;
    }
    
    public double getCurrentAtC(){
        
    }
    
    public double getTotalCurrent(){
        
    }
    
    public double getPowerAtA(){
        
    }
    
    public double getPowerAtB(){
        
    }
    
    public double getPowerAtC(){
        
    }*/
}
