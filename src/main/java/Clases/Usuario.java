/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author arale
 */
public class Usuario {
     private String nombreUsuario;
    private String contraseña;

    // Constructor para crear un nuevo objeto Usuario
    public Usuario(String nombreUsuario, String contrasena) {
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contrasena;
    }

    // Métodos para obtener los datos (getters)
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContrasena() {
        return contraseña;
    }

    public Object getNombre() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object getContraseña() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
