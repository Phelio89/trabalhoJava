package br.ufsm.csi.util;

import br.ufsm.csi.dao.ConectaDB;
import br.ufsm.csi.dao.PacienteDao;
import br.ufsm.csi.dao.TutorDao;
import br.ufsm.csi.model.Paciente;
import br.ufsm.csi.model.Tutor;


public class Teste {

    public static void main(String args[]){
        testaAtualizaTutor();

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
}
