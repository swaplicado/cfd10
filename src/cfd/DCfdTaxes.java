/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd;

import java.util.ArrayList;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DCfdTaxes {
    
    protected ArrayList<DCfdTax> maCfdTaxsRetained;
    protected ArrayList<DCfdTax> maCfdTaxsCharged;
    
    public DCfdTaxes() {
        maCfdTaxsRetained = new ArrayList<DCfdTax>();
        maCfdTaxsCharged = new ArrayList<DCfdTax>();
    }
    
    private void addTax(DCfdTax tax, ArrayList<DCfdTax> maCfdTaxes) {
        boolean exists = false;
        
        for (DCfdTax cfdTax : maCfdTaxes) {
            if (cfdTax.getTasa() == tax.getTasa() &&
                    cfdTax.getImpuestoClave().compareTo(tax.getImpuestoClave()) == 0 &&
                    cfdTax.getTipopFactor().compareTo(tax.getTipopFactor()) == 0) {
                cfdTax.addBaseImporte(tax.getBase(), cfdTax.getImporte());
                exists = true;
                break;
            }
        }
        
        if (!exists) {
            maCfdTaxes.add(tax);
        }
    }
    
    public void addTaxCharged(DCfdTax tax) {
        addTax(tax, maCfdTaxsCharged);
    }
    
    public void addTaxRetained(DCfdTax tax) {
        addTax(tax, maCfdTaxsRetained);
    }
    
    public ArrayList<DCfdTax> getTaxCharged() {
        return maCfdTaxsCharged;
    }
    
    public ArrayList<DCfdTax> getTaxRetained() {
        return maCfdTaxsRetained;
    }
}
