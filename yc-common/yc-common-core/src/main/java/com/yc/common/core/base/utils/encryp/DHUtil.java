package com.yc.common.core.base.utils.encryp;

import javax.crypto.*;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: youcong
 */
public class DHUtil {
    /**
     * 定义加密方式
     */
    private static final String KEY_DH = "DH";
    public static final String PUBLIC_KEY = "DHPublicKey";
    public static final String PRIVATE_KEY = "DHPrivateKey";
    // 开始生成本地密钥SecretKey 密钥算法为对称密码算法
    // 可以为 DES DES AES
    public static final String KEY_DH_DES = "DES";

    /**
     * 甲方初始化并返回密钥对
     *
     * @return
     */
    public static Map<String, Object> initKey() {
        try {
            // 实例化密钥对生成器
            KeyPairGenerator keyPairGenerator = KeyPairGenerator
                    .getInstance(KEY_DH);
            // 初始化密钥对生成器 默认是1024 512-1024 & 64的倍数
            keyPairGenerator.initialize(1024);
            // 生成密钥对
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            // 得到甲方公钥
            DHPublicKey publicKey = (DHPublicKey) keyPair.getPublic();
            // 得到甲方私钥
            DHPrivateKey privateKey = (DHPrivateKey) keyPair.getPrivate();
            // 将公钥和私钥封装在Map中， 方便之后使用
            Map<String, Object> keyMap = new HashMap<String, Object>();
            keyMap.put(PUBLIC_KEY, publicKey);
            keyMap.put(PRIVATE_KEY, privateKey);
            return keyMap;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 乙方根据甲方公钥初始化并返回密钥对
     *
     * @param key 甲方的公钥
     * @return
     */
    public static Map<String, Object> initKey(byte[] key) {
        try {
            // 将甲方公钥从字节数组转换为PublicKey
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(key);
            // 实例化密钥工厂
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_DH);
            // 产生甲方公钥pubKey
            DHPublicKey dhPublicKey = (DHPublicKey) keyFactory
                    .generatePublic(keySpec);
            // 剖析甲方公钥，得到其参数
            DHParameterSpec dhParameterSpec = dhPublicKey.getParams();
            // 实例化密钥对生成器
            KeyPairGenerator keyPairGenerator = KeyPairGenerator
                    .getInstance(KEY_DH);
            // 用甲方公钥初始化密钥对生成器
            keyPairGenerator.initialize(dhParameterSpec);
            // 产生密钥对
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            // 得到乙方公钥
            DHPublicKey publicKey = (DHPublicKey) keyPair.getPublic();
            // 得到乙方私钥
            DHPrivateKey privateKey = (DHPrivateKey) keyPair.getPrivate();
            // 将公钥和私钥封装在Map中， 方便之后使用
            Map<String, Object> keyMap = new HashMap<String, Object>();
            keyMap.put(PUBLIC_KEY, publicKey);
            keyMap.put(PRIVATE_KEY, privateKey);
            return keyMap;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 根据对方的公钥和自己的私钥生成 本地密钥,返回的是SecretKey对象的字节数组
     *
     * @param publicKey  公钥
     * @param privateKey 私钥
     * @return
     */
    public static byte[] getSecretKeyBytes(byte[] publicKey, byte[] privateKey) {
        try {
            // 实例化密钥工厂
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_DH);
            // 将公钥从字节数组转换为PublicKey
            X509EncodedKeySpec pubKeySpec = new X509EncodedKeySpec(publicKey);
            PublicKey pubKey = keyFactory.generatePublic(pubKeySpec);
            // 将私钥从字节数组转换为PrivateKey
            PKCS8EncodedKeySpec priKeySpec = new PKCS8EncodedKeySpec(privateKey);
            PrivateKey priKey = keyFactory.generatePrivate(priKeySpec);

            // 准备根据以上公钥和私钥生成本地密钥SecretKey
            // 先实例化KeyAgreement
            KeyAgreement keyAgreement = KeyAgreement.getInstance(KEY_DH);
            // 用自己的私钥初始化keyAgreement
            keyAgreement.init(priKey);
            // 结合对方的公钥进行运算
            keyAgreement.doPhase(pubKey, true);
            // 开始生成本地密钥SecretKey 密钥算法为对称密码算法
            SecretKey secretKey = keyAgreement.generateSecret(KEY_DH_DES);
            return secretKey.getEncoded();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 根据对方的公钥和自己的私钥生成 本地密钥,返回的是SecretKey对象
     *
     * @param publicKey  公钥
     * @param privateKey 私钥
     * @return
     */
    public static SecretKey getSecretKey(byte[] publicKey, byte[] privateKey) {
        try {
            // 实例化密钥工厂
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_DH);
            // 将公钥从字节数组转换为PublicKey
            X509EncodedKeySpec pubKeySpec = new X509EncodedKeySpec(publicKey);
            PublicKey pubKey = keyFactory.generatePublic(pubKeySpec);
            // 将私钥从字节数组转换为PrivateKey
            PKCS8EncodedKeySpec priKeySpec = new PKCS8EncodedKeySpec(privateKey);
            PrivateKey priKey = keyFactory.generatePrivate(priKeySpec);

            // 准备根据以上公钥和私钥生成本地密钥SecretKey
            // 先实例化KeyAgreement
            KeyAgreement keyAgreement = KeyAgreement.getInstance(KEY_DH);
            // 用自己的私钥初始化keyAgreement
            keyAgreement.init(priKey);
            // 结合对方的公钥进行运算
            keyAgreement.doPhase(pubKey, true);
            // 开始生成本地密钥SecretKey 密钥算法为对称密码算法
            SecretKey secretKey = keyAgreement.generateSecret(KEY_DH_DES);
            return secretKey;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 从 Map 中取得公钥
     *
     * @param keyMap
     * @return
     */
    public static byte[] getPublicKey(Map<String, Object> keyMap) {
        DHPublicKey key = (DHPublicKey) keyMap.get(PUBLIC_KEY);
        return key.getEncoded();
    }

    /**
     * 从 Map 中取得私钥
     *
     * @param keyMap
     * @return
     */
    public static byte[] getPrivateKey(Map<String, Object> keyMap) {
        DHPrivateKey key = (DHPrivateKey) keyMap.get(PRIVATE_KEY);
        return key.getEncoded();
    }

    /**
     * DH 加密
     *
     * @param data       带加密数据
     * @param publicKey  甲方公钥
     * @param privateKey 乙方私钥
     * @return
     */
    public static byte[] encryptDH(byte[] data, byte[] publicKey,
                                   byte[] privateKey) {
        byte[] bytes = null;
        try {
            //
            SecretKey secretKey = getSecretKey(publicKey, privateKey);
            // 数据加密
            Cipher cipher = Cipher.getInstance(secretKey.getAlgorithm());
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            bytes = cipher.doFinal(data);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return bytes;
    }

    /**
     * DH 解密
     *
     * @param data       待解密数据
     * @param publicKey  乙方公钥
     * @param privateKey 甲方私钥
     * @return
     */
    public static byte[] decryptDH(byte[] data, byte[] publicKey,
                                   byte[] privateKey) {
        byte[] bytes = null;
        try {
            //
            SecretKey secretKey = getSecretKey(publicKey, privateKey);
            // 数据加密
            Cipher cipher = Cipher.getInstance(secretKey.getAlgorithm());
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            bytes = cipher.doFinal(data);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return bytes;
    }

    public static String fromBytesToHex(byte[] resultBytes) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < resultBytes.length; i++) {
            if (Integer.toHexString(0xFF & resultBytes[i]).length() == 1) {
                builder.append("0").append(
                        Integer.toHexString(0xFF & resultBytes[i]));
            } else {
                builder.append(Integer.toHexString(0xFF & resultBytes[i]));
            }
        }
        return builder.toString();
    }

    // 待加密的明文
    public static final String DATA = "Java DH";

    public static void main(String[] args) throws Exception {
        /* Test DH */
        // 甲方公钥
        byte[] publicKey1;
        // 甲方私钥
        byte[] privateKey1;
        // 甲方本地密钥
        byte[] secretKey1;
        // 乙方公钥
        byte[] publicKey2;
        // 乙方私钥
        byte[] privateKey2;
        // 乙方本地密钥
        byte[] secretKey2;

        // 初始化密钥 并生成甲方密钥对
        Map<String, Object> keyMap1 = DHUtil.initKey();
        publicKey1 = DHUtil.getPublicKey(keyMap1);
        privateKey1 = DHUtil.getPrivateKey(keyMap1);
        System.out
                .println("DH 甲方公钥 : " + fromBytesToHex(publicKey1));
        System.out.println("DH 甲方私钥 : "
                + fromBytesToHex(privateKey1));

        // 乙方根据甲方公钥产生乙方密钥对
        Map<String, Object> keyMap2 = DHUtil.initKey(publicKey1);
        publicKey2 = DHUtil.getPublicKey(keyMap2);
        privateKey2 = DHUtil.getPrivateKey(keyMap2);
        System.out
                .println("DH 乙方公钥 : " + fromBytesToHex(publicKey2));
        System.out.println("DH 乙方私钥 : "
                + fromBytesToHex(privateKey2));

        // 对于甲方， 根据其私钥和乙方发过来的公钥， 生成其本地密钥secretKey1
        secretKey1 = DHUtil.getSecretKeyBytes(publicKey2, privateKey1);
        System.out.println("DH 甲方 本地密钥 : "
                + fromBytesToHex(secretKey1));

        // 对于乙方， 根据其私钥和甲方发过来的公钥， 生成其本地密钥secretKey2
        secretKey2 = DHUtil.getSecretKeyBytes(publicKey1, privateKey2);
        System.out.println("DH 乙方 本地密钥 : "
                + fromBytesToHex(secretKey2));
        // ---------------------------
        // 测试数据加密和解密
        System.out.println("加密前的数据" + DATA);
        // 甲方进行数据的加密
        // 用的是甲方的私钥和乙方的公钥
        byte[] encryptDH = DHUtil.encryptDH(DATA.getBytes(), publicKey2,
                privateKey1);
        System.out.println("加密后的数据 字节数组转16进制显示"
                + fromBytesToHex(encryptDH));
        // 乙方进行数据的解密
        // 用的是乙方的私钥和甲方的公钥
        byte[] decryptDH = DHUtil.decryptDH(encryptDH, publicKey1, privateKey2);
        System.out.println("解密后数据:" + new String(decryptDH));
    }
}
