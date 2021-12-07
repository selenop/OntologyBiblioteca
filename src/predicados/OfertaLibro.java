package predicados;

import conceptos.Libro;
import jade.content.Predicate;

public class OfertaLibro implements Predicate {
 
   private Libro libro;
 
   public Libro getLibro() {
     return libro;
   }
 
   public void setLibro(Libro l) {
     libro = l;
   }
}
