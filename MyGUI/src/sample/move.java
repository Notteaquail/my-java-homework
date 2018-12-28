package sample;

import sample.Being.Animal;

public class move {
    public Animal animal;
    public boolean forward, backward, down, up;//向前移动？,向下移动？
    public move(Animal animal, boolean forward, boolean backward, boolean down, boolean up ){
        this.animal=animal;
        this.forward=forward;
        this.backward=backward;
        this.down=down;
        this.up=up;
    }
}
