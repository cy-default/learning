package com.rm13.jvm;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2020/3/6
 */
public class PriceTest {
    public static void main(String[] args) {
        System.out.println(Price.Instance.currentPrice);
        final Price price = new Price(2.8);
        System.out.println(price.currentPrice);


        System.out.println(Price2.Instance.currentPrice);
        final Price2 price2 = new Price2(2.8);
        System.out.println(price2.currentPrice);
    }
}

class Price{
    final static Price Instance = new Price(2.8);
    static double initPrice = 20;
    double currentPrice;
    public Price(double discount){
        currentPrice = initPrice - discount;
    }
}


class Price2{

    final static Price2 Instance;
    static double initPrice = 0;
    double currentPrice = 0;

    static {
        Instance = new Price2(2.8);
        initPrice = 20;
    }

    {
        currentPrice = 10;
    }

    public Price2(double discount){
        currentPrice = initPrice - discount;
    }
}


