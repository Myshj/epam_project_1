package views.stringifiers;

import databases.Repository;
import models.Model;

public class RepositoryStringifier<T extends Model> extends Stringifier<Repository<T>> {
    private final ListStringifier<T> listStringifier;

    public RepositoryStringifier(ListStringifier<T> listStringifier) {
        this.listStringifier = listStringifier;
    }

    @Override
    public String apply(
            Repository<T> repository
    ) {
        return listStringifier.apply(repository.all());
    }
}
