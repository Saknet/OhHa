
package chess.game;

import chess.domain.Moves;

    /** 
     * pyörittää pelilautaa
     */

public class Chessboard {
    private int [][] board;
    private Moves moves;  
    private int [] whites;
    private int [] blacks;
    private boolean blackMove;
    private boolean whiteMove;

    /** 
     * luodaan uusi pelilauta
     */
    
    public Chessboard() {
    /**  
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

        this.whites = new int[16];
        this.blacks = new int[16];
        this.moves = new Moves();
        this.blackMove = false;
        this.whiteMove = false;
        
    }   
    
    /** 
     * lisää mustien ja valkoisten nappuloiden sijannit arrayhen
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
     * tulostaa shakki laudan
     */
    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println("");
        }
    }
        
    /** 
     * mustan siirrot laudalla
     * @param sx siirrettävän nappulan alku x-koordinaatti
     * @param sy siirrettävän nappulan alku y-koordinaatti
     * @param ex siirettävän nappulan loppu x-koordinaatti
     * @param ey siirettävän nappulan loppu y-koordinaatti
     */
    public void blackTurn(int sx, int sy, int ex, int ey) { 
        blackMove = false;
        int piece = getPiece(sx, sy); 
        if (piece == 2 && moves.moveBlackPawn(blacks, whites, sx, sy, ex, ey) == true) {  
            moveBlack(sx, sy, ex, ey, piece); 
        }    
        if (piece == 4 && moves.moveRook(board, blacks, sx, sy, ex, ey) == true) {  
            moveBlack(sx, sy, ex, ey, piece);           
        }  
        if (piece == 6 && moves.moveKnight(blacks, sx, sy, ex, ey) == true) {  
            moveBlack(sx, sy, ex, ey, piece);           
        }   
        if (piece == 8 && moves.moveBishop(board, blacks, sx, sy, ex, ey) == true) {  
            moveBlack(sx, sy, ex, ey, piece);
        }
        if (piece == 10 && moves.moveQueen(board, blacks, sx, sy, ex, ey) == true) { 
            moveBlack(sx, sy, ex, ey, piece);
        }        
        if (piece == 12 && moves.moveKing(blacks, sx, sy, ex, ey) == true) { 
            moveBlack(sx, sy, ex, ey, piece);
        }
    }  
    
    /** 
     * valkoisen siirrot laudalla
     * @param sx siirrettävän nappulan alku x-koordinaatti
     * @param sy siirrettävän nappulan alku y-koordinaatti
     * @param ex siirettävän nappulan loppu x-koordinaatti
     * @param ey siirettävän nappulan loppu y-koordinaatti
     */
    public void whiteTurn(int sx, int sy, int ex, int ey) {
        whiteMove = false;
        int piece = getPiece(sx, sy); 
        if (piece == 1 && moves.moveWhitePawn(whites, blacks, sx, sy, ex, ey) == true) {         
            moveWhite(sx, sy, ex, ey, piece);           
        }  
        if (piece == 3 && moves.moveRook(board, whites, sx, sy, ex, ey) == true) {         
            moveWhite(sx, sy, ex, ey, piece);           
        } 
        if (piece == 5 && moves.moveKnight(whites, sx, sy, ex, ey) == true) {  
            moveWhite(sx, sy, ex, ey, piece);           
        } 
        if (piece == 7 && moves.moveBishop(board, whites, sx, sy, ex, ey) == true) {  
            moveWhite(sx, sy, ex, ey, piece);           
        }        
        if (piece == 9 && moves.moveQueen(board, whites, sx, sy, ex, ey) == true) {         
            moveWhite(sx, sy, ex, ey, piece);
        }        
        if (piece == 11 && moves.moveKing(whites, sx, sy, ex, ey) == true) {         
            moveWhite(sx, sy, ex, ey, piece);
        }
    }
    
    /** 
     * suorittaa valkoisen siirron shakkilaudalla
     * @param sx siirrettävän nappulan alku x-koordinaatti
     * @param sy siirrettävän nappulan alku y-koordinaatti
     * @param ex siirettävän nappulan loppu x-koordinaatti
     * @param ey siirettävän nappulan loppu y-koordinaatti
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
     * "syö" mustan nappulan jos se on valkoisen kanssa samassa ruudussa
     * @param x syötävän nappulan x-koordinaatti
     * @param y syötävän nappulan y-koordinaatti
     */     
    public void eliminateBlack(int x, int y) {
        for (int i = 0; i < blacks.length; i++) {
            if (blacks[i] == 10 * x + y) {
                blacks[i] = 99;
            }
        }
    }
    
    /** 
     * "syö" valkoisen nappulan jos se on mustan kanssa samassa ruudussa
     * @param x syötävän nappulan x-koordinaatti
     * @param y syötävän nappulan y-koordinaatti
     */     
    public void eliminateWhite(int x, int y) {
        for (int i = 0; i < whites.length; i++) {
            if (whites[i] == 10 * x + y) {
                whites[i] = 99;
            }
        }
    }
    
    /** 
     * suorittaa mustan siirron shakkilaudalla
     * @param sx siirrettävän nappulan alku x-koordinaatti
     * @param sy siirrettävän nappulan alku y-koordinaatti
     * @param ex siirettävän nappulan loppu x-koordinaatti
     * @param ey siirettävän nappulan loppu y-koordinaatti
     * @param piece siirettävän nappulan numero
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
     * pävittää muuttuneen mustan nappulan sijannin
     * @param x uusi x - koordinaatti
     * @param y uusi y - koordinaatti
     * @param i nappulan koordinaattien sijanti värilistalla
     */ 
    public void editBlacks(int x, int y, int i) {
        blacks[i] = 10 * x + y;        
    }
    
    /** 
     * pävittää muuttuneen valkoisen nappulan sijannin
     * @param x uusi x - koordinaatti
     * @param y uusi y - koordinaatti
     * @param i nappulan koordinaattien sijanti värilistalla
     */
    public void editWhites(int x, int y, int i) {
        whites[i] = 10 * x + y;        
    } 
    
    /** 
     * siirtää nappulaa pelilaudalla
     * @param sx siirrettävän nappulan alku x-koordinaatti
     * @param sy siirrettävän nappulan alku y-koordinaatti
     * @param x siirettävän nappulan loppu x-koordinaatti
     * @param y siirettävän nappulan loppu y-koordinaatt
     * @param piece siirettävän nappulan numero
     */    
    public void movePiece(int sx, int sy, int x, int y, int piece) {
        this.board[sy][sx] = 0;
        this.board[y][x] = piece;        
    }
    
    
    /** 
     * palauttaa mustan nappulan sijannin
     */     
    public int getBlack(int i) {
        return blacks[i];
    }
    
    /** 
     * palauttaa valkoisen nappulan sijannin 
     */  
    public int getWhite(int i) {
        return whites[i];
    }
    /*
     * Palauttaa pelilaudan
     */
    public int[][] getBoard() {
        return board;
    }
   
    /**
     * Vaihtaa pelilaudan(undo)
     * @param old shakkilauta ennen viimeistä siirtoa
     */
    public void oldBoard(int[][] old) {
        this.board = old;
    }
    
    /**
     * palauttaa nappulan arvon jos koordinaatit x ja y ovat pelilaudalla
     * @param x x - koordinaatti
     * @param y y - koordinaatti
     * @return nappulan arvo
     */    
    public int getPiece(int x, int y) {
        int piece = 0;
        if (x >= 0 && y >= 0 && x < 8 && y < 8) {
            piece = this.board[y][x]; 
        }  
        return piece;
    }
    
    public boolean getMoveW() {
        return whiteMove;
    }
    
    public boolean getMoveB() {
        return blackMove;
    }   
   
   
    
}
