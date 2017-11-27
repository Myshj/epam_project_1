package controllers.displayers.database_related;

import databases.Database;

public abstract class DatabaseRelated implements Runnable {
    protected final Database database;

    public DatabaseRelated(Database database) {
        this.database = database;
    }
}
