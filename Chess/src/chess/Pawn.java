
package chess;


public class Pawn {
    private int x;
    private int y;
    private int moves = 0;
    
    public Pawn(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    
    public void movePawn(int xx, int yy) {
        if (moves == 0) {
            if (this.y == y && Math.abs(this.x - xx) < 3) {
                this.x = xx;
                this.y = yy;
                
            }
        }
        if (this.y == yy || (Math.abs(this.y - yy) == 1 && containsEnemy(xx, yy) == true)) {
            this.x = xx;
            this.y = yy;
        }
    }
    
    public boolean containsEnemy(int xx, int yy) {
        return true;
    }
    
}
