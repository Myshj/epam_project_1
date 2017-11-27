package controllers.command_executors;

import controllers.UserInputController;
import controllers.displayers.database_related.WearableListDisplayer;
import models.equipment.wearable.Wearable;
import service.specifications.WearablePriceSpecification;
import views.Displayable;
import views.stringifiers.Stringifier;

import java.io.InputStream;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CommandToFilterWearablesByPriceExecutor<T extends Wearable> extends UserInputController {
    private final Displayable enterMinView;
    private final Displayable enterMaxView;
    private final String header;
    private final List<T> items;
    private final Comparator<T> comparator;
    private final Stringifier<T> itemStringifier;
    private State state = State.WAITING;
    private long minPrice;
    private long maxPrice;
    public CommandToFilterWearablesByPriceExecutor(
            InputStream input,
            Displayable view,
            Displayable inputErrorView,
            Displayable enterMinView,
            Displayable enterMaxView,
            String header,
            List<T> items,
            Comparator<T> comparator,
            Stringifier<T> itemStringifier
    ) {
        super(input, view, inputErrorView);
        this.enterMinView = enterMinView;
        this.enterMaxView = enterMaxView;
        this.header = header;
        this.items = items;
        this.comparator = comparator;
        this.itemStringifier = itemStringifier;
    }

    @Override
    protected void onStarted() {
        super.onStarted();
        enterMinView.display();
        state = State.READING_MIN;
    }

    private List<T> filterItems() {
        return items.stream().filter(
                new WearablePriceSpecification<>(minPrice, maxPrice)
        ).collect(Collectors.toList());
    }

    @Override
    protected void onMessage(String message) {
        try {
            long value = Long.parseUnsignedLong(message);
            switch (state) {
                case READING_MIN:
                    minPrice = value;
                    state = State.READING_MAX;
                    enterMaxView.display();
                    break;
                case READING_MAX:
                    maxPrice = value;
                    state = State.WAITING;
                    new WearableListDisplayer<>(
                            header,
                            filterItems(),
                            comparator,
                            itemStringifier
                    ).run();
                    stop();
                    break;
            }
        } catch (NumberFormatException e) {
            displayErrorView();
        }

    }

    protected static enum State {
        WAITING,
        READING_MIN,
        READING_MAX
    }

}
