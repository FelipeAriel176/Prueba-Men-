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
    String tipoGobierno;
    float superficie;
    float esperanzaVida;
    String region;        
    int anioIndependencia; 
    float gnp;              
    String jefeEstado;      
    int idCapital;
    

    public Pais() {
    }

    public Pais(String codigo, String nombre, String continente, int poblacion, String tipoGobierno, float superficie, float esperanzaVida,
        String region, int anioIndependencia, float gnp, String jefeEstado, int idCapital) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.continente = continente;
        this.poblacion = poblacion;
        this.tipoGobierno = tipoGobierno;
        this.superficie = superficie;
        this.esperanzaVida = esperanzaVida;
        this.region = region;
        this.anioIndependencia = anioIndependencia;
        this.gnp = gnp;
        this.jefeEstado = jefeEstado;
        this.idCapital = idCapital;
    }
    
    public Pais(String codigo) {
        this.codigo = codigo;
        this.nombre = "";
        this.continente = "";
        this.region = "";
        this.poblacion = 0;
        this.tipoGobierno = "";
        this.superficie = 0.0f;
        this.anioIndependencia = 0;
        this.esperanzaVida = 0.0f;
        this.gnp = 0.0f;
        this.jefeEstado = "";
        this.idCapital = 0;
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
    
    public String getTipoGobierno() { 
     return tipoGobierno; }
 

    public void setTipoGobierno(String tipoGobierno) { 
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
    
    public String getRegion() { 
        return region; 
    }
    
    public void setRegion(String region) { 
        this.region = region; 
    }
    
    public int getAnioIndependencia() { 
        return anioIndependencia;
    } 
    
    public void setAnioIndependencia(int anioIndependencia) { 
        this.anioIndependencia = anioIndependencia; 
    }
    
    public float getGnp() { 
        return gnp;
    }
    
    public void setGnp(float gnp) { this.gnp = gnp; }

    public String getJefeEstado() { 
        return jefeEstado; 
    }
    
    public void setJefeEstado(String jefeEstado) { this.jefeEstado = jefeEstado; }

    public int getIdCapital() { 
        return idCapital;
    } 
    
    public void setIdCapital(int idCapital) { this.idCapital = idCapital; }
    
    @Override
    public String toString() {
        return nombre;
    } 
} 
    
