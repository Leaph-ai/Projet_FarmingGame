import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Shop {

    @FXML
    private Button buyChicken;
    @FXML
    private Button sellChicken;
    @FXML
    private Button buyCow;
    @FXML
    private Button sellCow;
    @FXML
    private Button sellEgg;
    @FXML
    private Button sellMilk;


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

    @FXML
    private Label labelEggs;

    @FXML
    private Label labelMilk;


    public void initialize() {
        labelMoney.textProperty().bind(Ressources.moneyProperty().asString("Monnaie : %d"));
        labelTomatoSeeds.textProperty().bind(Ressources.tomatoSeedsProperty().asString("Graines : %d"));
        labelWheetSeeds.textProperty().bind(Ressources.wheetSeedsProperty().asString("Graines : %d"));
        labelEggs.textProperty().bind(Ressources.eggsProperty().asString("Œufs : %d"));
        labelMilk.textProperty().bind(Ressources.milkProperty().asString("Lait : %d"));


        buyTomato.setOnAction(event -> {
            if (Ressources.getMoney() >= 10) {
                Ressources.setMoney(Ressources.getMoney() - 10);
                Ressources.addTomatoSeeds(1);
            } else {
                System.out.println("Pas assez d'argent pour acheter des graines de tomate !");
            }
        });

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

        buyChicken.setOnAction(event -> {
            if (Ressources.getMoney() >= 50) {
                Ressources.setMoney(Ressources.getMoney() - 50);
                Ressources.addChickens(1);
            } else {
                System.out.println("Pas assez d'argent pour acheter un poulet !");
            }
        });

        sellChicken.setOnAction(event -> {
            if (Ressources.getChickens() > 0) {
                Ressources.addChickens(-1);
                Ressources.setMoney(Ressources.getMoney() + 40);
            } else {
                System.out.println("Pas de poulet à vendre !");
            }
        });

        buyCow.setOnAction(event -> {
            if (Ressources.getMoney() >= 100) {
                Ressources.setMoney(Ressources.getMoney() - 100);
                Ressources.addCows(1);
            } else {
                System.out.println("Pas assez d'argent pour acheter une vache !");
            }
        });

        sellCow.setOnAction(event -> {
            if (Ressources.getCows() > 0) {
                Ressources.addCows(-1);
                Ressources.setMoney(Ressources.getMoney() + 80);
            } else {
                System.out.println("Pas de vache à vendre !");
            }
        });

        sellEgg.setOnAction(event -> {
            if (Ressources.getEggs() > 0) {
                Ressources.addEggs(-1);
                Ressources.setMoney(Ressources.getMoney() + 5);
            } else {
                System.out.println("Pas d'œufs à vendre !");
            }
        });

        sellMilk.setOnAction(event -> {
            if (Ressources.getMilk() > 0) {
                Ressources.addMilk(-1);
                Ressources.setMoney(Ressources.getMoney() + 10);
            } else {
                System.out.println("Pas de lait à vendre !");
            }

        });
    }
}
