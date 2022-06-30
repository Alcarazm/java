package controller;
import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DisqueraDao;
import model.DisqueraVo;

public class Disquera extends HttpServlet {

    DisqueraDao ddao= new DisqueraDao(); 
    DisqueraVo r= new DisqueraVo();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       System.out.print("Ingreso al doGet");
       String accion = req.getParameter("accion");

        switch(accion){
            case "abrirForm":
            abrirForm(req,resp);
            break;
       
            case "listar":
            listar(req,resp);
            break;

            case "eliminar": 
            eliminar(req, resp); 
            break;

            case "cambiarEstado":
            cambiarEstado(req, resp);
            break;

            case "editar":
            editar(req, resp);
            break;
        }
          
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.print("Ingreso al doGet");
        String accion = req.getParameter("accion");

        switch(accion){
            case "addDisquera":
            addDisquera(req,resp);
            break;

            case "modificarDisquera":
            modificarDisquera(req, resp);
            break;
        }      
    }
        private void abrirForm(HttpServletRequest req, HttpServletResponse resp) {
            try{
                req.getRequestDispatcher("views/disquera/nuevadisquera.jsp").forward(req, resp);
                System.out.println("El formulario ha sido abierto");
            }catch(Exception e){
                System.out.println("El formulario no ha sido abierto"+e.getMessage().toString());
            }
        }

        private void addDisquera(HttpServletRequest req, HttpServletResponse resp) {
            DisqueraDao ddao=new DisqueraDao();
            DisqueraVo r=new DisqueraVo();
            if(req.getParameter("nit")!=null){
                r.setnitDisquera(req.getParameter("nit"));
            }
            if(req.getParameter("nombre")!=null){
                r.setnombreDisquera(req.getParameter("nombre"));
            }
            if(req.getParameter("telefono")!=null){
                r.settelefonoDisquera(req.getParameter("telefono"));
            }
            if(req.getParameter("direccion")!=null){
                r.setdireccionDisquera(req.getParameter("direccion"));
            }
            if(req.getParameter("chkestado")!=null){
                r.setestadoDisquera(true);
            }
            else{
                r.setestadoDisquera(false);
            }
            try {
                ddao.registrar(r);
                resp.sendRedirect("disquera?accion=listar");
                System.out.println("Registro insertado correctamente");
            } catch (Exception e) {
                req.setAttribute("No se pudo registrar la disquera"+e.getMessage(), e);
                System.out.println("Error en la inserción del registro "+e.getMessage().toString());
            }
        }

        private void listar(HttpServletRequest req, HttpServletResponse resp) {
            try {
                List disquera=ddao.listar();
                req.setAttribute("disqueras", disquera);
                req.getRequestDispatcher("views/disquera/disquera.jsp").forward(req, resp);
                System.out.println("Datos listados correctamente");
            } catch (Exception e) {
                System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
            }
        }

        private void eliminar(HttpServletRequest req, HttpServletResponse resp){
            if(req.getParameter("id" )!=null){
                r.setidDisquera(Integer.parseInt(req.getParameter("id")));
            }
        
        try {
            ddao.eliminarDisquera(r.getidDisquera());
            resp.sendRedirect("disquera?accion=listar");
            System.out.println("se elimino correctamente");

        } catch (Exception e) {
            req.setAttribute("msje","No se pudo eliminar la disquera"+e.getMessage());
            System.out.println("No se pudo eliminar la disquera"+e.getMessage());
        }finally{
            
        }
    }

    private void cambiarEstado(HttpServletRequest req, HttpServletResponse resp) {
        DisqueraDao ddao=new DisqueraDao();
        DisqueraVo r=new DisqueraVo();
        if (req.getParameter("idd")!=null) {
            r.setidDisquera(Integer.parseInt(req.getParameter("idd")));
        }
        System.out.println(req.getParameter("estado"));
        Boolean estado = Boolean.valueOf(req.getParameter("estado"));
        if (req.getParameter("estado") != null && estado) {
            r.setestadoDisquera( false);
        } else {
            r.setestadoDisquera( true);
        }
        try {
            ddao.cambiarEstado(r);
            resp.sendRedirect("disquera?accion=listar");
            System.out.println("Estado actualizado");

        } catch (Exception e) {
            req.setAttribute("msje", "No se pudo actualizar el estado de la disquera"+e.getMessage());
            System.out.println("No se pudo actualizar el estado de la disquera"+e.getMessage().toString());
        }
    }


    private void editar(HttpServletRequest req, HttpServletResponse resp) {
        DisqueraDao ddao=new DisqueraDao();
        DisqueraVo r=new DisqueraVo();
        if (req.getParameter("IDdisquera")!=null) {
            r.setidDisquera(Integer.parseInt(req.getParameter("IDdisquera")));
        }
        try {
            List<DisqueraVo> 
            disquera=ddao.listar();
            req.setAttribute("modificardisquera", disquera);
            req.getRequestDispatcher("views/disquera/disquera-edit.jsp").forward(req, resp);
            System.out.println("Se listo correctamente");
        } catch (Exception e) {
            System.out.println("Error al listar los datos"+e.getMessage().toString());
        }
    }

    private void modificarDisquera(HttpServletRequest req, HttpServletResponse resp){
        DisqueraDao ddao=new DisqueraDao();
        DisqueraVo r=new DisqueraVo();

        if (req.getParameter("IDD")!=null) {
            r.setidDisquera(Integer.parseInt(req.getParameter("IDD")));
        }
        if (req.getParameter("nitdisquera" )!=null) {
            r.setnitDisquera(req.getParameter("nitdisquera"));
        }
        if (req.getParameter("nombredisquera" )!=null) {
            r.setnombreDisquera(req.getParameter("nombredisquera"));
        }
        if (req.getParameter("telefonodisquera" )!=null) {
            r.settelefonoDisquera(req.getParameter("telefonodisquera"));
        }
        if (req.getParameter("direcciondisquera" )!=null) {
            r.setdireccionDisquera(req.getParameter("direcciondisquera"));
        }
        if (req.getParameter("estadodisquera" )!=null) {
            r.setestadoDisquera(true);
        }
        else{
            r.setestadoDisquera(false);
        }
        try {
            ddao.modificarDisquera(r);
            resp.sendRedirect("disquera?accion=listar");
            System.out.println("La disquera se ha actualizado correctamente");
        } catch (Exception e) {
            req.setAttribute("msje", "No se pudo modificar la disquera"+e.getMessage());
            System.out.println("Error al modificar disquera"+e.getMessage().toString());
        }
    }
    
}
