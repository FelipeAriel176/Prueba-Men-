/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Usuario;
import conn.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAO {

    private static final String SQL_LOGIN = "SELECT NombreUsuario FROM Usuario WHERE NombreUsuario = ? AND Contrasena = ?";
    private static final String SQL_SELECT_ALL = "SELECT NombreUsuario, Contrasena FROM Usuario";
    private static final String SQL_INSERT = "INSERT INTO Usuario (NombreUsuario, Contrasena) VALUES (?, ?)";
    private static final String SQL_UPDATE = "UPDATE Usuario SET Contrasena = ? WHERE NombreUsuario = ?";
    private static final String SQL_DELETE = "DELETE FROM Usuario WHERE NombreUsuario = ?";

    public Usuario login(String nombre, String pass) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getInstancia();
            ps = conn.prepareStatement(SQL_LOGIN);
            ps.setString(1, nombre);
            ps.setString(2, pass);
            rs = ps.executeQuery();

            if (rs.next()) {
                return new Usuario(rs.getString("NombreUsuario"), pass);
            }
        } catch (SQLException e) {
            System.err.println("Error de Login: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                 System.err.println("Error al cerrar recursos en Login: " + e.getMessage());
            }
        }
        return null; 
    }
    // ----------------------------------------------------
    // READ: Listar todos los usuarios (para VistaUsuario)
    // ----------------------------------------------------
    public ArrayList<Usuario> listarUsuarios() {
        ArrayList<Usuario> lista = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            conn = Conexion.getInstancia();
            ps = conn.prepareStatement(SQL_SELECT_ALL);
            rs = ps.executeQuery();

            while (rs.next()) {
                String nombreUsuario = rs.getString("NombreUsuario");
                String contrasena = rs.getString("Contrasena");
                lista.add(new Usuario(nombreUsuario, contrasena));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar usuarios: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar recursos en listarUsuarios: " + e.getMessage());
            }
        }
        return lista;
    }

    // ----------------------------------------------------
    // CREATE: Agregar un nuevo usuario (para Registro/Admin)
    // ----------------------------------------------------
    public boolean agregarUsuario(Usuario usuario) {
        return ejecutarUpdate(SQL_INSERT, 
            usuario.getNombreUsuario(), 
            usuario.getContraseña());
    }

    // ----------------------------------------------------
    // UPDATE: Modificar la contraseña de un usuario
    // ----------------------------------------------------
    public boolean modificarUsuario(Usuario usuario) {
        // En el UPDATE la contraseña es el primer parámetro y el nombre de usuario (WHERE) es el segundo
        return ejecutarUpdate(SQL_UPDATE, 
            usuario.getContraseña(), 
            usuario.getNombreUsuario());
    }

    // ----------------------------------------------------
    // DELETE: Eliminar un usuario
    // ----------------------------------------------------
    public boolean eliminarUsuario(String nombreUsuario) {
        return ejecutarUpdate(SQL_DELETE, nombreUsuario);
    }
    
    private boolean ejecutarUpdate(String sql, String... params) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = Conexion.getInstancia();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                ps.setString(i + 1, params[i]);
            }
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error de operación SQL: " + e.getMessage());
            return false;
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
    }
}