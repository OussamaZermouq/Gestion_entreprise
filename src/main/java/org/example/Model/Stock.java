package org.example.Model;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.HorizontalAlignment;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Stock {
    public int id_stock;
    public String name_stock;

    public int getId_stock() {
        return id_stock;
    }

    public void setId_stock(int id_stock) {
        this.id_stock = id_stock;
    }

    public String getName_stock() {
        return name_stock;
    }

    public void setName_stock(String name_stock) {
        this.name_stock = name_stock;
    }

    public Stock(int id_stock, String name_stock) {
        this.id_stock = id_stock;
        this.name_stock = name_stock;
    }

    //our functions

    public static ArrayList<Stock> get_all_stocks(DB_connection db_connection) throws SQLException {
        ArrayList<Stock> stocks = new ArrayList<>();
        int count = db_connection.execute_query("Select count(*) as number_of_stocks from stock").getInt("number_of_stocks");
        ResultSet resultSet = db_connection.execute_query("Select * from stock");

        //another efficient loop would be to use the while(rs.next()) but meh
        for (int i=0;i<count;i++){
            stocks.add(new Stock(resultSet.getInt("id_stock"),
                                resultSet.getString("name_stock")));
            resultSet.next();
        }
        return stocks;

    }
    public static  void export_pdf(File file, String author, String title, ArrayList<Stock> data){
        // Output PDF file

        try {

            PdfWriter writer = new PdfWriter(file);
            PdfDocument pdfDocument = new PdfDocument(writer);
            Document document = new Document(pdfDocument);

            // Set metadata
            pdfDocument.getDocumentInfo().setAuthor(author);
            pdfDocument.getDocumentInfo().setTitle(title);

            document.add(new Paragraph(title));
            System.out.println("PDF with metadata generated successfully.");

            // Create a table with three columns
            Table table = new Table(4);

            // Add header cells
            table.addHeaderCell(new Cell().add(new Paragraph("Id")));
            table.addHeaderCell(new Cell().add(new Paragraph("Nom du Stock")));

            data.forEach(
                    d->{
                        table.addCell(new Cell().add(new Paragraph(String.valueOf(d.id_stock))));
                        table.addCell(new Cell().add(new Paragraph(d.name_stock)));
                    }
            );

            table.setHorizontalAlignment(HorizontalAlignment.CENTER);

            document.add(table);
            // Close the document
            document.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
