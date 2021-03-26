package Exercise1;

import java.util.Random;

public class Dear extends Animal implements Herbivorous {
    private int chanceToRunSuccesfully;

    Dear(String name, int age) {
        Random r = new Random();
        this.chanceToRunSuccesfully = r.nextInt(100) + 1;
        this.species = "Dear";
        this.age = age;
        this.name = name;
        //eat();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getChancesToRunSuccesfully() {
        return this.chanceToRunSuccesfully;
    }

    @Override
    public void runSuccesfully() {
        System.out.println(this.species + " " + this.name + " ran succesfully at age " + this.age + " with a chance of " + this.chanceToRunSuccesfully + "%");
    }

    @Override
    public void runFailed() {
        System.out.println(this.species + " " + this.name + " run failed at age " + this.age + " with a chance of " + this.chanceToRunSuccesfully + "%");
    }

    @Override
    public void eat() {
        System.out.print(this.species + " eats herbs\n");
    }
}