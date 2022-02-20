package ru.rudikov;

public class CoffeeMachine {

    private final int coffeeTank;
    private final int waterTank;
    private final int milkTank;

    private int coffeeVolume;
    private int waterVolume;
    private int milkVolume;

    public CoffeeMachine(int coffeeTank, int waterTank, int milkTank) {
        this.coffeeTank = coffeeTank;
        this.waterTank = waterTank;
        this.milkTank = milkTank;
    }

    public int getCoffeeVolume() {
        return coffeeVolume;
    }

    public int getWaterVolume() {
        return waterVolume;
    }

    public int getMilkVolume() {
        return milkVolume;
    }

    public void setCoffeeVolume(int coffeeVolume) {
        this.coffeeVolume = coffeeVolume;
    }

    public void setWaterVolume(int waterVolume) {
        this.waterVolume = waterVolume;
    }

    public void setMilkVolume(int milkVolume) {
        this.milkVolume = milkVolume;
    }

    public int getCoffeeTank() {
        return coffeeTank;
    }

    public int getWaterTank() {
        return waterTank;
    }

    public int getMilkTank() {
        return milkTank;
    }
}
