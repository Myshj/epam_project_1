package controllers.command_executors;

import controllers.UserInputController;
import databases.Repository;
import databases.exceptions.NoSuchEntityException;
import models.Knight;
import models.equipment.wearable.Wearable;
import models.exceptions.TooHeavyItemException;
import views.Displayable;

import java.io.InputStream;

public class CommandToEquipKnightWithWearableExecutor<T extends Wearable> extends UserInputController {

    private static enum State {
        WAITING,
        ENTERING_KNIGHT_ID,
        ENTERING_WEARABLE_ID
    }

    private final Repository<T> wearables;
    private final Repository<Knight> knights;

    private final Displayable enterKnightIdView;
    private final Displayable enterWearableIdView;

    private State state;

    private Knight knight;
    private T wearable;

    @Override
    protected void onStarted() {
        super.onStarted();
        state = State.ENTERING_KNIGHT_ID;
        enterKnightIdView.display();
    }

    @Override
    protected void onMessage(String message) {
        try {
            int value = Integer.parseUnsignedInt(message);
            switch (state) {
                case ENTERING_KNIGHT_ID:
                    knight = knights.getById(value);
                    state = State.ENTERING_WEARABLE_ID;
                    enterWearableIdView.display();
                    break;
                case ENTERING_WEARABLE_ID:
                    wearable = wearables.getById(value);
                    state = State.WAITING;
                    knight.wear(wearable);
                    stop();
                    break;
            }
        } catch (NumberFormatException | NoSuchEntityException ex) {
            displayErrorView();
        } catch (TooHeavyItemException ex){
            System.out.println(ex.getMessage());
            stop();
        }
    }

    public CommandToEquipKnightWithWearableExecutor(
            InputStream input,
            Displayable view,
            Displayable inputErrorView,
            Displayable enterKnightIdView,
            Displayable enterWearableIdView,
            Repository<T> wearables,
            Repository<Knight> knights
    ) {
        super(input, view, inputErrorView);
        this.wearables = wearables;
        this.knights = knights;
        this.enterKnightIdView = enterKnightIdView;
        this.enterWearableIdView = enterWearableIdView;
    }
}
