package sample;

public class DoDead extends Thread {
    AnimalThread[] animalThreads;
    boolean[] isStart;

    DoDead(AnimalThread[] animalThreads, boolean isStart){
        this.animalThreads=animalThreads;
        this.isStart=new boolean[1];
        this.isStart[0]=isStart;
    }

    @Override
    public void run() {

        while(isStart[0]){
            int cbCount=0, mstCount=0;
            try {
                Thread.sleep(1001);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for(int i = 0; i<21;i++){
                if(!animalThreads[i].isAlive()){
                    if(i>=0&&i<=6)
                        cbCount++;
                    if(i==7||i==20)
                        continue;
                    if(i>=8&&i<=19)
                        mstCount++;
                    for(int j=0;j<3;j++){
                        animalThreads[i].getAnimal().dead();
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        animalThreads[i].getAnimal().deading();
                    }
                    animalThreads[i].getAnimal().dead();
                }
            }
            if(cbCount==7||mstCount==12)
            {
                isStart[0]=false;
                break;
            }
        }
    }

    boolean[] getIsStart(){ return isStart;}
}
