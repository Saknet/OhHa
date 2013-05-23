
package chess;

//kontrolloiva luokka

import java.util.Scanner;

public class Chess {
    private Chessboard board;
    private int turns;  
    private Scanner reader; 
    private Player player;
    private Menu menu;
    
    public Chess() { 
        this.board = new Chessboard();
        this.turns = 1; 
        this.reader = new Scanner(System.in);  
        this.player = new Player();
        this.menu = new Menu();
    }
    
    // käynnistää pelin
    public void run () {
        board.addPieces();
        turn();
    }
    
        
    //aloittaa vuorot
    public void turn() {
        while(turns < Integer.MAX_VALUE) {  
            board.printBoard();
            if (turns % 2 == 0) {
                turns++;
                blackTurn();           
            } else {
                turns++;
                whiteTurn();
            }
        }
    }
        //mustan vuoro
    public void blackTurn() {
        System.out.println("Mustan vuoro:");
        System.out.println("Nappulan alku x-kordinaatti");  //sika ruma JButtom juttu sitten myöhemmin pelilaudan viereen kun teen grafiikat) 
        int sx = Integer.parseInt(reader.nextLine());
        System.out.println("Nappulan alku y-kordinaatti");
        int sy = Integer.parseInt(reader.nextLine());       
        System.out.println("Nappulan loppu x-kordinaatti");        
        int ex = Integer.parseInt(reader.nextLine());
        System.out.println("Nappulan loppu y-kordinaatti");        
        int ey = Integer.parseInt(reader.nextLine());
        board.blackTurn(sx, sy, ex, ey);
    }
    //valkoisen vuoro
    public void whiteTurn() {   
        System.out.println("Valkoisen vuoro:");
        System.out.println("Nappulan alku x-kordinaatti");  //sika ruma JButtom juttu sitten myöhemmin pelilaudan viereen kun teen grafiikat) 
        int sx = Integer.parseInt(reader.nextLine());
        System.out.println("Nappulan alku y-kordinaatti");
        int sy = Integer.parseInt(reader.nextLine());  
        System.out.println("Nappulan loppu x-kordinaatti");
        int ex = Integer.parseInt(reader.nextLine());
        System.out.println("Nappulan loppu y-kordinaatti");        
        int ey = Integer.parseInt(reader.nextLine()); 
        board.whiteTurn(sx, sy, ex, ey);
    }

}
