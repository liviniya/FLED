package com.moroz.fled.fuzzy;
/*
* Created by : Oksana_Moroz
* Created at : 11-04-2016
*/

import static java.lang.Math.max;
import static java.lang.Math.min;

public class MamdaniFIS {

    private static final boolean BLACK = false;
    private static final boolean WHITE = true;

    private static final int NEIGHBOURS_SIZE = 9;

    private static final boolean[] BOTTOM_EDGE              = {WHITE, WHITE, WHITE, WHITE, WHITE, WHITE, BLACK, BLACK, BLACK};
    private static final boolean[] TOP_EDGE                 = {BLACK, BLACK, BLACK, WHITE, WHITE, WHITE, WHITE, WHITE, WHITE};
    private static final boolean[] LEFT_EDGE                = {BLACK, WHITE, WHITE, BLACK, WHITE, WHITE, BLACK, WHITE, WHITE};
    private static final boolean[] RIGHT_EDGE               = {WHITE, WHITE, BLACK, WHITE, WHITE, BLACK, WHITE, WHITE, BLACK};
    private static final boolean[] LEFT_TOP_CORNER_EDGE     = {BLACK, BLACK, WHITE, BLACK, WHITE, WHITE, BLACK, WHITE, WHITE};
    private static final boolean[] RIGHT_BOTTOM_CORNER_EDGE = {WHITE, WHITE, BLACK, WHITE, WHITE, BLACK, WHITE, BLACK, BLACK};
    private static final boolean[] LEFT_BOTTOM_CORNER_EDGE  = {BLACK, WHITE, WHITE, BLACK, WHITE, WHITE, BLACK, BLACK, WHITE};
    private static final boolean[] RIGHT_TOP_CORNER_EDGE    = {WHITE, BLACK, BLACK, WHITE, WHITE, BLACK, WHITE, WHITE, BLACK};

    private static final boolean[][] RULES = {BOTTOM_EDGE, TOP_EDGE, LEFT_EDGE, RIGHT_EDGE, LEFT_TOP_CORNER_EDGE,
            RIGHT_BOTTOM_CORNER_EDGE, LEFT_BOTTOM_CORNER_EDGE, RIGHT_TOP_CORNER_EDGE};

    private static final int [][] NEIGHBOURS = {{-1, -1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 0}, {0, 1},
            {1, -1}, {1, 0}, {1, 1}};

    public double resolve(ImageFuzzyNumber[][] fuzzyNumbers, int widthIndex, int heightIndex) {
        double alphaMax = 0;
        for (int r = 0; r < RULES.length; r++) {
            double alpha = 1;
            for (int k = 0; k < NEIGHBOURS_SIZE; k++) {
                if (RULES[r][k] == WHITE) {
                    alpha = min(alpha, fuzzyNumbers[widthIndex + NEIGHBOURS[k][0]][heightIndex + NEIGHBOURS[k][1]].getWhite());
                } else if (RULES[r][k] == BLACK) {
                    alpha = min(alpha, fuzzyNumbers[widthIndex + NEIGHBOURS[k][0]][heightIndex + NEIGHBOURS[k][1]].getBlack());
                }
            }
            alphaMax = max(alphaMax, alpha);
        }
        return alphaMax;
    }
}
