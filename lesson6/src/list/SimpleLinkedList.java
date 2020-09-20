package list;

import java.util.Objects;

public class SimpleLinkedList<E> implements SimpleList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void add(E item) {
        Node<E> newNode = new Node<E>(tail, item, null);
        if (tail == null) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    @Override
    public void remove(int index) throws IndexOutOfBoundsException {
        checkIndexRange(index);
        Node<E> node = getNodeAt(index);
        unlink(node);
    }

    @Override
    public void remove(E item) {
        Node<E> node = head;
        while (node != null) {
            if (Objects.equals(item, node.item)) {
                unlink(node);
                break;
            }
            node = node.next;
        }
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        checkIndexRange(index);
        return getNodeAt(index).item;
    }

    @Override
    public void clear() {
        while (head != null) {
            Node<E> next = head.next;
            head.item = null;
            head.next = null;
            head.prev = null;
            head = next;
        }
        tail = null;
        size = 0;
    }

    private void checkIndexRange(int index) throws IndexOutOfBoundsException {
        if ((index) < 0 || (index >= size)) {
            throw new IndexOutOfBoundsException(index);
        }
    }

    private Node<E> getNodeAt(int index) {
        if (index < size / 2) {
            Node<E> node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else {
            Node<E> node = tail;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
            return node;
        }
    }

    private void unlink(Node<E> node) {
        Node<E> next = node.next;
        Node<E> prev = node.prev;

        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
            node.prev = null;
        }

        if (next == null) {
            tail = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }

        node.next = null;
        size--;
    }

    private static class Node<E> {
        public Node<E> prev;
        public Node<E> next;
        public E item;

        public Node(Node<E> prev, E item, Node<E> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

}
