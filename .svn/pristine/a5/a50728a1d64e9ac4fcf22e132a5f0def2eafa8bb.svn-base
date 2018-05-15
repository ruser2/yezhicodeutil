package com.yllt.utils.crypto;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.log4j.Logger;

import com.yllt.utils.Base64Utils;

/**
 *
 * @author Administrator
 */
public class AESCrypto implements ICrypto {

//    public static void main(String args[]){
//
//        String[] packages = new String[] { "com.manager.service.services" };
//        ServiceConfigParser serviceConfigParser = new ServiceConfigParser();
//        serviceConfigParser.parse(packages);
//        RequestParam requestParam=new RequestParam();
//        requestParam.setAct("listModuleService");
//        ServiceConfig serviceConfig = ServiceFinder.findServiceConfig(requestParam);
//        CryptEnum cryptEnum=serviceConfig.getResponseCryptEnum();
//        CryptEnum cryptEnum2=serviceConfig.getRequestCryptEnum();
//        System.out.println(cryptEnum.equals(CryptEnum.PLAIN));
//        System.out.println(cryptEnum==CryptEnum.PLAIN);
//
//        System.out.println("---");
//
//        System.out.println(cryptEnum2.equals(CryptEnum.PLAIN));
//        System.out.println(cryptEnum2==CryptEnum.PLAIN);
//
//    }

    private static Logger logger = Logger.getLogger(MD5Crypto.class);
    @Override
    public String encrypt(String content, String key) {
        try {
            byte[] contentBytes = content.getBytes("UTF-8");
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
            byte[] encryptResult = cipher.doFinal(contentBytes);
            String result = Base64Utils.encode(encryptResult);
            return result = result.replace("\n", "").replace("\r", "");
        } catch (Exception ex) {
            logger.error("encode 解密时候出现异常", ex);
        }
        return null;
    }

    @Override
    public String decrypt(String content, String key) {
        String result = null;
        byte[] decryptResult = null;
        try {
            byte[] contentBytes = Base64Utils.decode(content);
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            decryptResult = cipher.doFinal(contentBytes);
            if (decryptResult != null) {
                result = new String(decryptResult, "UTF-8");
            }
        } catch (Exception ex) {
            logger.error("decode 解密时候出现异常", ex);
        }
        return result;

    }

    public static void main(String args[]){
        String key="7613e58bd9bc40e4";
        String data = "{\"name\":\"1234\",\"id\":\"123456\"}";
        String enData="kfB/sMrQ2RXnUg6U9sz6AuJcijRNR0qsUfa/edS+p33W+XQaPN5XLAD7JVkVjfUOdOrF36gOkRGFXsWyQh8ZDkqSeK8EihefUsgUicCRaqYt6YFEZWuCzztbI1hxMtHleFlMEp/H2hXK1jkLAovsNMD+kVseQasatQw8Q8Iiddgd4I9WQD80Ikm0qUy/+a5S7PRy5QF8K2wgJSLM39dmhQ==";
        AESCrypto aesCrypto=new AESCrypto();
        String s=aesCrypto.decrypt(enData,key);
        System.out.println(aesCrypto.encrypt(data, key));
        System.out.print(s);

    }

}
