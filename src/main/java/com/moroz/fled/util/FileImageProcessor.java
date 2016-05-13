package com.moroz.fled.util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;

public class FileImageProcessor {

    public void writeImageToFile(BufferedImage image, String fileName) throws IOException {
        //File output = new File(fileName + ".jpg");
        // not working -> String property = System.getProperty("user.dir");
        
        File output = new File("D:\\images\\" + fileName + ".jpg");
        //System.out.println("PATH = " + output.getAbsolutePath());
        ImageIO.write(image, "jpg", output);
    }

    public BufferedImage readImageFromFile(String fullImageName) throws IOException {
        return ImageIO.read(this.getClass().getResource(fullImageName));
    }
}
