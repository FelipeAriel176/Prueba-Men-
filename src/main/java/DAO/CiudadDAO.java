/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Ciudad;
import Modelo.Pais;
import conn.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CiudadDAO {
    
    private final PaisDAO paisDAO = new PaisDAO(); 
    private static final String SQL_SELECT_ALL = "SELECT Nombre, Distrito, Poblacion, PaisCodigo FROM Ciudad";
    private static final String SQL_SELECT_BY_COUNTRY = "SELECT Nombre, Distrito, Poblacion, PaisCodigo FROM Ciudad WHERE PaisCodigo = ?";
    private static final String SQL_INSERT = "INSERT INTO Ciudad (Nombre, Distrito, Poblacion, PaisCodigo) VALUES (?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE Ciudad SET Nombre = ?, Distrito = ?, Poblacion = ?, PaisCodigo = ? WHERE Nombre = ? AND PaisCodigo = ?";
    private static final String SQL_DELETE = "DELETE FROM Ciudad WHERE Nombre = ? AND PaisCodigo = ?";
   
    public ArrayList<Ciudad> listarCiudades(int paisCodigo) {
    return ejecutarSelect(SQL_SELECT_BY_COUNTRY, String.valueOf(paisCodigo));
        }
    public ArrayList<Ciudad> listarCiudades() {
    return ejecutarSelect(SQL_SELECT_ALL);
}

    public boolean agregarCiudad(Ciudad ciudad) {
        return ejecutarUpdate(SQL_INSERT, 
                ciudad.getNombre(),
                ciudad.getDistrito(),
                String.valueOf(ciudad.getPoblacion()),
                String.valueOf(ciudad.getPais().getCodigo()));
        }

    public boolean modificarCiudad(Ciudad ciudadOriginal, Ciudad ciudadNueva) {
        return ejecutarUpdate(SQL_UPDATE, 
            ciudadNueva.getNombre(), 
            ciudadNueva.getDistrito(), 
            String.valueOf(ciudadNueva.getPoblacion()), 
            String.valueOf(ciudadNueva.getPais().getCodigo()), 
            ciudadOriginal.getNombre(), 
            String.valueOf(ciudadOriginal.getPais().getCodigo())); 
    }

    public boolean eliminarCiudad(String nombre, int paisCodigo) {
        return ejecutarUpdate(SQL_DELETE, nombre, String.valueOf(paisCodigo));
    }
        
    private ArrayList<Ciudad> ejecutarSelect(String sql, String... params) {
        ArrayList<Ciudad> lista = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
                conn = Conexion.getInstancia();
                ps = conn.prepareStatement(sql);
                for (int i = 0; i < params.length; i++) {
                ps.setString(i + 1, params[i]);
                }
                rs = ps.executeQuery();

               while (rs.next()) {
                String nombre = rs.getString("Nombre");
                String distrito = rs.getString("Distrito");
                int poblacion = rs.getInt("Poblacion");
                int paisCodigo = rs.getInt("PaisCodigo");
                
                Pais pais = paisDAO.obtenerPaisPorCodigo(paisCodigo);
                
                if (pais != null) {
                    lista.add(new Ciudad(nombre, distrito, poblacion, pais));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error de Select en Ciudad: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar recursos en Ciudad: " + e.getMessage());
            }
        }
        return lista;
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
            System.err.println("Error de Update en Ciudad: " + e.getMessage());
            return false;
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar recursos en Ciudad: " + e.getMessage());
            }
        }
    }
}
