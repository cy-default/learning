package com.remotes.design.handler3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-07-25
 */
public class CaseChain implements BaseCase {

    /**
     * 所有的case列表
     */
    private List<BaseCase> list = new ArrayList<>();

    /**
     * 索引， 用于遍历所有case列表
     */
    private Integer index = 0;

    /**
     * chain 重置
     */
    public void reset(){
        this.index = 0;
    }


    /**
     * 添加 case
     * @param baseCase
     * @return
     */
    public CaseChain addBaseCase(BaseCase baseCase){
        list.add(baseCase);
        return this;
    }

    @Override
    public void doSomething(String input, BaseCase baseCase) {
        // 所有遍历完成了， 直接返回
        if(index == list.size()){
            return;
        }
        // 获取当前 case
        BaseCase current = list.get(index);
        // 修改索引值， 以便下次回调获取下个节点， 达到遍历效果
        index++;
        // 调用当前case处理方法
        current.doSomething(input, this);
    }
}
