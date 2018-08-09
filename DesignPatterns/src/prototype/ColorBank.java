package prototype;

import java.util.HashMap;
import java.util.Map;

public class ColorBank {

    private static Map<String, GoogleColor> colors = new HashMap<>();

    static {
        colors.put("Blue", new Blue());
        colors.put("Green", new Green());
        colors.put("Purple", new Purple());
        colors.put("Red", new Red());
        colors.put("Yellow", new Yellow());
    }

    public static GoogleColor getColor(String colorName){
        return colors.get(colorName).clone();
    }
}
