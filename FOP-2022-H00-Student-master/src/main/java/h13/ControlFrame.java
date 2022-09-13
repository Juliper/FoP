package h13;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A Control Frame that contains all the necessary Control Elements for the Main
 * Frame
 *
 * @author Ruben Deisenroth
 */
public class ControlFrame extends JFrame {
    /**
     * The Main Frame to control
     */
    @SuppressWarnings("unused")
    private MainFrame mf;
    /**
     * A button that calls {@link MyPanel#addGreenEllipse()} when clicked
     */
    @SuppressWarnings("unused")
    private JButton addEllipseButton = new JButton("Add ellipse");
    /**
     * A button that calls {@link MyPanel#addYellowRectangle()} when clicked
     */
    @SuppressWarnings("unused")
    private JButton addRectangleButton = new JButton("Add rectangle");
    /**
     * A button that calls {@link MyPanel#addBlueString()} when clicked
     *
     */
    @SuppressWarnings("unused")
    private JButton addStringButton = new JButton("Add string");
    /**
     * A button that calls {@link MyPanel#removeGreenEllipse()} when clicked
     */
    @SuppressWarnings("unused")
    private JButton removeEllipseButton = new JButton("Remove ellipse");
    /**
     * A button that calls {@link MyPanel#removeYellowRectangle()} when clicked
     */
    @SuppressWarnings("unused")
    private JButton removeRectangleButton = new JButton("Remove rectangle");
    /**
     * A button that calls {@link MyPanel#removeBlueString()} when clicked
     */
    @SuppressWarnings("unused")
    private JButton removeStringButton = new JButton("Remove string");
    /**
     * A button that opens a {@link PropertyChangeDialogue} that controls the
     * transparency via {@link MyPanel#setAlpha(float)} when clicked
     */
    @SuppressWarnings("unused")
    private JButton changeAlphaButton = new JButton("Change alpha");
    /**
     * A button that opens a {@link PropertyChangeDialogue} that controls the
     * saturation via {@link MyPanel#setSaturation(float)} when clicked
     */
    @SuppressWarnings("unused")
    private JButton changeSaturationButton = new JButton("Change saturation");
    /**
     * A button that opens a {@link PropertyChangeDialogue} that controls the
     * saturation via {@link MyPanel#setBorderWidth(int)} when clicked
     */
    @SuppressWarnings("unused")
    private JButton changeBorderWidthButton = new JButton("Change border width");
    /**
     * A button that opens a {@link PropertyChangeDialogue} that controls the
     * font via {@link MyPanel#setFont(java.awt.Font)} when clicked
     */
    @SuppressWarnings("unused")
    private JButton changeFontButton = new JButton("Change font");
    /**
     * A button that opens a {@link PropertyChangeDialogue} that controls the
     * saturation via {@link MyPanel#setZoom(double)} when clicked
     */
    @SuppressWarnings("unused")
    private JButton changeZoomButton = new JButton("Change zoom");
    /**
     * A button that opens a {@link PropertyChangeDialogue} that exits the Program when clicked
     */
    @SuppressWarnings("unused")
    private JButton exitButton = new JButton("Exit");
    /**
     * The {@link PropertyChangeDialogue} that pops up when a Property needs to be
     * changed and updates the property in real Time
     */
    @SuppressWarnings("unused")
    private final PropertyChangeDialogue pcd = new PropertyChangeDialogue();

    /**
     * Creates a new {@link ControlFrame}-Instance
     *
     * @param mf The Main Drawing Frame
     */
    public ControlFrame(MainFrame mf) {
        super("Steuerungsfenster");
        this.mf = mf;
    }

    /**
     * Initializes and shows the Frame
     */
    public void init() {
        // Frame Properties
        // TODO: H2.2

        this.setLayout(new GridLayout(4,3));
        this.add(addEllipseButton);
        this.add(addRectangleButton);
        this.add(addStringButton);
        this.add(removeEllipseButton);
        this.add(removeRectangleButton);
        this.add(removeStringButton);
        this.add(changeSaturationButton);
        this.add(changeAlphaButton);
        this.add(changeBorderWidthButton);
        this.add(changeFontButton);
        this.add(changeZoomButton);
        this.add(exitButton);


        // Add Listeners
        // TODO: H2.2
        MyPanel p = this.mf.getPanel();

        addEllipseButton.addActionListener(e -> p.addGreenEllipse());
        addRectangleButton.addActionListener(e -> p.addYellowRectangle());
        addStringButton.addActionListener(e -> p.addBlueString());
        removeEllipseButton.addActionListener(e -> p.removeGreenEllipse());
        removeRectangleButton.addActionListener(e -> p.removeYellowRectangle());
        removeStringButton.addActionListener(e -> p.removeBlueString());

        exitButton.addActionListener(e -> System.exit(0));
        // Set Dimension and Position
        // TODO: H2.2
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize().width / 2,Toolkit.getDefaultToolkit().getScreenSize().height / 2);
        this.setLocation(0,Toolkit.getDefaultToolkit().getScreenSize().height / 2);

        // Show Frame
        // TODO: H2.2
        setVisible(true);
    }
}
