/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cfd;

import java.io.BufferedWriter;      // not used, but preserved only for reference
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;    // not used, but preserved only for reference
import java.io.OutputStreamWriter;  // not used, but preserved only for reference
import java.security.KeyFactory;
import java.security.Signature;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.PKCS8EncodedKeySpec;
import java.text.DecimalFormat;     // not used, but preserved only for reference

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Base64;

import cfd.util.DUtilUtils;         // not used, but preserved only for reference

/**
 *
 * @author Sergio Abraham Flores Gutiérrez
 */
public class DCfdSignature {

    private java.lang.String msCertBase64;
    private java.lang.String msCertNumber;
    private java.security.PrivateKey miPrivateKey;      // RSA private key, PKCS #8 encoded, DER format, decrypted using 'openssl' (*.key file)
    private java.security.PublicKey miPublicKey;        // RSA public key, X.509 encoded (*.cer file)
    private java.util.Date mtDate;
    private java.util.Date mtExpirationDate;
    /*  Signature in 2 steps does not pass SAT validation.
         RSA encryption means to require ID of the hash algorithm also encrypted
    private java.security.MessageDigest moDigestMd5;    // former SAT digestion for original string
    private java.security.MessageDigest moDigestSha1;
    private javax.crypto.Cipher moCipherRsa;
    */
    private java.security.Signature moSignatureMd5WithRsa;
    private java.security.Signature moSignatureSha1WithRsa;

    public DCfdSignature(byte[] bytesPrivateKey, byte[] bytesPublicKey, java.lang.String certNumber) throws java.security.NoSuchAlgorithmException, java.lang.Exception {
        initMembers(certNumber);
        loadKeyPair(bytesPrivateKey, bytesPublicKey);
    }

    public DCfdSignature(java.lang.String fileNamePrivateKey, java.lang.String fileNamePublicKey, java.lang.String certNumber) throws java.security.NoSuchAlgorithmException, java.lang.Exception {
        initMembers(certNumber);
        loadKeyPair(readKey(fileNamePrivateKey), readKey(fileNamePublicKey));
    }

    private void initMembers(java.lang.String certNumber) throws java.security.NoSuchAlgorithmException {
        msCertBase64 = "";
        msCertNumber = certNumber;
        miPrivateKey = null;
        miPublicKey = null;
        mtDate = null;
        mtExpirationDate = null;

        /* Signature in 2 steps does not pass SAT validation.
         RSA encryption means to require ID of the hash algorithm also encrypted
        moDigestMd5 = MessageDigest.getInstance("MD5");
        System.out.println("Digest MD5 Provider: " + moDigestMd5.getProvider());
        System.out.println("Digest MD5 Algorithm: " + moDigestMd5.getAlgorithm());

        moDigestSha1 = MessageDigest.getInstance("SHA1");
        System.out.println("Digest SHA-1 Provider: " + moDigestSha1.getProvider());
        System.out.println("Digest SHA-1 Algorithm: " + moDigestSha1.getAlgorithm());

        moCipherRsa = Cipher.getInstance("RSA", new BouncyCastleProvider());
        System.out.println("Cipher Provider: " + moCipherRsa.getProvider());
        System.out.println("Cipher Algorithm: " + moCipherRsa.getAlgorithm());
        */

        moSignatureMd5WithRsa = Signature.getInstance("MD5withRSA");
        moSignatureSha1WithRsa = Signature.getInstance("SHA1withRSA");
        //System.out.println("Signature Provider: " + moSignatureSha1WithRsa.getProvider());
        //System.out.println("Signature Algorithm: " + moSignatureSha1WithRsa.getAlgorithm());
    }

    private byte[] readKey(java.lang.String fileName) throws java.io.FileNotFoundException, java.io.IOException {
        File f = new File(fileName);
        FileInputStream fis = new FileInputStream(f);
        DataInputStream dis = new DataInputStream(fis);
        byte[] bytes = new byte[(int) f.length()];
        dis.readFully(bytes);
        dis.close();

        return bytes;
    }

    private void loadKeyPair(byte[] bytesPrivateKey, byte[] bytesPublicKey) throws java.lang.Exception {
        // 1. Load private key:

        KeyFactory oKeyFactory = KeyFactory.getInstance("RSA", new BouncyCastleProvider());
        //System.out.println("Key Factory Provider: " + oKeyFactory.getProvider().getName());
        //System.out.println("Key Factory Algorithm: " + oKeyFactory.getAlgorithm());

        PKCS8EncodedKeySpec oPKCS8EncodedKeySpec = new PKCS8EncodedKeySpec(bytesPrivateKey);
        //System.out.println("Private Key Spec Format: " + oPKCS8EncodedKeySpec.getFormat());
        //System.out.println("Private Key Spec Class: " + oPKCS8EncodedKeySpec.getClass().getName());

        miPrivateKey = oKeyFactory.generatePrivate(oPKCS8EncodedKeySpec);
        //System.out.println("Private Key Algorithm: " + miPrivateKey.getAlgorithm());
        //System.out.println("Private Key Format: " + miPrivateKey.getFormat());
        //System.out.println("Private Key Class: " + miPrivateKey.getClass().getName());

        // 2. Load public key:

        CertificateFactory oCertificateFactory = CertificateFactory.getInstance("X.509");
        //System.out.println("Certificate Factory Provider: " + oCertificateFactory.getProvider());
        //System.out.println("Certificate Factory Type: " + oCertificateFactory.getType());

        /*  File Input Stream Option:
        FileInputStream fis = new FileInputStream(fileNamePublicKey);
        X509Certificate oX509Certificate = (X509Certificate) oCertificateFactory.generateCertificate(fis);
        fis.close();
         */

        ByteArrayInputStream bais = new ByteArrayInputStream(bytesPublicKey);
        X509Certificate oX509Certificate = (X509Certificate) oCertificateFactory.generateCertificate(bais);
        bais.close();

        miPublicKey = oX509Certificate.getPublicKey();
        //System.out.println("Public Key Algorithm: " + miPublicKey.getAlgorithm());
        //System.out.println("Public Key Format: " + miPublicKey.getFormat());
        //System.out.println("Public Key Class: " + miPublicKey.getClass().getName());

        msCertBase64 = new String(Base64.encode(bytesPublicKey));
    }

    public void setDate(java.util.Date date) { mtDate = date; }
    public void setExpirationDate(java.util.Date date) { mtExpirationDate = date; }

    public java.lang.String getCertBase64() { return msCertBase64; }
    public java.lang.String getCertNumber() { return msCertNumber; }

    public java.util.Date getDate() { return mtDate; }
    public java.util.Date getExpirationDate() { return mtExpirationDate; }

    public java.lang.String sign(java.lang.String stringToSign, int versionYear) throws java.lang.Exception {
        /*
        byte[] bytesDigestion = null;
        byte[] bytesCipherEncrypted = null;
        byte[] bytesCipherEncoded = null;
        byte[] bytesCipherDecoded = null;
        byte[] bytesCipherDecrypted = null;
        */
        byte[] bytesSignature = null;
        byte[] bytesSignatureEncoded = null;
        String stringSignature = "";
        /*
        String stringDigestion = "";
        String stringDecrypted = "";
        */

        /*
         * Option A. Compute signature 2 steps:
         * 1. SHA-1 digestion of orignal string;
         * 2. RSA encryption of SHA-1 digestion;
         * 3. Base 64 encoding of RSA encryption (sign).
         * 4. Base 64 decoding of sign.
         * 5. RSA decryption of Base 64 decoding of sign.
         */

        // 1. SHA-1 digestion of orignal string:

        /*
        bytesDigestion = moDigestMd5.digest(stringToSign.getBytes());
        stringDigestion = new String(bytesDigestion);
        System.out.println("MD5 digestion: {" + stringDigestion + "}");
        System.out.println("MD5 digestion: {" + new String(Base64.encode(bytesDigestion)) + "} (Base 64)");
        */
        /*
        bytesDigestion = moDigestSha1.digest(stringToSign.getBytes());
        stringDigestion = new String(bytesDigestion);
        System.out.println("SHA-1 digestion: {" + stringDigestion + "}");
        System.out.println("SHA-1 digestion: {" + new String(Base64.encode(bytesDigestion)) + "} (Base 64)");
        */

        // 2. RSA encryption of SHA-1 digestion:
        /*
        moCipherRsa.init(Cipher.ENCRYPT_MODE, miPrivateKey);
        bytesCipherEncrypted = moCipherRsa.doFinal(bytesDigestion);
        */
        // 3. Base 64 encoding of RSA encryption (sign):
        /*
        bytesCipherEncoded = Base64.encode(bytesCipherEncrypted);

        stringSigned = new String(bytesCipherEncoded);
        System.out.println("digestion, RSA encryption and Base 64 encoding (sign):");
        System.out.println(stringSigned);
        */
        // 4. Base 64 decoding of sign:
        /*
        bytesCipherDecoded = Base64.decode(bytesCipherEncoded);

        moCipherRsa.init(Cipher.DECRYPT_MODE, miPublicKey);
        bytesCipherDecrypted = moCipherRsa.doFinal(bytesCipherDecoded);   // this must be the original digestion
        stringDecrypted = new String(bytesCipherDecrypted);

        System.out.println("digestion decrypted: {" + stringDecrypted + "}");
        System.out.println("digestion decrypted: {" + new String(Base64.encode(bytesCipherDecrypted)) + "} (Base 64)");

        if (stringDigestion.compareTo(stringDecrypted) != 0) {
            throw new Exception("¡No fue posible validar la firma electrónica de la cadena original!");
        }
        */

        // Option B. Compute signature in 1 step:

        /*
         * NOTE:
         * This signature encrypts the ID of the hash algorithm concatenated with the digest.
         */

        if (versionYear <= 2010) {
            moSignatureMd5WithRsa.initSign(miPrivateKey);
            moSignatureMd5WithRsa.update(stringToSign.getBytes("UTF-8"));

            bytesSignature = moSignatureMd5WithRsa.sign();
        }
        else {
            moSignatureSha1WithRsa.initSign(miPrivateKey);
            moSignatureSha1WithRsa.update(stringToSign.getBytes("UTF-8"));

            bytesSignature = moSignatureSha1WithRsa.sign();
        }

        bytesSignatureEncoded = Base64.encode(bytesSignature);
        stringSignature = new String(bytesSignatureEncoded, "UTF-8");
        /*
        System.out.println("String to sign:");
        System.out.println("{" + stringToSign + "}");
        System.out.println("String to sign Base 64:");
        System.out.println("{" + new String(Base64.encode(stringToSign.getBytes())) + "}");
        System.out.println("String to sign Base 64 as if it were UTF-8:");
        System.out.println("{" + new String(Base64.encode(stringToSign.getBytes("UTF-8"))) + "}");
        System.out.println("Signature:");
        System.out.println("{" + stringSignature + "}");
        */

        return stringSignature;
    }
}
