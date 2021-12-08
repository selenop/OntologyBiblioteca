/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conceptos;

import jade.content.Concept;

/**
 *
 * @author mvsam
 */
public class Tesis implements Concept {
    private int clave;
    private String titulo;
    private String autor;
    private String especialidad;
    private int ejemplares;

    public Tesis(int clave, String titulo, String autor, String especialidad, int ejemplares) {
        this.clave = clave;
        this.titulo = titulo;
        this.autor = autor;
        this.especialidad = especialidad;
        this.ejemplares = ejemplares;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(int ejemplares) {
        this.ejemplares = ejemplares;
    }
    
}
