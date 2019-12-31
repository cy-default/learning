package com.rm13.shiro.model.bo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019/12/24
 */
@Data
public class ResourceBO implements Serializable {

    /**
     * 权限码
     */
    private String permCode;

    /**
     * 资源名称
     */
    private String resName;

    /**
     * 资源URL
     */
    private String resUrl;

    /**
     * 资源类型：MENU BUTTON API
     */
    private String resType;
}
