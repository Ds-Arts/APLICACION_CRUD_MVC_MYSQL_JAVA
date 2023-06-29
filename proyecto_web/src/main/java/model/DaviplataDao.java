package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class DaviplataDao {
    Connection con; 
    PreparedStatement ps;
    ResultSet rs; // almacenar consutas
    String sql=null;
    int r; //cantidad de filas que devuelve una sentencia
    public List<DaviplataVo> listar(int IdUsuario) throws SQLException{
        List<DaviplataVo> daviplata=new ArrayList<>();
        sql="SELECT saldo from Daviplata WHERE IdUsuario = ?";
        try {
            
            con=conexion.conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1,IdUsuario );
            rs = ps.executeQuery();
            while(rs.next()){
                DaviplataVo l=new DaviplataVo();
                //Escribir  en el setter cada valor encontrado

                l.setSaldo(rs.getInt("saldo"));
                System.out.println(l.getSaldo());
                daviplata.add(l);

                System.out.println();
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

        return daviplata;
    }


        public int recargar(DaviplataVo dv) throws SQLException{
        sql="UPDATE Daviplata SET saldo=(?) WHERE IdUsuario=(?)";

        try{
        con=conexion.conectar(); //abrir conexión  
        ps=con.prepareStatement(sql); //preparar sentencia
        ps.setInt(1, dv.getValorRecarga());
        ps.setInt(2, dv.getIdUsuario()); // establecer el ID para la cláusula WHERE
            System.out.println(dv.getSaldo());

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


        public int retirar(DaviplataVo dv) throws SQLException{
        sql="UPDATE Nequi SET saldo=(?) WHERE IdUsuario=(?)";

        try{
        con=conexion.conectar(); //abrir conexión  
        ps=con.prepareStatement(sql); //preparar sentencia
        ps.setInt(1, dv.getValorRetiro());
        ps.setInt(2, dv.getIdUsuario()); // establecer el ID para la cláusula WHERE
            System.out.println(dv.getSaldo());

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
