import config.AppConfig;
import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.events.MousePressedEvent;
import de.ur.mi.oop.graphics.Label;
import de.ur.mi.oop.launcher.GraphicsAppLauncher;
import sounds.SoundFileNotFoundException;
import sounds.SoundManager;
import ui.Button;
import ui.ButtonClickListener;

import java.util.ArrayList;

/**
 * Einfaches SoundBoard auf Basis der GraphicsApp
 * <p>
 * In der App werden 36 Schaltflächen (Buttons) in einem Gitternetz angezeigt. Beim Klick
 * auf einen der Buttons wird ein damit verknüpfter Sound abgespielt.
 * <p>
 * Jeder Button wird durch ein Instanz der Button-Klasse repräsentiert die über das Interface
 * ButtonClickListener in einem Observer-Observable-Verhältnis zur SoundBoardApp steht. Die App
 * leitet alle Klicks an die Buttons weiter, die über die Interface-Methode zurückmelden, wenn
 * durch den jeweiligen Klick der Button berührt wurde.
 * <p>
 * Die Sounds werden vom SoundManager verwaltet. Beim Klick auf einen Button versucht die App,
 * den Sound, der über das Label des Buttons repräsentiert wird, im SoundManager abzuspielen.
 * <p>
 * Alle verfügbaren Sounds werden über ein Enum repräsentiert.
 */

public class SoundBoardApp extends GraphicsApp implements ButtonClickListener {

    private ArrayList<Button> buttons;
    private Label appLabel;
    private SoundManager soundManager;

    @Override
    public void initialize() {
        setCanvasSize(AppConfig.DISPLAY_WIDTH, AppConfig.DISPLAY_HEIGHT);
        soundManager = new SoundManager();
        initButtons();
        initAppLabel();
    }

    private void initButtons() {
        // Bereich, der im UI für einen Button zur Verfügung steht
        int buttonBoxWidth = AppConfig.BUTTON_WIDTH + (2 * AppConfig.BUTTON_MARGIN);
        buttons = new ArrayList<>();
        for (int x = 0; x < AppConfig.GRID_SIZE; x++) {
            for (int y = 0; y < AppConfig.GRID_SIZE; y++) {
                /*
                 Berechnung der ID auf Basis der aktuellen Zählervariablen der beiden Schleifen. Der numerische Wert wird
                 dabei durch die valueOf-Methode in eine String umgewandelt. Für die gleichmäßige Darstellung wird eine
                 führende Null ergänzt, wenn die ID kleiner als 10 ist.
                 */
                String buttonID = String.valueOf(y * AppConfig.GRID_SIZE + x + 1);
                if (buttonID.length() < 2) {
                    buttonID = "0" + buttonID;
                }
                Button button = new Button(x * buttonBoxWidth, y * buttonBoxWidth);
                button.setText(buttonID);
                button.setListener(this);
                buttons.add(button);
            }
        }
    }

    private void initAppLabel() {
        appLabel = new Label(AppConfig.APP_LABEL_POSITION_X, AppConfig.APP_LABEL_POSITION_Y, AppConfig.APP_TITLE);
        appLabel.setColor(AppConfig.APP_LABEL_COLOR);
        appLabel.setFontSize(AppConfig.APP_LABEL_FONT_SIZE);
        appLabel.setFont(AppConfig.DEFAULT_FONT);
    }

    private void playSound(String name) {
        // Die playSound-Methode löst eine Exception aus, wenn kein Sound für den übergebenen Parameter gefunden wurde ...
        try {
            soundManager.playSound(name);
            // ... die im Zweifelsfall hier abgefangen werden kann.
        } catch (SoundFileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void draw() {
        drawBackground(AppConfig.BACKGROUND_COLOR);
        drawButtons();
        appLabel.draw();
    }

    private void drawButtons() {
        for (Button button : buttons) {
            button.draw();
        }
    }

    /**
     * Wird aufgerufen, wenn ein Button zurückmeldet, dass er angeklickt wurde
     *
     * @param button Der angeklickte Button
     */
    @Override
    public void onButtonClicked(Button button) {
        /*
         Nach dem Klick wird der Button in den Highlight-Zustand versetzt, der nach einer bestimmten Anzahl
         an Frames automatisch deaktivert wird (siehe Button-Klasse).
         */
        button.highlight();
        // Anhand der Button-Beschriftung wird versucht, den zugehörigen Sound abzuspielen
        playSound(button.getLabel());
    }

    @Override
    public void onMousePressed(MousePressedEvent event) {
        for (Button button : buttons) {
            button.handleMouseClick(event.getXPos(), event.getYPos());
        }
    }

    public static void main(String[] args) {
        GraphicsAppLauncher.launch();
    }
}
