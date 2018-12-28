package sample.Being;

public class Monster extends Animal{
    public  Monster(){}
    public Monster(int x, int y, String url){
        super(x, y, url);
    }

    @Override
    public boolean attack() {
        int index=rand.nextInt(10);
        if(index<8)
            return true;
        return false;
    }
}
