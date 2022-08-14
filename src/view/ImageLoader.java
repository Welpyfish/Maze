package view;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageLoader {

    private BufferedImage marioForms;
    private BufferedImage brickAnimation;

    public ImageLoader(){
//        marioForms = loadImage("/mario-forms.png");
//        brickAnimation = loadImage("/brick-animation.png");
    }

    public BufferedImage loadImage(String path){
        BufferedImage imageToReturn = null;

        try {
            imageToReturn = ImageIO.read(getClass().getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return imageToReturn;
    }

    public BufferedImage loadImage(File file){
        BufferedImage imageToReturn = null;

        try {
            imageToReturn = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return imageToReturn;
    }

//    public BufferedImage getSubImage(BufferedImage image, int col, int row, int w, int h){
//        if((col == 1 || col == 4) && row == 3){ //koopa
//            return image.getSubimage((col-1)*48, 128, w, h);
//        }
//        return image.getSubimage((col-1)*48, (row-1)*48, w, h);
//    }

}
