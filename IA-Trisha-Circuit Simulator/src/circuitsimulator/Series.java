package circuitsimulator;

/**
 *SERIES
 * 
 * @author tklw06
 */
public class Series extends Circuit {
    
    private int numberOfResistorsAtA;
    private int resistancePerResistorAtA;
    
    public Series (int numberOfBatteries, int voltagePerBattery, int resistorsAtA,
            int resistancePerResistorAtA) throws Exception{              
        
        super(numberOfBatteries, voltagePerBattery);
        // SHOULD I MAKE THE RESISTANCE EXCEPTIONS COMMON TO ALL CIRCUITS?
    
        if(numberOfResistorsAtA >= 1){
            this.numberOfResistorsAtA = numberOfResistorsAtA;
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
        int v = getTotalVoltage();
        int r = getTotalResistance();
        double currentAtA = v / r;
        return currentAtA;
    }
    
    public double getTotalCurrent(){
        double tot = getCurrentAtA();
        return tot;
    }
    
    public double getPowerAtA(){
        double i = getTotalCurrent();
        int v = getTotalVoltage();
        double powerAtA = v * i;
        return powerAtA;
    }
    
    public double getTotalPower(){
        double tot = getPowerAtA();
        return tot;
    }
}
