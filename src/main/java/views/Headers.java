package views;

import service.StringResourceManager;

public abstract class Headers {

    private static StringResourceManager manager = StringResourceManager.INSTANCE;


    public static String armorTableHeader() {
        return String.format(
                manager.getValue("headers.armorFormat"),
                "#",
                manager.getValue("headers.id"),
                manager.getValue("headers.wearableName"),
                manager.getValue("headers.weight"),
                manager.getValue("headers.price"),
                manager.getValue("headers.protection"),
                manager.getValue("headers.slot")
        );
    }

    ;

    public static String weaponTableHeader() {
        return String.format(
                StringResourceManager.INSTANCE.getValue("headers.weaponFormat"),
                "#",
                manager.getValue("headers.id"),
                manager.getValue("headers.wearableName"),
                manager.getValue("headers.weight"),
                manager.getValue("headers.price"),
                manager.getValue("headers.damage"),
                manager.getValue("headers.slot")
        );
    }
}
