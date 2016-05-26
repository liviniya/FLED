package com.moroz.fled.util;
/*
* Created by : Oksana_Moroz
* Created at : 11-04-2016
*/

import static com.moroz.fled.util.CheckerUtil.checkIfRedGreenAndBlueAreEquals;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageTransformer {

    public BufferedImage toGrayscaleImage(BufferedImage image) {
        BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                int grayLevel = (int) getGrayLevel(image.getRGB(i, j));
                Color newColor = new Color(grayLevel, grayLevel, grayLevel);
                newImage.setRGB(i, j, newColor.getRGB());
            }
        }
        return newImage;
    }

    private double getGrayLevel(int rgb) {
        Color c = new Color(rgb);
        int red = c.getRed();
        int green = c.getGreen();
        int blue = c.getBlue();
        return 0.299 * red + 0.587 * green + 0.114 * blue;
    }
    
    public static int convertRGBToGrayLevelAndCheckIt(int rgb) {
        Color color = new Color(rgb);
        checkIfRedGreenAndBlueAreEquals(color);
        return color.getRed();
    }
}
