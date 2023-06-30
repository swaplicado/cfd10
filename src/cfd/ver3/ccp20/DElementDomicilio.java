/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cfd.ver3.ccp20;

import cfd.DAttributeString;

/**
 *
 * @author Isabel Danae García Servín
 */
public class DElementDomicilio extends cfd.DElement {
    
    private final DAttributeString moAttCalle; 
    private final DAttributeString moAttNumeroExterior; 
    private final DAttributeString moAttNumeroInterior; 
    private final DAttributeString moAttColonia; 
    private final DAttributeString moAttLocalidad; 
    private final DAttributeString moAttReferencia; 
    private final DAttributeString moAttMunicipio; 
    private final DAttributeString moAttEstado; 
    private final DAttributeString moAttPais; 
    private final DAttributeString moAttCodigoPostal; 

    public DElementDomicilio() {
        super("cartaporte20:Domicilio");
        
        moAttCalle = new DAttributeString("Calle", false);
        moAttNumeroExterior = new DAttributeString("NumeroExterior", false);
        moAttNumeroInterior = new DAttributeString("NumeroInterior", false);
        moAttColonia = new DAttributeString("Colonia", false);
        moAttLocalidad = new DAttributeString("Localidad", false);
        moAttReferencia = new DAttributeString("Referencia", false);
        moAttMunicipio = new DAttributeString("Municipio", false, 1, 30);
        moAttEstado = new DAttributeString("Estado", true);
        moAttPais = new DAttributeString("Pais", true);
        moAttCodigoPostal = new DAttributeString("CodigoPostal", true, 1, 12);
        
        mvAttributes.add(moAttCalle);
        mvAttributes.add(moAttNumeroExterior);
        mvAttributes.add(moAttNumeroInterior);
        mvAttributes.add(moAttColonia);
        mvAttributes.add(moAttLocalidad);
        mvAttributes.add(moAttReferencia);
        mvAttributes.add(moAttMunicipio);
        mvAttributes.add(moAttEstado);
        mvAttributes.add(moAttPais);
        mvAttributes.add(moAttCodigoPostal);
    }
    
    public DAttributeString getAttCalle() { return moAttCalle; } 
    public DAttributeString getAttNumeroExterior() { return moAttNumeroExterior; } 
    public DAttributeString getAttNumeroInterior() { return moAttNumeroInterior; } 
    public DAttributeString getAttColonia() { return moAttColonia; } 
    public DAttributeString getAttLocalidad() { return moAttLocalidad; } 
    public DAttributeString getAttReferencia() { return moAttReferencia; } 
    public DAttributeString getAttMunicipio() { return moAttMunicipio; } 
    public DAttributeString getAttEstado() { return moAttEstado; } 
    public DAttributeString getAttPais() { return moAttPais; } 
    public DAttributeString getAttCodigoPostal() { return moAttCodigoPostal; }
}
