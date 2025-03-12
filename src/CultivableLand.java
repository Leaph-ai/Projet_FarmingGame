import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class CultivableLand {
    @FXML
    private GridPane gridPane;

    public void initialize() {
        int rows = 23;
        int columns = 47;
        Plant[][] plants = new Plant[rows][columns];
        Animal[][] animals = new Animal[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                Button button = new Button("-");
                gridPane.setHalignment(button, javafx.geometry.HPos.CENTER);
                gridPane.setValignment(button, javafx.geometry.VPos.CENTER);
                gridPane.setAlignment(Pos.CENTER);

                plants[row][col] = new Plant(button);

                final int finalRow = row;
                final int finalCol = col;

                button.setOnMouseClicked((event) -> {
                    String selection = SelectionManager.getCurrentSelection();
                    Plant plant = plants[finalRow][finalCol];

                    if (plant.isReadyToCollect()) {
                        plant.collect();
                        return;
                    }

                    if (selection == null) {
                        System.out.println("Veuillez d'abord sélectionner un élément à placer !");
                        return;
                    }


                    switch (selection) {
                        case "tomato":
                            if (Ressources.getTomatoSeeds() > 0) {
                                Ressources.addTomatoSeeds(-1);
                                plants[finalRow][finalCol].plant("tomato");
                            } else {
                                System.out.println("Pas assez de graines de tomates !");
                            }
                            break;

                        case "wheat":
                            if (Ressources.getWheetSeeds() > 0) {
                                Ressources.addWheetSeeds(-1);
                                plants[finalRow][finalCol].plant("wheat");
                            } else {
                                System.out.println("Pas assez de graines de blé !");
                            }
                            break;

                        case "chicken":
                            if (Ressources.getMoney() >= 50 && animals[finalRow][finalCol] == null) {
                                Ressources.setMoney(Ressources.getMoney() - 50);
                                animals[finalRow][finalCol] = new Animal("chicken");
                                button.setText("🐔");
                            }
                            break;

                        case "cow":
                            if (Ressources.getMoney() >= 100 && animals[finalRow][finalCol] == null) {
                                Ressources.setMoney(Ressources.getMoney() - 100);
                                animals[finalRow][finalCol] = new Animal("cow");
                                button.setText("🐄");
                            }
                            break;
                    }
                });

                gridPane.add(button, col, row);
            }
        }
    }
}
