/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cfd.ver33;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DSelloDigital {
    
    protected String msSello;
    protected String msNoCertificado;
    protected String msCertificado;
    
    public DSelloDigital() {
        msSello = "";
        msNoCertificado = "";
        msCertificado = "";
    }
    
    public void setSello(String s) { msSello = s; }
    public void setNoCertificado(String s) { msNoCertificado = s; }
    public void setCertificado(String s) { msCertificado = s; }
    
    public String getSello() { return msSello; }
    public String getNoCertificado() { return msNoCertificado; }
    public String getCertificado() { return msCertificado; }
}
