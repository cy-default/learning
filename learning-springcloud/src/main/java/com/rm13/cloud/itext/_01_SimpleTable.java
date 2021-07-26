package com.rm13.cloud.itext;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.UnitValue;

import java.io.File;


public class _01_SimpleTable {

    public static final String DEST = "./doc/itext/_01_SimpleTable.pdf";
    public static final int NUMBER = 16;

    public static void main(String[] args) throws Exception {
        File file = new File(DEST);
        file.getParentFile().mkdirs();

        new _01_SimpleTable().manipulatePdf(DEST);
        System.out.println("end");
    }

    protected void manipulatePdf(String dest) throws Exception {
        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(dest));
        Document doc = new Document(pdfDoc);

        Table table = new Table(UnitValue.createPercentArray(1)).useAllAvailableWidth();

        for (int i = 0; i < NUMBER; i++) {
            table.addCell("hi");
        }

        doc.add(table);

        doc.close();
    }
}
