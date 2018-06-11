package controlador;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.cita;
import modelo.perfil;
import procesos.icitas;
import procesos.usuariocitas;

public class servletsalud extends HttpServlet {
    icitas ic=new usuariocitas();
    ArrayList listacita = null;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            HttpSession session = request.getSession(true);
            perfil per=(perfil)session.getAttribute("perse");
            
            if(per==null)
            {
                session.invalidate();
                response.sendRedirect("index.jsp");
            }
            else
            {
                String tipo=request.getParameter("eleccion");
                if (tipo == null)
                {tipo="";}
                
                    if(tipo.equalsIgnoreCase("u1"))
                    {
                        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/usuario-perfil.jsp");
                        dispatcher.forward(request, response);
                    }
                    else if(tipo.equalsIgnoreCase("u2"))
                    {
                        int count=ic.valida_replica(per);
                        if(count==0)
                        {
                            listacita = ic.listarcitas();
                            request.setAttribute("listacita", listacita);
                            request.setAttribute("count",count);
                            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/usuario-citas.jsp");
                            dispatcher.forward(request, response);
                        }
                        else
                        {
                            request.setAttribute("count",count);
                            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/usuario-citas.jsp");
                            dispatcher.forward(request, response);
                        }
                    }        
                    else if(tipo.equalsIgnoreCase("u3"))
                    {
                        ArrayList listadoctor = ic.listarDoctores();
                        request.setAttribute("listadoctor", listadoctor);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/usuario-doctores.jsp");  
                        dispatcher.forward(request, response);
                    }
                    else if(tipo.equalsIgnoreCase("u4"))
                    {
                        ArrayList listahistorial = ic.listarhistorial(per);
                        request.setAttribute("listahistorial",listahistorial); 
                        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/usuario-historialcitas.jsp");  
                        dispatcher.forward(request, response);
                    }
                    else
                    {
                        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/usuario.jsp");
                        dispatcher.forward(request, response);
                    }
            }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(true);
        perfil per=(perfil)session.getAttribute("perse");
            
        String pc=request.getParameter("procesarcita");
        String rc=request.getParameter("rc");
                
        if (pc == null)
        {pc="";}
        
        if(pc.equalsIgnoreCase("procesarcita"))
        {
            cita ci=new cita();
            ci.setIdmedico(rc);
            ci.setNdocum(per.getNdocum());
            ic.procita(ci);
            ic.disminuircupo(rc);
            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/usuario.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
