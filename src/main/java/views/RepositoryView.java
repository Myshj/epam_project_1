package views;

import databases.Repository;
import models.Model;
import views.stringifiers.ListStringifier;
import views.stringifiers.RepositoryStringifier;

import java.util.List;

public class RepositoryView<T extends Model> extends View {
    private final Repository<T> repository;
    private final ListStringifier<T> listStringifier;

    public RepositoryView(
            String header,
            Repository<T> repository,
            ListStringifier<T> listStringifier
    ) {
        super(
                String.format("%20s", "№") + header,
                "",
                ""
        );
        this.repository = repository;
        this.listStringifier = listStringifier;
    }

    private void updateRepository(){
        body = new RepositoryStringifier<>(listStringifier).apply(repository);
    }

    @Override
    public void display() {
        updateRepository();
        super.display();
    }
}
