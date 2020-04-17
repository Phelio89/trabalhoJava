package br.ufsm.csi.dao;

import br.ufsm.csi.model.Consultorio;

import java.sql.*;
import java.util.ArrayList;

public class ConsultorioDao {

    private String sql;
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement preparedStatement;

    public String cadastrar(Consultorio c){

        try (Connection connection = new ConectaDB().getConexao()){
            this.sql = "INSERT INTO consultorio (cnpj, cep, bairro, cidade, estado, logradouro, numero, telefone, email, razao_social) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            this.preparedStatement = connection.prepareStatement(sql);
            this.preparedStatement.setString(1, c.getCnpj());
            this.preparedStatement.setString(2, c.getCep());
            this.preparedStatement.setString(3, c.getBairro());
            this.preparedStatement.setString(4, c.getCidade());
            this.preparedStatement.setString(5, c.getEstado());
            this.preparedStatement.setString(6, c.getLogradouro());
            this.preparedStatement.setString(7, c.getNumero());
            this.preparedStatement.setString(8, c.getTelefone());
            this.preparedStatement.setString(9, c.getEmail());
            this.preparedStatement.setString(10, c.getRazao_social());

            this.preparedStatement.execute();

            return "Casdastro realizado com sucesso";
        }catch (SQLException e){
            e.printStackTrace();
            return "Cadastro não realizado";
        }
    }

    public ArrayList<Consultorio> getConsultorios(){
        ArrayList<Consultorio> consultorios = new ArrayList<Consultorio>();

        try(Connection connection = new ConectaDB().getConexao()){
            this.sql = "SELECT * FROM consultorio";
            this.stmt = connection.createStatement();
            this.rs = this.stmt.executeQuery(sql);

            while(this.rs.next()){
                Consultorio c = new Consultorio();
                c.setCnpj(this.rs.getString("cnpj"));
                c.setCep(this.rs.getString("cep"));
                c.setBairro(this.rs.getString("bairro"));
                c.setCidade(this.rs.getString("cidade"));
                c.setEstado(this.rs.getString("estado"));
                c.setNumero(this.rs.getString("numero"));
                c.setTelefone(this.rs.getString("telefone"));
                c.setEmail(this.rs.getString("email"));
                c.setRazao_social(this.rs.getString("razao_social"));

                consultorios.add(c);
            }

            return consultorios;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public Consultorio getConsultorioByCnpj(String cnpj){
        Consultorio c = new Consultorio();

        try(Connection connection = new ConectaDB().getConexao()){
            this.sql = "SELECT * FROM consultorio WHERE cnpj = ?";
            this.preparedStatement = connection.prepareStatement(sql);
            this.preparedStatement.setString(1, cnpj);

            this.rs = this.preparedStatement.executeQuery();

            this.rs.next();

            c.setCnpj(this.rs.getString("cnpj"));
            c.setCep(this.rs.getString("cep"));
            c.setBairro(this.rs.getString("bairro"));
            c.setCidade(this.rs.getString("cidade"));
            c.setEstado(this.rs.getString("estado"));
            c.setNumero(this.rs.getString("numero"));
            c.setTelefone(this.rs.getString("telefone"));
            c.setEmail(this.rs.getString("email"));
            c.setRazao_social(this.rs.getString("razao_social"));
            c.setId(this.rs.getInt("id"));

            return c;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public String atualizaConsultorio(Consultorio c){

        try(Connection connection = new ConectaDB().getConexao()){
            this.sql = "UPDATE consultorio SET cnpj = ?, cep = ?, bairro = ?, cidade = ?, estado = ?, logradouro = ?, numero = ?, telefone = ?, email = ?, razao_social = ? " +
                    "WHERE id = ?";
            this.preparedStatement = connection.prepareStatement(sql);
            this.preparedStatement.setString(1, c.getCnpj());
            this.preparedStatement.setString(2, c.getCep());
            this.preparedStatement.setString(3, c.getBairro());
            this.preparedStatement.setString(4, c.getCidade());
            this.preparedStatement.setString(5, c.getEstado());
            this.preparedStatement.setString(6, c.getLogradouro());
            this.preparedStatement.setString(7, c.getNumero());
            this.preparedStatement.setString(8, c.getTelefone());
            this.preparedStatement.setString(9, c.getEmail());
            this.preparedStatement.setString(10, c.getRazao_social());
            this.preparedStatement.setInt(11, c.getId());

            this.preparedStatement.execute();

            return "Cadastro atualizado com sucesso";
        }catch (SQLException e){
            e.printStackTrace();
            return "Não foi possivel atualizar";
        }
    }

    public String deletaConsultorio(Consultorio c){

        try(Connection connection = new ConectaDB().getConexao()){
            this.sql = "DELETE FROM consultorio WHERE id = ?";
            this.preparedStatement = connection.prepareStatement(sql);
            this.preparedStatement.setInt(1, c.getId());

            this.preparedStatement.execute();

            return "Consultorio deletado com sucesso";
        }catch (SQLException e){
            e.printStackTrace();
            return "Não foi possivel deletar";
        }
    }
}
