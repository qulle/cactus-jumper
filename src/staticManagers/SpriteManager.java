package staticManagers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.imageio.ImageIO;

public class SpriteManager {
    private static final String spritePath = "./images/";
    private static HashMap<String, BufferedImage> bufferedImages = new HashMap<String, BufferedImage>();
    private static boolean hasLoaded = false;

    @SuppressWarnings("serial")
    private static ArrayList<String> imagesToLoad = new ArrayList<String>() {{
        add("1.png");
        add("2.png");
        add("3.png");
    }};

    public static void loadImages() {
        if(hasLoaded) {
            return;
        }

        for(String spriteName : imagesToLoad) {
            try {
                bufferedImages.put(spriteName.split("\\.")[0], ImageIO.read(new File(spritePath + spriteName)));
            }catch(IOException e) {
                e.printStackTrace();
            }
        }
        hasLoaded = true;
    }

    public static BufferedImage getImage(String spriteName) {
        return bufferedImages.get(spriteName);
    }
}