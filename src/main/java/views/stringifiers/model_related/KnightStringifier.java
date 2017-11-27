package views.stringifiers.model_related;

import models.Knight;
import service.StringResourceManager;
import views.Headers;
import views.stringifiers.ListStringifier;
import views.stringifiers.Stringifier;

public class KnightStringifier extends Stringifier<Knight> {
    @Override
    public String apply(Knight knight) {
        StringResourceManager manager = StringResourceManager.INSTANCE;
        return
                String.format(
                        manager.getValue("headers.knightFormat"),
                        knight.getId(),
                        StringResourceManager.INSTANCE.getValue(knight.getName()),
                        knight.getMaxWeight(),
                        knight.getCurrentWeight()
                ) +
                        "------------------------------------------------------------------------------------------------------------\n" +
                        String.format(
                                manager.getValue("headers.tableHeaderFormat"),
                                manager.getValue("headers.weapon")
                        ) + Headers.weaponTableHeader() +
                        new ListStringifier<>(new WeaponStringifier()).apply(knight.weapon()) +
                        String.format(
                                manager.getValue("headers.tableHeaderFormat"),
                                manager.getValue("headers.armor")
                        ) +
                        Headers.armorTableHeader() +
                        new ListStringifier<>(new ArmorStringifier()).apply(knight.armor()) +
                        "------------------------------------------------------------------------------------------------------------\n";
    }
}
