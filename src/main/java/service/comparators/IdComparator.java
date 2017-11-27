package service.comparators;

import models.Model;

import java.util.Comparator;

public class IdComparator<T extends Model> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        long id1 = o1.getId();
        long id2 = o2.getId();
        if (id1 < id2) {
            return -1;
        } else if (id1 == id2) {
            return 0;
        }
        return 1;
    }
}
