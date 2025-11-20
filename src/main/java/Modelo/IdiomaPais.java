/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

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
    private static final System.Logger LOG = System.getLogger(IdiomaPais.class.getName());

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
        if (porcentajeHablantes < 0.0 || porcentajeHablantes > 100.0) {
            throw new IllegalArgumentException("El porcentaje de hablantes debe estar entre 0 y 100.");
        }
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


