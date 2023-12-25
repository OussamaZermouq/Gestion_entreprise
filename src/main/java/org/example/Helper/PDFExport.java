package org.example.Helper;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfXrefTable;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public interface PDFExport {

    public static  void export_pdf(String path, String author, String title){
        // Output PDF file

        try {
            // Create a PdfWriter instance to write to the output file
            PdfWriter writer = new PdfWriter(new File(path));

            // Create a PdfDocument instance
            PdfDocument pdfDocument = new PdfDocument(writer);

            // Create a Document instance
            Document document = new Document(pdfDocument);

            // Set metadata
            pdfDocument.getDocumentInfo().setAuthor(author);
            pdfDocument.getDocumentInfo().setTitle(title);

            // Add content to the document
            document.add(new Paragraph("This is the content of the PDF document."));
            System.out.println("PDF with metadata generated successfully.");

            // Create a table with three columns
            Table table = new Table(3);

            // Add header cells
            table.addHeaderCell(new Cell().add(new Paragraph("mok")));
            table.addHeaderCell(new Cell().add(new Paragraph("mok2")));
            table.addHeaderCell(new Cell().add(new Paragraph("mok3")));

            // Add data cells
            table.addCell(new Cell().add(new Paragraph("Row 1, Col 1")));
            table.addCell(new Cell().add(new Paragraph("Row 1, Col 2")));
            table.addCell(new Cell().add(new Paragraph("Row 1, Col 3")));

            table.addCell(new Cell().add(new Paragraph("Row 2, Col 1")));
            table.addCell(new Cell().add(new Paragraph("Row 2, Col 2")));
            table.addCell(new Cell().add(new Paragraph("Row 2, Col 3")));



            document.add(table);
            // Close the document
            document.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {

    }
}