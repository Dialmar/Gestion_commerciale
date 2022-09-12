/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author mariamadiallo
 */
public class Bdd {
Connection connection;
    Statement statement;
    public Connection connexionDatabase()
            
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection ("jdbc:mysql://localhost:8889/GestionDOusseynou","root","root");
        }
        catch (Exception e)
          { System.err.println(e.getMessage());}
        return connection ;
    }
    public String executionUpdate(String sql)
     {
         connexionDatabase();
         String result="";
         try
         {
             statement = connection.createStatement();
             statement.executeUpdate(sql);
             result=sql;
             
             
         }catch(SQLException ex)
         {
             result=ex.toString();
         }
         return result ;
     }
    
    
      public String queryInsertFactureFinal (int Num_Facture)         
    {
        connexionDatabase();
        
       
        
        String  SQL="INSERT INTO facture_final (Num_Facture) VALUES  (" +Num_Facture+ " ) ";
     return this.executionUpdate(SQL);
        
    }
            
            
                      
    public String queryInsertProduit (Produit p)         
    {
        connexionDatabase();
        int i;
       
        
        String  SQL="INSERT INTO stock (libelle, prix_unitaire, prix_en_gros, Stock_dispo) VALUES  ('"+p.getLibelle()+"','"+p.getPrix_unitaire()+"','"+p.getPrix_en_gros()+"', '"+p.getStock_dispo()+"' ) ";
     return this.executionUpdate(SQL);
        
    }
    
     public ResultSet queryStockCombobox ()
    {  connexionDatabase();
    String SQL = "Select * FROM stock";
      return this.executionQuery(SQL);
    
    }
    
   public String queryInsertStockCombobox ()
    {  connexionDatabase();
    String SQL = "Select * FROM stock";
      return this.executionUpdate(SQL);
    
    }
    
    /*public String queryInsertFacture (Facture f)         
    {
        connexionDatabase();
        int i;
       
        
        String  SQL="INSERT INTO Facturation () VALUES  ('"+p.getNom()+"','"+p.getPrixa()+"','"+p.getPrixv()+"','"+p.getQt()+"' ) ";
     return this.executionUpdate(SQL);
        
    }*/
    
    //public String queryInsert (String nomTable, String [] contenu){
    
     public int Nbr_Element_Table(String table) throws SQLException 
      {
           connexionDatabase();
          String SQL= "SELECT COUNT(*) AS total FROM "+table ;
          ResultSet rs;
          rs = this.executionQuery(SQL);
          String solde="0";
          while(rs.next()){
              solde = rs.getString("total");
          }
          
          
          return Integer.parseInt(solde);       
      }

  public String[] Produit(String Table) throws SQLException
      {
           connexionDatabase();
          String Produit[] = new String[Nbr_Element_Table(Table)];
          String SQL= "SELECT * FROM "+Table;
          ResultSet rs =this.executionQuery(SQL);
          int i=0;
          while(rs.next())
          {
              if(i<9){
                  Produit[i]="*0"+rs.getString("id")+" "+rs.getString("libelle"); 
                  
              }
              else if ((i>9)& (i<19))
                   Produit[i]="*"+rs.getString("id")+" "+rs.getString("libelle"); 
              else
                  Produit[i]="*"+rs.getString("id")+" "+rs.getString("libelle"); 
              
              i++;
          }
          return Produit;
       }
    
    
public ResultSet executionQuery(String sql)
     {
         connexionDatabase();
         ResultSet resultset =null ;
         try 
         {
             statement = connection.createStatement();
             resultset= statement.executeQuery(sql);
             
         }catch (SQLException ex) {System.err.println(ex);}
         return resultset ;
         
         
     }
//public void AjoutFacturation(String libelle, int qttProduit, int price, int total){
//    
//    connexionDatabase();
//    
//    
//}
         
    public ResultSet querySelectUser (String login, String password){
      
        connexionDatabase();
    
       String SQL = "SELECT * FROM utilisateur WHERE login = '"+login+"' AND password = '"+password+"'";
        return this.executionQuery(SQL);   
    }
    
    public ResultSet queryStockById (int id){
      
        connexionDatabase();
    
       String SQL = "SELECT * FROM stock WHERE id = " + id;
        return this.executionQuery(SQL);   
    }

     /*public String AjoutFacturation(int id , int qtt , String Num_facture) throws SQLException 
     {
         connexionDatabase();
         
         String name, prixU, stock, en_Cour;
         int total;
            //Designation nom   
                  String  SQL= "SELECT libelle FROM stock WHERE ID= " +id ;
        
                   ResultSet rs = this.executionQuery(SQL);
                   ArrayList info = new ArrayList();
                   info = resultSetToArrayList(rs);
                   name=info.get(0).toString().substring(9,info.get(0).toString().length()-1);
            //Designation prixU 
                 String  SQL2= "SELECT prixU FROM stock WHERE ID= " +id ;        
                   rs = this.executionQuery(SQL2);
                   ArrayList info2 = new ArrayList();
                   info2 = resultSetToArrayList(rs);
                   prixU=info2.get(0).toString().substring(15,info2.get(0).toString().length()-1);
           Designation Stock dispo 
                  String SQL3= "SELECT Qte FROM Produits  WHERE ID= " +id ;        
                   rs = this.executionQuery(SQL3);
                   ArrayList info3 = new ArrayList();
                   info3 = resultSetToArrayList(rs);
                   stock=info3.get(0).toString().substring(13,info3.get(0).toString().length()-1);     
            DEsignation montant total
            total = Integer.parseInt(prixU) * qtt;
            
               
            //Control Stock
           int stockk = Integer.parseInt(stock);
            if(stockk < qtt-1)
            {
                JOptionPane.showMessageDialog(null,"Attention Stock insuffisant");
            }
        
        
         
         String SQL5 = "INSERT INTO facture_en_cours (id, libelle, qtt, prix_unitaire, Montant_total, Statut, Num_facture) VALUES ("+id+",'"+name+"',"+qtt+",'"+prixU+"','"+total+"','"+'En_Cour','"+NumFacture+"')";
         this.executionUpdate(SQL5);
         name= ""+total;
         return name;
         
         
     }*/
    
    public void AjoutFacturation(int id , String libelle, int qttProduct, int numFacture) throws SQLException 
     {
         connexionDatabase();
         
         String name,prixU,stock;
         int totalFacture = 0;
//            //Designation nom   
                  String SQL= "SELECT libelle FROM stock WHERE ID= " + id ;
//        
                   ResultSet rs = this.executionQuery(SQL);
//                   ArrayList info = new ArrayList();
//                   info = resultSetToArrayList(rs);
//                   name=info.get(0).toString().substring(9,info.get(0).toString().length()-1);
            //Designation prixU 
                 String  SQL2= "SELECT prix_unitaire FROM stock WHERE ID= " + id ;        
                   rs = this.executionQuery(SQL2);
                   ArrayList info2 = new ArrayList();
                   info2 = resultSetToArrayList(rs);
                   prixU=info2.get(0).toString().substring(15,info2.get(0).toString().length()-1);
            //Designation Stock dispo 
                  /*String SQL3= "SELECT Stock_dispo FROM stock WHERE ID= " +id ;        
                   rs = this.executionQuery(SQL3);
                   ArrayList info3 = new ArrayList();
                   info3 = resultSetToArrayList(rs);
                   stock=info3.get(0).toString().substring(13,info3.get(0).toString().length()-1);       
            //DEsignation montant total*/
            totalFacture = Integer.parseInt(prixU) * qttProduct;
            
               
            //Control Stock
            /*int stockk = Integer.parseInt(stock);
            if(stockk < qtt-1)
            {
                JOptionPane.showMessageDialog(null,"Attention Stock insuffisant");
            }*/
        
        
         
         String SQL5="INSERT INTO Facture_En_cour (id , Libelle , qtt , prix_unitaire , Montant_Total , Statut, Num_Facture) VALUES (" + id + ",'" + libelle + "'," + qttProduct + "," + prixU + "," + totalFacture + ",'En Cours'," + numFacture + ")";
         this.executionUpdate(SQL5);
//         name= ""+total;
         /*return name; */
         
         
     }
      public ArrayList resultSetToArrayList(ResultSet rs) throws SQLException{ //recuperer un resultat et les mettre sous une certaine forme
           ResultSetMetaData md = rs.getMetaData();
           int columns = md.getColumnCount();
           ArrayList results = new ArrayList();

           while (rs.next()) {
                  HashMap row = new HashMap();
                  results.add(row);

                  for(int i=1; i<=columns; i++){
                        row.put(md.getColumnName(i),rs.getObject(i));
                    }
                }
    return results;
}
      public ResultSet querySelect_Facture(String[] nomColonne , String nomTable, int numFacture )
     {
          connexionDatabase();
          int i;
        String  SQL="SELECT ";
          for(i=0;i<= nomColonne.length-1;i++)
          {
              SQL += nomColonne[i];
              if(i<nomColonne.length-1)
              {
                  SQL+= ",";
              }
          }
         SQL+=" FROM " + nomTable;
         SQL+=" WHERE Num_Facture= " + numFacture + " AND Statut= 'En Cours'";
         return this.executionQuery(SQL);
         
     }
      
     public ResultSet querySelect_Facture_Caisse(String[] nomColonne , String nomTable, String NumFacture )
     {
          connexionDatabase();
          int i;
        String  SQL="SELECT ";
          for(i=0;i<= nomColonne.length-1;i++)
          {
              SQL += nomColonne[i];
              if(i<nomColonne.length-1)
              {
                  SQL+= ",";
              }
          }
         SQL+=" FROM " + nomTable;
         SQL+=" WHERE Num_Facture= '"+NumFacture+"' AND Statut= 'Caisse'";
         return this.executionQuery(SQL);
         
     }
   
}
