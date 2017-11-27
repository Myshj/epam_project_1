package databases.exceptions;

public class NoSuchEntityException extends RuntimeException {
    @Override
    public String getMessage() {
        return "No entity with such id found.";
    }
}
