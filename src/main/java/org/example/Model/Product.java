package org.example.Model;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.HorizontalAlignment;
import org.example.Interfaces.Product_interface;

import java.io.File;
import java.io.IOException;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Product {
    public String id;
    public String libelle;
    public double prix;

    public String description;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public Product(String id, String libelle, double prix, String description) {
        this.id = id;
        this.libelle = libelle;
        this.prix = prix;
        this.description = description;
    }

    public boolean ajouter_produit(Product product_to_add,DB_connection connection){
        String query= "Insert into products values('"+product_to_add.id+"','"+product_to_add.libelle+"','"+product_to_add.prix+"','"+product_to_add.description+"',)";
        try{
            connection.execute_query(query);
        }
        catch (Exception e){
            System.err.println(e.getMessage());
            return false;

        }
        return true;
    }

    public static ArrayList<Product> get_all_products(DB_connection connection) throws SQLException {
        ArrayList<Product> products = new ArrayList<Product>();
        int count = connection.execute_query("Select count(*) as number_of_products from Products").getInt("number_of_products");
        ResultSet resultSet = connection.execute_query("Select * from Products");
        for (int i=0;i<count;i++){
            products.add(new Product(resultSet.getString("id"),
                                    resultSet.getString("libelle"),
                                    resultSet.getDouble("price"),
                                    resultSet.getString("description")));
            resultSet.next();
        }
        return products;

    }
    public static  void export_pdf(File file, String author, String title, ArrayList<Product> data){
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
            table.addHeaderCell(new Cell().add(new Paragraph("id")));
            table.addHeaderCell(new Cell().add(new Paragraph("Libelle")));
            table.addHeaderCell(new Cell().add(new Paragraph("Prix")));
            table.addHeaderCell(new Cell().add(new Paragraph("Description")));



            data.forEach(
                    d->{
                        table.addCell(new Cell().add(new Paragraph(d.id)));
                        table.addCell(new Cell().add(new Paragraph(d.libelle)));
                        table.addCell(new Cell().add(new Paragraph(String.valueOf(d.prix)+"DH")));
                        table.addCell(new Cell().add(new Paragraph(d.description)));

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
    public static void main(String[] args) throws SQLException {

    }
}
