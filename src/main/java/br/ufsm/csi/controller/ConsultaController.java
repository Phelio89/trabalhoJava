package br.ufsm.csi.controller;

import br.ufsm.csi.dao.ConsultaDao;
import br.ufsm.csi.dao.TutorDao;
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

                RequestDispatcher rd = req.getRequestDispatcher("/cadastroTutor.jsp");
                rd.forward(req, resp);
                break;
            }
            case "delete": {
                int id = Integer.parseInt(req.getParameter("id"));
                dao.deletarTutor(id);

                req.setAttribute("clinica", clinica);
                req.setAttribute("tutores", new TutorDao().getTutoresByClinic(clinica));

                RequestDispatcher rd = req.getRequestDispatcher("/tutores.jsp");
                rd.forward(req, resp);
                break;
            }
            case "edit": {
                int id = Integer.parseInt(req.getParameter("id"));
                req.setAttribute("tutor", dao.getTutorById(id));
                req.setAttribute("clinica", clinica);

                RequestDispatcher rd = req.getRequestDispatcher("/tutorView.jsp");
                rd.forward(req, resp);

                break;
            }
            case "editSave": {
                int id = Integer.parseInt(req.getParameter("id"));

                String nome = req.getParameter("nome");
                String email = req.getParameter("email");
                String celular = req.getParameter("celular");
                String cpf = req.getParameter("cpf");
                String cep = req.getParameter("cep");
                String bairro = req.getParameter("bairro");
                String cidade = req.getParameter("cidade");
                String estado = req.getParameter("estado");
                String logradouro = req.getParameter("logradouro");
                String numero = req.getParameter("numero");

                Tutor t = new Tutor(nome);
                t.setId(id);
                t.setCelular(celular);
                t.setEmail(email);
                t.setCpf(cpf);
                t.setBairro(bairro);
                t.setCep(cep);
                t.setCidade(cidade);
                t.setEstado(estado);
                t.setNumero(numero);
                t.setLogradouro(logradouro);

                System.out.println(dao.atualizarTutor(t));

                req.setAttribute("clinica", clinica);
                req.setAttribute("tutores", new TutorDao().getTutoresByClinic(clinica));

                RequestDispatcher rd = req.getRequestDispatcher("/tutores.jsp");
                rd.forward(req, resp);

                break;
            }
            case "save": {
                String nome = req.getParameter("nome");
                String email = req.getParameter("email");
                String celular = req.getParameter("celular");
                String cpf = req.getParameter("cpf");
                String cep = req.getParameter("cep");
                String bairro = req.getParameter("bairro");
                String cidade = req.getParameter("cidade");
                String estado = req.getParameter("estado");
                String logradouro = req.getParameter("logradouro");
                String numero = req.getParameter("numero");
                int consultorio_id = Integer.parseInt(req.getParameter("consultorio"));

                Tutor t = new Tutor(nome);
                t.setCelular(celular);
                t.setEmail(email);
                t.setCpf(cpf);
                t.setBairro(bairro);
                t.setCep(cep);
                t.setCidade(cidade);
                t.setEstado(estado);
                t.setNumero(numero);
                t.setLogradouro(logradouro);
                t.setConsultorio_id(consultorio_id);

                System.out.println(dao.cadastraTutor(t));

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

