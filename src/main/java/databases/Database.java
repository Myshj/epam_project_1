package databases;

import models.Knight;
import models.equipment.slots.ArmorSlot;
import models.equipment.slots.WeaponSlot;
import models.equipment.wearable.Armor;
import models.equipment.wearable.Weapon;

public class Database {
    public final Repository<ArmorSlot> armorSlots = new Repository<>();
    public final Repository<WeaponSlot> weaponSlots = new Repository<>();
    public final Repository<Armor> armors = new Repository<>();
    public final Repository<Weapon> weapons = new Repository<>();
    public final Repository<Knight> knights = new Repository<>();
}
