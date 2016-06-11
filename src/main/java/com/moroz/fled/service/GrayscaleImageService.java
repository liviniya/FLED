/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moroz.fled.service;

import com.moroz.fled.util.ImageTransformer;
import java.awt.image.BufferedImage;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class GrayscaleImageService {
    
    protected final ImageTransformer imageTransformer = new ImageTransformer();
    
    public BufferedImage processImage(BufferedImage input) {
        BufferedImage grayscaleImage = imageTransformer.toGrayscaleImage(input);
        
        return grayscaleImage;
    }
}
