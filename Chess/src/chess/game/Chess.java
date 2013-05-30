
package chess.game;

import chess.domain.CheckMate;
import chess.Menu;
import chess.domain.Player;
import java.util.Scanner;

/** 
 * kontrolloiva luokka
 */ 
public class Chess {
    private Chessboard board;
    private int turns;  
    private Scanner reader; 
    private Player player;
    private Menu menu;
    private CheckMate cm;

    
    
    public Chess() { 
        this.board = new Chessboard();
        this.turns = 1; 
        this.reader = new Scanner(System.in);  
        this.player = new Player();
        this.menu = new Menu();
        this.cm = new CheckMate();

    }
    
    /** 
     * käynnistää pelin
     */    
    public void run () {
        board.addPieces();
        turn();
    }
    
    /** 
     * pyörittää peliä, tällä hetkellä siihen asti kunnes jompikumpi kuningas on syöty ja tekstipohjaisena
     * pariton vuoro on valkoisen vuoro ja parillinen mustan
     * jos vuoro epäonnistuu virheellisen syötteen takia pelaaja saa syöttää uudestaan arvot
     * jos kuningas on hyökkäyksen kohteena peli ilmoittaa siitä
     */     
    public void turn() {    
        while(turns < Integer.MAX_VALUE) { 
            board.printBoard();          
        
            if (turns % 2 == 0) {
                if (board.getBlack(4) == 99) {
                    player.WhiteWins();
                    break;
                }
                blackTurn();
                if (board.getMoveB() == true) {                   
                    turns++;
                }                
            } else { 
                if (board.getWhite(12) == 99) {
                    player.BlackWins();
                    break;
                }                
                whiteTurn();             
                if (board.getMoveW() == true) {                   
                    turns++;
            }                
            }           
        }
    }
    
    /** 
     * mustan vuoro, tekstipohjaisena tällä hetkellä..
     */     
    public void blackTurn() {
        System.out.println("Mustan vuoro:");
        System.out.println("Nappulan alku x-kordinaatti");  //sika ruma JButton juttu sitten myöhemmin pelilaudan viereen kun teen grafiikat 
        int sx = Integer.parseInt(reader.nextLine());
        System.out.println("Nappulan alku y-kordinaatti");
        int sy = Integer.parseInt(reader.nextLine());       
        System.out.println("Nappulan loppu x-kordinaatti");        
        int ex = Integer.parseInt(reader.nextLine());
        System.out.println("Nappulan loppu y-kordinaatti");        
        int ey = Integer.parseInt(reader.nextLine());
        board.blackTurn(sx, sy, ex, ey);
        if (canAttackKing(board.getBoard(), board.getPiece(sx, sy), ex, ey) == true) {
            System.out.println("White king under attack");
        }
    }
    
    /** 
     * valkoisen vuoro, tekstipohjaisena tällä hetkellä..
     */ 
    public void whiteTurn() {   
        System.out.println("Valkoisen vuoro:");
        System.out.println("Nappulan alku x-kordinaatti");  //sika ruma JButton juttu sitten myöhemmin pelilaudan viereen kun teen grafiikat 
        int sx = Integer.parseInt(reader.nextLine());
        System.out.println("Nappulan alku y-kordinaatti");
        int sy = Integer.parseInt(reader.nextLine());  
        System.out.println("Nappulan loppu x-kordinaatti");
        int ex = Integer.parseInt(reader.nextLine());
        System.out.println("Nappulan loppu y-kordinaatti");        
        int ey = Integer.parseInt(reader.nextLine()); 
        board.whiteTurn(sx, sy, ex, ey);        
        if (canAttackKing(board.getBoard(), board.getPiece(sx, sy), ex, ey) == true) {
            System.out.println("Black king under attack");
        }
    } 
    /**
     * tarkistaa voiko kyseinen puoli shakittaa vastapuolen kuningasta
     * @param board tämän hetken shakki lauta
     * @param piece siirtyneen nappulan numero
     * @param x hyökkävän nappulan x - koordinaatti
     * @param y hyökkävän nappulan y - koordinaatti
     * @return palauttaa arvoksi true jos kuningas on hyökkäyksen kohteena
     */     
    public boolean canAttackKing(int[][] board, int piece, int x, int y) {
        if (cm.canAttackKing(board, piece, x, y) == true) {
            return true;
        }
        return false;
    }

}
