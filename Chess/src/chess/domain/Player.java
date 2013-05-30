
package chess.domain;
/** 
 * pahasti keskenkeräinen luokka, luovutus nappi, voittaminen, undonappi yms tänne
 */ 
public class Player {
    private int [][] boardBefore;
    private int [][] boardAfter;    
    
    public Player() {
        this.boardBefore = new int[8][8];
        this.boardAfter = new int[8][8];
    }
    
    public String giveUp(int turns) {
        String string = "";
        if (turns % 2 == 0) {
            string = WhiteWins();
        } else {
            string = BlackWins();
        }
        return string;
    }
    
    public String BlackWins() {
        return "Black wins!";
    }
    
   public String WhiteWins() {
       return "White wins!";
        
    }    
 
   /** 
    * ehkä pois nämä jos ei aika riitä
    */  
    public void beforeBoard(int[][] before) {
        this.boardBefore = before;
    }
    
    public void afterBoard(int[][] after) {
        this.boardAfter = after;
    }    
    
    public int[][] getBoardBefore() {
        return this.boardBefore;
    }
    
    public int[][] getBoardAfter() {
        return this.boardAfter;
    }
    
    public boolean sameBoard(int[][] before, int[][] after) {
        for (int i = 0; i < before.length; i++) {
            for (int j = 0; j < before.length; j++) { 
                System.out.print(before[i][j]);
                System.out.print(after[i][j]);
                System.out.println();
                if (before[i][j] != after[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
        
    public void undo(){
        
    }
    
}
