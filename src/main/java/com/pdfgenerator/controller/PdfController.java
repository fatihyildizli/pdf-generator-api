package com.pdfgenerator.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import com.pdfgenerator.service.PdfService;

import javax.servlet.http.HttpServletResponse;

import java.io.IOException;



@RestController
public class PdfController {
    @Autowired
    PdfService service;

    @CrossOrigin(origins = {"*"})
    @RequestMapping(path = "/api/generatePdfFromHtml/", headers = "Accept=*/*", method = RequestMethod.POST,
            produces = "application/pdf")
    @ApiOperation(value = "Generate PDF from given HTML.", notes = "Generate pdf from given HTML input.")
    @ResponseBody
        public void generatePdfFromHTML(@RequestBody String html, HttpServletResponse response) throws IOException {

            if (service.generatePdfFromHTML(html).toByteArray().length > 0) {
                response.setHeader("Content-Disposition", "attachment;filename=result.pdf");
                response.setContentType("application/pdf");
                response.setContentLength(service.generatePdfFromHTML(html).toByteArray().length);
                response.getOutputStream().write(service.generatePdfFromHTML(html).toByteArray());
                response.setHeader("Cache-Control","must-revalidate, post-check=0, pre-check=0");
            }

        }

    }

