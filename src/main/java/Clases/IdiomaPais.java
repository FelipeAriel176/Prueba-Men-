/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author FELIP
 */
public class IdiomaPais {
    String idioma;
    boolean esOficial;
    double porcentajeHablantes;
    Pais pais; 

    public IdiomaPais() {
    }

    public IdiomaPais(String idioma, boolean esOficial, double porcentajeHablantes, Pais pais) {
        this.idioma = idioma;
        this.esOficial = esOficial;
        this.porcentajeHablantes = porcentajeHablantes;
        this.pais = pais;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public boolean isEsOficial() {
        return esOficial;
    }

    public void setEsOficial(boolean esOficial) {
        this.esOficial = esOficial;
    }

    public double getPorcentajeHablantes() {
        return porcentajeHablantes;
    }

    public void setPorcentajeHablantes(double porcentajeHablantes) {
        this.porcentajeHablantes = porcentajeHablantes;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "IdiomaPais{" + "idioma=" + idioma + ", esOficial=" + esOficial + ", porcentajeHablantes=" + porcentajeHablantes + ", pais=" + pais + '}';
    }

}


