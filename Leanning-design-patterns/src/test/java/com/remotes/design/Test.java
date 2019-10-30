package com.remotes.design;

import com.remotes.design.strategy.Cashier;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-07-18
 */
public class Test {

    public static void main(String[] args) {
        PParam search = new PParam();
        PResult result =  new PageTemplate<String, PParam>() {
            @Override
            public List<String> query(PParam search) {
                return null;
            }
        }.pageResult(search);
    }



}
