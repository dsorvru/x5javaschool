package list;

import java.util.Objects;

public class SimpleArrayList<E> implements SimpleList<E> {

    private Object[] elements = {};
    private int size = 0;

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void add(E item) {
        grow();
        elements[size] = item;
        size++;
    }

    @Override
    public void remove(int index) throws IndexOutOfBoundsException {
        checkIndexRange(index);
        int newSize = size - 1;
        if (newSize > index) {
            System.arraycopy(elements, index + 1, elements, index, newSize - index);
        }
        elements[newSize] = null;
        size = newSize;
    }

    @Override
    public void remove(E item) {
        int index = indexOf(item);
        if (index >= 0) {
            remove(index);
        }
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        checkIndexRange(index);
        return (E)elements[index];
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            this.elements[i] = null;
        }
        size = 0;
    }

    private void checkIndexRange(int index) throws IndexOutOfBoundsException {
        if ((index) < 0 || (index >= size)) {
            throw new IndexOutOfBoundsException(index);
        }
    }

    private int indexOf(E item) {
        int index = -1;

        for (int i = 0; i < size; i++) {
            if (Objects.equals(item, elements[i])) {
                index = i;
                break;
            }
        }
        return index;
    }

    private void grow() {
        if (size == elements.length) {
            Object[] arr = new Object[elements.length + 1];
            System.arraycopy(elements, 0, arr, 0, elements.length);
            elements = arr;
        }
    }
}
