/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moroz.fled.service;

import com.moroz.fled.fuzzy.FuzzyLogicEdgeDetector;
import java.awt.image.BufferedImage;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class FuzzyLogicService extends GrayscaleImageService{
    
    private final FuzzyLogicEdgeDetector edgeDetector = new FuzzyLogicEdgeDetector();
    
    @Override
    public BufferedImage processImage(BufferedImage input) {
        BufferedImage grayscaleImage = imageTransformer.toGrayscaleImage(input);
        
        BufferedImage output = edgeDetector.detectEdges(grayscaleImage);     
        
        return output;
    }
    
    public void modifyBlackWhiteMembershipFunctions(Integer blackStartGray, Integer blackEndGray,
            Integer whiteStartGray, Integer whiteEndGray) {
        edgeDetector.modifyBlackMembershipFunction(blackStartGray, blackEndGray);
        edgeDetector.modifyWhiteMembershipFunction(whiteStartGray, whiteEndGray);
    }
    
    public void modifyEdgeMembershipFunction(Integer edgeEnd) {
        edgeDetector.modifyEdgeMembershipFunction(edgeEnd);
    }
}
