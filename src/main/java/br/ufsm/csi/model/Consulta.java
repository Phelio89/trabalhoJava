package br.ufsm.csi.model;

import java.sql.Date;

public class Consulta {

    private int id;
    private Date data_hora_inicial;
    private Date data_hora_final;
    private int medico_id;
    private int paciten_id;
    private String descricao;
    private String comentario;

    public Consulta() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData_hora_inicial() {
        return data_hora_inicial;
    }

    public void setData_hora_inicial(Date data_hora_inicial) {
        this.data_hora_inicial = data_hora_inicial;
    }

    public Date getData_hora_final() {
        return data_hora_final;
    }

    public void setData_hora_final(Date data_hora_final) {
        this.data_hora_final = data_hora_final;
    }

    public int getMedico_id() {
        return medico_id;
    }

    public void setMedico_id(int medico_id) {
        this.medico_id = medico_id;
    }

    public int getPaciten_id() {
        return paciten_id;
    }

    public void setPaciten_id(int paciten_id) {
        this.paciten_id = paciten_id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
