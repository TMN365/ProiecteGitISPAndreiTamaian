package Exercise1;

import java.util.Random;

public class Tiger extends Animal implements Carnivorous {
    private int chanceToHuntSuccesfully;

    Tiger(String name, int age) {
        Random r = new Random();
        this.chanceToHuntSuccesfully = r.nextInt(100) + 1;
        this.species = "Tiger";
        this.age = age;
        this.name = name;
        //eat();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getChancesToHuntSuccesfully() {
        return this.chanceToHuntSuccesfully;
    }

    @Override
    public void huntSuccesfully() {
        System.out.println(this.species + " " + this.name + " hunt succesfully at age " + this.age + " with a chance of " + this.chanceToHuntSuccesfully + "%");
    }

    @Override
    public void huntFailed() {
        System.out.println(this.species + " " + this.name + " hunt failed at age " + this.age + " with a chance of " + this.chanceToHuntSuccesfully + "%");
    }

    @Override
    public void eat() {
        System.out.print(this.species + " eats meat\n");
    }
}
