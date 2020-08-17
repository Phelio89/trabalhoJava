package br.ufsm.csi.model;

import java.sql.Date;

public class Consulta {

    private int id;
    private Date data_hora_inicial;
    private Date data_hora_final;
    private Veterinario veterinario;
    private Paciente paciente;
    private String descricao;
    private String comentario;
    private int clinica;

    public Consulta() {
    }

    public int getClinica() {
        return clinica;
    }

    public void setClinica(int clinica) {
        this.clinica = clinica;
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

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
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
