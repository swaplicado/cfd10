/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.mtrn.view;

/**
 *
 * @author Claudio Peña
 */

public class SDataStockExcel  {

    private String msClave;
    private String msItem;
    private int mnExistencias;
    private String msUnidad;
    private double mnCosto;

    public SDataStockExcel(String clave, String item, int existencias, String unidad, double costo) {
        this.msClave = clave;
        this.msItem = item;
        this.mnExistencias = existencias;
        this.msUnidad = unidad;
        this.mnCosto = costo;
    }

    public void setClave(String n) { msClave = n; }
    public void setItem(String n) { msItem = n; }
    public void setExistencias(int n) { mnExistencias = n; }
    public void setUnidad(String n) { msUnidad = n; }
    public void setCosto(double n) { mnCosto = n; }
    
    public String getClave() { return msClave; }
    public String getItem() { return msItem; }
    public int getExistencias() { return mnExistencias; }
    public String getUnidad() { return msUnidad; }
    public double getCosto() { return mnCosto; }
}