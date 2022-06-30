package controller;
import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GeneroDao;
import model.GeneroVo;

public class Genero extends HttpServlet {

    GeneroDao gdao= new GeneroDao(); 
    GeneroVo r= new GeneroVo();

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
            case "addGenero":
            addGenero(req,resp);
            break;

            case "modificarGenero":
            modificarGenero(req, resp);
            break;
        }      
    }
        private void abrirForm(HttpServletRequest req, HttpServletResponse resp) {
            try{
                req.getRequestDispatcher("views/genero/nuevogenero.jsp").forward(req, resp);
                System.out.println("El formulario ha sido abierto");
            }catch(Exception e){
                System.out.println("El formulario no ha sido abierto"+e.getMessage().toString());
            }
        }

        private void addGenero(HttpServletRequest req, HttpServletResponse resp) {
            GeneroDao gdao=new GeneroDao();
            GeneroVo r=new GeneroVo();
            if(req.getParameter("nombre")!=null){
                r.setnombreGenero(req.getParameter("nombre"));
            }
            if(req.getParameter("chkestado")!=null){
                r.setestadoGenero(true);
            }
            else{
                r.setestadoGenero(false);
            }
            try {
                gdao.registrar(r);
                resp.sendRedirect("genero?accion=listar");
                System.out.println("Registro insertado correctamente");
            } catch (Exception e) {
                req.setAttribute("No se pudo registrar el genero"+e.getMessage(), e);
                System.out.println("Error en la inserción del registro "+e.getMessage().toString());
            }
        }

        private void listar(HttpServletRequest req, HttpServletResponse resp) {
            try {
                List genero=gdao.listar();
                req.setAttribute("generos", genero);
                req.getRequestDispatcher("views/genero/genero.jsp").forward(req, resp);
                System.out.println("Datos listados correctamente");
            } catch (Exception e) {
                System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
            }
        }

        private void eliminar(HttpServletRequest req, HttpServletResponse resp){
            if(req.getParameter("id" )!=null){
                r.setidgenero(Integer.parseInt(req.getParameter("id")));
            }
        
        try {
            gdao.eliminarGenero(r.getidGenero());
            resp.sendRedirect("genero?accion=listar");
            System.out.println("se elimino correctamente");

        } catch (Exception e) {
            req.setAttribute("msje","No se pudo eliminar el genero"+e.getMessage());
            System.out.println("No se pudo eliminar el genero"+e.getMessage());
        }finally{
            
        }
    }

    private void cambiarEstado(HttpServletRequest req, HttpServletResponse resp) {
        GeneroDao gdao=new GeneroDao();
        GeneroVo r=new GeneroVo();
        if (req.getParameter("idg")!=null) {
            r.setidgenero(Integer.parseInt(req.getParameter("idg")));
        }
        System.out.println(req.getParameter("estado"));
        Boolean estado = Boolean.valueOf(req.getParameter("estado"));
        if (req.getParameter("estado") != null && estado) {
            r.setestadoGenero( false);
        } else {
            r.setestadoGenero( true);
        }
        try {
            gdao.cambiarEstado(r);
            resp.sendRedirect("genero?accion=listar");
            System.out.println("Estado actualizado");

        } catch (Exception e) {
            req.setAttribute("msje", "No se pudo actualizar el estado del genero"+e.getMessage());
            System.out.println("No se pudo actualizar el estado del genero"+e.getMessage().toString());
        }
    }


    private void editar(HttpServletRequest req, HttpServletResponse resp) {
        GeneroDao gdao=new GeneroDao();
        GeneroVo r=new GeneroVo();
        if (req.getParameter("IDgenero")!=null) {
            r.setidgenero(Integer.parseInt(req.getParameter("IDgenero")));
        }
        try {
            List<GeneroVo> 
            genero=gdao.listar();
            req.setAttribute("modificargenero", genero);
            req.getRequestDispatcher("views/genero/genero-edit.jsp").forward(req, resp);
            System.out.println("Se listo correctamente");
        } catch (Exception e) {
            System.out.println("Error al listar los datos"+e.getMessage().toString());
        }
    }

    private void modificarGenero(HttpServletRequest req, HttpServletResponse resp){
        GeneroDao gdao=new GeneroDao();
        GeneroVo r=new GeneroVo();

        if (req.getParameter("IDG")!=null) {
            r.setidgenero(Integer.parseInt(req.getParameter("IDG")));
        }
        if (req.getParameter("nombregenero" )!=null) {
            r.setnombreGenero(req.getParameter("nombregenero"));
        }
        if (req.getParameter("estadogenero" )!=null) {
            r.setestadoGenero(true);
        }
        else{
            r.setestadoGenero(false);
        }
        try {
            gdao.modificarGenero(r);
            resp.sendRedirect("genero?accion=listar");
            System.out.println("El genero se ha actualizado correctamente");
        } catch (Exception e) {
            req.setAttribute("msje", "No se pudo modificar el genero"+e.getMessage());
            System.out.println("Error al modificar genero"+e.getMessage().toString());
        }
    }

        
        
}

   

    

    

