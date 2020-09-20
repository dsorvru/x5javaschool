package fruit;

import java.util.ArrayList;

public class App {


    public static void main(String[] args) {
        Box<Apple> appleBox1 = new Box<>();
        appleBox1.add(new Apple());
        System.out.println("apple box #1: " + appleBox1);

        Box<Apple> appleBox2 = new Box<>();
        appleBox2.add(new Apple());
        //appleBox2.add(new Orange());

        System.out.println("apple box #2: " + appleBox2);
        System.out.println("Moving apples from box2 to box1...");
        appleBox2.moveContentTo(appleBox1);
        System.out.println("apple box #1: " + appleBox1);
        System.out.println("apple box #2: " + appleBox2);

        Box<Orange> orangeBox1 = new Box<>();
        orangeBox1.add(new Orange());
        System.out.println("orange box: " + orangeBox1);

        //appleBox1.moveContentTo(orangeBox1);

        System.out.println("Comparison of apple box #1 and apple box #2: " + appleBox1.compare(appleBox2));
        System.out.println("Comparison of apple box #1 and oracle box: " + appleBox1.compare(orangeBox1));

    }
}
