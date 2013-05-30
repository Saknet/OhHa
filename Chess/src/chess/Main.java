
package chess;

import chess.game.Chess;
import chess.gui.Interface;


public class Main {
    // ei toimi graafinen käyttis vielä, tosi basic(siirrot ainoat komennot) tekstipohjaisella voi pelailla
    public static void main(String[] args) {
        Interface gui = new Interface();
        gui.run();
        Chess chess = new Chess();
        chess.run();

    }
    
}
