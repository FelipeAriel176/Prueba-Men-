/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.Pais;
import conn.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaisDAO {
    private static final String SQL_SELECT_ALL = "SELECT p.*, c.nombreCiudad as nombre_capital FROM Pais p LEFT JOIN Ciudad c ON p.capital = c.idCiudad";
    private static final String SQL_SELECT_FILTER_NAME = "SELECT codigoPais, nombrePais, continentePais, region, poblacionPais, tipoGobierno, superficie, indepYear, esperanzaVida, gnp, jefeEstado, capital FROM Pais WHERE nombrePais LIKE ?";
    private static final String SQL_SELECT_FILTER_CONTINENT = "SELECT codigoPais, nombrePais, continentePais, region, poblacionPais, tipoGobierno, superficie, indepYear, esperanzaVida, gnp, jefeEstado, capital FROM Pais WHERE continentePais = ?";
    private static final String SQL_SELECT_BY_CODE = "SELECT codigoPais, nombrePais, continentePais, region, poblacionPais, tipoGobierno, superficie, indepYear, esperanzaVida, gnp, jefeEstado, capital FROM Pais WHERE codigoPais = ?";
    
    public ArrayList<Pais> listarPaises() {
        return ejecutarSelect(SQL_SELECT_ALL);
    }

    public ArrayList<Pais> listarPaisesFiltrados(String textoBuscado) {
        return ejecutarSelect(SQL_SELECT_FILTER_NAME, "%" + textoBuscado + "%");
    }
    
    public ArrayList<Pais> listarPaisesPorContinente(String continente) {
        return ejecutarSelect(SQL_SELECT_FILTER_CONTINENT, continente);
    }
    
    public Pais obtenerPaisPorCodigo(String codigo) {
        ArrayList<Pais> resultado = ejecutarSelect(SQL_SELECT_BY_CODE, String.valueOf(codigo));
        return resultado.isEmpty() ? null : resultado.get(0);
        }

     private ArrayList<Pais> ejecutarSelect(String sql, String... params) {
        ArrayList<Pais> lista = new ArrayList<>();
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
                String codigo = rs.getString("codigoPais");    
                String nombre = rs.getString("nombrePais");
                String continente = rs.getString("continentePais");
                int poblacion = rs.getInt("poblacionPais");
                String gobierno = rs.getString("tipoGobierno");
                float superficie = rs.getFloat("superficie");
                float esperanza = rs.getFloat("esperanzaVida");
                String region = rs.getString("region");
                int indepYear = rs.getInt("indepYear");
                float gnp = rs.getFloat("gnp"); 
                String jefe = rs.getString("jefeEstado"); 
                int capital = rs.getInt("capital");
                
                lista.add(new Pais(codigo, nombre, continente, poblacion, gobierno, superficie, esperanza, region, indepYear, gnp, jefe, capital));
                 }
        } catch (SQLException e) {
                System.err.println("Error de Select en País: " + e.getMessage());
                throw new RuntimeException("Error al ejecutar select en PaisDAO: " + e.getMessage(), e);
        } finally {
                try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar recursos en País: " + e.getMessage());
                }
        }
        return lista;
        }
      }
