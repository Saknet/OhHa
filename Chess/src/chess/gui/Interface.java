
package chess.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

/** 
 * graafinen käyttöliittymä, ei toimi mikään, kesken pahasti
 * ainostaan exit nappi toimii
 */ 

public class Interface  {
    private JFrame frame;
    private Paint paint;      
    private JButton start;
    private JButton exit;
    private JButton giveUp;
    private modifyComponent mC;


    public void run() {
        frame = new JFrame("Chess"); 
        frame.setPreferredSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
        createComponents(frame.getContentPane());  
        frame.pack();
        frame.setVisible(true);        

    }
    
    /** 
     * teen oman luokka nappien yms muokkaukseen seuravaan deadlineen..
     */     
    private void createComponents(Container container) {
        this.paint = new Paint(); 
        this.mC = new modifyComponent();
        
        start = new JButton("Start new game"); 
        mC.modifyJButton(start, 50, 50, 150, 50, 12, container);
        
        giveUp = new JButton("Give up");
        mC.modifyJButton(giveUp, 50, 150, 150, 50, 12, container); 
        
        exit = new JButton("Exit");        
        mC.modifyJButton(exit, 50, 250, 150, 50, 12, container);                
        exit.addActionListener(new Actions());        
        
        JLabel startx = new JLabel("start X: ");
        mC.modifyJLabel(startx, 25, 350, 70, 50, 12, container);
        
        JTextField startxField = new JTextField();
        mC.modifyJTextField(startxField, 100, 350, 50, 40, 12, container);        
        
        JLabel starty = new JLabel("start Y: ");
        mC.modifyJLabel(starty, 25, 400, 70, 50, 12, container);        
        
        JTextField startyField = new JTextField();
        mC.modifyJTextField(startyField, 100, 400, 50, 40, 12, container);            
        
        JLabel endx = new JLabel("end X: "); 
        mC.modifyJLabel(endx, 175, 350, 70, 50, 12, container);        
        
        JTextField endxField = new JTextField();
        mC.modifyJTextField(endxField, 250, 350, 50, 40, 12, container);            
        
        JLabel endy = new JLabel("end Y: ");
        mC.modifyJLabel(endy, 175, 400, 70, 50, 12, container);        
        
        
        JTextField endyField = new JTextField(); 
        mC.modifyJTextField(endyField, 250, 400, 50, 40, 12, container);          
        
        JButton moves = new JButton("Move piece");  
        mC.modifyJButton(moves, 200, 450, 100, 50, 12, container);                                  

        container.add(paint);         
            
    }
    
}
