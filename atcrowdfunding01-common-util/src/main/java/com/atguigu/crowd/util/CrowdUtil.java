package com.atguigu.crowd.util;

import com.atguigu.crowd.constant.CrowdConstant;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 判断请求方式的工具类
 */
public class CrowdUtil {
    /**
     * 判断当前请求是否为ajax请求
     * @param request
     * @return
     *      true:是ajax请求
     */
    public static boolean judgeRequestType(HttpServletRequest request){

        //获取请求消息头
        String acceptHeader = request.getHeader("Accept");
        String xRequestedHeader = request.getHeader("X-Requested-With");

        if (acceptHeader != null && acceptHeader.contains("application/json")){
            return true;
        }

        if (xRequestedHeader != null && xRequestedHeader.equals("XMLHttpRequest")){
            return true;
        }

        return false;
    }

    /**
     * 对密码进行MD5加密工具类
     * @param source
     * @return
     */
    public static String md5(String source){
        // 1、判断source是否是一个有效值
        if (source == null || source.length() == 0){
            //如果不是有效字符串，则抛出异常
            throw new RuntimeException(CrowdConstant.MESSAGE_STRING_INVALIDATE);
        }

        try {
            // 2、获取MessageDigest对象
            String algorithm = "md5"; // 加密算法名称
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);

            // 3、获取明文字符串对应的字节数组
            byte[] input = source.getBytes();

            // 4、执行加密
            byte[] output = messageDigest.digest(input);

            // 5、创建一个BigInteger对象
            int signum = 1;

            BigInteger bigInteger = new BigInteger(signum, output);

            // 6、按照十六进制将BigInteger的值转换
            int redis = 16;
            String encoded = bigInteger.toString(redis).toUpperCase();

            return encoded;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }
}
