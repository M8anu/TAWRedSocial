/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redSocial.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import redsocial.dao.ChatFacade;
import redsocial.dao.MensajeFacade;
import redsocial.dao.UsuarioFacade;
import redsocial.entity.Chat;
import redsocial.entity.Mensaje;
import redsocial.entity.Usuario;

/**
 *
 * @author Guille
 */
@WebServlet(name = "enviarMensajeServlet", urlPatterns = {"/enviarMensajeServlet"})
public class enviarMensajeServlet extends HttpServlet {

    @EJB
    private ChatFacade chatFacade;

    @EJB
    private UsuarioFacade usuarioFacade;

    @EJB
    private MensajeFacade mensajeFacade;

    
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String contenido = request.getParameter("mensaje");
        String id = request.getParameter("id");
        String chat = request.getParameter("chat");
        String id2 = request.getParameter("id2");
        Usuario u = this.usuarioFacade.find(new Integer(id));
        Usuario u2 = this.usuarioFacade.find(new Integer(id2));
        Chat c = this.chatFacade.find(new Integer(chat));
        Mensaje m = new Mensaje();
        
        m.setContenido(contenido);
        m.setIdUsuario(u);
        m.setIdChat(c);
        Date date = new Date();
        m.setHoraEnvio(date);
        List<Chat> listaC = new ArrayList<>();
        listaC.add(c);
        m.setChatList(listaC);
        
        this.mensajeFacade.create(m);

        request.setAttribute("id", id);
        request.setAttribute("id2", id2);
        
        request.setAttribute("u", u);
        
        RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/mensajeEnviado.jsp");
        rd.forward(request, response);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
