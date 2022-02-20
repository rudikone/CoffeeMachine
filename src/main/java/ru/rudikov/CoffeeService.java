package ru.rudikov;

import java.util.Arrays;
import java.util.Scanner;

import static ru.rudikov.CoffeeType.valueOf;

public class CoffeeService {

    private final Scanner scanner;
    private final CoffeeMachine coffeeMachine;

    public CoffeeService(Scanner scanner, CoffeeMachine coffeeMachine) {
        this.scanner = scanner;
        this.coffeeMachine = coffeeMachine;
    }

    public void runCoffeeMachine() {
        if (scanner.hasNextLine()) {
            String stringsFromConsole = scanner.nextLine();

            isTurnOff(stringsFromConsole);

            String[] words = stringsFromConsole.split("\\s");
            if (isUnknownCommand(words)) {
                System.out.println("Unknown command!");
                return;
            }

            String command = words[0];
            int volume = getVolume(words[1]);

            switch (command.toUpperCase()) {
                case "WATER":
                    addWater(coffeeMachine, volume);
                    break;
                case "MILK":
                    addMilk(coffeeMachine, volume);
                    break;
                case "COFFEE":
                    addCoffee(coffeeMachine, volume);
                    break;
                default:
                    createCoffee(coffeeMachine, getCoffeeType(command), volume);
            }
        }
    }

    private boolean isUnknownCommand(String[] words) {
        return words.length != 2
                || words[0].isBlank()
                || words[1].isBlank()
                || (Arrays.stream(CoffeeType.values()).noneMatch(e -> e.name().equals(words[0].toUpperCase()))
                && Arrays.stream(CommandType.values()).noneMatch(e -> e.name().equals(words[0].toUpperCase())));
    }

    private void createCoffee(CoffeeMachine coffeeMachine, CoffeeType coffeeType, int volumeOfCup) {

        if (volumeOfCup < 10) {
            System.out.println("Minimum volume is 10 ml!");
            return;
        }
        int newCoffeeVolume = coffeeMachine.getCoffeeVolume() - (volumeOfCup * coffeeType.getCoffeePercent() / 100);
        if (newCoffeeVolume < 0) {
            System.out.println("Not enough coffee!");
            return;
        }

        int newWaterVolume = coffeeMachine.getWaterVolume() - (volumeOfCup * coffeeType.getWaterPercent() / 100);
        if (newWaterVolume < 0) {
            System.out.println("Not enough water!");
            return;
        }

        int newMilkVolume = coffeeMachine.getMilkVolume() - (volumeOfCup * coffeeType.getMilkPercent() / 100);
        if (newMilkVolume < 0) {
            System.out.println("Not enough milk!");
            return;
        }

        coffeeMachine.setCoffeeVolume(newCoffeeVolume);
        coffeeMachine.setWaterVolume(newWaterVolume);
        coffeeMachine.setMilkVolume(newMilkVolume);

        getVolumesOfCoffeeMachine(coffeeMachine);
    }

    private void addWater(CoffeeMachine coffeeMachine, int addedWater) {
        if (addedWater < 0) {
            System.out.println("Can't drain water!");
            return;
        }

        int newWaterVolume = coffeeMachine.getWaterVolume() + addedWater;
        newWaterVolume = Math.min(newWaterVolume, coffeeMachine.getWaterTank());
        coffeeMachine.setWaterVolume(newWaterVolume);

        getVolumesOfCoffeeMachine(coffeeMachine);
    }

    private void addCoffee(CoffeeMachine coffeeMachine, int addedCoffee) {
        if (addedCoffee < 0) {
            System.out.println("Coffee can only be added!");
            return;
        }

        int newCoffeeVolume = coffeeMachine.getCoffeeVolume() + addedCoffee;
        newCoffeeVolume = Math.min(newCoffeeVolume, coffeeMachine.getCoffeeTank());
        coffeeMachine.setCoffeeVolume(newCoffeeVolume);

        getVolumesOfCoffeeMachine(coffeeMachine);
    }

    private void addMilk(CoffeeMachine coffeeMachine, int addedMilk) {
        if (addedMilk < 0) {
            System.out.println("Can't spill milk!");
            return;
        }

        int newMilkVolume = coffeeMachine.getMilkVolume() + addedMilk;
        newMilkVolume = Math.min(newMilkVolume, coffeeMachine.getMilkTank());
        coffeeMachine.setMilkVolume(newMilkVolume);

        getVolumesOfCoffeeMachine(coffeeMachine);
    }

    private void getVolumesOfCoffeeMachine(CoffeeMachine coffeeMachine) {
        System.out.println(coffeeMachine.getCoffeeVolume() + " "
                + coffeeMachine.getWaterVolume() + " "
                + coffeeMachine.getMilkVolume());
    }

    private void isTurnOff(String command) {
        if (command.equalsIgnoreCase("turn off")) {
            System.out.println("turn off...");
            System.out.println("bye-bye!");
            System.exit(0);
        }
    }

    private CoffeeType getCoffeeType(String type) {
        return valueOf(type.toUpperCase());
    }

    private static Integer getVolume(String volume) {
        return Integer.valueOf(volume);
    }
}
