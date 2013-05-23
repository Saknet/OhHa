
package Chess;

import chess.MovesBlack;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class MovesBlackTest {
    MovesBlack mBlack;
    private int [] whites;
    private int [] blacks;
    private int [][] board;     
    
    public MovesBlackTest() {
        mBlack = new MovesBlack();
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
    public void moveBlackKingTest() {
        assertEquals(mBlack.moveBlackKing(blacks, 0, 0, 0, 1), false); 
        assertEquals(mBlack.moveBlackKing(blacks, 4, 0, 4, -1), false); 
        assertEquals(mBlack.moveBlackKing(blacks, 5, 5, 6, 6), true); 
        assertEquals(mBlack.moveBlackKing(blacks, 10, 5, 0, 1), false); 
        assertEquals(mBlack.moveBlackKing(blacks, 7, 7, 6, 7), true);          
        
    } 
    
    @Test
    public void moveBlackPawnTest() {
        assertEquals(mBlack.moveBlackPawn(blacks, whites, 4, 4, 4, 5), true);
        assertEquals(mBlack.moveBlackPawn(blacks, whites, 0, 1, 0, 3), true);
        assertEquals(mBlack.moveBlackPawn(blacks, whites, 5, 5, 4, 6), true);
        assertEquals(mBlack.moveBlackPawn(blacks, whites, 0, 0, -1, -1), false); 
        assertEquals(mBlack.moveBlackPawn(blacks, whites, 3, 3, 3, 5), false);
        assertEquals(mBlack.moveBlackPawn(blacks, whites, 3, 3, 3, 2), false);         
    }
    
    @Test
    public void moveBlackKnightTest() {   
        assertEquals(mBlack.moveBlackKnight(blacks, 0, 0, 9, 9), false);
        assertEquals(mBlack.moveBlackKnight(blacks, 1, 0, 3, 1), false);
        assertEquals(mBlack.moveBlackKnight(blacks, 9, 3, 8, 1), false);
        assertEquals(mBlack.moveBlackKnight(blacks, 5, 5, 7, 4), true);  
        assertEquals(mBlack.moveBlackKnight(blacks, 6, 6, 7, 4), true);        
    } 
    
    @Test
    public void moveBlackRookTest() {  
        assertEquals(mBlack.moveBlackRook(board, blacks, 0, 0, 0, 2), false);
        assertEquals(mBlack.moveBlackRook(board, blacks, 0, 0, 5, 0), false);
        assertEquals(mBlack.moveBlackRook(board, blacks, 5, 5, 6, 6), false);
        assertEquals(mBlack.moveBlackRook(board, blacks, 3, 3, 6, 3), true);  
        assertEquals(mBlack.moveBlackRook(board, blacks, 3, 3, 3, 6), true);          
    }  
    
    @Test
    public void moveBlackBishopTest() {
        assertEquals(mBlack.moveBlackBishop(board, blacks, 0, 0, 1, 1), false);
        assertEquals(mBlack.moveBlackBishop(board, blacks, 3, 3, 5, 5), true);
        assertEquals(mBlack.moveBlackBishop(board, blacks, 3, 3, 7, 7), false);
        assertEquals(mBlack.moveBlackBishop(board, blacks, 3, 3, 2, 2), true);   
        assertEquals(mBlack.moveBlackBishop(board, blacks, 3, 3, 0, 6), true);         
    }
    
    @Test
    public void moveBlackQueenTest() {
        assertEquals(mBlack.moveBlackQueen(board, blacks, 2, 0, 6, 0), false);
        assertEquals(mBlack.moveBlackQueen(board, blacks, 2, 0, 2, 6), false);
        assertEquals(mBlack.moveBlackQueen(board, blacks, 2, 0, 1, 1), false);
        assertEquals(mBlack.moveBlackQueen(board, blacks, 3, 3, 3, 6), true); 
        assertEquals(mBlack.moveBlackQueen(board, blacks, 3, 3, 6, 6), true);  
        assertEquals(mBlack.moveBlackQueen(board, blacks, 4, 4, 2, 2), true);
        assertEquals(mBlack.moveBlackQueen(board, blacks, 4, 4, 2, 6), true);  
        assertEquals(mBlack.moveBlackQueen(board, blacks, 4, 4, 6, 2), true);         
        assertEquals(mBlack.moveBlackQueen(board, blacks, 4, 4, 0, 0), false);         
    }

}
