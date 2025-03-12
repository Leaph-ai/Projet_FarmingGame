import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.util.Duration;

public class Plant {
    private boolean plantingInProgress;
    private boolean readyToCollect = false;
    private Button button;
    private String plantType;
    private Timeline growthTimeline;

    public Plant(Button button) {
        this.button = button;
        this.plantingInProgress = false;
        this.plantType = null; // Aucune graine plantée par défaut
    }


    public void readyToCollect() {
        Platform.runLater(() -> {
            readyToCollect = true;
            button.setText(plantType.equals("tomato") ? "🍅" : "🌾");
            button.setDisable(false);
        });
    }


    public boolean isReadyToCollect() {
        return readyToCollect;
    }


    public void collect() {
        if (plantType == null) {
            System.out.println("Erreur : Aucune plante à récolter !");
            return;
        }


        switch (plantType) {
            case "tomato":
                Ressources.addHarvestedTomatoes(3);
                Ressources.addTomatoSeeds(2);
                System.out.println("Vous avez récolté une tomate !");
                break;
            case "wheat":
                Ressources.addHarvestedWheat(3);
                Ressources.addWheetSeeds(2);
                System.out.println("Vous avez récolté un blé !");
                break;
            default:
                System.out.println("Type de plante inconnu !");
        }

        Platform.runLater(() -> {
            button.setText("-");
        });
        plantType = null;
        readyToCollect = false;
        plantingInProgress = false;
    }


    public void plant(String type) {
        if (!plantingInProgress && type != null) {
            plantingInProgress = true;
            plantType = type;
            readyToCollect = false;

            Platform.runLater(() -> {
                button.setText(type.equals("tomato") ? "🌱 Tomate" : "🌱 Blé");
                button.setDisable(true);
            });

            growthTimeline = new Timeline(new KeyFrame(Duration.seconds(10), e -> {
                readyToCollect = true;
                readyToCollect();
            }));
            growthTimeline.setCycleCount(1);
            growthTimeline.play();
        }
    }
}

