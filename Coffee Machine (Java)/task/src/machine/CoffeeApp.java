package machine;

import java.util.Scanner;

// Define a CoffeeMachine class
class CoffeeMachine {
    // Constants for ingredient amounts per cup
    private static final int WATER_PER_CUP = 200; // ml
    private static final int MILK_PER_CUP = 50;   // ml
    private static final int COFFEE_BEANS_PER_CUP = 15; // g

    private int availableCoffee = 0;
    private int availableMilk = 0;
    private int availableWater = 0;


    public int getAvailableCoffee() {
        return availableCoffee;
    }

    public int getAvailableMilk() {
        return availableMilk;
    }

    public int getAvailableWater() {
        return availableWater;
    }

    public void setAvailableCoffee(int availableCoffee) {
        this.availableCoffee = availableCoffee;
    }

    public void setAvailableMilk(int availableMilk) {
        this.availableMilk = availableMilk;
    }

    public void setAvailableWater(int availableWater) {
        this.availableWater = availableWater;
    }

    // Method to calculate ingredient amounts
    public void prepareCoffee(int cups) {
        int totalWater = cups * WATER_PER_CUP;
        int totalMilk = cups * MILK_PER_CUP;
        int totalCoffeeBeans = cups * COFFEE_BEANS_PER_CUP;

        // Print the required ingredient amounts
        System.out.println("For " + cups + " cups of coffee you will need:");
        System.out.println(totalWater + " ml of water");
        System.out.println(totalMilk + " ml of milk");
        System.out.println(totalCoffeeBeans + " g of coffee beans");
    }

    public void calculator(int numberOfCups) {
        int possibleCupsByWater = getAvailableWater() / WATER_PER_CUP;
        int possibleCupsByMilk = getAvailableMilk() / MILK_PER_CUP;
        int possibleCupsByCoffeeBeans = getAvailableCoffee() / COFFEE_BEANS_PER_CUP;

        int minCups = Math.min(Math.min(possibleCupsByWater, possibleCupsByMilk), possibleCupsByCoffeeBeans);

        if (minCups >= numberOfCups) {
            int additionalCups = minCups - numberOfCups;
            if (additionalCups > 0) {
                System.out.println("Yes, I can make that amount of coffee (and even " + additionalCups + " more than that)");
            } else {
                System.out.println("Yes, I can make that amount of coffee");
            }
        } else {
            System.out.println("No, I can make only " + minCups + " cup(s) of coffee");
        }
    }

}

public class CoffeeApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Instantiate the CoffeeMachine class
        CoffeeMachine coffeeMachine = new CoffeeMachine();

//        System.out.println("Write how many cups of coffee you will need: ");
//        int cups = scanner.nextInt(); // Read the number of cups

        // Call the prepareCoffee method to calculate and print ingredient amounts
//        coffeeMachine.prepareCoffee(cups);
        System.out.println("Write how many ml of water the coffee machine has:\n");
        coffeeMachine.setAvailableWater(scanner.nextInt());
        System.out.println("Write how many ml of milk the coffee machine has:\n");
        coffeeMachine.setAvailableMilk(scanner.nextInt());
        System.out.println("Write how many grams of coffee beans the coffee machine has:\n");
        coffeeMachine.setAvailableCoffee(scanner.nextInt());
        ;
        System.out.println("Write how many cups of coffee you will need:\n");
        int howManyCups = scanner.nextInt();
        coffeeMachine.calculator(howManyCups);
        scanner.close();
    }
}
