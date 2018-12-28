package sample.Being;


public class CalabashBoy extends Animal{
    public enum Color{
        red, orange,yellow,green,
        cyan,blue,purple
    }
    //private String name;
    private Color color;

    public CalabashBoy(Color color, int x, int y, String url){
        super(x,y,url);
        this.color=color;
    }

    @Override
    public boolean attack() {
        int index = rand.nextInt(10);
        if(index<8)
            return false;
        return true;
    }

    /*public String getColor() {
        switch (color){
            case red: return "red";
            case orange: return "orange";
            case yellow: return "yellow";
            case green: return "green";
            case cyan: return "cyan";
            case blue: return "blue";
            case purple: return "purple";
        }
        return "";
    }*/

    /*

    CalabashBoy(int rank, String name, String color) {
        this.rank  = rank;
        this.name = name;
        this.color = color;
    }

    public String tellname(){
        System.out.println(name);
        return name;
    }

    public String tellcolor(){
        System.out.println(color);
        return color;
    }

    public boolean compareWith(CalabashBoy T){
        return T.rank < this.rank;
    }*/

}
