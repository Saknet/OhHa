
package Chess;

import chess.Chessboard;
import chess.Movement;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class ChessboardTest {
    Chessboard board;
    Movement move;
    private int [] whites;
    private int [] blacks;
    private int [][] board2;    
   
    
    public ChessboardTest() {
        board = new Chessboard();
        move = new Movement();
        this.board2 = new int[][] {{4,6,8,10,12,8,6,4},
                                  {2,2,2,2,2,2,2,2},
                                  {0,0,0,0,0,0,0,0},
                                  {0,0,0,0,0,0,0,0},
                                  {0,0,0,0,0,0,0,0},
                                  {0,0,0,0,0,0,0,0},
                                  {1,1,1,1,1,1,1,1},
                                  {3,5,7,9,11,7,5,3}};   
        this.whites = new int[16];
        this.blacks = new int[16]; 
        int k = 0;
        int l = 0;
        for (int i = 0; i < this.board2.length; i++) {
            for (int j = 0; j < this.board2.length; j++) {
                if (this.board2[i][j] != 0) {
                    if (this.board2[i][j] % 2 == 0) {
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
         

    @BeforeClass
    public static void setUpClass() {
       
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void creationTest() {
        assertEquals(board.getPiece(0, 0), 4);
        assertEquals(board.getPiece(7, 6), 1);
        assertEquals(board.getPiece(5, 5), 0); 
        assertEquals(board.getPiece(6, 7), 5);
        assertEquals(board.getPiece(4, 0), 12);                
    }
    @Test
    public void movePieceTest() {
        board.movePiece(0, 2, 1);
        assertEquals(board.getPiece(0, 2), 1);
        board.movePiece(5, 5, 5);
        assertEquals(board.getPiece(5, 5), 5);
                
    }
    
    @Test
    public void editBlacksTest() {
        board.editBlacks(5, 5, 5);
        assertEquals(board.getBlack(5), 55);
        board.editBlacks(6, 2, 1);
        assertEquals(board.getBlack(1), 62);   
        board.editBlacks(0, 0, 0);
        assertEquals(board.getBlack(0), 0);   
        assertEquals(board.getBlack(8), 0);         
    }
    
    @Test
    public void editWhitessTest() {
        board.editWhites(1, 1, 1);
        assertEquals(board.getWhite(1), 11);
        board.editWhites(0, 7, 3);
        assertEquals(board.getWhite(3), 7);  
        board.editWhites(3, 0, 2);
        assertEquals(board.getWhite(2), 30);  
        assertEquals(board.getWhite(5), 0);        
        
    }    
    
    @Test
    public void whiteMoveTest() {
        assertEquals(move.moveWhiteKing(whites, 8, 8), false);
        assertEquals(move.moveWhiteKing(whites, 4, 4), true);  
        assertEquals(move.moveWhiteKing(whites, -4, 6), false);  
        assertEquals(move.moveWhiteKing(whites, 5, 7), false);  
    }
    
    @Test
    public void blackMoveTest() {
        assertEquals(move.moveBlackKing(blacks, 8, 8), false);
        assertEquals(move.moveBlackKing(blacks, 4, 4), true);  
        assertEquals(move.moveBlackKing(blacks, -4, 6), false);  
        assertEquals(move.moveBlackKing(blacks, 5, 7), true);         
        
    }
    
    @Test
    public void startLocationTest() {
        assertEquals(move.checkStart(whites, 3, 5), false); 
        assertEquals(move.checkStart(whites, 5, 6), true); 
        assertEquals(move.checkStart(blacks, 5, 6), false);  
        assertEquals(move.checkStart(blacks, 4, 1), true); 
    }
    
    @Test
    public void endlocationTest() {
        assertEquals(move.empty(whites, 5, 5), true);  
        assertEquals(move.empty(whites, 0, 0), true); 
        assertEquals(move.empty(whites, 7, 7), false);
        assertEquals(move.empty(blacks, 0, 0), false); 
        assertEquals(move.empty(blacks, 2, 6), true);         
        
    }

}
