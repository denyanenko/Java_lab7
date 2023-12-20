import java.util.ArrayList;
import java.util.UUID;
public abstract class ElectricalAppliance {
    private static final ArrayList<ElectricalAppliance> electricalAppliances =new ArrayList<>();



    private final UUID id;
    private final String name;
    private final String companyName;
    private final String modelName;
    private final double electricCurrent;
    private final double voltage;
    private final double electromagneticRadiation;
    private UUID outletId=null;
    public UUID getId() {
        return id;
    }


    public ElectricalAppliance(String name, String companyName, String modelName, double electricCurrent, double voltage, double electromagneticRadiation) {
        this.name = name;
        this.companyName = companyName;
        this.modelName = modelName;
        this.electricCurrent = electricCurrent;
        this.voltage = voltage;
        this.electromagneticRadiation = electromagneticRadiation;
        this.id=UUID.randomUUID();
        ElectricalAppliance.electricalAppliances.add(this);
    }

    public String getName() {
        return name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getModelName() {
        return modelName;
    }

    public double getElectricCurrent() {
        return electricCurrent;
    }

    public double getVoltage() {
        return voltage;
    }

    public double getElectromagneticRadiation() {
        return electromagneticRadiation;
    }

    public double getPower() {
        return electricCurrent * voltage;
    }




    public boolean isTurnedOn() {
        if(outletId!=null)
            return true;
        else
            return false;
    }
    static ElectricalAppliance getElementById(UUID id){
        for (ElectricalAppliance appliance : electricalAppliances) {
            if (appliance.id == id) {
                return appliance;
            }
        }
        return null;  // Якщо елемент не знайдено.
    }
    public void turnOn(UUID outletId) {
        this.outletId = outletId;
    }
    public  void tornOff(){
        outletId=null;
    }
    @Override
    public String toString() {
        return name + ' ' + companyName + ' ' + modelName + ' ' +
                electricCurrent + "А " + voltage + "V "
                + getPower() + "W " + electromagneticRadiation + "MHz";
    }
}
