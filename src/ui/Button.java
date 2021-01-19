package ui;

import config.AppConfig;
import de.ur.mi.oop.colors.Colors;
import de.ur.mi.oop.graphics.Circle;
import de.ur.mi.oop.graphics.Label;

public class Button {

    /**
     * Position und Größe der Bildschirmfläche, in der der Button dargestellt wird. Die sichtbare Form
     * des Buttons nimmt nur einen Teil dieser Box ein.
     */
    private final int xPos;
    private final int yPos;
    private final int boxSize;
    // Darstellung des Buttons
    private Circle shape;
    // Unter dem Button liegender "Schatten"
    private Circle shadow;
    // Label mit dem "Namen" des Buttons
    private Label label;
    // Anzahl der aktuell noch verbleibenden Frames in der Highlight-Phase
    private int remainingHighlightFrames;
    // Listener, der informiert wird, wenn der Button angeklickt wurde
    private ButtonClickListener clickListener;

    /**
     * Initalisiert den Button an der angegebene Postion am Bildschirm
     *
     * @param x X-Koordinate des Bereichs, in dem der Button gezeichnet werden soll
     * @param y Y-Koordinate des Bereichs, in dem der Button gezeichnet werden soll
     */
    public Button(int x, int y) {
        this.xPos = x;
        this.yPos = y;
        /*
          Der sichtbare Teil des Buttons nimmt nur einen Teil des Bereichs innerhalb der Gitterdarstellung ein.
          An dieser Stelle berechnen wir einmalig die Breite (und Höhe) der Box, innerhalb der der Button angezeigt
          wird, um später über diesen Wert die eigentlichen, sichtbaren Elemente innerhalb der gedachten Box
          positionieren zu können.
         */
        this.boxSize = AppConfig.BUTTON_WIDTH + (2 * AppConfig.BUTTON_MARGIN);
        remainingHighlightFrames = 0;
        initButtonShape();
        initLabel();
    }

    private void initButtonShape() {
        int shapeX = this.xPos + (this.boxSize / 2);
        int shapeY = this.yPos + (this.boxSize / 2);
        this.shape = new Circle(shapeX, shapeY, AppConfig.BUTTON_WIDTH / 2, AppConfig.BUTTON_COLOR);
        this.shadow = new Circle(shapeX, shapeY + AppConfig.BUTTON_SHADOW_OFFSET, AppConfig.BUTTON_WIDTH / 2, AppConfig.BUTTON_SHADOW_COLOR);
    }

    private void initLabel() {
        this.label = new Label(0, 0, "");
        this.label.setColor(AppConfig.BUTTON_FONT_COLOR);
        this.label.setFontSize(AppConfig.BUTTON_FONT_SIZE);
        this.label.setFont(AppConfig.DEFAULT_FONT);
    }

    public void setListener(ButtonClickListener listener) {
        this.clickListener = listener;
    }

    public void setText(String text) {
        this.label.setText(text);
        float labelX = xPos + boxSize - label.getWidthEstimate() - AppConfig.BUTTON_TEXT_MARGIN_RIGHT;
        float labelY = yPos + boxSize - label.getHeightEstimate();
        this.label.setPosition(labelX, labelY);
    }

    public String getLabel() {
        return label.getText();
    }

    /**
     * Diese Methode versetzt den Button in einen Highlight-Status, während der eine andere Darstellung
     * (kein Schatten und andere Farbe des Knopfs) gezeichnet wird. Diese Animation dauert eine bestimmte
     * Anzahl an Frames, die in der Konfigurationsklasse gesetzt ist. Während der Animationsphase wird die
     * Anzahl der verbleibenden Frames bei jedem Aufruf der draw-Methode um eins reduziert.
     */
    public void highlight() {
        // Zu Beginn der Highlight-Phase wird die Farbe des Buttons geändert ...
        shape.setColor(AppConfig.BUTTON_HIGHLIGHT_COLOR);
        // ... und der Schatten durch das Setzen einer vollständig transparenten Farbe ausgeblendet
        shadow.setColor(Colors.TRANSPARENT);
        remainingHighlightFrames = AppConfig.BUTTON_HIGHLIGHT_FRAME_COUNT;
    }

    public void draw() {
        // Wenn der Button im aktuellen Frame noch ge-highlighted werden soll ...
        if (remainingHighlightFrames > 0) {
            // ... ziehen wir einen der verbleibenden Animations-Frames ab.
            remainingHighlightFrames--;
        }
        // Wenn das Ende der Animationsphase erreicht ist, setzen wir die Farbe des Buttons und des Schattens zurück
        if (remainingHighlightFrames == 0) {
            shape.setColor(AppConfig.BUTTON_COLOR);
            shadow.setColor(AppConfig.BUTTON_SHADOW_COLOR);
        }
        shadow.draw();
        shape.draw();
        label.draw();
    }

    public void handleMouseClick(int x, int y) {
        // Während der Animationsphase verarbeitet der Button keine weiteren Klicks
        if (remainingHighlightFrames > 0) {
            return;
        }
        if (clickListener == null) {
            return;
        }
        if (shape.hitTest(x, y)) {
            clickListener.onButtonClicked(this);
        }
    }
}
