package circuitsimulator;

/**
 * PRALELL L? ???
 * @author tklw06
 */
public class Parallel extends Circuit {

    private int numberOfResistorsAtA;
    private int resistancePerResistorAtA;
    
    private int numberOfResistorsAtB;
    private int resistancePerResistorAtB;
    
    public Parallel(int numberOfBatteries, int voltagePerBattery, int numberOfResistorsAtA,
            int resistancePerResistorAtA, int numberOfResistorsAtB, 
            int resistancePerResistorAtB) throws Exception {
        
        super(numberOfBatteries, voltagePerBattery);
        
        //to check if input number of resistors is valid at A
        if(numberOfResistorsAtA >= 1){
            this.numberOfResistorsAtA = numberOfResistorsAtA;
        }
        else{
            throw new Exception("Error: You can't have a negative number of resistors!");
        }
        //at B
        if(numberOfResistorsAtB >= 1){
            this.numberOfResistorsAtB = numberOfResistorsAtB;
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
        //at b
                //at b
        if(resistancePerResistorAtB >= 1 && resistancePerResistorAtB <= 9000){
            this.resistancePerResistorAtB = resistancePerResistorAtB;
        }
        else{
            throw new Exception("Error: One resistor with over 9000 ohms? That's ridiculous!");
        }
    }
    
    //get methods inbound
    
    /**
     * 
     */
    public int getResistanceAtA(){
        int resistanceAtA = numberOfResistorsAtA * resistancePerResistorAtA;
        return resistanceAtA;
    }
    
    public int getResistanceAtB(){
        int resistanceAtB = numberOfResistorsAtB * resistancePerResistorAtB;
        return resistanceAtB;
    }
    
    /**
     * Calculates total resistance. Total resistance = 1/ (sum of 1/resistance
     * at each point), the parallel resistance formula.
     * 
     * @return The total resistance calculated with the parallel resistance
     * formula.
     */
    public double getTotalResistance(){
        int a = getResistanceAtA();
        int b = getResistanceAtB();
        double totalResistance = (a * b) / (a + b);
        return totalResistance;
    }
    
    /**
     * Calculates the current at point A using the V = IR formula. 
     * 
     * 
     * @return 
     */
    public double getCurrentAtA(){
        int a = getTotalVoltage();
        int rA = getResistanceAtA();
        double currentAtA = a / rA;
        return currentAtA;
    }
    
    /**
     * this WOULD calculate the current at point B if i knew what i was doing
     * @return 
     */
    public double getCurrentAtB(){
        double v = getTotalVoltage();
        int rB = getResistanceAtB();
        double currentAtB = v / rB;
        return currentAtB;
    }
    
    /**
     * calculate the total current, adding the two points.
     * @return the sum of current
     */
    public double getTotalCurrent(){
        double a = getCurrentAtA();
        double b = getCurrentAtB();
        double totalCurrent = a + b;
        return totalCurrent;
    }
    
    public double getVoltageAtA(){
        double i = getCurrentAtA();
        double r = getResistanceAtA();
        double v = i * r;
        return v;
    }
    
    public double getVoltageAtB(){
        
    }
    
    /**
     * calculate power at a using P= IV
     * 
     * @return 
     */
    public double getPowerAtA(){
        double a = getCurrentAtA();
        double v = getTotalVoltage();
        double powerAtA = v * a;
        return powerAtA;
    }
    
    public double getPowerAtB(){
        double b = getCurrentAtB();
        double v = getTotalVoltage();
        double powerAtB = v * b;
        return powerAtB;
    }
    
    public double getTotalPower(){
        double a = getPowerAtA();
        double b = getPowerAtB();
        double totalPower = a + b;
        return totalPower;
    }
    
}