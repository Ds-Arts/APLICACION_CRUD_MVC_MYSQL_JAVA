package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {

    Connection con; 
    PreparedStatement ps;
    ResultSet rs; // almacenar consutas
    String sql=null;
    int r; //cantidad de filas que devuelve una sentencia

    public int crear(UsuarioVo usuario) throws SQLException{
        sql="INSERT INTO Usuario(usu_nombre,usu_contrasena,usu_telefono,usu_direccion,usu_email,usu_estado) values(?,?,?,?,?,?)";
        try{
            con=conexion.conectar(); //abrir conexión
            ps=con.prepareStatement(sql); //preparar sentencia
            
            System.out.println("entro al registro");
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getContrasena());
            ps.setInt(3, usuario.getTelefono());
            ps.setString(4, usuario.getDireccion());
            ps.setString(5, usuario.getEmail());
            ps.setBoolean(6, usuario.getEstado());
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //cerrar sentencia
            System.out.println("Se registró el usuario correctamente");
        }catch(Exception e){

        }finally{
            con.close();//cerrando conexión
        }
        return r;
    }
    
    public List<UsuarioVo> listar() throws SQLException{
        List<UsuarioVo> usuario=new ArrayList<>();
        sql="SELECT *from Usuario";
        try {
            con=conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            while(rs.next()){
                UsuarioVo l=new UsuarioVo();
                //Escribir  en el setter cada valor encontrado
                l.setIdUsuario(rs.getInt("usu_id"));
                l.setNombre(rs.getString("usu_nombre"));
                l.setContrasena( rs.getString("usu_contrasena"));
                l.setTelefono(rs.getInt("usu_telefono"));
                l.setDireccion(rs.getString("usu_direccion"));
                l.setEmail(rs.getString("usu_email"));
                l.setEstado(rs.getBoolean("usu_estado"));
                usuario.add(l);
                System.out.println(l.getTelefono());
                System.out.println(l.getEmail());
                System.out.println(usuario);
            }
            ps.close();
            System.out.println("consulta exitosa");
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutado "+e.getMessage().toString());
        }
        finally{
            con.close();
        }

        return usuario;
    }


    public int modificar(UsuarioVo usuario) throws SQLException{
        sql="UPDATE Usuario SET usu_nombre=(?),usu_contrasena=(?),usu_telefono=(?),usu_direccion=(?),usu_email=(?),usu_estado=(?) WHERE usu_id=(?)";

        try{
        con=conexion.conectar(); //abrir conexión  
        ps=con.prepareStatement(sql); //preparar sentencia
        ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getContrasena());
            ps.setInt(3, usuario.getTelefono());
            ps.setString(4, usuario.getDireccion());
            ps.setString(5, usuario.getEmail());
            ps.setBoolean(6, usuario.getEstado());
            ps.setInt(7, usuario.getIdUsuario()); // establecer el ID para la cláusula WHERE

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
    /* 
    public int modificar(UsuarioVo usuario) throws SQLException{ 

        sql="UPDATE Usuario SET usu_nombre='"+usuario.getNombre() + "',usu_contrasena='"+usuario.getContrasena() + "',usu_telefono="+usuario.getTelefono() + ",usu_direccion='"+usuario.getNombre() + "',usu_email='"+usuario.getEmail() + "',usu_estado='"+usuario.getEstado() + "' WHERE usu_id="+usuario.getIdUsuario(); 
        
                try{ 
        
                con=conexion.conectar(); //abrir conexión   
        
                ps=con.prepareStatement(sql); //preparar sentencia 
        
                 
        
                System.out.println("entro al modificar"); 
        
                // ps.setString(1, usuario.getNombre()); 
        
                // ps.setString(2, usuario.getContrasena()); 
        
                // ps.setInt(3, usuario.getTelefono()); 
        
                // ps.setString(4, usuario.getDireccion()); 
        
                // ps.setString(5, usuario.getEmail()); 
        
                // ps.setBoolean(6, usuario.getEstado()); 
        
                // ps.setInt(7, usuario.getIdUsuario()); // establecer el ID para la cláusula WHERE 
        
                System.out.println(ps); 
        
                ps.executeUpdate(); //Ejecutar sentencia 
        
                ps.close(); //cerrar sentencia 
        
                System.out.println("Se modifico el usuario correctamente");  
        
                }catch (Exception e) { 
        
                    System.out.println("No pudo ser ejecutado la modificacion"+e.getMessage().toString()); 
        
                }finally{ 
        
                    con.close(); 
        
                } 
        
                return r; 
        
            } 
            */


public UsuarioVo obtenerUsuario(String nombre, String contrasena) throws SQLException {
    sql = "SELECT * FROM Usuario WHERE usu_nombre = ? AND usu_contrasena = ?";
    UsuarioVo usuario = null;
    System.out.println("entro al inicio");
    try(Connection con = conexion.conectar();
        PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, nombre);
        ps.setString(2, contrasena);

        try(ResultSet rs = ps.executeQuery();){ if (rs.next()){ 
            usuario=new UsuarioVo();
            usuario.setIdUsuario(rs.getInt("usu_id"));
            usuario.setNombre(rs.getString("usu_nombre"));
            usuario.setContrasena(rs.getString("usu_contrasena"));
            // Asignar otras propiedades según corresponda
            
        }
    } catch (SQLException e) {
        System.out.println("Error al obtener el usuario: " + e.getMessage());
    } 

    return usuario;
}
}
}


