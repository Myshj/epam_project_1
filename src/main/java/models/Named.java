package models;

public abstract class Named extends Model {
    private final String name;

    public Named(
            int id,
            String name
    ) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
