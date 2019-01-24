package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {
    public static void display(String title, String message) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        Label label = new Label();
        label.setText(message);
        Button okButton = new Button("OK");
        okButton.setPrefSize(70,30);
        okButton.setOnAction(event -> {
            window.close();
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(0,10,0,10));
        layout.getChildren().addAll(label, okButton);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(15,15,15,15));
        Scene scene = new Scene(layout);
        scene.getStylesheets().add(MenuScene.menuStylesheet);
        window.setScene(scene);
        window.showAndWait();
    }
}
