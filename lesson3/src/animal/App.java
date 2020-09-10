package animal;

public class App {

    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();
        Horse horse = new Horse();

        Animal[] animals = new Animal[] {
                cat, dog, horse
        };

        Vet vet = new Vet();
        for (Animal animal: animals) {
            vet.treatAnimal(animal);
        }
    }

}
