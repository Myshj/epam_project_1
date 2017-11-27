package controllers;

import views.Displayable;

import java.io.InputStream;

public class MainMenuController extends UserInputController {

    private static final String LIST_KNIGHTS = "1";
    private static final String LIST_ARMOR = "2";
    private static final String LIST_WEAPON = "3";
    private static final String LIST_ARMOR_SORTED_BY_WEIGHT = "4";
    private static final String LIST_WEAPON_SORTED_BY_WEIGHT = "5";
    private static final String FIND_ARMOR_BY_PRICE = "6";
    private static final String FIND_WEAPON_BY_PRICE = "7";
    private static final String WEAR_ARMOR = "8";
    private static final String WEAR_WEAPON = "9";
    private static final String EXIT = "10";


    private final Displayable allKnightsView;
    private final Runnable allArmorDisplayer;
    private final Runnable armorSortedByWeightDisplayer;
    private final Runnable allWeaponDisplayer;
    private final Runnable weaponSortedByWeightDisplayer;
    private final Runnable armorFilteredByPriceDisplayer;
    private final Runnable weaponFilteredByPriceDisplayer;

    private final Runnable wearArmorExecutor;
    private final Runnable wearWeaponExecutor;

    public MainMenuController(
            InputStream input,
            Displayable view,
            Displayable inputErrorView,
            Displayable allKnightsView,
            Runnable allArmorDisplayer,
            Runnable armorSortedByWeightDisplayer,
            Runnable allWeaponDisplayer,
            Runnable weaponSortedByWeightDisplayer,
            Runnable armorFilteredByPriceDisplayer,
            Runnable weaponFilteredByPriceDisplayer,
            Runnable wearArmorExecutor,
            Runnable wearWeaponExecutor
    ) {
        super(input, view, inputErrorView);
        this.allKnightsView = allKnightsView;
        this.allArmorDisplayer = allArmorDisplayer;
        this.allWeaponDisplayer = allWeaponDisplayer;
        this.armorSortedByWeightDisplayer = armorSortedByWeightDisplayer;
        this.weaponSortedByWeightDisplayer = weaponSortedByWeightDisplayer;
        this.armorFilteredByPriceDisplayer = armorFilteredByPriceDisplayer;
        this.weaponFilteredByPriceDisplayer = weaponFilteredByPriceDisplayer;
        this.wearArmorExecutor = wearArmorExecutor;
        this.wearWeaponExecutor = wearWeaponExecutor;
    }

    @Override
    protected void onMessage(String message) {
        switch (message) {
            case LIST_KNIGHTS:
                allKnightsView.display();
                break;
            case LIST_ARMOR:
                allArmorDisplayer.run();
                break;
            case LIST_WEAPON:
                allWeaponDisplayer.run();
                break;
            case LIST_ARMOR_SORTED_BY_WEIGHT:
                armorSortedByWeightDisplayer.run();
                break;
            case LIST_WEAPON_SORTED_BY_WEIGHT:
                weaponSortedByWeightDisplayer.run();
                break;
            case FIND_ARMOR_BY_PRICE:
                armorFilteredByPriceDisplayer.run();
                break;
            case FIND_WEAPON_BY_PRICE:
                weaponFilteredByPriceDisplayer.run();
                break;
            case WEAR_ARMOR:
                wearArmorExecutor.run();
                break;
            case WEAR_WEAPON:
                wearWeaponExecutor.run();
                break;
            case EXIT:
                stop();
                return;
            default:
                displayErrorView();
                break;
        }
        displayView();
    }
}
