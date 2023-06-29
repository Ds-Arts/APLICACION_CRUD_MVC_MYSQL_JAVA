package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NequiDao {
    Connection con; 
    PreparedStatement ps;
    ResultSet rs; // almacenar consutas
    String sql=null;
    int r; //cantidad de filas que devuelve una sentencia

    public List<NequiVo> listar(int IdUsuario) throws SQLException{
        List<NequiVo> nequi=new ArrayList<>();
        sql="SELECT saldo from Nequi WHERE IdUsuario = ?";
        try {
            
            con=conexion.conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1,IdUsuario );
            rs = ps.executeQuery();
            while(rs.next()){
                NequiVo l=new NequiVo();
                //Escribir  en el setter cada valor encontrado

                l.setSaldo(rs.getInt("saldo"));
                System.out.println(l.getSaldo());
                nequi.add(l);

                System.out.println(nequi);
            }
            ps.close();
            System.out.println("consulta exitosa");
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutado "+e.getMessage().toString());
        }
        finally{
            if (con != null) {
            con.close();
        }

        }

        return nequi;
    }

    public int recargar(NequiVo nequi) throws SQLException{
        sql="UPDATE Nequi SET saldo=(?) WHERE IdUsuario=(?)";

        try{
        con=conexion.conectar(); //abrir conexión  
        ps=con.prepareStatement(sql); //preparar sentencia
        ps.setInt(1, nequi.getValorRecarga());
        ps.setInt(2, nequi.getIdUsuario()); // establecer el ID para la cláusula WHERE
            System.out.println(nequi.getSaldo());

            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia.
            ps.close(); //cerrar sentencia.
            System.out.println("Se actualizó el registro del usuario correctamente, revisa la base de datos.");

        }catch(Exception e){

            System.out.println("UsuarioDao dice: Error en la actualizacion del registro "+e.getMessage().toString());

        }
        finally{
            con.close();//cerrando conexión
        }
        return r;
    }
        public int retirar(NequiVo nequi) throws SQLException{
        sql="UPDATE Nequi SET saldo=(?) WHERE IdUsuario=(?)";

        try{
        con=conexion.conectar(); //abrir conexión  
        ps=con.prepareStatement(sql); //preparar sentencia
        ps.setInt(1, nequi.getValorRetiro());
        ps.setInt(2, nequi.getIdUsuario()); // establecer el ID para la cláusula WHERE
            System.out.println(nequi.getSaldo());

            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia.
            ps.close(); //cerrar sentencia.
            System.out.println("Se actualizó el registro del usuario correctamente, revisa la base de datos.");

        }catch(Exception e){

            System.out.println("UsuarioDao dice: Error en la actualizacion del registro "+e.getMessage().toString());

        }
        finally{
            con.close();//cerrando conexión
        }
        return r;
    }
}
