package sample;



import javafx.scene.Scene;

import java.security.PrivateKey;
import java.util.PrimitiveIterator;

public class Battlefield {
    public final int SINGLE_LENGTH = 100;
    private final int BATTLE_FIELD_WIDTH = 18;
    private final int BATTLE_FIELD_HEIGHT = 9;
    /*public final int C=1;//calabashBoy
    public final int G=2;//grandpa
    public final int M=3;//soldier
    public final int P=4;//scorpion
    public final int N=5;//snake*/


    private int[][] map;


    public Battlefield(){
        map=new int[BATTLE_FIELD_HEIGHT][BATTLE_FIELD_WIDTH];
        init();
    }

    public int[][] getMap() {
        return map;
    }

    public int getWidth(){
        return BATTLE_FIELD_WIDTH;
    }
    public int getHeight(){
        return BATTLE_FIELD_HEIGHT;
    }
    public int getSingleLength(){
        return SINGLE_LENGTH;
    }


    public void init(){
        for(int i=0;i<BATTLE_FIELD_HEIGHT;i++){
            for(int j=0;j<BATTLE_FIELD_WIDTH;j++)
                map[i][j]=0;
        }
    }
/*    void showmap(){
        for(int i = 0; i < BATTLE_FIELD_HEIGHT; i++)
            System.out.println(map[i]);
        System.out.println();
        System.out.println();
    }*/

    void setFormation(int row, int col, FormationMaker formationMaker){
        for(int i = row; i < formationMaker.getLength()+row;i++){
            for(int j = col; j < formationMaker.getWidth()+col;j++){
                map[i][j] = formationMaker.getFormation()[i-row][j-col];
            }
        }
    }

    void setFormation(int row, int col, int roleIndex){
        map[row][col]=roleIndex;
    }

}
