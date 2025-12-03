/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.IdiomaPais;
import Modelo.Pais;
import conn.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class IdiomaDAO {
    private static final String SQL_SELECT_ALL = "SELECT nombreIdioma, oficial, porcentaje, codigoPais FROM Idioma";
    private static final String SQL_SELECT_BY_COUNTRY = "SELECT nombreIdioma, oficial, porcentaje, codigoPais FROM Idioma WHERE codigoPais = ?";
    private static final String SQL_RANKING = "SELECT nombreIdioma, oficial, porcentaje, codigoPais FROM Idioma ORDER BY porcentaje DESC";
    
    public ArrayList<IdiomaPais> listarIdiomas() {
    return ejecutarSelect(SQL_SELECT_ALL);
    }
    
    public ArrayList<IdiomaPais> listarIdiomasPorPais(String paisCodigo) {
        return ejecutarSelect(SQL_SELECT_BY_COUNTRY, paisCodigo);
    }

    public ArrayList<IdiomaPais> listarIdiomasRanking() {
        return ejecutarSelect(SQL_RANKING);
    }
    
    private ArrayList<IdiomaPais> ejecutarSelect(String sql, String... params) {
        ArrayList<IdiomaPais> lista = new ArrayList<>();
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
                String idioma = rs.getString("nombreIdioma");
                boolean esOficial = rs.getBoolean("oficial");
                double porcentaje = rs.getDouble("porcentaje");
                String paisCodigoStr = rs.getString("codigoPais");
                Pais pais = new Pais(paisCodigoStr);                
                lista.add(new IdiomaPais(idioma, esOficial, porcentaje, pais));
            }
        } catch (SQLException e) {
                System.err.println("Error de Select: " + e.getMessage());
                throw new RuntimeException("Error al ejecutar select: " + e.getMessage(), e);
        } 
                finally {
                try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
        return lista;
    }                
}
