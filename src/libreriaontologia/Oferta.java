/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreriaontologia;

import jade.content.Predicate;

/**
 *
 * @author mvsam
 */
public class Oferta implements Predicate {
 
   private Libro libro;
 
   public Libro getLibro() {
     return libro;
   }
 
   public void setLibro(Libro l) {
     libro = l;
   }
}
