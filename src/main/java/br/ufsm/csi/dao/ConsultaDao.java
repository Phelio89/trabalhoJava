package br.ufsm.csi.dao;

import br.ufsm.csi.model.Consulta;
import br.ufsm.csi.model.Paciente;
import br.ufsm.csi.model.Veterinario;

import java.sql.*;
import java.util.ArrayList;

public class ConsultaDao {

    private String sql;
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement preparedStatement;

    public String marcaConsulta(Paciente p, Veterinario v, Date d){

        try(Connection connection = new ConectaDB().getConexao()){

            this.sql =  "INSERT INTO consulta (data_hora_inicial, medico_id, paciente_id) " +
                    "VALUES (?, ?, ?)";

            this.preparedStatement = connection.prepareStatement(sql);
            this.preparedStatement.setDate(1, d);
            this.preparedStatement.setInt(2, v.getId());
            this.preparedStatement.setInt(3, p.getId());

            this.preparedStatement.execute();

            return "Consulta marcada com sucesso";

        }catch (SQLException e){
            e.printStackTrace();
            return "Consulta não pode ser marcada";
        }
    }

    public ArrayList<Consulta> getConsultas(){

        ArrayList<Consulta> consultas = new ArrayList<Consulta>();

        try(Connection connection = new ConectaDB().getConexao()){

            this.sql = "SELECT * FROM consulta";
            this.stmt = connection.createStatement();
            this.rs = this.stmt.executeQuery(sql);

            while (rs.next()){
                Consulta c = new Consulta();
                c.setData_hora_inicial(rs.getDate("data_hora_inicial"));
                c.setData_hora_final(rs.getDate("data_hora_final"));
                c.setPaciente(new PacienteDao().getPacientesById(rs.getInt("paciente_id")));
                c.setVeterinario(new VeterinarioDao().getVeterinarioById(rs.getInt("medico_id")));
                c.setComentario(rs.getString("comentario"));
                c.setDescricao(rs.getString("descricao"));
                consultas.add(c);
            }

            return consultas;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public String deletarConsulta(Consulta c){

        try(Connection connection = new ConectaDB().getConexao()){
            this.sql = "DELETE FROM consulta WHERE id = ?";
            this.preparedStatement = connection.prepareStatement(sql);
            this.preparedStatement.setInt(1, c.getId());

            this.preparedStatement.execute();

            return "Consulta deletada com sucesso";
        }catch (SQLException e){
            e.printStackTrace();
            return "Não foi possivel deletar consulta";
        }

    }

    public String editarConsulta(Consulta c){

        try(Connection connection = new ConectaDB().getConexao()){

            this.sql = "UPDATE consulta SET data_hora_inicial = ?, data_hora_final = ?, medico_id = ?, paciente_id = ?, descricao = ?, comentario = ? " +
                    "WHERE id = ?";
            this.preparedStatement = connection.prepareStatement(sql);
            this.preparedStatement.setDate(1, c.getData_hora_inicial());
            this.preparedStatement.setDate(2, c.getData_hora_final());
            this.preparedStatement.setInt(3, c.getVeterinario().getId());
            this.preparedStatement.setInt(4, c.getPaciente().getId());
            this.preparedStatement.setString(5, c.getDescricao());
            this.preparedStatement.setString(6, c.getComentario());
            this.preparedStatement.setInt(7, c.getId());

            this.preparedStatement.execute();

            return "Consulta editada com sucesso";
        }catch (SQLException e){
            e.printStackTrace();
            return "Não foi possivel editar";
        }

    }

    public Consulta getConsultaById(int id){
        Consulta c = new Consulta();

        try(Connection connection = new ConectaDB().getConexao()){

            this.sql = "SELECT * FROM consulta WHERE id = ?";

            this.preparedStatement = connection.prepareStatement(sql);
            this.preparedStatement.setInt(1, id);

            this.rs = this.preparedStatement.executeQuery();

            while (rs.next()){
                c.setId(rs.getInt("id"));
                c.setData_hora_inicial(rs.getDate("data_hora_inicial"));
                c.setData_hora_final(rs.getDate("data_hora_final"));
                c.setPaciente(new PacienteDao().getPacientesById(rs.getInt("paciente_id")));
                c.setVeterinario(new VeterinarioDao().getVeterinarioById(rs.getInt("medico_id")));
                c.setComentario(rs.getString("comentario"));
                c.setDescricao(rs.getString("descricao"));
            }

            return c;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
