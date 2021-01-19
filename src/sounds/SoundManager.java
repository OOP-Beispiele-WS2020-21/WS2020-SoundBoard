package sounds;

import java.util.HashMap;

/**
 * Diese Klasse verwaltet eine Liste von Sounds und erlaubt das Abspielen einzelner
 * Töne über die Angabe derer Namen. Wird versucht, auf einen Sound zuzugreifen, der unter
 * dem angegebenen Namen nicht bekannt ist, löst eine Exception aus.
 */

public class SoundManager {

    // HashMap für Zuordnung der Sound zu deren Namen
    private HashMap<String, Sound> sounds;

    public SoundManager() {
        initSounds();
    }

    private void initSounds() {
        sounds = new HashMap<>();
        for (Sound sound : Sound.values()) {
            /* In der HashMap werden die Enum-Objekte (Sounds) mit deren Namen verknüpft,
               um schnell auf diese zugreifen zu können.
            */
            sounds.put(sound.name, sound);
        }
    }

    /**
     * Spielt den Sound mit dem übergebenen Namen ab.
     * @param name Name des Sounds, der abgespielt werden soll
     * @throws SoundFileNotFoundException Wird ausgelöst, wenn unter dem angegebenen Namen kein Sound gefunden wurde
     */
    public void playSound(String name) throws SoundFileNotFoundException {
        Sound sound = sounds.get(name);
        if (sound != null) {
            sound.audio.play();
        } else {
            throw new SoundFileNotFoundException();
        }
    }
}
