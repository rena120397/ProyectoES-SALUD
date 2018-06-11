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
public class ServletInsertar extends HttpServlet {

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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //obtiene el valor de accion del frm de "intranet-insertar.jsp
        String accion = request.getParameter("accion");

        if (accion == null) {
            accion = "";
        }
        System.out.println("accion   " + accion);
        //obtiene la sesion ya iniciada
        HttpSession session = request.getSession();
        //Obtiene la sesion ya iniciada en ServletControler por el atributo "bUsuario" 
        //y lo castea a tipo "(Usuario)" dentro de la variable "busuario"
        Usuario busuario = (Usuario) session.getAttribute("bUsuario");

        if (busuario == null) {
            request.getRequestDispatcher("jsp/404.jsp").forward(request, response);
        } else {
            switch (busuario.getID_PERFIL()) {// obtiene el ID_PERFIL del usuario logeado
                case 1:// ID_PERFIL = 1 = administrador 
                    if (accion.equalsIgnoreCase("Insertar")) {//llamado desde intranet-insertar.jsp, boton INSERTAR
                        //instancia nuevo usuario
                        UsuarioAdm usuAdm = new UsuarioAdm();
                        Usuario usu = new Usuario();
                        //Definiendo los valores de objeto usuario con los valores de las cajas de texto del formulario.
                        usu.setID_USU(request.getParameter("TXT_ID_USU"));
                        usu.setNOMBRE(request.getParameter("TXT_NOMBRE"));
                        usu.setCONTRA(request.getParameter("TXT_CONTRA"));
                        usu.setID_PERFIL(Integer.parseInt(request.getParameter("TXT_ID_PERFIL")));
                        //registra usuario en la bd
                        usuAdm.registrarUsuario(usu);
                        //lista usuarios
                        ArrayList alUsuarios = usuAdm.getListaUsuarios();
                        //establece atributo "alUsuarios" para el obejeto instanciado,
                        //para ser llamado en intranet-insertar.jsp
                        request.setAttribute("alUsuarios", alUsuarios);
                        //enviar nuevamente a intranet-insertar.jsp
                        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/intranet-insertar.jsp");
                        dispatcher.forward(request, response);
                    }
                    break;
                default://en caso se intente acceder sin haberse logeado
                    response.sendRedirect("jsp/404.jsp");
            }
        }

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
