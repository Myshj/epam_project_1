package data;

import data.wearables.Armors;
import data.wearables.Weapons;
import models.Knight;

import java.util.Arrays;

public class Knights extends Data<Knight> {

    public final Knight lotar;
    public final Knight hagen;

    public Knights(
            Armors armors,
            Weapons weapons
    ) {
        lotar = new Knight(
                1,
                "knights.lotar",
                160
        );
        lotar.wearArmor(armors.paladinArmor);
        lotar.wearArmor(armors.paladinBoots);
        lotar.wearWeapon(weapons.paladinSword);

        hagen = new Knight(
                2,
                "knights.hagen",
                250
        );
        hagen.wearArmor(armors.paladinArmor);
        hagen.wearArmor(armors.paladinBoots);
        hagen.wearWeapon(weapons.paladinSword);

        objects.addAll(
                Arrays.asList(
                        lotar,
                        hagen
                )
        );
    }
}
