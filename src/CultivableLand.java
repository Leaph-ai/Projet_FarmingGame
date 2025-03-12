import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class CultivableLand {

    @FXML
    private GridPane gridPane;

    public void initialize() {
        int rows = 20;
        int columns = 29;

        // Tableau de champs
        Plant[][] plants = new Plant[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                Button button = new Button("-");
                gridPane.setHalignment(button, javafx.geometry.HPos.CENTER);
                gridPane.setValignment(button, javafx.geometry.VPos.CENTER);
                gridPane.setAlignment(Pos.CENTER);

                plants[row][col] = new Plant(button);

                final int finalRow = row;
                final int finalCol = col;

                // Action sur clic de champ
                button.setOnMouseClicked((event) -> {
                    Plant plant = plants[finalRow][finalCol];

                    // Vérifie l'état pour chaque action en fonction
                    if (!plant.isPlantingInProgress() && !plant.isReadyToCollect()) {
                        // Si le champ est vide, planter
                        if (Ressources.getTomatoSeeds() > 0) {
                            Ressources.addTomatoSeeds(-1);
                            plant.plant("tomato");
                        } else if (Ressources.getWheetSeeds() > 0) {
                            Ressources.addWheetSeeds(-1);
                            plant.plant("wheat");
                        } else {
                            System.out.println("Pas assez de graines !");
                        }
                    } else if (plant.isReadyToCollect()) {
                        // Sauvegarder le type de plante avant la collecte
                        String plantType = plant.getPlantType();
                        // Récolter la plante
                        plant.collect();
                        // Utiliser le type sauvegardé pour l'affichage
                        System.out.println("Vous avez récolté : " + (plantType.equals("tomato") ? "🍅 Tomates" : "🌾 Blé") + " !");
                    } else {
                        System.out.println("Cette plante est encore en train de pousser !");
                    }
                });

                gridPane.add(button, col, row);
            }
        }
    }
}