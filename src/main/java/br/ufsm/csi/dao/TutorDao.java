package br.ufsm.csi.dao;

import br.ufsm.csi.model.Tutor;

import java.sql.*;
import java.util.ArrayList;

public class TutorDao {

    private String sql;
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement preparedStatement;

    public ArrayList<Tutor> getTutores(){
        ArrayList<Tutor> tutores = new ArrayList<Tutor>();

        try(Connection connection = new ConectaDB().getConexao()){

            this.sql = "SELECT * FROM tutor";
            this.stmt = connection.createStatement();
            this.rs = stmt.executeQuery(sql);

            while(this.rs.next()){
                Tutor tutor = new Tutor(null);
                tutor.setId(this.rs.getInt("id"));
                tutor.setNome(this.rs.getString("nome"));
                tutor.setCelular(this.rs.getString("celular"));
                tutor.setEmail(this.rs.getString("email"));
                tutor.setCpf(this.rs.getString("cpf"));
                tutor.setBairro(this.rs.getString("bairro"));
                tutor.setCep(this.rs.getString("cep"));
                tutor.setCidade(this.rs.getString("cidade"));
                tutor.setEstado(this.rs.getString("estado"));
                tutor.setNumero(this.rs.getString("numero"));
                tutor.setLogradouro(this.rs.getString("logradouro"));
                tutor.setConsultorio_id(this.rs.getInt("consultorio_id"));

                tutores.add(tutor);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return tutores;
    }

    public Tutor getTutorByCpf(String cpf){


        Tutor t = new Tutor(null);

        try(Connection connection = new ConectaDB().getConexao()){

            this.sql = "SELECT * FROM tutor WHERE cpf = ?";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setString(1, cpf);

            this.rs = this.preparedStatement.executeQuery();

            this.rs.next();

            t.setId(this.rs.getInt("id"));
            t.setEmail(this.rs.getString("email"));
            t.setNome(this.rs.getString("nome"));
            t.setCelular(this.rs.getString("celular"));
            t.setCpf(this.rs.getString("cpf"));
            t.setBairro(this.rs.getString("bairro"));
            t.setCep(this.rs.getString("cep"));
            t.setCidade(this.rs.getString("cidade"));
            t.setEstado(this.rs.getString("estado"));
            t.setNumero(this.rs.getString("numero"));
            t.setLogradouro(this.rs.getString("logradouro"));
            t.setConsultorio_id(this.rs.getInt("consultorio_id"));

            return t;

        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }

    }

    public Tutor getTutorById(int id){


        Tutor t = new Tutor(null);

        try(Connection connection = new ConectaDB().getConexao()){

            this.sql = "SELECT * FROM tutor WHERE id = ?";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, id);

            this.rs = this.preparedStatement.executeQuery();

            this.rs.next();

            t.setId(this.rs.getInt("id"));
            t.setEmail(this.rs.getString("email"));
            t.setNome(this.rs.getString("nome"));
            t.setCelular(this.rs.getString("celular"));
            t.setCpf(this.rs.getString("cpf"));
            t.setBairro(this.rs.getString("bairro"));
            t.setCep(this.rs.getString("cep"));
            t.setCidade(this.rs.getString("cidade"));
            t.setEstado(this.rs.getString("estado"));
            t.setNumero(this.rs.getString("numero"));
            t.setLogradouro(this.rs.getString("logradouro"));
            t.setConsultorio_id(this.rs.getInt("consultorio_id"));

            return t;

        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }

    }

    public String cadastraTutor(Tutor t){

        try(Connection connection = new ConectaDB().getConexao()){

            this.sql = "INSERT INTO tutor " +
                    "(nome, celular, email, cpf, cep, bairro, cidade, estado, logradouro, numero, consultorio_id) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setString(1, t.getNome());
            this.preparedStatement.setString(2, t.getCelular());
            this.preparedStatement.setString(3, t.getEmail());
            this.preparedStatement.setString(4, t.getCpf());
            this.preparedStatement.setString(5, t.getCep());
            this.preparedStatement.setString(6, t.getBairro());
            this.preparedStatement.setString(7, t.getCidade());
            this.preparedStatement.setString(8, t.getEstado());
            this.preparedStatement.setString(9, t.getLogradouro());
            this.preparedStatement.setString(10, t.getNumero());
            this.preparedStatement.setInt(11, t.getConsultorio_id());

            this.preparedStatement.execute();

            return "Cadastro realizado";

        }catch (SQLException e){
            e.printStackTrace();
            return "não foi possivel realizar cadastro";
        }
    }

    public String deletarTutor(int id){

        try(Connection connection = new ConectaDB().getConexao()) {
            this.sql = "DELETE FROM tutor WHERE id = ?";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, id);
            this.preparedStatement.execute();

            return "Tutor deletado";
        }catch (SQLException e){
            e.printStackTrace();
            return "Não foi possivel deletar Tutor";
        }
    }

    public String atualizarTutor(Tutor t){

        try(Connection connection = new ConectaDB().getConexao()){
            this.sql = "UPDATE tutor SET nome = ?, celular = ?, email = ?, cpf = ?, cep = ?, bairro = ?, cidade = ?, estado = ?, logradouro = ?, numero = ? " +
                    "WHERE id = ?";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setString(1, t.getNome());
            this.preparedStatement.setString(2, t.getCelular());
            this.preparedStatement.setString(3, t.getEmail());
            this.preparedStatement.setString(4, t.getCpf());
            this.preparedStatement.setString(5, t.getCep());
            this.preparedStatement.setString(6, t.getBairro());
            this.preparedStatement.setString(7, t.getCidade());
            this.preparedStatement.setString(8, t.getEstado());
            this.preparedStatement.setString(9, t.getLogradouro());
            this.preparedStatement.setString(10, t.getNumero());
            this.preparedStatement.setInt(11, t.getId());

            this.preparedStatement.execute();

            return "Tutor atualizado";
        }catch (SQLException e){
            e.printStackTrace();
            return "Não foi possivel atualziar";
        }
    }
}
