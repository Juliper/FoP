package h13;

import com.formdev.flatlaf.util.Graphics2DProxy;

import javax.swing.plaf.basic.BasicOptionPaneUI;
import javax.swing.plaf.basic.BasicTextUI;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A JPanel to display the following three shapes:
 * <ul>
 * <li>Green ellipse</li>
 * <li>Yellow triangle</li>
 * <li>Blue string</li>
 * </ul>
 *
 * @author Ruben Deisenroth
 */
public class MyPanel extends javax.swing.JPanel {

    // **************** //
    // -- Attributes -- //
    // **************** //

    /**
     * The possible Figures to display
     */
    private enum Figure {
        /**
         * A green ellipse
         */
        GREEN_ELLIPSE,
        /**
         * A yellow rectangle
         */
        YELLOW_RECTANGLE,
        /**
         * A blue string
         */
        BLUE_STRING,
    }

    /**
     * The figures to display ()
     */
    private List<Figure> figuresToDisplay = new ArrayList<>(List.of(
            Figure.BLUE_STRING,
            Figure.YELLOW_RECTANGLE,
            Figure.GREEN_ELLIPSE));

    // TODO: H1.1 - Default Values
    /**
     * The current Transparency of the inner color of the shapes
     * <br>
     * </br>
     * - 0f => completely transparent, 1f => opaque
     */
    private float alpha = 0.5f;

    /**
     * The Saturation of the border color of the shapes
     */
    private float saturation = 1f;

    /**
     * The Zoom of the Shapes
     */
    private double zoom = 1d;

    /**
     * The Text of the blue string
     */
    private String text = "FOP-2022";

    /**
     * The Font for the blue string
     */
    private Font font = new Font("Default", Font.PLAIN, 16);

    /**
     * The Border width of the green ellipse and the yellow rectangle
     */
    private int borderWidth = 20;

    // ****************** //
    // -- Constructors -- //
    // ****************** //

    /**
     * Creates a new {@link MyPanel}
     */
    public MyPanel() {
        super();
        setOpaque(true);
        setBackground(Color.BLACK);
    }

    // -- Getters and Setters -- //

    /**
     * Getter-Method for the {@link #alpha}-Field
     *
     * @return the value of the {@link #alpha}-Field
     */
    public float getAlpha() {
        return this.alpha;
    }

    /**
     * Setter-Method for the {@link #alpha}-Field.
     * <br>
     * </br>
     * Only values in [0d,1d] are permitted.
     *
     * @param alpha the new Value of the {@link #alpha}-Field
     */
    public void setAlpha(float alpha) throws IllegalArgumentException{
        // TODO: H1.1
        if(!(alpha >= 0 && alpha <= 1)) {
            throw new IllegalArgumentException();
        }
        this.alpha = alpha;
        this.repaint();
    }

    /**
     * Getter-Method for the {@link #saturation}-Field
     *
     * @return the value of the {@link #saturation}-Field
     */
    public float getSaturation() {
        return this.saturation;
    }

    /**
     * Setter-Method for the {@link #saturation}-Field.
     * <br>
     * </br>
     * Only values in [0d,1d] are permitted.
     *
     * @param saturation the new Value of the {@link #saturation}-Field
     */
    public void setSaturation(float saturation) throws IllegalArgumentException{
        // TODO: H1.1
        if(!(saturation >= 0 && saturation <= 1)) {
            throw new IllegalArgumentException();
        }
        this.saturation = saturation;
        this.repaint();
    }

    /**
     * Getter-Method for the {@link #zoom}-Field
     *
     * @return the value of the {@link #zoom}-Field
     */
    public double getZoom() {
        return this.zoom;
    }

    /**
     * Setter-Method for the {@link #zoom}-Field.
     * <br>
     * </br>
     * Only positive values are permitted.
     *
     * @param zoom the new Value of the {@link #zoom}-Field
     */
    public void setZoom(double zoom) throws IllegalArgumentException{
        // TODO: H1.1
        if(!(zoom > 0)) {
            throw new IllegalArgumentException();
        }
        this.zoom = zoom;
        this.repaint();
    }

    /**
     * Getter-Method for the {@link #text}-Field
     *
     * @return the value of the {@link #text}-Field
     */
    public String getText() {
        return this.text;
    }

    /**
     * Setter-Method for the {@link #text}-Field.
     * <br>
     * </br>
     * Only Strings with at least one and at most 30 characters are permitted.
     *
     * @param text the new Value of the {@link #text}-Field
     */
    public void setText(String text) throws IllegalArgumentException {
        // TODO: H1.1
        if(!(text != null && text.length() >= 1 && text.length() <= 30)) {
            throw new IllegalArgumentException();
        }
        this.text = text;
        this.repaint();
    }

    /**
     * Getter-Method for the {@link #font}-Field
     *
     * @return the value of the {@link #font}-Field
     */
    public Font getFont() {
        return this.font;
    }

    /**
     * Setter-Method for the {@link #font}-Field.
     * <br>
     * </br>
     * Only non-null Fonts are permitted.
     *
     * @param font the new Value of the {@link #font}-Field
     */
    public void setFont(Font font) throws IllegalArgumentException {
        // TODO: H1.1
        if(font == null) {
            throw new IllegalArgumentException();
        }
        this.font = font;
        this.repaint();
    }

    /**
     * Getter-Method for the {@link #borderWidth}-Field
     *
     * @return the value of the {@link #borderWidth}-Field
     */
    public int getBorderWidth() {
        return borderWidth;
    }

    /**
     * Setter-Method for the {@link #borderWidth}-Field.
     * <br>
     * </br>
     * Only values in [1,20] are permitted.
     *
     * @param borderWidth the new Value of the {@link #borderWidth}-Field
     */
    public void setBorderWidth(int borderWidth) throws IllegalArgumentException{
        // TODO: H1.1
        if(!(borderWidth >= 1 && borderWidth <= 20)) {
            throw new IllegalArgumentException();
        }
        this.borderWidth = borderWidth;
        this.repaint();
    }

    // ******************* //
    // -- Other Methods -- //
    // ******************* //

    /**
     * Displays the green ellipse if it is not already displayed.
     * If it is already displayed, it will be moved to the end.
     */
    public void addGreenEllipse() {
        // TODO: H1.1
        if(this.figuresToDisplay.contains(Figure.GREEN_ELLIPSE)) {
            this.figuresToDisplay.remove(Figure.GREEN_ELLIPSE);
            this.figuresToDisplay.add(Figure.GREEN_ELLIPSE);
            repaint();
        } else {
            this.figuresToDisplay.add(Figure.GREEN_ELLIPSE);
            repaint();
            revalidate();
        }
    }

    /**
     * Removes the green ellipse from the Panel.
     * If it is already hidden, the method will do nothing.
     */
    public void removeGreenEllipse() {
        // TODO: H1.1
        this.figuresToDisplay.remove(Figure.GREEN_ELLIPSE);
        repaint();
        revalidate();
    }

    /**
     * Displays the yellow rectangle if it is not already displayed.
     * If it is already displayed, it will be moved to the end.
     */
    public void addYellowRectangle() {
        // TODO: H1.1
        if(this.figuresToDisplay.contains(Figure.YELLOW_RECTANGLE)) {
            this.figuresToDisplay.remove(Figure.YELLOW_RECTANGLE);
            this.figuresToDisplay.add(Figure.YELLOW_RECTANGLE);
        } else this.figuresToDisplay.add(Figure.YELLOW_RECTANGLE);
        this.repaint();
    }

    /**
     * Removes the yellow rectangle from the Panel.
     * If it is already hidden, the method will do nothing.
     */
    public void removeYellowRectangle() {
        // TODO: H1.1
        this.figuresToDisplay.remove(Figure.YELLOW_RECTANGLE);
        this.repaint();
    }

    /**
     * Displays the blue string if it is not already displayed.
     * If it is already displayed, it will be moved to the end.
     */
    public void addBlueString() {
        // TODO: H1.1

        if(this.figuresToDisplay.contains(Figure.BLUE_STRING)) {
            this.figuresToDisplay.remove(Figure.BLUE_STRING);
            this.figuresToDisplay.add(Figure.BLUE_STRING);
        } else this.figuresToDisplay.add(Figure.BLUE_STRING);
        this.repaint();
    }

    /**
     * Removes the blue string from the Panel.
     * If it is already hidden, the method will do nothing.
     */
    public void removeBlueString() {
        // TODO: H1.1
        this.figuresToDisplay.remove(Figure.BLUE_STRING);

        this.repaint();
    }

    // Drawing Methods and helpers

    /**
     * Returns a Color generated from the original Color with the desired
     * transparency (alpha).
     *
     * @param c     The Source color
     * @param alpha the desired Alpha
     * @return the generated Color
     */
    private Color colorWithAlpha(Color c, int alpha) {
        // TODO: H1.2
        return new Color(c.getRed(), c.getGreen(), c.getBlue(), alpha);
    }

    /**
     * Returns a Color generated from the original Color with the desired
     * transparency (alpha).
     *
     * @param c     The Source color
     * @param alpha the desired Alpha
     * @return the generated Color
     */
    private Color colorWithAlpha(Color c, float alpha) {
        return colorWithAlpha(c, (int) (alpha * 255 + 0.5));
    }

    /**
     * Returns a Color generated from the original Color with the desired saturation
     *
     * @param c          The Source color
     * @param saturation the desired Saturation
     * @return the generated Color
     */
    private Color colorWithSaturation(Color c, float saturation) {
        // TODO: H1.2
        float[] hsb = Color.RGBtoHSB(c.getRed(), c.getGreen(), c.getBlue(), null);
        hsb[1] = saturation;
        int rgb = Color.HSBtoRGB(hsb[0], hsb[1], hsb[2]);
        return new Color((rgb>>16)&0xFF, (rgb>>8)&0xFF, rgb&0xFF);
    }

    /**
     * Centers a rectangular Shape
     *
     * @param <T>         The Dynamic Type of the RectangularShape
     * @param s           the RectangularShape
     * @param scaleX      how much horizontal screen space the shape will take
     *                    (1.0d -> full screen)
     * @param scaleY      how much vertical screen space the shape will take
     *                    (1.0d -> full screen)
     * @param borderWidth the Border width to consider
     * @return the centered Shape (for convenience)
     */
    private <T extends RectangularShape> T centerShape(T s, double scaleX, double scaleY, int borderWidth) {
        // TODO: H1.2
        double newWidth = (s.getWidth() * scaleX) - borderWidth;
        double newHeight = (s.getHeight() * scaleY) - borderWidth;

        double newX = (getBounds().getX() + getBounds().getWidth()/2) - (newWidth / 2);
        double newY = (getBounds().getY() + getBounds().getHeight()/2) - (newHeight / 2);

        s.setFrame(newX, newY, newWidth, newHeight);
        return s;
    }

    /**
     * Fills a Given Shape and also draws a border with the given Colors saving and
     * restoring the original stoke and color of g2d.
     *
     * @param g2d           the specified Graphics context
     * @param interiorColor the Color of the filled Area
     * @param borderColor   the border Color
     * @param borderWidth   the Width of the Border
     * @param s             the Shape to draw
     */
    private void fillDraw(Graphics2D g2d, Color interiorColor, Color borderColor, int borderWidth, Shape s) {
        // TODO: H1.2
        Color color = g2d.getColor();
        Stroke stroke = g2d.getStroke();

        g2d.setColor(interiorColor);
        g2d.fill(s);
        g2d.setColor(borderColor);
        g2d.setStroke(new BasicStroke(borderWidth));
        g2d.draw(s);

        g2d.setColor(color);
        g2d.setStroke(stroke);
    }

    /**
     * Fills a Given Shape and also draws a border with the given Colors and Scale
     * to the Center of the Screen.
     *
     * @param g2d           the specified Graphics context
     * @param interiorColor the Color of the filled Area
     * @param borderColor   the border Color
     * @param borderWidth   the Width of the Border
     * @param s             the Shape to draw
     * @param scaleX        how much horizontal screen space the shape will take
     *                      (1.0d -> full screen)
     * @param scaleY        how much vertical screen space the shape will take
     *                      (1.0d -> full screen)
     */
    private void fillDrawCentered(Graphics2D g2d, Color interiorColor, Color borderColor, int borderWidth,
            RectangularShape s, double scaleX, double scaleY) {
        centerShape(s, scaleX, scaleY, borderWidth);
        fillDraw(g2d, interiorColor, borderColor, borderWidth, s);
    }

    /**
     * Create A shape with the desired Text and the desired width
     *
     * @param g2d         the specified Graphics context to draw the font with
     * @param width       the desired text width
     * @param borderWidth the border width to account for
     * @param text        the string to display
     * @param f           the font used for drawing the string
     * @return The Shape of the outline
     */
    private Shape scaleTextToWidth(Graphics2D g2d, double width, float borderWidth, String text, Font f) {
        // TODO: H1.3
        Rectangle2D r = f.createGlyphVector(g2d.getFontRenderContext(), text).getVisualBounds();

        double scale = (width - borderWidth) / (r.getBounds().getWidth());

        AffineTransform affineTransform = new AffineTransform();
        affineTransform.translate(0, ((getBounds().getHeight() / 2) + (r.getHeight() * scale) / 2 ));
        affineTransform.scale(scale, scale);



        FontRenderContext frc = g2d.getFontRenderContext();
        TextLayout textLayout = new TextLayout(this.text, f, frc);

        return textLayout.getOutline(affineTransform);
    }

    /**
     * Draws a given String with the given Color to the center of the Panel.
     *
     * @param g2d           the specified Graphics context
     * @param interiorColor the Color of the filled Area
     * @param borderColor   the border Color
     * @param borderWidth   the Width of the Border
     * @param text          the text to display
     * @param f             the font to use
     * @param width         the desired text width
     */
    @SuppressWarnings("unused") // Kann entfernt werden, sobald die Methode verwendet wird
    private void drawColoredString(Graphics2D g2d, Color interiorColor, Color borderColor, int borderWidth,
            String text, Font f, double width) {
        // TODO: H1.3
        Shape shape = scaleTextToWidth(g2d, width, borderWidth, text, f);

        fillDraw(g2d, interiorColor, borderColor, borderWidth, shape);
    }

    /**
     * Draws a Grid to help With Positioning
     *
     * @param g2d the specified graphics context
     */
    private void drawGrid(Graphics2D g2d) {
        // save g2d configuration
        var oldColor = g2d.getColor();
        var oldStroke = g2d.getStroke();

        // Get current size
        Rectangle bounds = getBounds();
        double width = bounds.getWidth();
        double height = bounds.getHeight();

        // G2d Configuration
        g2d.setColor(Color.GRAY);

        float outerTicksWidth = Math.min(width, height) < 500 ? 4 : 6;
        float tenTicksWidth = Math.min(width, height) < 500 ? 2 : 3;
        float fiveTicksWidth = Math.min(width, height) < 500 ? 1 : 2;
        float oneTicksWidth = Math.min(width, height) < 500 ? 0 : 1;

        // Vertical Lines
        for (double i = 0, x = 0; x < width; i++, x += width / 100d) {
            float strokeWidth = i % 10 == 0 ? tenTicksWidth : i % 5 == 0 ? fiveTicksWidth : oneTicksWidth;
            if (strokeWidth <= 0) {
                continue;
            }
            g2d.setStroke(new BasicStroke(strokeWidth));
            g2d.drawLine((int) x, 0, (int) x, (int) height);
        }

        // Horizontal Lines
        for (double i = 0, y = 0; y < height; i++, y += height / 100d) {
            float strokeWidth = i % 10 == 0 ? tenTicksWidth : i % 5 == 0 ? fiveTicksWidth : oneTicksWidth;
            if (strokeWidth <= 0) {
                continue;
            }
            g2d.setStroke(new BasicStroke(strokeWidth));
            g2d.drawLine(0, (int) y, (int) width, (int) y);
        }

        // Border
        g2d.setStroke(new BasicStroke(outerTicksWidth));
        g2d.drawRect(
                (int) (.5 * outerTicksWidth),
                (int) (.5 * outerTicksWidth),
                (int) (width - outerTicksWidth),
                (int) (height - outerTicksWidth));

        // Restore g2d Configuration
        g2d.setColor(oldColor);
        g2d.setStroke(oldStroke);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // Convert to g2d
        @SuppressWarnings("unused") // Kann entfernt werden, sobald die Methode verwendet wird
        Graphics2D g2d = (Graphics2D) g;

        // Optional: draw a grid that helps with positioning
        // TODO: Remember to disable for submission
         drawGrid(g2d);

        // Paint the desired Figures to the Center of the Screen
        // TODO: H1.3





        for (int i = 0; i < this.figuresToDisplay.size(); i++) {
            if(Objects.equals(figuresToDisplay.get(i).toString(), "BLUE_STRING")) {
                Color outside = colorWithSaturation(Color.BLUE, this.saturation);
                Color inside = colorWithAlpha(Color.BLUE, this.alpha);

                drawColoredString(g2d, inside, outside, 5, this.text, this.font, getBounds().getWidth());
            }

            if(Objects.equals(figuresToDisplay.get(i).toString(), "GREEN_ELLIPSE")) {
                Ellipse2D.Double ellipse = new Ellipse2D.Double();
                ellipse.setFrame(1, 1,getBounds().getWidth(), getBounds().getHeight());

                Color outside = colorWithSaturation(Color.GREEN, this.saturation);
                Color inside = colorWithAlpha(Color.GREEN, this.alpha);

                fillDrawCentered(g2d, inside, outside, this.borderWidth, ellipse, 0.9, 0.9);
            }

            if(Objects.equals(figuresToDisplay.get(i).toString(), "YELLOW_RECTANGLE")) {
                Rectangle2D.Double rectangle = new Rectangle2D.Double();
                rectangle.setFrame(1, 1,getBounds().getWidth(), getBounds().getHeight());

                Color outside = colorWithSaturation(Color.YELLOW, this.saturation);
                Color inside = colorWithAlpha(Color.YELLOW, this.alpha);

                fillDrawCentered(g2d, inside, outside, this.borderWidth, rectangle, 0.8, 0.8);
            }
        }

    }

    @Override
    public void repaint() {
        super.repaint();
    }

}
