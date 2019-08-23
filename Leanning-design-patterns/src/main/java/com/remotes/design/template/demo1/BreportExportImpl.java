package com.remotes.design.template.demo1;

/**
 * B公司报表打印
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-08-06
 */
public class BreportExportImpl extends ExportTemplate {
    @Override
    public void printTitle() {
        System.out.println("打印B表头");
    }

    @Override
    public void printBody() {
        System.out.println("打印B正文");
    }

    @Override
    public void printTail() {
        System.out.println("打印B表尾");
    }

    @Override
    public void printWaterMark() {
        System.out.println("打印B水印");
    }
}
