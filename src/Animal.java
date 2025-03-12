import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class Animal {
    private String type;
    private Timeline productionTimeline;

    public Animal(String type) {
        this.type = type;
        startProduction();
    }

    private void startProduction() {
        productionTimeline = new Timeline(new KeyFrame(Duration.seconds(30), e -> {
            if (type.equals("chicken")) {
                Ressources.addEggs(1);
                System.out.println("Un œuf a été pondu !");
            } else if (type.equals("cow")) {
                Ressources.addMilk(1);
                System.out.println("Du lait a été produit !");
            }
        }));
        productionTimeline.setCycleCount(Timeline.INDEFINITE);
        productionTimeline.play();
    }
}