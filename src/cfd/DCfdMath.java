/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import sa.lib.SLibUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public abstract class DCfdMath {
    
    private static final DecimalFormat DecimalFormatRound = new DecimalFormat();
    private static final DecimalFormat DecimalFormatRoundUp = new DecimalFormat();
    
    static {
        DecimalFormatRound.setRoundingMode(RoundingMode.HALF_UP);
        DecimalFormatRoundUp.setRoundingMode(RoundingMode.UP);
    }
    
    /**
     * Truncs value up to desired number of decimals.
     * @param value Value to be truncked.
     * @param decimals Desired number of decimals.
     * @return  Truncked value.
     */
    public static double trunck(final double value, final int decimals) {
        String valueAsStr = "" + value;
        int dotIndex = valueAsStr.indexOf('.');
        int valueAsStrDecimals = valueAsStr.substring(dotIndex + 1, valueAsStr.length()).length();
        return SLibUtils.parseDouble(valueAsStr.substring(0, dotIndex + 1 + (decimals <= valueAsStrDecimals ? decimals : valueAsStrDecimals)));
    }
    
    /**
     * Rounds value to desired number of decimals.
     * @param value Value to be rounded.
     * @param decimals Desired number of decimals.
     * @return  Rounded value.
     */
    public static double round(final double value, final int decimals) {
        DecimalFormatRound.setMaximumFractionDigits(decimals);
        return SLibUtils.parseDouble(DecimalFormatRound.format(value));
    }
    
    /**
     * Rounds-up value to desired number of decimals.
     * @param value Value to be rounded-up.
     * @param decimals Desired number of decimals.
     * @return  Rounded-up value.
     */
    public static double roundUp(final double value, final int decimals) {
        DecimalFormatRoundUp.setMaximumFractionDigits(decimals);
        return SLibUtils.parseDouble(DecimalFormatRoundUp.format(value));
    }
}
