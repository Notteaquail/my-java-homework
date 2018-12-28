package sample;

public class FormationMaker {

    private int[][] formation;
    private int length;
    private int width;
    //private final int MAX_CALABASH_BOYS_COUNT = 7;

    public FormationMaker(){
        formation=null;
        length=0;
        width=0;
    }


    public void singleLineBattleArray(int[] calabashBoysArray){
        length = 7; width = 1;
        formation = new int[length][width];
        for(int i = 0; i < length; i++)
            formation[i][0] = calabashBoysArray[i];
    }

/*    private static void dogFaceName(char[][] f,int  i, int j){
        if(j%3==0)
            f[i][j] = '小';
        else if(j%3==1)
            f[i][j] = '喽';
        else
            f[i][j] = '啰';
    }*/

    public void crescentMoonArray(int[] monsters){
        length = 7; width = 4;
        formation = new int[length][width];
        for(int i = 0; i < length; i++){
            for(int j = 0; j < width; j++) {
                    formation[i][j] = 0;
            }
        }
        formation[0][3]=monsters[0];
        formation[1][3]=monsters[1];
        formation[1][2]=monsters[2];
        formation[2][2]=monsters[3];
        formation[2][1]=monsters[4];
        formation[3][1]=monsters[5];
        formation[3][0]=monsters[6];
        formation[4][2]=monsters[7];
        formation[4][1]=monsters[8];
        formation[5][3]=monsters[9];
        formation[5][2]=monsters[10];
        formation[6][3]=monsters[11];
    }

    public void fangRArray(int[] monsters){
        length = 7; width = 7;
        formation = new int[length][width];
        for(int i = 0; i < length; i++){
            for(int j = 0; j<width;j++){
                    formation[i][j] = 0;
            }
        }
        formation[0][3]=monsters[0];
        formation[1][4]=monsters[1];
        formation[1][2]=monsters[2];
        formation[2][5]=monsters[3];
        formation[2][1]=monsters[4];
        formation[3][6]=monsters[5];
        formation[3][0]=monsters[6];
        formation[4][5]=monsters[7];
        formation[4][1]=monsters[8];
        formation[5][4]=monsters[9];
        formation[5][2]=monsters[10];
        formation[6][3]=monsters[11];
    }

    public int[][] getFormation(){
        return formation;
    }

    public int getLength(){
        return length;
    }

    public int getWidth(){
        return width;
    }

}
