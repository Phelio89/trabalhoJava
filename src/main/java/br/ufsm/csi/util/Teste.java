package br.ufsm.csi.util;

import br.ufsm.csi.dao.*;
import br.ufsm.csi.model.Consultorio;
import br.ufsm.csi.model.Paciente;
import br.ufsm.csi.model.Tutor;
import br.ufsm.csi.model.Veterinario;

import java.util.ArrayList;


public class Teste {

    public static void main(String args[]){
        deletaConsultorio();

    }

    public static void testGetTutores(){
        for (Tutor u : new TutorDao().getTutores()) {
            System.out.println();
        }
    }

    public static void testeGetPaciente(){
        for (Paciente p : new PacienteDao().getPacientes()) {
            System.out.println("Paciente: "+p.getNome());
        }
    }

    public static void testeGetByNameAndTutor(){
        Paciente pnome = new Paciente("Link");
        Tutor tnome = new Tutor("Érika");

        Paciente p = new PacienteDao().getPacientesByNameAndTutor(pnome, tnome);
        System.out.println("Paciente: "+p.getNome());
        System.out.println("Tutor: "+p.getTutor().getNome());
    }

    public static String testeCadastraPaciente(Paciente paciente, Tutor tutor){
        return new PacienteDao().cadastrar(paciente,tutor);
    }

    public static void testaDeletarPaciente(){
        Paciente p = new Paciente("Dave");
        p.setId(5);

        System.out.println(new PacienteDao().deletar(p));
    }

    public static void testaAtualizarPaciente(){
        Paciente p = new Paciente("Dave");
        p.setId(4);
        p.setRaca("SRD");
        p.setEspecie("felino");
        p.setSexo("M");

        System.out.println(new PacienteDao().atualizar(p));

    }

    public static void testaCadastrarTutor(){
        Tutor t = new Tutor("Alex");
        t.setCpf("123123132");
        t.setCelular("1234145678");

        System.out.println(new TutorDao().cadastraTutor(t));
    }

    public static void testaGetTutorCPF(){
        Tutor t = new TutorDao().getTutorByCpf("96785643");
        System.out.println("Nome: "+t.getNome());
        System.out.println("CPF: "+t.getCpf());
    }

    public static void testaDeletarTutor(){
        Tutor t = new Tutor("Alex");
        t.setId(5);
        System.out.println(new TutorDao().deletarTutor(t));
    }

    public static void testaAtualizaTutor(){
        Tutor t = new TutorDao().getTutorByCpf("96785643");
        t.setNome("Loreni");
        System.out.println(new TutorDao().atualizarTutor(t));
    }

    public static void testaGetVet(){
        for (Veterinario v : new VeterinarioDao().getVeterinarios()) {
            System.out.println("Veterinario: "+v.getNome());
        }

    }

    public static void testaGetVetCrmv(){
        Veterinario v = new VeterinarioDao().getVeterinarioByCrmv("321312");

        System.out.println("Nome: "+v.getNome());
        System.out.println("CRMV: "+v.getCrmv());
    }

    public static void testaCadastrarVet(){
        Veterinario v = new Veterinario();
        v.setNome("Pedro");
        v.setCrmv("123123");
        v.setConsultorio_id(2);

        System.out.println(new VeterinarioDao().cadastrarVet(v));

    }

    public static void testaDeletaVet(){
        System.out.println(new VeterinarioDao().deletaVet(new VeterinarioDao().getVeterinarioByCrmv("123123")));
    }

    public static void testaAtualizaVet(){
        Veterinario v = new VeterinarioDao().getVeterinarioByCrmv("512345");
        v.setValor_consulta(150.00);
        System.out.println(new VeterinarioDao().atualizaVet(v));
    }

    public static void testaGeConsultorio(){

        for (Consultorio c: new ConsultorioDao().getConsultorios()) {
            System.out.println("Razao Social: "+c.getRazao_social());
        }

    }

    public static void testaGetConCnpj(){
        Consultorio c = new ConsultorioDao().getConsultorioByCnpj("CNPJ5232524");

        System.out.println("Razao social: "+c.getRazao_social());
        System.out.println("CNPJ: "+c.getCnpj());

    }

    public static void testaCadastraConsu(){
        Consultorio c = new Consultorio();
        c.setRazao_social("Meh");
        c.setCnpj("6666");

        System.out.println(new ConsultorioDao().cadastrar(c));
    }

    public static void testaAtualizaCon(){
        Consultorio c = new ConsultorioDao().getConsultorioByCnpj("6666");
        c.setNumero("7777");
        c.setTelefone("00000-0000");
        System.out.println(new ConsultorioDao().atualizaConsultorio(c));
    }

    public static void deletaConsultorio(){

        System.out.println(new ConsultorioDao().deletaConsultorio(new ConsultorioDao().getConsultorioByCnpj("6666")));
    }
}
