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


public class Client {
    public String id;
    public String nom;
    public String prenom;

    public String adresse;
    public String tele;
    public String pays;
    public String ville;
    public String codee;

    public Client(String id, String nom, String prenom, String adresse, String tele, String pays, String ville, String codee) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.tele = tele;
        this.pays = pays;
        this.ville = ville;
        this.codee = codee;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodee() {
        return codee;
    }

    public void setCodee(String codee) {
        this.codee = codee;
    }
    public boolean ajouter_client(Client client_to_add,DB_connection connection){
        String query= "Insert into client values('"+client_to_add.id+"','"+client_to_add.nom+"','"+client_to_add.prenom+"','"+client_to_add.adresse+"','"+client_to_add.tele+"','"+client_to_add.pays+"','"+client_to_add.ville+"','"+client_to_add.codee+"',)";
        try{
            connection.execute_query(query);
        }
        catch (Exception e){
            System.err.println(e.getMessage());
            return false;

        }
        return true;
    }
    public static ArrayList<Client> get_all_client(DB_connection connection) throws SQLException {
        ArrayList<Client> client = new ArrayList<Client>();
        int count = connection.execute_query("Select count(*) as number_of_client from client").getInt("number_of_client");
        ResultSet resultSet = connection.execute_query("Select * from Client");
        for (int i=0;i<count;i++){
            client.add(new Client(resultSet.getString("id"),
                    resultSet.getString("nom"),
                    resultSet.getString("prenom"),
                    resultSet.getString("adresse"),
                    resultSet.getString("tele"),
                    resultSet.getString("paye"),
                    resultSet.getString("ville"),
                    resultSet.getString("code")));
            resultSet.next();
        }
        return client;


    }
    public static  void export_pdf(File file, String author, String title, ArrayList<Client> data){
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
            table.addHeaderCell(new Cell().add(new Paragraph("nom")));
            table.addHeaderCell(new Cell().add(new Paragraph("prenom")));
            table.addHeaderCell(new Cell().add(new Paragraph("adresse")));
            table.addHeaderCell(new Cell().add(new Paragraph("tele")));
            table.addHeaderCell(new Cell().add(new Paragraph("paye")));
            table.addHeaderCell(new Cell().add(new Paragraph("ville")));
            table.addHeaderCell(new Cell().add(new Paragraph("codee")));






            data.forEach(
                    d->{
                        table.addCell(new Cell().add(new Paragraph(d.id)));
                        table.addCell(new Cell().add(new Paragraph(d.nom)));
                        table.addCell(new Cell().add(new Paragraph(d.prenom)));
                        table.addCell(new Cell().add(new Paragraph(d.adresse)));
                        table.addCell(new Cell().add(new Paragraph(d.tele)));
                        table.addCell(new Cell().add(new Paragraph(d.pays)));
                        table.addCell(new Cell().add(new Paragraph(d.ville)));
                        table.addCell(new Cell().add(new Paragraph(d.codee)));



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
