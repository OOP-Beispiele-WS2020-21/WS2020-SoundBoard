import config.AppConfig;
import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.launcher.GraphicsAppLauncher;

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

public class SoundBoardApp extends GraphicsApp {


    @Override
    public void initialize() {
        setCanvasSize(AppConfig.DISPLAY_WIDTH, AppConfig.DISPLAY_HEIGHT);
    }

    @Override
    public void draw() {
        drawBackground(AppConfig.BACKGROUND_COLOR);
    }

    public static void main(String[] args) {
        GraphicsAppLauncher.launch();
    }
}
