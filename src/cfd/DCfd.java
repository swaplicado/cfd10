/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd;

import cfd.util.DUtilUtils;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public final class DCfd {

    private java.lang.String msXmlBaseDir;
    private java.text.DecimalFormat moDecimalFormat;

    private java.util.Date mtLastTimestamp;
    private java.lang.String msLastStringSigned;
    private java.lang.String msLastSignature;
    private java.lang.String msLastXml;
    private java.lang.String msLastXmlFileName;
    private java.lang.String msLastXmlFilePath;

    public DCfd(java.lang.String xmlBaseDir) {
        msXmlBaseDir = xmlBaseDir;
        moDecimalFormat = new DecimalFormat("0000000000");
        resetLastMembers();
    }

    private void resetLastMembers() {
        mtLastTimestamp = null;
        msLastStringSigned = "";
        msLastSignature = "";
        msLastXml = "";
        msLastXmlFileName = "";
        msLastXmlFilePath = "";
    }

    public void setLastTimestamp(java.util.Date t) { mtLastTimestamp = t; }
    public void setLastStringSigned(java.lang.String s) { msLastStringSigned = s; }
    public void setLastSignature(java.lang.String s) { msLastSignature = s; }
    public void setLastXml(java.lang.String s) { msLastXml = s; }
    public void setLastXmlFileName(java.lang.String s) { msLastXmlFileName = s; }
    public void setLastXmlFilePath(java.lang.String s) { msLastXmlFilePath = s; }

    public java.lang.String getXmlBaseDir() { return msXmlBaseDir; }
    public java.text.DecimalFormat getDecimalFormat() { return moDecimalFormat; }

    public java.util.Date getLastTimestamp() { return mtLastTimestamp; }
    public java.lang.String getLastStringSigned() { return msLastStringSigned; }
    public java.lang.String getLastSignature() { return msLastSignature; }
    public java.lang.String getLastXml() { return msLastXml; }
    public java.lang.String getLastXmlFileName() { return msLastXmlFileName; }
    public java.lang.String getLastXmlFilePath() { return msLastXmlFilePath; }

    public int signAndWrite(cfd.ver2.DElementComprobante comprobante, cfd.DCfdSignature cfdSignature) throws java.io.IOException, java.lang.Exception {
        String stringSigned = DUtilUtils.generateOriginalString(comprobante);
        String signature = cfdSignature.sign(stringSigned, DUtilUtils.getYear(comprobante.getAttFecha().getDatetime()));

        return write(comprobante, stringSigned, signature, cfdSignature.getCertNumber(), cfdSignature.getCertBase64());
    }

    public String createFileName(cfd.ver2.DElementComprobante comprobante) {
        String fileName = "";

        fileName += comprobante.getEltEmisor().getAttRfc().getString() + "_";
        fileName += comprobante.getAttTipoDeComprobante().getOption().substring(0, 1).toUpperCase() + "_";
        fileName += (comprobante.getAttSerie().getString().length() == 0 ? "" : comprobante.getAttSerie().getString() + "_");
        fileName += moDecimalFormat.format(DUtilUtils.parseLong(comprobante.getAttFolio().getString()));

        return fileName;
    }

    public String createFileName(cfd.ver3.DElementComprobante comprobante) {
        String fileName = "";

        fileName += comprobante.getEltEmisor().getAttRfc().getString() + "_";
        fileName += comprobante.getAttTipoDeComprobante().getOption().substring(0, 1).toUpperCase() + "_";
        fileName += (comprobante.getAttSerie().getString().length() == 0 ? "" : comprobante.getAttSerie().getString() + "_");
        fileName += moDecimalFormat.format(DUtilUtils.parseLong(comprobante.getAttFolio().getString()));

        return fileName;
    }

    public int write(cfd.ver2.DElementComprobante comprobante, final java.lang.String stringSigned, final java.lang.String signature, final java.lang.String certNumber, final java.lang.String certBase64) throws java.io.IOException, java.lang.Exception {
        int result = 0;
        String xml = "";
        String xmlFileName = "";
        String xmlFilePath = "";
        BufferedWriter bw = null;

        resetLastMembers();

        comprobante.getAttSello().setString(signature);
        comprobante.getAttNoCertificado().setString(certNumber);
        comprobante.getAttCertificado().setString(certBase64);

        xmlFileName = createFileName(comprobante) + ".xml";
        xmlFilePath = msXmlBaseDir + xmlFileName;

        xml = DCfdConsts.XML_HEADER + comprobante.getElementForXml();

        bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(xmlFilePath), "UTF-8"));
        bw.write(xml);
        bw.close();

        mtLastTimestamp = comprobante.getAttFecha().getDatetime();
        msLastStringSigned = stringSigned;
        msLastSignature = signature;
        msLastXml = xml;
        msLastXmlFileName = xmlFileName;
        msLastXmlFilePath = xmlFilePath;

        return result;
    }

    public int write(cfd.ver3.DElementComprobante comprobante, final java.lang.String stringSigned, final java.lang.String signature, final java.lang.String certNumber, final java.lang.String certBase64) throws java.io.IOException, java.lang.Exception {
        int result = 0;
        String xml = "";
        String xmlFileName = "";
        String xmlFilePath = "";
        BufferedWriter bw = null;

        resetLastMembers();

        comprobante.getAttSello().setString(signature);
        comprobante.getAttNoCertificado().setString(certNumber);
        comprobante.getAttCertificado().setString(certBase64);

        xmlFileName = createFileName(comprobante) + ".xml";
        xmlFilePath = msXmlBaseDir + xmlFileName;

        xml = DCfdConsts.XML_HEADER + comprobante.getElementForXml();

        bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(xmlFilePath), "UTF-8"));
        bw.write(xml);
        bw.close();

        mtLastTimestamp = comprobante.getAttFecha().getDatetime();
        msLastStringSigned = stringSigned;
        msLastSignature = signature;
        msLastXml = xml;
        msLastXmlFileName = xmlFileName;
        msLastXmlFilePath = xmlFilePath;

        return result;
    }
    
    public int write(final java.lang.String xml, final java.lang.String xmlName, final java.util.Date xmlDate, final java.lang.String stringSigned, final java.lang.String signature, final java.lang.String certNumber, final java.lang.String certBase64, boolean omitXmlDeclaration) throws java.io.IOException, java.lang.Exception {
        int result = 0;
        String xmlFile = "";
        String xmlFileName = "";
        String xmlFilePath = "";
        BufferedWriter bw = null;

        resetLastMembers();
        xmlFileName = xmlName;
        xmlFilePath = msXmlBaseDir + xmlFileName;

        xmlFile += xml; // create new String from provided one
        
        bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(xmlFilePath), "UTF-8"));
        bw.write(xmlFile);
        bw.close();

        mtLastTimestamp = xmlDate;
        msLastStringSigned = stringSigned;
        msLastSignature = signature;
        msLastXml = xmlFile;
        msLastXmlFileName = xmlFileName;
        msLastXmlFilePath = xmlFilePath;

        return result;
    }

    /**
     * Generates two-dimensional bar code
     * @param sDatas Datas of bar code
     * @return QR Code
     */
    /*
    private String getQrCode(String xmlFileName, cfd.ver3.DElementComprobante comprobante, String uuid)  throws java.lang.Exception {
	String sQRcode = msXmlBaseDir + xmlFileName.replace(".xml", ".jpg");
        String sDatasQRCode  = "";
        String sTotalDps = "";
        String sIntegerPart = "";
        String sDecimalPart = "";
        String sCeros = "";
        int nDecimalPoint = 0;
        BufferedImage oBufferedImage = null;
        BitMatrix oBitMatrix = null;
        Writer oWriter = new QRCodeWriter();
        FileOutputStream oFileOutput = null;

        sDatasQRCode += "?re=" +  comprobante.getEltEmisor().getAttRfc();
        sDatasQRCode += "&rr=" +  comprobante.getEltReceptor().getAttRfc();
        sTotalDps =  "" + comprobante.getAttTotal().getDouble();
        nDecimalPoint = sTotalDps.indexOf('.');

        sIntegerPart = sTotalDps.substring(0, nDecimalPoint);
        sDecimalPart = sTotalDps.substring(nDecimalPoint + 1, sTotalDps.length());

        for (int i = 0; i < 10 - sIntegerPart.length(); i++ ) {
            sCeros += "0";
        }
        sIntegerPart = sCeros + sIntegerPart;
        sCeros = "";

        for (int i = 0; i < 6 - sDecimalPart.length(); i++ ) {
            sCeros += "0";
        }
        sDecimalPart = sDecimalPart + sCeros;

        sTotalDps = sIntegerPart + "." + sDecimalPart;
        sDatasQRCode += "&tt=" + sTotalDps + "&id=" + uuid;

        try {
            oBitMatrix = oWriter.encode(sDatasQRCode, BarcodeFormat.QR_CODE, 140, 140);
        }
        catch (WriterException e) {
            e.printStackTrace(System.err);
        }

        oBufferedImage = new BufferedImage(140, 140, BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < 140; y++) {
            for (int x = 0; x < 140; x++) {
                 int grayValue = (oBitMatrix.get(x, y) ? 1 : 0) & 0xff;
                 oBufferedImage.setRGB(x, y, (grayValue == 0 ? 0xFFFFFF : 0));
            }
        }

        try {
            oFileOutput = new FileOutputStream(sQRcode);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace(System.err);
        }
        try {
            ImageIO.write(oBufferedImage, "jpg", oFileOutput);
        }
        catch (IOException e) {
            e.printStackTrace(System.err);
        }
        try {
            oFileOutput.close();
        }
        catch (IOException e) {
            e.printStackTrace(System.err);
        }

        sQRcode = sQRcode.replaceAll(java.util.regex.Matcher.quoteReplacement(System.getProperty("file.separator")), "/");

        return sQRcode;
    }
    */

    public static BufferedImage createQrCodeBufferedImage(final String rfcEmisor, final String rfcReceptor, final double total, final String uuid) {
        int x = 0;
        int y = 0;
        int grayValue = 0;
        String data  = "";
        DecimalFormat decimalFormat = new DecimalFormat("0000000000.000000");
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = null;
        BufferedImage bufferedImage = null;

        data += "?re=" + rfcEmisor;
        data += "&rr=" + rfcReceptor;
        data += "&tt=" + decimalFormat.format(total);
        data += "&id=" + uuid;

        try {
            bufferedImage = new BufferedImage(140, 140, BufferedImage.TYPE_INT_RGB);
            bitMatrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, 140, 140);

            for (y = 0; y < 140; y++) {
                for (x = 0; x < 140; x++) {
                     grayValue = (bitMatrix.get(x, y) ? 1 : 0) & 0xff;
                     bufferedImage.setRGB(x, y, (grayValue == 0 ? 0xFFFFFF : 0));
                }
            }
        }
        catch (WriterException e) {
            e.printStackTrace(System.err);
        }
        catch (Exception e) {
            e.printStackTrace(System.err);
        }

        return bufferedImage;
    }
}
