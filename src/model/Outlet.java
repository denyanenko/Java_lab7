package model;

import java.util.UUID;
public class Outlet {
    private final UUID id;
    private UUID electricApplianceId=null;

    public UUID getElectricApplianceId() {
        return electricApplianceId;
    }

    public Outlet() {
        id=UUID.randomUUID();
    }
    public boolean isUsed(){
        return electricApplianceId != null;

    }
    public void plugInto(ElectricalAppliance electricalAppliance){
        electricApplianceId=electricalAppliance.getId();
        electricalAppliance.turnOn(id);
    }
    public ElectricalAppliance getElectricalAppliance(){
        if(isUsed()){
        return ElectricalAppliance.getElementById(electricApplianceId);}
        else{
            return  null;
        }
    }

    public void unplug() {
        ElectricalAppliance applianced=getElectricalAppliance();
            if (applianced != null) {
                applianced.tornOff();
            }
            electricApplianceId=null;

    }
}
