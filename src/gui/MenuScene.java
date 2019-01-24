package gui;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Arrays;


public class MenuScene {
    Stage window;

    public MenuScene(Stage window) {
        this.window = window;
    }

    public void display() {
        prepareStage();
        VBox layout = prepareLayout();
        window.setScene(new Scene(layout, 300, 300));
        window.show();
        GuiUtils.centerWindow(window);
    }

    private VBox prepareLayout() {
        Label label = new Label("Wolf and Sheep");
        VBox layout = new VBox(30);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().add(label);
        addButtons(layout);
        return layout;
    }

    private void addButtons(VBox layout) {
        Button singlePlayerButton = new Button("One Player");
        Button multiPlayerButton = new Button("Two Players");
        Button helpButton = new Button("help");
        Button[] buttons = {singlePlayerButton, helpButton};
        GuiUtils.setButtonHeightAndBindSizes(50, Arrays.asList(buttons), multiPlayerButton);
        layout.getChildren().addAll(singlePlayerButton, multiPlayerButton, helpButton);

        singlePlayerButton.setOnAction(event -> GameOverBox.display("Single player not supported",
                "Sorry, but we don't have AI yet, so single player is not supported." +
                        " Enjoy the two Players game :)"));
        multiPlayerButton.setOnAction(event -> {
            GameScene gameScene = new GameScene(this.window);
            gameScene.display();
        });
    }

    private void prepareStage() {
        window.setTitle("Wolf and Sheep - Chessboard game");
        window.setResizable(false);
        window.setOnCloseRequest(event -> Platform.exit());
    }
}
