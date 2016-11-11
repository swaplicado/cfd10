/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.mod.hrs.db;

import cfd.DAttributeOptionCondicionesPago;
import cfd.DAttributeOptionFormaPago;
import cfd.DAttributeOptionImpuestoRetencion;
import cfd.DAttributeOptionTipoComprobante;
import cfd.DElement;
import cfd.ver3.DElementDeduccion;
import cfd.ver3.DElementDeducciones;
import cfd.ver3.DElementPercepcion;
import cfd.ver3.DElementPercepciones;
import erp.cfd.SCfdConsts;
import erp.cfd.SCfdDataConcepto;
import erp.cfd.SCfdDataImpuesto;
import erp.cfd.SCfdXml;
import erp.client.SClientInterface;
import erp.mod.SModSysConsts;
import java.util.ArrayList;
import java.util.Date;
import sa.lib.SLibTimeUtils;
import sa.lib.SLibUtils;

/**
 *
 * @author Juan Barajas
 * 
 * Maintenance Log
 * 2016-07-11, Sergio Flores:
 *  Deletion of obsolete import sentences.
 * 
 */
public class SHrsFormerPayrollReceipt implements SCfdXml {

    protected SClientInterface miClient;

    protected int mnPkEmpleadoId;
    protected int mnPkSucursalEmpleadoId;
    protected String msRegistroPatronal;
    protected String msNumEmpleado;
    protected String msCurp;
    protected int msTipoRegimen;
    protected String msNumSeguridadSocial;
    protected Date mtFechaPago;
    protected Date mtFechaInicialPago;
    protected Date mtFechaFinalPago;
    protected double mdNumDiasPagados;
    protected String msDepartamento;
    protected String msClabe;
    protected int mnBanco;
    protected Date mtFechaInicioRelLaboral;
    protected int mnAntiguedad;
    protected String msPuesto;
    protected String msTipoContrato;
    protected String msTipoJornada;
    protected String msPeriodicidadPago;
    protected double mdSalarioBaseCotApor;
    protected int mnRiesgoPuesto;
    protected double mdSalarioDiarioIntegrado;

    protected double mdTotalPercepciones;
    protected double mdTotalDeducciones;
    protected double mdTotalRetenciones;
    protected double mdTotalNeto;
    protected int mnMetodoPago;
    protected String msMetodoPagoAux;
    protected String msSerie;
    protected int mnFolio;
    protected String msMoneda;
    protected Date mtFechaEdicion;

    protected int mnAuxEmpleadoId;

    protected SHrsFormerPayroll moPayroll;
    protected ArrayList<SHrsFormerPayrollConcept> moChildPayrollConcept;

    public SHrsFormerPayrollReceipt(SHrsFormerPayroll payroll, SClientInterface client) {
        miClient = client;

        mnPkEmpleadoId = 0;
        mnPkSucursalEmpleadoId = 0;
        msRegistroPatronal = "";
        msNumEmpleado = "";
        msCurp = "";
        msTipoRegimen = 0;
        msNumSeguridadSocial = "";
        mtFechaPago = null;
        mtFechaInicialPago = null;
        mtFechaFinalPago = null;
        mdNumDiasPagados = 0;
        msDepartamento = "";
        msClabe = "";
        mnBanco = 0;
        mtFechaInicioRelLaboral = null;
        mnAntiguedad = 0;
        msPuesto = "";
        msTipoContrato = "";
        msTipoJornada = "";
        msPeriodicidadPago = "";
        mdSalarioBaseCotApor = 0;
        mnRiesgoPuesto = 0;
        mdSalarioDiarioIntegrado = 0;

        mdTotalPercepciones = 0;
        mdTotalDeducciones = 0;
        mdTotalRetenciones = 0;
        mdTotalNeto = 0;
        mnMetodoPago = 0;
        msMetodoPagoAux = "";
        msSerie = "";
        mnFolio = 0;
        msMoneda = "";
        mtFechaEdicion = null;

        mnAuxEmpleadoId = 0;

        moPayroll = payroll;
        moChildPayrollConcept = new ArrayList<SHrsFormerPayrollConcept>();
    }

    public void setPkEmpleadoId(int n) { mnPkEmpleadoId = n; }
    public void setPkSucursalEmpleadoId(int n) { mnPkSucursalEmpleadoId = n; }
    public void setRegistroPatronal(String s) { msRegistroPatronal = s; }
    public void setNumEmpleado(String s) { msNumEmpleado = s; }
    public void setCurp(String s) { msCurp = s; }
    public void setTipoRegimen(int n) { msTipoRegimen = n; }
    public void setNumSeguridadSocial(String s) { msNumSeguridadSocial = s; }
    public void setFechaPago(Date t) { mtFechaPago = t; }
    public void setFechaInicialPago(Date t) { mtFechaInicialPago = t; }
    public void setFechaFinalPago(Date t) { mtFechaFinalPago = t; }
    public void setNumDiasPagados(double d) { mdNumDiasPagados = d; }
    public void setDepartamento(String s) { msDepartamento = s; }
    public void setClabe(String s) { msClabe = s; }
    public void setBanco(int n) { mnBanco = n; }
    public void setFechaInicioRelLaboral(Date t) { mtFechaInicioRelLaboral = t; }
    public void setAntiguedad(int n) { mnAntiguedad = n; }
    public void setPuesto(String s) { msPuesto = s; }
    public void setTipoContrato(String s) { msTipoContrato = s; }
    public void setTipoJornada(String s) { msTipoJornada = s; }
    public void setPeriodicidadPago(String s) { msPeriodicidadPago = s; }
    public void setSalarioBaseCotApor(double d) { mdSalarioBaseCotApor = d; }
    public void setRiesgoPuesto(int n) { mnRiesgoPuesto = n; }
    public void setSalarioDiarioIntegrado(double d) { mdSalarioDiarioIntegrado = d; }

    public void setTotalPercepciones(double d) { mdTotalPercepciones = d; }
    public void setTotalDeducciones(double d) { mdTotalDeducciones = d; }
    public void setTotalRetenciones(double d) { mdTotalRetenciones = d; }
    public void setTotalNeto(double d) { mdTotalNeto = d; }
    public void setMetodoPago(int n) { mnMetodoPago = n; }
    public void setMetodoPagoAux(String s) { msMetodoPagoAux = s; }
    public void setSerie(String s) { msSerie = s; }
    public void setFolio(int n) { mnFolio = n; }
    public void setMoneda(String s) { msMoneda = s; }
    public void setFechaEdicion(Date t) { mtFechaEdicion = t; }

    public void setAuxEmpleadoId(int n) { mnAuxEmpleadoId = n; }

    public void setPayroll(SHrsFormerPayroll o) { moPayroll = o; }

    public int getPkEmpleadoId() { return mnPkEmpleadoId; }
    public int getPkSucursalEmpleadoId() { return mnPkSucursalEmpleadoId; }
    public String getRegistroPatronal() { return msRegistroPatronal; }
    public String getNumEmpleado() { return msNumEmpleado; }
    public String getCurp() { return msCurp; }
    public int getTipoRegimen() { return msTipoRegimen; }
    public String getNumSeguridadSocial() { return msNumSeguridadSocial; }
    public Date getFechaPago() { return mtFechaPago; }
    public Date getFechaInicialPago() { return mtFechaInicialPago; }
    public Date getFechaFinalPago() { return mtFechaFinalPago; }
    public double getNumDiasPagados() { return mdNumDiasPagados; }
    public String getDepartamento() { return msDepartamento; }
    public String getClabe() { return msClabe; }
    public int getBanco() { return mnBanco; }
    public Date getFechaInicioRelLaboral() { return mtFechaInicioRelLaboral; }
    public int getAntiguedad() { return mnAntiguedad; }
    public String getPuesto() { return msPuesto; }
    public String getTipoContrato() { return msTipoContrato; }
    public String getTipoJornada() { return msTipoJornada; }
    public String getPeriodicidadPago() { return msPeriodicidadPago; }
    public double getSalarioBaseCotApor() { return mdSalarioBaseCotApor; }
    public int getRiesgoPuesto() { return mnRiesgoPuesto; }
    public double getSalarioDiarioIntegrado() { return mdSalarioDiarioIntegrado; }

    public double getTotalPercepciones() { return mdTotalPercepciones; }
    public double getTotalDeducciones() { return mdTotalDeducciones; }
    public double getTotalRetenciones() { return mdTotalRetenciones; }
    public double getTotalNeto() { return mdTotalNeto; }
    public int getMetodoPago() { return mnMetodoPago; }
    public String getMetodoPagoAux() { return msMetodoPagoAux; }
    public String getSerie() { return msSerie; }
    public int getFolio() { return mnFolio; }
    public String getMoneda() { return msMoneda; }
    public Date getFechaEdicion() { return mtFechaEdicion; }

    public int getAuxEmpleadoId() { return mnAuxEmpleadoId; }

    public SHrsFormerPayroll getPayroll() { return moPayroll; }
    public ArrayList<SHrsFormerPayrollConcept> getChildPayrollConcept() { return moChildPayrollConcept; }

    public cfd.DElement createCfdiElementNomina() throws java.lang.Exception {
        double dTotalTaxedPerceptions = 0;
        double dTotalExemptPerceptions = 0;
        double dTotalTaxedDeductions = 0;
        double dTotalExemptDeductions = 0;
        double dTotalExtraTime = 0;
        double dTotalExtraTimeAux = 0;
        cfd.ver3.DElementNomina nomina = new cfd.ver3.DElementNomina();
        cfd.ver3.DElementPercepciones percepciones = new DElementPercepciones();
        cfd.ver3.DElementDeducciones deducciones = new DElementDeducciones();
        cfd.ver3.DElementIncapacidades incapacidades = new cfd.ver3.DElementIncapacidades();
        cfd.ver3.DElementHorasExtras horasExtras = new cfd.ver3.DElementHorasExtras();

        nomina.getAttRegistroPatronal().setString(msRegistroPatronal);
        nomina.getAttNumEmpleado().setString(msNumEmpleado);
        nomina.getAttCurp().setString(msCurp);
        nomina.getAttTipoRegimen().setInteger(msTipoRegimen);
        nomina.getAttNumSeguridadSocial().setString(msNumSeguridadSocial);
        nomina.getAttFechaPago().setDate(mtFechaPago);
        nomina.getAttFechaInicialPago().setDate(mtFechaInicialPago);
        nomina.getAttFechaFinalPago().setDate(mtFechaFinalPago);
        nomina.getAttNumDiasPagados().setDouble(mdNumDiasPagados);
        nomina.getAttDepartamento().setString(msDepartamento);
        nomina.getAttClabe().setString(msClabe);
        nomina.getAttBanco().setInteger(mnBanco);
        nomina.getAttFechaInicioRelLaboral().setDate(mtFechaInicioRelLaboral);
        nomina.getAttAntiguedad().setInteger(mnAntiguedad);
        nomina.getAttPuesto().setString(msPuesto);
        nomina.getAttTipoContrato().setString(msTipoContrato);
        nomina.getAttTipoJornada().setString(msTipoJornada);
        nomina.getAttPeriodicidadPago().setString(msPeriodicidadPago);
        nomina.getAttSalarioBaseCotApor().setDouble(mdSalarioBaseCotApor);
        nomina.getAttRiesgoPuesto().setInteger(mnRiesgoPuesto);
        nomina.getAttSalarioDiarioIntegrado().setDouble(mdSalarioDiarioIntegrado);

        for (SHrsFormerPayrollConcept concept : moChildPayrollConcept) {
            switch (concept.getPkTipoConcepto()) {
                case SCfdConsts.CFDI_PAYROLL_PERCEPTION:
                    cfd.ver3.DElementPercepcion percepcion = new DElementPercepcion();

                    dTotalTaxedPerceptions += concept.getTotalGravado();
                    dTotalExemptPerceptions += concept.getTotalExento();

                    percepcion.getAttTipoPercepcion().setInteger(concept.getClaveOficial());
                    percepcion.getAttClave().setString(concept.getClaveEmpresa().length() < 3 ? SLibUtils.textRepeat("0", 3 - concept.getClaveEmpresa().length()) + concept.getClaveEmpresa() : concept.getClaveEmpresa());
                    percepcion.getAttConcepto().setString(concept.getConcepto());
                    percepcion.getAttImporteGravado().setDouble(concept.getTotalGravado());
                    percepcion.getAttImporteExento().setDouble(concept.getTotalExento());

                    percepciones.getEltHijosPercepcion().add(percepcion);

                    if (SLibUtils.belongsTo(concept.getPkSubtipoConcepto(), new int[] { SCfdConsts.CFDI_PAYROLL_PERCEPTION_EXTRA_TIME_DOUBLE[1], SCfdConsts.CFDI_PAYROLL_PERCEPTION_EXTRA_TIME_TRIPLE[1] })) {
                        cfd.ver3.DElementHorasExtra horasExtra = new cfd.ver3.DElementHorasExtra();

                        horasExtra.getAttDias().setInteger((int) concept.getCantidad());
                        horasExtra.getAttTipoHoras().setString(concept.getPkSubtipoConcepto() == SCfdConsts.CFDI_PAYROLL_PERCEPTION_EXTRA_TIME_DOUBLE[1] ? SCfdConsts.CFDI_PAYROLL_EXTRA_TIME_TYPE_DOUBLE : SCfdConsts.CFDI_PAYROLL_EXTRA_TIME_TYPE_TRIPLE);
                        horasExtra.getAttHorasExtra().setInteger(concept.getHoras_r());
                        horasExtra.getAttImportePagado().setDouble(concept.getTotalGravado() + concept.getTotalExento());

                        dTotalExtraTime += concept.getTotalGravado() + concept.getTotalExento();

                        horasExtras.getEltHijosHorasExtra().add(horasExtra);
                    }
                    break;
                case SCfdConsts.CFDI_PAYROLL_DEDUCTION:
                    cfd.ver3.DElementDeduccion deduccion = new DElementDeduccion();

                    dTotalTaxedDeductions += concept.getTotalGravado();
                    dTotalExemptDeductions += concept.getTotalExento();

                    deduccion.getAttTipoDeduccion().setInteger(concept.getClaveOficial());
                    deduccion.getAttClave().setString(concept.getClaveEmpresa().length() < 3 ? SLibUtils.textRepeat("0", 3 - concept.getClaveEmpresa().length()) + concept.getClaveEmpresa() : concept.getClaveEmpresa());
                    deduccion.getAttConcepto().setString(concept.getConcepto());
                    deduccion.getAttImporteGravado().setDouble(concept.getTotalGravado());
                    deduccion.getAttImporteExento().setDouble(concept.getTotalExento());

                    deducciones.getEltHijosDeduccion().add(deduccion);
                    break;
                default:
            }
        }

        if (!percepciones.getEltHijosPercepcion().isEmpty()) {
            percepciones.getAttTotalGravado().setDouble(dTotalTaxedPerceptions);
            percepciones.getAttTotalExento().setDouble(dTotalExemptPerceptions);
            nomina.setEltPercepciones(percepciones);
        }

        if (!deducciones.getEltHijosDeduccion().isEmpty()) {
            deducciones.getAttTotalGravado().setDouble(dTotalTaxedDeductions);
            deducciones.getAttTotalExento().setDouble(dTotalExemptDeductions);
            nomina.setEltDeducciones(deducciones);
        }

        if (!horasExtras.getEltHijosHorasExtra().isEmpty()) {
            nomina.setEltHorasExtras(horasExtras);
        }

        if (!incapacidades.getEltHijosIncapacidad().isEmpty()) {
            nomina.setEltIncapacidades(incapacidades);
        }

        for (int i = 0; i < horasExtras.getEltHijosHorasExtra().size(); i++) {
            dTotalExtraTimeAux += horasExtras.getEltHijosHorasExtra().get(i).getAttImportePagado().getDouble();
        }

        if (SLibUtils.round(dTotalExtraTime, SLibUtils.DecimalFormatPercentage2D.getMaximumFractionDigits()) != SLibUtils.round(dTotalExtraTimeAux, SLibUtils.DecimalFormatPercentage2D.getMaximumFractionDigits())) {
            nomina = null;
            throw new Exception("El importe pagado de horas extra (" + SLibUtils.getDecimalFormatAmount().format(dTotalExtraTimeAux) + ") no coincide con el total de las percepciones de horas extra (" + SLibUtils.getDecimalFormatAmount().format(dTotalExtraTime) + ").");
        }

        return nomina;
    }

    @Override
    public int getCfdTipoCfdXml() {
        return SCfdConsts.CFD_TYPE_PAYROLL;
    }

    @Override
    public String getCfdSerie() {
        return msSerie;
    }

    @Override
    public String getCfdFolio() {
        return "" + mnFolio;
    }

    @Override
    public String getCfdReferencia() {
        return "";
    }

    @Override
    public Date getCfdFecha() {
        Date tDate = null;
        Date tDateTime = null;
        long lTimes = 0;

        tDate = new Date();
        tDateTime = new Date();

        lTimes = tDateTime.getTime() - SLibTimeUtils.convertToDateOnly(tDateTime).getTime();

        tDate.setTime(moPayroll.getFecha().getTime() + lTimes);

        return tDate;
    }

    @Override
    public int getCfdFormaDePago() {
        return DAttributeOptionFormaPago.CFD_UNA_EXHIBICION;
    }

    @Override
    public int getCfdCondicionesDePago() {
        return DAttributeOptionCondicionesPago.CFD_CONTADO;
    }

    @Override
    public double getCfdSubTotal() {
        return mdTotalPercepciones;
    }

    @Override
    public double getCfdDescuento() {
        return mdTotalDeducciones - mdTotalRetenciones;
    }

    @Override
    public String getCfdMotivoDescuento() {
        return "Deducciones nómina";
    }

    @Override
    public double getCfdTipoCambio() {
        return 1;
    }

    @Override
    public String getCfdMoneda() {
        return msMoneda;
    }

    @Override
    public double getCfdTotal() {
        return mdTotalNeto;
    }

    @Override
    public int getCfdTipoDeComprobante() {
        return DAttributeOptionTipoComprobante.CFD_EGRESO;
    }

    /**
     * Maintenance Log:
     * 
     * 2016-07-14, Sergio Flores: implementation of new payment method catalogue (erp.TRNU_TP_PAY_SYS DB table).
     */
    
    @Override
    public String getCfdMetodoDePago() {
        String metodoPago = "";

        try {
            metodoPago = SHrsFormerUtils.getPaymentMethodName(miClient, mnMetodoPago);
        }
        catch (Exception e) {
            SLibUtils.printException(this, e);
        }

        return metodoPago;
    }

    @Override
    public String getCfdNumCtaPago() {
        return "";
    }

    @Override
    public int getEmisor() {
        return moPayroll.getEmpresaId();
    }

    @Override
    public int getSucursalEmisor() {
        return moPayroll.getSucursalEmpresaId();
    }

    @Override
    public int getReceptor() {
        return mnPkEmpleadoId;
    }

    @Override
    public int getSucursalReceptor() {
        return mnPkSucursalEmpleadoId;
    }

    @Override
    public ArrayList<DElement> getCfdElementRegimenFiscal() {
        ArrayList<DElement> regimes = new ArrayList<DElement>();
        DElement regimen = null;

        for (int i = 0; i < moPayroll.getRegimenFiscal().length; i++) {
            regimen = new cfd.ver3.DElementRegimenFiscal();

            ((cfd.ver3.DElementRegimenFiscal) regimen).getAttRegimen().setString(moPayroll.getRegimenFiscal()[i]);
            regimes.add(regimen);
        }

        return regimes;
    }

    @Override
    public DElement getCfdElementAddenda() {
        return null;
    }

    @Override
    public DElement getCfdElementComplemento() {
        DElement complemento = null;

        try {
            complemento = new cfd.ver3.DElementComplemento();

            ((cfd.ver3.DElementComplemento) complemento).getElements().add(createCfdiElementNomina());
        }
        catch (Exception e) {
            SLibUtils.showException(this, e);
        }

        return complemento;
    }

    @Override
    public ArrayList<SCfdDataConcepto> getCfdConceptos() {
        ArrayList<SCfdDataConcepto> concepts = null;
        SCfdDataConcepto concept = null;

        concepts = new ArrayList<SCfdDataConcepto>();
        concept = new SCfdDataConcepto();

        concept.setNoIdentificacion("");
        concept.setUnidad("Servicio");
        concept.setCantidad(1.0);
        concept.setDescripcion(moPayroll.getDescripcion());
        concept.setValorUnitario(mdTotalPercepciones);
        concept.setImporte(mdTotalPercepciones);

        concepts.add(concept);

        return concepts;
    }

    @Override
    public ArrayList<SCfdDataImpuesto> getCfdImpuestos() {
        ArrayList<SCfdDataImpuesto> taxes = null;
        SCfdDataImpuesto tax = null;

        taxes = new ArrayList<SCfdDataImpuesto>();

        tax = new SCfdDataImpuesto();

        tax.setImpuesto(DAttributeOptionImpuestoRetencion.CFD_ISR);
        tax.setImpuestoBasico(SModSysConsts.FINS_TP_TAX_RETAINED);
        tax.setTasa(1);
        tax.setImporte(mdTotalRetenciones);

        taxes.add(tax);

        return taxes;
    }
}