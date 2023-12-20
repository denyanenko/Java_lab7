package model;

public class Refrigerator extends ElectricalAppliance {
    public Refrigerator(String companyName, String modelName, double electricCurrent, double voltage, double electromagneticRadiation) {
        super("Холодильник", companyName, modelName, electricCurrent, voltage, electromagneticRadiation);
    }
}
