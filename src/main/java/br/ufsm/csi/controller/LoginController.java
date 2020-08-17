package br.ufsm.csi.controller;

import br.ufsm.csi.dao.ConsultaDao;
import br.ufsm.csi.dao.VeterinarioDao;
import br.ufsm.csi.model.Veterinario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("login")
public class LoginController extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        VeterinarioDao dao = new VeterinarioDao();
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");

        Veterinario v = dao.loginVet(email, senha);

        if( v.getEmail() != null) {
            req.setAttribute("clinica", v.getConsultorio_id());

            req.setAttribute("consultas", new ConsultaDao().getConsultas(v.getConsultorio_id()));

            RequestDispatcher rd = req.getRequestDispatcher("/consultas.jsp");
            rd.forward(req, resp);
        }

        RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
        rd.forward(req, resp);
    }
}
