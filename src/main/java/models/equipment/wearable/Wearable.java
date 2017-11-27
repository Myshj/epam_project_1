package models.equipment.wearable;

import models.Named;
import models.equipment.slots.Slot;

public abstract class Wearable extends Named {
    private final long weight;
    private final long price;

    Wearable(
            int id,
            String name,
            long weight,
            long price
    ) {
        super(id, name);
        this.weight = weight;
        this.price = price;
    }

    public long getWeight() {
        return weight;
    }

    public long getPrice() {
        return price;
    }

    public abstract Slot getSlot();
}
