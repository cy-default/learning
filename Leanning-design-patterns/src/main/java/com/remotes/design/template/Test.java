package com.remotes.design.template;

/**
 * 模版方法模式
 * @author yuan.chen
 * @email chen.yuan135@chinaredstar.com
 * @Date 2019-08-06
 */
public class Test {
    public static void main(String[] args) {
        ExportTemplate export;
        export = new BreportExportImpl();
        export.export();

        export = new AreportExportImpl();
        export.export();
    }
}
