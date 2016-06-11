/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moroz.fled.service;

import com.moroz.fled.classic.SobelOperatorEdgeDetector;
import com.moroz.fled.interfaces.EdgeDetector;
import java.awt.image.BufferedImage;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class SobelOperatorService extends GrayscaleImageService {
    
    private final EdgeDetector edgeDetector = new SobelOperatorEdgeDetector();
    
    @Override
    public BufferedImage processImage(BufferedImage input) {
        BufferedImage grayscaleImage = imageTransformer.toGrayscaleImage(input);
        
        BufferedImage output = edgeDetector.detectEdges(grayscaleImage);
        
        return output;
    }  
}
