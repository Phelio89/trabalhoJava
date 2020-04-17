package br.ufsm.csi.model;

public class Veterinario {

    private int id;
    private String nome;
    private String email;
    private String celular;
    private String senha;
    private String crmv;
    private double valor_consulta;
    private int consultorio_id;

    public Veterinario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCrmv() {
        return crmv;
    }

    public void setCrmv(String crmv) {
        this.crmv = crmv;
    }

    public double getValor_consulta() {
        return valor_consulta;
    }

    public void setValor_consulta(double valor_consulta) {
        this.valor_consulta = valor_consulta;
    }

    public int getConsultorio_id() {
        return consultorio_id;
    }

    public void setConsultorio_id(int consultorio_id) {
        this.consultorio_id = consultorio_id;
    }
}
