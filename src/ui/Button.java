package ui;

import config.AppConfig;
import de.ur.mi.oop.colors.Color;
import de.ur.mi.oop.graphics.Label;
import de.ur.mi.oop.graphics.Rectangle;

public class Button {

    private Rectangle shape;
    private Label label;
    private Color originalColor;
    private Color highlightColor;
    private int remainingHighlightFrames;
    private ButtonClickListener clickListener;

    public Button(int x, int y, Color color) {
        this.originalColor = color;
        this.highlightColor = new Color(color.red(), color.green(), color.blue(), 115);
        this.shape = new Rectangle(x, y, AppConfig.BUTTON_WIDTH, AppConfig.BUTTON_HEIGHT, originalColor);
        this.label = new Label(0, 0, "");
        this.label.setColor(AppConfig.BUTTON_FONT_COLOR);
        this.label.setFontSize(AppConfig.BUTTON_FONT_SIZE);
        remainingHighlightFrames = 0;
    }

    public void setListener(ButtonClickListener listener) {
        this.clickListener = listener;
    }

    public void setLabel(String label) {
        this.label.setText(label);
        float centerX = shape.getXPos() + (AppConfig.BUTTON_WIDTH / 2) - (this.label.getWidthEstimate() / 2);
        float centerY = shape.getYPos() + (AppConfig.BUTTON_HEIGHT / 2) + (this.label.getHeightEstimate() / 2);
        this.label.setPosition(centerX, centerY);
    }

    public String getLabel() {
        return label.getText();
    }

    public void highlight() {
        shape.setColor(highlightColor);
        remainingHighlightFrames = AppConfig.BUTTON_HIGHLIGHT_FRAME_COUNT;
    }

    public void draw() {
        if (remainingHighlightFrames > 0) {
            remainingHighlightFrames--;
        }
        shape.draw();
        label.draw();
        if (remainingHighlightFrames == 0) {
            this.shape.setColor(originalColor);
        }
    }

    public void handleMouseClick(int x, int y) {
        if (clickListener == null) {
            return;
        }
        if (shape.hitTest(x, y)) {
            clickListener.onButtonClicked(this);
        }
    }
}
