package initializers;

import databases.Repository;
import models.Model;

import java.util.List;

public class RepositoryInitializer<T extends Model> extends Initializer {

    private Repository<T> repository;
    private List<T> objects;

    RepositoryInitializer(
            Repository<T> repository,
            List<T> objects
    ) {
        this.repository = repository;
        this.objects = objects;
    }

    @Override
    public void init() {
        objects.forEach(repository::add);
    }
}
