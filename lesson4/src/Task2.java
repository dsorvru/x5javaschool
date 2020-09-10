public class Task2 {

    public static void main(String[] args) {
        Car lorry = new Lorry("Модель грузовика", "Класс грузовика",
                5000, new Engine("Производитель двигателя", 2000), 2000);
        Car sportCar = new SportCar("Модель спорткара", "Класс спорткара",
                5000, new Engine("Производитель двигателя", 2500), 300);
        lorry.printInfo();
        sportCar.printInfo();
    }
}
