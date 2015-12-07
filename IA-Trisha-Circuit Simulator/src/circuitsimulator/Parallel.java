package circuitsimulator;

/**
 * The parallel circuit, subclass of Circuit. 
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
        return numberOfResistorsAtA * resistancePerResistorAtA;
    }
    
    public int getResistanceAtB(){
        return numberOfResistorsAtB * resistancePerResistorAtB;
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
        return (a * b) / (a + b);
    }
    
    /**
     * Calculates the current at point A using the V = IR formula. 
     * 
     * 
     * @return 
     */
    public double getCurrentAtA(){
        return getTotalVoltage() / getResistanceAtA();
    }
    
    /**
     * this WOULD calculate the current at point B if i knew what i was doing
     * @return 
     */
    public double getCurrentAtB(){
        return getTotalVoltage() / getResistanceAtB();
    }
    
    /**
     * calculate the total current, adding the two points.
     * @return the sum of current
     */
    public double getTotalCurrent(){
        return getCurrentAtA() + getCurrentAtB();
    }
    
    public double getVoltageAtA(){
        return getCurrentAtA() * getResistanceAtA();
    }
    
    public double getVoltageAtB(){
        // across B
        return getCurrentAtB() * getResistanceAtB();
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
    
    /**
     * Concatenates the fields as a string, and separates them by spaces.
     * @return The fields as a concatenated string, separated by spaces.
     */
    public String getState() {
        return UI.PARALLEL + " " +
               Integer.toString(getBatteries()) + " " + 
               Integer.toString(getVoltage()) + " " +
               Integer.toString(numberOfResistorsAtA) + " " +
               Integer.toString(resistancePerResistorAtA) + " " +
               Integer.toString(numberOfResistorsAtB) + " " +
               Integer.toString(resistancePerResistorAtB);
    }
    
}