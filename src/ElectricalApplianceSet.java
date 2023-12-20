import model.ElectricalAppliance;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class ElectricalApplianceSet implements Set<ElectricalAppliance> {
    // Внутрішній двозв'язний список для зберігання об'єктів
    private final LinkedList<ElectricalAppliance> items;

    // Конструктор для порожньої колекції
    public ElectricalApplianceSet() {
        this.items = new LinkedList<>();
    }
    public ElectricalApplianceSet(ElectricalAppliance item) {
        this.items = new LinkedList<>();
        this.add(item);
    }
    // Конструктор для колекції з іншої колекції
    public ElectricalApplianceSet(Collection<ElectricalAppliance> collection) {
        this.items = new LinkedList<>();
        this.addAll(collection);
    }

    @Override
    public int size() {
        return items.size();
    }

    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return items.contains(o);
    }

    @Override
    public Iterator<ElectricalAppliance> iterator() {
       return items.iterator();
    }

    @Override
    public Object[] toArray() {
        return items.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return items.toArray(a);
    }

    @Override
    public boolean add(ElectricalAppliance electricalAppliance) {
        if(!this.contains(electricalAppliance)){
            items.add(electricalAppliance);
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return items.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return items.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends ElectricalAppliance> c) {
        int sizeBeforeOperation = this.size();
        for (ElectricalAppliance appliance:c){
            this.add(appliance);
        }
        return sizeBeforeOperation != this.size();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return items.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return items.removeAll(c);
    }

    @Override
    public void clear() {
        items.clear();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("ElectricalApplianceSet{\n");
        for (ElectricalAppliance item : this) {
            result.append(item).append("\n");
        }
        result.append("}");
        return result.toString();
    }

}
