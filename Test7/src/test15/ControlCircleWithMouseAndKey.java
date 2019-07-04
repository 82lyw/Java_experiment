package test15;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ControlCircleWithMouseAndKey extends Application {
    private CirclePane circlePane = new CirclePane();

    @Override
    public void start(Stage primaryStage) {
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        Button btEnlarge = new Button("Enlarge");
        Button btShrink = new Button("Shrink");
        hBox.getChildren().add(btEnlarge);
        hBox.getChildren().add(btShrink);

        btEnlarge.setOnAction(event -> circlePane.enlarge());
        btShrink.setOnAction(event -> circlePane.shrink());

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(circlePane);
        borderPane.setBottom(hBox);
        BorderPane.setAlignment(hBox,Pos.CENTER);

        Scene scene = new Scene(borderPane,200,150);
        primaryStage.setTitle("ControlCircle");
        primaryStage.setScene(scene);
        primaryStage.show();

        circlePane.setOnMouseClicked(e -> {
            if (e.getButton() == MouseButton.PRIMARY) {
                circlePane.enlarge();
            }
            else if (e.getButton() == MouseButton.SECONDARY) {
                circlePane.shrink();
            }
        });

        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP) {
                circlePane.enlarge();
            }
            else if (e.getCode() == KeyCode.DOWN) {
                circlePane.shrink();
            }
        });
    }
}
