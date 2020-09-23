package task1;

public class App {

    public static void main(String[] args) {
        Shape[] shape = new Shape[3];
        shape[0] = new Triangle(10, 10, 14.14);
        shape[1] = new Circle(10);
        shape[2] = new Rectangle(10, 10);
        for (Shape sh: shape) {
            System.out.println("Площадь фигуры: " + sh.square());
        }
    }
}
