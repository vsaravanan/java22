package com.saravanjs.java22.console.designpatterns.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sarav on 08 May 2024
 * @project govtech
 * @package com.govtech.viswa.designpatterns.iterator
 * @class IteratorPattern
 */




// Step 1: Iterator interface
interface Iterator<T> {
    boolean hasNext();
    T next();
}

// Step 2: Concrete Iterator
class ListIterator<T> implements Iterator<T> {
    private List<T> list;
    private int index;

    public ListIterator(List<T> list) {
        this.list = list;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    @Override
    public T next() {
        return list.get(index++);
    }
}

// Step 3: Aggregate interface
interface Aggregate<T> {
    Iterator<T> createIterator();
}

// Step 4: Concrete Aggregate
class ListAggregate<T> implements Aggregate<T> {
    private List<T> list;

    public ListAggregate() {
        this.list = new ArrayList<>();
    }

    public void add(T element) {
        list.add(element);
    }

    @Override
    public Iterator<T> createIterator() {
        return new ListIterator<>(list);
    }
}

// Step 5: Client code
public class IteratorPattern {
    public static void main(String[] args) {
        ListAggregate<String> aggregate = new ListAggregate<>();
        aggregate.add("A");
        aggregate.add("B");
        aggregate.add("C");

        Iterator<String> iterator = aggregate.createIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
