package config;

import de.ur.mi.oop.colors.Color;

/**
 * Konfigurations-Werte für verschiedene Bereiche der Anwendung
 */

public abstract class AppConfig {

    // Display
    public static final int DISPLAY_WIDTH = 620;
    public static final int DISPLAY_HEIGHT = 700;
    public static final Color BACKGROUND_COLOR = OOPColors.CREAM;
    public static final int GRID_SIZE = 6;
    // Fonts
    public static final String DEFAULT_FONT = "Arial Rounded MT Bold";
    // App label
    public static final String APP_TITLE = "OOP SOUNDBOARD";
    public static final int APP_LABEL_POSITION_X = 25;
    public static final int APP_LABEL_POSITION_Y = 675;
    public static final int APP_LABEL_FONT_SIZE = 32;
    public static final Color APP_LABEL_COLOR = OOPColors.GREY;
    // Buttons
    public static final int BUTTON_WIDTH = 50;
    public static final int BUTTON_MARGIN = 25;
    public static final int BUTTON_SHADOW_OFFSET = 5;
    public static final Color BUTTON_COLOR = OOPColors.RED;
    public static final Color BUTTON_SHADOW_COLOR = new Color(150, 49, 63);
    public static final Color BUTTON_HIGHLIGHT_COLOR = OOPColors.GREEN;
    public static final int BUTTON_TEXT_MARGIN_RIGHT = 5;
    public static final int BUTTON_FONT_SIZE = 12;
    public static final Color BUTTON_FONT_COLOR = OOPColors.GREY;
    public static final int BUTTON_HIGHLIGHT_FRAME_COUNT = 30;

}