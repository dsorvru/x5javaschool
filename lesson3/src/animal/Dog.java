package animal;

public class Dog extends Animal {
    
    private String breed;

    public Dog(String food, String location, String breed) {
        super(food, location);
        this.breed = breed;
    }
    
    public Dog() {
        this("кость", "будка", "лайка");
    }
    
    @Override
    public void makeNoise() {
        System.out.println("Гав!");
    }

    @Override
    public void eat() {
        System.out.println("Грызет");
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}
