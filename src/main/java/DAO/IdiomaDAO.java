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

    private static final String SQL_SELECT_ALL = "SELECT Idioma, EsOficial, PorcentajeHablantes, PaisCodigo FROM IdiomaPais";
    private static final String SQL_SELECT_BY_COUNTRY = "SELECT Idioma, EsOficial, PorcentajeHablantes, PaisCodigo FROM IdiomaPais WHERE PaisCodigo = ?";
    private static final String SQL_INSERT = "INSERT INTO IdiomaPais (Idioma, EsOficial, PorcentajeHablantes, PaisCodigo) VALUES (?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE IdiomaPais SET Idioma = ?, EsOficial = ?, PorcentajeHablantes = ?, PaisCodigo = ? WHERE Idioma = ? AND PaisCodigo = ?";
    private static final String SQL_DELETE = "DELETE FROM IdiomaPais WHERE Idioma = ? AND PaisCodigo = ?";


    public ArrayList<IdiomaPais> listarIdiomas() {
        return ejecutarSelect(SQL_SELECT_ALL);
    }
    
    public ArrayList<IdiomaPais> listarIdiomasPorPais(int paisCodigo) {
        return ejecutarSelect(SQL_SELECT_BY_COUNTRY, String.valueOf(paisCodigo));
    }

    public boolean agregarIdioma(IdiomaPais idioma) {
        return ejecutarUpdate(SQL_INSERT, 
            idioma.getIdioma(),
            String.valueOf(idioma.isEsOficial() ? 1 : 0),
            String.valueOf(idioma.getPorcentajeHablantes()),
            String.valueOf(idioma.getPais().getCodigo()));
    }

    public boolean modificarIdioma(IdiomaPais idiomaOriginal, IdiomaPais idiomaNuevo) {
        return ejecutarUpdate(SQL_UPDATE, 
            idiomaNuevo.getIdioma(), 
            String.valueOf(idiomaNuevo.isEsOficial() ? 1 : 0), 
            String.valueOf(idiomaNuevo.getPorcentajeHablantes()), 
            String.valueOf(idiomaNuevo.getPais().getCodigo()), 
            idiomaOriginal.getIdioma(), 
            String.valueOf(idiomaOriginal.getPais().getCodigo())); 
    }

    public boolean eliminarIdioma(String idioma, int paisCodigo) {
        return ejecutarUpdate(SQL_DELETE, idioma, String.valueOf(paisCodigo));
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
                String idioma = rs.getString("Idioma");
                boolean esOficial = rs.getBoolean("EsOficial");
                double porcentajeHablantes = rs.getDouble("PorcentajeHablantes");
                int paisCodigo = rs.getInt("PaisCodigo");
                
                Pais pais = paisDAO.obtenerPaisPorCodigo(paisCodigo);
                
                if (pais != null) {
                    lista.add(new IdiomaPais(idioma, esOficial, porcentajeHablantes, pais));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error de Select en IdiomaPais: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar recursos en IdiomaPais: " + e.getMessage());
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
            System.err.println("Error de Update en IdiomaPais: " + e.getMessage());
            return false;
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar recursos en IdiomaPais: " + e.getMessage());
            }
        }
    }
}
