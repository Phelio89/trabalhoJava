package br.ufsm.csi.dao;

import br.ufsm.csi.model.Veterinario;

import java.sql.*;
import java.util.ArrayList;

public class VeterinarioDao {

    private String sql;
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement preparedStatement;

    public String cadastrarVet(Veterinario v){

        try(Connection connection = new ConectaDB().getConexao()){
            this.sql = "INSERT INTO veterinario (nome, email, celular, senha, crmv, valor_consulta, consultorio_id) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";
            this.preparedStatement = connection.prepareStatement(sql);
            this.preparedStatement.setString(1, v.getNome());
            this.preparedStatement.setString(2, v.getEmail());
            this.preparedStatement.setString(3, v.getCelular());
            this.preparedStatement.setString(4, v.getSenha());
            this.preparedStatement.setString(5, v.getCrmv());
            this.preparedStatement.setDouble(6, v.getValor_consulta());
            this.preparedStatement.setInt(7, v.getConsultorio_id());

            this.preparedStatement.execute();

            return "Cadastro realizado com sucesso";

        }catch (SQLException e){
            e.printStackTrace();
            return "Não foi possivel cadastrar";
        }
    }

    public String deletaVet(Veterinario v){

        try(Connection connection = new ConectaDB().getConexao()){

            this.sql = "DELETE FROM veterinario WHERE id = ?";
            this.preparedStatement = connection.prepareStatement(sql);
            this.preparedStatement.setInt(1, v.getId());

            this.preparedStatement.execute();

            return "Cadastro deletado";
        }catch (SQLException e){
            e.printStackTrace();
            return "Não foi possivelo deletar cadastro";
        }

    }

    public String atualizaVet(Veterinario v){

        try(Connection connection = new ConectaDB().getConexao()){
            this.sql = "UPDATE veterinario SET nome = ?, email = ?, celular = ?, senha = ?, crmv = ?, valor_consulta = ?, consultorio_id = ? " +
                    "WHERE id = ?";

            this.preparedStatement = connection.prepareStatement(sql);
            this.preparedStatement.setString(1, v.getNome());
            this.preparedStatement.setString(2, v.getEmail());
            this.preparedStatement.setString(3, v.getCelular());
            this.preparedStatement.setString(4, v.getSenha());
            this.preparedStatement.setString(5, v.getCrmv());
            this.preparedStatement.setDouble(6, v.getValor_consulta());
            this.preparedStatement.setInt(7, v.getConsultorio_id());
            this.preparedStatement.setInt(8, v.getId());

            this.preparedStatement.execute();

            return "Cadastro atualizado com sucesso";
        }catch (SQLException e){
            e.printStackTrace();
            return "Não foi possivel atualizar";
        }
    }

    public ArrayList<Veterinario> getVeterinarios(){
        ArrayList<Veterinario> veterinarios = new ArrayList<Veterinario>();

        try(Connection connection = new ConectaDB().getConexao()) {

            this.sql = "SELECT * FROM veterinario";
            this.stmt = connection.createStatement();
            this.rs = stmt.executeQuery(sql);

            while(this.rs.next()){
                Veterinario v = new Veterinario();
                v.setNome(this.rs.getString("nome"));
                v.setCelular(this.rs.getString("celular"));
                v.setCrmv(this.rs.getString("crmv"));
                v.setEmail(this.rs.getString("email"));
                v.setConsultorio_id(this.rs.getInt("consultorio_id"));
                v.setId(this.rs.getInt("id"));
                v.setSenha(this.rs.getString("senha"));
                v.setValor_consulta(this.rs.getDouble("valor_consulta"));

                veterinarios.add(v);
            }

            return veterinarios;

        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public Veterinario getVeterinarioByCrmv(String crmv){

        try(Connection connection = new ConectaDB().getConexao()){
            Veterinario v = new Veterinario();

            this.sql = "SELECT * FROM veterinario WHERE crmv = ?";
            this.preparedStatement = connection.prepareStatement(sql);
            this.preparedStatement.setString(1, crmv);

            this.rs = this.preparedStatement.executeQuery();

            this.rs.next();
            v.setNome(this.rs.getString("nome"));
            v.setCelular(this.rs.getString("celular"));
            v.setCrmv(this.rs.getString("crmv"));
            v.setEmail(this.rs.getString("email"));
            v.setConsultorio_id(this.rs.getInt("consultorio_id"));
            v.setId(this.rs.getInt("id"));
            v.setSenha(this.rs.getString("senha"));
            v.setValor_consulta(this.rs.getDouble("valor_consulta"));

            return v;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public Veterinario getVeterinarioById(int id){
        Veterinario v = new Veterinario();

        try(Connection connection = new ConectaDB().getConexao()){

            this.sql = "SELECT * FROM veterinario WHERE id = ?";
            this.preparedStatement = connection.prepareStatement(sql);
            this.preparedStatement.setInt(1, id);

            this.rs = this.preparedStatement.executeQuery();

            while (this.rs.next()){
                v.setNome(this.rs.getString("nome"));
                v.setCelular(this.rs.getString("celular"));
                v.setCrmv(this.rs.getString("crmv"));
                v.setEmail(this.rs.getString("email"));
                v.setConsultorio_id(this.rs.getInt("consultorio_id"));
                v.setId(this.rs.getInt("id"));
                v.setSenha(this.rs.getString("senha"));
                v.setValor_consulta(this.rs.getDouble("valor_consulta"));
            }


            return v;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }


    }



}
