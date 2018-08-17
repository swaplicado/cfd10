/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd;

import cfd.ver33.DCfdi33Consts;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import sa.lib.SLibUtils;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public final class DCfd {

    private java.lang.String msXmlBaseDir;

    private java.util.Date mtLastTimestamp;
    private java.lang.String msLastStringSigned;
    private java.lang.String msLastSignature;
    private java.lang.String msLastXml;
    private java.lang.String msLastXmlFileName;
    private java.lang.String msLastXmlFilePath;

    public DCfd(java.lang.String xmlBaseDir) {
        msXmlBaseDir = xmlBaseDir;
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
    public java.util.Date getLastTimestamp() { return mtLastTimestamp; }
    public java.lang.String getLastStringSigned() { return msLastStringSigned; }
    public java.lang.String getLastSignature() { return msLastSignature; }
    public java.lang.String getLastXml() { return msLastXml; }
    public java.lang.String getLastXmlFileName() { return msLastXmlFileName; }
    public java.lang.String getLastXmlFilePath() { return msLastXmlFilePath; }

    public static String createFileName(cfd.ver2.DElementComprobante comprobante) {
        String fileName = "";

        fileName += comprobante.getEltEmisor().getAttRfc().getString() + "_";
        fileName += comprobante.getAttTipoDeComprobante().getOption().substring(0, 1).toUpperCase() + "_";
        fileName += (comprobante.getAttSerie().getString().isEmpty() ? "" : comprobante.getAttSerie().getString() + "_");
        fileName += DCfdUtils.CfdNumberFormat.format(SLibUtils.parseLong(comprobante.getAttFolio().getString()));

        return fileName;
    }

    public static String createFileName(cfd.ver32.DElementComprobante comprobante) {
        String fileName = "";

        fileName += comprobante.getEltEmisor().getAttRfc().getString() + "_";
        fileName += comprobante.getAttTipoDeComprobante().getOption().substring(0, 1).toUpperCase() + "_";
        fileName += (comprobante.getAttSerie().getString().isEmpty() ? "" : comprobante.getAttSerie().getString() + "_");
        fileName += DCfdUtils.CfdNumberFormat.format(SLibUtils.parseLong(comprobante.getAttFolio().getString()));

        return fileName;
    }

    public static String createFileName(cfd.ver33.DElementComprobante comprobante) {
        String fileName = "";

        fileName += comprobante.getEltEmisor().getAttRfc().getString() + "_";
        fileName += comprobante.getAttTipoDeComprobante().getString()+ "_";
        fileName += (comprobante.getAttSerie().getString().isEmpty() ? "" : comprobante.getAttSerie().getString() + "_");
        fileName += DCfdUtils.CfdNumberFormat.format(SLibUtils.parseLong(comprobante.getAttFolio().getString()));

        return fileName;
    }

    public int write(cfd.ver2.DElementComprobante comprobante, final java.lang.String stringSigned, final java.lang.String signature, final java.lang.String certNumber, final java.lang.String certBase64) throws java.io.IOException, java.lang.Exception {
        int result = 0;

        resetLastMembers();

        comprobante.getAttSello().setString(signature);
        comprobante.getAttNoCertificado().setString(certNumber);
        comprobante.getAttCertificado().setString(certBase64);

        String xmlFile = DCfdConsts.XML_HEADER + comprobante.getElementForXml();
        String xmlFileName = createFileName(comprobante) + ".xml";
        String xmlFilePath = msXmlBaseDir + xmlFileName;

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(xmlFilePath), "UTF-8"));
        bw.write(xmlFile);
        bw.close();

        mtLastTimestamp = comprobante.getAttFecha().getDatetime();
        msLastStringSigned = stringSigned;
        msLastSignature = signature;
        msLastXml = xmlFile;
        msLastXmlFileName = xmlFileName;
        msLastXmlFilePath = xmlFilePath;

        return result;
    }

    public int write(cfd.ver32.DElementComprobante comprobante, final java.lang.String stringSigned, final java.lang.String signature, final java.lang.String certNumber, final java.lang.String certBase64) throws java.io.IOException, java.lang.Exception {
        int result = 0;

        resetLastMembers();

        comprobante.getAttSello().setString(signature);
        comprobante.getAttNoCertificado().setString(certNumber);
        comprobante.getAttCertificado().setString(certBase64);

        String xmlFile = DCfdConsts.XML_HEADER + comprobante.getElementForXml();
        String xmlFileName = createFileName(comprobante) + ".xml";
        String xmlFilePath = msXmlBaseDir + xmlFileName;

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(xmlFilePath), "UTF-8"));
        bw.write(xmlFile);
        bw.close();

        mtLastTimestamp = comprobante.getAttFecha().getDatetime();
        msLastStringSigned = stringSigned;
        msLastSignature = signature;
        msLastXml = xmlFile;
        msLastXmlFileName = xmlFileName;
        msLastXmlFilePath = xmlFilePath;

        return result;
    }
    
    public int write(cfd.ver33.DElementComprobante comprobante, final java.lang.String stringSigned, final java.lang.String signature, final java.lang.String certNumber, final java.lang.String certBase64) throws java.io.IOException, java.lang.Exception {
        int result = 0;

        resetLastMembers();

        comprobante.getAttSello().setString(signature);
        comprobante.getAttNoCertificado().setString(certNumber);
        comprobante.getAttCertificado().setString(certBase64);

        String xmlFile = DCfdConsts.XML_HEADER + comprobante.getElementForXml();
        String xmlFileName = createFileName(comprobante) + ".xml";
        String xmlFilePath = msXmlBaseDir + xmlFileName;

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(xmlFilePath), "UTF-8"));
        bw.write(xmlFile);
        bw.close();

        mtLastTimestamp = comprobante.getAttFecha().getDatetime();
        msLastStringSigned = stringSigned;
        msLastSignature = signature;
        msLastXml = xmlFile;
        msLastXmlFileName = xmlFileName;
        msLastXmlFilePath = xmlFilePath;

        return result;
    }
    
    public int write(final java.lang.String xml, final java.lang.String xmlName, final java.util.Date xmlDate, final java.lang.String stringSigned, final java.lang.String signature) throws java.io.IOException, java.lang.Exception {
        int result = 0;

        resetLastMembers();
        
        String xmlFile = xml;
        String xmlFileName = xmlName;
        String xmlFilePath = msXmlBaseDir + xmlFileName;
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(xmlFilePath), "UTF-8"));
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

    public static BufferedImage createQrCodeBufferedImageCfdi32(final String rfcEmisor, final String rfcReceptor, final double total, final String uuid) {
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

    public static BufferedImage createQrCodeBufferedImageCfdi33(final String uuid, final String rfcEmisor, final String rfcReceptor, final double total, final String sello) {
        int x = 0;
        int y = 0;
        int grayValue = 0;
        String data  = "";
        DecimalFormat decimalFormat = new DecimalFormat("#." + SLibUtils.textRepeat("#", 6));
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = null;
        BufferedImage bufferedImage = null;

        data += DCfdi33Consts.URL_VERIFIC;
        data += "?id=" + (uuid == null || uuid.isEmpty() ? SLibUtils.textRepeat("0", 40) : uuid);
        data += "&re=" + (rfcEmisor == null || rfcEmisor.isEmpty() ? SLibUtils.textRepeat("X", 13) : rfcEmisor);
        data += "&rr=" + (rfcReceptor == null || rfcReceptor.isEmpty() ? SLibUtils.textRepeat("X", 13) : rfcReceptor);
        data += "&tt=" + decimalFormat.format(SLibUtils.roundAmount(total));
        data += "&fe=" + (sello == null || sello.isEmpty() ? SLibUtils.textRepeat("0", 8) : sello);

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
