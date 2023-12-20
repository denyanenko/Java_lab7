package model;

public class Microwave extends ElectricalAppliance{
    public Microwave(String companyName, String modelName, double electricCurrent, double voltage, double electromagneticRadiation) {
        super("Мікрохвильова піч", companyName, modelName, electricCurrent, voltage, electromagneticRadiation);
    }
}
