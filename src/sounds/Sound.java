package sounds;

import de.ur.mi.oop.audio.AudioClip;

/**
 * Dieses Enum bildet alle Sound-Datei ab, die innerhalb des Programms verwendet werden können.
 */

public enum Sound {
    SOUND_01("01", "assets/sound/SOUND_(1).wav"),
    SOUND_02("02", "assets/sound/SOUND_(2).wav"),
    SOUND_03("03", "assets/sound/SOUND_(3).wav"),
    SOUND_04("04", "assets/sound/SOUND_(4).wav"),
    SOUND_05("05", "assets/sound/SOUND_(5).wav"),
    SOUND_06("06", "assets/sound/SOUND_(6).wav"),
    SOUND_07("07", "assets/sound/SOUND_(7).wav"),
    SOUND_08("08", "assets/sound/SOUND_(8).wav"),
    SOUND_09("09", "assets/sound/SOUND_(9).wav"),
    SOUND_10("10", "assets/sound/SOUND_(10).wav"),
    SOUND_11("11", "assets/sound/SOUND_(11).wav"),
    SOUND_12("12", "assets/sound/SOUND_(12).wav"),
    SOUND_13("13", "assets/sound/SOUND_(13).wav"),
    SOUND_14("14", "assets/sound/SOUND_(14).wav"),
    SOUND_15("15", "assets/sound/SOUND_(15).wav"),
    SOUND_16("16", "assets/sound/SOUND_(16).wav"),
    SOUND_17("17", "assets/sound/SOUND_(17).wav"),
    SOUND_18("18", "assets/sound/SOUND_(18).wav"),
    SOUND_19("19", "assets/sound/SOUND_(19).wav"),
    SOUND_20("20", "assets/sound/SOUND_(20).wav"),
    SOUND_21("21", "assets/sound/SOUND_(21).wav"),
    SOUND_22("22", "assets/sound/SOUND_(22).wav"),
    SOUND_23("23", "assets/sound/SOUND_(23).wav"),
    SOUND_24("24", "assets/sound/SOUND_(24).wav"),
    SOUND_25("25", "assets/sound/SOUND_(25).wav"),
    SOUND_26("26", "assets/sound/SOUND_(26).wav"),
    SOUND_27("27", "assets/sound/SOUND_(27).wav"),
    SOUND_28("28", "assets/sound/SOUND_(28).wav"),
    SOUND_29("29", "assets/sound/SOUND_(29).wav"),
    SOUND_30("30", "assets/sound/SOUND_(30).wav"),
    SOUND_31("31", "assets/sound/SOUND_(31).wav"),
    SOUND_32("32", "assets/sound/SOUND_(32).wav"),
    SOUND_33("33", "assets/sound/SOUND_(33).wav"),
    SOUND_34("34", "assets/sound/SOUND_(34).wav"),
    SOUND_35("35", "assets/sound/SOUND_(35).wav"),
    SOUND_36("36", "assets/sound/SOUND_(36).wav");

    // Name der Sound-Datei
    public final String name;
    // AudioClip zum Abspielen des Sounds
    public final AudioClip audio;

    /**
     * Konstruktor für die Enum-Objekte (siehe Liste oben)
     *
     * @param name      Eindeutiger Name für den Sound
     * @param audioPath Pfad zur Audio-Datei für das Erstellen des AudioClips
     */
    Sound(String name, String audioPath) {
        this.name = name;
        this.audio = new AudioClip(audioPath);

    }

}
