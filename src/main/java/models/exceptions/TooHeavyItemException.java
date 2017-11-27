package models.exceptions;

import service.StringResourceManager;

public class TooHeavyItemException extends RuntimeException {
    @Override
    public String getMessage() {
        return StringResourceManager.INSTANCE.getValue( "couldNotWearTooHeavyItems");
    }
}
