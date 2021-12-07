/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import conceptos.Libro;
import jade.content.AgentAction;

/**
 *
 * @author mvsam
 */
public class DevolverLibro implements AgentAction {
 
   private Libro libro;
 
   public Libro getLibro() {
     return libro;
   }
 
   public void setLibro(Libro l) {
     libro = l;
   }
}
