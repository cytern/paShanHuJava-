package dam.jsoup.updatereport.updatreport.util;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;

public class AesUtil {
    public static String enAes(String msg){
        byte[] key = {13,22,35,24,55,66,74,82,94,101,121,42,113,24,45,56};
        SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES,key);
        return aes.encryptHex(msg);
    }


    public static String deAes(String msg){
        byte[] key = {13,22,35,24,55,66,74,82,94,101,121,42,113,24,45,56};
        SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES,key);
        return aes.decryptStr(msg, CharsetUtil.CHARSET_UTF_8);
    }
}

