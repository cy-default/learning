package com.rm13.util;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-08-15
 */
public class JSONTest {

    @Test
    public void test(){
        Ob ob = JSON.parseObject("{\"element\":\"{\\\"type\\\":\\\"26\\\",\\\"imgSrc\\\":\\\"https://img2.mklmall.com/g1/M00/04/21/rBB52l1VH6OAVO2lAAf0MEmFnXU939.png!\\\",\\\"href\\\":\\\"\\\",\\\"videoSrc\\\":\\\"\\\",\\\"left\\\":0,\\\"top\\\":825,\\\"width\\\":375,\\\"height\\\":264,\\\"lineHeight\\\":0,\\\"animatedName\\\":\\\"\\\",\\\"duration\\\":1,\\\"delay\\\":0,\\\"playing\\\":false,\\\"loop\\\":false,\\\"opacity\\\":100,\\\"transform\\\":0,\\\"text\\\":\\\"\\\",\\\"textAlign\\\":\\\"left\\\",\\\"iconKey\\\":\\\"\\\",\\\"bg\\\":\\\"\\\",\\\"fontSize\\\":15,\\\"fontFamily\\\":\\\"微软雅黑\\\",\\\"fontWeight\\\":\\\"normal\\\",\\\"color\\\":\\\"#666666\\\",\\\"activeColor\\\":\\\"#009dd9\\\",\\\"background\\\":\\\"#ffffff\\\",\\\"zindex\\\":3,\\\"isPayCoupon\\\":false,\\\"couponName\\\":\\\"\\\",\\\"couponId\\\":\\\"\\\",\\\"textCouponId\\\":\\\"\\\",\\\"wecharId\\\":\\\"\\\",\\\"imgskey\\\":\\\"26\\\",\\\"couponType\\\":\\\"coupon1\\\",\\\"couponDes\\\":\\\"\\\",\\\"showType\\\":\\\"img\\\",\\\"carouselList\\\":[],\\\"couponOwnerType\\\":1,\\\"tempType\\\":\\\"\\\",\\\"couponIsIssuedMall\\\":true,\\\"groupCouponId\\\":\\\"\\\",\\\"subActivityId\\\":\\\"\\\",\\\"elementId\\\":\\\"\\\",\\\"elementType\\\":\\\"22\\\",\\\"applyName\\\":\\\"\\\",\\\"isMustApply\\\":true,\\\"couponInfo\\\":{},\\\"anchorName\\\":\\\"\\\",\\\"uuid\\\":\\\"1dbe7907-f678-48c3-2a9e-51bbc43ebf42\\\",\\\"timeEdition\\\":1565859753358}\",\"activityId\":\"143\",\"subActivityId\":178,\"locationUuid\":\"b0d06e1d-1972-8048-6951-4ad613b3cfe2\",\"optUuid\":\"1dbe7907-f678-48c3-2a9e-51bbc43ebf42\",\"issuedIdList\":[\"10058\"]}", Ob.class);
        System.out.println(ob);
    }
}
