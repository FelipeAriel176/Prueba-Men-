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

    private final PaisDAO paisDAO = new PaisDAO();

    private static final String SQL_SELECT_ALL = "SELECT nombreIdioma, oficial, codigoPais FROM Idioma";
    private static final String SQL_SELECT_BY_COUNTRY = "SELECT nombreIdioma, oficial, codigoPais FROM Idioma WHERE codigoPais = ?";
    
    public ArrayList<IdiomaPais> listarIdiomas() {
    return ejecutarSelect(SQL_SELECT_ALL);
    }
    
    public ArrayList<IdiomaPais> listarIdiomasPorPais(String paisCodigo) {
        return ejecutarSelect(SQL_SELECT_BY_COUNTRY, String.valueOf(paisCodigo));
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
                String paisCodigoStr = rs.getString("codigoPais");
                Pais pais = new Pais(paisCodigoStr, "", "", 0, false);                
                lista.add(new IdiomaPais(idioma, esOficial, 0.0, pais));
            }
        } catch (SQLException e) {
                System.err.println("Error de Select en IdiomaPais: " + e.getMessage());
                throw new RuntimeException("Error al ejecutar select en IdiomaDAO: " + e.getMessage(), e);
        } 
                finally {
                try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar recursos en IdiomaPais: " + e.getMessage());
            }
        }
        return lista;
    }                
}
