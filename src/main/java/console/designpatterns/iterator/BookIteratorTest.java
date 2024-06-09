package console.designpatterns.iterator;


import java.util.ArrayList;

/**
 * @author Sarav on 08 May 2024
 * @project govtech
 * @package com.govtech.viswa.designpatterns.iterator
 * @class BookIteratorTest
 */

class Book {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}


class BookIterator implements Iterator {
    private BookCollection collection;
    private int index;

    public BookIterator(BookCollection collection) {
        this.collection = collection;
        this.index = 0;
    }

    public boolean hasNext() {
        return index < collection.size();
    }

    public Object next() {
        return collection.get(index++);
    }
}

class BookCollection extends ArrayList<Book> {

    public Iterator<Book> getIterator() {
        return new BookIterator(this);
    }

    @Override
    public boolean add(Book e) {
        super.add(e);
        return true;
    }


}

public class BookIteratorTest  {
    public static void main(String[] args) {
        BookCollection collection = new BookCollection();
        collection.add(new Book("The Java Book"));
        collection.add(new Book("Design Patterns"));

        Iterator<Book> iterator = collection.getIterator();

        while (iterator.hasNext()) {
            Book book = iterator.next();
            System.out.println(book.getTitle());
        }
    }
}

