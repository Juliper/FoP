package h13;

import java.awt.Dimension;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;

/**
 * A Property Change Dialogue for changing Values
 *
 * @author Ruben Deisenroth
 */
public class PropertyChangeDialogue extends JDialog {
    /**
     * The Property JLabel to display the Property name
     */
    JLabel propertyJLabel = new JLabel("NaN");
    /**
     * The JSlider that controls the Value
     */
    JSlider valueControlJSlider = new JSlider();
    /**
     * The JTextField that accepts valid value Inputs
     */
    JTextField valueInputField = new JTextField("50");
    /**
     * The Confirmation Button
     */
    JButton okButton = new JButton("Ok");
    /**
     * The ComboBox for Enum-like Properties
     */
    JComboBox<String> optionsComboBox = new JComboBox<String>();

    /**
     * Creates a new {@link PropertyChangeDialogue}
     */
    public PropertyChangeDialogue() {
        setTitle("Change property");
        setMinimumSize(new Dimension(300, 300));
        setModal(true);
    }

    /**
     * Initializes the Dialog for a Number based property
     *
     * @param title        the Dialog Title
     * @param propertyName the Property Name
     * @param min          the minimum Value of the Property
     * @param max          the Maximum Value of the Property
     * @param current      the current Value of the Property
     * @param updateValue  a consumer that is executed every time the value changes
     */
    public void showNumberChangeDialog(
            String title,
            String propertyName,
            int min,
            int max,
            int current,
            IntConsumer updateValue) {
        // Frame Properties
        // TODO: H2.3
        // Add Listeners
        // TODO: H2.3
        // Set Dimension and Position
        // TODO: H2.3
        // Show Frame
        // TODO: H2.3
    }

    /**
     * Initializes the Dialog for an Enum-Like property
     *
     * @param title        the Dialog Title
     * @param propertyName the Property Name
     * @param current      the index currently selected Item
     * @param options      the Options for the Combo Box
     * @param updateValue  a consumer that is executed every time the value
     *                     changes
     */
    public void showEnumChangeDialogue(
            String title,
            String propertyName,
            int current,
            String[] options,
            Consumer<String> updateValue) {
        // Frame Properties
        // TODO: H2.3
        // Add Listeners
        // TODO: H2.3
        // Set Dimension and Position
        // TODO: H2.3
        // Show Frame
        // TODO: H2.3
    }
}
