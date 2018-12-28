package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;


public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        GamePanel myGP = new GamePanel();
        final Scene scene = new Scene(myGP, myGP.getWidth(), myGP.getHeight());
        myGP.formations1();
        myGP.load();

        Image background = new Image(getClass().getResourceAsStream("image/map.jpg"));
        ImagePattern imagePattern=new ImagePattern(background);
        scene.setFill(imagePattern);
        primaryStage.setTitle("葫芦娃大战蛇精军团主战场");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
