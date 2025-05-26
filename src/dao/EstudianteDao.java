package dao;

import data.ConexionWorkbenchDB;
import model.EstudianteModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EstudianteDao {
    public static String mensaje = "";
    
    public static boolean guardar(EstudianteModel e) {
        try {
            String sql = "INSERT INTO estudiantes(nombre, apellido, direccion, telefono, estrato) VALUES(?, ?, ?, ?, ?)";
            Connection con = ConexionWorkbenchDB.Conectar();
            PreparedStatement sentencia = con.prepareStatement(sql);
            sentencia.setString(1, e.getNombre());
            sentencia.setString(2, e.getApellido());
            sentencia.setString(3, e.getDireccion());
            sentencia.setString(4, e.getTelefono());
            sentencia.setInt(5, e.getEstrato());
            int filas = sentencia.executeUpdate();
            
            if(filas > 0) {
                mensaje = "Estudiante guardado con exito!";
                return true;
            }
            mensaje = "No se logro guardar el estudiante.";
            return false;
        } catch(Exception ex) {
            mensaje = ex.getMessage();
            return false;
        }
    }
    
    public static ResultSet listar() {
        try {
            String sql = "SELECT * FROM estudiantes";
            Connection con = ConexionWorkbenchDB.Conectar();
            PreparedStatement sentencia = con.prepareStatement(sql);

            ResultSet datos = sentencia.executeQuery();
            
            return datos;
        } catch(Exception ex) {
            mensaje = ex.getMessage();
            return null;
        }
    }
    
    public static EstudianteModel consultar(int codigoEstudiante) {
        try {
            String sql = "SELECT * FROM estudiantes WHERE codigo=?";
            Connection con = ConexionWorkbenchDB.Conectar();
            PreparedStatement sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, codigoEstudiante);
            ResultSet datos = sentencia.executeQuery();
            
            if(datos.next()) {
                EstudianteModel est = new EstudianteModel();
                est.setCodigo(datos.getInt("codigo"));
                est.setNombre(datos.getString("nombre"));
                est.setApellido(datos.getString("apellido"));
                est.setDireccion(datos.getString("direccion"));
                est.setTelefono(datos.getString("telefono"));
                est.setEstrato(datos.getInt("estrato"));
                
                return est;
            }
            return null;
        } catch(Exception ex) {
            mensaje = ex.getMessage();
            return null;
        }
    }
    
    public static boolean actualizar(EstudianteModel e) {
        try {
            String sql = "UPDATE estudiantes SET nombre=?, apellido=?, direccion=?, telefono=?, estrato=? WHERE codigo = ?";
            Connection con = ConexionWorkbenchDB.Conectar();
            PreparedStatement sentencia = con.prepareStatement(sql);
            sentencia.setString(1, e.getNombre());
            sentencia.setString(2, e.getApellido());
            sentencia.setString(3, e.getDireccion());
            sentencia.setString(4, e.getTelefono());
            sentencia.setInt(5, e.getEstrato());
            sentencia.setInt(6, e.getCodigo());
            int filas = sentencia.executeUpdate();
            
            if(filas > 0) {
                mensaje = "Estudiante actualizado/a con exito!";
                return true;
            }
            mensaje = "No se logro actualizar al/la estudiante.";
            return false;
        } catch(Exception ex) {
            mensaje = ex.getMessage();
            return false;
        }
    }
    
    public static boolean eliminar(int codigo) {
        try {
            String sql = "DELETE FROM estudiantes WHERE codigo = ?";
            Connection con = ConexionWorkbenchDB.Conectar();
            PreparedStatement sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, codigo);
            int filas = sentencia.executeUpdate();
            
            if(filas > 0) {
                mensaje = "Estudiante eliminado/a con exito!";
                return true;
            }
            mensaje = "No se logro eliminar al/la estudiante.";
            return false;
        } catch(Exception ex) {
            mensaje = ex.getMessage();
            return false;
        }
    }
}
