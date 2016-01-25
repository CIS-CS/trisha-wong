package circuitsimulator;

/**
 *SERIES
 * 
 * @author tklw06
 */
public class Series extends Circuit {
    
    private int numberOfResistorsAtA;
    private int resistancePerResistorAtA;
    
    public Series(int numberOfBatteries, 
                  int voltagePerBattery, 
                  int numberOfResistorsAtA,
                  int resistancePerResistorAtA) throws Exception { 
        
        super (numberOfBatteries, voltagePerBattery);
    
        if(numberOfResistorsAtA >= 1){
            this.numberOfResistorsAtA = numberOfResistorsAtA;
        }
        else{
            throw new Exception("Resistors should be greater than 0!");
        }
        
        //to check if resistance per resistor is valid at A
        if(resistancePerResistorAtA >= 1 && resistancePerResistorAtA <= 9000){
            this.resistancePerResistorAtA = resistancePerResistorAtA;
        }
        else{
            throw new Exception("One resistor with over 9000 ohms? That's ridiculous!");
        }
        
    }
    
    public int getResistanceAtA(){
        int resistanceAtA = numberOfResistorsAtA * resistancePerResistorAtA;
        return resistanceAtA;
    }
    
    public int getTotalResistance(){
        int tot = getResistanceAtA();
        return tot;
    }
    
    public double getCurrentAtA(){
        double v = getTotalVoltage();
        double r = getTotalResistance();
        double currentAtA = v / r;
        return currentAtA;
    }
    
    public double getTotalCurrent() {
        double tot = getCurrentAtA();
        return tot;
    }
    
    public double getPowerAtA() {
        double i = getTotalCurrent();
        double v = getTotalVoltage();
        double powerAtA = v * i;
        return powerAtA;
    }
    
    public double getTotalPower() {
        double tot = getPowerAtA();
        return tot;
    }
    
    /**
     * Concatenates the fields as a string, and separates them by spaces.
     * @return The fields as a concatenated string, separated by spaces.
     */
    public String getState() {
        return UI.SERIES + " " +
               Integer.toString(getBatteries()) + " " + 
               Integer.toString(getVoltage()) + " " +
               Integer.toString(numberOfResistorsAtA) + " " +
               Integer.toString(resistancePerResistorAtA);
    }
}
