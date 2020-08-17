package br.ufsm.csi.controller;

import br.ufsm.csi.dao.PacienteDao;
import br.ufsm.csi.dao.TutorDao;
import br.ufsm.csi.model.Paciente;
import br.ufsm.csi.model.Tutor;
import br.ufsm.csi.model.Veterinario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/pacientes")
public class PacienteController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String opcao = req.getParameter("opcao");
        int clinica =  Integer.parseInt(req.getParameter("clinica"));

        TutorDao dao = new TutorDao();

        switch (opcao) {
            case "novo": {
                req.setAttribute("clinica", clinica);
                int tutor_id =  Integer.parseInt(req.getParameter("id"));

                req.setAttribute("id", tutor_id);

                RequestDispatcher rd = req.getRequestDispatcher("/novoPaciente.jsp");
                rd.forward(req, resp);
                break;
            }
            case "delete": {
                int id = Integer.parseInt(req.getParameter("id"));
                new PacienteDao().deletar(id);

                req.setAttribute("clinica", clinica);
                req.setAttribute("tutores", new TutorDao().getTutoresByClinic(clinica));

                RequestDispatcher rd = req.getRequestDispatcher("/tutores.jsp");
                rd.forward(req, resp);
                break;
            }
            case "edit": {
                int id = Integer.parseInt(req.getParameter("id"));
                req.setAttribute("pet", new PacienteDao().getPacientesById(id));
                req.setAttribute("clinica", clinica);

                RequestDispatcher rd = req.getRequestDispatcher("/petView.jsp");
                rd.forward(req, resp);

                break;
            }
            case "editSave": {
                int id = Integer.parseInt(req.getParameter("id"));

                String nome = req.getParameter("nome");
                String sexo = req.getParameter("sexo");
                String raca = req.getParameter("raca");
                String especie = req.getParameter("especie");

                Paciente p = new Paciente(nome);
                p.setId(id);
                p.setSexo(sexo);
                p.setEspecie(especie);
                p.setRaca(raca);

                System.out.println(new PacienteDao().atualizar(p));

                req.setAttribute("clinica", clinica);
                req.setAttribute("tutores", new TutorDao().getTutoresByClinic(clinica));

                RequestDispatcher rd = req.getRequestDispatcher("/tutores.jsp");
                rd.forward(req, resp);

                break;
            }
            case "save": {
                String nome = req.getParameter("nome");
                String sexo = req.getParameter("sexo");
                String raca = req.getParameter("raca");
                String especie = req.getParameter("especie");
                int tutor_id = Integer.parseInt(req.getParameter("id"));

                Paciente p = new Paciente(nome);
                p.setTutor(new TutorDao().getTutorById(tutor_id));
                p.setSexo(sexo);
                p.setEspecie(especie);
                p.setRaca(raca);

                System.out.println(new PacienteDao().cadastrar(p));

                req.setAttribute("clinica", clinica);
                req.setAttribute("tutores", new TutorDao().getTutoresByClinic(clinica));

                RequestDispatcher rd = req.getRequestDispatcher("/tutores.jsp");
                rd.forward(req, resp);
                break;
            }
        }
    }
}
