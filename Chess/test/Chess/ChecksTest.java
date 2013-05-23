
package Chess;

import chess.Checks;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class ChecksTest {
    private Checks checks;
    private int [] whites;
    private int [] blacks;
    private int [][] board;  
    
    public ChecksTest() {
        this.checks = new Checks();
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
    public void emptyTest() {
        assertEquals(checks.empty(whites, 7, 7), false);
        assertEquals(checks.empty(whites, 3, 2), true);
        assertEquals(checks.empty(whites, 5, 1), true);  
        assertEquals(checks.empty(whites, 0, 3), true);    
        assertEquals(checks.empty(whites, 5, 6), false);          
    }
    @Test
    public void onBoardTest() {
        assertEquals(checks.onBoard(0, 0), true);
        assertEquals(checks.onBoard(7, 9), false);        
        assertEquals(checks.onBoard(-1, 9), false);    
        assertEquals(checks.onBoard(5, 7), true); 
        assertEquals(checks.onBoard(3, -9), false);         
    }

}
