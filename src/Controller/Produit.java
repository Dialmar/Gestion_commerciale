/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author mariamadiallo
 */
public class Produit {
     String id,libelle, prix_unitaire, prix_en_gros, Stock_dispo;

    public Produit(String id, String libelle, String quantitep, String prix_unitaire, String prix_en_gros, String Stock_dispo) {
        this.id = id;
        this.libelle = libelle;
        this.prix_unitaire = prix_unitaire;
        this.prix_en_gros = prix_en_gros;
        this.Stock_dispo = Stock_dispo;
    }

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


    public String getPrix_unitaire() {
        return prix_unitaire;
    }

    public void setPrix_unitaire(String prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }

    public String getPrix_en_gros() {
        return prix_en_gros;
    }

    public void setPrix_en_gros(String prix_en_gros) {
        this.prix_en_gros = prix_en_gros;
    }

    public String getStock_dispo() {
        return Stock_dispo;
    }

    public void setStock_dispo(String Stock_dispo) {
        this.Stock_dispo = Stock_dispo;
    }

    public Produit(String libelle, String prix_unitaire, String prix_en_gros, String Stock_dispo) {
        this.libelle = libelle;
        this.prix_unitaire = prix_unitaire;
        this.prix_en_gros = prix_en_gros;
        this.Stock_dispo = Stock_dispo;
    }

   
     
     
     
     
     
     
     
     
     
}

    //String id,nom,prixa,prixv,qt;
   

   /* public Produit(String nom, String prixa, String prixv, String qt) {
        this.nom = nom;
        this.prixa = prixa;
        this.prixv = prixv;
        this.qt = qt;
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

    public String getPrixa() {
        return prixa;
    }

    public void setPrixa(String prixa) {
        this.prixa = prixa;
    }

    public String getPrixv() {
        return prixv;
    }

    public void setPrixv(String prixv) {
        this.prixv = prixv;
    }

    public String getQt() {
        return qt;
    }

    public void setQt(String qt) {
        this.qt = qt;
    }
    
    
}*/
