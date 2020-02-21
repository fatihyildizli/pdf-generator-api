package com.pdfgenerator.service;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
@Component
public class PdfService {
    public ByteArrayOutputStream generatePdfFromHTML(String html) throws IOException {
        try {
            com.itextpdf.text.Document document = new com.itextpdf.text.Document();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PdfWriter.getInstance(document, baos);

            document.open();
            HTMLWorker htmlWorker = new HTMLWorker(document);
            htmlWorker.parse(new StringReader(html));
            document.close();
            return baos;

        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return null;
    }
}
