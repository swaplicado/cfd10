/*
 * Copyright 2010-2011 Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public abstract class DUtilUtils {

    public static final TimeZone SysTimeZone = TimeZone.getTimeZone("GMT-06:00");
    public static final GregorianCalendar SysCalendar = new GregorianCalendar(SysTimeZone);
    public static final SimpleDateFormat DbmsDateFormatDate = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat DbmsDateFormatDatetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final DecimalFormat RoundingDecimalFormat = new DecimalFormat();

    static {
        RoundingDecimalFormat.setRoundingMode(RoundingMode.HALF_UP);
    }
    
    public static int parseInt(final String text) {
        int value = 0;

        try {
            value = Integer.parseInt(text.trim().replaceAll(",", "").replaceAll("%", ""));
        }
        catch (NumberFormatException e) { }

        return value;
    }

    public static long parseLong(final String text) {
        long value = 0;

        try {
            value = Long.parseLong(text.trim().replaceAll(",", "").replaceAll("%", ""));
        }
        catch (NumberFormatException e) { }

        return value;
    }

    public static float parseFloat(final String text) {
        float value = 0;

        try {
            value = Float.parseFloat(text.trim().replaceAll(",", "").replaceAll("%", ""));
        }
        catch (NumberFormatException e) { }

        return value;
    }

    public static double parseDouble(final String text) {
        double value = 0;

        try {
            value = Double.parseDouble(text.trim().replaceAll(",", "").replaceAll("%", ""));
        }
        catch (NumberFormatException e) { }

        return value;
    }

    public static double round(final double value, final int decimals) {
        //return Math.round(value * Math.pow(10, decimals)) / Math.pow(10, decimals);   this method has inconsistencies, e.g. 0.04615 rounded to 4 decimals results in 0.0461 instead of 0.0462!

        RoundingDecimalFormat.setMaximumFractionDigits(decimals);
        return parseDouble(RoundingDecimalFormat.format(value));
    }

    public static java.lang.String textRepeat(final String text, final int times) {
        String textRepeated = "";

        for (int i = 0; i < times; i++) {
            textRepeated += text;
        }

        return textRepeated;
    }

    public static java.lang.String textTrim(final String text) {
        String textTrimmed = text.trim();

        while (textTrimmed.indexOf("  ") != -1) {
            textTrimmed = textTrimmed.replaceAll("  ", " ");
        }

        return textTrimmed;
    }

    public static java.lang.String textForXml(final String text) {
        String textForXml = text;

        textForXml = textForXml.replaceAll("<", "&lt;");
        textForXml = textForXml.replaceAll(">", "&gt;");
        textForXml = textForXml.replaceAll("&", "&amp;");
        textForXml = textForXml.replaceAll("\'", "&apos;");
        textForXml = textForXml.replaceAll("\"", "&quot;");

        return textTrim(textForXml);
    }

    public static java.lang.String textForOriginalString(final String text) {
        String textForOriginalString = text;

        textForOriginalString = textForOriginalString.replaceAll("\b", " ");
        textForOriginalString = textForOriginalString.replaceAll("\t", " ");
        textForOriginalString = textForOriginalString.replaceAll("\n", " ");
        textForOriginalString = textForOriginalString.replaceAll("\f", " ");
        textForOriginalString = textForOriginalString.replaceAll("\r", " ");

        return textTrim(textForOriginalString);
    }

    public static java.lang.String generateOriginalString(final cfd.DElement rootElement) {
        return "||" + rootElement.getElementForOriginalString() + "|";
    }

    public static int getYear(java.util.Date date) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);
        return gc.get(GregorianCalendar.YEAR);
    }

    public static String readXml(final String filePath) throws FileNotFoundException, UnsupportedEncodingException, IOException, Exception {
        String line = "";
        String xml = "";
        int i = 0;
        BufferedReader br = null;

        br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"));

        while (true) {
            line = br.readLine();
            if (line == null) {
                break;
            }
            else {
                if (i == 0) {
                    line = line.substring(line.indexOf("<"));
                    i = 1;
                }
                xml += line;
            }
        }

        br.close();

        return xml;
    }
}
