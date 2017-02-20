/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cfd.ver32;

/**
 *
 * @author Sergio Abraham Flores Gutérrez
 */
public class DTimbreFiscal {

    protected String msVersion;
    protected String msUuid;
    protected String msFechaTimbrado;
    protected String msSelloCfd;
    protected String msNoCertificadoSat;
    protected String msSelloSat;
    protected int mnPacId;

    public DTimbreFiscal() {
        msVersion = DElementTimbreFiscalDigital.VER;
        msUuid = "";
        msFechaTimbrado = "";
        msSelloCfd = "";
        msNoCertificadoSat = "";
        msSelloSat = "";
        mnPacId = 0;
    }

    public void setVersion(String s) { msVersion = s; }
    public void setUuid(String s) { msUuid = s; }
    public void setFechaTimbrado(String s) { msFechaTimbrado = s; }
    public void setSelloCfd(String s) { msSelloCfd = s; }
    public void setNoCertificadoSat(String s) { msNoCertificadoSat = s; }
    public void setSelloSat(String s) { msSelloSat = s; }
    public void setPacId(int n) { mnPacId = n; }

    public String getVersion() { return msVersion; }
    public String getUuid() { return msUuid; }
    public String getFechaTimbrado() { return msFechaTimbrado; }
    public String getSelloCfd() { return msSelloCfd; }
    public String getNoCertificadoSat() { return msNoCertificadoSat; }
    public String getSelloSat() { return msSelloSat; }
    public int getPacId() { return mnPacId; }
}
