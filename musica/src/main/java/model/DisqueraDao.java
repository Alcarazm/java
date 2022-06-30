package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DisqueraDao {
    
    Connection con; //objeto de conexión
    PreparedStatement ps; //objeto para sentencias preparadas
    ResultSet rs; //objeto para almacenar consultas
    String sql=null; //variable para guardar sentencias
    int r;


    public List<DisqueraVo> listar() throws Exception{
        List<DisqueraVo> disqueras=new ArrayList<>();
        sql="SELECT * FROM Disquera";
        try {
            con=Conexion.conectar(); //abrir conexion
            ps=con.prepareStatement(sql); //preparar sentencia select
            rs=ps.executeQuery(); //ejecutamos las sentencia y guardamos los resultados
            while(rs.next()){
                DisqueraVo r=new DisqueraVo();
                
                r.setidDisquera(rs.getInt("idDisquera") );
                r.setnitDisquera(rs.getString("nitDisquera"));
                r.setnombreDisquera(rs.getString("nombreDisquera"));
                r.settelefonoDisquera(rs.getString("telefonoDisquera") );
                r.setdireccionDisquera(rs.getString("direccionDisquera"));
                r.setestadoDisquera(rs.getBoolean("estadoDisquera"));
                disqueras.add(r);
            }
            ps.close();
            System.out.print("Consulta exitosa");

        }catch (Exception e) {
            System.out.print("No hay disqueras definidas"+e.getMessage());
        }finally {
            con.close();
        }
        return disqueras;

    }

    public int registrar(DisqueraVo disquera) throws SQLException{
        sql="INSERT INTO Disquera(nitDisquera,nombreDisquera,telefonoDisquera,direccionDisquera,estadoDisquera) values(?,?,?,?,?)";
        try{
            con=Conexion.conectar(); 
            ps=con.prepareStatement(sql); 
            ps.setString(1, disquera.getnitDisquera());
            ps.setString(2, disquera.getnombreDisquera());
            ps.setString(3, disquera.gettelefonoDisquera());
            ps.setString(4, disquera.getdireccionDisquera());
            ps.setBoolean(5, disquera.getestadoDisquera());
            System.out.println(ps);
            ps.executeUpdate(); 
            ps.close(); 
            System.out.println("Se registró la disquera correctamente");
        }catch(Exception e){
            System.out.println("Error en el regisro "+e.getMessage().toString());
        }
        finally{
            con.close();
        }
        return r;
    }

    public void eliminarDisquera(int idDisquera)throws SQLException{
        sql="DELETE FROM disquera WHERE idDisquera="+ idDisquera;
    try {
        con=Conexion.conectar();
        ps=con.prepareStatement(sql);
        System.out.println(ps);
        ps.executeUpdate(sql);
        ps.close();
        System.out.println("Se elimino una disquera");
    } catch (Exception e) {
        System.out.println("Error al eliminar la disquera"+e);

       
    } finally{
        con.close();
    }
    }

    public int cambiarEstado(DisqueraVo disquera) throws SQLException{

        sql = "UPDATE disquera SET estadoDisquera = "+ (disquera.getestadoDisquera()== true ? "1" : "0")+ " WHERE idDisquera = " + disquera.getidDisquera();

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

    public int modificarDisquera(DisqueraVo disquera) throws SQLException{
        System.out.println("Entro al modificar");
        sql = "UPDATE disquera SET nitDisquera = '"+ disquera.getnitDisquera()+ "', nombreDisquera = '"+ disquera.getnombreDisquera()+ "', telefonoDisquera = '"+ disquera.gettelefonoDisquera()+ "', direccionDisquera = '"+ disquera.getdireccionDisquera()+
                    "', estadoDisquera = '"+ (disquera.getestadoDisquera()== true ? "1" : "0")+ "' WHERE idDisquera = '" + disquera.getidDisquera()+"'";
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
