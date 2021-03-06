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
public class BlackMembershipFunction extends MembershipFunction {

    public static int BLACK_START_GRAY = 43;
    public static int BLACK_END_GRAY = 117;
    
    public void refresh() {
        BLACK_START_GRAY = 43;
        BLACK_END_GRAY = 117;
    }
    
    @Override
    public double getValue(int grayLevel) {
        checkIfCorrectPixelValue(grayLevel);
        if (grayLevel <= BLACK_START_GRAY) {
            return 1;
        }
        if (grayLevel >= BLACK_END_GRAY) {
            return 0;
        }
        return getYForXInLineByTwoPoints(BLACK_START_GRAY, 1, BLACK_END_GRAY, 0, grayLevel);
    }    

    @Override
    public void modify(Integer startValue, Integer endValue) {
        BLACK_START_GRAY = startValue;
        BLACK_END_GRAY = endValue;
    }   
}
