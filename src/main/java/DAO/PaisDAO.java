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

    private static final String SQL_SELECT_ALL = "SELECT Codigo, Nombre, Continente, Poblacion FROM Pais";
    private static final String SQL_SELECT_BY_CODE = "SELECT Codigo, Nombre, Continente, Poblacion FROM Pais WHERE Codigo = ?";
    private static final String SQL_SELECT_FILTER_NAME = "SELECT Codigo, Nombre, Continente, Poblacion FROM Pais WHERE Nombre LIKE ?";
    private static final String SQL_SELECT_FILTER_CONTINENT = "SELECT Codigo, Nombre, Continente, Poblacion FROM Pais WHERE Continente = ?";
    private static final String SQL_INSERT = "INSERT INTO Pais (Codigo, Nombre, Continente, Poblacion) VALUES (?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE Pais SET Nombre = ?, Continente = ?, Poblacion = ? WHERE Codigo = ?";
    private static final String SQL_DELETE = "DELETE FROM Pais WHERE Codigo = ?";

    public ArrayList<Pais> listarPaises() {
        return ejecutarSelect(SQL_SELECT_ALL);
    }

    public ArrayList<Pais> listarPaisesFiltrados(String textoBuscado) {
        return ejecutarSelect(SQL_SELECT_FILTER_NAME, "%" + textoBuscado + "%");
    }
    
    public ArrayList<Pais> listarPaisesPorContinente(String continente) {
        return ejecutarSelect(SQL_SELECT_FILTER_CONTINENT, continente);
    }
    
    public Pais obtenerPaisPorCodigo(int codigo) {
        ArrayList<Pais> resultado = ejecutarSelect(SQL_SELECT_BY_CODE, String.valueOf(codigo));
        return resultado.isEmpty() ? null : resultado.get(0);
    }

    public boolean agregarPais(Pais pais) {
        return ejecutarUpdate(SQL_INSERT, 
            String.valueOf(pais.getCodigo()),
            pais.getNombre(),
            pais.getContinente(),
            String.valueOf(pais.getPoblacion()));
    }

    public boolean modificarPais(Pais pais) {
        return ejecutarUpdate(SQL_UPDATE, 
            pais.getNombre(),
            pais.getContinente(),
            String.valueOf(pais.getPoblacion()),
            String.valueOf(pais.getCodigo())); 
    }

    public boolean eliminarPais(int codigo) {
        return ejecutarUpdate(SQL_DELETE, String.valueOf(codigo));
    }
    
    // ----------------------------------------------------
    // Lógica Auxiliar de Ejecución
    // ----------------------------------------------------

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
                int codigo = rs.getInt("Codigo");
                String nombre = rs.getString("Nombre");
                String continente = rs.getString("Continente");
                int poblacion = rs.getInt("Poblacion");
                lista.add(new Pais(codigo, nombre, continente, poblacion));
            }
        } catch (SQLException e) {
            System.err.println("Error de Select en País: " + e.getMessage());
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
            System.err.println("Error de Update en País: " + e.getMessage());
            return false;
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar recursos en País: " + e.getMessage());
            }
        }
    }
}
