package ru.rudikov;

public enum CoffeeType {
    LATTE(30, 10, 60),
    RISTRETTO(50, 50, 0),
    LUNGO(85, 15, 0),
    CAPPUCCINO(40, 15, 45),
    ESPRESSO(70,30,0);

    private final int waterPercent;
    private final int coffeePercent;
    private  final int milkPercent;

    CoffeeType(int waterPercent, int coffeePercent, int milkPercent) {
        this.waterPercent = waterPercent;
        this.coffeePercent = coffeePercent;
        this.milkPercent = milkPercent;
    }

    public int getWaterPercent() {
        return waterPercent;
    }

    public int getCoffeePercent() {
        return coffeePercent;
    }

    public int getMilkPercent() {
        return milkPercent;
    }
}
