package phone;

public class App {

    public static void main(String[] args) {
        Phone[] phones = new Phone[3];
        for (int i = 0; i < 3; i++) {
            phones[i] = new Phone("495000000" + i, "model" + (i + 1), 100 + i);
        }

        for (int i = 0; i < phones.length; i++) {
            System.out.println("Phone " + (i + 1) + ":"
                    + " number = " + phones[i].getNumber()
                    + ", model = " + phones[i].getModel()
                    + ", weight = " + phones[i].getWeight());
        }

        for (int i = 0; i < phones.length; i++) {
            phones[i].receiveCall("John Smith");
            System.out.println(phones[i].getNumber());
        }

        phones[0].receiveCall("John Smith", "4959999999");
    }
}
