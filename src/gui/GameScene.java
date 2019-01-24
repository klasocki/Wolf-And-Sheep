package gui;

import game.GameController;
import game.GameOverObserver;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Arrays;

public class GameScene implements GameOverObserver {
    private Stage window;
    private final String gameStylesheet = "gui/Game.css";

    public GameScene(Stage window) {
        this.window = window;
    }

    public void display() {
        prepareStage();
        GameController gameController = GameController.initGame(true);
        gameController.addObserver(this);
        GridPane boardView = getChessboardGrid(window, gameController);
        HBox layout = prepareLayout(gameController, boardView);
        Scene scene = new Scene(layout, 820, 620);
        scene.getStylesheets().add(gameStylesheet);
        window.setScene(scene);
        window.show();
        GuiUtils.centerWindow(window);
    }

    private HBox prepareLayout(GameController gameController, GridPane boardView) {
        HBox layout = new HBox();
        layout.setPadding(new Insets(10, 0, 10, 10));
        VBox rightMenu = new VBox(30);
        addButtons(gameController, rightMenu);
        rightMenu.setPadding(new Insets(20,0,20,20));
        rightMenu.setAlignment(Pos.BASELINE_RIGHT);
        layout.getChildren().addAll(boardView, rightMenu);
        return layout;
    }

    private void addButtons(GameController gameController, VBox rightMenu) {
        Button undoButton = new Button("Undo");
        Button restartButton = new Button("Restart");
        Button quitButton = new Button("Back to menu");
        Button[] arr = {restartButton, undoButton};
        GuiUtils.setButtonHeightAndBindSizes(50, Arrays.asList(arr), quitButton);
        undoButton.setOnAction(event -> gameController.undoLastMove());
        restartButton.setOnAction(event -> {
            if (ConfirmationBox.display("Restarting game",
                    "Are you sure you want to restart? Game progress will be lost")) {
                restart();
            }
        });
        quitButton.setOnAction(event -> {
            if (ConfirmationBox.display("Back to menu",
                    "Are you sure you want to quit to menu? Game progress will be lost")) {
                MenuScene menuScene = new MenuScene(window);
                menuScene.display();
            }
        });

        rightMenu.getChildren().addAll(undoButton, restartButton, quitButton);
    }


    private void prepareStage() {
        window.setTitle("Wolf and Sheep - Chessboard game");
        window.setResizable(false);
        window.setOnCloseRequest(event -> {
            event.consume();
            closeWindows();
        });
    }

    private GridPane getChessboardGrid(Stage window, GameController gameController) {
        GridPane boardView = gameController.getChessboardGrid();
        boardView.prefWidthProperty().bind(window.widthProperty().subtract(200));
        return boardView;
    }

    private void closeWindows() {
        boolean answer = ConfirmationBox.display("Exiting Wolf and Sheep",
                "Are you sure you want to quit? Your game progress will be lost");
        if (answer) {
            Platform.exit();
        }
    }

    @Override
    public void wolfHasWon() {
        AlertBox.display("Game Over", "The Wolf has won!!!");
        restart();
    }

    @Override
    public void sheepHaveWon() {
        AlertBox.display("Game Over", "The Sheep have won!!!");
        restart();
    }

    private void restart() {
        this.window.close();
        this.display();
    }
}
