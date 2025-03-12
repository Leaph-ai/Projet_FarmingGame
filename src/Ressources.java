import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Ressources {
    // Propriétés observables pour les ressources
    private static final IntegerProperty money = new SimpleIntegerProperty(100);
    private static final IntegerProperty tomatoSeeds = new SimpleIntegerProperty(0);
    private static final IntegerProperty wheetSeeds = new SimpleIntegerProperty(0);
    private static final IntegerProperty harvestedTomatoes = new SimpleIntegerProperty(0);
    private static final IntegerProperty harvestedWheat = new SimpleIntegerProperty(0);

    // Getter et setter pour 'money'
    public static int getMoney() {
        return money.get();
    }

    public static void setMoney(int value) {
        money.set(value);
    }

    public static IntegerProperty moneyProperty() {
        return money;
    }

    // Getter et setter pour 'tomatoSeeds'
    public static int getTomatoSeeds() {
        return tomatoSeeds.get();
    }

    public static void addTomatoSeeds(int amount) {
        tomatoSeeds.set(tomatoSeeds.get() + amount);
    }

    public static IntegerProperty tomatoSeedsProperty() {
        return tomatoSeeds;
    }

    // Getter et setter pour 'wheetSeeds'
    public static int getWheetSeeds() {
        return wheetSeeds.get();
    }

    public static void addWheetSeeds(int amount) {
        wheetSeeds.set(wheetSeeds.get() + amount);
    }

    public static IntegerProperty wheetSeedsProperty() {
        return wheetSeeds;
    }

    // Getter et setter pour tomates récoltées
    public static int getHarvestedTomatoes() {
        return harvestedTomatoes.get();
    }

    public static void addHarvestedTomatoes(int amount) {
        harvestedTomatoes.set(harvestedTomatoes.get() + amount);
    }

    public static IntegerProperty harvestedTomatoesProperty() {
        return harvestedTomatoes;
    }

    // Getter et setter pour blé récolté
    public static int getHarvestedWheat() {
        return harvestedWheat.get();
    }

    public static void addHarvestedWheat(int amount) {
        harvestedWheat.set(harvestedWheat.get() + amount);
    }

    public static IntegerProperty harvestedWheatProperty() {
        return harvestedWheat;
    }
}