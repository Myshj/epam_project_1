package views.stringifiers.model_related;

import models.equipment.wearable.Armor;
import service.StringResourceManager;
import views.stringifiers.Stringifier;

public class ArmorStringifier extends Stringifier<Armor> {
    @Override
    public String apply(Armor armor) {
        return String.format(
                StringResourceManager.INSTANCE.getValue("bodies.armorFormat"),
                armor.getId(),
                StringResourceManager.INSTANCE.getValue(armor.getName()),
                armor.getWeight(),
                armor.getPrice(),
                armor.getProtection(),
                StringResourceManager.INSTANCE.getValue(armor.getSlot().getName())
        );
    }
}
