/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.prueba2menu;

import Modelo.Pais;
import Modelo.Usuario;
import Vistas.VistaLogin;
import java.util.ArrayList;
/**
 *
 * @author FELIP
 */
public class main {
    
    public static ArrayList<Pais> listaPaises = new ArrayList<>();
    public static ArrayList<Modelo.Ciudad> listaCiudades = new ArrayList<>();
    public static ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    public static ArrayList<Modelo.IdiomaPais> listaIdiomas = new ArrayList<>();

        public static void main(String[] args) {
        VistaLogin login = new VistaLogin();
        login.setVisible(true);
    }
}

