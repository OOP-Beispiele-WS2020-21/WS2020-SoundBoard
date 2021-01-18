import config.AppConfig;
import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.colors.Colors;
import de.ur.mi.oop.events.MousePressedEvent;
import de.ur.mi.oop.launcher.GraphicsAppLauncher;
import sounds.Sound;
import ui.Button;
import ui.ButtonClickListener;

import java.util.ArrayList;
import java.util.HashMap;

public class SoundBoardApp extends GraphicsApp implements ButtonClickListener {

    private ArrayList<Button> buttons;
    private HashMap<String, Sound> sounds;

    @Override
    public void initialize() {
        setCanvasSize(AppConfig.DISPLAY_WIDTH, AppConfig.DISPLAY_HEIGHT);
        initSounds();
        initButtons();
    }

    private void initSounds() {
        sounds = new HashMap<>();
        for(Sound sound: Sound.values()) {
            sounds.put(sound.label, sound);
        }
    }

    private void initButtons() {
        buttons = new ArrayList<>();
        int gridSize = AppConfig.DISPLAY_WIDTH / AppConfig.BUTTON_WIDTH;
        for(int x = 0; x < gridSize; x++) {
            for(int y = 0; y < gridSize; y++) {
                String buttonID = String.valueOf(y * gridSize + x + 1);
                if( buttonID.length() < 2) {
                    buttonID = "0" + buttonID;
                }
                Button button = new Button(x * AppConfig.BUTTON_WIDTH, y * AppConfig.BUTTON_HEIGHT, Colors.getRandomColor());
                button.setLabel(buttonID);
                button.setListener(this);
                buttons.add(button);
            }
        }
    }

    @Override
    public void draw() {
        drawBackground(AppConfig.BACKGROUND_COLOR);
        for(Button button: buttons) {
            button.draw();
        }
    }

    @Override
    public void onMousePressed(MousePressedEvent event) {
        for(Button button: buttons) {
            button.handleMouseClick(event.getXPos(), event.getYPos());
        }
    }

    @Override
    public void onButtonClicked(Button button) {
        button.highlight();
        sounds.get(button.getLabel()).audio.play();
    }

    public static void main(String[] args) {
        GraphicsAppLauncher.launch();
    }
}
