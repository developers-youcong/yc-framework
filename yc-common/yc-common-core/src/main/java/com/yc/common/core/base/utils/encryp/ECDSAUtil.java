package com.yc.common.core.base.utils.encryp;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.KeyAgreement;
import javax.xml.bind.DatatypeConverter;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * @description:
 * @author: youcong
 */
public class ECDSAUtil {

    private static String data = "ECDSA Java";
//    private final static String publicKey1 = "3059301306072A8648CE3D020106082A8648CE3D03010703420004A416FD8C6572CCD2345AC3310A02D44A0BF2BC2E22153A26ABE0CB01EFC62D286D002D9B1328590EE2A8890D52E54652EA1AC54FB9699A98953128B20A177734";
//    private final static String privateKey1 = "3041020100301306072A8648CE3D020106082A8648CE3D030107042730250201010420D0C7C40D4841EFA1F2AB1831C18EA8CDF73974F26475E0DFA393D822FA475FF7";
//    private final static String publicKey2 = "3059301306072a8648ce3d020106082a8648ce3d03010703420004767c30eae6ef41a24de0b61b730f5990924c7427d2f215a3478a871c0de4dfe34b5e6c275d447098d864499491c669012e8c2c6aeb1c8cffff3e34a5f8515c9a";
//    private final static String privateKey2 = "3041020100301306072a8648ce3d020106082a8648ce3d03010704273025020101042011353b6b2ee5975cf2c7efb836329a07794be70b58d64efc23e7311fb4352501";

    public static void main(String[] args) throws Exception {
//        加签验签
        KeyPair keyPair = getKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();
        String sign = signECDSA(privateKey, data);
        verifyECDSA(publicKey, sign, data);

//        生成公钥私钥1
//        KeyPair keyPair1 = getKeyPair();
//        PublicKey publicKey1 = keyPair1.getPublic();
//        PrivateKey privateKey1 = keyPair1.getPrivate();
//        System.out.println(Hex.encodeHexString(publicKey1.getEncoded()));
//        System.out.println(Hex.encodeHexString(privateKey1.getEncoded()));

//        生成公钥私钥2
//        KeyPair keyPair2 = getKeyPair();
//        PublicKey publicKey2 = keyPair2.getPublic();
//        PrivateKey privateKey2 = keyPair2.getPrivate();
//        System.out.println(Hex.encodeHexString(publicKey2.getEncoded()));
//        System.out.println(Hex.encodeHexString(privateKey2.getEncoded()));

        //生成多次的share key一样
//        for (int i = 0; i < 10; i++) {
//            String sharedKey1 = genSharedKey(publicKey1, privateKey2);
//            String sharedKey2 = genSharedKey(publicKey2, privateKey1);
//            System.out.println(sharedKey1);
//            System.out.println(sharedKey2);
//        }


    }

    //加签
    public static String signECDSA(PrivateKey privateKey, String message) {
        String result = "";
        try {
            //执行签名
            Signature signature = Signature.getInstance("SHA1withECDSA");
            signature.initSign(privateKey);
            signature.update(message.getBytes());
            byte[] sign = signature.sign();
            return Hex.encodeHexString(sign);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //验签
    public static boolean verifyECDSA(PublicKey publicKey, String signed, String message) {
        try {
            //验证签名
            Signature signature = Signature.getInstance("SHA1withECDSA");
            signature.initVerify(publicKey);
            signature.update(message.getBytes());

            byte[] hex = Hex.decodeHex(signed);
            boolean bool = signature.verify(hex);
            System.out.println("验证：" + bool);
            return bool;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 从string转private key
     */
    public static PrivateKey getPrivateKey(String key) throws Exception {
        byte[] bytes = DatatypeConverter.parseHexBinary(key);

        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(bytes);
        KeyFactory keyFactory = KeyFactory.getInstance("EC");
        return keyFactory.generatePrivate(keySpec);
    }

    /**
     * 从string转public key
     */
    public static PublicKey getPublicKey(String key) throws Exception {
        byte[] bytes = DatatypeConverter.parseHexBinary(key);

        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(bytes);
        KeyFactory keyFactory = KeyFactory.getInstance("EC");
        return keyFactory.generatePublic(keySpec);
    }


    /**
     * 生成 share key
     *
     * @param publicStr  公钥字符串
     * @param privateStr 私钥字符串
     * @return
     */
    public static String genSharedKey(String publicStr, String privateStr) {
        try {
            return genSharedKey(getPublicKey(publicStr), getPrivateKey(privateStr));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 生成 share key
     *
     * @param publicKey  公钥
     * @param privateKey 私钥
     * @return
     */
    public static String genSharedKey(PublicKey publicKey, PrivateKey privateKey) {
        String sharedKey = "";
        try {
            KeyAgreement ka = KeyAgreement.getInstance("ECDH");
            ka.init(privateKey);
            ka.doPhase(publicKey, true);
            sharedKey = Hex.encodeHexString(ka.generateSecret());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sharedKey;
    }

    //生成KeyPair
    public static KeyPair getKeyPair() throws Exception {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("EC");
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        keyGen.initialize(256, random);
        return keyGen.generateKeyPair();
    }


}
