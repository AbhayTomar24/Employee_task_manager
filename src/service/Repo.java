package service;

import java.util.ArrayList;
import java.util.List;

public class Repo<T> {

    private List<T> items = new ArrayList<>();

    public void add(T item) {
        items.add(item);
    }

    public List<T> getAll() {
        return items;
    }
}
