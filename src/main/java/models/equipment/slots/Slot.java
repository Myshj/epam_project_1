package models.equipment.slots;

import models.Named;

public abstract class Slot extends Named {
    Slot(
            int id,
            String name
    ) {
        super(id, name);
    }
}
