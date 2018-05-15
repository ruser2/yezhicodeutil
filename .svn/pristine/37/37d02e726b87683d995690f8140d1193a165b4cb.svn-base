package com.yllt.utils.crypto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

/**
 *
 * @author Administrator
 */
public class Base64Crypto implements ICrypto{
    private  static final Logger logger = LoggerFactory.getLogger(Base64Crypto.class);

    public static byte[] decode(String content) {
        byte[] result = null;
        try {
        	BASE64Decoder base64Decoder = new BASE64Decoder();
            result = base64Decoder.decodeBuffer(content);
        } catch (IOException ex) {
            logger.error("decode 解密时候出现异常", ex);
        }
        return result;
    }

    public static String decodeToString(String content) {
        String result = null;
        try {
        	BASE64Decoder base64Decoder = new BASE64Decoder();
            byte[] contents = base64Decoder.decodeBuffer(content);
            result = new String(contents, "UTF-8");
        } catch (Exception ex) {
            logger.error("decodeToString 解密时候出现异常", ex);
        }
        return result;
    }

    public static String encode(byte[] bytes) {
    	BASE64Encoder base64Encoder = new BASE64Encoder();
        String result = base64Encoder.encode(bytes);
        return result.replace("\n", "").replace("\r", "");
    }

    @Override
    public String decrypt(String content, String key) {
        String result = null;
        try {
            BASE64Decoder base64Decoder = new BASE64Decoder();
            byte[] contents = base64Decoder.decodeBuffer(content);
            result = new String(contents, "UTF-8");
        } catch (Exception ex) {
            logger.error("decodeToString 解密时候出现异常", ex);
        }
        return result;
    }

    @Override
    public String encrypt(String content, String key) {
        BASE64Encoder base64Encoder = new BASE64Encoder();
        String result = base64Encoder.encode(content.getBytes());
        return result.replace("\n", "").replace("\r", "");
    }
    
    public static void main(String[] args) {
    	Base64Crypto base64Crypto = new Base64Crypto();
		System.out.println(base64Crypto.encrypt("{\"token\":\"123456\",\"user\":\"123456\"}","123456"));
		System.out.println(base64Crypto.decrypt("eyJ0b2tlbiI6IjEyMzQ1NiIsInVzZXIiOiIxMjM0NTYifQ==", "123456"));
		
	}
}
