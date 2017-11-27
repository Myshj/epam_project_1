package controllers.displayers.database_related;

import models.equipment.wearable.Wearable;
import views.ListView;
import views.stringifiers.ListStringifier;
import views.stringifiers.Stringifier;

import java.util.Comparator;
import java.util.List;

public class WearableListDisplayer<T extends Wearable> implements Runnable {
    private final List<T> items;
    private final String header;
    private final Stringifier<T> itemStringifier;
    private final Comparator<T> comparator;

    public WearableListDisplayer(
            String header,
            List<T> items,
            Comparator<T> comparator,
            Stringifier<T> itemStringifier
    ) {
        this.header = header;
        this.itemStringifier = itemStringifier;
        this.items = items;
        this.comparator = comparator;
    }

    @Override
    public void run() {
        displayItems();
    }

    private void displayItems() {
        new ListView<>(
                header,
                items,
                comparator,
                new ListStringifier<>(itemStringifier)
        ).display();
    }
}
