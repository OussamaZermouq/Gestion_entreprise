package org.example.Model;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.HorizontalAlignment;
import com.sun.jdi.connect.spi.Connection;
import org.example.Interfaces.MDIParent;
import org.example.Interfaces.Product_interface;
import org.example.Interfaces.Stock_interface;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Stock {
    public int id_stock;
    public String name_stock;

    //since each stock is in a depot
    public Depot depot;

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

    public Stock(int id_stock, String name_stock, Depot depot) {
        this.id_stock = id_stock;
        this.name_stock = name_stock;
        this.depot = depot;
    }

    //our functions

    public static ArrayList<Stock> get_all_stocks(DB_connection db_connection) throws SQLException {
        ArrayList<Stock> stocks = new ArrayList<>();
        int count = db_connection.execute_query("Select count(*) as number_of_stocks from stock").getInt("number_of_stocks");
        ResultSet resultSet = db_connection.execute_query("Select * from stock");

        //another efficient loop would be to use the while(rs.next()) but meh
        for (int i=0;i<count;i++){
            stocks.add(new Stock(resultSet.getInt("id_stock"),
                                resultSet.getString("name_stock"),
                                Depot.get_depot_by_id(resultSet.getInt("depot_id"), Depot.get_all_depot())
                    ));
            resultSet.next();
        }
        return stocks;
    }


    public static Stock get_stock_by_id(int id, DB_connection db_connection) throws SQLException {
        ArrayList<Stock> stock_list = get_all_stocks(db_connection);
        for (Stock s:stock_list){
            if (s.id_stock == id){
                return s;
            }
        }
        return null;
    }

    public static int get_stock_id_by_name(String stock_name, ArrayList<Stock> stocks){
        for (Stock s : stocks){
            if (s.name_stock.equals(stock_name)){
                return s.id_stock;
            }
        }
        return -1;
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
            Table table = new Table(3);

            // Add header cells
            table.addHeaderCell(new Cell().add(new Paragraph("Id")));
            table.addHeaderCell(new Cell().add(new Paragraph("Nom du Stock")));
            table.addHeaderCell(new Cell().add(new Paragraph("Nom du Depot")));

            data.forEach(
                    d->{
                        table.addCell(new Cell().add(new Paragraph(String.valueOf(d.id_stock))));
                        table.addCell(new Cell().add(new Paragraph(d.name_stock)));
                        table.addCell(new Cell().add(new Paragraph(d.depot.nom_depot)));
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
