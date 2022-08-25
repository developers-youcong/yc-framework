package com.yc.common.core.base.utils.encryp;

import org.bouncycastle.crypto.digests.SM3Digest;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.pqc.math.linearalgebra.ByteUtils;

import java.io.UnsupportedEncodingException;
import java.security.Security;
import java.util.Arrays;

/**
 * @description:
 * @author: youcong
 */
public class SM3Util {
    private static final String ENCODING = "UTF-8";

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    /**
     * sm3算法加密
     *
     * @param paramStr 待加密字符串
     * @return 返回加密后，固定长度=32的16进制字符串
     * @explain
     */
    public static String encrypt(String paramStr) {
        // 将返回的hash值转换成16进制字符串
        String resultHexString = "";
        try {
            // 将字符串转换成byte数组
            byte[] srcData = paramStr.getBytes(ENCODING);
            // 调用hash()
            byte[] resultHash = hash(srcData);
            // 将返回的hash值转换成16进制字符串
            resultHexString = ByteUtils.toHexString(resultHash);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return resultHexString;
    }

    /**
     * 返回长度=32的byte数组
     *
     * @param srcData
     * @return
     * @explain 生成对应的hash值
     */
    public static byte[] hash(byte[] srcData) {
        SM3Digest digest = new SM3Digest();
        digest.update(srcData, 0, srcData.length);
        byte[] hash = new byte[digest.getDigestSize()];
        digest.doFinal(hash, 0);
        return hash;
    }

    /**
     * 判断源数据与加密数据是否一致
     *
     * @param srcStr       原字符串
     * @param sm3HexString 16进制字符串
     * @return 校验结果
     * @explain 通过验证原数组和生成的hash数组是否为同一数组，验证2者是否为同一数据
     */
    public static boolean verify(String srcStr, String sm3HexString) {
        boolean flag = false;
        try {
            byte[] srcData = srcStr.getBytes(ENCODING);
            byte[] sm3Hash = ByteUtils.fromHexString(sm3HexString);
            byte[] newHash = hash(srcData);
            if (Arrays.equals(newHash, sm3Hash)) {
                flag = true;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return flag;
    }

}
