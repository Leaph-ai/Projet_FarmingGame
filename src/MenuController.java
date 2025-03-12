import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

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

    @FXML
    private Label labelMilk;


    @FXML
    private Label labelCow;

    @FXML
    private Label labelChicken;

    @FXML
    private Label labelEgg;

    public void initialize() {
        labelMoney.textProperty().bind(Ressources.moneyProperty().asString("Monnaie : %d"));
        labelTomatoSeeds.textProperty().bind(Ressources.tomatoSeedsProperty().asString("Graines : %d"));
        labelWheetSeeds.textProperty().bind(Ressources.wheetSeedsProperty().asString("Graines : %d"));
        labelTomato.textProperty().bind(Ressources.harvestedTomatoesProperty().asString("x %d"));
        labelWheet.textProperty().bind(Ressources.harvestedWheatProperty().asString("x %d"));
        labelChicken.textProperty().bind(Ressources.chickensProperty().asString("Poulets : %d"));
        labelEgg.textProperty().bind(Ressources.eggsProperty().asString("Œufs : %d"));
        labelCow.textProperty().bind(Ressources.cowsProperty().asString("Vaches : %d"));
        labelMilk.textProperty().bind(Ressources.milkProperty().asString("Lait : %d"));
        addImageClickHandler("tomatoimage", "tomato");
        addImageClickHandler("wheatimage", "wheat");
        addImageClickHandler("chickenimage", "chicken");
        addImageClickHandler("cowimage", "cow");


    }

    private void addImageClickHandler(String imageId, String type) {
        labelMoney.sceneProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                ImageView imageView = (ImageView) newValue.lookup("#" + imageId);
                if (imageView != null) {
                    imageView.setOnMouseClicked(event -> {
                        SelectionManager.setCurrentSelection(type);
                        System.out.println("Sélection : " + type);
                    });
                }
            }
        });
    }
}