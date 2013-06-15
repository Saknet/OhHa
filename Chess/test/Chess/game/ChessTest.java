
package Chess.game;

import chess.game.Chess;
import chess.game.Chessboard;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class ChessTest {
    Chess chess;
    Chessboard board;
    
    public ChessTest() {
        this.chess = new Chess();
        this.board = new Chessboard();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        board.newBoard();
        board.addPieces();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void BlackTurns() {
        board.blackTurn(6, 6, 6, 4);
        assertEquals(board.getMoveB(), false);
        board.blackTurn(1, 0, 0, 2);
        assertEquals(board.getMoveB(), true);         
    }
    
    @Test
    public void WhiteTurns() {
        board.whiteTurn(6, 6, 6, 4);
        assertEquals(board.getMoveW(), true);     
        board.whiteTurn(1, 0, 0, 2);
        assertEquals(board.getMoveW(), false);  
    }
    
    @Test
    public void getInfoStart() {
        assertEquals(chess.getInfo(), 0);
    }
    
    @Test
    public void setInfoKingDead() {
        chess.setInfo(4);
        assertEquals(chess.getInfo(), 4);
    }
    
       
}
