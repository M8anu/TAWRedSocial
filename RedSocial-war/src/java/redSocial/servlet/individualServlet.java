/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redSocial.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
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
import redsocial.dao.TipoChatFacade;
import redsocial.dao.UsuarioFacade;
import redsocial.entity.Chat;
import redsocial.entity.TipoChat;
import redsocial.entity.Usuario;

/**
 *
 * @author Guille
 */
@WebServlet(name = "individualServlet", urlPatterns = {"/individualServlet"})
public class individualServlet extends HttpServlet {

    @EJB
    private TipoChatFacade tipochatFacade;

    @EJB
    private ChatFacade chatFacade;
    
    @EJB
    private UsuarioFacade usuarioFacade;
    
    
    
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
        
        String id = request.getParameter("id");
        Usuario u = this.usuarioFacade.find(new Integer(id));
        String id2 = request.getParameter("id2");
        Usuario u2 = this.usuarioFacade.find(new Integer(id2));
        
        request.setAttribute("u", u);
        request.setAttribute("u2", u2);
        
        Chat c = null;
        
        for (Chat chat : u.getChatList1()) {
            
            for (Usuario us: chat.getUsuarioList()) {
                
                if (u2.equals(us)) {
                    
                    c = chat;
                }
            }
        }
        
        if (c != null) {
            
            request.setAttribute("chat", c);
            request.setAttribute("u", u);
            request.setAttribute("u2", u2);
            RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/individual.jsp");
            rd.forward(request, response);
        
        } else {
            
            c = new Chat();
            c.setUsuarioCreador(u);
            TipoChat t = new TipoChat();
            c.setTipoChat(this.tipochatFacade.find("Conversacion"));
            List<Usuario> listaU = new ArrayList<>();
            listaU.add(u2);
            c.setUsuarioList(listaU);
            Date date = new Date();
            Timestamp ts=new Timestamp(date.getTime());  
            c.setFechaCreacion(ts);
            this.chatFacade.create(c);
            request.setAttribute("chat", c);
            request.setAttribute("u", u);
            request.setAttribute("u2", u2);
            RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/individual.jsp");
            rd.forward(request, response);
        }


        
       
        
        
        
        
        
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
