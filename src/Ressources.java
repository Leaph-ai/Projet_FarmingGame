import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Ressources {
    private static final IntegerProperty money = new SimpleIntegerProperty(100);
    private static final IntegerProperty tomatoSeeds = new SimpleIntegerProperty(0);
    private static final IntegerProperty wheetSeeds = new SimpleIntegerProperty(0);
    private static final IntegerProperty harvestedTomatoes = new SimpleIntegerProperty(0);
    private static final IntegerProperty harvestedWheat = new SimpleIntegerProperty(0);

    public static int getMoney() {
        return money.get();
    }

    public static void setMoney(int value) {
        money.set(value);
    }

    public static IntegerProperty moneyProperty() {
        return money;
    }

    public static int getTomatoSeeds() {
        return tomatoSeeds.get();
    }

    public static void addTomatoSeeds(int amount) {
        tomatoSeeds.set(tomatoSeeds.get() + amount);
    }

    public static IntegerProperty tomatoSeedsProperty() {
        return tomatoSeeds;
    }

    public static int getWheetSeeds() {
        return wheetSeeds.get();
    }

    public static void addWheetSeeds(int amount) {
        wheetSeeds.set(wheetSeeds.get() + amount);
    }

    public static IntegerProperty wheetSeedsProperty() {
        return wheetSeeds;
    }

    public static int getHarvestedTomatoes() {
        return harvestedTomatoes.get();
    }

    public static void addHarvestedTomatoes(int amount) {
        harvestedTomatoes.set(harvestedTomatoes.get() + amount);
    }

    public static IntegerProperty harvestedTomatoesProperty() {
        return harvestedTomatoes;
    }

    public static int getHarvestedWheat() {
        return harvestedWheat.get();
    }

    public static void addHarvestedWheat(int amount) {
        harvestedWheat.set(harvestedWheat.get() + amount);
    }

    public static IntegerProperty harvestedWheatProperty() {
        return harvestedWheat;
    }

    private static final IntegerProperty chickens = new SimpleIntegerProperty(0);
    private static final IntegerProperty eggs = new SimpleIntegerProperty(0);
    private static final IntegerProperty cows = new SimpleIntegerProperty(0);
    private static final IntegerProperty milk = new SimpleIntegerProperty(0);

    public static int getChickens() {
        return chickens.get();
    }

    public static void addChickens(int amount) {
        chickens.set(chickens.get() + amount);
    }

    public static IntegerProperty chickensProperty() {
        return chickens;
    }

    // Getters et setters pour eggs
    public static int getEggs() {
        return eggs.get();
    }

    public static void addEggs(int amount) {
        eggs.set(eggs.get() + amount);
    }

    public static IntegerProperty eggsProperty() {
        return eggs;
    }

    // Getters et setters pour cows
    public static int getCows() {
        return cows.get();
    }

    public static void addCows(int amount) {
        cows.set(cows.get() + amount);
    }

    public static IntegerProperty cowsProperty() {
        return cows;
    }

    public static int getMilk() {
        return milk.get();
    }

    public static void addMilk(int amount) {
        milk.set(milk.get() + amount);
    }

    public static IntegerProperty milkProperty() {
        return milk;
    }

}