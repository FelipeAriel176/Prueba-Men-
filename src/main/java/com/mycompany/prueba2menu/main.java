/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.prueba2menu;

import Clases.Pais;
import Clases.Usuario;
import Vistas.VistaLogin;
import java.util.ArrayList;
import Vistas.VistaMenúADMIN;
import Vistas.VistaMenúUSUARIO;
import Vistas.VistaRegistro;
/**
 *
 * @author FELIP
 */
public class main {
    public static VistaMenúADMIN vistaMenuAdmin = new VistaMenúADMIN();
    public static VistaMenúUSUARIO vistaMenuUsuario = new VistaMenúUSUARIO();
    public static VistaRegistro vistaRegistro = new VistaRegistro();
    public static VistaLogin vistaLogin = new VistaLogin();
    public static ArrayList<Pais> listaPaises = new ArrayList<>();
    public static ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        public static void main(String[] args) {
        VistaLogin login = new VistaLogin();
        login.setVisible(true);
    }
}

