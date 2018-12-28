package sample;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import sample.Being.*;


public class GamePanel extends Parent{


    private Battlefield battlefield;
    private int sl,width,height,cbCount=-1, msCount=0, atCount = 0, atcbCount=0, atmsCount=8;
    private CalabashBoy calabashBoys[];
    private Grandpa grandpa;
    private MonsterSoldier soldiers[];
    private Scorpion scorpion;
    private Snake snake;
    private AnimalThread animalThreads[];
    private DoMove doMove;
    private DoDead doDead;
    FormationMaker formationMaker;

    public GamePanel() {
        battlefield=new Battlefield();
        sl = battlefield.getSingleLength();
        width=battlefield.getWidth();
        height=battlefield.getHeight();

    }

    void formations1(){
        battlefield.init();
        formationMaker = new FormationMaker();
        int array1[]={1,2,3,4,5,6,7};
        formationMaker.singleLineBattleArray(array1);
        battlefield.setFormation(1,3,formationMaker);
        battlefield.setFormation(6,1, 8);
        int array2[]={9,10,11,12,13,14,20,15,16,17,18,19};
        formationMaker.crescentMoonArray(array2);
        battlefield.setFormation(1,13,formationMaker);
        battlefield.setFormation(4,16,21);
    }

    void formation2(){
        battlefield.init();
        formationMaker = new FormationMaker();
        int array1[]={1,2,3,4,5,6,7};
        formationMaker.singleLineBattleArray(array1);
        battlefield.setFormation(1,3,formationMaker);
        battlefield.setFormation(6,1, 8);
        int array2[]={9,10,11,12,13,14,20,15,16,17,18,19};
        formationMaker.fangRArray(array2);
        battlefield.setFormation(1,10,formationMaker);
        battlefield.setFormation(2,16,21);
    }


    public void load() {
        calabashBoys = new CalabashBoy[7];
        soldiers = new MonsterSoldier[11];
        cbCount=-1; msCount=0; atCount = 0; atcbCount=0; atmsCount=8;
        animalThreads = new AnimalThread[21];
        doDead=new DoDead(animalThreads,true);
        doMove=new DoMove((doDead.getIsStart()));
        int[][] curMap = battlefield.getMap();

        int index=0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++){
                int px = x * sl + sl / 2, py = y * sl + sl / 2;
                //System.out.printf("%d, %d, %d%n", y,x,curMap[y][x]);
                if(curMap[y][x]>0&&curMap[y][x]<=7)
                    index=1;
                else if(curMap[y][x]==8)
                    index=2;
                else if(curMap[y][x]>8&&curMap[y][x]<=19)
                    index=3;
                else if(curMap[y][x]==20)
                    index=4;
                else if(curMap[y][x]==21)
                    index=5;
                else
                    index=0;
                switch (index) {
                    case 1: {
                        //System.out.println(index);
                        if (cbCount < 7) cbCount++;
                        else break;
                        calabashBoys[cbCount] = new CalabashBoy(CalabashBoy.Color.values()[cbCount], px, py, "/sample/image/" + CalabashBoy.Color.values()[cbCount] + ".png");
                        getChildren().add(calabashBoys[cbCount]);

                        animalThreads[atcbCount] = new AnimalThread(calabashBoys[cbCount],curMap,x,y,doMove.getMoves());
                        atcbCount++;
                        atCount++;

                        break;
                    }
                    case 2: {
                        grandpa = new Grandpa(px, py, "/sample/image/grandpa.png");
                        getChildren().add(grandpa);

                        animalThreads[7] = new AnimalThread(grandpa,curMap,x,y,doMove.getMoves());
                        atCount++;

                        break;
                    }
                    case 3: {
                        soldiers[msCount] = new MonsterSoldier(px, py, "/sample/image/crocodile.png");
                        getChildren().add(soldiers[msCount]);

                        animalThreads[atmsCount] = new AnimalThread(soldiers[msCount],curMap,x,y,doMove.getMoves());
                        atmsCount++;
                        atCount++;

                        msCount++;
                        break;
                    }
                    case 4: {
                        scorpion = new Scorpion(px, py, "/sample/image/scorpion.png");
                        getChildren().add(scorpion);

                        animalThreads[19] = new AnimalThread(scorpion,curMap,x,y,doMove.getMoves());
                        atCount++;

                        break;
                    }
                    case 5: {
                        snake = new Snake(px, py, "/sample/image/snake.png");
                        getChildren().add(snake);
                        //getChildren().remove(snake);

                        animalThreads[20] = new AnimalThread(snake,curMap,x,y,doMove.getMoves());
                        atCount++;

                        break;
                    }
                    default:
                        break;
                }
            }
        }



        getScene().setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                onKeyPressed(event);
            }
         });
    }

    public void start(){
        /*animalThreads[0].setIsStart(true);
        animalThreads[0].setBackward(true);
        animalThreads[0].start();
        animalThreads[8].setForward(true);
        animalThreads[8].setIsStart(true);
        animalThreads[8].start();*/
        for(int i=0;i<atCount;i++){
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            if(i==atmsCount||i==11||i==13||i==14||i==3||i==1||i==5){
                animalThreads[i].setUp(true);
                animalThreads[i].setIsStart(true);
                animalThreads[i].start();
            }else if(i>=0&&i<7){
                //animalThreads[i].setDown(true);
                animalThreads[i].setForward(true);
                animalThreads[i].setIsStart(true);
                animalThreads[i].start();

            }
            else if(i>atcbCount&&i<atmsCount){
                animalThreads[i].setBackward(true);
                animalThreads[i].setIsStart(true);
                animalThreads[i].start();
            }
        }
        doMove.start();
        doDead.start();
    }

/*    public void stop(){
        //animalThreads[0].setIsDead(true);
        for(int i=0;i<atCount;i++){
            animalThreads[i].setIsDead(true);
        }
    }*/



    public int getWidth(){
        return width*sl;
    }
    public int getHeight(){
        return height*sl;
    }



   public void onKeyPressed(KeyEvent event){
        if(event.getCode() == KeyCode.SPACE){

            start();
        }
        if(event.getCode() == KeyCode.UP)
        {
            getChildren().clear();
            formations1();
            load();
        }
        if(event.getCode() == KeyCode.DOWN){
            getChildren().clear();
            formation2();
            load();
        }
    }




    public void update(long now){

    }
}
