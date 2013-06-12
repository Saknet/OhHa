
package Chess;

import chess.domain.CheckMate;
import chess.domain.Moves;
import chess.game.Chess;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class CheckMateTest {
    private int [][] board; 
    private int [][] board2; 
    private Chess chess;
    private CheckMate cm;
    private Moves moves;
    private int [] whites;
    private int [] blacks;      
    
    public CheckMateTest() {
        this.board = new int[][] {{0,0,8,10,0,0,6,4},
                                  {2,2,2,2,2,2,2,2},
                                  {0,0,0,0,0,8,0,0},
                                  {9,0,0,12,0,0,0,3},
                                  {4,0,0,11,1,0,0,0},
                                  {0,5,0,0,0,0,0,5},
                                  {1,1,1,1,6,1,1,1},
                                  {3,0,7,0,0,7,0,0}};  
              
        this.cm = new CheckMate();
        this.chess = new Chess();
        this.moves = new chess.domain.Moves();
        this.whites = new int[16];
        this.blacks = new int[16];          
    }
    
    @BeforeClass
    public static void setUpClass() {        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        cm.addPieces(board);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void canAttacBlackKing() {
        
        assertEquals(chess.canAttackKing(board, 9, 0, 3), true);   
        assertEquals(chess.canAttackKing(board, 3, 7, 3), true);  
        assertEquals(chess.canAttackKing(board, 1, 2, 6), false); 
        assertEquals(chess.canAttackKing(board, 5, 1, 5), false);                       
       
        
    }
    
    @Test
    public void canAttacWhiteKing() {
        
        assertEquals(chess.canAttackKing(board, 4, 0, 4), true);  
        assertEquals(chess.canAttackKing(board, 8, 2, 5), true); 
        assertEquals(chess.canAttackKing(board, 6, 4, 6), true);
        assertEquals(chess.canAttackKing(board, -5, 4, 6), false);          
    }   
    
    @Test
    public void boardOK() {
        assertEquals(board[3][3], 12);
        assertEquals(board[4][3], 11);    
        assertEquals(board[6][4], 6);         
    }
    
    @Test
    public void KingLocation() {
        cm.findKing(board, 3);
        assertEquals(cm.getX(), 3);
        assertEquals(cm.getY(), 3);
        cm.findKing(board, 10); 
        assertEquals(cm.getX(), 3);
        assertEquals(cm.getY(), 4);        
    }
    
    @Test
    public void PiecesLocations() {
        assertEquals(cm.getBlack(0), 20);
        assertEquals(cm.getBlack(15), 46);   
        assertEquals(cm.getBlack(8), 41);
        assertEquals(cm.getBlack(11), 71);    
        assertEquals(cm.getWhite(6), 6);
        assertEquals(cm.getWhite(12), 76);   
        assertEquals(cm.getWhite(4), 15);
        assertEquals(cm.getWhite(1), 73);          
    }
    
    
}
