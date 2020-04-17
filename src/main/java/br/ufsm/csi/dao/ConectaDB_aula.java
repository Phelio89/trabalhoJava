package br.ufsm.csi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConectaDB_aula {

    public static void main(String args[]){

        try{
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/vetplace", "postgres", "meridalink");

            System.out.println("Conexão realizada");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM veterinario");

            while(rs.next()){
                System.out.println("id: "+rs.getInt("id"));
                System.out.println("nome: "+rs.getString("nome"));
            }

            stmt.close();
            conn.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
