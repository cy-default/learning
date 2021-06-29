package com.rm13.cloud.guava;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.rm13.cloud.model.dto.Product;

import java.util.ArrayList;
import java.util.Collection;

public class GuavaTest {

    public static void main(String[] args) {
        hashMultimap();
    }

    public static void hashMultimap(){
        ArrayList<Product> productList = Lists.newArrayList(
                new Product("小米", 1),
                new Product("华为", 1),
                new Product("宝马", 2),
                new Product("三星", 1),
                new Product("菠萝", 3),
                new Product("奔驰", 2),
                new Product("西瓜", 3)
        );

        Multimap<Integer, Product> productMap = HashMultimap.create();
        for (Product product : productList) {
            productMap.put(product.getCategoryId(), product);
        }

        Collection<Product> products = productMap.get(1);
        System.out.println(JSON.toJSONString(products));
    }
}
