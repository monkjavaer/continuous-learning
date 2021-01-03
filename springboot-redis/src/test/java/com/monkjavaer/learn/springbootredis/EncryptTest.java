package com.monkjavaer.learn.springbootredis;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.jupiter.api.Test;

/**
 * @author monkjavaer
 * @date 2021/1/3
 */
public class EncryptTest {
    // 密钥
    private static final String KEY = "123";

    @Test
    public void testEncrypt() {
        String ciphertext1 = encrypt("123");
        System.out.println(ciphertext1);
    }

    /**
     * 加密
     * @param text 明文
     * @return     密文
     */
    public static String encrypt(String text) {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(KEY);
        return encryptor.encrypt(text);
    }

    /**
     * 解密
     * @param ciphertext 密文
     * @return           明文
     */
    public static String decrypt(String ciphertext) {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(KEY);
        return encryptor.decrypt(ciphertext);
    }

}
