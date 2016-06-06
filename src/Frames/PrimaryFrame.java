package Frames;

/**
 * Created by Дарья on 21.05.2016.
 */

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;


public class PrimaryFrame extends Application {
    private GameMenu gameMenu;

    @Override
    public void start(Stage primaryStage) throws Exception {

        Pane root = new Pane();
        root.setPrefSize(1200,700);

        InputStream is = Files.newInputStream(Paths.get("C:\\Users\\Дарья\\IdeaProjects\\pattern_game\\pattern_game\\src\\Image\\Game-of-Thrones-screen.jpg"));
        Image img = new Image(is);
        is.close();

        ImageView imgView = new ImageView(img);
        imgView.setFitWidth(1200);
        imgView.setFitHeight(700);

        gameMenu = new GameMenu();
        gameMenu.setVisible(false);

        root.getChildren().addAll(imgView, gameMenu);

        Scene scene = new Scene(root);
        scene.setOnKeyPressed( event -> {
           if (event.getCode() == KeyCode.ESCAPE) {
               if (!gameMenu.isVisible()) {
                   FadeTransition ft = new FadeTransition(Duration.seconds(0.5), gameMenu);
                   ft.setFromValue(0);
                   ft.setToValue(1);

                   gameMenu.setVisible(true);
                   ft.play();
               } else {
                   FadeTransition ft = new FadeTransition(Duration.seconds(0.5), gameMenu);
                   ft.setFromValue(1);
                   ft.setToValue(0);
                   ft.setOnFinished(evt -> gameMenu.setVisible(false));
                   ft.play();
               }
           }
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
