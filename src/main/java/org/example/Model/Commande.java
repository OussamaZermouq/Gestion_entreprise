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
import java.util.Date;

import static org.example.Model.Stock.get_stock_by_id;

public class Commande {
    public int commande_id;
    public String commande_nom;
    public int quantite;
    public String date_commande;
    public static Client client;

    public Commande(int commande_id, String commande_nom, int quantite, String date_commande, Client client) {
        this.commande_id = commande_id;
        this.commande_nom = commande_nom;
        this.quantite = quantite;
        this.date_commande = date_commande;
        this.client = client;
    }

    public int getCommande_id() {
        return commande_id;
    }

    public void setCommande_id(int commande_id) {
        this.commande_id = commande_id;
    }

    public String getCommande_nom() {
        return commande_nom;
    }

    public void setCommande_nom(String commande_nom) {
        this.commande_nom = commande_nom;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getDate_commande() {
        return date_commande;
    }

    public void setDate_commande(String date_commande) {
        this.date_commande = date_commande;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public static ArrayList<Commande> get_all_commandes(DB_connection connection) throws SQLException {
        ArrayList<Commande> commandes = new ArrayList<Commande>();
        int count = connection.execute_query("Select count(*) as number_of_commandes from commande").getInt("number_of_commandes");
        ResultSet resultSet = connection.execute_query("Select * from commande");
        for (int i=0;i<count;i++){
            commandes.add(new Commande(
                    resultSet.getInt("commande_id"),
                    resultSet.getString("commande_nom"),
                    resultSet.getInt("quantite"),
                    resultSet.getString("date_commande"),
                    Client.get_client_by_id(String.valueOf(resultSet.getInt("client_id")), Client.get_all_client(MDIParent.db_connection))
            ));
            resultSet.next();
        }
        return commandes;
    }


    public static  void export_pdf(File file, String author, String title, ArrayList<Commande> data){
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
            Table table = new Table(5);

            // Add header cells
            table.addHeaderCell(new Cell().add(new Paragraph("ID commande")));
            table.addHeaderCell(new Cell().add(new Paragraph("Nom commande")));
            table.addHeaderCell(new Cell().add(new Paragraph("Quantite")));
            table.addHeaderCell(new Cell().add(new Paragraph("Date Commande")));
            table.addHeaderCell(new Cell().add(new Paragraph("Client nom")));

            data.forEach(
                    d->{
                        table.addCell(new Cell().add(new Paragraph(String.valueOf(d.commande_id))));
                        table.addCell(new Cell().add(new Paragraph(d.commande_nom)));
                        table.addCell(new Cell().add(new Paragraph(String.valueOf(d.quantite))));
                        table.addCell(new Cell().add(new Paragraph(d.date_commande)));
                        table.addCell(new Cell().add(new Paragraph(client.nom)));

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
    public static void main(String[] args) {

    }
}
