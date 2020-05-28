package javaApiLearning.ConstructorTesting;

public class Main {
    public static void main(String[] args) {
        Fruit fruit = new Fruit();
        Apple apple = new Apple();
        Strawberry strawberry = new Strawberry();

        FruitContainer fruitContainer = new FruitContainer(fruit);

        System.out.println("Fruit container 1: " + ((Fruit) fruitContainer.getFruit()).getName());
        FruitContainer<Fruit> fruitContainer1 = new FruitContainer<>(fruit);

        System.out.println("Fruit container 2: " + fruitContainer1.getFruit().getName());
        FruitContainer<Apple> appleFruitContainer = new FruitContainer<>(apple);

        System.out.println("Apple container: " + appleFruitContainer.getFruit().getName());
        FruitContainer<Strawberry> strawberryFruitContainer = new FruitContainer<>(strawberry);

        System.out.println("Strawberry container: " + strawberryFruitContainer.getFruit().getName());
    }
}
