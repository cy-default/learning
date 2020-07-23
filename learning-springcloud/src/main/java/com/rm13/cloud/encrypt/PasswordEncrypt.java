package com.rm13.cloud.encrypt;

import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.digest.DigestUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/6/9
 */
public class PasswordEncrypt {

    /**
     * md5: 是散列，哈希算法，摘要算法
     * 单向的散列算法:（不是加密算法）
     * 运算后固定长度的摘要信息
     */
    public static void md5() {
        System.out.println("md5======");
        String salt = IdUtil.simpleUUID();
        String password = "lovemyrm13";
        String password2 = salt.concat(password);
        final String result = DigestUtil.md5Hex(password2);
        System.out.println(password2);
        System.out.println(password2.length());
        System.out.println(result);
        System.out.println(result.length());
    }

    /**
     * 密码最好采用这种模式
     * <p>
     * 固定长度：60
     * BCrypt 把盐作为了算法的一部分，强制我们遵循安全保存密码的最佳实践
     * 生成的盐和哈希后的密码拼在了一起：
     * $2a$10$D1alu2vifGQvmB/YHczwLOL1c1giNNBdT.MVAZvQ9Uk3Uh4yrVJOS
     * $是字段分隔符，其中第一个$后的 2a 代表算法版本，第二个$后的 10 是代价因子（默认是 10，代表 2 的 10 次方次哈希），第三个$后的 22 个字符是盐，再后面是摘要。
     * 代价因子的值越大，BCrypt 哈希的耗时越久
     */
    public static void bcrypt() {
        System.out.println("bcrypt1======");
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = "lovemyrm13";
        String result = encoder.encode(password);
        System.out.println(result);
        System.out.println(result.length());
        System.out.println(encoder.matches(password, result));

        System.out.println("bcrypt2======");
        password = IdUtil.simpleUUID();
        result = encoder.encode(password);
        System.out.println(result);
        System.out.println(result.length());
        System.out.println(encoder.matches(password, result));
    }

    public static void main(String[] args) {
        md5();
        bcrypt();
    }
}
