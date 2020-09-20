package list;

public class App {

    public static void main(String[] args) {
        testList(new SimpleArrayList<>());
        testList(new SimpleLinkedList<>());
    }

    private static void testList(SimpleList list) {
        System.out.println("Initial size: " + list.size());
        list.add("element #1");
        System.out.println("Added element '" + list.get(0) + "', size: " + list.size());
        list.add(null);
        System.out.println("Added element '" + list.get(1) + "', size: " + list.size());

        list.clear();
        System.out.println("List is cleared, size: " + list.size());

        System.out.println("Initial size: " + list.size());
        list.add("element #1");
        System.out.println("Added element '" + list.get(0) + "', size: " + list.size());
        list.add(null);
        System.out.println("Added element '" + list.get(1) + "', size: " + list.size());

        Object obj = list.get(1);
        list.remove(obj);
        System.out.println("Removed element '" + obj + "', size: " + list.size());
        list.remove(0);
        System.out.println("Removed element #0, size: " + list.size());
    }
}
