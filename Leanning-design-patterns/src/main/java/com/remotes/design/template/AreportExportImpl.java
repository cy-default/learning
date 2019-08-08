package com.remotes.design.template;

/**
 * A公司报表打印
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-08-06
 */
public class AreportExportImpl extends ExportTemplate {
    @Override
    public void printTitle() {
        System.out.println("打印A表头");
    }

    @Override
    public void printBody() {
        System.out.println("打印A正文");
    }

    @Override
    public void printTail() {
        System.out.println("打印A表尾");
    }

    @Override
    public void printWaterMark() {
        System.out.println("打印A水印");
    }
}
