package data.slots;

import data.Data;
import models.equipment.slots.WeaponSlot;

import java.util.Arrays;

public class WeaponSlots extends Data<WeaponSlot> {
    public final WeaponSlot rightArm = new WeaponSlot(1, "slots.rightArm");

    {
        objects.addAll(
                Arrays.asList(
                        rightArm
                )
        );
    }
}
