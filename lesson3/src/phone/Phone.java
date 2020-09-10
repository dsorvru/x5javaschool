package phone;

public class Phone {

    private String number;
    private String model;
    private int weight;

    public Phone() {
    }

    public Phone(String number, String model) {
        this.number = number;
        this.model = model;
    }

    public Phone(String number, String model, int weight) {
        this(number, model);
        this.weight = weight;
    }

    public void receiveCall(String callerName) {
        System.out.println("Звонит " + callerName);
    }

    public void receiveCall(String callerName, String callerNumber) {
        System.out.println("Звонит " + callerName + ", номер " + callerNumber);
    }

    public void sendMessage(String...  numbers) {
        for (String number: numbers) {
            System.out.println(number);
        }
    }

    public String getNumber() {
        return number;
    }

    public static void main(String[] args) {
        Phone[] phones = new Phone[3];
        for (int i = 0; i < 3; i++) {
            phones[i] = new Phone();
            phones[i].number = "495000000" + i;
            phones[i].model = "model" + i + 1;
            phones[i].weight = 100 + i;
        }

        for (int i = 0; i < phones.length; i++) {
            System.out.println("Phone " + (i + 1) + ":"
                    + " number = " + phones[i].number
                    + ", model = " + phones[i].model
                    + ", weight = " + phones[i].weight);
        }

        for (int i = 0; i < phones.length; i++) {
            phones[i].receiveCall("John Smith");
            System.out.println(phones[i].getNumber());
        }

        phones[0].receiveCall("John Smith", "4959999999");
    }

}
