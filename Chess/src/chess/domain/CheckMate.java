
package chess.domain;

/**
 * Tämä luokka  tarkistaa onko kuningas shakissa myöhemmin olis tarkoitus lisätä 
 * myös shakkimatti ominaisuus jos semmoisen osaan tehdä.
 */

public class CheckMate {

    private Moves moves;
    private int [] whites;
    private int [] blacks; 
    private int x;
    private int y;
    
    /**
     * Luokan konstruktori, luodaan Moves olio jota tämä luokka käyttää määrittelemään
     * uhkaako tietyn nappulan siirto kuningasta. Luodaan whites ja blacks arrayt 
     * kaikkien nappuloiden sijanteja varten. Luodaan x ja y int muuttujat määrittelemään
     * kyseisen kuninkaan sijanti shakkilaudalla.
     */     
    public CheckMate() {

        this.moves = new Moves();
        this.whites = new int[16];
        this.blacks = new int[16]; 
        this.x = 0;
        this.y = 0;
    }
    
   /** 
     * Metodi joka lisää mustien ja valkoisten nappuloiden sijannit arrayhen.
     * @param board tämän hetken shakkilauta.
     */    
    
    public void addPieces(int[][]board) {
        int k = 0;
        int l = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != 0) {
                    if (board[i][j] % 2 == 0) {
                        this.blacks[k] = j * 10 + i;
                        k++;                        
                    } else {
                        this.whites[l] = j * 10 + i;
                        l++;
                    }
                }                        
            }
        }
    }    

    /**
     * Tarkistaa voiko nappula "syödä" kuninkaan seuravalla siirolla
     * ensin laitettaan valkoisten ja mustien nappuloiden sijannit arrayihin
     * sitten etitään kuninkaan sijanti
     * lopulta katsotaan voiko annettu nappula shakittaa vastapuolen kuningasta.
     * @param board tämän hetken shakki lauta
     * @param piece shakkinappulan numero, tämä määrää kumpi puoli on hyökkääjä
     * @param sx hyökkävän nappulan x - koordinaatti
     * @param sy hyökkävän nappulan y - koordinaatti 
     * @return palauttaa arvon true jos kuningas on hyökkäyksen kohteena
     */   
    public boolean canAttackKing(int[][] board, int piece, int sx, int sy) {    
        addPieces(board);
        findKing(board, piece, sx, sy);
        if (piece % 2 == 0 && checkWhiteKing(board, piece, sx, sy, x, y)) {
            return true;
            }
        if (piece % 2 != 0 && checkBlackKing(board, piece, sx, sy, x, y)) {
            return true;        
        }                  
       
      
        return false;
    } 
    
    /**
     * Tarkistaa voiko nappula "syödä" kuninkaan seuravalla siirolla.
     * @param board tämän hetken shakki lauta
     * @param piece shakkinappulan numero, tämä määrää kumpi puoli on hyökkääjä
     * @param sx hyökkävän nappulan x - koordinaatti
     * @param sy hyökkävän nappulan y - koordinaatti 
     */    
    public void findKing(int[][] board, int piece, int sx, int sy) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (piece % 2 == 0 && board[i][j] == 11) {
                    x = j;
                    y = i;
                } 
                if (piece % 2 != 0 && board[i][j] == 12) {
                    x = j;
                    y = i;
                }                
                
            }
        }               
    }
    /**
     * Tarkistaa onko valkoinen kuningas hyökkäyksen kohteena.
     * @param board tämän hetken shakki lauta
     * @param piece siirtyneen nappulan numero
     * @param sx hyökkävän mustan nappulan x - koordinaatti
     * @param sy hyökkävän mustan nappulan y - koordinaatti
     * @param x valkoisen kuninkaan x - koordinaatti
     * @param y valkoisen kuninkaan y - koordinaatti
     * @return palauttaa arvoksi true jos valkoinen kuningas on hyökkäyksen kohteena
     */  
    public boolean checkWhiteKing(int[][] board, int piece, int sx, int sy, int x, int y) {
        if (piece == 2 && moves.moveBlackPawn(blacks, whites, sx, sy, x, y)) {     
            return true;
        }        
        if (piece == 4 && moves.moveRook(board, blacks, sx, sy, x, y)) {         
            return true;
        } 
        if (piece == 6 && moves.moveKnight(blacks, sx, sy, x, y)) {   
            return true;            
        } 
        if (piece == 8 && moves.moveBishop(board, blacks, sx, sy, x, y)) { 
            return true;            
        }        
        if (piece == 10 && moves.moveQueen(board, blacks, sx, sy, x, y)) {
            return true;            
        }        
        return false;
    } 
    
     /**
      * Tarkistaa onko musta kuningas hyökkäyksen kohteena.
      * @param board tämän hetken shakki lauta
      * @param piece siirtyneen nappulan numero
      * @param sx hyökkävän valkoisen nappulan x - koordinaatti
      * @param sy hyökkävän valkoisen nappulan y - koordinaatti
      * @param x mustan kuninkaan x - koordinaatti
      * @param y mustan kuninkaan y - koordinaatti
     * @return palauttaa arvoksi true jos musta kuningas on hyökkäyksen kohteena
     */    
    public boolean checkBlackKing(int[][] board, int piece, int sx, int sy, int x, int y) {       
        if (piece == 1 && moves.moveWhitePawn(whites, blacks, sx, sy, x, y)) {  
            return true;
        }    
        if (piece == 3 && moves.moveRook(board, whites, sx, sy, x, y)) {  
            return true;
        }  
        if (piece == 5 && moves.moveKnight(whites, sx, sy, x, y)) {  
            return true;
        }   
        if (piece == 7 && moves.moveBishop(board, whites, sx, sy, x, y)) {  
            return true;
        }
        if (piece == 9 && moves.moveQueen(board, whites, sx, sy, x, y)) { 
            return true;
        }         
        return false;
    } 
    
    /**
     * 4 getteria testauksen helpottamista varten
     */
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    } 
    
    public int getBlack(int i) {
        return blacks[i];
    }
 
    public int getWhite(int i) {
        return whites[i];
    }    
    
}
