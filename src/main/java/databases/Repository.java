package databases;

import databases.exceptions.NoSuchEntityException;
import models.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Repository<E extends Model> {
    private List<E> data = new ArrayList<>();

    public void add(E value) {
        data.add(value);
    }

    public void remove(E value) {
        data.remove(value);
    }


    public List<E> all() {
        return new ArrayList<>(data);
    }

    public E getById(int id) {
        for(E element : data){
            if(element.getId() == id){
                return element;
            }
        }
        throw new NoSuchEntityException();
    }

    public List<E> filter(Predicate<E> predicate) {
        return all().stream().filter(predicate).collect(Collectors.toList());
    }
}
