package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GeneroDao {

    Connection con; //objeto de conexión
    PreparedStatement ps; //objeto para sentencias preparadas
    ResultSet rs; //objeto para almacenar consultas
    String sql=null; //variable para guardar sentencias
    int r;


    public List<GeneroVo> listar() throws Exception{
        List<GeneroVo> generos=new ArrayList<>();
        sql="SELECT * FROM Genero";
        try {
            con=Conexion.conectar(); //abrir conexion
            ps=con.prepareStatement(sql); //preparar sentencia select
            rs=ps.executeQuery(); //ejecutamos las sentencia y guardamos los resultados
            while(rs.next()){
                GeneroVo r=new GeneroVo();
                
                r.setidgenero(rs.getInt("idGenero") );
                r.setnombreGenero(rs.getString("nombreGenero"));
                r.setestadoGenero(rs.getBoolean("estadoGenero"));
                generos.add(r);
            }
            ps.close();
            System.out.print("Consulta exitosa");

        }catch (Exception e) {
            System.out.print("No hay generos definidos"+e.getMessage());
        }finally {
            con.close();
        }
        return generos;

    }

    public int registrar(GeneroVo genero) throws SQLException{
        sql="INSERT INTO Genero(nombreGenero,estadoGenero) values(?,?)";
        try{
            con=Conexion.conectar(); 
            ps=con.prepareStatement(sql); 
            ps.setString(1, genero.getnombreGenero());
            ps.setBoolean(2, genero.getestadoGenero());
            System.out.println(ps);
            ps.executeUpdate(); 
            ps.close(); 
            System.out.println("Se registró el genero correctamente");
        }catch(Exception e){
            System.out.println("Error en el regisro "+e.getMessage().toString());
        }
        finally{
            con.close();
        }
        return r;
    }

    public void eliminarGenero(int idGenero)throws SQLException{
        sql="DELETE FROM genero WHERE idGenero="+ idGenero;
    try {
        con=Conexion.conectar();
        ps=con.prepareStatement(sql);
        System.out.println(ps);
        ps.executeUpdate(sql);
        ps.close();
        System.out.println("Se elimino un genero");
    } catch (Exception e) {
        System.out.println("Error al eliminar un genero"+e);

       
    } finally{
        con.close();
    }
    }

    public int cambiarEstado(GeneroVo genero) throws SQLException{

        sql = "UPDATE genero SET estadoGenero = "+ (genero.getestadoGenero()== true ? "1" : "0")+ " WHERE idGenero = " + genero.getidGenero();

        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            System.out.println("Actualizar estado");
            System.out.println(ps);
            ps.executeUpdate();
            ps.close();

            System.out.println("Estado se ha actualizado");

        } catch (Exception e) {
            System.out.println("No se pudo cambiar el estado"+e.getMessage().toString());
        }finally{

            con.close();
        }
        return r;
    }

    public int modificarGenero(GeneroVo genero) throws SQLException{
        System.out.println("Entro al modificar");
        sql = "UPDATE genero SET nombreGenero = '"+ genero.getnombreGenero()+ "', estadoGenero = '"+ (genero.getestadoGenero()== true ? "1" : "0")+ "' WHERE idGenero = '" + genero.getidGenero()+"'";
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            System.out.println("Modificar datos");
            System.out.println(ps);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al modificar "+e.getMessage().toString());
        }finally{
            con.close();
        }
        return r; 
    }
}
