package br.ufsm.csi.controller;

import br.ufsm.csi.dao.ConsultaDao;
import br.ufsm.csi.dao.PacienteDao;
import br.ufsm.csi.dao.TutorDao;
import br.ufsm.csi.model.Consulta;
import br.ufsm.csi.model.Tutor;
import br.ufsm.csi.model.Veterinario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/consultas")
public class ConsultaController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String opcao = req.getParameter("opcao");
        int clinica =  Integer.parseInt(req.getParameter("clinica"));

        TutorDao dao = new TutorDao();

        switch (opcao) {
            case "novo": {
                req.setAttribute("clinica", clinica);
                int id = Integer.parseInt(req.getParameter("id"));
                req.setAttribute("paciente", new PacienteDao().getPacientesById(id));

                RequestDispatcher rd = req.getRequestDispatcher("/novaConsulta.jsp");
                rd.forward(req, resp);
                break;
            }
            case "delete": {

                break;
            }
            case "edit": {


                break;
            }
            case "editSave": {


                break;
            }
            case "save": {
                String descricao = req.getParameter("descricao");
                int id = Integer.parseInt(req.getParameter("id"));

                Consulta c = new Consulta();
                c.setDescricao(descricao);
                c.setPaciente(new PacienteDao().getPacientesById(id));
                c.setClinica(id);

                System.out.println(new ConsultaDao().marcaConsulta(c));

                req.setAttribute("clinica", clinica);
                req.setAttribute("tutores", new TutorDao().getTutoresByClinic(clinica));

                RequestDispatcher rd = req.getRequestDispatcher("/tutores.jsp");
                rd.forward(req, resp);
                break;
            }
            case "consultas": {
                req.setAttribute("clinica", clinica);
                req.setAttribute("consultas", new ConsultaDao().getConsultas(clinica));

                RequestDispatcher rd = req.getRequestDispatcher("/consultas.jsp");
                rd.forward(req, resp);
                break;
            }
        }
    }
}

