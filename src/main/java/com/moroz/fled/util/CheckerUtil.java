/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moroz.fled.util;

import static com.moroz.fled.util.GeneralConstants.PIXEL_SIZE;
import java.awt.Color;

/**
 *
 * @author Oksana_Moroz
 */
public class CheckerUtil {
    
    private CheckerUtil() {}   
    
    public static void checkIfRedGreenAndBlueAreEquals(Color color) {
        int red = color.getRed();
        int green = color.getGreen();
        int blue = color.getBlue();
        if (red != green || green != blue) {
            throw new IllegalArgumentException("Colourful pixel detected, when gray level expected. Red: " + red + ", green: " + green + ", blue: " + blue);
        }
    }

    public static void checkIfCorrectPixelValue(int pixel) {
        if (pixel < 0 || pixel > PIXEL_SIZE) {
            throw new IllegalArgumentException("Wrong pixel value for: " + pixel);
        }
    }
    
    public static int cutToCorrectPixelValue(int pixel) {
        if (pixel < 0) {
            return 0;
        }
        if (pixel > PIXEL_SIZE) {
            return PIXEL_SIZE;
        }
        return pixel;
    }
}
