package com.rm13.cloud.kaptcha;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.rm13.cloud.login.PassLogin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/7/2
 */
@Slf4j
@PassLogin
@RestController
@RequestMapping("/captcha")
public class KaptchaController {
    /**
     * 验证码工具
     */
    @Autowired
    DefaultKaptcha kaptchaProducer;


    /**
     * 直接响应图片验证码
     *
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/img/kaptcha")
    public void imgKaptcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
        byte[] captcha = null;
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            // 将生成的验证码保存在session中
            String createText = kaptchaProducer.createText();
            request.getSession().setAttribute("rightCode", createText);
            log.info("kaptcha:{}", createText);
            BufferedImage bi = kaptchaProducer.createImage(createText);
            ImageIO.write(bi, "jpg", out);
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        captcha = out.toByteArray();
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        ServletOutputStream sout = response.getOutputStream();
        sout.write(captcha);
        sout.flush();
        sout.close();
    }


    /**
     * 直接响应base64位验证码
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/base64/kaptcha")
    public String base64Kaptcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 生成文字验证码
        String content = kaptchaProducer.createText();
        // 生成图片验证码
        ByteArrayOutputStream outputStream = null;
        BufferedImage image = kaptchaProducer.createImage(content);

        outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", outputStream);
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();

        String str = "data:image/jpeg;base64,";
        String base64Img = str + encoder.encode(outputStream.toByteArray()).replace("\n", "").replace("\r", "");

        return base64Img;
    }

}
