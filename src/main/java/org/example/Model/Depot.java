package org.example.Model;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.HorizontalAlignment;
import org.example.Interfaces.MDIParent;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Depot {
    public int id;
    public String nom_depot;
    public String adresse_depot;

    public static DB_connection db_connection = MDIParent.db_connection;

    public String getNom_depot() {
        return nom_depot;
    }

    public void setNom_depot(String nom_depot) {
        this.nom_depot = nom_depot;
    }

    public String getAdresse_depot() {
        return adresse_depot;
    }

    public void setAdresse_depot(String adresse_depot) {
        this.adresse_depot = adresse_depot;
    }

    public Depot(int id, String nom_depot, String adresse_depot, String tel_depot) {
        this.id = id;
        this.nom_depot = nom_depot;
        this.adresse_depot = adresse_depot;
        this.tel_depot = tel_depot;
    }

    public String tel_depot;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTel_depot() {
        return tel_depot;
    }

    public void setTel_depot(String tel_depot) {
        this.tel_depot = tel_depot;
    }

    public static Depot get_depot_by_id(int id, ArrayList<Depot> depots) throws SQLException {
        for (Depot d:depots){
            if (d.id == id){
                return d;
            }
        }
        return null;
    }

    public static Depot get_depot_by_name(String name, ArrayList<Depot> depots){
        for(Depot d: depots){
            if (d.nom_depot.equals(name)){
                return d;
            }
        }
        return null;
    }

    public static ArrayList<Depot> get_all_depot() throws SQLException {
        ArrayList<Depot> depots = new ArrayList<>();
        int count = db_connection.execute_query("select count(*) as number_depot from depot").getInt("number_depot");
        ResultSet resultSet = db_connection.execute_query("select * from depot");
        for (int i=0; i<count;i++){
            depots.add(new Depot(resultSet.getInt("id_depot"),
                                resultSet.getString("nom_depot"),
                                resultSet.getString("adresse_depot"),
                                resultSet.getString("tel_depot")

            ));
            resultSet.next();
        }
        return depots;
    }

    public static  void export_pdf(File file, String author, String title, ArrayList<Depot> data){
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
            table.addHeaderCell(new Cell().add(new Paragraph("Nom")));
            table.addHeaderCell(new Cell().add(new Paragraph("Adresse")));
            table.addHeaderCell(new Cell().add(new Paragraph("Telephone")));

            data.forEach(
                    d->{
                        table.addCell(new Cell().add(new Paragraph(String.valueOf(d.id))));
                        table.addCell(new Cell().add(new Paragraph(d.nom_depot)));
                        table.addCell(new Cell().add(new Paragraph(d.adresse_depot)));
                        table.addCell(new Cell().add(new Paragraph(d.tel_depot)));

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