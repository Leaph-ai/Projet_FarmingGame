import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Shop {

    @FXML
    private Button buyTomato;

    @FXML
    private Button buyWheet;

    @FXML
    private Button sellTomato;

    @FXML
    private Button sellWheet;

    @FXML
    private Label labelMoney;

    @FXML
    private Label labelTomatoSeeds;

    @FXML
    private Label labelWheetSeeds;

    public void initialize() {
        // Lier les labels aux propriétés de Ressources
        labelMoney.textProperty().bind(Ressources.moneyProperty().asString("Monnaie : %d"));
        labelTomatoSeeds.textProperty().bind(Ressources.tomatoSeedsProperty().asString("Graines : %d"));
        labelWheetSeeds.textProperty().bind(Ressources.wheetSeedsProperty().asString("Graines : %d"));

        // Bouton pour acheter des graines de tomates
        buyTomato.setOnAction(event -> {
            if (Ressources.getMoney() >= 10) {
                Ressources.setMoney(Ressources.getMoney() - 10);
                Ressources.addTomatoSeeds(1);
            } else {
                System.out.println("Pas assez d'argent pour acheter des graines de tomate !");
            }
        });

        // Bouton pour acheter des graines de blé
        buyWheet.setOnAction(event -> {
            if (Ressources.getMoney() >= 15) {
                Ressources.setMoney(Ressources.getMoney() - 15);
                Ressources.addWheetSeeds(1);
            } else {
                System.out.println("Pas assez d'argent pour acheter des graines de blé !");
            }
        });

        sellTomato.setOnAction(event -> {
            if (Ressources.getHarvestedTomatoes() > 0) {
                Ressources.addHarvestedTomatoes(-1);
                Ressources.setMoney(Ressources.getMoney() + 5);
            } else {
                System.out.println("Pas de tomates récoltées à vendre !");
            }
        });

        sellWheet.setOnAction(event -> {
            if (Ressources.getHarvestedWheat() > 0) {
                Ressources.addHarvestedWheat(-1);
                Ressources.setMoney(Ressources.getMoney() + 8);
            } else {
                System.out.println("Pas de blé récolté à vendre !");
            }
        });
    }
}