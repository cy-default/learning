package com.rm13.cloud.encrypt;

import org.apache.commons.codec.binary.Hex;
import org.springframework.data.redis.util.ByteUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.spec.AlgorithmParameterSpec;

/**
 * 敏感数据处理逻辑
 *
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/6/9
 */
public class SensitiveDataProcess {
    //密钥
    private static final String KEY = "secretkey1234567";


    /**
     * 密码类逻辑处理
     */
    public static void password() {
        // 次适合做密码加密
        PasswordEncrypt.md5();
        // 最适合做密码加密
        PasswordEncrypt.bcrypt();
    }

    /**
     * 加密算法
     *  1: 对称加密算法
     *    1.1: DES (不安全)
     *    1.2: 3DES(性能差)
     *    1.3: AES(不是算法名称，而是算法标准)
     *      **: 重要特点: AES 有一个重要的特点就是分组加密体制，一次只能处理 128 位的明文，然后生成 128 位的密文。如果要加密很长的明文，那么就需要迭代处理，而迭代方式就叫做模式
     *      模式:
     *      1.3.1:ECB 模式（也叫电子密码本模式）ECB 模式简单，但是不安全，不推荐使用
     *
     *
     *  2: 非对称加密算法(公钥/私钥)
     */
    public static void aesECB() throws Exception {
        //密钥
        String key = "secretkey1234567";
        Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, setKey(KEY), (AlgorithmParameterSpec) null);
        String source = "lovemyrm13";
        System.out.println(Hex.encodeHexString(cipher.doFinal(source.getBytes())));
    }

    public static void aesCBC() throws Exception {
        //初始化向量
        String initVector = "abcdefghijklmnop";
        Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
        IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
        test(cipher, iv);
    }

    //测试逻辑
    private static void test(Cipher cipher, AlgorithmParameterSpec parameterSpec) throws Exception {
        //初始化Cipher
        cipher.init(Cipher.ENCRYPT_MODE, setKey(KEY), parameterSpec);
        //加密测试文本
        System.out.println("一次：" + Hex.encodeHexString(cipher.doFinal("abcdefghijklmnop".getBytes())));
        //加密重复一次的测试文本
        System.out.println("两次：" + Hex.encodeHexString(cipher.doFinal("abcdefghijklmnopabcdefghijklmnop".getBytes())));
        //下面测试是否可以通过操纵密文来操纵明文
        //发送方账号
        byte[] sender = "1000000000012345".getBytes();
        //接收方账号
        byte[] receiver = "1000000000034567".getBytes();
        //转账金额
        byte[] money = "0000000010000000".getBytes();
        //加密发送方账号
        System.out.println("发送方账号：" + Hex.encodeHexString(cipher.doFinal(sender)));
        //加密接收方账号
        System.out.println("接收方账号：" + Hex.encodeHexString(cipher.doFinal(receiver)));
        //加密金额
        System.out.println("金额：" + Hex.encodeHexString(cipher.doFinal(money)));
        //加密完整的转账信息
        byte[] result = cipher.doFinal(ByteUtils.concatAll(sender, receiver, money));
        System.out.println("完整数据：" + Hex.encodeHexString(result));
        //用于操纵密文的临时字节数组
        byte[] hack = new byte[result.length];
        //把密文前两段交换
        System.arraycopy(result, 16, hack, 0, 16);
        System.arraycopy(result, 0, hack, 16, 16);
        System.arraycopy(result, 32, hack, 32, 16);
        cipher.init(Cipher.DECRYPT_MODE, setKey(KEY), parameterSpec);
        //尝试解密
        System.out.println("原始明文：" + new String(ByteUtils.concatAll(sender, receiver, money)));
        System.out.println("操纵密文：" + new String(cipher.doFinal(hack)));
    }

    //获取加密秘钥帮助方法
    private static SecretKeySpec setKey(String secret) {
        return new SecretKeySpec(secret.getBytes(), "AES");
    }

}
