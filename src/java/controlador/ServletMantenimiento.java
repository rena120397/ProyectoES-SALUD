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
public class ServletMantenimiento extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        //Obtiene la sesion ya iniciada en ServletControler por el atributo "bUsuario" 
        //y lo castea a tipo "(Usuario)" dentro de la variable "busuario"
        HttpSession session = request.getSession();

        Usuario busuario = (Usuario) session.getAttribute("bUsuario");
        if (busuario != null) {
            //obtiene el valor de accion del intranet.jsp
            String accion = request.getParameter("accion");

            if (accion == null) {
                accion = "recarga";
            }
            System.out.println("accion   " + accion);

            switch (busuario.getID_PERFIL()) {// obtiene el ID_PERFIL del usuario logeado
                case 1:// ID_PERFIL = 1 = administrador 
                    if (accion.equalsIgnoreCase("goMantenimiento")) {//llamado desde intranet.jsp, boton MANTENIMIENTO
                        //instancia nuevo usuario
                        UsuarioAdm usuAdm = new UsuarioAdm();
                        //lista usuarios
                        ArrayList alUsuarios = usuAdm.getListaUsuarios();
                        //establece atributo "alUsuarios" para el obejeto instanciado,
                        //para ser llamado en intranet-mantenimiento.jsp
                        request.setAttribute("alUsuarios", alUsuarios);
                        //Envia a intranet-mantenimiento.jsp
                        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/intranet-mantenimiento.jsp");
                        dispatcher.forward(request, response);
                    } else if (accion.equalsIgnoreCase("Eliminar")) {//llamado desde intranet-mantenimiento.jsp, boton ELIMINAR
                        //instancia usuAdm
                        UsuarioAdm usuAdm = new UsuarioAdm();
                        //lista usuarios
                        ArrayList alUsuarios = usuAdm.getListaUsuarios();
                        request.setAttribute("alUsuarios", alUsuarios);
                        //instancia Usuario
                        Usuario usu = new Usuario();
                        //Definiendo los valores de objeto Usuario con los valores de las cajas de texto del formulario.
                        usu.setID_USU(request.getParameter("TXT_ID_USU"));
                        //elimina de la bd el usuario cuyo ID_USU sea el ingresado
                        usuAdm.eliminarUsuario(usu);
                        //envia nuevamente a intranet-mantenimiento.jsp
                        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/intranet-mantenimiento.jsp");
                        dispatcher.forward(request, response);
                    } else if (accion.equalsIgnoreCase("Recarga")) {//toma el nuevo valor de accion, dado despues de eliminar un usuario
                        //instancia
                        UsuarioAdm usuAdm = new UsuarioAdm();
                        //lista
                        ArrayList alUsuarios = usuAdm.getListaUsuarios();
                        request.setAttribute("alUsuarios", alUsuarios);
                        //envia nuevamente 
                        request.getRequestDispatcher("jsp/intranet-mantenimiento.jsp").forward(request, response);
                    } else if (accion.equalsIgnoreCase("goRegistrar")) {//llamado desde intranet-mantenimiento.jsp, boton REGISTRAR NUEVO
                        UsuarioAdm usuAdm = new UsuarioAdm();

                        ArrayList alUsuarios = usuAdm.getListaUsuarios();
                        request.setAttribute("alUsuarios", alUsuarios);
                        //envia a intranet-insertar
                        request.getRequestDispatcher("jsp/intranet-insertar.jsp").forward(request, response);
                    }
                    break;
                default://en caso se intente acceder sin haberse logeado
                    RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/mensaje.jsp");
            }
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/mensaje.jsp");
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
