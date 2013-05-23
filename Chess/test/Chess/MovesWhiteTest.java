
package Chess;

import chess.MovesWhite;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class MovesWhiteTest {
    MovesWhite mWhite;
    private int [] whites;
    private int [] blacks;
    private int [][] board;     
    
    public MovesWhiteTest() {
        mWhite = new MovesWhite();
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
    public void moveWhiteKingTest() {
        assertEquals(mWhite.moveWhiteKing(whites, 0, 0, 0, 1), true); 
        assertEquals(mWhite.moveWhiteKing(whites, 4, 0, 4, -1), false); 
        assertEquals(mWhite.moveWhiteKing(whites, 8, 0, 5, 1), false); 
        assertEquals(mWhite.moveWhiteKing(whites, 4, 4, 4, 5), true); 
        assertEquals(mWhite.moveWhiteKing(whites, 4, 4, 5, 4), true);          
        
    } 
    
    @Test
    public void moveWhitePawnTest() {
        assertEquals(mWhite.moveWhitePawn(whites, blacks, 0, 6, 0, 4), true);
        assertEquals(mWhite.moveWhitePawn(whites, blacks, 2, 5, 2, 4), true);
        assertEquals(mWhite.moveWhitePawn(whites, blacks, 3, 2, 2, 1), true);
        assertEquals(mWhite.moveWhitePawn(whites, blacks, 1, 3, 1, 1), false); 
        assertEquals(mWhite.moveWhitePawn(whites, blacks, 4, 3, 3, 2), false);  
        assertEquals(mWhite.moveWhitePawn(whites, blacks, 5, 6, 5, 7), false);         
    }
    
    @Test
    public void moveWhiteKnightTest() {   
        assertEquals(mWhite.moveWhiteKnight(whites, 1, 7, 3, 6), false);
        assertEquals(mWhite.moveWhiteKnight(whites, 5, 6, 3, 7), false);
        assertEquals(mWhite.moveWhiteKnight(whites, 3, 2, 4, 0), true);
        assertEquals(mWhite.moveWhiteKnight(whites, 6, 7, 7, 5), true);  
        assertEquals(mWhite.moveWhiteKnight(whites, 0, 0, 0, 0), false);        
    } 
    
    @Test
    public void moveWhiteRookTest() {  
        assertEquals(mWhite.moveWhiteRook(board, whites, 7, 7, 0, 7), false);
        assertEquals(mWhite.moveWhiteRook(board, whites, 5, 4, 5, 0), false);
        assertEquals(mWhite.moveWhiteRook(board, whites, 0, 7, 5, 7), false);
        assertEquals(mWhite.moveWhiteRook(board, whites, 3, 2, 3, 1), true);  
        assertEquals(mWhite.moveWhiteRook(board, whites, 5, 4, 2, 4), true);  
        assertEquals(mWhite.moveWhiteRook(board, whites, 0, 0, 0, 1), true);        
    }  
    
    @Test
    public void moveWhiteBishopTest() {
        assertEquals(mWhite.moveWhiteBishop(board, whites, 7, 7, 0, 0), false);
        assertEquals(mWhite.moveWhiteBishop(board, whites, 4, 5, 6, 5), false);
        assertEquals(mWhite.moveWhiteBishop(board, whites, 2, 2, 5, 7), false);
        assertEquals(mWhite.moveWhiteBishop(board, whites, 3, 4, 4, 5), true);   
        assertEquals(mWhite.moveWhiteBishop(board, whites, 3, 4, 6, 1), true); 
        assertEquals(mWhite.moveWhiteBishop(board, whites, 3, 4, 0, 1), true);         
    }
    
    @Test
    public void moveWhiteQueenTest() {
        assertEquals(mWhite.moveWhiteQueen(board, whites, 0, 0, 7, 7), false);
        assertEquals(mWhite.moveWhiteQueen(board, whites, 0, 0, 7, 0), false);
        assertEquals(mWhite.moveWhiteQueen(board, whites, 0, 0, 0, 7), false);
        assertEquals(mWhite.moveWhiteQueen(board, whites, 3, 2, 5, 6), false); 
        assertEquals(mWhite.moveWhiteQueen(board, whites, 3, 2, 5, 2), true); 
        assertEquals(mWhite.moveWhiteQueen(board, whites, 3, 2, 5, 4), true);  
        assertEquals(mWhite.moveWhiteQueen(board, whites, 3, 2, 2, 1), true); 
        assertEquals(mWhite.moveWhiteQueen(board, whites, 3, 2, 3, 1), true);  
        assertEquals(mWhite.moveWhiteQueen(board, whites, 3, 2, 3, 5), true);        
    }                    
}
