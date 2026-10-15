/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd;

import sa.lib.SLibUtils;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DAttributeTypeImporte extends DAttributeDouble {
    
    public static final int DEF_DECS = 2;
    public static final int MAX_DECS = 6;

    public DAttributeTypeImporte(java.lang.String name, boolean isRequired) {
        super(name, isRequired, DEF_DECS);
    }
    
    /**
     * Set double value adjusting current decimals.
     * Decimals cannot be less than 2 or more than 6 neither.
     */
    public void setDoubleAdjustingDecimals(final double value) {
        int newDecimals = MAX_DECS;
        double newDouble = SLibUtils.round(value, newDecimals);
        String newValueStr = "" + newDouble;
        int pointPos = newValueStr.lastIndexOf(".");
        
        if (pointPos >= 0) {
            String decimalsStr = newValueStr.substring(pointPos + 1);
            
            if (decimalsStr.length() <= DEF_DECS) {
                newDecimals = DEF_DECS;
            }
            else if (decimalsStr.length() > MAX_DECS) {
                newDecimals = MAX_DECS;
            }
            else {
                newDecimals = decimalsStr.length();
            }
        }
        
        setDecimals(newDecimals);
        setDouble(newDouble);
    }
}
