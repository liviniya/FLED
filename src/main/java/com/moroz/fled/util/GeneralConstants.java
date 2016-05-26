/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moroz.fled.util;

/**
 *
 * @author Oksana_Moroz
 */
public class GeneralConstants {
    
    private GeneralConstants() {}
    
    public static final int NEIGHBOURS_SIZE = 9;
     
    public static final int [][] NEIGHBOURS = {{-1, -1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 0}, {0, 1},
            {1, -1}, {1, 0}, {1, 1}};
    
    public static final int PIXEL_SIZE = 255;
}
