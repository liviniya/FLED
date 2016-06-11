/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moroz.fled.fuzzy;

import static com.moroz.fled.util.GeneralConstants.PIXEL_SIZE;

/**
 *
 * @author Admin
 */
public class EdgeMembershipFunctionConverter {
    
    public static final int EDGE_END = 10;
    
    private static final double MAX_EDGE_AREA = EDGE_END / 2;
    
    public double convertFuzzyNumberToEdgeGrayLevel(double alphaMax) {
        double trapeziumArea = getTrapeziumArea(alphaMax);
        //return -PIXEL_SIZE * trapeziumArea / MAX_EDGE_AREA + PIXEL_SIZE;
        return PIXEL_SIZE * trapeziumArea / MAX_EDGE_AREA;
    }
    
    private double getTrapeziumArea(double alphaMax) {
        return EDGE_END * (2 - alphaMax) * alphaMax / 2;
    } 
}
