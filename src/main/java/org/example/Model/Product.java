package org.example.Model;

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

    public static void main(String[] args) throws SQLException {


    }
}
