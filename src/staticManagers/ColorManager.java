package staticManagers;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

public class ColorManager {

    @SuppressWarnings("serial")
    private static Map<Character, String> Colors = new HashMap<Character, String>() {{
        // Gras
        put('1', "#98c768");
        put('2', "#97c968");
        put('3', "#65a43b");
        put('4', "#5c9b31");
        put('5', "#73b048");
        put('6', "#6ba13c");
        put('7', "#4c6f30");
        // Earth
        put('=', "#b7835a");
        put('+', "#765338");
        put('?', "#5b422d");
        // Clouds
        put('!', "#ffffff");
        put('@', "#f5f5f5");
        put('%', "#95d2f0");
        //Sky
        put('-', "#83b1fc");
    }};

    public static Color getColor(char key) {
        return Color.decode(Colors.get(key));
    }
}