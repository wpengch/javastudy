package start;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.BoxBlur;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class Main extends Application {

    private Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(demo4());
        primaryStage.show();
    }

    private Scene demo4() {
        Group root = new Group();
        Scene scene = new Scene(root, 800, 600, Color.BLACK);
        Rectangle colors = linearGradient7(scene);
        root.getChildren().add(colors);
        Group circles = circles30();
        circles.setEffect(new BoxBlur(10, 10, 3));

        root.getChildren().add(circles);

        Timeline timeline = new Timeline();
        for (Node circle : circles.getChildren()) {
            timeline.getKeyFrames().addAll(new KeyFrame(Duration.ZERO, new KeyValue(circle.translateXProperty(), Math.random() * 800), new KeyValue(circle.translateYProperty(), Math.random() * 600)),
                    new KeyFrame(new Duration(40000), new KeyValue(circle.translateXProperty(), Math.random() * 800), new KeyValue(circle.translateYProperty(), Math.random() * 600)));
        }

        timeline.play();

        return scene;
    }


    private Scene demo3() {
        Group group = new Group();
        Scene scene = new Scene(group, 800, 600, Color.BLACK);
        Rectangle colors = linearGradient7(scene);
        Group circles = circles30();
        Group blendModeGroup = new Group(new Group(new Rectangle(scene.getWidth(), scene.getHeight(), Color.BLACK), circles), colors);
        colors.setBlendMode(BlendMode.OVERLAY);
        group.getChildren().add(blendModeGroup);
        return scene;
    }

    private Group circles30() {
        Group circles = new Group();
        for (int i = 0; i < 30; i++) {
            Circle circle = new Circle(150, Color.web("white", 0.05));
            circle.setStrokeType(StrokeType.OUTSIDE);
            circle.setStroke(Color.web("white", 0.16));
            circle.setStrokeWidth(4);
            circles.getChildren().add(circle);
        }
        return circles;
    }

    private Rectangle linearGradient7(Scene scene) {
        return new Rectangle(scene.getWidth(), scene.getHeight(), new LinearGradient(0, 1, 1, 0, true, CycleMethod.NO_CYCLE, new Stop(0, Color.web("#f8bd55")),
                new Stop(0.14, Color.web("#c0fe56")),
                new Stop(0.28, Color.web("#5dfbc1")),
                new Stop(0.43, Color.web("#64c2f8")),
                new Stop(0.57, Color.web("#be4af7")),
                new Stop(0.71, Color.web("#ed5fc2")),
                new Stop(0.85, Color.web("#ef504c")),
                new Stop(1, Color.web("#f2660f"))));
    }

    private Scene demo2() {
        Group root = new Group();
        Scene scene = new Scene(root, 800, 600, Color.BLACK);
        Rectangle colors = linearGradient7(scene);
        root.getChildren().add(colors);
        Group circles = circles30();
        circles.setEffect(new BoxBlur(10, 10, 3));

        root.getChildren().add(circles);
        return scene;
    }

    private Scene demo1() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        return new Scene(root, 300, 275);
    }
}
