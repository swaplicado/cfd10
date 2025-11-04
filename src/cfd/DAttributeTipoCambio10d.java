/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DAttributeTipoCambio10d extends DAttributeDouble {
    
    public static final int DECS = 10;

    public DAttributeTipoCambio10d(java.lang.String name, boolean isRequired) {
        super(name, isRequired, DECS);
    }
}
