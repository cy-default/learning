package com.remotes.design.template.demo1;

/**
 * 模版方法。 钩子方法
 *
 * 导出模版，内部算法定义好，抽象出待实现方法给子类。
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-08-06
 */
public abstract class ExportTemplate {

    /**
     * 文档导出
     */
    public final void export(){
        // 打印表头
        printTitle();
        // 打印正文
        printBody();
        // 打印表尾
        printTail();
        // 打印水印
        printWaterMark();
    }

    /**
     * 打印表头
     */
    public abstract void printTitle();

    /**
     * 打印正文
     */
    public abstract void printBody();

    /**
     * 打印表尾
     */
    public abstract void printTail();

    /**
     * 打印水印
     */
    public abstract void printWaterMark();

}
