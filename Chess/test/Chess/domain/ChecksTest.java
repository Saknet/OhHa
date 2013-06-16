
package Chess.domain;

import chess.domain.Checks;
import chess.game.Chessboard;
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
    private Chessboard cb;
    
    public ChecksTest() {
        this.checks = new Checks();
        this.board = new int [8][8];
        this.cb = new Chessboard();
                        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        cb.newBoard();
        this.board = cb.getBoard();
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
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void emptyWhiteTest() {
        assertEquals(checks.empty(whites, 7, 7), false);
        assertEquals(checks.empty(whites, 3, 2), true);
        assertEquals(checks.empty(whites, 5, 1), true);  
        assertEquals(checks.empty(whites, 0, 3), true);    
        assertEquals(checks.empty(whites, 5, 6), false);          
    }
    
    @Test
    public void emptyBlackTest() {
        assertEquals(checks.empty(blacks, 7, 7), true);
        assertEquals(checks.empty(blacks, 3, 2), true);
        assertEquals(checks.empty(blacks, 5, 1), false);  
        assertEquals(checks.empty(blacks, 0, 3), true);    
        assertEquals(checks.empty(blacks, 5, 6), true);          
    }    
    
    @Test
    public void onBoardTest() {
        assertEquals(checks.onBoard(0, 0), true);
        assertEquals(checks.onBoard(7, 9), false);        
        assertEquals(checks.onBoard(-1, 9), false);    
        assertEquals(checks.onBoard(5, 7), true); 
        assertEquals(checks.onBoard(3, -9), false);         
    }
    
    // jotain kusee seuraavissa testeissä, ei pitäisi mennä läpi mutta silti menee...
    @Test
    public void rookCheckVerticalTrue() {
        assertEquals(checks.rookCheckHorizontal(this.board, 0, 5, 0, 7), true);       
    }
    
    @Test
    public void rookCheckHorizontalTrue() {
        assertEquals(checks.rookCheckHorizontal(this.board, 4, 5, 4, 7), true);       
    }  
    
    @Test
    public void bishopCheckNWTrue() {
        assertEquals(checks.bishopCheckNW(this.board, 4, 5, 2, 3), true);       
    }
    
    @Test
    public void bishopCheckNEFalse() {
        assertEquals(checks.bishopCheckNE(this.board, 4, 5, 4, 7), false);       
    } 
    
    @Test
    public void bishopCheckSWFalse() {
        assertEquals(checks.bishopCheckSW(this.board, 4, 5, 4, 7), false);       
    }   

    @Test
    public void bishopCheckSEFalse() {    
        assertEquals(checks.bishopCheckSE(this.board, 4, 5, 4, 9), false);       
    }     

}
