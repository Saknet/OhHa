
package chess.gui;

import chess.game.Chess;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * Graafisen käyttöliitymän pääluokka.
 * Grafiikat bugailee, kun ikkunaa refresh tulee  näkyviin napit taas,
 * monet asiat eivät toimi vielä, siirrot kuitenkin toimivat eli peliä voi pelata graafisesti.
 */

public class Gui implements Runnable {
    private JFrame frame;
    private DrawingPanel paint;
    private JButton start;
    private JButton exit;
    private JButton giveUp;
    private ModifyComponent mC;
    private Chess chess;
    private JTextField startxField;
    private JTextField startyField;
    private JTextField endxField;
    private JTextField endyField;
    private JLabel startx;
    private JLabel starty;
    private JLabel endx;
    private JLabel endy;
    private JLabel turns;
    private JButton moves;
    private JLabel info;
    private int sx;
    private int sy;
    private int ex;
    private int ey;

    /**
     * Luokan konstruktori. Luodaan Chess olio joka tulee pyörittämään pelilogiikkaa.
     */
    public Gui () {
        chess = new Chess();
    }

    /**
     * Tämä metodi käynnistää jäyttöliittymän.
     */
    @Override
    public void run() {
        frame = new JFrame("Chess");
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());       
        frame.pack();
        frame.setVisible(true);

    }

    /**
     * Tämä metodi luo pelin komponentit.
     */
    private void createComponents(Container container) {
        this.paint = new DrawingPanel(chess);
        this.mC = new ModifyComponent();

        start = new JButton("Start new game");
        mC.modifyJButton(start, 50, 50, 150, 50, 12, container);
        start.addActionListener(new Actions(this));

        giveUp = new JButton("Give up");
        mC.modifyJButton(giveUp, 50, 150, 150, 50, 12, container);
        giveUp.addActionListener(new Actions(this));

        exit = new JButton("Exit");
        mC.modifyJButton(exit, 50, 250, 150, 50, 12, container);
        exit.addActionListener(new Actions(this));

        startx = new JLabel("start X: ");
        mC.modifyJLabel(startx, 25, 350, 70, 50, 12, container);

        startxField = new JTextField("");
        mC.modifyJTextField(startxField, 100, 350, 50, 40, 12, container);

        starty = new JLabel("start Y: ");
        mC.modifyJLabel(starty, 25, 400, 70, 50, 12, container);

        startyField = new JTextField("");
        mC.modifyJTextField(startyField, 100, 400, 50, 40, 12, container);

        endx = new JLabel("end X: ");
        mC.modifyJLabel(endx, 175, 350, 70, 50, 12, container);

        endxField = new JTextField("");
        mC.modifyJTextField(endxField, 250, 350, 50, 40, 12, container);

        endy = new JLabel("end Y: ");
        mC.modifyJLabel(endy, 175, 400, 70, 50, 12, container);


        endyField = new JTextField("");
        mC.modifyJTextField(endyField, 250, 400, 50, 40, 12, container);

        moves = new JButton("Move piece");
        mC.modifyJButton(moves, 120, 470, 140, 50, 12, container);


        turns = new JLabel("White turn ");
        mC.modifyJLabel(turns, 375, 10, 100, 100, 14, container);

        info = new JLabel("");
        mC.modifyJLabel(info, 500, 10, 200, 100, 14, container);

        container.add(paint);

    }

    /**
     * Tämä metodi on Move Piece nappulan käyttöä varten, valkoinen ja musta
     * käyttävät samaa nappulaa.
     */
    public void turns() {
        this.frame.repaint(); 
        update();        
        int turn = chess.getTurn();
        MovesListener listener = new MovesListener(this, startxField, startyField, endxField, endyField, turn);
        moves.addActionListener(listener);
    }

    /**
     * Tämä metodi aloittaa uuden pelin.
     */
    public void startGame() {
        chess.run();
        this.moves.setEnabled(true); 
        this.info.setText("New game");
        this.turns.setText("White turn");
        this.frame.repaint();
        turns();
    }

    /**
     * Tämä metodi lähettää logiikka luokalle viestin että valkoista pitäisi siirtää.
     */
    public void moveWhite() {
        chess.whiteTurn(sx, sy, ex, ey);
        turns();
    }

    /**
     * Tämä metodi lähettää logiikka luokalle viestin että mustaa pitäisi siirtää.
     */
    public void moveBlack() {
        chess.blackTurn(sx, sy, ex, ey);
        turns();
    }

    /**
     *
     * Tätä metodia käytettään siirtokoordinaattien luontia varten.
     *
     * @param x asettaa sx koordiaatin siirtoa varten.
     */
    public void setSX(int x) {
        this.sx = x;
    }

    /**
     * Tätä metodia käytettään siirtokoordinaattien luontia varten.
     *
     * @param y asettaa sy koordiaatin siirtoa varten.
     */
    public void setSY(int y) {
        this.sy = y;
    }

    /**
     * Tätä metodia käytettään siirtokoordinaattien luontia varten.
     *
     * @param x asettaa ex koordiaatin siirtoa varten.
     */
    public void setEX(int x) {
        this.ex = x;
    }

    /**
     * Tätä metodia käytettään siirtokoordinaattien luontia varten.
     *
     * @param y asettaa ey koordiaatin siirtoa varten.
     */
    public void setEY(int y) {
        this.ey = y;
    }

    /**
     * Tämä metodi luovuttaa pelin jos luovutusnappia painetaan.
     */
    public void endGame() {
        if (chess.getTurn() % 2 == 0) {
            chess.setInfo(4);
        } else {
            chess.setInfo(3);
        }
        this.frame.repaint();
        update();
        this.moves.setEnabled(false);      
    }

    public JFrame getFrame() {
        return frame;
    }
   
    /**
     * Tämä metodi päivittää nappuloiden tilanteen kun niitä painetaan.
     */    
    public void update() {        
        startxField.setText("");
        startyField.setText("");
        endxField.setText("");
        endyField.setText("");        
        if (chess.getTurn() % 2 == 0) {
            turns.setText("Black turn");
        } else {
            turns.setText("White turn");
        }
        if (chess.getInfo() == 0) {
            info.setText("");
        }
        if (chess.getInfo() == 1) {
            info.setText("White King under attack!");
        }
        if (chess.getInfo() == 2) {
            info.setText("Black King under attack!");
        }
        if (chess.getInfo() == 3) {
            info.setText("Black wins!");
            moves.setEnabled(false);
        }
        if (chess.getInfo() == 4) {
            info.setText("White wins!");
            moves.setEnabled(false);            
        }
        
    }    

}
