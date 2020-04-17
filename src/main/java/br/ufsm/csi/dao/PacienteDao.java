package br.ufsm.csi.dao;

import br.ufsm.csi.model.Paciente;
import br.ufsm.csi.model.Tutor;

import java.sql.*;
import java.util.ArrayList;

public class PacienteDao {

    private String sql;
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement preparedStatement;

    public String cadastrar(Paciente paciente, Tutor tutor){

        try(Connection connection = new ConectaDB().getConexao()){

            this.sql = "INSERT INTO paciente (especie, nome, raca, sexo, tutor_id) " +
                    "VALUES (?, ?, ?, ?, ?)";

             this.preparedStatement = connection.prepareStatement(this.sql);
             this.preparedStatement.setString(1, paciente.getEspecie());
             this.preparedStatement.setString(2, paciente.getNome());
             this.preparedStatement.setString(3, paciente.getRaca());
             this.preparedStatement.setString(4, paciente.getSexo());
             this.preparedStatement.setInt(5, tutor.getId());

             this.preparedStatement.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }

        return "Paciente cadastrado com sucesso";
    }

    public String deletar(Paciente p){

        try(Connection connection = new ConectaDB().getConexao()){

            this.sql = "DELETE FROM paciente WHERE id = ?";

            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setInt(1, p.getId());

            this.preparedStatement.execute();

            return "Paciente Deletado";
        }catch (SQLException e){
            e.printStackTrace();
            return "Não foi possivel deletar o paciente";
        }
    }

    public String atualizar(Paciente p){

        try(Connection connection = new ConectaDB().getConexao()){
            this.sql = "UPDATE paciente SET especie = ?, nome = ?, raca = ?, sexo = ? " +
                    "WHERE id = ?";
            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setString(1, p.getEspecie());
            this.preparedStatement.setString(2, p.getNome());
            this.preparedStatement.setString(3, p.getRaca());
            this.preparedStatement.setString(4, p.getSexo());
            this.preparedStatement.setInt(5, p.getId());

            this.preparedStatement.execute();

            return "Paciente atualizado";

        }catch (SQLException e){
            e.printStackTrace();
            return "Não foi possivel atualizar paciente";
        }
    }

    public Paciente getPacientesByNameAndTutor(Paciente p, Tutor t){

        Paciente paciente = new Paciente(null);

        try(Connection connection = new ConectaDB().getConexao()){


            this.sql = "SELECT * , p.nome pnome, t.nome tnome FROM paciente p, tutor t " +
                    "WHERE p.nome = ? AND p.tutor_id = t.id AND t.nome = ?";

            this.preparedStatement = connection.prepareStatement(this.sql);
            this.preparedStatement.setString(1, p.getNome());
            this.preparedStatement.setString(2, t.getNome());

            this.rs = this.preparedStatement.executeQuery();


            while(this.rs.next()){
                paciente.setNome(this.rs.getString("pnome"));

                Tutor tutor = new Tutor(this.rs.getString("tnome"));

                paciente.setTutor(tutor);
            }


        }catch (SQLException e){
            e.printStackTrace();
        }
        return paciente;
    }

    public ArrayList<Paciente> getPacientes(){
        ArrayList<Paciente> pacientes = new ArrayList<Paciente>();

        try(Connection connection = new ConectaDB().getConexao()){

            this.sql = "SELECT * FROM paciente";
            this.stmt = connection.createStatement();
            this.rs = stmt.executeQuery(sql);

            while(this.rs.next()){
                Paciente paciente = new Paciente(null);
                paciente.setId(this.rs.getInt("id"));
                paciente.setNome(this.rs.getString("nome"));
                paciente.setEspecie(this.rs.getString("especie"));
                paciente.setRaca(this.rs.getString("raca"));
                paciente.setSexo(this.rs.getString("sexo"));

                pacientes.add(paciente);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return pacientes;
    }

    public ArrayList<Paciente> getPacientesTutor(){
        ArrayList<Paciente> pacientes = new ArrayList<Paciente>();

        try(Connection connection = new ConectaDB().getConexao()){

            this.sql = "SELECT p.id pid, p.nome pnome, t.id tid, t.nome tnome FROM paciente p, tutor t WHERE p.tutor_id = t.id";
            this.stmt = connection.createStatement();
            this.rs = stmt.executeQuery(sql);

            while(this.rs.next()){
                Paciente paciente = new Paciente(null);
                paciente.setId(this.rs.getInt("pid"));
                paciente.setNome(this.rs.getString("pnome"));

                Tutor tutor = new Tutor(null);
                tutor.setId(this.rs.getInt("tid"));
                tutor.setNome(this.rs.getString("tnome"));

                paciente.setTutor(tutor);
                pacientes.add(paciente);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return pacientes;
    }

}
