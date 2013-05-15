
package chess;

import java.util.Scanner;

//pyörittää pelilautaa, tähän luokkaan tulee aika paljon koodia
public class Chessboard {
    private int [][] board;
    private Movement movement;
    private int turns;
    private Scanner reader;    
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
        this.reader = new Scanner(System.in);
        this.whites = new int[16];
        this.blacks = new int[16];
        this.movement = new Movement();

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
    
    
    //aloittaa vuorot
    public void turn() {
        while(turns < 1000) {           
            if (turns % 2 == 0) {
                turns++;
                blackTurn();           
            } else {
                turns++;
                whiteTurn();
            }
        }
    }
    //vuoroihin pitäisi lisätä koodia joka palauttaa vuoron pelajalle jos nappullaa ei voida siirtää
    //mustan vuoro
    public void blackTurn() {
        System.out.println("Nappulan alku x-kordinaatti");  //sika ruma JButtom juttu sitten myöhemmin pelilaudan viereen kun teen grafiikat) 
        int sx = Integer.parseInt(reader.nextLine());
        System.out.println("Nappulan alku y-kordinaatti");
        int sy = Integer.parseInt(reader.nextLine());
        int piece = this.board[sx][sy];        
        System.out.println("Nappulan loppu x-kordinaatti");        
        int ex = Integer.parseInt(reader.nextLine());
        System.out.println("Nappulan loppu y-kordinaatti");        
        int ey = Integer.parseInt(reader.nextLine());
        if (movement.checkStart(blacks, sx, sy) == true && movement.moveBlackKing(blacks, ex, ey) == true) { 
            for (int i = 0; i < blacks.length; i++) {
                if (blacks[i] == 10 * sx + sy) {
                    editBlacks(ex, ey, i); 
                    movePiece(sx, sy, piece);
                }
            }
        }
    }
    
    //valkoisen vuoro
    public void whiteTurn() {
        System.out.println("Nappulan alku x-kordinaatti");  //sika ruma JButtom juttu sitten myöhemmin pelilaudan viereen kun teen grafiikat) 
        int sx = Integer.parseInt(reader.nextLine());
        System.out.println("Nappulan alku y-kordinaatti");
        int sy = Integer.parseInt(reader.nextLine());  
        System.out.println("Nappulan loppu x-kordinaatti");
        int piece = this.board[sx][sy];        
        int ex = Integer.parseInt(reader.nextLine());
        System.out.println("Nappulan loppu y-kordinaatti");        
        int ey = Integer.parseInt(reader.nextLine());
        if (movement.checkStart(whites, sx, sy) == true && movement.moveWhiteKing(whites, ex, ey) == true) {         
            for (int i = 0; i < whites.length; i++) {
                if (whites[i] == 10 * sx + sy) {
                    editWhites(ex, ey, i);  
                    movePiece(sx, sy, piece);                  
                }       
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
    public void movePiece(int x, int y, int piece) {
        this.board[y][x] = 0;
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
