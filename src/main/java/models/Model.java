package models;

public abstract class Model {

    private final int id;

    public Model(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
