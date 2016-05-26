/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moroz.fled.classic;

import com.moroz.fled.interfaces.EdgeDetector;
import com.moroz.fled.util.CheckerUtil;
import java.awt.image.BufferedImage;
import java.awt.Color;
import com.moroz.fled.util.ImageTransformer;

import static com.moroz.fled.util.GeneralConstants.*;
import static java.lang.Math.sqrt;
/**
 *
 * @author Oksana_Moroz
 */
public class SobelOperatorEdgeDetector implements EdgeDetector {
    
    private static final int[][] G1 = {{1, 2, 1},
        {0, 0, 0},
        {-1, -2, -1}};
    
    private static final int[][] G2 = transpose(G1);

    private static int[][] transpose(int[][] G) {
        int[][] G2 = new int[0][0];
        int n = G.length;
        if (n > 0) {
            int m = G[0].length;
            G2 = new int[m][n];
            for (int i = 0; i < n; i++) {                
                for (int j = 0; j < m; j++) {
                    G2[j][i] = G[i][j];
                }
            }
        }
        return G2;
    }
    
    @Override
    public BufferedImage detectEdges(BufferedImage grayscaleImage) {
        BufferedImage resultGrayscaleImage = new BufferedImage(grayscaleImage.getWidth(), grayscaleImage.getHeight(), grayscaleImage.getType());
        for (int i = 1; i < grayscaleImage.getWidth() - 1; i++) {
            for (int j = 1; j < grayscaleImage.getHeight() - 1; j++) {
                int X = convolution(G1, grayscaleImage, i, j);
                int Y = convolution(G2, grayscaleImage, i, j);
                int result = (int) sqrt(X * X + Y * Y);
                int resultGrayLevel = CheckerUtil.cutToCorrectPixelValue(result);
                Color resultColor = new Color(resultGrayLevel, resultGrayLevel, resultGrayLevel);
                resultGrayscaleImage.setRGB(i, j, resultColor.getRGB());
            }
        }
        return resultGrayscaleImage;
    }
    
    private int convolution(int[][] G, BufferedImage A, int widthIndex, int heightIndex) {
        int sum = 0;
        for (int k = 0; k < NEIGHBOURS_SIZE; k++) {
            int rgb = A.getRGB(widthIndex + NEIGHBOURS[k][0], heightIndex + NEIGHBOURS[k][1]);
            int grayLevel = ImageTransformer.convertRGBToGrayLevelAndCheckIt(rgb);
            sum += G[1 + NEIGHBOURS[k][0]][1 + NEIGHBOURS[k][1]] * grayLevel;
        }
        return sum;
    }
    
}
