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

    public Pais() {
    }

    public Pais(String codigo, String nombre, String continente, int poblacion, boolean tipoGobierno) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.continente = continente;
        this.poblacion = poblacion;
        this.tipoGobierno = tipoGobierno;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
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

    public int getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }
    
    public boolean isTipoGobierno() {
        return tipoGobierno;
    }

    public void setTipoGobierno(boolean tipoGobierno) {
        this.tipoGobierno = tipoGobierno;
    }
    
    @Override
    public String toString() {
        return nombre;
    }
    public String getTipoGobiernoTexto() {
        return tipoGobierno ? "República" : "Monarquía/Otro";
     }
    
    private static final System.Logger LOG = System.getLogger(Pais.class.getName());
}
 
    
