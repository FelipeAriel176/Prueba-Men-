/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prueba2menu;

/**
 *
 * @author FELIP
 */
public class Pais {
    String nombre;
    String continente;
    String region;
    double poblacion;
    double anioIndependencia;
    double productoBruto;
    String formaGobierno;
    String jefeEstado;
    String Capital;
    public Pais() {
    }

    public Pais(String nombre, String continente, String region, double poblacion, 
    double anioIndependencia, 
    double productoBruto, String formaGobierno, String jefeEstado, String Capital) {
        this.nombre = nombre;
        this.continente = continente;
        this.region = region;
        this.poblacion = poblacion;
        this.anioIndependencia = anioIndependencia;
        this.productoBruto = productoBruto;
        this.formaGobierno = formaGobierno;
        this.jefeEstado = jefeEstado;
        this.Capital = Capital;
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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public double getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(double poblacion) {
        this.poblacion = poblacion;
    }

    public double getAnioIndependencia() {
        return anioIndependencia;
    }

    public void setAnioIndependencia(double anioIndependencia) {
        this.anioIndependencia = anioIndependencia;
    }

    public double getProductoBruto() {
        return productoBruto;
    }

    public void setProductoBruto(double productoBruto) {
        this.productoBruto = productoBruto;
    }

    public String getFormaGobierno() {
        return formaGobierno;
    }

    public void setFormaGobierno(String formaGobierno) {
        this.formaGobierno = formaGobierno;
    }

    public String getJefeEstado() {
        return jefeEstado;
    }

    public void setJefeEstado(String jefeEstado) {
        this.jefeEstado = jefeEstado;
    }

    public String getCapital() {
        return Capital;
    }

    public void setCapital(String Capital) {
        this.Capital = Capital;
    }

    @Override
    public String toString() {
        return "Pais{" + "nombre=" + nombre + ", continente=" + continente + ", region=" + region + ", poblacion=" + poblacion + ", anioIndependencia=" + anioIndependencia + ", productoBruto=" + productoBruto + ", formaGobierno=" + formaGobierno + ", jefeEstado=" + jefeEstado + ", Capital=" + Capital + '}';
    }
}
