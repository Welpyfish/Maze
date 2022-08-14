package view;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageLoader
{
    public ImageLoader(){}

    public BufferedImage loadImage(String path) {
        BufferedImage image = null;

        try
        {
            image = ImageIO.read(getClass().getClassLoader().getResource(path));
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        return image;
    }
}
