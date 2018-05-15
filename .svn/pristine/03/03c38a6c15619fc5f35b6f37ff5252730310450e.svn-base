package com.yllt.utils.crypto;

import java.util.HashMap;
import java.util.Map;

import com.yllt.enumeration.CryptEnum;

/**
 *
 * @author Administrator
 */
public class CryptoManager {

    private CryptoManager() {
    }
    private static CryptoManager cryptoManager=new CryptoManager();
    private static final Map<CryptEnum, ICrypto> cryptoMap = new HashMap<CryptEnum, ICrypto>(2, 1);

    static {
        cryptoMap.put(CryptEnum.AES, new AESCrypto());
        cryptoMap.put(CryptEnum.MD5, new MD5Crypto());
        cryptoMap.put(CryptEnum.BASE64, new Base64Crypto());
        cryptoMap.put(CryptEnum.PLAIN, new EmptyCrypto());
    }

    public static CryptoManager getInstance() {
        return cryptoManager;
    }

    public ICrypto getCrypto(CryptEnum cryptEnum) {
        return cryptoMap.get(cryptEnum);
    }
}
