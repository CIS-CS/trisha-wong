package circuitsimulator;

/**
 * The multi loop circuit, subclass of Circuit. 
 * @author tklw06
 */
public class MultiLoop extends Circuit {
    
    private int numberOfResistorsAtA;
    private int resistancePerResistorAtA;
    
    private int numberOfResistorsAtB;
    private int resistancePerResistorAtB;
    
    private int numberOfResistorsAtC;
    private int resistancePerResistorAtC;
    
    private int numberOfResistorsAtD;
    private int resistancePerResistorAtD;
    
    public MultiLoop(int numberOfBatteries, 
                     int voltagePerBattery, 
                     int numberOfResistorsAtA, 
                     int resistancePerResistorAtA,
                     int numberOfResistorsAtB, 
                     int resistancePerResistorAtB,
                     int numberOfResistorsAtC,
                     int resistancePerResistorAtC,
                     int numberOfResistorsAtD,
                     int resistancePerResistorAtD) throws Exception{
            
            super(numberOfBatteries, voltagePerBattery);
    
        if(numberOfResistorsAtA >= 1){
            this.numberOfResistorsAtA = numberOfResistorsAtA;
        }
        else{
            throw new Exception("Error: You can't have a negative number of resistors!");
        }
        //at b
        if(numberOfResistorsAtB >= 1){
            this.numberOfResistorsAtB = numberOfResistorsAtB;
        }
        else{
            throw new Exception("Error: You can't have a negative number of resistors!");
        }
        
        //at c
        if(numberOfResistorsAtC >= 1){
            this.numberOfResistorsAtC = numberOfResistorsAtC;
        }
        else{
            throw new Exception("Error: You can't have a negative number of resistors!");
        }
        
        //at d
        if(numberOfResistorsAtD >= 1){
            this.numberOfResistorsAtD = numberOfResistorsAtD;
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
        if(resistancePerResistorAtB >= 1 && resistancePerResistorAtB <= 9000){
            this.resistancePerResistorAtB = resistancePerResistorAtB;
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
        //at d
        if(resistancePerResistorAtD >= 1 && resistancePerResistorAtD <= 9000){
            this.resistancePerResistorAtD = resistancePerResistorAtD;
        }
        else{
            throw new Exception("Error: One resistor with over 9000 ohms? That's ridiculous!");
        }
    }
    
    
    public double getResistanceAtA(){
        // ACROSS THE point only
        return numberOfResistorsAtA * resistancePerResistorAtA;
    }
    
    public double getResistanceAtB(){
        return numberOfResistorsAtB * resistancePerResistorAtB;
    }
    
    public double getResistanceAtC(){
        // ACROSS The point only
        return numberOfResistorsAtC * resistancePerResistorAtC;
    }
    
    public double getResistanceAtD(){
        return numberOfResistorsAtD * resistancePerResistorAtD;
    }
    
    public double getTotalResistance(){
        double a = getResistanceAtA();
        double b = getResistanceAtB();
        double c = getResistanceAtC();
        double d = getResistanceAtD();
        
        return a + ((b * c * d) / (b + c + d));
        // the resistance formula simplified
    }
    
    public double getTotalCurrent(){
        return getTotalVoltage() / getTotalResistance();
    }
    
    public double getCurrentAtA(){
        return getTotalCurrent();
    }
    
    public double getCurrentAtB(){
        return getVoltageAtB() / getResistanceAtB();
    }
    
    public double getCurrentAtC(){
        return getVoltageAtC() / getResistanceAtC();
    }
    
    public double getCurrentAtD(){
        return getVoltageAtD() / getResistanceAtD();
    }
    
    public double getVoltageAtA(){
        return getTotalCurrent() * getTotalResistance();
    }
    
    public double getVoltageAtB(){
        return getTotalVoltage() - getVoltageAtA();
    }
    
    public double getVoltageAtC(){
        return getTotalVoltage() - getVoltageAtA();
    }
    
    public double getVoltageAtD(){
        return getTotalVoltage() - getVoltageAtA();
    }
    
    public double getTotalPower(){
        return getTotalVoltage() * getTotalCurrent();
    }
    
    public double getPowerAtA(){
        return getVoltageAtA() * getCurrentAtA();
    }
    
    public double getPowerAtB(){
        return getVoltageAtB() * getCurrentAtB();
    }
    
    public double getPowerAtC(){
        return getVoltageAtC() * getCurrentAtC();
    }
    
    public double getPowerAtD(){
        return getVoltageAtD() * getCurrentAtD();
    }
    
    /**
     * Concatenates the fields as a string, and separates them by spaces.
     * @return The fields as a concatenated string, separated by spaces.
     */
    public String getState() {
        return UI.MULTI_LOOP + " " +
               Integer.toString(getBatteries()) + " " + 
               Integer.toString(getVoltage()) + " " +
               Integer.toString(numberOfResistorsAtA) + " " +
               Integer.toString(resistancePerResistorAtA) + " " +
               Integer.toString(numberOfResistorsAtB) + " " +
               Integer.toString(resistancePerResistorAtB) + " " +
               Integer.toString(numberOfResistorsAtC) + " " +
               Integer.toString(resistancePerResistorAtC) + " " +
               Integer.toString(numberOfResistorsAtD) + " " +
               Integer.toString(resistancePerResistorAtD);
    }
}
