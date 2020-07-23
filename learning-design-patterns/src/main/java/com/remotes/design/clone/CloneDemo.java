package com.remotes.design.clone;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/6/24
 */
@Getter
@Setter
public class CloneDemo implements Cloneable{
    private String name;
    private List<Object> addrs;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
