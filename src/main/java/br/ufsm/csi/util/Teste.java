package br.ufsm.csi.util;

import br.ufsm.csi.dao.ConectaDB;
import br.ufsm.csi.dao.PacienteDao;
import br.ufsm.csi.dao.TutorDao;
import br.ufsm.csi.model.Paciente;
import br.ufsm.csi.model.Tutor;

public class Teste {

    public static void main(String args[]){

        testeGetPaciente();

    }

    public static void testGetTutores(){
        for (Tutor u : new TutorDao().getTutores()) {
            System.out.println();
        }
    }

    public static  void testeGetPaciente(){
        for (Paciente p : new PacienteDao().getPacientes()) {
            System.out.println("Paciente: "+p.getNome());
        }
    }
}
