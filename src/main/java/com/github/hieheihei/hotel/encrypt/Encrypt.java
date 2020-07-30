package com.github.hieheihei.hotel.encrypt;

import javax.crypto.*;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Encrypt {
    private SecretKey secretKey = null;
    private Cipher cipher = null;
    private static Encrypt encrypt = null;

    public Encrypt(SecretKey secretKey, Cipher cipher) {
        this.secretKey = secretKey;
        this.cipher = cipher;
    }

    public static Encrypt getEncrypt() throws NoSuchAlgorithmException, NoSuchPaddingException {
        if (encrypt == null) {
            KeyGenerator keyGenerator =
                    KeyGenerator.getInstance("DESede");
            keyGenerator.init(168);
            encrypt = new Encrypt(keyGenerator.generateKey(), Cipher.getInstance("DESede"));
        }
        return encrypt;
    }

    public String encrypt(String plain) throws UnsupportedEncodingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        byte[] plainTextBytes = plain.getBytes("UTF8");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] cipherBytes = cipher.doFinal(plainTextBytes);
        return Base64.getEncoder().encodeToString(cipherBytes);
    }

    public String decrypt(String encrypted) throws InvalidKeyException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException {
        byte[] cipherBytes = Base64.getDecoder().decode(encrypted);

        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(cipherBytes);
        return new String(decryptedBytes, "UTF8");
    }

}
