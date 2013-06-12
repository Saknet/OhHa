
package chess.domain;

import java.util.ArrayList;


/**
 * Tämä luokka  on shakki ja shakkimatti tilanteiden tarkistamista varten.
 */

public class CheckMate {

    private Moves moves;
    private int [] whites;
    private int [] blacks; 
    private int x;
    private int y;
    private int [][] cb;
    private ArrayList<Integer> aroundKingX;
    private ArrayList<Integer> aroundKingY; 
    private ArrayList<Integer> blockX;
    private ArrayList<Integer> blockY;
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
        this.cb = new int[8][8];
        this.x = 0;
        this.y = 0;
        this.aroundKingX = new ArrayList<Integer>();
        this.aroundKingY = new ArrayList<Integer>();   
        this.blockX = new ArrayList<Integer>();
        this.blockY = new ArrayList<Integer>();          
    }
    
   /** 
     * Metodi joka lisää mustien ja valkoisten nappuloiden sijannit arrayhen.
     * @param board tämän hetken shakkilauta.
     */    
    
    public void addPieces(int[][]board) {
        this.cb = board;
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
        findKing(board, piece);
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
     */    
    public void findKing(int[][] board, int piece) {
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
   
    /**
     * Tämä metodi lisää kuninkaan ympärillä olevat ruudut 2teen ArrayListiin,
     * shakkimatti tilanteen tarkistamista varten.
     */    
    public void addSquares() {
        this.aroundKingX.clear();
        this.aroundKingY.clear();
        if (x - 1 > -1 && y - 1 > -1 && cb[y - 1][x - 1] == 0) {
            this.aroundKingX.add((x - 1));
            this.aroundKingY.add((y - 1));            
        }
        if (y - 1 > -1 && cb[y - 1][x] == 0) {
            this.aroundKingX.add((x));
            this.aroundKingY.add((y - 1));            
        } 
        if (x + 1 < 8 && y - 1 > -1 && cb[y - 1][x + 1] == 0) {
            this.aroundKingX.add((x + 1));
            this.aroundKingY.add((y - 1)); 
        }
        if (x + 1 < 8 && cb[y][x + 1] == 0) {
            this.aroundKingX.add((x + 1));
            this.aroundKingY.add((y)); 
        } 
        if (x + 1 < 8 && y + 1 < 8 && cb[y + 1][x + 1] == 0) {
            this.aroundKingX.add((x + 1));
            this.aroundKingY.add((y + 1)); 
        } 
        if (y + 1 < 8 && cb[y + 1][x] == 0) {
            this.aroundKingX.add((x));
            this.aroundKingY.add((y + 1)); 
        } 
        if (x - 1 > -1 && y + 1 < 8 && cb[y + 1][x - 1] == 0) {
            this.aroundKingX.add((x - 1));
            this.aroundKingY.add((y + 1)); 
        }
        if (x - 1 > -1 && cb[y][x - 1] == 0) {
            this.aroundKingX.add((x - 1));
            this.aroundKingY.add((y)); 
        }                
    }
     /**
     * Tarkistettaan pystyykö kuningas liikkumaan ympärillä oleviin ruutuihinsa
     * 
     * @return palauttaa true jos kuningas pystyy liikkumaan
     */      
    public boolean canKingMove() {
        int checkX = 0;
        int checkY = 0;
        int piece = 0;
        int l = 0;
        for (int k = 0; k < aroundKingX.size(); k++) { 
            for (int i = 0; i < cb.length; i++) {
                for (int j = 0; j < cb.length; j++) {
                    checkX = aroundKingX.get(k);
                    checkY = aroundKingY.get(k);                 
                    if (cb[i][j] != 0 && cb[i][j] % 2 == 0) {
                        piece = cb[i][j];
                        if (checkWhiteKing(cb, piece, j, i, checkX, checkY)) {
                            l++;
                        }                        
                    }
                    if (cb[i][j] != 0 && cb[i][j] % 2 != 0) {
                        piece = cb[i][j];
                        if (checkBlackKing(cb, piece, j, i, checkX, checkY)) {
                            l++;
                        }                                               
                    }                     
                }
            }
            if (k > l) {
                return false;
            }            
            l = k;             
        }
        
        return true;
    }
 
     /**
     * Tarkistettaan pystytäänkö kuningasta vastaan hyökkävä nappula "syömään" tai
     * voidaanko sen uhka blockata jollain nappullalla, jos hyökkävä nappula on torni,
     * lähetti tai kuningatar.
     * 
     * @param x hyökkävän nappulan x - koordinaatti
     * @param y hyökkävän nappulan y - koordinaatti
     * @return palauttaa true jos kuningas voidaan pelastaa muiden nappuloiden toimesta
     */     
    public boolean canTakeDownAttacker(int x, int y) {
        if (canBlock(x, y)) {
            return true;
        }
        for (int i = 0; i < cb.length; i++) {
            for (int j = 0; j < cb.length; j++) {
                if (cb[y][x] % 2 == 0 && cb[i][j] != 0 && cb[i][j] % 2 != 0) {
                    if (checkBlackKing(cb, cb[i][j], j, i, x, y)) {
                        return true;
                    }
                } 
                if (cb[y][x] % 2 != 0 && cb[i][j] != 0 && cb[i][j] % 2 == 0) {
                    if (checkWhiteKing(cb, cb[i][j], j, i, x, y)) {
                        return true;
                    }
                }                 
            }
        }
        return false;
    }
       
     /**
     * Tarkistettaan pystytäänkö kuningasta vastaan hyökkävän nappulan hyökkäys
     * estämään jonkun oman nappulan toimesta.
     * 
     * @param ex hyökkävän nappulan x - koordinaatti
     * @param ey hyökkävän nappulan y - koordinaatti
     * @return palauttaa true jos kuningas voidaan pelastaa muiden nappuloiden toimesta
     */      
    public boolean canBlock(int ex, int ey) {
        this.blockX.clear();
        this.blockY.clear();        
        if (cb[ey][ex] == 3 || cb[ey][ex] == 4) {
            if (blockRook(ex, ey)) {
            return true;
            }
        }
        
        if (cb[ey][ex] == 7 || cb[ey][ex] == 8) {
            if (blockBishop(ex, ey)) {
            return true;
            }
        } 
        if (cb[ey][ex] == 9 || cb[ey][ex] == 10) {
            if (blockBishop(ex, ey) || blockRook(ex, ey)) {
            return true;
            }
        }        
        
        
        return false;
    }
    
     /**
     * Tarkistettaan pystytäänkö kuningasta vastaan hyökkävän tornin hyökkäys
     * estämään.
     * 
     * @param ex hyökkävän nappulan x - koordinaatti
     * @param ey hyökkävän nappulan y - koordinaatti
     * @return palauttaa true jos tornin hyökkäys torjutaan.
     */    
    public boolean blockRook(int ex, int ey) {
            if (ex == x) {
                rockVertical(ex, ey);
            } else { 
                rockHorizontal(ex, ey);
            }              
            if (blockCheck()) {
                return true;
            } 
            
            return false;
    }
     /**
     * Lisätään arraylistoihin tornin ja kuninkaan välissä olevat ruudut, jos
     * torni uhkaa kuningasta pystysuunnassa.
     * 
     * @param ex hyökkävän nappulan x - koordinaatti
     * @param ey hyökkävän nappulan y - koordinaatti
     */     
    public void rockVertical(int ex, int ey) {
        if (ey < y) {
            for (int i = ey + 1; i < y; i++) {
                blockX.add(ex);
                blockY.add(i);
            }  
        } else {
            for (int i = ey - 1; i > y; i--) {
                blockX.add(ex);
                blockY.add(i);
            }
        }         
    }

     /**
     * Lisätään arraylistoihin tornin ja kuninkaan välissä olevat ruudut, jos
     * torni uhkaa kuningasta vaakasuunnassa.
     * 
     * @param ex hyökkävän nappulan x - koordinaatti
     * @param ey hyökkävän nappulan y - koordinaatti
     */     
    public void rockHorizontal(int ex, int ey) {
        if (ex < x) {
            for (int i = ex + 1; i < x; i++) {
                blockX.add(i);
                blockY.add(ey);
            }       
        } else {
            for (int i = ex - 1; i > x; i--) {
                blockX.add(i);
                blockY.add(ey);
            }
        } 
    }
 
     /**
     * Tarkistettaan pystytäänkö kuningasta vastaan hyökkävän lähetin hyökkäys
     * estämään.
     * 
     * @param ex hyökkävän nappulan x - koordinaatti
     * @param ey hyökkävän nappulan y - koordinaatti
     * @return palauttaa true jos lähetin hyökkäys torjutaan.
     */     
    public boolean blockBishop(int ex, int ey) {
            if (ex > x && ey > y) {
                bishopNW(ex, ey);
            }
            
            if (ex > x && ey < y) {  
                bishopSW(ex, ey);
            }  
            
            if (ex < x && ey > y) {
                bishopNE(ex, ey);
            }
                        
            if (ex < x && ey < y) {
                bishopSE(ex, ey);                
            } 
            
            if (blockCheck()) {
                return true;
            } 
            
            return false;
    }

    /**
     * Lisätään arraylistoihin lähetin ja kuninkaan välissä olevat ruudut, jos
     * lähetti uhkaa kuningasta yläoikealta.
     * 
     * @param ex hyökkävän nappulan x - koordinaatti
     * @param ey hyökkävän nappulan y - koordinaatti
     */ 
    public void bishopNW(int ex, int ey) {
        int k = 0;
        for (int i = ex - 1; i > x; i--) {
            k++;
            blockX.add(i);
            blockY.add(ey - k);
        }        
    }
    
    /**
     * Lisätään arraylistoihin lähetin ja kuninkaan välissä olevat ruudut, jos
     * lähetti uhkaa kuningasta yläoikealta.
     * 
     * @param ex hyökkävän nappulan x - koordinaatti
     * @param ey hyökkävän nappulan y - koordinaatti
     */     
    public void bishopSW(int ex, int ey) {
        int k = 0;
        for (int i = ex - 1; i > x; i--) {
            k++;
            blockX.add(i);
            blockY.add(ey + k);            
        }        
    }
  
    /**
     * Lisätään arraylistoihin lähetin ja kuninkaan välissä olevat ruudut, jos
     * lähetti uhkaa kuningasta alavasemmalta.
     * 
     * @param ex hyökkävän nappulan x - koordinaatti
     * @param ey hyökkävän nappulan y - koordinaatti
     */     
    public void bishopNE(int ex, int ey) {
        int k = 0;                
        for (int i = ex + 1; i < x; i++) {
            k++; 
            blockX.add(i);
            blockY.add(ey - k);              
        }                
    }

    /**
     * Lisätään arraylistoihin lähetin ja kuninkaan välissä olevat ruudut, jos
     * lähetti uhkaa kuningasta ylävasemmalta.
     * 
     * @param ex hyökkävän nappulan x - koordinaatti
     * @param ey hyökkävän nappulan y - koordinaatti
     */     
    public void bishopSE(int ex, int ey) {
        int k = 0;
        for (int i = ex + 1; i < x; i++) {
            k++;
            blockX.add(i);
            blockY.add(ey + k);             
        }        
    }

    /**
     * Varsinainen hyökkäyksen estämisen tarkistava metodi.
     * 
     * @return palauttaa true jos hyökkäys voidaan estää
     */    
    public boolean blockCheck() {       
        for (int k = 0; k < blockX.size(); k++) {
            for (int i = 0; i < cb.length; i++) {
                for (int j = 0; j < cb.length; j++) {
                    if (cb[i][j] % 2 != 0 && cb[i][j] != 0) {
                        if (checkWhiteKing(cb, cb[i][j], j, i, blockX.get(k), blockY.get(k))) {
                            System.out.println(i);
                            System.out.println(j);
                            return true;
                        }
                    } 
                    if (cb[i][j] % 2 == 0 && cb[i][j] != 0) {
                        if (checkBlackKing(cb, cb[i][j], j, i,blockX.get(k), blockY.get(k))) {
                            return true;
                        }
                    }                 
                }
            }
        }
        return false;
    }
}
