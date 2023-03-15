/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DAttributeTipoCambio extends DAttributeDouble {
    
    public static final int DECS = 4;

    public DAttributeTipoCambio(java.lang.String name, boolean isRequired) {
        super(name, isRequired, DECS);
    }
}
