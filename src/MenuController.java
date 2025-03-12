import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MenuController {

    @FXML
    private Label labelTomato;

    @FXML
    private Label labelWheet;


    @FXML
    private Label labelMoney;

    @FXML
    private Label labelTomatoSeeds;

    @FXML
    private Label labelWheetSeeds;

    public void initialize() {
        // Liaison des propriétés aux labels
        labelMoney.textProperty().bind(Ressources.moneyProperty().asString("Monnaie : %d"));
        labelTomatoSeeds.textProperty().bind(Ressources.tomatoSeedsProperty().asString("Graines : %d"));
        labelWheetSeeds.textProperty().bind(Ressources.wheetSeedsProperty().asString("Graines : %d"));
        labelTomato.textProperty().bind(Ressources.harvestedTomatoesProperty().asString("x %d"));
        labelWheet.textProperty().bind(Ressources.harvestedWheatProperty().asString("x %d"));

    }
}