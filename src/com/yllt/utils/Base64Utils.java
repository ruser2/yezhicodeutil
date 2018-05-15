package com.yllt.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author Administrator
 */
public class Base64Utils {
    private  static final Logger logger = LoggerFactory.getLogger(Base64Utils.class);
    private Base64Utils() {
    }

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
   
    
    public static void main(String[] args) throws UnsupportedEncodingException {
		String enc = encode("{\"token\":\"7613e58bd9bc40e4\",\"user\":\"123456\"}".getBytes("UTF-8"));
		System.out.println(enc);
		System.out.println(decodeToString(enc));
	}
}
