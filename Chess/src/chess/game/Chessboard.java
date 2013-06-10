
package chess.game;

import chess.domain.Moves;

    /** 
     * Luokka joka pyörittää pelilautaa.
     */

public class Chessboard {
    private int [][] board;
    private Moves moves;  
    private int [] whites;
    private int [] blacks;
    private boolean blackMove;
    private boolean whiteMove;
    private Piece piece;

    /**
     * Luokan konstruktori, luodaan Moves olio jota tämä luokka käyttää määrittelemään
     * onko tietty siirto laillinen. Luodaan whites ja blacks arrayt joihin 
     * lisätään luokassa valkoisten(16kpl) ja mustien nappuloiden(16kpl) sijannit, näitä käytettään
     * määrittelemään onko jokin siirto lailinen vai ei. Lisäksi luodaan blackMove ja
     * whiteMove boolean muuttujat, joita chess luokka käyttää palauttamaan siirron puolelle
     * joka on suorittanut laittoman siirron, asetettaan nille molemille alkuarvoksi false.
     */ 
    
    public Chessboard() {

        this.whites = new int[16];
        this.blacks = new int[16];
        this.moves = new Moves();
        this.blackMove = false;
        this.whiteMove = false;

        
    } 
    
     /** 
     * Metodi joka luo uuden pelilaudan.
     */
       
    public void newBoard() {        
        /** 
         * Metodi joka luo uuden shakkilaudan.
         * 1 = valkoinen sotilas, 2 = musta sotilas, 3 = valkoinen torni, 4 = musta torni
         * 5 = valkoinen ratsu, 6 = musta ratsu, 7 = valkoinen lähetti, 8 = musta lähetti
         * 9 = valkoinen kuningatar, 10 = musta kuningatar, 11 = valkoinen kuningas
         * 12 = musta kuningas, 0 = tyhjä
         */    
        this.board = new int[][] {{4,6,8,10,12,8,6,4},
                                  {2,2,2,2,2,2,2,2},
                                  {0,0,0,0,0,0,0,0},
                                  {0,0,0,0,0,0,0,0},
                                  {0,0,0,0,0,0,0,0},
                                  {0,0,0,0,0,0,0,0},
                                  {1,1,1,1,1,1,1,1},
                                  {3,5,7,9,11,7,5,3}};
               
    }
  
    
    /** 
     * Metodi joka lisää mustien ja valkoisten nappuloiden sijannit arrayhen.
     */
    
    public void addPieces() {
        int k = 0;
        int l = 0;
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board.length; j++) {
                if (this.board[i][j] != 0) {
                    if (this.board[i][j] % 2 == 0) {
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
     * Metodi joka tarkistaa moves olion avulla onko mustan nappulan siirto
     * laillinen.
     * 
     * @param sx siirrettävän nappulan alku x-koordinaatti.
     * @param sy siirrettävän nappulan alku y-koordinaatti.
     * @param ex siirettävän nappulan loppu x-koordinaatti.
     * @param ey siirettävän nappulan loppu y-koordinaatti.
     */
    public void blackTurn(int sx, int sy, int ex, int ey) { 
        blackMove = false;
        int p = getPiece(sx, sy); 
        if (piece.BLACKPAWN.getPiece() == p  && moves.moveBlackPawn(blacks, whites, sx, sy, ex, ey)) {  
            moveBlack(sx, sy, ex, ey, p); 
        }    
        if (piece.BLACKROOK.getPiece() == p  && moves.moveRook(board, blacks, sx, sy, ex, ey)) {  
            moveBlack(sx, sy, ex, ey, p);           
        }  
        if (piece.BLACKKNIGHT.getPiece() == p && moves.moveKnight(blacks, sx, sy, ex, ey)) {  
            moveBlack(sx, sy, ex, ey, p);           
        }   
        if (piece.BLACKBISHOP.getPiece() == p  && moves.moveBishop(board, blacks, sx, sy, ex, ey)) {  
            moveBlack(sx, sy, ex, ey, p);
        }
        if (piece.BLACKQUEEN.getPiece() == p  && moves.moveQueen(board, blacks, sx, sy, ex, ey)) { 
            moveBlack(sx, sy, ex, ey, p);
        }        
        if (piece.BLACKKING.getPiece() == p  && moves.moveKing(blacks, sx, sy, ex, ey)) { 
            moveBlack(sx, sy, ex, ey, p);
        }
    }  
    
    /** 
     * Metodi joka tarkistaa moves olion avulla onko valkoisen nappulan siirto
     * laillinen.
     * 
     * @param sx siirrettävän nappulan alku x-koordinaatti.
     * @param sy siirrettävän nappulan alku y-koordinaatti.
     * @param ex siirettävän nappulan loppu x-koordinaatti.
     * @param ey siirettävän nappulan loppu y-koordinaatti.
     */
    public void whiteTurn(int sx, int sy, int ex, int ey) {
        whiteMove = false;
        int p = getPiece(sx, sy); 
        if (piece.WHITEPAWN.getPiece() == p && moves.moveWhitePawn(whites, blacks, sx, sy, ex, ey)) {         
            moveWhite(sx, sy, ex, ey, p);           
        }  
        if (piece.WHITEKNIGHT.getPiece() == p && moves.moveRook(board, whites, sx, sy, ex, ey)) {         
            moveWhite(sx, sy, ex, ey, p);           
        } 
        if (piece.WHITEBISHOP.getPiece() == p && moves.moveKnight(whites, sx, sy, ex, ey)) {  
            moveWhite(sx, sy, ex, ey, p);           
        } 
        if (piece.WHITEBISHOP.getPiece() == p && moves.moveBishop(board, whites, sx, sy, ex, ey)) {  
            moveWhite(sx, sy, ex, ey, p);           
        }        
        if (piece.WHITEQUEEN.getPiece() == p && moves.moveQueen(board, whites, sx, sy, ex, ey)) {         
            moveWhite(sx, sy, ex, ey, p);
        }        
        if (piece.WHITEKING.getPiece() == p && moves.moveKing(whites, sx, sy, ex, ey)) {         
            moveWhite(sx, sy, ex, ey, p);
        }
    }
    
    /** 
     * Metodi joka uorittaa valkoisen siirron shakkilaudalla.
     * 
     * @param sx siirrettävän nappulan alku x-koordinaatti.
     * @param sy siirrettävän nappulan alku y-koordinaatti.
     * @param ex siirettävän nappulan loppu x-koordinaatti.
     * @param ey siirettävän nappulan loppu y-koordinaatti.
     * @param piece siirettävän nappulan numero
     */    
    public void moveWhite(int sx, int sy, int ex, int ey, int piece) {
            for (int i = 0; i < whites.length; i++) {
                if (whites[i] == 10 * sx + sy) {
                    editWhites(ex, ey, i);  
                    movePiece(sx, sy, ex, ey, piece); 
                    eliminateBlack(ex, ey);
                    whiteMove = true;
                }       
            }         
    }
    
    /** 
     * "Syö" mustan nappulan jos se on valkoisen kanssa samassa ruudussa.
     * 
     * @param x syötävän nappulan x-koordinaatti.
     * @param y syötävän nappulan y-koordinaatti.
     */     
    public void eliminateBlack(int x, int y) {
        for (int i = 0; i < blacks.length; i++) {
            if (blacks[i] == 10 * x + y) {
                blacks[i] = 99;
            }
        }
    }
    
    /** 
     * "Syö" valkoisen nappulan jos se on mustan kanssa samassa ruudussa.
     * 
     * @param x syötävän nappulan x-koordinaatti.
     * @param y syötävän nappulan y-koordinaatti.
     */     
    public void eliminateWhite(int x, int y) {
        for (int i = 0; i < whites.length; i++) {
            if (whites[i] == 10 * x + y) {
                whites[i] = 99;
            }
        }
    }
    
    /** 
     * Metodi joka suorittaa mustan siirron shakkilaudalla.
     * 
     * @param sx siirrettävän nappulan alku x-koordinaatti.
     * @param sy siirrettävän nappulan alku y-koordinaatti.
     * @param ex siirettävän nappulan loppu x-koordinaatti.
     * @param ey siirettävän nappulan loppu y-koordinaatti.
     * @param piece siirettävän nappulan numero.
     */     
    public void moveBlack(int sx, int sy, int ex, int ey, int piece) {
            for (int i = 0; i < blacks.length; i++) {
                if (blacks[i] == 10 * sx + sy) {
                    editBlacks(ex, ey, i); 
                    movePiece(sx, sy, ex, ey, piece);
                    eliminateWhite(ex, ey);
                    blackMove = true;
                }
            }        
    }
    
    /** 
     * Pävittää muuttuneen mustan nappulan sijannin mustien nappuloiden arrayhin.
     * 
     * @param x uusi x - koordinaatti.
     * @param y uusi y - koordinaatti.
     * @param i nappulan koordinaattien sijanti värilistalla.
     */ 
    public void editBlacks(int x, int y, int i) {
        blacks[i] = 10 * x + y;        
    }
    
    /** 
     * Pävittää muuttuneen valkoisen nappulan sijannin valkoisten nappuloiden arrayhin.
     * 
     * @param x uusi x - koordinaatti.
     * @param y uusi y - koordinaatti.
     * @param i nappulan koordinaattien sijanti värilistalla.
     */
    public void editWhites(int x, int y, int i) {
        whites[i] = 10 * x + y;        
    } 
    
    /** 
     * Siirtää nappulaa pelilaudalla.
     * 
     * @param sx siirrettävän nappulan alku x-koordinaatti.
     * @param sy siirrettävän nappulan alku y-koordinaatti.
     * @param x siirettävän nappulan loppu x-koordinaatti.
     * @param y siirettävän nappulan loppu y-koordinaatt.
     * @param piece siirettävän nappulan numero.
     */    
    public void movePiece(int sx, int sy, int x, int y, int piece) {
        this.board[sy][sx] = 0;
        this.board[y][x] = piece;        
    }
       
    /** 
     * Palauttaa mustan nappulan sijannin.
     */     
    public int getBlack(int i) {
        return blacks[i];
    }
    
    /** 
     * Palauttaa valkoisen nappulan sijannin. 
     */  
    public int getWhite(int i) {
        return whites[i];
    }
    
    /*
     * Palauttaa pelilaudan.
     */
    public int[][] getBoard() {
        return board;
    }
   
    /**
     * Vaihtaa pelilaudan(undo).
     * 
     * @param old shakkilauta ennen viimeistä siirtoa
     */
    public void oldBoard(int[][] old) {
        this.board = old;
    }
    
    /**
     * palauttaa nappulan arvon jos koordinaatit x ja y ovat pelilaudalla.
     * 
     * @param x x - koordinaatti.
     * @param y y - koordinaatti.
     * @return nappulan arvo.
     */    
    public int getPiece(int x, int y) {
        int piece = 0;
        if (x >= 0 && y >= 0 && x < 8 && y < 8) {
            piece = this.board[y][x]; 
        }  
        return piece;
    }
    
    /**
     * Palauttaa boolean muuttujan joka ilmoittaa Chess oliolle oliko valkoisen 
     * siirto laillinen.
     * 
     * @return whiteMove.
     */     
    public boolean getMoveW() {
        return whiteMove;
    }
    
     /**
     * Palauttaa boolean muuttujan joka ilmoittaa Chess oliolle oliko mustan 
     * nsiirto laillinen.
     * 
     * @return whiteMove.
     */    
    public boolean getMoveB() {
        return blackMove;
    }   
   
   
    
}
