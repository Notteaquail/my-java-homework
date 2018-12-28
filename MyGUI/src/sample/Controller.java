package sample;

import sample.Being.*;

public class Controller {
    private GamePanel myGP;

    private CalabashBoy calabashBoys[];
    private Grandpa grandpa;
    private MonsterSoldier soldiers[];
    private Scorpion scorpion;
    private Snake snake;

    public Controller(){
        myGP=new GamePanel();
    }

    GamePanel getMyGP(){
        return myGP;
    }
}
