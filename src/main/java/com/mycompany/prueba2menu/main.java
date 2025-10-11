/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.prueba2menu;

import Clases.Usuario;
import Vistas.VistaLogin;
import Vistas.VistaMenúUSUARIO;
import Vistas.VistaRegistro;
import java.util.ArrayList;
/**
 *
 * @author FELIP
 */
public class main {
public static ArrayList<Usuario> listaUsuarios = new ArrayList<>();

public static VistaLogin vistaLogin = new VistaLogin();
    public static VistaRegistro vistaRegistro = new VistaRegistro();
    public static VistaMenúUSUARIO vistaMenúUsuario = new VistaMenúUSUARIO();
    public static void main(String[] args) {
        VistaLogin login = new VistaLogin();
    }
}

