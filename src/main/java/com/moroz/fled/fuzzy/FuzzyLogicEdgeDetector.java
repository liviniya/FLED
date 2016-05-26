package com.moroz.fled.fuzzy;
/*
* Created by : Oksana_Moroz
* Created at : 11-04-2016
*/

import com.moroz.fled.interfaces.EdgeDetector;
import java.awt.*;
import java.awt.image.BufferedImage;

public class FuzzyLogicEdgeDetector implements EdgeDetector {

    private final ImageToFuzzyNumbersConverter imageToFuzzyNumbersConverter = new ImageToFuzzyNumbersConverter();
    private final MamdaniFIS mamdani = new MamdaniFIS();

    @Override
    public BufferedImage detectEdges(BufferedImage grayscaleImage) {
        BufferedImage resultGrayscaleImage = new BufferedImage(grayscaleImage.getWidth(), grayscaleImage.getHeight(), grayscaleImage.getType());
        ImageFuzzyNumber [][] fuzzyNumbers = imageToFuzzyNumbersConverter.convertGrayLevelImageToFuzzyNumbers(grayscaleImage);
        for (int i = 1; i < grayscaleImage.getWidth() - 1; i++) {
            for (int j = 1; j < grayscaleImage.getHeight() - 1; j++) {
                double alphaMax = mamdani.resolve(fuzzyNumbers, i, j);
                int resultGrayLevel = (int) imageToFuzzyNumbersConverter.convertFuzzyNumberToEdgeGrayLevel(alphaMax);
                Color resultColor = new Color(resultGrayLevel, resultGrayLevel, resultGrayLevel);
                resultGrayscaleImage.setRGB(i, j, resultColor.getRGB());
            }
        }
        return resultGrayscaleImage;
    }
}
