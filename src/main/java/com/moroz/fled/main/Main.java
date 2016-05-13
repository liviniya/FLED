package com.moroz.fled.main;
/*
* Created by : Oksana_Moroz
* Created at : 04-04-2016
*/

import com.moroz.fled.fuzzy.FuzzyLogicEdgeDetector;
import com.moroz.fled.util.FileImageProcessor;
import com.moroz.fled.util.ImageTransformer;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        FileImageProcessor imageProcessor = new FileImageProcessor();
        BufferedImage image = imageProcessor.readImageFromFile("/image.jpg");

        ImageTransformer imageTransformer = new ImageTransformer();
        BufferedImage grayscaleImage = imageTransformer.toGrayscaleImage(image);

        FuzzyLogicEdgeDetector edgeDetector = new FuzzyLogicEdgeDetector();
        BufferedImage edgeImage = edgeDetector.detectEdges(grayscaleImage);

        imageProcessor.writeImageToFile(edgeImage, "result_edges_image");
    }
}
