package sample;

import sample.Being.Animal;

import java.util.ArrayList;

public class AnimalThread extends Thread {

    private Animal animal;
    int[][] map;
    int x,y;//在map上的位置下标；
    boolean isDead, isStart;
    private boolean forward, backward, down, up;//向前移动？,向下移动？
    private ArrayList<move> moves;


    public AnimalThread(Animal animal, int[][] map, int x, int y,ArrayList<move> moves){
        isDead=false;
        isStart=false;
        forward=false;
        backward=false;
        down=false;
        up=false;
        this.animal=animal;
        this.map=map;
        this.x=x;
        this.y=y;
        this.moves=moves;
    }

    private boolean move(){
        int dx=0,dy=0;
        if(forward){
            dx=1;
        }
        if(backward){
            dx=-1;
        }
        if(down){
            dy=1;
        }
        if(up){
            dy=-1;
        }
        if(dx!=0){
            if(map[y][x+dx]==0){
                map[y][x+dx]=map[y][x];
                map[y][x]=0;
                x+=dx;
                return true;
            }
            else{
                if(!isDead){
                    boolean temp=forward;
                    forward=backward;
                    backward=temp;
                }
            }
        }
        else if(dy!=0){
            if(map[y+dy][x]==0){
                map[y+dy][x]=map[y][x];
                map[y][x]=0;
                y+=dy;
                return true;
            }
            else{
                if(!isDead){
                    boolean temp=up;
                    up=down;
                    down=temp;
                }
            }
        }
        return false;
    }

    @Override
    public void run() {
        while(!isDead){
                if(isStart){
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(x==3&&backward){ backward=false; forward=true;}
                    if(x==15&&forward){ backward=true; forward=false;}
                    if(y==1&&up){ up=false; down=true;}
                    if(y==7&&down){ up=true; down=false;}
                    if(move()){
                        moves.add(new move(animal,forward,backward,down,up));
                    }
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(0<x&&x<17&&0<y&&y<8){
                        if(((0<map[y][x]&&map[y][x]<8)&&((8<map[y][x+1]&&map[y][x+1]<21)))||
                                ((8<map[y][x]&&map[y][x]<21)&&((0<map[y][x-1]&&map[y][x-1]<8)))){
                            isDead=animal.attack();
                        }
                    }
                }
        }
        if(isDead) {
            map[y][x] = 0;
        }
    }


    public void setIsDead(boolean isDead){
        this.isDead=isDead;
    }
    public void setIsStart(boolean isStart){
        this.isStart=isStart;
    }
    public void setForward(boolean forward){
        this.forward=forward;
    }
    public void setBackward(boolean backward){this.backward=backward; }
    public void setDown(boolean down){
        this.down=down;
    }
    public void setUp(boolean up){ this.up=up; }

    public Animal getAnimal(){ return animal; }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}
