package data.wearables;

import data.Data;
import data.slots.WeaponSlots;
import models.equipment.wearable.Weapon;

import java.util.Arrays;

public class Weapons extends Data<Weapon> {
    public final Weapon paladinSword;
    public final Weapon longPaladinSword;

    public Weapons(WeaponSlots slots) {
        paladinSword = new Weapon(
                1,
                "wearables.paladinSword",
                30,
                1000,
                50,
                slots.rightArm
        );

        longPaladinSword = new Weapon(
                2,
                "wearables.longPaladinSword",
                40,
                1500,
                70,
                slots.rightArm
        );

        objects.addAll(
                Arrays.asList(
                        paladinSword,
                        longPaladinSword
                )
        );
    }
}
