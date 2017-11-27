package models;

import models.equipment.slots.ArmorSlot;
import models.equipment.slots.Slot;
import models.equipment.slots.WeaponSlot;
import models.equipment.wearable.Armor;
import models.equipment.wearable.Weapon;
import models.equipment.wearable.Wearable;
import models.exceptions.TooHeavyItemException;
import service.evaluators.KnightEquipmentWeightEvaluator;

import java.util.*;

public class Knight extends Named {
    private final Map<Slot, Wearable> equipment = new HashMap<>();
    private final Map<ArmorSlot, Armor> armor = new HashMap<>();
    private final Map<WeaponSlot, Weapon> weapon = new HashMap<>();
    private final long maxWeight;
    private long currentWeight = 0;

    public long getCurrentWeight() {
        return currentWeight;
    }

    public Knight(
            int id,
            String name,
            long maxWeight
    ) {
        super(id, name);
        this.maxWeight = maxWeight;
    }

    private void putIntoEquipment(Wearable wearable) {
        if (currentWeight + wearable.getWeight() < maxWeight){
            this.equipment.put(
                    wearable.getSlot(),
                    wearable
            );
            updateCurrentWeight();
            return;
        }

        throw new TooHeavyItemException();
    }

    private void removeFromEquipment(Wearable wearable) {
        this.equipment.remove(wearable.getSlot());
        updateCurrentWeight();
    }

    public void wear(Wearable wearable){
        if(wearable instanceof Armor){
            wearArmor((Armor) wearable);
        }else if (wearable instanceof Weapon){
            wearWeapon((Weapon) wearable);
        }
    }

    public void wearArmor(Armor armor) {
        this.armor.put(armor.getSlot(), armor);
        putIntoEquipment(armor);
    }

    public void wearWeapon(Weapon weapon) {
        this.weapon.put(weapon.getSlot(), weapon);
        putIntoEquipment(weapon);
    }

    public void removeArmor(Armor armor) {
        this.armor.remove(armor.getSlot());
        removeFromEquipment(armor);
    }

    public void removeWeapon(Weapon weapon) {
        this.weapon.remove(weapon.getSlot());
        removeFromEquipment(weapon);
    }

    public List<Wearable> equipment() {
        return new ArrayList<>(equipment.values());
    }

    public List<Weapon> weapon(){
        return new ArrayList<>(weapon.values());
    }

    public List<Armor> armor(){
        return new ArrayList<>(armor.values());
    }

    public long getMaxWeight() {
        return maxWeight;
    }

    private void updateCurrentWeight() {
        currentWeight = new KnightEquipmentWeightEvaluator().applyAsLong(this);

    }
}
