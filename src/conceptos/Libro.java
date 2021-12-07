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
 
   private String nombre;
   private int precio;
 
   public String getNombre() {
     return nombre;
   }
 
   public void setNombre(String n) {
     nombre = n;
   }
 
   public int getPrecio() {
     return precio;
   }
 
   public void setPrecio(int p) {
     precio = p;
   }
}