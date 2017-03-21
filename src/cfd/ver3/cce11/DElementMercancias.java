/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.ver3.cce11;

import cfd.DAttribute;
import cfd.DElement;
import java.util.Vector;
import sa.lib.SLibUtils;

/**
 *
 * @author Juan Barajas
 */
public class DElementMercancias extends cfd.DElement {

    protected java.util.Vector<cfd.ver3.cce11.DElementMercancia> mvEltHijosMercancia;

    public DElementMercancias() {
        super("cce11:Mercancias");

        mvEltHijosMercancia = new Vector<DElementMercancia>();
    }

    public java.util.Vector<cfd.ver3.cce11.DElementMercancia> getEltHijosMercancia() { return mvEltHijosMercancia; }

    /**
     * Add one element Element Mercancia type to vector, if not exists.
     * @param elementMercancia element to add.
     */
    public void addMercancia(cfd.ver3.cce11.DElementMercancia elementMercancia) {
        boolean exists = false;
        
        for (cfd.ver3.cce11.DElementMercancia mercancia : mvEltHijosMercancia) {
            if (mercancia.getAttNoIdentificacion().getString().compareTo(elementMercancia.getAttNoIdentificacion().getString()) == 0 &&
                    mercancia.getAttFraccionArancelaria().getString().compareTo(elementMercancia.getAttFraccionArancelaria().getString()) == 0) {
                mercancia.getAttCantidadAduana().setDouble(SLibUtils.round((mercancia.getAttCantidadAduana().getDouble() + elementMercancia.getAttCantidadAduana().getDouble()), elementMercancia.getAttCantidadAduana().getDecimals()));
                mercancia.getAttValorDolares().setDouble(SLibUtils.round((mercancia.getAttValorDolares().getDouble() + elementMercancia.getAttValorDolares().getDouble()), SLibUtils.getDecimalFormatAmount().getMaximumFractionDigits()));
                exists = true;
                break;
            }
        }
        
        if (!exists) {
            mvEltHijosMercancia.add(elementMercancia);
        }
    }
    
    
    @Override
    public java.lang.String getElementForXml() {
        String xml = "";
        String string = "";

        string = "<" + msName;

        for (DAttribute attribute : mvAttributes) {
            xml = attribute.getAttributeForXml();
            string += xml.length() == 0 ? "" : " " + xml;
        }

        string += ">";

        if (mvEltHijosMercancia.size() == 0) {
            throw new IllegalStateException(DElement.MSG_ERR_NO_ELEMENTS + "'" + msName + "'.");
        }
        else {
            for (DElementMercancia concepto : mvEltHijosMercancia) {
                xml = concepto.getElementForXml();
                string += xml.length() == 0 ? "" : "\n" + xml;
            }
        }

        string += "\n</" + msName + ">";

        return string;
    }

    @Override
    public java.lang.String getElementForOriginalString() {
        String string = "";

        for (DElementMercancia concepto : mvEltHijosMercancia) {
            string += concepto.getElementForOriginalString();
        }

        return string;
    }
}
