/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd;

import cfd.ver3.DCfdVer3Consts;
import cfd.ver33.DElementCfdiRelacionado;
import cfd.ver33.DElementCfdiRelacionados;
import cfd.ver33.DElementConceptoImpuestos;
import cfd.ver33.DElementImpuestos;
import java.io.ByteArrayInputStream;
import java.text.DecimalFormat;
import java.util.TreeMap;
import java.util.Vector;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import sa.lib.SLibUtils;
import sa.lib.xml.SXmlUtils;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public abstract class DCfdUtils {
    
    public static final DecimalFormat AmountFormat = new DecimalFormat("#." + SLibUtils.textRepeat("0", SLibUtils.getDecimalFormatAmount().getMaximumFractionDigits()));
    public static final DecimalFormat CfdNumberFormat = new DecimalFormat(SLibUtils.textRepeat("0", DCfdConsts.CFD_NUM_LEN));   // to be used in composing XML file name
    
    /**
     * Clean all XML entites considered in sa.lib.SLibUtils.XmlEntityNamesMap from supplied XML String.
     * @param xml Supplied XML String.
     * @return 
     */
    public static String cleanXmlEntities(final String xml) {
        String text = xml;
        
        for (Character character : SLibUtils.XmlEntityNamesMap.keySet()) {
            text = text.replaceAll(SLibUtils.XmlEntityNamesMap.get(character), "" + character);
        }
        
        return text;
    }

    public static String textForOriginalString(final String text) {
        String textForOriginalString = text;

        textForOriginalString = textForOriginalString.replaceAll("\b", " ");
        textForOriginalString = textForOriginalString.replaceAll("\t", " ");
        textForOriginalString = textForOriginalString.replaceAll("\n", " ");
        textForOriginalString = textForOriginalString.replaceAll("\f", " ");
        textForOriginalString = textForOriginalString.replaceAll("\r", " ");

        return SLibUtils.textTrim(textForOriginalString);
    }

    public static String generateOriginalString(final cfd.DElement rootElement) throws Exception {
        String string = "";
        
        if (rootElement instanceof cfd.ver2.DElementComprobante) {
            string = "||" + rootElement.getElementForOriginalString() + "|";
        }
        else if (rootElement instanceof cfd.ver32.DElementComprobante) {
            string = "||" + rootElement.getElementForOriginalString() + "|";
        }
        else if (rootElement instanceof cfd.ver33.DElementComprobante) {
            string = rootElement.getElementForOriginalString();
        }
        
        return string;
    }
    
    private static cfd.DElement getElementNomina(Node node) throws Exception {
        cfd.DElement elementNomina = null;
        Node nodeChild = null;
        Vector<Node> nodeChilds = null;
        Vector<Node> nodeChildsAux = null;
        NamedNodeMap namedNodeMapChild = null;
        double versionPayroll = 0;
        
        if (SXmlUtils.hasChildElement(node, "nomina:Nomina") || SXmlUtils.hasChildElement(node, "nomina12:Nomina")) {
            if (SXmlUtils.hasChildElement(node, "nomina:Nomina")) {
                node = SXmlUtils.extractChildElements(node, "nomina:Nomina").get(0);
                namedNodeMapChild = node.getAttributes();
            }
            else {
                node = SXmlUtils.extractChildElements(node, "nomina12:Nomina").get(0);
                namedNodeMapChild = node.getAttributes();
            }

            versionPayroll = SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMapChild, "Version", true));

            if (versionPayroll == DCfdVer3Consts.VER_NOM_11) {
                cfd.ver3.nom11.DElementNomina nomina = new cfd.ver3.nom11.DElementNomina();

                nomina.getAttVersion().setString(versionPayroll + "");
                nomina.getAttRegistroPatronal().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "RegistroPatronal", false));
                nomina.getAttNumEmpleado().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "NumEmpleado", true));
                nomina.getAttCurp().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "CURP", true));
                nomina.getAttTipoRegimen().setInteger(SLibUtils.parseInt(SXmlUtils.extractAttributeValue(namedNodeMapChild, "TipoRegimen", true)));
                nomina.getAttNumSeguridadSocial().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "NumSeguridadSocial", false));
                nomina.getAttFechaPago().setDate(SLibUtils.DbmsDateFormatDate.parse(SXmlUtils.extractAttributeValue(namedNodeMapChild, "FechaPago", true)));
                nomina.getAttFechaInicialPago().setDate(SLibUtils.DbmsDateFormatDate.parse(SXmlUtils.extractAttributeValue(namedNodeMapChild, "FechaInicialPago", true)));
                nomina.getAttFechaFinalPago().setDate(SLibUtils.DbmsDateFormatDate.parse(SXmlUtils.extractAttributeValue(namedNodeMapChild, "FechaFinalPago", true)));
                nomina.getAttNumDiasPagados().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMapChild, "NumDiasPagados", true)));
                nomina.getAttDepartamento().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "Departamento", false));
                nomina.getAttClabe().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "CLABE", false));
                nomina.getAttBanco().setInteger(SLibUtils.parseInt(SXmlUtils.extractAttributeValue(namedNodeMapChild, "Banco", false)));
                nomina.getAttFechaInicioRelLaboral().setDate(SLibUtils.DbmsDateFormatDate.parse(SXmlUtils.extractAttributeValue(namedNodeMapChild, "FechaInicioRelLaboral", false)));
                nomina.getAttAntiguedad().setInteger(SLibUtils.parseInt(SXmlUtils.extractAttributeValue(namedNodeMapChild, "Antiguedad", false)));
                nomina.getAttPuesto().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "Puesto", false));
                nomina.getAttTipoContrato().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "TipoContrato", false));
                nomina.getAttTipoJornada().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "TipoJornada", false));
                nomina.getAttPeriodicidadPago().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "PeriodicidadPago", true));
                nomina.getAttSalarioBaseCotApor().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMapChild, "SalarioBaseCotApor", false)));
                nomina.getAttRiesgoPuesto().setInteger(SLibUtils.parseInt(SXmlUtils.extractAttributeValue(namedNodeMapChild, "RiesgoPuesto", false)));
                nomina.getAttSalarioDiarioIntegrado().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMapChild, "SalarioDiarioIntegrado", false)));

                // Perceptions:

                if (SXmlUtils.hasChildElement(node, "nomina:Percepciones")) {
                    cfd.ver3.nom11.DElementPercepciones percepciones = new cfd.ver3.nom11.DElementPercepciones();

                    nodeChild = SXmlUtils.extractChildElements(node, "nomina:Percepciones").get(0);
                    namedNodeMapChild = nodeChild.getAttributes();

                    percepciones.getAttTotalGravado().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMapChild, "TotalGravado", true)));
                    percepciones.getAttTotalExento().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMapChild, "TotalExento", true)));

                    nodeChilds = SXmlUtils.extractChildElements(nodeChild, "nomina:Percepcion");

                    for (int i = 0; i < nodeChilds.size(); i++) {
                        cfd.ver3.nom11.DElementPercepcion percepcion = new cfd.ver3.nom11.DElementPercepcion();

                        nodeChild = nodeChilds.get(i);
                        namedNodeMapChild = nodeChild.getAttributes();

                        percepcion.getAttTipoPercepcion().setInteger(SLibUtils.parseInt(SXmlUtils.extractAttributeValue(namedNodeMapChild, "TipoPercepcion", false)));
                        percepcion.getAttClave().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "Clave", true));
                        percepcion.getAttConcepto().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "Concepto", true));
                        percepcion.getAttImporteGravado().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMapChild, "ImporteGravado", true)));
                        percepcion.getAttImporteExento().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMapChild, "ImporteExento", true)));

                        percepciones.getEltHijosPercepcion().add(percepcion);
                    }
                    nomina.setEltPercepciones(percepciones);
                }

                // Deductions:

                if (SXmlUtils.hasChildElement(node, "nomina:Deducciones")) {
                    cfd.ver3.nom11.DElementDeducciones deducciones = new cfd.ver3.nom11.DElementDeducciones();

                    nodeChild = SXmlUtils.extractChildElements(node, "nomina:Deducciones").get(0);
                    namedNodeMapChild = nodeChild.getAttributes();

                    deducciones.getAttTotalGravado().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMapChild, "TotalGravado", true)));
                    deducciones.getAttTotalExento().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMapChild, "TotalExento", true)));

                    nodeChilds = SXmlUtils.extractChildElements(nodeChild, "nomina:Deduccion");

                    for (int i = 0; i < nodeChilds.size(); i++) {
                        cfd.ver3.nom11.DElementDeduccion deduccion = new cfd.ver3.nom11.DElementDeduccion();

                        nodeChild = nodeChilds.get(i);
                        namedNodeMapChild = nodeChild.getAttributes();

                        deduccion.getAttTipoDeduccion().setInteger(SLibUtils.parseInt(SXmlUtils.extractAttributeValue(namedNodeMapChild, "TipoDeduccion", false)));
                        deduccion.getAttClave().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "Clave", true));
                        deduccion.getAttConcepto().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "Concepto", true));
                        deduccion.getAttImporteGravado().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMapChild, "ImporteGravado", true)));
                        deduccion.getAttImporteExento().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMapChild, "ImporteExento", true)));

                        deducciones.getEltHijosDeduccion().add(deduccion);
                    }
                    nomina.setEltDeducciones(deducciones);
                }

                // Incapacities:

                if (SXmlUtils.hasChildElement(node, "nomina:Incapacidades")) {
                    cfd.ver3.nom11.DElementIncapacidades incapacidades = new cfd.ver3.nom11.DElementIncapacidades();

                    nodeChild = SXmlUtils.extractChildElements(node, "nomina:Incapacidades").get(0);
                    nodeChilds = SXmlUtils.extractChildElements(nodeChild, "nomina:Incapacidad");

                    for (int i = 0; i < nodeChilds.size(); i++) {
                        cfd.ver3.nom11.DElementIncapacidad incapacidad = new cfd.ver3.nom11.DElementIncapacidad();

                        nodeChild = nodeChilds.get(i);
                        namedNodeMapChild = nodeChild.getAttributes();

                        incapacidad.getAttDiasIncapacidad().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMapChild, "DiasIncapacidad", true)));
                        incapacidad.getAttTipoIncapacidad().setInteger(SLibUtils.parseInt(SXmlUtils.extractAttributeValue(namedNodeMapChild, "TipoIncapacidad", false)));
                        incapacidad.getAttDescuento().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMapChild, "Descuento", true)));

                        incapacidades.getEltHijosIncapacidad().add(incapacidad);
                    }
                    nomina.setEltIncapacidades(incapacidades);
                }

                // ExtraTimes:

                if (SXmlUtils.hasChildElement(node, "nomina:HorasExtras")) {
                    cfd.ver3.nom11.DElementHorasExtras horasExtras = new cfd.ver3.nom11.DElementHorasExtras();

                    nodeChild = SXmlUtils.extractChildElements(node, "nomina:HorasExtras").get(0);
                    nodeChilds = SXmlUtils.extractChildElements(nodeChild, "nomina:HorasExtra");

                    for (int i = 0; i < nodeChilds.size(); i++) {
                        cfd.ver3.nom11.DElementHorasExtra horasExtra = new cfd.ver3.nom11.DElementHorasExtra();

                        nodeChild = nodeChilds.get(i);
                        namedNodeMapChild = nodeChild.getAttributes();

                        horasExtra.getAttDias().setInteger(SLibUtils.parseInt(SXmlUtils.extractAttributeValue(namedNodeMapChild, "Dias", true)));
                        horasExtra.getAttTipoHoras().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "TipoHoras", true));
                        horasExtra.getAttHorasExtra().setInteger(SLibUtils.parseInt(SXmlUtils.extractAttributeValue(namedNodeMapChild, "HorasExtra", false)));
                        horasExtra.getAttImportePagado().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMapChild, "ImportePagado", true)));

                        horasExtras.getEltHijosHorasExtra().add(horasExtra);
                    }
                    nomina.setEltHorasExtras(horasExtras);
                }
                elementNomina = nomina;
            }
            else if (versionPayroll == DCfdVer3Consts.VER_NOM_12) {
                cfd.ver3.nom12.DElementNomina nomina = new cfd.ver3.nom12.DElementNomina();

                nomina.getAttVersion().setString(versionPayroll + "");
                nomina.getAttFechaPago().setDate(SLibUtils.DbmsDateFormatDate.parse(SXmlUtils.extractAttributeValue(namedNodeMapChild, "FechaPago", true)));
                nomina.getAttFechaInicialPago().setDate(SLibUtils.DbmsDateFormatDate.parse(SXmlUtils.extractAttributeValue(namedNodeMapChild, "FechaInicialPago", true)));
                nomina.getAttFechaFinalPago().setDate(SLibUtils.DbmsDateFormatDate.parse(SXmlUtils.extractAttributeValue(namedNodeMapChild, "FechaFinalPago", true)));
                nomina.getAttNumDiasPagados().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMapChild, "NumDiasPagados", true)));

                // Emisor:

                if (SXmlUtils.hasChildElement(node, "nomina12:Emisor")) {
                    cfd.ver3.nom12.DElementEmisor emisor = new cfd.ver3.nom12.DElementEmisor();

                    nodeChild = SXmlUtils.extractChildElements(node, "nomina12:Emisor").get(0);
                    namedNodeMapChild = nodeChild.getAttributes();

                    emisor.getAttRegistroPatronal().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "RegistroPatronal", false));

                    nomina.setEltEmisor(emisor);
                }

                // Receptor:
                String dateInicioLab = "";


                if (SXmlUtils.hasChildElement(node, "nomina12:Receptor")) {
                    cfd.ver3.nom12.DElementReceptor receptor = new cfd.ver3.nom12.DElementReceptor();

                    nodeChild = SXmlUtils.extractChildElements(node, "nomina12:Receptor").get(0);
                    namedNodeMapChild = nodeChild.getAttributes();

                    receptor.getAttCurp().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "Curp", true));
                    receptor.getAttNumSeguridadSocial().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "NumSeguridadSocial", false));

                    dateInicioLab = SXmlUtils.extractAttributeValue(namedNodeMapChild, "FechaInicioRelLaboral", false);

                    if (!dateInicioLab.isEmpty()) {
                        receptor.getAttFechaInicioRelLaboral().setDate(SLibUtils.DbmsDateFormatDate.parse(dateInicioLab));
                    }
                    receptor.getAttAntiguedad().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "Antigüedad", false));
                    receptor.getAttTipoContrato().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "TipoContrato", true));
                    receptor.getAttSindicalizado().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "Sindicalizado", false));
                    receptor.getAttTipoJornada().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "TipoJornada", false));
                    receptor.getAttTipoRegimen().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "TipoRegimen", true));
                    receptor.getAttNumEmpleado().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "NumEmpleado", true));
                    receptor.getAttDepartamento().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "Departamento", false));
                    receptor.getAttPuesto().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "Puesto", false));
                    receptor.getAttRiesgoPuesto().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "RiesgoPuesto", false));
                    receptor.getAttPeriodicidadPago().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "PeriodicidadPago", true));
                    receptor.getAttBanco().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "Banco", false));
                    receptor.getAttCuentaBancaria().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "CuentaBancaria", false));
                    receptor.getAttSalarioBaseCotApor().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMapChild, "SalarioBaseCotApor", false)));
                    receptor.getAttSalarioDiarioIntegrado().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMapChild, "SalarioDiarioIntegrado", false)));
                    receptor.getAttClaveEntFed().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "ClaveEntFed", true));

                    nomina.setEltReceptor(receptor);
                }

                // Perceptions:

                if (SXmlUtils.hasChildElement(node, "nomina12:Percepciones")) {
                    cfd.ver3.nom12.DElementPercepciones percepciones = new cfd.ver3.nom12.DElementPercepciones();

                    nodeChild = SXmlUtils.extractChildElements(node, "nomina12:Percepciones").get(0);
                    namedNodeMapChild = nodeChild.getAttributes();

                    percepciones.getAttTotalGravado().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMapChild, "TotalGravado", false)));
                    percepciones.getAttTotalExento().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMapChild, "TotalExento", false)));

                    nodeChilds = SXmlUtils.extractChildElements(nodeChild, "nomina12:Percepcion");

                    for (int i = 0; i < nodeChilds.size(); i++) {
                        cfd.ver3.nom12.DElementPercepcion percepcion = new cfd.ver3.nom12.DElementPercepcion();

                        nodeChild = nodeChilds.get(i);
                        namedNodeMapChild = nodeChild.getAttributes();

                        percepcion.getAttTipoPercepcion().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "TipoPercepcion", true));
                        percepcion.getAttClave().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "Clave", true));
                        percepcion.getAttConcepto().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "Concepto", true));
                        percepcion.getAttImporteGravado().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMapChild, "ImporteGravado", true)));
                        percepcion.getAttImporteExento().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMapChild, "ImporteExento", true)));

                        // ExtraTimes:

                        if (SXmlUtils.hasChildElement(nodeChild, "nomina12:HorasExtra")) {
                            nodeChildsAux = SXmlUtils.extractChildElements(nodeChild, "nomina12:HorasExtra");

                            for (int overTime = 0; overTime < nodeChildsAux.size(); overTime++) {
                                cfd.ver3.nom12.DElementHorasExtra horasExtra = new cfd.ver3.nom12.DElementHorasExtra();

                                nodeChild = nodeChildsAux.get(overTime);
                                namedNodeMapChild = nodeChild.getAttributes();

                                horasExtra.getAttDias().setInteger(SLibUtils.parseInt(SXmlUtils.extractAttributeValue(namedNodeMapChild, "Dias", true)));
                                horasExtra.getAttTipoHoras().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "TipoHoras", true));
                                horasExtra.getAttHorasExtra().setInteger(SLibUtils.parseInt(SXmlUtils.extractAttributeValue(namedNodeMapChild, "HorasExtra", true)));
                                horasExtra.getAttImportePagado().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMapChild, "ImportePagado", true)));

                                percepcion.getEltHijosHorasExtra().add(horasExtra);
                            }
                        }
                        percepciones.getEltHijosPercepcion().add(percepcion);

                    }
                    nomina.setEltPercepciones(percepciones);
                }

                // Other payments:

                if (SXmlUtils.hasChildElement(node, "nomina12:OtrosPagos")) {
                    cfd.ver3.nom12.DElementOtrosPagos otrosPagos = new cfd.ver3.nom12.DElementOtrosPagos();

                    nodeChild = SXmlUtils.extractChildElements(node, "nomina12:OtrosPagos").get(0);

                    nodeChilds = SXmlUtils.extractChildElements(nodeChild, "nomina12:OtroPago");

                    for (int i = 0; i < nodeChilds.size(); i++) {
                        cfd.ver3.nom12.DElementOtroPago otroPago = new cfd.ver3.nom12.DElementOtroPago();

                        nodeChild = nodeChilds.get(i);
                        namedNodeMapChild = nodeChild.getAttributes();

                        otroPago.getAttTipoOtroPago().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "TipoOtroPago", true));
                        otroPago.getAttClave().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "Clave", true));
                        otroPago.getAttConcepto().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "Concepto", true));
                        otroPago.getAttImporte().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMapChild, "Importe", true)));

                        if (SXmlUtils.hasChildElement(node, "nomina12:SubsidioAlEmpleo")) {
                            nodeChildsAux = SXmlUtils.extractChildElements(nodeChild, "nomina12:SubsidioAlEmpleo");

                            for (int sub = 0; sub < nodeChildsAux.size(); sub++) {
                                cfd.ver3.nom12.DElementSubsidioEmpleo subsidio = new cfd.ver3.nom12.DElementSubsidioEmpleo();

                                nodeChild = nodeChildsAux.get(sub);
                                namedNodeMapChild = nodeChild.getAttributes();

                                subsidio.getAttSubsidioCausado().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMapChild, "SubsidioCausado", true)));

                                otroPago.setEltSubsidioEmpleo(subsidio);
                            }
                        }

                        otrosPagos.getEltHijosOtroPago().add(otroPago);
                    }
                    nomina.setEltOtrosPagos(otrosPagos);
                }

                // Deductions:

                if (SXmlUtils.hasChildElement(node, "nomina12:Deducciones")) {
                    cfd.ver3.nom12.DElementDeducciones deducciones = new cfd.ver3.nom12.DElementDeducciones();

                    nodeChild = SXmlUtils.extractChildElements(node, "nomina12:Deducciones").get(0);
                    namedNodeMapChild = nodeChild.getAttributes();

                    deducciones.getAttTotalImpuestosRetenidos().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMapChild, "TotalImpuestosRetenidos", false)));
                    deducciones.getAttTotalOtrasDeducciones().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMapChild, "TotalOtrasDeducciones", false)));

                    nodeChilds = SXmlUtils.extractChildElements(nodeChild, "nomina12:Deduccion");

                    for (int i = 0; i < nodeChilds.size(); i++) {
                        cfd.ver3.nom12.DElementDeduccion deduccion = new cfd.ver3.nom12.DElementDeduccion();

                        nodeChild = nodeChilds.get(i);
                        namedNodeMapChild = nodeChild.getAttributes();

                        deduccion.getAttTipoDeduccion().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "TipoDeduccion", true));
                        deduccion.getAttClave().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "Clave", true));
                        deduccion.getAttConcepto().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "Concepto", true));
                        deduccion.getAttImporte().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMapChild, "Importe", true)));

                        deducciones.getEltHijosDeduccion().add(deduccion);
                    }
                    nomina.setEltDeducciones(deducciones);
                }

                // Incapacities:

                if (SXmlUtils.hasChildElement(node, "nomina12:Incapacidades")) {
                    cfd.ver3.nom12.DElementIncapacidades incapacidades = new cfd.ver3.nom12.DElementIncapacidades();

                    nodeChild = SXmlUtils.extractChildElements(node, "nomina12:Incapacidades").get(0);
                    nodeChilds = SXmlUtils.extractChildElements(nodeChild, "nomina12:Incapacidad");

                    for (int i = 0; i < nodeChilds.size(); i++) {
                        cfd.ver3.nom12.DElementIncapacidad incapacidad = new cfd.ver3.nom12.DElementIncapacidad();

                        nodeChild = nodeChilds.get(i);
                        namedNodeMapChild = nodeChild.getAttributes();

                        incapacidad.getAttDiasIncapacidad().setInteger(SLibUtils.parseInt(SXmlUtils.extractAttributeValue(namedNodeMapChild, "DiasIncapacidad", true)));
                        incapacidad.getAttTipoIncapacidad().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "TipoIncapacidad", true));
                        incapacidad.getAttImporteMonetario().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMapChild, "ImporteMonetario", true)));

                        incapacidades.getEltHijosIncapacidad().add(incapacidad);
                    }
                    nomina.setEltIncapacidades(incapacidades);
                }
                elementNomina = nomina;
            }
        }
        
        return elementNomina;
    }

    private static cfd.ver3.DElementAddenda getElementAddendaWithAddenda1(Node node) throws Exception {
        cfd.ver3.DElementAddenda addenda = null;
        Node nodeChild = null;
        Vector<Node> nodeChilds = null;
        NamedNodeMap namedNodeMapChild = null;
        TreeMap<Integer, String> moOptions = null;
        
        if (SXmlUtils.hasChildElement(node, "myadd:Addenda1")) {
            node = SXmlUtils.extractChildElements(node, "myadd:Addenda1").get(0);

            cfd.ext.addenda1.DElementAddenda1 addenda1 = new cfd.ext.addenda1.DElementAddenda1();

            nodeChild = SXmlUtils.extractChildElements(node, "myadd:Moneda").get(0);
            namedNodeMapChild = nodeChild.getAttributes();

            moOptions = addenda1.getEltMoneda().getAttClaveMoneda().moOptions;

            for (int j = 0; j < moOptions.size(); j++) {
                if (((String) moOptions.values().toArray()[j]).compareTo(SXmlUtils.extractAttributeValue(namedNodeMapChild, "claveMoneda", true)) == 0) {
                    addenda1.getEltMoneda().getAttClaveMoneda().setOption((Integer) moOptions.keySet().toArray()[j]);
                }
            }

            addenda1.getEltMoneda().getAttTipoDeCambio().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMapChild, "tipoDeCambio", true)));

            nodeChild = SXmlUtils.extractChildElements(node, "myadd:Adicional").get(0);
            namedNodeMapChild = nodeChild.getAttributes();

            addenda1.getEltAdicional().getAttDiasDeCredito().setInteger(SLibUtils.parseInt(SXmlUtils.extractAttributeValue(namedNodeMapChild, "diasDeCredito", false)));
            addenda1.getEltAdicional().getAttEmbarque().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "embarque", false));
            addenda1.getEltAdicional().getAttOrdenDeEmbarque().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "ordenDeEmbarque", false));
            addenda1.getEltAdicional().getAttOrdenDeCompra().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "ordenDeCompra", false));
            addenda1.getEltAdicional().getAttContrato().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "contrato", false));
            addenda1.getEltAdicional().getAttPedido().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "pedido", false));
            addenda1.getEltAdicional().getAttFactura().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "factura", false));
            addenda1.getEltAdicional().getAttCliente().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "cliente", false));
            addenda1.getEltAdicional().getAttSucursal().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "sucursal", false));
            addenda1.getEltAdicional().getAttAgente().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "agente", false));
            addenda1.getEltAdicional().getAttRuta().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "ruta", false));
            addenda1.getEltAdicional().getAttChofer().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "chofer", false));
            addenda1.getEltAdicional().getAttPlacas().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "placas", false));
            addenda1.getEltAdicional().getAttBoleto().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "boleto", false));
            addenda1.getEltAdicional().getAttPesoBruto().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMapChild, "pesoBruto", false)));
            addenda1.getEltAdicional().getAttPesoNeto().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMapChild, "pesoNeto", false)));
            addenda1.getEltAdicional().getAttUnidadPesoBruto().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "unidadPesoBruto", false));
            addenda1.getEltAdicional().getAttUnidadPesoNeto().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "unidadPesoNeto", false));

            if (SXmlUtils.hasChildElement(node, "myadd:Pagare")) {
                cfd.ext.addenda1.DElementPagare pagare = new cfd.ext.addenda1.DElementPagare();

                nodeChild = SXmlUtils.extractChildElements(node, "myadd:Pagare").get(0);
                namedNodeMapChild = nodeChild.getAttributes();

                pagare.getAttFecha().setDate(SLibUtils.DbmsDateFormatDate.parse(SXmlUtils.extractAttributeValue(namedNodeMapChild, "fecha", true)));
                pagare.getAttFechaDeVencimiento().setDate(SLibUtils.DbmsDateFormatDate.parse(SXmlUtils.extractAttributeValue(namedNodeMapChild, "fechaDeVencimiento", true)));
                pagare.getAttImporte().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMapChild, "importe", true)));
                pagare.getAttClaveMoneda().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "claveMoneda", false));
                pagare.getAttInteresMoratorio().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMapChild, "interesMoratorio", true)));

                addenda1.setEltOpcPagare(pagare);
            }

            if (SXmlUtils.hasChildElement(node, "myadd:AdicionalConceptos")) {
                nodeChild = SXmlUtils.extractChildElements(node, "myadd:AdicionalConceptos").get(0);
                nodeChilds = SXmlUtils.extractChildElements(nodeChild, "myadd:AdicionalConcepto");

                for (int i = 0; i < nodeChilds.size(); i++) {
                    cfd.ext.addenda1.DElementAdicionalConcepto concepto = new cfd.ext.addenda1.DElementAdicionalConcepto();

                    nodeChild = nodeChilds.get(i);
                    namedNodeMapChild = nodeChild.getAttributes();

                    concepto.getAttClaveConcepto().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "claveConcepto", true));
                    concepto.getAttPresentacion().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "presentacion", false));
                    concepto.getAttDescuentoUnitario().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMapChild, "descuentoUnitario", false)));
                    concepto.getAttDescuento().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMapChild, "descuento", false)));
                    concepto.getAttPesoBruto().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMapChild, "pesoBruto", false)));
                    concepto.getAttPesoNeto().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMapChild, "pesoNeto", false)));

                    addenda1.getEltAdicional().getEltAdicionalConceptos().getEltHijosAdicionalConcepto().add(concepto);
                }
            }

            addenda = new cfd.ver3.DElementAddenda();
            addenda.getElements().add(addenda1);
        }
        
        return addenda;
    }

    public static cfd.ver2.DElementComprobante getCfd(String xml) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static cfd.ver32.DElementComprobante getCfdi32(String xml) throws Exception {
        double dTotalImptoRetenido = 0;
        double dTotalImptoTrasladado = 0;
        DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = docBuilder.parse(new ByteArrayInputStream(xml.getBytes("UTF-8")));
        Node node = null;
        Node nodeChild = null;
        Vector<Node> nodeChilds = null;
        Vector<Node> nodeChildsAduanera = null;
        Vector<Node> nodeChildsParte = null;
        NamedNodeMap namedNodeMap = null;
        NamedNodeMap namedNodeMapChild = null;
        TreeMap<Integer, String> moOptions = null;

        cfd.ver32.DElementComprobante comprobante = new cfd.ver32.DElementComprobante();

        // Comprobante:

        node = SXmlUtils.extractElements(doc, "cfdi:Comprobante").item(0);
        namedNodeMap = node.getAttributes();

        comprobante.getAttVersion().setString(SXmlUtils.extractAttributeValue(namedNodeMap, "version", true));
        comprobante.getAttSerie().setString(SXmlUtils.extractAttributeValue(namedNodeMap, "serie", false));
        comprobante.getAttFolio().setString(SXmlUtils.extractAttributeValue(namedNodeMap, "folio", true));
        comprobante.getAttFecha().setDatetime(SLibUtils.DbmsDateFormatDatetime.parse(SXmlUtils.extractAttributeValue(namedNodeMap, "fecha", true).replaceAll("T", " ")));
        comprobante.getAttSello().setString(SXmlUtils.extractAttributeValue(namedNodeMap, "sello", true));
        comprobante.getAttNoCertificado().setString(SXmlUtils.extractAttributeValue(namedNodeMap, "noCertificado", true));
        comprobante.getAttCertificado().setString(SXmlUtils.extractAttributeValue(namedNodeMap, "certificado", false));

        moOptions = comprobante.getAttFormaDePago().moOptions;

        for (int i = 0; i < moOptions.size(); i++) {
            if (((String) moOptions.values().toArray()[i]).compareTo(SXmlUtils.extractAttributeValue(namedNodeMap, "formaDePago", true)) == 0) {
                comprobante.getAttFormaDePago().setOption((Integer) moOptions.keySet().toArray()[i]);
                break;
            }
        }

        moOptions = comprobante.getAttCondicionesDePago().moOptions;

        for (int i = 0; i < moOptions.size(); i++) {
            if (((String) moOptions.values().toArray()[i]).compareTo(SXmlUtils.extractAttributeValue(namedNodeMap, "condicionesDePago", false)) == 0) {
                comprobante.getAttCondicionesDePago().setOption((Integer) moOptions.keySet().toArray()[i]);
                break;
            }
        }

        comprobante.getAttSubTotal().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMap, "subTotal", true)));
        comprobante.getAttDescuento().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMap, "descuento", false)));
        comprobante.getAttMotivoDescuento().setString(SXmlUtils.extractAttributeValue(namedNodeMap, "motivoDescuento", false));
        comprobante.getAttTipoCambio().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMap, "TipoCambio", false)));
        comprobante.getAttMoneda().setString(SXmlUtils.extractAttributeValue(namedNodeMap, "Moneda", false));
        comprobante.getAttTotal().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMap, "total", true)));

        comprobante.getAttMetodoDePago().setString(SXmlUtils.extractAttributeValue(namedNodeMap, "metodoDePago", false));

        comprobante.getAttLugarExpedicion().setString(SXmlUtils.extractAttributeValue(namedNodeMap, "LugarExpedicion", true));

        moOptions = comprobante.getAttTipoDeComprobante().moOptions;

        for (int i = 0; i < moOptions.size(); i++) {
            if (((String) moOptions.values().toArray()[i]).compareTo(SXmlUtils.extractAttributeValue(namedNodeMap, "tipoDeComprobante", true)) == 0) {
                comprobante.getAttTipoDeComprobante().setOption((Integer) moOptions.keySet().toArray()[i]);
                break;
            }
        }

        comprobante.getAttNumCtaPago().setString(SXmlUtils.extractAttributeValue(namedNodeMap, "NumCtaPago", false));
        comprobante.getAttFolioFiscalOrig().setString(SXmlUtils.extractAttributeValue(namedNodeMap, "FolioFiscalOrig", false));
        comprobante.getAttSerieFolioFiscalOrig().setString(SXmlUtils.extractAttributeValue(namedNodeMap, "SerieFolioFiscalOrig", false));
        comprobante.getAttFechaFolioFiscalOrig().setString(SXmlUtils.extractAttributeValue(namedNodeMap, "FechaFolioFiscalOrig", false));
        comprobante.getAttMontoFolioFiscalOrig().setString(SXmlUtils.extractAttributeValue(namedNodeMap, "MontoFolioFiscalOrig", false));

        // Emisor:

        node = SXmlUtils.extractElements(doc, "cfdi:Emisor").item(0);
        namedNodeMap = node.getAttributes();

        comprobante.getEltEmisor().getAttRfc().setString(SXmlUtils.extractAttributeValue(namedNodeMap, "rfc", true));
        comprobante.getEltEmisor().getAttNombre().setString(SXmlUtils.extractAttributeValue(namedNodeMap, "nombre", true));

        if (SXmlUtils.hasChildElement(node, "cfdi:DomicilioFiscal")) {
            nodeChild = SXmlUtils.extractChildElements(node, "cfdi:DomicilioFiscal").get(0);
            namedNodeMapChild = nodeChild.getAttributes();

            comprobante.getEltEmisor().getEltDomicilioFiscal().getAttCalle().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "calle", true));
            comprobante.getEltEmisor().getEltDomicilioFiscal().getAttNoExterior().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "noExterior", false));
            comprobante.getEltEmisor().getEltDomicilioFiscal().getAttNoInterior().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "noInterior", false));
            comprobante.getEltEmisor().getEltDomicilioFiscal().getAttColonia().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "colonia", false));
            comprobante.getEltEmisor().getEltDomicilioFiscal().getAttLocalidad().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "localidad", false));
            comprobante.getEltEmisor().getEltDomicilioFiscal().getAttReferencia().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "referencia", false));
            comprobante.getEltEmisor().getEltDomicilioFiscal().getAttMunicipio().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "municipio", true));
            comprobante.getEltEmisor().getEltDomicilioFiscal().getAttEstado().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "estado", true));
            comprobante.getEltEmisor().getEltDomicilioFiscal().getAttPais().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "pais", true));
            comprobante.getEltEmisor().getEltDomicilioFiscal().getAttCodigoPostal().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "codigoPostal", true));
        }
        
        if (SXmlUtils.hasChildElement(node, "cfdi:RegimenFiscal")) {
            nodeChild = SXmlUtils.extractChildElements(node, "cfdi:RegimenFiscal").get(0);
            namedNodeMapChild = nodeChild.getAttributes();
        }

        if (SXmlUtils.extractAttributeValue(namedNodeMapChild, "Regimen", false).length() > 0) {
            cfd.ver32.DElementRegimenFiscal regimen = new cfd.ver32.DElementRegimenFiscal();

            regimen.getAttRegimen().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "Regimen", true));

            comprobante.getEltEmisor().getEltHijosRegimenFiscal().add(regimen);
        }

        if (SXmlUtils.hasChildElement(node, "cfdi:ExpedidoEn")) {
            nodeChild = SXmlUtils.extractChildElements(node, "cfdi:ExpedidoEn").get(0);
            namedNodeMapChild = nodeChild.getAttributes();

            cfd.ver32.DElementTipoUbicacion expedidoEn = new cfd.ver32.DElementTipoUbicacion("cfdi:ExpedidoEn");

            expedidoEn.getAttCalle().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "calle", false));
            expedidoEn.getAttNoExterior().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "noExterior", false));
            expedidoEn.getAttNoInterior().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "noInterior", false));
            expedidoEn.getAttColonia().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "colonia", false));
            expedidoEn.getAttLocalidad().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "localidad", false));
            expedidoEn.getAttReferencia().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "referencia", false));
            expedidoEn.getAttMunicipio().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "municipio", false));
            expedidoEn.getAttEstado().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "estado", false));
            expedidoEn.getAttPais().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "pais", true));
            expedidoEn.getAttCodigoPostal().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "codigoPostal", false));

            comprobante.getEltEmisor().setEltOpcExpedidoEn(expedidoEn);
        }

        // Receptor:

        node = SXmlUtils.extractElements(doc, "cfdi:Receptor").item(0);
        namedNodeMap = node.getAttributes();

        comprobante.getEltReceptor().getAttRfc().setString(SXmlUtils.extractAttributeValue(namedNodeMap, "rfc", true));
        comprobante.getEltReceptor().getAttNombre().setString(SXmlUtils.extractAttributeValue(namedNodeMap, "nombre", true));

        if (SXmlUtils.hasChildElement(node, "cfdi:Domicilio")) {
            nodeChild = SXmlUtils.extractChildElements(node, "cfdi:Domicilio").get(0);
            namedNodeMapChild = nodeChild.getAttributes();

            comprobante.getEltReceptor().getEltDomicilio().getAttCalle().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "calle", false));
            comprobante.getEltReceptor().getEltDomicilio().getAttNoExterior().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "noExterior", false));
            comprobante.getEltReceptor().getEltDomicilio().getAttNoInterior().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "noInterior", false));
            comprobante.getEltReceptor().getEltDomicilio().getAttColonia().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "colonia", false));
            comprobante.getEltReceptor().getEltDomicilio().getAttLocalidad().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "localidad", false));
            comprobante.getEltReceptor().getEltDomicilio().getAttReferencia().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "referencia", false));
            comprobante.getEltReceptor().getEltDomicilio().getAttMunicipio().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "municipio", false));
            comprobante.getEltReceptor().getEltDomicilio().getAttEstado().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "estado", false));
            comprobante.getEltReceptor().getEltDomicilio().getAttPais().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "pais", true));
            comprobante.getEltReceptor().getEltDomicilio().getAttCodigoPostal().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "codigoPostal", false));
        }

        // Concepts:

        node = SXmlUtils.extractElements(doc, "cfdi:Conceptos").item(0);
        nodeChilds = SXmlUtils.extractChildElements(node, "cfdi:Concepto");

        for (int i = 0; i < nodeChilds.size(); i++) {
            cfd.ver32.DElementConcepto concepto = new cfd.ver32.DElementConcepto();

            nodeChild = nodeChilds.get(i);
            namedNodeMapChild = nodeChild.getAttributes();

            concepto.getAttCantidad().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMapChild, "cantidad", true)));
            concepto.getAttUnidad().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "unidad", true));
            concepto.getAttNoIdentificacion().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "noIdentificacion", false));
            concepto.getAttDescripcion().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "descripcion", true));
            concepto.getAttValorUnitario().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMapChild, "valorUnitario", true)));
            concepto.getAttImporte().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMapChild, "importe", true)));

            if (SXmlUtils.hasChildElement(node, "cfdi:InformacionAduanera")) {
                nodeChildsAduanera = SXmlUtils.extractChildElements(nodeChild, "cfdi:InformacionAduanera");

                for (int j = 0; j < nodeChildsAduanera.size(); j++) {
                    cfd.ver32.DElementInformacionAduanera aduanera = new cfd.ver32.DElementInformacionAduanera();

                    nodeChild = nodeChildsAduanera.get(j);
                    namedNodeMapChild = nodeChild.getAttributes();

                    aduanera.getAttNumero().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "numero", true));
                    aduanera.getAttFecha().setDate(SLibUtils.DbmsDateFormatDate.parse(SXmlUtils.extractAttributeValue(namedNodeMapChild, "fecha", true)));
                    aduanera.getAttAduana().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "aduana", false));

                    concepto.getEltHijosInformacionAduanera().add(aduanera);
                }
            }

            nodeChild = nodeChilds.get(i);
            if (SXmlUtils.hasChildElement(node, "cfdi:Parte")) {
                nodeChildsParte = SXmlUtils.extractChildElements(nodeChild, "cfdi:Parte");

                for (int j = 0; j < nodeChildsParte.size(); j++) {
                    cfd.ver32.DElementParte parte = new cfd.ver32.DElementParte();

                    nodeChild = nodeChildsParte.get(j);
                    namedNodeMapChild = nodeChild.getAttributes();

                    parte.getAttCantidad().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMapChild, "cantidad", true)));
                    parte.getAttUnidad().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "unidad", false));
                    parte.getAttNoIdentificacion().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "noIdentificacion", false));
                    parte.getAttDescripcion().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "descripcion", true));
                    parte.getAttValorUnitario().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMapChild, "valorUnitario", false)));
                    parte.getAttImporte().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMapChild, "importe", false)));

                    nodeChildsAduanera = SXmlUtils.extractChildElements(nodeChild, "cfdi:InformacionAduanera");

                    for (int k = 0; k < nodeChildsAduanera.size(); k++) {
                        cfd.ver32.DElementInformacionAduanera aduanera = new cfd.ver32.DElementInformacionAduanera();

                        nodeChild = nodeChildsAduanera.get(k);
                        namedNodeMapChild = nodeChild.getAttributes();

                        aduanera.getAttNumero().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "numero", true));
                        aduanera.getAttFecha().setDate(SLibUtils.DbmsDateFormatDate.parse(SXmlUtils.extractAttributeValue(namedNodeMapChild, "fecha", true)));
                        aduanera.getAttAduana().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "aduana", false));

                        parte.getEltHijosInformacionAduanera().add(aduanera);
                    }

                    concepto.getEltHijosParte().add(parte);
                }
            }

            nodeChild = nodeChilds.get(i);
            if (SXmlUtils.hasChildElement(nodeChild, "cfdi:CuentaPredial")) {
                cfd.ver32.DElementCuentaPredial predial = new cfd.ver32.DElementCuentaPredial();

                nodeChild = SXmlUtils.extractChildElements(nodeChild, "cfdi:CuentaPredial").get(0);
                namedNodeMapChild = nodeChild.getAttributes();

                predial.getAttNumero().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "numero", true));

                concepto.setEltOpcCuentaPredial(predial);
            }
            comprobante.getEltConceptos().getEltHijosConcepto().add(concepto);
        }

        // Tax:

        node = SXmlUtils.extractElements(doc, "cfdi:Impuestos").item(0);

        cfd.ver32.DElementImpuestosRetenidos retenidos = new cfd.ver32.DElementImpuestosRetenidos();
        cfd.ver32.DElementImpuestosTrasladados trasladados = new cfd.ver32.DElementImpuestosTrasladados();

        if (SXmlUtils.hasChildElement(node, "cfdi:Retenciones")) {
            nodeChild = SXmlUtils.extractChildElements(node, "cfdi:Retenciones").get(0);
            nodeChilds = SXmlUtils.extractChildElements(nodeChild, "cfdi:Retencion");

            for (int i = 0; i < nodeChilds.size(); i++) {
                cfd.ver32.DElementImpuestoRetencion retencion = new cfd.ver32.DElementImpuestoRetencion();

                nodeChild = nodeChilds.get(i);
                namedNodeMapChild = nodeChild.getAttributes();

                moOptions = retencion.getAttImpuesto().moOptions;

                for (int j = 0; j < moOptions.size(); j++) {
                    if (((String) moOptions.values().toArray()[j]).compareTo(SXmlUtils.extractAttributeValue(namedNodeMapChild, "impuesto", true)) == 0) {
                        retencion.getAttImpuesto().setOption((Integer) moOptions.keySet().toArray()[j]);
                    }
                }

                dTotalImptoRetenido += SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMapChild, "importe", true));
                retencion.getAttImporte().setDouble(dTotalImptoRetenido);

                retenidos.getEltHijosImpuestoRetenido().add(retencion);
            }
        }

        if (SXmlUtils.hasChildElement(node, "cfdi:Traslados")) {
            nodeChild = SXmlUtils.extractChildElements(node, "cfdi:Traslados").get(0);
            nodeChilds = SXmlUtils.extractChildElements(nodeChild, "cfdi:Traslado");

            for (int i = 0; i < nodeChilds.size(); i++) {
                cfd.ver32.DElementImpuestoTraslado traslado = new cfd.ver32.DElementImpuestoTraslado();

                nodeChild = nodeChilds.get(i);
                namedNodeMapChild = nodeChild.getAttributes();

                moOptions = traslado.getAttImpuesto().moOptions;

                for (int j = 0; j < moOptions.size(); j++) {
                    if (((String) moOptions.values().toArray()[j]).compareTo(SXmlUtils.extractAttributeValue(namedNodeMapChild, "impuesto", true)) == 0) {
                        traslado.getAttImpuesto().setOption((Integer) moOptions.keySet().toArray()[j]);
                    }
                }

                traslado.getAttTasa().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMapChild, "tasa", true)));
                dTotalImptoTrasladado += SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMapChild, "importe", true));
                traslado.getAttImporte().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMapChild, "importe", true)));

                trasladados.getEltHijosImpuestoTrasladado().add(traslado);
            }
        }

        if (retenidos.getEltHijosImpuestoRetenido().size() > 0) {
            comprobante.getEltImpuestos().getAttTotalImpuestosRetenidos().setDouble(dTotalImptoRetenido);
            comprobante.getEltImpuestos().setEltOpcImpuestosRetenidos(retenidos);
        }

        if (trasladados.getEltHijosImpuestoTrasladado().size() > 0) {
            comprobante.getEltImpuestos().getAttTotalImpuestosTrasladados().setDouble(dTotalImptoTrasladado);
            comprobante.getEltImpuestos().setEltOpcImpuestosTrasladados(trasladados);
        }

        // Child elements of element 'cfdi:Complemento':

        cfd.ver32.DElementComplemento complemento = new cfd.ver32.DElementComplemento();

        node = SXmlUtils.extractElements(doc, "cfdi:Complemento").item(0);

        if (node != null) {
            // Digital signature:
            
            if (SXmlUtils.hasChildElement(node, "tfd:TimbreFiscalDigital")) {
                cfd.ver32.DElementTimbreFiscalDigital tfd = new cfd.ver32.DElementTimbreFiscalDigital();

                nodeChild = SXmlUtils.extractChildElements(node, "tfd:TimbreFiscalDigital").get(0);
                namedNodeMapChild = nodeChild.getAttributes();

                tfd.getAttVersion().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "version", true));
                tfd.getAttUUID().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "UUID", true));
                tfd.getAttFechaTimbrado().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "FechaTimbrado", true));
                tfd.getAttSelloCFD().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "selloCFD", true));
                tfd.getAttNoCertificadoSAT().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "noCertificadoSAT", true));
                tfd.getAttSelloSAT().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "selloSAT", true));

                complemento.getElements().add(tfd);
            }
            
            // Payroll:
            
            if (SXmlUtils.hasChildElement(node, "nomina:Nomina") || SXmlUtils.hasChildElement(node, "nomina12:Nomina")) {
                complemento.getElements().add(getElementNomina(node));
            }
        }

        if (complemento.getElements().size() > 0) {
            comprobante.setEltOpcComplemento(complemento);
        }

        // Addenda:
        
        node = SXmlUtils.extractElements(doc, "cfdi:Addenda").item(0);  // note that it is assumed that allways exists an addenda node!

        if (node != null) {
            cfd.ver3.DElementAddenda addenda = getElementAddendaWithAddenda1(node);
            
            comprobante.setEltOpcAddenda(addenda);
        }

        return comprobante;
    }

    public static cfd.ver33.DElementComprobante getCfdi33(String xml) throws Exception {
        // Comprobante:

        Document doc = SXmlUtils.parseDocument(xml);
        Node nodeComprobante = SXmlUtils.extractElements(doc, "cfdi:Comprobante").item(0);
        NamedNodeMap nodeComprobanteMap = nodeComprobante.getAttributes();

        cfd.ver33.DElementComprobante comprobante = new cfd.ver33.DElementComprobante();
        comprobante.getAttSerie().setString(SXmlUtils.extractAttributeValue(nodeComprobanteMap, "Serie", false));
        comprobante.getAttFolio().setString(SXmlUtils.extractAttributeValue(nodeComprobanteMap, "Folio", false));
        comprobante.getAttFecha().setDatetime(SLibUtils.DbmsDateFormatDatetime.parse(SXmlUtils.extractAttributeValue(nodeComprobanteMap, "Fecha", true).replaceAll("T", " ")));
        comprobante.getAttSello().setString(SXmlUtils.extractAttributeValue(nodeComprobanteMap, "Sello", true));
        comprobante.getAttFormaPago().setString(SXmlUtils.extractAttributeValue(nodeComprobanteMap, "FormaPago", false));
        comprobante.getAttNoCertificado().setString(SXmlUtils.extractAttributeValue(nodeComprobanteMap, "NoCertificado", true));
        comprobante.getAttCertificado().setString(SXmlUtils.extractAttributeValue(nodeComprobanteMap, "Certificado", true));
        comprobante.getAttCondicionesDePago().setString(SXmlUtils.extractAttributeValue(nodeComprobanteMap, "CondicionesDePago", false));
        comprobante.getAttSubTotal().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(nodeComprobanteMap, "SubTotal", true)));
        comprobante.getAttDescuento().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(nodeComprobanteMap, "Descuento", false)));
        comprobante.getAttMoneda().setString(SXmlUtils.extractAttributeValue(nodeComprobanteMap, "Moneda", false));
        comprobante.getAttTipoCambio().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(nodeComprobanteMap, "TipoCambio", false)));
        comprobante.getAttTotal().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(nodeComprobanteMap, "Total", true)));
        comprobante.getAttTipoDeComprobante().setString(SXmlUtils.extractAttributeValue(nodeComprobanteMap, "TipoDeComprobante", true));
        comprobante.getAttMetodoPago().setString(SXmlUtils.extractAttributeValue(nodeComprobanteMap, "MetodoPago", false));
        comprobante.getAttLugarExpedicion().setString(SXmlUtils.extractAttributeValue(nodeComprobanteMap, "LugarExpedicion", true));
        comprobante.getAttConfirmacion().setString(SXmlUtils.extractAttributeValue(nodeComprobanteMap, "Confirmacion", false));

        // CFDI Related:
    
        if (SXmlUtils.hasChildElement(nodeComprobante, "cfdi:CfdiRelacionados")) {
            Node nodeCfdiRelacionados = SXmlUtils.extractChildElements(nodeComprobante, "cfdi:CfdiRelacionados").get(0);
            NamedNodeMap nodeCfdiRelacionadosMap = nodeCfdiRelacionados.getAttributes();
            
            DElementCfdiRelacionados cfdiRelacionados = new DElementCfdiRelacionados();
            cfdiRelacionados.getAttTipoRelacion().setString(SXmlUtils.extractAttributeValue(nodeCfdiRelacionadosMap, "TipoRelacion", true));
            
            Vector<Node> childNodeCfdiRelacionados = SXmlUtils.extractChildElements(nodeCfdiRelacionados, "cfdi:CfdiRelacionado");
            for (Node nodeCfdiRelacionado : childNodeCfdiRelacionados) {
                NamedNodeMap nodeCfdiRelacionadoMap = nodeCfdiRelacionado.getAttributes();
                
                DElementCfdiRelacionado cfdiRelacionado = new DElementCfdiRelacionado();
                cfdiRelacionado.getAttUuid().setString(SXmlUtils.extractAttributeValue(nodeCfdiRelacionadoMap, "UUID", true));
                cfdiRelacionados.getEltCfdiRelacionados().add(cfdiRelacionado);
            }
            
            comprobante.setEltOpcCfdiRelacionados(cfdiRelacionados);
        }

        // Emisor:

        Node nodeEmisor = SXmlUtils.extractElements(doc, "cfdi:Emisor").item(0);
        NamedNodeMap nodeEmisorMap = nodeEmisor.getAttributes();

        comprobante.getEltEmisor().getAttRfc().setString(SXmlUtils.extractAttributeValue(nodeEmisorMap, "Rfc", true));
        comprobante.getEltEmisor().getAttNombre().setString(SXmlUtils.extractAttributeValue(nodeEmisorMap, "Nombre", false));
        comprobante.getEltEmisor().getAttRegimenFiscal().setString(SXmlUtils.extractAttributeValue(nodeEmisorMap, "RegimenFiscal", true));

        // Receptor:

        Node nodeReceptor = SXmlUtils.extractElements(doc, "cfdi:Receptor").item(0);
        NamedNodeMap nodeReceptorMap = nodeReceptor.getAttributes();

        comprobante.getEltReceptor().getAttRfc().setString(SXmlUtils.extractAttributeValue(nodeReceptorMap, "Rfc", true));
        comprobante.getEltReceptor().getAttNombre().setString(SXmlUtils.extractAttributeValue(nodeReceptorMap, "Nombre", false));
        comprobante.getEltReceptor().getAttResidenciaFiscal().setString(SXmlUtils.extractAttributeValue(nodeReceptorMap, "ResidenciaFiscal", false));
        comprobante.getEltReceptor().getAttNumRegIdTrib().setString(SXmlUtils.extractAttributeValue(nodeReceptorMap, "NumRegIdTrib", false));
        comprobante.getEltReceptor().getAttUsoCFDI().setString(SXmlUtils.extractAttributeValue(nodeReceptorMap, "UsoCFDI", true));
        
        // Concepts:

        Node nodeConceptos = SXmlUtils.extractElements(doc, "cfdi:Conceptos").item(0);
        Vector<Node> childNodeConceptos = SXmlUtils.extractChildElements(nodeConceptos, "cfdi:Concepto");

        for (int i = 0; i < childNodeConceptos.size(); i++) {
            NamedNodeMap childNodeConceptosMap = childNodeConceptos.get(i).getAttributes();

            cfd.ver33.DElementConcepto concepto = new cfd.ver33.DElementConcepto();
            concepto.getAttClaveProdServ().setString(SXmlUtils.extractAttributeValue(childNodeConceptosMap, "ClaveProdServ", true));
            concepto.getAttNoIdentificacion().setString(SXmlUtils.extractAttributeValue(childNodeConceptosMap, "NoIdentificacion", false));
            concepto.getAttCantidad().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(childNodeConceptosMap, "Cantidad", true)));
            concepto.getAttClaveUnidad().setString(SXmlUtils.extractAttributeValue(childNodeConceptosMap, "ClaveUnidad", true));
            concepto.getAttUnidad().setString(SXmlUtils.extractAttributeValue(childNodeConceptosMap, "Unidad", false));
            concepto.getAttDescripcion().setString(SXmlUtils.extractAttributeValue(childNodeConceptosMap, "Descripcion", true));
            concepto.getAttValorUnitario().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(childNodeConceptosMap, "ValorUnitario", true)));
            concepto.getAttImporte().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(childNodeConceptosMap, "Importe", true)));
            concepto.getAttDescuento().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(childNodeConceptosMap, "Descuento", false)));

            // Tax concept:

            if (SXmlUtils.hasChildElement(childNodeConceptos.get(i), "cfdi:Impuestos")) {
                Vector<Node> childNodeImpuestos = SXmlUtils.extractChildElements(childNodeConceptos.get(i), "cfdi:Impuestos");
                Node nodeImpuestos = childNodeImpuestos.get(0);

                cfd.ver33.DElementConceptoImpuestosTraslados trasladados = new cfd.ver33.DElementConceptoImpuestosTraslados();
                
                if (SXmlUtils.hasChildElement(nodeImpuestos, "cfdi:Traslados")) {
                    Node nodeTraslados = SXmlUtils.extractChildElements(nodeImpuestos, "cfdi:Traslados").get(0);
                    Vector<Node> childNodeTraslado = SXmlUtils.extractChildElements(nodeTraslados, "cfdi:Traslado");

                    for (int indexTraslado = 0; indexTraslado < childNodeTraslado.size(); indexTraslado++) {
                        NamedNodeMap childNodeTrasladosMap = childNodeTraslado.get(indexTraslado).getAttributes();
                        
                        cfd.ver33.DElementConceptoImpuestoTraslado conceptoImpuestoTraslado = new cfd.ver33.DElementConceptoImpuestoTraslado();
                        conceptoImpuestoTraslado.getAttImpuesto().setString(SXmlUtils.extractAttributeValue(childNodeTrasladosMap, "Impuesto", true));
                        conceptoImpuestoTraslado.getAttBase().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(childNodeTrasladosMap, "Base", true)));
                        conceptoImpuestoTraslado.getAttTipoFactor().setString(SXmlUtils.extractAttributeValue(childNodeTrasladosMap, "TipoFactor", true));
                        conceptoImpuestoTraslado.getAttTasaOCuota().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(childNodeTrasladosMap, "TasaOCuota", false)));
                        conceptoImpuestoTraslado.getAttImporte().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(childNodeTrasladosMap, "Importe", false)));

                        trasladados.getEltImpuestoTrasladados().add(conceptoImpuestoTraslado);
                    }
                }
                
                cfd.ver33.DElementConceptoImpuestosRetenciones retenciones = new cfd.ver33.DElementConceptoImpuestosRetenciones();
                
                if (SXmlUtils.hasChildElement(nodeImpuestos, "cfdi:Retenciones")) {
                    Node nodeRetenciones = SXmlUtils.extractChildElements(nodeImpuestos, "cfdi:Retenciones").get(0);
                    Vector<Node> childNodeRetencion = SXmlUtils.extractChildElements(nodeRetenciones, "cfdi:Retencion");

                    for (int indexRetencion = 0; indexRetencion < childNodeRetencion.size(); indexRetencion++) {
                        NamedNodeMap childNodeRetencionesMap = childNodeRetencion.get(indexRetencion).getAttributes();

                        cfd.ver33.DElementConceptoImpuestoRetencion conceptoImpuestoRetencion = new cfd.ver33.DElementConceptoImpuestoRetencion();
                        conceptoImpuestoRetencion.getAttImpuesto().setString(SXmlUtils.extractAttributeValue(childNodeRetencionesMap, "Impuesto", true));
                        conceptoImpuestoRetencion.getAttBase().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(childNodeRetencionesMap, "Base", true)));
                        conceptoImpuestoRetencion.getAttTipoFactor().setString(SXmlUtils.extractAttributeValue(childNodeRetencionesMap, "TipoFactor", true));
                        conceptoImpuestoRetencion.getAttTasaOCuota().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(childNodeRetencionesMap, "TasaOCuota", true)));
                        conceptoImpuestoRetencion.getAttImporte().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(childNodeRetencionesMap, "Importe", true)));

                        retenciones.getEltImpuestoRetenciones().add(conceptoImpuestoRetencion);
                    }
                }
                
                if (!trasladados.getEltImpuestoTrasladados().isEmpty() || !retenciones.getEltImpuestoRetenciones().isEmpty()) {
                    concepto.setEltOpcConceptoImpuestos(new DElementConceptoImpuestos());
                    
                    if (!trasladados.getEltImpuestoTrasladados().isEmpty()) {
                        concepto.getEltOpcConceptoImpuestos().setEltOpcImpuestosTrasladados(trasladados);
                    }
                    
                    if (!retenciones.getEltImpuestoRetenciones().isEmpty()) {
                        concepto.getEltOpcConceptoImpuestos().setEltOpcImpuestosRetenciones(retenciones);
                    }
                }
            }
            
            if (SXmlUtils.hasChildElement(childNodeConceptos.get(i), "cfdi:InformacionAduanera")) {
                Vector<Node> childNodeInformacionAduanera = SXmlUtils.extractChildElements(childNodeConceptos.get(i), "cfdi:InformacionAduanera");

                for (int indexInformacionAduanera = 0; indexInformacionAduanera < childNodeInformacionAduanera.size(); indexInformacionAduanera++) {
                    NamedNodeMap childNodeInformacionAduaneraMap = childNodeInformacionAduanera.get(indexInformacionAduanera).getAttributes();

                    cfd.ver33.DElementConceptoInformacionAduanera conceptoInformacionAduanera = new cfd.ver33.DElementConceptoInformacionAduanera();
                    conceptoInformacionAduanera.getAttNumeroPedimento().setString(SXmlUtils.extractAttributeValue(childNodeInformacionAduaneraMap, "NumeroPedimento", true));
                    
                    concepto.getEltOpcConceptoInformacionAduaneras().add(conceptoInformacionAduanera);
                }
            }

            if (SXmlUtils.hasChildElement(childNodeConceptos.get(i), "cfdi:Parte")) {
                Vector<Node> childNodeParte = SXmlUtils.extractChildElements(childNodeConceptos.get(i), "cfdi:Parte");

                for (int indexParte = 0; indexParte < childNodeParte.size(); indexParte++) {
                    NamedNodeMap childNodeParteMap = childNodeParte.get(indexParte).getAttributes();

                    cfd.ver33.DElementConceptoParte conceptoParte = new cfd.ver33.DElementConceptoParte();
                    conceptoParte.getAttClaveProdServ().setString(SXmlUtils.extractAttributeValue(childNodeParteMap, "ClaveProdServ", true));
                    conceptoParte.getAttNoIdentificacion().setString(SXmlUtils.extractAttributeValue(childNodeParteMap, "NoIdentificacion", false));
                    conceptoParte.getAttCantidad().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(childNodeParteMap, "Cantidad", true)));
                    conceptoParte.getAttUnidad().setString(SXmlUtils.extractAttributeValue(childNodeParteMap, "Unidad", false));
                    conceptoParte.getAttDescripcion().setString(SXmlUtils.extractAttributeValue(childNodeParteMap, "Descripcion", true));
                    conceptoParte.getAttValorUnitario().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(childNodeParteMap, "ValorUnitario", true)));
                    conceptoParte.getAttImporte().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(childNodeParteMap, "Importe", true)));
                    
                    if (SXmlUtils.hasChildElement(childNodeParte.get(indexParte), "cfdi:InformacionAduanera")) {
                        Vector<Node> childNodeParteInformacionAduanera = SXmlUtils.extractChildElements(childNodeParte.get(indexParte), "cfdi:InformacionAduanera");

                        for (int indexParteInformacionAduanera = 0; indexParteInformacionAduanera < childNodeParteInformacionAduanera.size(); indexParteInformacionAduanera++) {
                            NamedNodeMap childNodeParteInformacionAduaneraMap = childNodeParteInformacionAduanera.get(indexParteInformacionAduanera).getAttributes();

                            cfd.ver33.DElementConceptoInformacionAduanera parteConceptoInformacionAduanera = new cfd.ver33.DElementConceptoInformacionAduanera();
                            parteConceptoInformacionAduanera.getAttNumeroPedimento().setString(SXmlUtils.extractAttributeValue(childNodeParteInformacionAduaneraMap, "NumeroPedimento", true));

                            conceptoParte.getEltOpcConceptoInformacionAduaneras().add(parteConceptoInformacionAduanera);
                        }
                    }

                    concepto.getEltOpcConceptoPartes().add(conceptoParte);
                }
            }

            if (SXmlUtils.hasChildElement(childNodeConceptos.get(i), "cfdi:CuentaPredial")) {
                if (SXmlUtils.hasChildElement(childNodeConceptos.get(i), "cfdi:CuentaPredial")) {

                    Node nodeCuentaPredial = SXmlUtils.extractChildElements(childNodeConceptos.get(i), "cfdi:CuentaPredial").get(0);
                    NamedNodeMap nodeCuentaPredialMap = nodeCuentaPredial.getAttributes();

                    cfd.ver33.DElementConceptoCuentaPredial predial = new cfd.ver33.DElementConceptoCuentaPredial();
                    predial.getAttNumero().setString(SXmlUtils.extractAttributeValue(nodeCuentaPredialMap, "Numero", true));

                    concepto.setEltOpcConceptoCuentaPredial(predial);
                }
            }
            
            comprobante.getEltConceptos().getEltConceptos().add(concepto);
        }
        
        // Taxes:
        
        double dTotalImptoRetenido = 0;
        double dTotalImptoTrasladado = 0;
        
        if (SXmlUtils.hasChildElement(nodeComprobante, "cfdi:Impuestos")) {
            Node node = SXmlUtils.extractChildElements(nodeComprobante, "cfdi:Impuestos").get(0);

            cfd.ver33.DElementImpuestosRetenciones retenciones = new cfd.ver33.DElementImpuestosRetenciones();
            cfd.ver33.DElementImpuestosTraslados trasladados = new cfd.ver33.DElementImpuestosTraslados();

            if (SXmlUtils.hasChildElement(node, "cfdi:Retenciones")) {
                Node nodeChild = SXmlUtils.extractChildElements(node, "cfdi:Retenciones").get(0);
                Vector<Node> nodeChilds = SXmlUtils.extractChildElements(nodeChild, "cfdi:Retencion");

                for (int i = 0; i < nodeChilds.size(); i++) {
                    cfd.ver33.DElementImpuestoRetencion impuestoRetencion = new cfd.ver33.DElementImpuestoRetencion();

                    Node nodeChild1 = nodeChilds.get(i);
                    NamedNodeMap namedNodeMapChild = nodeChild1.getAttributes();

                    impuestoRetencion.getAttImpuesto().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "Impuesto", true));
                    dTotalImptoRetenido += SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMapChild, "Importe", true));
                    impuestoRetencion.getAttImporte().setDouble(dTotalImptoRetenido);

                    retenciones.getEltImpuestoRetenciones().add(impuestoRetencion);
                }
            }

            if (SXmlUtils.hasChildElement(node, "cfdi:Traslados")) {
                Node nodeChild = SXmlUtils.extractChildElements(node, "cfdi:Traslados").get(0);
                Vector<Node> nodeChilds = SXmlUtils.extractChildElements(nodeChild, "cfdi:Traslado");

                for (int i = 0; i < nodeChilds.size(); i++) {
                    cfd.ver33.DElementImpuestoTraslado impuestoTraslado = new cfd.ver33.DElementImpuestoTraslado();

                    Node nodeChild1 = nodeChilds.get(i);
                    NamedNodeMap namedNodeMapChild = nodeChild1.getAttributes();

                    impuestoTraslado.getAttImpuesto().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "Impuesto", true));
                    impuestoTraslado.getAttTipoFactor().setString(SXmlUtils.extractAttributeValue(namedNodeMapChild, "TipoFactor", true));
                    impuestoTraslado.getAttTasaOCuota().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMapChild, "TasaOCuota", true)));
                    dTotalImptoTrasladado += SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMapChild, "Importe", true));
                    impuestoTraslado.getAttImporte().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMapChild, "Importe", true)));

                    trasladados.getEltImpuestoTrasladados().add(impuestoTraslado);
                }
            }

            if (!retenciones.getEltImpuestoRetenciones().isEmpty() || !trasladados.getEltImpuestoTrasladados().isEmpty()) {
                comprobante.setEltOpcImpuestos(new DElementImpuestos(comprobante));
                
                if (!retenciones.getEltImpuestoRetenciones().isEmpty()) {
                    comprobante.getEltOpcImpuestos().getAttTotalImpuestosRetenidos().setDouble(dTotalImptoRetenido);
                    comprobante.getEltOpcImpuestos().setEltOpcImpuestosRetenciones(retenciones);
                }

                if (!trasladados.getEltImpuestoTrasladados().isEmpty()) {
                    comprobante.getEltOpcImpuestos().getAttTotalImpuestosTraslados().setDouble(dTotalImptoTrasladado);
                    comprobante.getEltOpcImpuestos().setEltOpcImpuestosTrasladados(trasladados);
                }
            }
        }

        // Child elements of element 'cfdi:Complemento':
        
        if (SXmlUtils.hasChildElement(nodeComprobante, "cfdi:Complemento")) {
            Node nodeComplemento = SXmlUtils.extractChildElements(nodeComprobante, "cfdi:Complemento").get(0);
            
            cfd.ver33.DElementComplemento complemento = new cfd.ver33.DElementComplemento();

            // 'Complemento Timbrado':

            if (SXmlUtils.hasChildElement(nodeComplemento, "tfd:TimbreFiscalDigital")) {
                Node nodeTfd = SXmlUtils.extractChildElements(nodeComplemento, "tfd:TimbreFiscalDigital").get(0);
                NamedNodeMap namedNodeMapTfd = nodeTfd.getAttributes();

                cfd.ver33.DElementTimbreFiscalDigital tfd = new cfd.ver33.DElementTimbreFiscalDigital();
                tfd.getAttVersion().setString(SXmlUtils.extractAttributeValue(namedNodeMapTfd, "Version", true));
                tfd.getAttUUID().setString(SXmlUtils.extractAttributeValue(namedNodeMapTfd, "UUID", true));
                tfd.getAttFechaTimbrado().setString(SXmlUtils.extractAttributeValue(namedNodeMapTfd, "FechaTimbrado", true));
                tfd.getAttRfcProvCertif().setString(SXmlUtils.extractAttributeValue(namedNodeMapTfd, "RfcProvCertif", true));
                tfd.getAttLeyenda().setString(SXmlUtils.extractAttributeValue(namedNodeMapTfd, "Leyenda", false));
                tfd.getAttSelloCFD().setString(SXmlUtils.extractAttributeValue(namedNodeMapTfd, "SelloCFD", true));
                tfd.getAttNoCertificadoSAT().setString(SXmlUtils.extractAttributeValue(namedNodeMapTfd, "NoCertificadoSAT", true));
                tfd.getAttSelloSAT().setString(SXmlUtils.extractAttributeValue(namedNodeMapTfd, "SelloSAT", true));

                complemento.getElements().add(tfd);
            }

            // 'Complemento Comercio Exterior':

            if (SXmlUtils.hasChildElement(nodeComplemento, "cce11:ComercioExterior")) {
                /*
                Node nodeChild = SXmlUtils.extractChildElements(node, "cce11:ComercioExterior").get(0);
                NamedNodeMap namedNodeMapChild = nodeChild.getAttributes();

                cfd.ver3.cce11.DElementComercioExterior cce = new cfd.ver3.cce11.DElementComercioExterior();
                
                // add code here to read each attribute and node from 'Complemento Comercio Exterior'

                complemento.getElements().add(cce);
                */
            }

            // 'Complemento Recepción Pagos':

            if (SXmlUtils.hasChildElement(nodeComplemento, "pago10:Pagos")) {
                Node nodePagos = SXmlUtils.extractChildElements(nodeComplemento, "pago10:Pagos").get(0);
                NamedNodeMap namedNodeMapPagos = nodePagos.getAttributes();

                cfd.ver33.crp10.DElementPagos pagos = new cfd.ver33.crp10.DElementPagos();
                pagos.getAttVersion().setString(SXmlUtils.extractAttributeValue(namedNodeMapPagos, "Version", true));
                
                for (Node nodePago : SXmlUtils.extractChildElements(nodePagos, "pago10:Pago")) {
                    NamedNodeMap namedNodeMapPago = nodePago.getAttributes();
                    
                    cfd.ver33.crp10.DElementPagosPago pago = new cfd.ver33.crp10.DElementPagosPago();
                    pago.getAttFechaPago().setDatetime(SLibUtils.DbmsDateFormatDatetime.parse(SXmlUtils.extractAttributeValue(namedNodeMapPago, "FechaPago", true).replaceAll("T", " ")));
                    pago.getAttFormaDePagoP().setString(SXmlUtils.extractAttributeValue(namedNodeMapPago, "FormaDePagoP", true));
                    pago.getAttMonedaP().setString(SXmlUtils.extractAttributeValue(namedNodeMapPago, "MonedaP", true));
                    pago.getAttTipoCambioP().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMapPago, "TipoCambioP", false)));
                    pago.getAttMonto().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMapPago, "Monto", true)));
                    pago.getAttNumOperacion().setString(SXmlUtils.extractAttributeValue(namedNodeMapPago, "NumOperacion", false));
                    pago.getAttRfcEmisorCtaOrd().setString(SXmlUtils.extractAttributeValue(namedNodeMapPago, "RfcEmisorCtaOrd", false));
                    pago.getAttNomBancoOrdExt().setString(SXmlUtils.extractAttributeValue(namedNodeMapPago, "NomBancoOrdExt", false));
                    pago.getAttCtaOrdenante().setString(SXmlUtils.extractAttributeValue(namedNodeMapPago, "CtaOrdenante", false));
                    pago.getAttRfcEmisorCtaBen().setString(SXmlUtils.extractAttributeValue(namedNodeMapPago, "RfcEmisorCtaBen", false));
                    pago.getAttCtaBeneficiario().setString(SXmlUtils.extractAttributeValue(namedNodeMapPago, "CtaBeneficiario", false));
                    pago.getAttTipoCadPago().setString(SXmlUtils.extractAttributeValue(namedNodeMapPago, "TipoCadPago", false));
                    pago.getAttCertPago().setString(SXmlUtils.extractAttributeValue(namedNodeMapPago, "CertPago", false));
                    pago.getAttCadPago().setString(SXmlUtils.extractAttributeValue(namedNodeMapPago, "CadPago", false));
                    pago.getAttSelloPago().setString(SXmlUtils.extractAttributeValue(namedNodeMapPago, "SelloPago", false));

                    for (Node nodeDoctoRelacionado : SXmlUtils.extractChildElements(nodePago, "pago10:DoctoRelacionado")) {
                        NamedNodeMap namedNodeMapDoctoRelacionado = nodeDoctoRelacionado.getAttributes();

                        cfd.ver33.crp10.DElementDoctoRelacionado doctoRelacionado = new cfd.ver33.crp10.DElementDoctoRelacionado();
                        doctoRelacionado.getAttIdDocumento().setString(SXmlUtils.extractAttributeValue(namedNodeMapDoctoRelacionado, "IdDocumento", true));
                        doctoRelacionado.getAttSerie().setString(SXmlUtils.extractAttributeValue(namedNodeMapDoctoRelacionado, "Serie", false));
                        doctoRelacionado.getAttFolio().setString(SXmlUtils.extractAttributeValue(namedNodeMapDoctoRelacionado, "Folio", false));
                        doctoRelacionado.getAttMonedaDR().setString(SXmlUtils.extractAttributeValue(namedNodeMapDoctoRelacionado, "MonedaDR", true));
                        doctoRelacionado.getAttTipoCambioDR().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMapDoctoRelacionado, "TipoCambioDR", false)));
                        doctoRelacionado.getAttMetodoPagoDR().setString(SXmlUtils.extractAttributeValue(namedNodeMapDoctoRelacionado, "MetodoPagoDR", true));
                        doctoRelacionado.getAttNumParcialidad().setInteger(SLibUtils.parseInt(SXmlUtils.extractAttributeValue(namedNodeMapDoctoRelacionado, "NumParcialidad", true)));
                        doctoRelacionado.getAttImpSaldoAnt().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMapDoctoRelacionado, "SaldoAnt", true)));
                        doctoRelacionado.getAttImpPagado().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMapDoctoRelacionado, "ImpPagado", false)));
                        doctoRelacionado.getAttImpSaldoInsoluto().setDouble(SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMapDoctoRelacionado, "ImpSaldoInsoluto", false)));
                        
                        pago.getEltDoctoRelacionados().add(doctoRelacionado);
                    }

                    pagos.getEltPagos().add(pago);
                }

                complemento.getElements().add(pagos);
            }

            // 'Complemento Nómina':

            if (SXmlUtils.hasChildElement(nodeComplemento, "nomina:Nomina") || SXmlUtils.hasChildElement(nodeComplemento, "nomina12:Nomina")) {
                complemento.getElements().add(getElementNomina(nodeComplemento));
            }

            if (!complemento.getElements().isEmpty()) {
                comprobante.setEltOpcComplemento(complemento);
            }
        }

        // Addenda:

        if (SXmlUtils.hasChildElement(nodeComprobante, "cfdi:Addenda")) {
            Node node = SXmlUtils.extractChildElements(nodeComprobante, "cfdi:Addenda").get(0);

            cfd.ver3.DElementAddenda addenda = getElementAddendaWithAddenda1(node);

            comprobante.setEltOpcAddenda(addenda);
        }
        
        return comprobante;
    }
    
    public static double getVersionPayrollComplement(String xml) throws Exception {
        DocumentBuilder docBuilder = null;
        Document doc = null;
        Node node = null;
        double version = 0;
        NamedNodeMap namedNodeMap = null;

        docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        doc = docBuilder.parse(new ByteArrayInputStream(xml.getBytes("UTF-8")));

        node = SXmlUtils.extractElements(doc, "cfdi:Complemento").item(0);

        if (node != null) {
            if (SXmlUtils.hasChildElement(node, "nomina:Nomina")) {
                node = SXmlUtils.extractChildElements(node, "nomina:Nomina").get(0);
                namedNodeMap = node.getAttributes();
            }
            else {
                node = SXmlUtils.extractChildElements(node, "nomina12:Nomina").get(0);
                namedNodeMap = node.getAttributes();
            }

            version = SLibUtils.parseDouble(SXmlUtils.extractAttributeValue(namedNodeMap, "Version", true));
        }
        
        return version;
    }
}
