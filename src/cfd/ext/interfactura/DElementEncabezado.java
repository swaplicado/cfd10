/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ext.interfactura;

import cfd.DAttribute;
import cfd.DAttributeDatetime;
import cfd.DAttributeDouble;
import cfd.DAttributeOptionMoneda;
import cfd.DAttributeString;
import cfd.DElement;
import java.util.Vector;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementEncabezado extends cfd.DElementParent {

    protected cfd.DAttributeOptionMoneda moAttMoneda;
    protected cfd.DAttributeString moAttFolioOrdenCompra;
    protected cfd.DAttributeString moAttFolioNotaRecepcion;
    protected cfd.DAttributeDatetime moAttFecha;
    protected cfd.DAttributeString moAttCondicionPago;
    protected cfd.DAttributeDouble moAttIVAPCT;
    protected cfd.DAttributeString moAttNumProveedor;
    protected cfd.DAttributeString moAttCargoTipo;
    protected cfd.DAttributeDouble moAttSubTotal;
    protected cfd.DAttributeString moAttFolio;
    protected cfd.DAttributeString moAttSerie;
    protected cfd.DAttributeDouble moAttIva;
    protected cfd.DAttributeDouble moAttTotal;
    protected cfd.DAttributeString moAttProcesoId;
    protected cfd.DAttributeString moAttObservaciones;
    protected cfd.DAttributeString moAttLugarExpedicion;

    protected java.util.Vector<cfd.ext.interfactura.DElementCuerpo> mvEltHijosEncabezado;

    public DElementEncabezado() {
        super("if:Encabezado");

        moAttMoneda = new DAttributeOptionMoneda("Moneda", true);
        moAttFolioOrdenCompra = new DAttributeString("FolioOrdenCompra", true, 1, 50);
        moAttFolioNotaRecepcion = new DAttributeString("FolioNotaRecepcion", true, 1, 50);
        moAttFecha = new DAttributeDatetime("Fecha", true);
        moAttCondicionPago = new DAttributeString("CondicionPago", true, 1, 5);
        moAttIVAPCT = new DAttributeDouble("IVAPCT", true, 0);
        moAttNumProveedor = new DAttributeString("NumProveedor", true, 1, 10);
        moAttCargoTipo = new DAttributeString("CargoTipo", true, 0);
        moAttSubTotal = new DAttributeDouble("SubTotal", true, 2);
        moAttSerie = new DAttributeString("Serie", false);
        moAttFolio = new DAttributeString("Folio", false);
        moAttIva = new DAttributeDouble("Iva", true, 2);
        moAttTotal = new DAttributeDouble("Total", true, 2);
        moAttProcesoId = new DAttributeString("ProcesoId", false);
        moAttObservaciones = new DAttributeString("Observaciones", false, 0, 256);
        moAttLugarExpedicion = new DAttributeString("LugarExpedicion", false);

        mvAttributes.add(moAttMoneda);
        mvAttributes.add(moAttFolioOrdenCompra);
        mvAttributes.add(moAttFolioNotaRecepcion);
        mvAttributes.add(moAttFecha);
        mvAttributes.add(moAttCondicionPago);
        mvAttributes.add(moAttIVAPCT);
        mvAttributes.add(moAttNumProveedor);
        mvAttributes.add(moAttCargoTipo);
        mvAttributes.add(moAttSubTotal);
        mvAttributes.add(moAttSerie);
        mvAttributes.add(moAttFolio);
        mvAttributes.add(moAttIva);
        mvAttributes.add(moAttTotal);
        mvAttributes.add(moAttProcesoId);
        mvAttributes.add(moAttObservaciones);
        mvAttributes.add(moAttLugarExpedicion);

        mvEltHijosEncabezado = new Vector<DElementCuerpo>();
    }

    public cfd.DAttributeOptionMoneda getAttMoneda() { return moAttMoneda; }
    public cfd.DAttributeString getAttFolioOrdenCompra() { return moAttFolioOrdenCompra; }
    public cfd.DAttributeString getAttFolioNotaRecepcion() { return moAttFolioNotaRecepcion; }
    public cfd.DAttributeDatetime getAttFecha() { return moAttFecha; }
    public cfd.DAttributeString getAttCondicionPago() { return moAttCondicionPago; }
    public cfd.DAttributeDouble getAttIVAPCT() { return moAttIVAPCT; }
    public cfd.DAttributeString getAttNumProveedor() { return moAttNumProveedor; }
    public cfd.DAttributeString getAttCargoTipo() { return moAttCargoTipo; }
    public cfd.DAttributeDouble getAttSubTotal() { return moAttSubTotal; }
    public cfd.DAttributeString getAttSerie() { return moAttSerie; }
    public cfd.DAttributeString getAttFolio() { return moAttFolio; }
    public cfd.DAttributeDouble getAttIva() { return moAttIva; }
    public cfd.DAttributeDouble getAttTotal() { return moAttTotal; }
    public cfd.DAttributeString getAttProcesoId() { return moAttProcesoId; }
    public cfd.DAttributeString getAttObservaciones() { return moAttObservaciones; }
    public cfd.DAttributeString getAttLugarExpedicion() { return moAttLugarExpedicion; }

    public java.util.Vector<cfd.ext.interfactura.DElementCuerpo> getEltHijosEncabezado() { return mvEltHijosEncabezado; }

    @Override
    public java.lang.String getElementForXml() throws Exception {
        String xml = "";
        String string = "";

        string = "<" + msName;

        for (DAttribute attribute : mvAttributes) {
            xml = attribute.getAttributeForXml();
            string += xml.isEmpty() ? "" : " " + xml;
        }

        string += ">";

        if (mvEltHijosEncabezado.isEmpty()) {
            throw new IllegalStateException(DElement.ERR_MSG_NODE + "'" + msName + "'" + DElement.ERR_MSG_NODE_NO_CHILD + "'" + (new cfd.ext.interfactura.DElementCuerpo().getName()) + "'.");
        }
        else {
            for (DElementCuerpo cuerpo : mvEltHijosEncabezado) {
                xml = cuerpo.getElementForXml();
                string += xml.isEmpty() ? "" : "\n" + xml;
            }
        }

        string += "\n</" + msName + ">";

        return string;
    }

    @Override
    public java.lang.String getElementForOriginalString() throws Exception {
        return "";
    }
}
