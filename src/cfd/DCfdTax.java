/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd;


/**
 *
 * @author Juan Barajas
 */
public interface DCfdTax {
    
    public void setImpuestoClave(String s);
    public void setTasa(double d);
    public void setTipoFactor(String s);
    
    public String getImpuestoClave();
    public double getTasa();
    public String getTipopFactor();
    public double getBase();
    public double getImporte();
    
    public void clearBaseImporte();
    public void addBaseImporte(double base, double importe);
}
