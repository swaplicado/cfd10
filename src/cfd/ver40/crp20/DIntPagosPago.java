/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.ver40.crp20;

import cfd.DAttributeDatetime;
import cfd.DAttributeString;
import cfd.DAttributeTipoCambio;
import cfd.DAttributeTypeImporte;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public interface DIntPagosPago {
    
    public DAttributeDatetime getAttFechaPago();
    public DAttributeString getAttFormaDePagoP();
    public DAttributeString getAttMonedaP();
    public DAttributeTipoCambio getAttTipoCambioP();
    public DAttributeTypeImporte getAttMonto();
    public DAttributeString getAttNumOperacion();
    public DAttributeString getAttRfcEmisorCtaOrd();
    public DAttributeString getAttNomBancoOrdExt();
    public DAttributeString getAttCtaOrdenante();
    public DAttributeString getAttRfcEmisorCtaBen();
    public DAttributeString getAttCtaBeneficiario();
    public DAttributeString getAttTipoCadPago();
    public DAttributeString getAttCertPago();
    public DAttributeString getAttCadPago();
    public DAttributeString getAttSelloPago();
}
