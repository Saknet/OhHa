
package chess.game;

import chess.domain.CheckMate;
import chess.domain.Menu;
import java.io.FileNotFoundException;
import java.io.IOException;

/** 
 * kontrolloiva luokka, tämän luokan avulla GUI pyörittää itse pelilogiikkaa.
 */ 
public class Chess {
    private Chessboard board;
    private int turns;  
    private CheckMate cm;
    private int[][] cb;
    private int info;
    private Menu player;

    
    /**
     * Luokan konstruktori, luodaan oliot ChessBoard ja CheckMate joita luokka
     * käyttää, lisäksi luodaan shakkilautakopio array jota GUI voi käyttää, 
     * turns muuttuja joka pitää kirjaa vuoroista ja info muuttuja jota käytettään
     * ilmoittamaan pelitilannetta GUIssa (shakki ja voitto).
     */    
    public Chess() { 
        this.board = new Chessboard();
        this.cm = new CheckMate();
        this.cb =  new int[8][8];
        this.turns = 1;         
        this.info = 0;
        this.player = new Menu();

    }
    
    /** 
     * käynnistää pelin, luo uuden shakkilaudan ja kirjaa ylös mustien ja
     * valkoisten nappuloiden sijannit omiin arraynsa.
     */    
    public void run () {
        this.info = 0;
        this.turns = 1;
        this.board.newBoard();
        this.board.addPieces();
    }
 
     /** 
     * kopio pelilaudan GUIta varten.
     */     
    public void copyBoard() {
        this.cb = board.getBoard();
    }
    
     /** 
     * palauttaa pelilaudan, käytettään GUIsta.
     */     
    public int[][] getBoard() {
        return cb;
    }  
    
    
    /** 
     * Mustan vuoro.
     * 
     * @param sx siirettävän nappulan x - alkukoordinaatti.
     * @param sy siirettävän nappulan y - alkukoordinaatti.
     * @param ex siirettävän nappulan x - loppukoordinaatti.
     * @param ey siirettävän nappulan y - loppukoordinaatti.
     */     
    public void blackTurn(int sx, int sy, int ex, int ey) { 
        int piece = board.getPiece(sx, sy);        
        board.blackTurn(sx, sy, ex, ey);
        if (board.getMoveB()) { 
            setInfo(0);
            turns++;
        if (canAttackKing(board.getBoard(), piece, ex, ey)) {
            setInfo(1);
            cm.addSquares();
            if (cm.canKingMove() && !cm.canTakeDownAttacker(ex, ey)) {
                setInfo(3);
            }
        }            
        }        
        if (board.getWhite(12) == 99) {
            setInfo(3);
        }         
    }
    
    /** 
     * Valkoisen vuoro.
     * 
     * @param sx siirettävän nappulan x - alkukoordinaatti.
     * @param sy siirettävän nappulan y - alkukoordinaatti.
     * @param ex siirettävän nappulan x - loppukoordinaatti.
     * @param ey siirettävän nappulan y - loppukoordinaatti.
     */ 
    public void whiteTurn(int sx, int sy, int ex, int ey) {  
        int piece = board.getBoard()[sy][sx];
        board.whiteTurn(sx, sy, ex, ey);  
        if (board.getMoveW()) {
            setInfo(0);            
            turns++;
        if (canAttackKing(board.getBoard(), piece, ex, ey)) {
            setInfo(2);
            cm.addSquares();
            if (cm.canKingMove() && !cm.canTakeDownAttacker(ex, ey)) {
                setInfo(4);
            }            
        }            
        }         
        if (board.getBlack(4) == 99) {
            setInfo(4);
        }          
    } 
    /**
     * Tarkistaa voiko kyseinen puoli shakittaa vastapuolen kuningasta.
     * 
     * @param board tämän hetken shakki lauta.
     * @param piece siirtyneen nappulan numero.
     * @param x hyökkävän nappulan x - koordinaatti.
     * @param y hyökkävän nappulan y - koordinaatti.
     * @return palauttaa arvoksi true jos kuningas on hyökkäyksen kohteena.
     */     
    public boolean canAttackKing(int[][] board, int piece, int x, int y) {
        if (cm.canAttackKing(board, piece, x, y)) {
            return true;
        }
        return false;
    }
    
    public int getTurn() {
        return this.turns;
    }

     /** 
     * Asetetaan infolle arvo, infoa luetaan GUIsta, jos aika riittää katson voinko
     * todeuttaa tämän enumilla.
     */     
    public void setInfo(int info) {
        this.info = info;
    } 
     /** 
     * Palauttaa GUIlle infon arvon.
     */     
    public int getInfo() {
        return this.info;
    }
    
    public void saveGame() throws IOException {
        player.save(board.getBoard(), turns, info);
    }
    
    public void loadGame() throws FileNotFoundException {
        int [][] cb = player.load();
        board.setBoard(cb);
        setInfo(player.loadInfo());
        this.turns = player.loadTurns();
        this.board.addPieces();        
    }
       
}
