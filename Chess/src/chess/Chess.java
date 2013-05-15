
package chess;

//päälogiikka luokka
public class Chess {
    Chessboard board;
    
    public Chess() { 
        this.board = new Chessboard();
        
    }
    
    // käynnistää pelin
    public void run () {
        board.addPieces();
        board.turn();
    }

}
