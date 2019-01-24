package gui;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;
import java.net.URI;
import java.util.Arrays;


public class MenuScene {
    Stage window;
    final private String helpURL = "https://en.wikipedia.org/wiki/Fox_games#Fox_and_Hounds";
    final public static String menuStylesheet = "gui/Menu.css";

    public MenuScene(Stage window) {
        this.window = window;
    }

    public void display() {
        prepareStage();
        VBox layout = prepareLayout();
        Scene scene = new Scene(layout, 333, 333);
        scene.getStylesheets().add(menuStylesheet);
        window.setScene(scene);
        window.show();
        GuiUtils.centerWindow(window);
    }

    private VBox prepareLayout() {
        Label label = new Label("Wolf and Sheep");
        label.setStyle("-fx-font-family: 'Keraleeyam'; -fx-font-size: 43px; -fx-font-style: oblique;");
        VBox layout = new VBox(30);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().add(label);
        addButtons(layout);
        return layout;
    }

    private void addButtons(VBox layout) {
        Button singlePlayerButton = new Button("One Player");
        Button multiPlayerButton = new Button("Two Players");
        Button helpButton = new Button("Help");
        Button[] buttons = {singlePlayerButton, helpButton};
        GuiUtils.setButtonHeightAndBindSizes(50, Arrays.asList(buttons), multiPlayerButton);
        layout.getChildren().addAll(singlePlayerButton, multiPlayerButton, helpButton);

        singlePlayerButton.setOnAction(event -> AlertBox.display("Single player not supported",
                "Sorry, but we don't have AI yet, so single player is not supported." +
                        " Enjoy the two Players game :)"));

        multiPlayerButton.setOnAction(event -> {
            GameScene gameScene = new GameScene(this.window);
            gameScene.display();
        });

        helpButton.setOnAction(event -> {
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                try {
                    Desktop.getDesktop().browse(new URI(helpURL));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void prepareStage() {
        window.setTitle("Wolf and Sheep - Chessboard game");
        window.setResizable(false);
        window.setOnCloseRequest(event -> Platform.exit());
    }
}
