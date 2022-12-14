/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.ver40.crp20;

import cfd.DAttributeInteger;
import cfd.DAttributeString;
import cfd.DAttributeTipoCambio6d;
import cfd.DAttributeTypeImporte;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public interface DIntDoctoRelacionado {
    
    public DAttributeString getAttIdDocumento();
    public DAttributeString getAttSerie();
    public DAttributeString getAttFolio();
    public DAttributeString getAttMonedaDR();
    public DAttributeTipoCambio6d getAttEquivalenciaDR();
    public DAttributeInteger getAttNumParcialidad();
    public DAttributeTypeImporte getAttImpSaldoAnt();
    public DAttributeTypeImporte getAttImpPagado();
    public DAttributeTypeImporte getAttImpSaldoInsoluto();
    public DAttributeString getAttObjetoImpDR();
}
