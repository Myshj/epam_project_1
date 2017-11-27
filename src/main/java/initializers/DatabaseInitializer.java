package initializers;

import databases.Database;
import models.Knight;
import models.equipment.slots.ArmorSlot;
import models.equipment.slots.WeaponSlot;
import models.equipment.wearable.Armor;
import models.equipment.wearable.Weapon;

import java.util.List;

public class DatabaseInitializer extends Initializer {
    private final Database database;
    private final List<ArmorSlot> armorSlots;
    private final List<WeaponSlot> weaponSlots;
    private final List<Armor> armors;
    private final List<Weapon> weapons;
    private final List<Knight> knights;

    public DatabaseInitializer(
            Database database,
            List<ArmorSlot> armorSlots,
            List<WeaponSlot> weaponSlots,
            List<Armor> armors,
            List<Weapon> weapons,
            List<Knight> knights
    ) {
        this.database = database;
        this.armorSlots = armorSlots;
        this.weaponSlots = weaponSlots;
        this.armors = armors;
        this.weapons = weapons;
        this.knights = knights;
    }

    @Override
    public void init() {
        new RepositoryInitializer<>(
                database.armorSlots,
                armorSlots
        ).init();

        new RepositoryInitializer<>(
                database.weaponSlots,
                weaponSlots
        ).init();

        new RepositoryInitializer<>(
                database.armors,
                armors
        ).init();

        new RepositoryInitializer<>(
                database.weapons,
                weapons
        ).init();

        new RepositoryInitializer<>(
                database.knights,
                knights
        ).init();
    }
}
