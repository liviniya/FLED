package com.moroz.fled.fuzzy;
/*
* Created by : Oksana_Moroz
* Created at : 11-04-2016
*/

import java.awt.image.BufferedImage;

import static java.lang.Double.compare;
import static com.moroz.fled.util.GeneralConstants.*;
import static com.moroz.fled.util.CheckerUtil.*;
import com.moroz.fled.util.ImageTransformer;

public class ImageToFuzzyNumbersConverter {

    private static final double WHITE_START_GRAY = 90;
    private static final double WHITE_END_GRAY = 203;
    private static final double BLACK_START_GRAY = 43;
    private static final double BLACK_END_GRAY = 117;

    private static final double EDGE_END = 10;

    private static final double MAX_EDGE_AREA = EDGE_END / 2;
    
    public ImageFuzzyNumber[][] convertGrayLevelImageToFuzzyNumbers(BufferedImage grayscaleImage) {
        ImageFuzzyNumber[][] fuzzyNumbers = new ImageFuzzyNumber[grayscaleImage.getWidth()][grayscaleImage.getHeight()];
        for (int i = 0; i < grayscaleImage.getWidth(); i++) {
            for (int j = 0; j < grayscaleImage.getHeight(); j++) {
                int rgb = grayscaleImage.getRGB(i, j);
                int grayLevel = ImageTransformer.convertRGBToGrayLevelAndCheckIt(rgb);

                double white = getWhiteMembershipFunction(grayLevel);
                double black = getBlackMembershipFunction(grayLevel);
                fuzzyNumbers[i][j] = new ImageFuzzyNumber(white, black);
            }
        }
        return fuzzyNumbers;
    }

    public double convertFuzzyNumberToEdgeGrayLevel(double alphaMax) {
        double trapeziumArea = getTrapeziumArea(alphaMax);
        //return -PIXEL_SIZE * trapeziumArea / MAX_EDGE_AREA + PIXEL_SIZE;
        return PIXEL_SIZE * trapeziumArea / MAX_EDGE_AREA;
    }

    private double getTrapeziumArea(double alphaMax) {
        return EDGE_END * (2 - alphaMax) * alphaMax / 2;
    }   

    private double getBlackMembershipFunction(int grayLevel) {
        checkIfCorrectPixelValue(grayLevel);
        if (compare(grayLevel, BLACK_START_GRAY) <= 0) {
            return 1;
        }
        if (compare(grayLevel, BLACK_END_GRAY) >= 0) {
            return 0;
        }
        return getYForXInLineByTwoPoints(BLACK_START_GRAY, 1, BLACK_END_GRAY, 0, grayLevel);
    }

    private double getWhiteMembershipFunction(int grayLevel) {
        checkIfCorrectPixelValue(grayLevel);
        if (compare(grayLevel, WHITE_START_GRAY) <= 0) {
            return 0;
        }
        if (compare(grayLevel, WHITE_END_GRAY) >= 0) {
            return 1;
        }
        return getYForXInLineByTwoPoints(WHITE_START_GRAY, 0, WHITE_END_GRAY, 1, grayLevel);
    }

    private double getYForXInLineByTwoPoints(double x1, double y1, double x2, double y2, double x) {
        return ((x - x1) * (y2 - y1) + (x2 - x1) * y1) / (x2 - x1);
    }
}
