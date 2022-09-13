package h13;

import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*ww  w  .  j a va  2  s.co  m*/
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Ruben Deisenroth
 */
public class TwoSimpleWindows {

    public static void main(String[] args) {

        FlatDarkLaf.setup();
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainFrame zeichenfenster = new MainFrame(new MyPanel());
                ControlFrame steuerungsfenster = new ControlFrame(zeichenfenster);
                zeichenfenster.init();
                steuerungsfenster.init();
            }
        });
    }
}
