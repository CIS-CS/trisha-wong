package circuitsimulator;
/**
 * IN WHICH i define circuit object
 * @author tklw06
 */
public class Circuit {
    
    private int numberOfBatteries;
    private int voltagePerBattery;
    
    /**
     * Constructs a Circuit object. Voltage for Circuits depends on the number 
     * of batteries and the voltage per battery.
     * 
     * @param numberOfBatteries The number of batteries in the circuit.
     * @param voltagePerBattery The supplied emf per single battery.
     */
    public Circuit(int numberOfBatteries, int voltagePerBattery) throws Exception {
        
        if((numberOfBatteries >= 1) && (numberOfBatteries <= 50)){
            this.numberOfBatteries = numberOfBatteries;
        }
        else{
            throw new Exception("Error: Please choose a positive, reasonable number"
                    + "of batteries! This is meant to be a realistic simulator!");
        }
        
        if((voltagePerBattery >= 1) && (voltagePerBattery <= 50)){
            this.voltagePerBattery = voltagePerBattery;
        }
        else{
            throw new Exception("Error: Please choose a positive, reasonable emf"
                    + "per battery! This is meant to be a realistic simulator!");
        }
        
        //no negative batteries
        /*int i = numberOfBatteries * voltagePerBattery;
        
        if ((i >= 1) && (i <= 1000)){ 
            this.numberOfBatteries = numberOfBatteries;
            this.voltagePerBattery = voltagePerBattery;
        }
        else{
            throw new Exception("Error: Total voltage must be 1-1000. Voltage calculated: " +
                    i);
        }*/
    }
    
    /**
     * Calculates total voltage. Total voltage = batteries * voltage per battery.
     * 
     * @return The total voltage calculated by multiplying the number of 
     * batteries and voltage per battery.
     */
    public int getTotalVoltage() {
        //must be greater than 0 and less than thousand
        int totalVoltage = numberOfBatteries * voltagePerBattery;
        return totalVoltage;
    }
}