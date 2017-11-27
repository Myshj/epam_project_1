package models.equipment.wearable;

import models.equipment.slots.WeaponSlot;

public class Weapon extends Wearable {
    private final long damage;
    private final WeaponSlot slot;

    public Weapon(
            int id,
            String name,
            long weight,
            long price,
            long damage,
            WeaponSlot slot
    ) {
        super(id, name, weight, price);
        this.damage = damage;
        this.slot = slot;
    }

    @Override
    public WeaponSlot getSlot() {
        return slot;
    }

    public long getDamage() {
        return damage;
    }
}
