package config;

import de.ur.mi.oop.colors.Color;

/**
 * Konfigurations-Werte für verschiedene Bereiche der Anwendung
 */

public abstract class AppConfig {

    // Display
    public static final int DISPLAY_WIDTH = 600;
    public static final int DISPLAY_HEIGHT = 700;
    public static final Color BACKGROUND_COLOR = new Color(226, 232, 206);
    public static final int GRID_SIZE = 6;
    // Fonts
    public static final String DEFAULT_FONT = "Arial Rounded MT Bold";
    // App label
    public static final String APP_TITLE = "OOP SOUNDBOARD";
    public static final int APP_LABEL_POSITION_X = 25;
    public static final int APP_LABEL_POSITION_Y = 675;
    public static final int APP_LABEL_FONT_SIZE = 48;
    public static final Color APP_LABEL_COLOR = new Color(38, 38, 38);
    // Buttons
    public static final int BUTTON_WIDTH = 50;
    public static final int BUTTON_MARGIN = 25;
    public static final int BUTTON_SHADOW_OFFSET = 5;
    public static final Color BUTTON_COLOR = new Color(245, 0, 0);
    public static final Color BUTTON_SHADOW_COLOR = new Color(184, 0, 0);
    public static final Color BUTTON_HIGHLIGHT_COLOR = new Color(255, 51, 51);
    public static final int BUTTON_TEXT_MARGIN_RIGHT = 10;
    public static final int BUTTON_FONT_SIZE = 14;
    public static final Color BUTTON_FONT_COLOR = new Color(38, 38, 38);
    public static final int BUTTON_HIGHLIGHT_FRAME_COUNT = 30;

}
