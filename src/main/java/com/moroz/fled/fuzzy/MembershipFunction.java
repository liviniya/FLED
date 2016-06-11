/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moroz.fled.fuzzy;

/**
 *
 * @author Admin
 */
public abstract class MembershipFunction {
    
    public abstract double getValue(int grayLevel);
    
    public abstract void modify(Integer startValue, Integer endValue);
    
    protected final double getYForXInLineByTwoPoints(double x1, double y1, double x2, double y2, double x) {
        return ((x - x1) * (y2 - y1) + (x2 - x1) * y1) / (x2 - x1);
    }
}
