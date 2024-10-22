package interview_prep.CollectionsFramework;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/*
 Generic list which has to be able to
 Iterate the list
 add element
 remove element
 update element
 */
public class GenericList<T> implements Iterable<T> {
    private T[] array;
    private int size;
    private int length;

    public GenericList() {
        this(100);
    }

    public GenericList(int length) {
        this.size = 0;
        this.length = length;
        array = (T[])new Object[length];
    }

    public void addItem(T item) {
        if(size < length) {
            array[size ++] = item;
        } else {
            length *= (int) 1.5; /* increase the size by 50%*/
        }
    }

    public T getItem(int index) {
        if(index < this.size) {
            return array[index];
        } else {
            throw new IndexOutOfBoundsException("Index is beyond array limits");
        }
    }

    public void setItem(T item, int index) {
        if(index < this.size) {
           array[index] = item;
        } else {
            throw new IndexOutOfBoundsException("Index is beyond array limits");
        }
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new GenericIterator(this);
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<T> spliterator() {
        return Iterable.super.spliterator();
    }

    /*
    Inner class implementing the Iterator inteface
    to give the functionality of
    hasNext, next and remove
     */
    public class GenericIterator implements Iterator<T> {

        private GenericList<T> list;
        int index = 0;

        public GenericIterator(GenericList<T> list) {
            this.list = list;
        }

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            return array[index ++];
        }

        @Override
        public void remove() {
            Iterator.super.remove();
        }
    }

}
