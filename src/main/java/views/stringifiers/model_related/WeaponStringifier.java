package views.stringifiers.model_related;

import models.equipment.wearable.Weapon;
import service.StringResourceManager;
import views.stringifiers.Stringifier;

public class WeaponStringifier extends Stringifier<Weapon> {
    @Override
    public String apply(Weapon weapon) {
        return String.format(
                StringResourceManager.INSTANCE.getValue("bodies.weaponFormat"),
                weapon.getId(),
                StringResourceManager.INSTANCE.getValue(weapon.getName()),
                weapon.getWeight(),
                weapon.getPrice(),
                weapon.getDamage(),
                StringResourceManager.INSTANCE.getValue(weapon.getSlot().getName())
        );
    }
}
