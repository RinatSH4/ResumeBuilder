package com.project.resume_builder.services;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.project.resume_builder.models.Education;
import com.project.resume_builder.models.Experience;
import org.springframework.stereotype.Service;
import com.project.resume_builder.models.Resume;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class FileGenerationService {

    public byte[] generatePdf(Resume resume) {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            PdfWriter writer = new PdfWriter(baos);
            com.itextpdf.kernel.pdf.PdfDocument pdfDoc = new com.itextpdf.kernel.pdf.PdfDocument(writer);
            Document document = new Document(pdfDoc);

            addResumeDetailsToDocument(document, resume);

            document.close();
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void addResumeDetailsToDocument(Document document, Resume resume) {
        document.add(new Paragraph("Resume"));
        document.add(new Paragraph("Name: " + resume.getFirstName() + " " + resume.getLastName()));
        document.add(new Paragraph("Email: " + resume.getEmail()));
        document.add(new Paragraph("Phone: " + resume.getPhone()));

        addEducationDetails(document, resume.getEducationList());
        addExperienceDetails(document, resume.getExperienceList());
    }

    private void addEducationDetails(Document document, List<Education> educationList) {
        document.add(new Paragraph("Education:"));
        for (Education education : educationList) {
            document.add(new Paragraph(education.getDegree() + " from " + education.getUniversity()));
        }
    }

    private void addExperienceDetails(Document document, List<Experience> experienceList) {
        document.add(new Paragraph("Experience:"));
        for (Experience experience : experienceList) {
            document.add(new Paragraph(experience.getJobTitle() + " at " + experience.getCompany()));
        }
    }
}