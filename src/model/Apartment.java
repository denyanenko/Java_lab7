import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Apartment {
    private List<Outlet> outlets;

    public Apartment() {
        this(10);
    }

    public Apartment(int numberOfOutlets) throws IllegalArgumentException  {
        if (numberOfOutlets < 0) {
            throw new IllegalArgumentException("Кількість розеток не може бути від'ємною.");
        }
        outlets = Stream.generate(Outlet::new)
                .limit(numberOfOutlets)
                .collect(Collectors.toList());
    }

    /**
     * Підключає електроприлад до першої вільної розетки в квартирі.
     *
     * @param electricalAppliance Прилад, який потрібно підключити.
     * @return -1, якщо прилад вже увімкнено і не може бути підключений.
     * -2, якщо немає вільних розеток для підключення.
     * Індекс розетки, яку використано для підключення приладу, якщо успішно.
     */
    int plugIntoOutlet(ElectricalAppliance electricalAppliance) {
        if (electricalAppliance.isTurnedOn()) {
            return -1;
        }
        for (int i = 0; i < outlets.size(); i++) {
            if (!outlets.get(i).isUsed()) {
                outlets.get(i).plugInto(electricalAppliance);
                return i;
            }
        }
        return -2;
    }

    /**
     * Підключає електроприлад до зазначеної розетки в квартирі.
     *
     * @param electricalAppliance Прилад, який потрібно підключити.
     * @param outletIndex         Індекс розетки, до якої слід підключити прилад.
     * @return -1, якщо розетка з даним індексом не існує.
     * -2, якщо розетка вже зайнята.
     * Індекс розетки, яку використано для підключення приладу, якщо успішно.
     */
    public int plugIntoOutlet(ElectricalAppliance electricalAppliance, int outletIndex) {
        if (outletIndex < 0 || outletIndex >= outlets.size()) {
            //Розетка з даним індексом не існує
            return -1;
        }

        if (outlets.get(outletIndex).isUsed()) {
            // Розетка вже зайнята.
            return -2;
        }

        outlets.get(outletIndex).plugInto(electricalAppliance);
        return outletIndex;
    }

    public void unplugFromOutlet(int outletIndex) {
        outlets.get(outletIndex).unplug();
    }

    public void unplugFromOutlet(ElectricalAppliance appliance) {
        for (Outlet outlet : outlets) {
            if (outlet.getElectricApplianceId() == appliance.getId()) {
                outlet.unplug();
            }
        }
    }

    public void addOutlet() {
        outlets.add(new Outlet());
    }

    public double calculatePowerConsumption() {
        double totalPower = 0;
        for (Outlet outlet : outlets) {
            ElectricalAppliance appliance = outlet.getElectricalAppliance();
            if (appliance != null) {
                totalPower += appliance.getPower();
            }
        }
        return totalPower;
    }

    public ArrayList<ElectricalAppliance> getSortedElectricalAppliance() {
        ArrayList<ElectricalAppliance> appliances = new ArrayList<>();
        for (Outlet outlet : outlets) {
            if (outlet.isUsed()) {
                appliances.add(outlet.getElectricalAppliance());
            }
        }
        appliances.sort(Comparator.comparing(ElectricalAppliance::getPower));
        return appliances;
    }

    public ArrayList<ElectricalAppliance> findApplianceByElectromagneticRange(double min, double max) {
        ArrayList<ElectricalAppliance> appliances = new ArrayList<>();
        for (Outlet outlet : outlets) {
            if (outlet.isUsed()) {
                ElectricalAppliance appliance=outlet.getElectricalAppliance();
                if(appliance.getElectromagneticRadiation()>=min&&appliance.getElectromagneticRadiation()<=max){
                    appliances.add(appliance);
                }
            }
        }
        return appliances;
    }


}
