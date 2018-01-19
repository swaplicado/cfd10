/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */
package cfd.ext.continental;

import cfd.DSubelementAddendaType;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DElementAddendaContinentalTire extends cfd.DSubelementAddenda {
    
    public static final String NAME = "AddendaContinentalTire";

    protected DElementPo moEltPo;
    protected DElementPedido moEltPedido;
    protected DElementTipoProv moEltTipoProv;
    protected DElementPosicionesPo moEltPosicionesPo;

    public DElementAddendaContinentalTire() {
        super(NAME, DSubelementAddendaType.Continental);
        
        moEltPo = new DElementPo(DElementPoOptions.CON);
        moEltPedido = new DElementPedido("");
        moEltTipoProv = new DElementTipoProv(DElementTipoProvOptions.P);
        moEltPosicionesPo = new DElementPosicionesPo();
        
        mvElements.add(moEltPo);
        mvElements.add(moEltPedido);
        mvElements.add(moEltTipoProv);
        mvElements.add(moEltPosicionesPo);
    }
    
    public DElementPo getEltPo() { return moEltPo; }
    public DElementPedido getEltPedido() { return moEltPedido; }
    public DElementTipoProv getEltTipoProv() { return moEltTipoProv; }
    public DElementPosicionesPo getEltPosicionesPo() { return moEltPosicionesPo; }
}
