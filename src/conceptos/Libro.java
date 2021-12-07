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
public class Libro implements Concept {
 
    private int clave;
    private String titulo;
    private String autores;
    private String editorial;
    private String isbn; //int no permite numeros de mas de 10 digitos, el isbn esta compuesto de 13
    private int ejemplares;
    private String area;
    private String categoria;

    public Libro(int clave, String titulo, String autores, String editorial, String isbn, int ejemplares, String area, String categoria) {
        this.clave = clave;
        this.titulo = titulo;
        this.autores = autores;
        this.editorial = editorial;
        this.isbn = isbn;
        this.ejemplares = ejemplares;
        this.area = area;
        this.categoria = categoria;
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

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(int ejemplares) {
        this.ejemplares = ejemplares;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}