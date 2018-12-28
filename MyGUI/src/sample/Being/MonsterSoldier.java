package sample.Being;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MonsterSoldier extends Monster{
    public MonsterSoldier(int x, int y, String url){
        super.x=x;
        super.y=y;
        Image actor = new Image(getClass().getResourceAsStream(url));
        super.cbImageView = new ImageView(actor);
        super.cbImageView.setViewport(new Rectangle2D(0,0,WIDTH,HEIGHT));
        super.cbImageView.setLayoutX(x-68);
        super.cbImageView.setLayoutY(y-68);
        getChildren().add(super.cbImageView);
    }
}
