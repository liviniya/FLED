package com.moroz.fled.util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FileImageProcessor {

    public void writeImageToFile(BufferedImage image, String path, 
            String fileName, String format) throws IOException {        
        File output = new File(path + fileName + "." + format);
        ImageIO.write(image, format, output);
    }

    public BufferedImage readImageFromFile(String fullImageName) throws IOException {
        return ImageIO.read(this.getClass().getResource(fullImageName));
    }
}
