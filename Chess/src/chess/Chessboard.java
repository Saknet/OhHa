
package chess;

//pyörittää pelilautaa
public class Chessboard {
    private int [][] board;
    private MovesWhite mWhite;
    private MovesBlack mBlack;   
    private int [] whites;
    private int [] blacks;

    // luodaan uusi pelilauta
    public Chessboard() {
        // 1 = valkoinen sotilas, 2 = musta sotilas, 3 = valkoinen torni, 4 = musta torni
        // 5 = valkoinen ratsu, 6 = musta ratsu, 7 = valkoinen lähetti, 8 = musta lähetti
        // 9 = valkoinen kuningatar, 10 = musta kuningatar, 11 = valkoinen kuningas
        // 12 = musta kuningas, 0 = tyhjä
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
        this.mWhite = new MovesWhite();
        this.mBlack = new MovesBlack();
    }   
    
    //lisää mustien ha valkoisten nappuloiden sijannit arrayhen
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
    
    //tulostaa shakki laudan
    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println("");
        }
    }
    //vuoroihin pitäisi lisätä koodia joka palauttaa vuoron pelajalle jos nappullaa ei voida siirtää
    //mustan siirrot laudalla
    public void blackTurn(int sx, int sy, int ex, int ey) {
        int piece = this.board[sy][sx]; 
        if (piece == 2 && mBlack.moveBlackPawn(blacks, whites, sx, sy, ex, ey) == true) {  
            moveBlack(sx, sy, ex, ey, piece);           
        }    
        if (piece == 4 && mBlack.moveBlackRook(board, blacks, sx, sy, ex, ey) == true) {  
            moveBlack(sx, sy, ex, ey, piece);           
        }  
        if (piece == 6 && mBlack.moveBlackKnight(blacks, sx, sy, ex, ey) == true) {  
            moveBlack(sx, sy, ex, ey, piece);           
        }   
        if (piece == 8 && mBlack.moveBlackBishop(board, blacks, sx, sy, ex, ey) == true) {  
            moveBlack(sx, sy, ex, ey, piece);
        }
        if (piece == 10 && mBlack.moveBlackQueen(board, blacks, sx, sy, ex, ey) == true) { 
            moveBlack(sx, sy, ex, ey, piece);
        }        
        if (piece == 12 && mBlack.moveBlackKing(blacks, sx, sy, ex, ey) == true) { 
            moveBlack(sx, sy, ex, ey, piece);
        }
    }
    
    //valkoisen siirrot laudalla
    public void whiteTurn(int sx, int sy, int ex, int ey) {
        int piece = this.board[sy][sx]; 
        if (piece == 1 && mWhite.moveWhitePawn(whites, blacks, sx, sy, ex, ey) == true) {         
            moveWhite(sx, sy, ex, ey, piece);           
        }  
        if (piece == 3 && mWhite.moveWhiteRook(board, whites, sx, sy, ex, ey) == true) {         
            moveWhite(sx, sy, ex, ey, piece);           
        } 
        if (piece == 5 && mWhite.moveWhiteKnight(whites, sx, sy, ex, ey) == true) {  
            moveWhite(sx, sy, ex, ey, piece);           
        } 
        if (piece == 7 && mWhite.moveWhiteBishop(board, whites, sx, sy, ex, ey) == true) {  
            moveWhite(sx, sy, ex, ey, piece);           
        }        
        if (piece == 9 && mWhite.moveWhiteQueen(board, whites, sx, sy, ex, ey) == true) {         
            moveWhite(sx, sy, ex, ey, piece);
        }        
        if (piece == 11 && mWhite.moveWhiteKing(whites, sx, sy, ex, ey) == true) {         
            moveWhite(sx, sy, ex, ey, piece);
        }
    }
    //suorittaa valkoisen siirron shakkilaudalla
    public void moveWhite(int sx, int sy, int ex, int ey, int piece) {
            for (int i = 0; i < whites.length; i++) {
                if (whites[i] == 10 * sx + sy) {
                    editWhites(ex, ey, i);  
                    movePiece(sx, sy, ex, ey, piece); 
                    eliminateBlack(ex, ey);
                }       
            }         
    }
    
    //"syö" mustan nappulan jos se on valkoisen kanssa samassa ruudussa
    public void eliminateBlack(int x, int y) {
        for (int i = 0; i < blacks.length; i++) {
            if (blacks[i] == 10 * x + y) {
                blacks[i] = 99;
            }
        }
    }
    
    //"syö" valkoisen nappulan jos se on mustan kanssa samassa ruudussa
    public void eliminateWhite(int x, int y) {
        for (int i = 0; i < whites.length; i++) {
            if (whites[i] == 10 * x + y) {
                whites[i] = 99;
            }
        }
    }     
    //suorittaa mustan siirron shakkilaudalla
    public void moveBlack(int sx, int sy, int ex, int ey, int piece) {
            for (int i = 0; i < blacks.length; i++) {
                if (blacks[i] == 10 * sx + sy) {
                    editBlacks(ex, ey, i); 
                    movePiece(sx, sy, ex, ey, piece);
                    eliminateWhite(ex, ey);
                }
            }        
    }
    
    //pävittää muuttuneen mustan nappulan sijannin
    public void editBlacks(int x, int y, int i) {
        blacks[i] = 10 * x + y;        
    }
    //päivittää muuttuneen valkoisen nappulan sijannin
    public void editWhites(int x, int y, int i) {
        whites[i] = 10 * x + y;        
    }    
    
    //siirtää nappulaa pelilaudalla
    public void movePiece(int sx, int sy, int x, int y, int piece) {
        this.board[sy][sx] = 0;
        this.board[y][x] = piece;        
    }
    
    //palauttaa paikassa x,y olevan nappulan arvon
    public int getPiece(int x, int y) {
        return board[y][x];
    }
    
    //palauttaa mustan nappulan sijannin
    public int getBlack(int i) {
        return blacks[i];
    }
    
    //palauttaa valkoisen nappulan sijannin   
    public int getWhite(int i) {
        return whites[i];
    }
}
