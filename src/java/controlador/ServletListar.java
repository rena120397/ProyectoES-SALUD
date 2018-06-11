/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.adm.UsuarioAdm;
import app.modelo.vo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author NB
 */
public class ServletListar extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
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
        //Obtiene el valor del input (name="accion" value="goListar") de intranet.jsp 
        String accion = request.getParameter("accion");

        if (accion == null) {
            accion = "";
        }

        System.out.println("accion----" + accion);

        HttpSession session = request.getSession();
        //Obtiene la sesion ya iniciada en ServletControler por el atributo "bUsuario" 
        //y lo castea a tipo "(Usuario)" dentro de la variable "busuario"
        Usuario busuario = (Usuario) session.getAttribute("bUsuario");

        if (busuario == null) {
            request.getRequestDispatcher("jsp/404.jsp").forward(request, response);
        } else {
            switch (busuario.getID_PERFIL()) { // obtiene el ID_PERFIL del usuario logeado
                case 1: // ID_PERFIL = 1 = administrador 
                    if (accion.equalsIgnoreCase("goListar")) { //llamado desde intranet, boton LISTAR
                        //instancia usuAdm
                        UsuarioAdm usuAdm = new UsuarioAdm();
                        //Obtiene la lista de usuarios actuales de la bd
                        ArrayList alUsuarios = usuAdm.getListaUsuarios();
                        //establece atributo "alUsuarios" para el obejeto instanciado,
                        //para ser llamado en intranet-listar.jsp
                        request.setAttribute("alUsuarios", alUsuarios);
                        //Envia a intranet-listar.jsp
                        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/intranet-listar.jsp");
                        dispatcher.forward(request, response);
                    } else if (accion.equalsIgnoreCase("goRegistrar")) { //llamado desde intranet, boton Insertar
                        //instancia usuAdm
                        UsuarioAdm usuAdm = new UsuarioAdm();
                        //Obtiene la lista de usuarios actuales de la bd
                        ArrayList alUsuarios = usuAdm.getListaUsuarios();
                        //establece atributo "alUsuarios" para el obejeto instanciado,
                        //para ser llamado en intranet-insertar.jsp
                        request.setAttribute("alUsuarios", alUsuarios);
                        //Envia a intranet-insertar.jsp
                        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/intranet-insertar.jsp");
                        dispatcher.forward(request, response);
                    }
                    break;
                default: //en caso se intente acceder sin haberse logeado
                    response.sendRedirect("jsp/404.jsp");
            }
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
