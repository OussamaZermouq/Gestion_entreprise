package org.example.Model;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.HorizontalAlignment;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.example.Model.DB_connection.*;

import static org.example.Model.Fournisseur.*;
import static org.example.Model.Stock.get_stock_by_id;

public class Livraison {
    public String id;
    public String code_livraison;
    public Fournisseur fourniseur;
    public Product produit;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getcode_livraison() {
        return code_livraison;
    }

    public void setcode_livraison(String code_livraison) {
        code_livraison = code_livraison;
    }

    public Livraison(String id, String code_livraison, Fournisseur fourniseur,Product produit) {
        this.id = id;
        this.code_livraison = code_livraison;
        this.fourniseur = fourniseur;
        this.produit = produit;
    }

//    public static void populateCombo1(JComboBox<String> j1) throws SQLException {
//        try (Connection con = DB_connection.connect_to_db()) {
//            String query = "SELECT libelle FROM products";
//            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
//                ResultSet resultSet = preparedStatement.executeQuery();
//
//                // Clear existing items in the combo box
//                j1.removeAllItems();
//
//                // Add items from the result set to the combo box
//                while (resultSet.next()) {
//                    String nom = resultSet.getString("libelle");
//                    j1.addItem(nom);
//                }
//            }
//        }
//    }

public static ArrayList<Livraison> get_all_livraison(DB_connection connection) throws SQLException {
    ArrayList<Livraison> livraisons = new ArrayList<Livraison>();
    int count = connection.execute_query("Select count(*) as number_of_livraison from livraison").getInt("number_of_livraison");
    ResultSet resultSet = connection.execute_query("Select * from livraison");

    for (int i = 0; i < count; i++) {
        livraisons.add(new Livraison(
                resultSet.getString("id"),
                resultSet.getString("code_livraison"),
                Fournisseur.get_fournisseur_by_id(resultSet.getString("four_id")),
                //this should have been int in the class but meh
                Product.get_produit_by_id(String.valueOf(resultSet.getInt("prod_id")))
                )
        );
        resultSet.next();
    }
    return livraisons;
}

    public static void populateCombo2(JComboBox<String> j1) throws SQLException {
        try (Connection con = DB_connection.connect_to_db()) {
            String query = "SELECT nom FROM fournisseur";
            try (PreparedStatement preparedStatement = con.prepareStatement(query)) {
                ResultSet resultSet = preparedStatement.executeQuery();

                // Clear existing items in the combo box
                j1.removeAllItems();

                // Add items from the result set to the combo box
                while (resultSet.next()) {
                    String nom = resultSet.getString("nom");
                    j1.addItem(nom);
                }
            }
        }
    }

    public static  void export_pdf(File file, String author, String title, ArrayList<Livraison> data){
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
            Table table = new Table(3);

            // Add header cells
            table.addHeaderCell(new Cell().add(new Paragraph("Id")));
            table.addHeaderCell(new Cell().add(new Paragraph("Nom du Stock")));
            table.addHeaderCell(new Cell().add(new Paragraph("Nom du Depot")));

            data.forEach(
                    d->{
                        table.addCell(new Cell().add(new Paragraph(String.valueOf(d.id))));
                        table.addCell(new Cell().add(new Paragraph(d.code_livraison)));
                        table.addCell(new Cell().add(new Paragraph(d.fourniseur.codee)));
                        table.addCell(new Cell().add(new Paragraph(d.produit.libelle)));
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
