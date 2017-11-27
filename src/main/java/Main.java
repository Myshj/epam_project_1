import controllers.MainMenuController;
import controllers.command_executors.CommandToEquipKnightWithWearableExecutor;
import controllers.displayers.database_related.WearableListDisplayer;
import controllers.command_executors.CommandToFilterWearablesByPriceExecutor;
import data.Knights;
import data.slots.ArmorSlots;
import data.slots.WeaponSlots;
import data.wearables.Armors;
import data.wearables.Weapons;
import databases.Database;
import initializers.DatabaseInitializer;
import service.StringResourceManager;
import service.comparators.IdComparator;
import service.comparators.wearable_related.WeightComparator;
import views.*;
import views.stringifiers.ListStringifier;
import views.stringifiers.model_related.ArmorStringifier;
import views.stringifiers.model_related.KnightStringifier;
import views.stringifiers.model_related.WeaponStringifier;

import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws IOException {
        Database database = new Database();
        ArmorSlots armorSlots = new ArmorSlots();
        WeaponSlots weaponSlots = new WeaponSlots();
        Armors armors = new Armors(armorSlots);
        Weapons weapons = new Weapons(weaponSlots);
        Knights knights = new Knights(armors, weapons);

        StringResourceManager manager = StringResourceManager.INSTANCE;
        manager.setLocale(Locale.forLanguageTag("ru"));

        new DatabaseInitializer(
                database,
                armorSlots.objects,
                weaponSlots.objects,
                armors.objects,
                weapons.objects,
                knights.objects
        ).init();

        new MainMenuController(
                System.in,
                new MenuView(
                        manager.getValue("mainMenu"),
                        Arrays.asList(
                                manager.getValue("listKnights"),
                                manager.getValue("listArmor"),
                                manager.getValue("listWeapon"),
                                manager.getValue("listArmorSortedByWeight"),
                                manager.getValue("listWeaponSortedByWeight"),
                                manager.getValue("filterArmorByPrice"),
                                manager.getValue("filterWeaponByPrice"),
                                manager.getValue("wearArmor"),
                                manager.getValue("wearWeapon"),
                                manager.getValue("exit")
                        ),
                        manager.getValue("typeNumberOfOptionAndPressEnter")
                ),
                new SimpleView(manager.getValue("invalidInput")),
                new RepositoryView<>(
                        String.format(
                                manager.getValue("headers.knightFormat"),
                                manager.getValue("headers.id"),
                                manager.getValue("headers.knightName"),
                                manager.getValue("headers.maxWeight"),
                                manager.getValue("headers.currentWeight")
                        ),
                        database.knights,
                        new ListStringifier<>(new KnightStringifier())

                ),
                new WearableListDisplayer<>(
                        Headers.armorTableHeader(),
                        database.armors.all(),
                        new IdComparator<>(),
                        new ArmorStringifier()

                ),
                new WearableListDisplayer<>(
                        Headers.armorTableHeader(),
                        database.armors.all(),
                        new WeightComparator<>(),
                        new ArmorStringifier()

                ),
                new WearableListDisplayer<>(
                        Headers.weaponTableHeader(),
                        database.weapons.all(),
                        new IdComparator<>(),
                        new WeaponStringifier()

                ),
                new WearableListDisplayer<>(
                        Headers.weaponTableHeader(),
                        database.weapons.all(),
                        new WeightComparator<>(),
                        new WeaponStringifier()

                ),
                new CommandToFilterWearablesByPriceExecutor<>(
                        System.in,
                        new SimpleView(manager.getValue("filteringArmorByPrice")),
                        new SimpleView(manager.getValue("invalidInput")),
                        new PromtingView(
                                manager.getValue("enteringMinPrice"),
                                manager.getValue("priceShouldBeUnsigned"),
                                manager.getValue("typePrice")
                        ),
                        new PromtingView(
                                manager.getValue("enteringMaxPrice"),
                                manager.getValue("priceShouldBeUnsigned"),
                                manager.getValue("typePrice")
                        ),
                        Headers.armorTableHeader(),
                        database.armors.all(),
                        new IdComparator<>(),
                        new ArmorStringifier()
                ),
                new CommandToFilterWearablesByPriceExecutor<>(
                        System.in,
                        new SimpleView("Filtering weapon by price"),
                        new SimpleView(manager.getValue("invalidInput")),
                        new PromtingView(
                                manager.getValue("enteringMinPrice"),
                                manager.getValue("priceShouldBeUnsigned"),
                                manager.getValue("typePrice")
                        ),
                        new PromtingView(
                                manager.getValue("enteringMaxPrice"),
                                manager.getValue("priceShouldBeUnsigned"),
                                manager.getValue("typePrice")
                        ),
                        Headers.weaponTableHeader(),
                        database.weapons.all(),
                        new IdComparator<>(),
                        new WeaponStringifier()
                ),
                new CommandToEquipKnightWithWearableExecutor<>(
                        System.in,
                        new SimpleView(manager.getValue("equipKnightWithArmor")),
                        new SimpleView(manager.getValue("invalidInput")),
                        new SimpleView(manager.getValue("typeKnightId")),
                        new SimpleView(manager.getValue("typeArmorId")),
                        database.armors,
                        database.knights
                ),
                new CommandToEquipKnightWithWearableExecutor<>(
                        System.in,
                        new SimpleView(manager.getValue("equipKnightWithWeapon")),
                        new SimpleView(manager.getValue("invalidInput")),
                        new SimpleView(manager.getValue("typeKnightId")),
                        new SimpleView(manager.getValue("typeWeaponId")),
                        database.weapons,
                        database.knights
                )
        ).run();
    }
}
