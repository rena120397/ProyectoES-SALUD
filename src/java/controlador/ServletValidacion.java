package controlador;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import procesos.icitas;
import modelo.login;
import modelo.perfil;
import procesos.usuariocitas;
public class ServletValidacion extends HttpServlet {

        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id=request.getParameter("dni");
        String pass=request.getParameter("password");
        perfil per=null;
        login lo=new login();
        icitas ic=new usuariocitas();
        
        lo.setDni(id);
        lo.setPass(pass);
        
        per=ic.validacion(lo);
        if(per!=null)
        {
            HttpSession session = request.getSession(true);
            session.setAttribute("perse",per);
            response.sendRedirect("servletsalud");
        }
        else
        {
            request.setAttribute("mensaje","<i class=\"fa fa-times\"> </i> Usuario no registrado");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
