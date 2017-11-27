package service.comparators.wearable_related;

import models.equipment.wearable.Wearable;

import java.util.Comparator;

public class WeightComparator<T extends Wearable> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        long weight1 = o1.getWeight();
        long weight2 = o2.getWeight();
        if (weight1 < weight2) {
            return -1;
        } else if (weight1 == weight2) {
            return 0;
        }
        return 1;
    }
}
