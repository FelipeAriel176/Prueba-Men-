/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prueba2menu;

/**
 *
 * @author FELIP
 */
public class Ciudad {
    String nombre;
    String distrito;
    int poblacion;
    
    
    Pais pais;

    public Ciudad() {
    }

    public Ciudad(String nombre, String distrito, int poblacion, Pais pais) {
        this.nombre = nombre;
        this.distrito = distrito;
        this.poblacion = poblacion;
        this.pais = pais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public int getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Ciudad{" + "nombre=" + nombre + ", distrito=" + distrito + ", poblacion=" + poblacion + ", pais=" + pais + '}';
    }

}
