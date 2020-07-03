package com.rm13.wx.entity.bo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/7/1
 */
@Data
public class WxUser implements Serializable {
    private String openId;
    private String unionId;
    // private String nickname;
    // private String headImgUrl;
}
