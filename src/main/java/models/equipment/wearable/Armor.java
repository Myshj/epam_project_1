package models.equipment.wearable;

import models.equipment.slots.ArmorSlot;

public class Armor extends Wearable {
    private final long protection;
    private final ArmorSlot slot;

    public Armor(
            int id,
            String name,
            long weight,
            long price,
            long protection,
            ArmorSlot slot
    ) {
        super(id, name, weight, price);
        this.protection = protection;
        this.slot = slot;
    }

    @Override
    public ArmorSlot getSlot() {
        return slot;
    }

    public long getProtection() {
        return protection;
    }
}
