package com.pdfgenerator.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.pdfgenerator.*"})
public class PdfgeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(PdfgeneratorApplication.class, args);
    }

}
