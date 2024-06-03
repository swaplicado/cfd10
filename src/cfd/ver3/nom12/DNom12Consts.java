/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.ver3.nom12;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public abstract class DNom12Consts {
    
    /**
     * Máximo subsidio para el empleo en una nómina correspondiente a un período menor o igual a 31 días pagados.
     * "<strong>Error NOM101.</strong> El valor del atributo Nomina.OtrosPagos.OtroPago.SubsidioAlEmpleo.SubsidioCausado no puede ser mayor que 407.02 ya que el valor de NumDiasPagados es menor o igual a 31."
     * Entrada en vigor desde enero 2020.
     */
    public static final double MAX_TAX_SUB = 407.02;
}
