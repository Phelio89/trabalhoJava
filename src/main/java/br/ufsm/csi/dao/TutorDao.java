package br.ufsm.csi.dao;

import br.ufsm.csi.model.Tutor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TutorDao {

    private String sql;
    private Statement stmt;
    private ResultSet rs;

    public ArrayList<Tutor> getTutores(){
        ArrayList<Tutor> tutores = new ArrayList<Tutor>();

        try(Connection connection = new ConectaDB().getConexao()){

            this.sql = "SELECT * FROM tutor";
            this.stmt = connection.createStatement();
            this.rs = stmt.executeQuery(sql);

            while(this.rs.next()){
                Tutor tutor = new Tutor();
                tutor.setId(this.rs.getInt("id"));
                tutor.setNome(this.rs.getString("nome"));
                tutor.setCelular(this.rs.getString("celular"));
                tutor.setCpf(this.rs.getString("cpf"));
                tutor.setBairro(this.rs.getString("bairro"));
                tutor.setCep(this.rs.getString("cep"));
                tutor.setCidade(this.rs.getString("cidade"));
                tutor.setEstado(this.rs.getString("estado"));
                tutor.setNumero(this.rs.getString("numero"));
                tutor.setLogradouro(this.rs.getString("logradouro"));

                tutores.add(tutor);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return tutores;
    }

    public void create(Tutor t){

        try(Connection connection = new ConectaDB().getConexao()){

            System.out.println("Nome: ");
            this.sql = "INSERT INTO tutor ('nome', 'celular', 'email', 'cpf', 'cep', 'bairro', 'cidade', 'estado', 'logradouro', 'numero') VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            this.stmt = connection.createStatement();
            this.rs = stmt.executeQuery(sql);

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
