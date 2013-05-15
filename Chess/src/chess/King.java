
package chess;

public class King {
    private int x;
    private int y; 
    
    public King(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getY(){
       return this.y;
   }
   
    public int getX(){
        return this.x;
   }    
    
    public void moveKing(int xx, int yy) {
        int currentx = getX();
        int currenty = getY();
        if (Math.abs(currentx - xx) == 1 && Math.abs(currenty - yy) == 1 
                && xx >= 0 && xx < 9 && yy >= 0 && yy < 9 && containsOwn(xx, yy) == false) {
            this.x = xx;
            this.y = yy;
        }
    }
    
    public boolean containsOwn(int xx, int yy) {
        return false;
    }
    
    
}
