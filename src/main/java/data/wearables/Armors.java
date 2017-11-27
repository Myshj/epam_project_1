package data.wearables;

import data.Data;
import data.slots.ArmorSlots;
import models.equipment.wearable.Armor;

import java.util.Arrays;

public class Armors extends Data<Armor> {
    public final Armor paladinGloves;
    public final Armor paladinArmor;
    public final Armor paladinHelmet;
    public final Armor paladinBoots;

    public Armors(ArmorSlots slots) {
        paladinGloves = new Armor(
                1,
                "wearables.paladinGloves",
                10,
                100,
                20,
                slots.arms
        );

        paladinArmor = new Armor(
                2,
                "wearables.paladinArmor",
                100,
                1500,
                100,
                slots.torso
        );

        paladinHelmet = new Armor(
                3,
                "wearables.paladinHelmet",
                20,
                200,
                40,
                slots.head
        );

        paladinBoots = new Armor(
                4,
                "wearables.paladinBoots",
                20,
                100,
                20,
                slots.feet
        );

        objects.addAll(
                Arrays.asList(
                        paladinArmor,
                        paladinHelmet,
                        paladinGloves
                )
        );
    }
}
