package com.project.resume_builder.tests;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.hibernate.validator.internal.util.Contracts.assertTrue;

public class CreatePdfTest {

    @BeforeEach
    public void setup() {
        File resultsDir = new File("results");
        if (!resultsDir.exists()) {
            resultsDir.mkdirs();
        }
    }

    @Test
    public void testCreatePdf() {
        String dest = "results/sample.pdf";
        try {
            PdfWriter writer = new PdfWriter(dest);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            document.add(new Paragraph("Hello, World!"));

            document.close();

            // Проверяем, что PDF файл был создан
            File file = new File(dest);
            assertTrue(file.exists(), "PDF file should be created");
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false, "Exception occurred: " + e.getMessage());
        }
    }
}
