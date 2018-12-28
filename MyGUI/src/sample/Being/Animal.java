package sample.Being;

import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

public class Animal extends Parent{
    protected Random rand = new Random();
    protected final int HEIGHT = 180;
    protected final int WIDTH = 180;
   /* private enum Direction {
        Left, Right, Up, Down
    };

    private Direction direction = Direction.Left;
    private Direction lastDirection;*/
    protected int x,y;
    protected ImageView cbImageView;
//    private int index = 0;
//    private int indexDiv = 5;
    private int speed = 100;


    public  Animal(){}
    Animal(int x, int y, String url){
        this.x=x;
        this.y=y;
        Image actor = new Image(getClass().getResourceAsStream(url));
        cbImageView = new ImageView(actor);
        cbImageView.setViewport(new Rectangle2D(0,0,WIDTH,HEIGHT));
        cbImageView.setLayoutX(x-82);
        cbImageView.setLayoutY(y-89);
        getChildren().add(cbImageView);
    }

    /**
     * 向下移动
     */
    public void moveDown() {
        //direction = Direction.Down;
        /*if(lastDirection != direction){
            index = 0;
        }
        index++;
        if (index / indexDiv > 2) {
            index = 0;
        }*/
/*        cbImageView.setViewport(new Rectangle2D(((index / indexDiv) % 3) * width, ((index / indexDiv) / 3) * height, width,
                height));*/
        cbImageView.setLayoutY(cbImageView.getLayoutY() + speed);

        //lastDirection = direction;
    }

    /**
     * 向左移动
     */
    public void moveLeft() {
        //direction = Direction.Left;
        /*if(lastDirection != direction){
            index = 3 * indexDiv;
        }
        index++;
        if (index / indexDiv > 5) {
            index = 3 * indexDiv;
        }
        *//*cbImageView.setViewport(new Rectangle2D(((index / indexDiv) % 3) * width, ((index / indexDiv) / 3) * height, width,
                height));*/
        cbImageView.setLayoutX(cbImageView.getLayoutX() - speed);

        //lastDirection = direction;
    }

    /**
     * 向右移动
     */
    public void moveRight() {
        //direction = Direction.Right;
        /*if(lastDirection != direction){
            index = 6 * indexDiv;
        }
        index++;
        if (index / indexDiv > 8) {
            index = 6 * indexDiv;
        }
        cbImageView.setViewport(new Rectangle2D(((index / indexDiv) % 3) * width, ((index / indexDiv) / 3) * height, width,
                height));*/
        cbImageView.setLayoutX(cbImageView.getLayoutX() + speed);

        //lastDirection = direction;
    }

    /**
     * 向上移动
     */
    public void moveUp() {
        //direction = Direction.Up;
        /*if(lastDirection != direction){
            index = 9 * indexDiv;
        }
        index++;
        if (index / indexDiv > 11) {
            index = 9 * indexDiv;
        }*/
        /*cbImageView.setViewport(new Rectangle2D(((index / indexDiv) % 3) * width, ((index / indexDiv) / 3) * height, width,
                height));*/
        cbImageView.setLayoutY(cbImageView.getLayoutY() - speed);

        //lastDirection = direction;
    }

    public void dead(){
        cbImageView.setViewport(new Rectangle2D(0,0,10,10));
    }

    public void deading(){
        cbImageView.setViewport(new Rectangle2D(0,0,WIDTH,HEIGHT));
    }

    public boolean attack(){
        return false;
    }



    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getSpeed(){ return speed; }
    public int getDeadIndex(){ return rand.nextInt(10); }
    /*public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }*/
}
