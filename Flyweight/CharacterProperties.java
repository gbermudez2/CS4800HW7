package Flyweight;

import java.util.HashMap;
import java.util.Map;

public class CharacterProperties {
    private String font;
    private String color;
    private int size;

    public CharacterProperties(String font, String color, int size) {
        this.font = font;
        this.color = color;
        this.size = size;
    }

    public String getFont() {
        return font;
    }

    public String getColor() {
        return color;
    }

    public int getSize() {
        return size;
    }
}

// Flyweight factory to manage shared flyweight objects
class CharacterPropertiesFactory {
    private static Map<String, CharacterProperties> propertiesMap = new HashMap<>();

    public static CharacterProperties getCharacterProperties(String font, String color, int size) {
        String key = font + "_" + color + "_" + size;
        if (!propertiesMap.containsKey(key)) {
            propertiesMap.put(key, new CharacterProperties(font, color, size));
        }
        return propertiesMap.get(key);
    }
}
