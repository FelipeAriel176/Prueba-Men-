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
    String codigo;
    String nombre;
    String continente;
    int poblacion;
    boolean tipoGobierno;
    float superficie;
    float esperanzaVida;

    public Pais() {
    }

    public Pais(String codigo, String nombre, String continente, int poblacion, boolean tipoGobierno, float superficie, float esperanzaVida) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.continente = continente;
        this.poblacion = poblacion;
        this.tipoGobierno = tipoGobierno;
        this.superficie = superficie;
        this.esperanzaVida = esperanzaVida;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        if ( codigo.trim().length() != 3) {
            throw new IllegalArgumentException("El código del país ('" + codigo + "') debe ser de 3 caracteres.");
        }
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null) {
            throw new IllegalArgumentException("El país no puede estar vacío.");
        }
        this.nombre = nombre;
    }
    
    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public int getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(int poblacion) {
        if (poblacion < 0) {
            throw new IllegalArgumentException("La población no puede ser negativa: " + poblacion);
        }
        this.poblacion = poblacion;
        }
    
    public boolean isTipoGobierno() {
        return tipoGobierno;
    }

    public void setTipoGobierno(boolean tipoGobierno) {
        this.tipoGobierno = tipoGobierno;
    }
    
    public float getSuperficie() { 
        return superficie; 
    }
    
    public void setSuperficie(float superficie) {
        if (superficie < 0) 
                throw new IllegalArgumentException("La superficie no puede ser negativa.");
        this.superficie = superficie;
    }

    public float getEsperanzaVida() { 
        return esperanzaVida; 
    }
    
    public void setEsperanzaVida(float esperanzaVida) {
        if (esperanzaVida < 0) 
                throw new IllegalArgumentException("La esperanza de vida no puede ser negativa.");
        this.esperanzaVida = esperanzaVida;
    }
    
    @Override
    public String toString() {
        return nombre;
    }
    public String getTipoGobiernoTexto() {
        return tipoGobierno ? "República" : "Monarquía/Otro";
     }
}
 
    
