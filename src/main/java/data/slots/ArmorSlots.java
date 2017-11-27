package data.slots;

import data.Data;
import models.equipment.slots.ArmorSlot;

import java.util.Arrays;

public class ArmorSlots extends Data<ArmorSlot> {
    public final ArmorSlot torso = new ArmorSlot(1, "slots.torso");
    public final ArmorSlot head = new ArmorSlot(2, "slots.head");
    public final ArmorSlot arms = new ArmorSlot(3, "slots.arms");
    public final ArmorSlot feet = new ArmorSlot(4, "slots.feet");

    {
        objects.addAll(
                Arrays.asList(
                        torso,
                        head,
                        arms,
                        feet
                )
        );
    }
}
