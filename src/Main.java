import model.*;

import java.sql.SQLOutput;
import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Створення списку електроприладів
        ArrayList<ElectricalAppliance> electricalAppliances = new ArrayList<>();
        electricalAppliances.add(new ElectricKettle("Philips", "HD9353/90", 9, 220, 0.3));
        electricalAppliances.add(new ElectricKettle("BrandX", "Model123", 8, 230, 0.4));
        electricalAppliances.add(new Microwave("Samsung", "MS1234", 12, 240, 700));
        electricalAppliances.add(new Microwave("LG", "MH5678", 10, 220, 800));
        electricalAppliances.add(new Refrigerator("Whirlpool", "WR123", 15, 230, 0.7));
        electricalAppliances.add(new Refrigerator("Bosch", "BFR456", 14, 240, 0.8));
        electricalAppliances.add(new ElectricKettle("AnotherBrand", "ModelABC", 7, 210, 0.2));
        electricalAppliances.add(new Microwave("Panasonic", "P123", 11, 225, 600));
        electricalAppliances.add(new Refrigerator("Electrolux", "ER789", 13, 220, 0.6));
        electricalAppliances.add(new ElectricKettle("Philips", "HD9353/80", 9, 220, 0.3));

        // Створення ElectricalApplianceSet за допомогою різних конструкторів
        ElectricalApplianceSet applianceSet1 = new ElectricalApplianceSet();
        ElectricalApplianceSet applianceSet2 = new ElectricalApplianceSet(electricalAppliances.get(0));
        ElectricalApplianceSet applianceSet3 = new ElectricalApplianceSet(electricalAppliances.subList(3,8));
        // Виведення вмісту кожної множини в консоль
        System.out.println("Створені  множини за допомогою різних конструкторів");
        System.out.println("Множина 1: " + applianceSet1);
        System.out.println("Множина 2: " + applianceSet2);
        System.out.println("Множина 3: " + applianceSet3+"\n");

        // Додавання ще приладів до множин
        System.out.println("Додамо:\nдо Множини 1 і Множини 2 - "+electricalAppliances.get(0)+",\nдо Множини3 {");
        for(ElectricalAppliance a: electricalAppliances.subList(2, 9)){
            System.out.print(a+",\n");
        }
        System.out.print("}");

        applianceSet1.add(electricalAppliances.get(0));
        applianceSet2.add(electricalAppliances.get(0));
        applianceSet3.addAll(electricalAppliances.subList(2, 9));
        // Виведення вмісту кожної множини в консоль
        System.out.println("\nМножина 1: " + applianceSet1);
        System.out.println("Множина 2: " + applianceSet2);
        System.out.println("Множина 3: " + applianceSet3);

        // Демонстрація інших методів
        System.out.println("\nРозмір множини 3: " + applianceSet3.size());
        System.out.println("Множина 1 порожня? " + applianceSet1.isEmpty());
        System.out.println("Очистимо Множину 1");
        applianceSet1.clear();
        System.out.println("Множина 1 порожня? " + applianceSet1.isEmpty());
        // Видалення приладу з множини 3
        ElectricalAppliance applianceToRemove = electricalAppliances.get(3);
        applianceSet3.remove(applianceToRemove);
        System.out.println("Множина 3 після вилучення " + applianceToRemove + ":\n" + applianceSet3);
        System.out.println("\nЗберегти в Множині 3 тільки елементи спільні з колекцією {");
        for(ElectricalAppliance a: electricalAppliances.subList(6, 10)){
            System.out.print(a+",\n");
        }
        System.out.print("}");
        applianceSet3.retainAll(electricalAppliances.subList(6, 10));
        System.out.println("\n Множина 3 "+ applianceSet3);


    }

}
