package fruit;

import java.util.ArrayList;
import java.util.List;

public class Box<E extends Fruit> {

    private List<E> content = new ArrayList<E>();

    public float getWeight() {
        float weight = 0f;
        if (content.size() != 0) {
            weight = content.size() * content.get(0).getWeight();
        }
        return weight;
    }

    public int getCount() {
        return content.size();
    }

    public void add(E e) {
        content.add(e);
    }

    public boolean compare(Box<? extends Fruit> b) {
        return (b == null) ? false : this.getWeight() == b.getWeight();
    }

    @Override
    public String toString() {
        return "Box{" +
                "content=" + content +
                '}';
    }

    public List<E> getContent() {
        return content;
    }

    public void moveContentTo(Box<E> b) {
        b.addAll(this);
        this.clear();
    }

    private void clear() {
        content.clear();
    }

    private void addAll(Box<E> b) {
        this.content.addAll(b.getContent());
    }

}



