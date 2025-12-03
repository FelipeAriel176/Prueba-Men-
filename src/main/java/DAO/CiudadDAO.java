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
    private static final String SQL_SELECT_FILTER_NAME = "SELECT nombreCiudad, distritoCiudad, poblacionCiudad, codigoPais FROM Ciudad WHERE nombreCiudad LIKE ?";
    private static final String SQL_SELECT_TOP_CITIES = "SELECT nombreCiudad, distritoCiudad, poblacionCiudad, codigoPais FROM Ciudad ORDER BY poblacionCiudad DESC";    
    private static final String SQL_SELECT_ALL = "SELECT nombreCiudad, distritoCiudad, poblacionCiudad, codigoPais FROM Ciudad";
    private static final String SQL_SELECT_BY_COUNTRY = "SELECT nombreCiudad, distritoCiudad, poblacionCiudad, codigoPais FROM Ciudad WHERE codigoPais = ?";
    
    public ArrayList<Ciudad> listarCiudadesFiltradas(String textoBuscado) {
    return ejecutarSelect(SQL_SELECT_FILTER_NAME, "%" + textoBuscado + "%");
    }
    
    public ArrayList<Ciudad> listarTopCiudades() {
    return ejecutarSelect(SQL_SELECT_TOP_CITIES);
    }
    
    public ArrayList<Ciudad> listarCiudades(String paisCodigo) {
    return ejecutarSelect(SQL_SELECT_BY_COUNTRY, String.valueOf(paisCodigo));        
    }
    
    public ArrayList<Ciudad> listarCiudades() {
    return ejecutarSelect(SQL_SELECT_ALL);
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
                String nombre = rs.getString("nombreCiudad");
                String distrito = rs.getString("distritoCiudad");
                int poblacion = rs.getInt("poblacionCiudad");
                String paisCodigoStr = rs.getString("codigoPais");                
                Pais pais = new Pais(paisCodigoStr);
                lista.add(new Ciudad(nombre, distrito, poblacion, pais));
                }
        } 
        catch (SQLException e) {
            System.err.println("Error de Select en ciudad: " + e.getMessage());
        throw new RuntimeException("Error al ejecutar select: " + e.getMessage(), e);
        } finally {
                try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                } 
                catch (SQLException e) {
                System.err.println("Error al cerrar recursos en Ciudad: " + e.getMessage());
                }
        }
        return lista;
        }
        }
