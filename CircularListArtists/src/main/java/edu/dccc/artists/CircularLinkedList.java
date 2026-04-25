package edu.dccc.artists;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

class CircularIterator<T> implements ListIterator<T> {
    private LinkedList<T> list;
    private ListIterator<T> listIterator;
    private boolean wasGoingForward = true;

    public CircularIterator(LinkedList<T> list) {
        this.list = list;
        listIterator = list.listIterator();
    }

    @Override
    public boolean hasNext() {
        return !list.isEmpty();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more elements in the circular list.");
        }

        // Seamlessly adjust the cursor when switching from Previous to Next
        if (!wasGoingForward) {
            wasGoingForward = true;
            if (listIterator.hasNext()) listIterator.next();
        }

        if (!listIterator.hasNext()) {
            listIterator = list.listIterator(0);
        }

        return listIterator.next();
    }

    @Override
    public boolean hasPrevious() {
        return !list.isEmpty();
    }

    @Override
    public T previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException("No more elements in the circular list.");
        }

        // Seamlessly adjust the cursor when switching from Next to Previous
        if (wasGoingForward) {
            wasGoingForward = false;
            if (listIterator.hasPrevious()) listIterator.previous();
        }

        if (!listIterator.hasPrevious()) {
            listIterator = list.listIterator(list.size());
        }

        return listIterator.previous();
    }

    @Override
    public int nextIndex() {
        return listIterator.nextIndex();
    }

    @Override
    public int previousIndex() {
        return listIterator.previousIndex();
    }

    @Override
    public void remove() {
        listIterator.remove();
    }

    @Override
    public void set(T t) {
        listIterator.set(t);
    }

    @Override
    public void add(T t) {
        listIterator.add(t);
    }
}

public class CircularLinkedList<T> extends LinkedList<T> {

    @Override
    public ListIterator<T> iterator() {
        return new CircularIterator<>(this);
    }

    @Override
    public T get(int index) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("List is empty");
        }
        int normalizedIndex = (index % size() + size()) % size();
        return super.get(normalizedIndex);
    }
}