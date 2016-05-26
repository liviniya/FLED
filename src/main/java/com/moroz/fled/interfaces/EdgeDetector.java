/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moroz.fled.interfaces;

import java.awt.image.BufferedImage;

/**
 *
 * @author Oksana_Moroz
 */
public interface EdgeDetector {
    
    public BufferedImage detectEdges(BufferedImage grayscaleImage);
}
