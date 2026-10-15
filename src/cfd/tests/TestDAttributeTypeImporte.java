/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.tests;

import cfd.DAttributeTypeImporte;

/**
 *
 * @author Sergio Flores
 */
public class TestDAttributeTypeImporte {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double[] doubles = new double[] { 0, 0., 1, 1., 1.1, 1.10, 1.100, 1.1000, 16410.2, 16410.25, 40427.793, 40427.7931, 42009.88793, 42009.887934, 42009.8879349, 42009.88793491 };
        for (double d : doubles) {
            DAttributeTypeImporte importe = new DAttributeTypeImporte("value", true);
            importe.setCanBeZero(true);
            importe.setDoubleAdjustingDecimals(d);
            System.out.println("Value: " + d + " as attribute for XML: " + importe.getAttributeForXml());
        }
    }
    
}
