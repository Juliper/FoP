package h13;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

/**
 * The Main Drawing Frame for H13 containing a {@link MyPanel}
 *
 * @author Ruben Deisenroth
 */
public class MainFrame extends JFrame {
    /**
     * The {@link MyPanel}-Object that draws the shapes
     */
    private final MyPanel panel;

    /**
     * Creates a new {@link MainFrame}
     */
    public MainFrame(MyPanel panel) {
        super("H13");
        this.panel = panel;
    }

    /**
     * Getter-Method for the {@link #panel}-Field
     *
     * @return the value of the {@link #panel}-Field
     */
    public MyPanel getPanel() {
        return panel;
    }

    /**
     * Initialize and Display the Frame
     */
    public void init() {
        // Frame Properties
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(300, 300));
        setLayout(new BorderLayout());


        // Add Components
        // TODO: H2.1
        add(new MyPanel());


        // Add Listeners
        // TODO: H2.1
        addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent event) {
                if(event.getKeyChar() == '+') {
                    System.out.println("Zoom " + panel.getZoom());
                    panel.setZoom(panel.getZoom() * 1.2);
                }

                if(event.getKeyChar() == '-') {
                    System.out.println("DeZoom " + panel.getZoom());
                    panel.setZoom(panel.getZoom() * 0.8);
                }
            }

            @Override
            public void keyReleased(KeyEvent event) {

            }

            @Override
            public void keyTyped(KeyEvent event) {

            }
        });
        // Set Dimension and Position
        // TODO: H2.1
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize().width , Toolkit.getDefaultToolkit().getScreenSize().height / 2);

        // Show Frame
        // TODO: H2.1
        setVisible(true);
    }
}
