
package Chess;

import chess.domain.Player;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class PlayerTest {
    Player player;
    
    public PlayerTest() {
        player = new Player();
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
    public void giveUp() {
        assertEquals(player.giveUp(2), "White wins!");   
        assertEquals(player.giveUp(1), "Black wins!");          
    }    

}
