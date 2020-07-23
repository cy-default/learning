package com.rm13.cloud.encrypt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.spec.AlgorithmParameterSpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * AES加解密工具
 *
 * @author chenyuan
 */
public class AESUtils {
    private static final Logger logger = LoggerFactory.getLogger(AESUtils.class);

    private static String characterEncoding = "UTF-8";

    private static final String STR_KEY = "F9E8D7C6B5A4F3E2";
    private static final String STR_IV = "0A1B2C3D4E5F6E7D";

    public static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder(2 * bytes.length);

        for (int i = 0; i < bytes.length; i++) {
            String hexStr = String.format("%02X", bytes[i]);
            hexString.append(hexStr);
        }

        return hexString.toString();
    }

    private static byte[] hexToBytes(String str) {
        if (str == null) {
            return null;
        } else if (str.length() < 2) {
            return null;
        } else {
            int len = str.length() / 2;
            byte[] buffer = new byte[len];
            for (int i = 0; i < len; i++) {
                buffer[i] = (byte) Integer.parseInt(
                        str.substring(i * 2, i * 2 + 2), 16);
            }
            return buffer;
        }

    }

    public static String encryptCBC(String strPlainText) {
        try {
            SecretKeySpec key = new SecretKeySpec(STR_KEY.getBytes(), "AES");
            AlgorithmParameterSpec paramSpec = new IvParameterSpec(STR_IV.getBytes());
            Cipher ecipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
            return bytesToHex(ecipher.doFinal(strPlainText
                    .getBytes(characterEncoding))).toUpperCase();
        } catch (Exception e) {
            logger.error("encrypt error:{},{}", strPlainText, e.getMessage());
        }
        return strPlainText;
    }

    public static String decryptCBC(String value) {
        try {
            SecretKeySpec key = new SecretKeySpec(STR_KEY.getBytes(), "AES");
            AlgorithmParameterSpec paramSpec = new IvParameterSpec(STR_IV.getBytes());
            Cipher ecipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            ecipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
            return new String(ecipher.doFinal(hexToBytes(value)));
        } catch (Exception e) {
            logger.error("decrypt error:{},{}", value, e.getMessage());
        }
        return value;
    }

    public static void main(String[] args) {

        final List<String> strings = Arrays.asList("2A934EE1C65A8E720987FCF3A4B935FA", "CB8B196EF20154E3EEBF009A7859C80E");
        List<String> result = new ArrayList<>();
        for (String character : strings) {
            result.add(decryptCBC(character));
            System.out.println(decryptCBC(character));
        }
    }

}