/*
* Name: Ben Le
* Class: CS1150 (M/W)
* Due: Dec 4, 2024
* Description: Assignment #12
* This program simulates the behavior of different animals.
* It creates various animal objects such as Bear, Elephant, Monkey, and Sloth, using inheritance to share common behaviors and attributes. 
* The program reads input data from the Aninmals.txt file, creates instances of each animal, and simulates them eating, sleeping, and swimming.
*/


import java.io.File; 
import java.io.IOException;
import java.util.Scanner;

// creating Animal class and its variables
class Animal {
    private String name; 
    private String food; 
    private int weight; 
    private int sleep; 
    private String location; 

Animal(String name, String food, int weight, int sleep, String location) { 
    this.name = name; 
    this.food = food; 
    this.weight = weight; 
    this.sleep = sleep; 
    this.location = location;
    }

    // creating getters 

    public String getName() { 
        return name;
    }

    public String getFood() { 
        return food;
    }

    public int getWeight() { 
        return weight; 
    }

    public int getSleep() { 
        return sleep;
    }

    public String getLocation() {
        return location;
    }

    // animal methods

    public void eat() { 
        System.out.println("Animal is eating.");
    }

    public void sleep() { 
        System.out.println("Animal is sleeping - do not disturb");
    }

    public void swim() {
        System.out.println("Animal is swimming.");
    }

    @Override
    public String toString() {
        return  getClass().getSimpleName()+ ": " + "Name: " + name + " - Weighs: " + weight + " lbs - Sleeps: " + sleep + " hours - Location: " + location;
    }
}

// creating subclasses 

class Bear extends Animal {
    public Bear(String name, String food, int weight, int sleep, String location) {
        super(name, food, weight, sleep, location);
    }

    @Override
    public void eat() {
        System.out.println("Bear is eating " + getFood());
    }

    @Override
    public void sleep() {
        System.out.println("Bear is sleeping " + getSleep() + " hours");
    }

    @Override
    public void swim() {
        System.out.println("Bear is swimming");
    }
}

class Elephant extends Animal {
    public Elephant(String name, String food, int weight, int sleep, String location) {
        super(name, food, weight, sleep, location);
    }

    @Override
    public void sleep() {
        System.out.println("Elephant is sleeping " + getSleep() + " hours");
    }
}

class Monkey extends Animal {
    public Monkey(String name, String food, int weight, int sleep, String location) {
        super(name, food, weight, sleep, location);
    }

    @Override
    public void eat() {
        System.out.println("Monkey is eating " + getFood());
    }

    @Override
    public void swim() {
        System.out.println("Monkey is swimming");
    }
}

class Sloth extends Animal {
    public Sloth(String name, String food, int weight, int sleep, String location) {
        super(name, food, weight, sleep, location);
    }
}

// main 

public class LeBenAssignment12 {
    public static void main(String[] args) throws IOException {
        File inputFileName = new File("Animals.txt");
        Scanner inputFile = new Scanner(inputFileName);

        int numAnimals = inputFile.nextInt();
        Animal[] animals = new Animal[numAnimals];

        for (int i = 0; i < numAnimals; i++) {
            String type = inputFile.next();
            String name = inputFile.next();
            String food = inputFile.next();
            int weight = inputFile.nextInt();
            int sleep = inputFile.nextInt();
            String location = inputFile.nextLine().trim();

            switch (type.toLowerCase()) {
                case "bear":
                    animals[i] = new Bear(name, food, weight, sleep, location);
                    break;
                case "elephant":
                    animals[i] = new Elephant(name, food, weight, sleep, location);
                    break;
                case "monkey":
                    animals[i] = new Monkey(name, food, weight, sleep, location);
                    break;
                case "sloth":
                    animals[i] = new Sloth(name, food, weight, sleep, location);
                    break;
                default:
                    System.out.println("Unknown animal type: " + type);
                    break;
            }
        }

        for (int i = 0; i < animals.length; i++) {
            Animal animal = animals[i];
            System.out.println("Animal[" + i + "] is a " + animal.getClass().getSimpleName());
            System.out.println(animal);
            animal.eat();
            animal.sleep();
            animal.swim();
            System.out.println();
        }

        inputFile.close();
    }
}
