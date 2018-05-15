package com.yllt.utils.crypto;

/**
 *
 * @author Administrator
 */
public interface ICrypto {

    public String decrypt(String content, String key);

    public String encrypt(String content, String key);
}
