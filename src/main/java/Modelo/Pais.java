/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author FELIP
 */
public class Pais {
    int codigo;
    String nombre;
    String continente;
    int poblacion;
    public Pais() {   
    }

    public Pais(String nombre, String continente, int poblacion, int codigo) {
        this.nombre = nombre;
        this.continente = continente;
        this.poblacion = poblacion;
        this.codigo = codigo;
    }

    public double getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public double getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }
    @Override
    public String toString() {
        return "Pais{" + "nombre=" + nombre + ", continente=" + continente + ", poblacion=" + poblacion + ", codigo=" + codigo + '}';
    }
 }