/*
 * Copyright Sergio Abraham Flores Gutiérrez
 * All rights reserved.
 */

package cfd;

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DAttributeOptionMoneda extends cfd.DAttributeStringOption {

    public static final int CFD_ARS = 1;
    public static final int CFD_ATS = 2;
    public static final int CFD_AUD = 3;
    public static final int CFD_BEF = 4;
    public static final int CFD_BGL = 5;
    public static final int CFD_BRL = 6;
    public static final int CFD_CAD = 7;
    public static final int CFD_CHF = 8;
    public static final int CFD_CLP = 9;
    public static final int CFD_CNY = 10;
    public static final int CFD_COP = 11;
    public static final int CFD_CRC = 12;
    public static final int CFD_CUP = 13;
    public static final int CFD_CYP = 14;
    public static final int CFD_CZK = 15;
    public static final int CFD_DEM = 16;
    public static final int CFD_DKK = 17;
    public static final int CFD_DZD = 18;
    public static final int CFD_ECS = 19;
    public static final int CFD_EEK = 20;
    public static final int CFD_EGP = 21;
    public static final int CFD_ESP = 22;
    public static final int CFD_EUR = 23;
    public static final int CFD_FIM = 24;
    public static final int CFD_FRF = 25;
    public static final int CFD_GBP = 26;
    public static final int CFD_GRD = 27;
    public static final int CFD_GTQ = 28;
    public static final int CFD_HKD = 29;
    public static final int CFD_HNL = 30;
    public static final int CFD_HRD = 31;
    public static final int CFD_HUF = 32;
    public static final int CFD_IDR = 33;
    public static final int CFD_IEP = 34;
    public static final int CFD_ILS = 35;
    public static final int CFD_INR = 36;
    public static final int CFD_IQD = 37;
    public static final int CFD_IRR = 38;
    public static final int CFD_ISK = 39;
    public static final int CFD_ITL = 40;
    public static final int CFD_JOD = 41;
    public static final int CFD_JPY = 42;
    public static final int CFD_KPW = 43;
    public static final int CFD_KWD = 44;
    public static final int CFD_LKR = 45;
    public static final int CFD_LTL = 46;
    public static final int CFD_LUF = 47;
    public static final int CFD_LVL = 48;
    public static final int CFD_MAD = 49;
    public static final int CFD_MTL = 50;
    public static final int CFD_MXN = 51;
    public static final int CFD_MYR = 52;
    public static final int CFD_NAD = 53;
    public static final int CFD_NIO = 54;
    public static final int CFD_NLG = 55;
    public static final int CFD_NOK = 56;
    public static final int CFD_NZD = 57;
    public static final int CFD_PAB = 58;
    public static final int CFD_PEN = 59;
    public static final int CFD_PHP = 60;
    public static final int CFD_PKR = 61;
    public static final int CFD_PLZ = 62;
    public static final int CFD_PTE = 63;
    public static final int CFD_PYG = 64;
    public static final int CFD_ROL = 65;
    public static final int CFD_RUR = 66;
    public static final int CFD_SAR = 67;
    public static final int CFD_SEK = 68;
    public static final int CFD_SGD = 69;
    public static final int CFD_SIT = 70;
    public static final int CFD_SKK = 71;
    public static final int CFD_SVC = 72;
    public static final int CFD_THB = 73;
    public static final int CFD_TND = 74;
    public static final int CFD_TRL = 75;
    public static final int CFD_TWD = 76;
    public static final int CFD_USD = 77;
    public static final int CFD_UYU = 78;
    public static final int CFD_VEB = 79;
    public static final int CFD_XEU = 80;
    public static final int CFD_YUN = 81;
    public static final int CFD_ZAR = 82;

    public DAttributeOptionMoneda(java.lang.String name, boolean isRequired) {
        super(name, isRequired);

        moOptions.put(CFD_ARS, "ARS");
        moOptions.put(CFD_ATS, "ATS");
        moOptions.put(CFD_AUD, "AUD");
        moOptions.put(CFD_BEF, "BEF");
        moOptions.put(CFD_BGL, "BGL");
        moOptions.put(CFD_BRL, "BRL");
        moOptions.put(CFD_CAD, "CAD");
        moOptions.put(CFD_CHF, "CHF");
        moOptions.put(CFD_CLP, "CLP");
        moOptions.put(CFD_CNY, "CNY");
        moOptions.put(CFD_COP, "COP");
        moOptions.put(CFD_CRC, "CRC");
        moOptions.put(CFD_CUP, "CUP");
        moOptions.put(CFD_CYP, "CYP");
        moOptions.put(CFD_CZK, "CZK");
        moOptions.put(CFD_DEM, "DEM");
        moOptions.put(CFD_DKK, "DKK");
        moOptions.put(CFD_DZD, "DZD");
        moOptions.put(CFD_ECS, "ECS");
        moOptions.put(CFD_EEK, "EEK");
        moOptions.put(CFD_EGP, "EGP");
        moOptions.put(CFD_ESP, "ESP");
        moOptions.put(CFD_EUR, "EUR");
        moOptions.put(CFD_FIM, "FIM");
        moOptions.put(CFD_FRF, "FRF");
        moOptions.put(CFD_GBP, "GBP");
        moOptions.put(CFD_GRD, "GRD");
        moOptions.put(CFD_GTQ, "GTQ");
        moOptions.put(CFD_HKD, "HKD");
        moOptions.put(CFD_HNL, "HNL");
        moOptions.put(CFD_HRD, "HRD");
        moOptions.put(CFD_HUF, "HUF");
        moOptions.put(CFD_IDR, "IDR");
        moOptions.put(CFD_IEP, "IEP");
        moOptions.put(CFD_ILS, "ILS");
        moOptions.put(CFD_INR, "INR");
        moOptions.put(CFD_IQD, "IQD");
        moOptions.put(CFD_IRR, "IRR");
        moOptions.put(CFD_ISK, "ISK");
        moOptions.put(CFD_ITL, "ITL");
        moOptions.put(CFD_JOD, "JOD");
        moOptions.put(CFD_JPY, "JPY");
        moOptions.put(CFD_KPW, "KPW");
        moOptions.put(CFD_KWD, "KWD");
        moOptions.put(CFD_LKR, "LKR");
        moOptions.put(CFD_LTL, "LTL");
        moOptions.put(CFD_LUF, "LUF");
        moOptions.put(CFD_LVL, "LVL");
        moOptions.put(CFD_MAD, "MAD");
        moOptions.put(CFD_MTL, "MTL");
        moOptions.put(CFD_MXN, "MXN");
        moOptions.put(CFD_MYR, "MYR");
        moOptions.put(CFD_NAD, "NAD");
        moOptions.put(CFD_NIO, "NIO");
        moOptions.put(CFD_NLG, "NLG");
        moOptions.put(CFD_NOK, "NOK");
        moOptions.put(CFD_NZD, "NZD");
        moOptions.put(CFD_PAB, "PAB");
        moOptions.put(CFD_PEN, "PEN");
        moOptions.put(CFD_PHP, "PHP");
        moOptions.put(CFD_PKR, "PKR");
        moOptions.put(CFD_PLZ, "PLZ");
        moOptions.put(CFD_PTE, "PTE");
        moOptions.put(CFD_PYG, "PYG");
        moOptions.put(CFD_ROL, "ROL");
        moOptions.put(CFD_RUR, "RUR");
        moOptions.put(CFD_SAR, "SAR");
        moOptions.put(CFD_SEK, "SEK");
        moOptions.put(CFD_SGD, "SGD");
        moOptions.put(CFD_SIT, "SIT");
        moOptions.put(CFD_SKK, "SKK");
        moOptions.put(CFD_SVC, "SVC");
        moOptions.put(CFD_THB, "THB");
        moOptions.put(CFD_TND, "TND");
        moOptions.put(CFD_TRL, "TRL");
        moOptions.put(CFD_TWD, "TWD");
        moOptions.put(CFD_USD, "USD");
        moOptions.put(CFD_UYU, "UYU");
        moOptions.put(CFD_VEB, "VEB");
        moOptions.put(CFD_XEU, "XEU");
        moOptions.put(CFD_YUN, "YUN");
        moOptions.put(CFD_ZAR, "ZAR");
    }
}
