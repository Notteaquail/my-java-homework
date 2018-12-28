package sample;



import java.util.ArrayList;

public class DoMove extends Thread {
    private ArrayList<move> moves;
    private boolean[] isStart;
    public DoMove(boolean[] isStart){
        moves=new ArrayList<>();
        this.isStart=isStart;
    }

    @Override
    public void run() {
        while (isStart[0]){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int movesCount=0;
            /*System.out.println(moves.size());
            print();*/
            while (movesCount<moves.size()){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                move(movesCount);
                movesCount++;
            }
            moves.clear();
        }
    }

    private void move(int i){
        if(moves.get(i).forward){
            moves.get(i).animal.moveRight();
        }
        if(moves.get(i).backward){
            moves.get(i).animal.moveLeft();
        }
        if(moves.get(i).down){
            moves.get(i).animal.moveDown();
        }
        if(moves.get(i).up){
            moves.get(i).animal.moveUp();
        }
    }

    private void print(){
        int i=0;
        while (i<moves.size()){
            System.out.printf("Being%d:%b,%b,%b,%b%n",i,moves.get(i).forward,moves.get(i).backward,
                    moves.get(i).down,moves.get(i).up);
            i++;
        }
    }

    public ArrayList<move> getMoves() {
        return moves;
    }
    public void setIsStart(boolean[] isStart){ this.isStart=isStart; }
}
