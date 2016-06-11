/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moroz.fled.fuzzy;

import static com.moroz.fled.util.CheckerUtil.checkIfCorrectPixelValue;

/**
 *
 * @author Admin
 */
public class WhiteMembershipFunction extends MembershipFunction {

    public static int WHITE_START_GRAY = 90;
    public static int WHITE_END_GRAY = 203; 
    
    @Override
    public double getValue(int grayLevel) {
        checkIfCorrectPixelValue(grayLevel);
        if (grayLevel <= WHITE_START_GRAY) {
            return 0;
        }
        if (grayLevel >= WHITE_END_GRAY) {
            return 1;
        }
        return getYForXInLineByTwoPoints(WHITE_START_GRAY, 0, WHITE_END_GRAY, 1, grayLevel);
    }    

    @Override
    public void modify(Integer startValue, Integer endValue) {
        WHITE_START_GRAY = startValue;
        WHITE_END_GRAY = endValue;
    }
}
