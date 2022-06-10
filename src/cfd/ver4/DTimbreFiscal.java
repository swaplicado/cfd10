/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cfd.ver4;

import cfd.ver32.DElementTimbreFiscalDigital;

/**
 *
 * @author Sergio Abraham Flores Gutérrez
 */
public class DTimbreFiscal {

    protected String msVersion;             // CFDI 3.2 & 3.3 & 4.0
    protected String msUuid;                // CFDI 3.2 & 3.3 & 4.0
    protected String msFechaTimbrado;       // CFDI 3.2 & 3.3 & 4.0
    protected String msRfcProvCertif;       // CFDI 3.3 & 4.0
    protected String msLeyenda;             // CFDI 3.3 & 4.0
    protected String msSelloCfd;            // CFDI 3.2 & 3.3 & 4.0
    protected String msNoCertificadoSat;    // CFDI 3.2 & 3.3 & 4.0
    protected String msSelloSat;            // CFDI 3.2 & 3.3 & 4.0
    protected int mnPacId;

    public DTimbreFiscal() {
        msVersion = DElementTimbreFiscalDigital.VER;
        msUuid = "";
        msFechaTimbrado = "";
        msRfcProvCertif = "";
        msLeyenda = "";
        msSelloCfd = "";
        msNoCertificadoSat = "";
        msSelloSat = "";
        mnPacId = 0;
    }

    public void setVersion(String s) { msVersion = s; }
    public void setUuid(String s) { msUuid = s; }
    public void setFechaTimbrado(String s) { msFechaTimbrado = s; }
    public void setRfcProvCertif(String s) { msRfcProvCertif = s; }
    public void setLeyenda(String s) { msLeyenda = s; }
    public void setSelloCfd(String s) { msSelloCfd = s; }
    public void setNoCertificadoSat(String s) { msNoCertificadoSat = s; }
    public void setSelloSat(String s) { msSelloSat = s; }
    public void setPacId(int n) { mnPacId = n; }

    public String getVersion() { return msVersion; }
    public String getUuid() { return msUuid; }
    public String getFechaTimbrado() { return msFechaTimbrado; }
    public String getRfcProvCertif() { return msRfcProvCertif; }
    public String getLeyenda() { return msLeyenda; }
    public String getSelloCfd() { return msSelloCfd; }
    public String getNoCertificadoSat() { return msNoCertificadoSat; }
    public String getSelloSat() { return msSelloSat; }
    public int getPacId() { return mnPacId; }
}
