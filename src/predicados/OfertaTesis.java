package predicados;

import conceptos.Tesis;
import jade.content.Predicate;

public class OfertaTesis implements Predicate {
 
   private Tesis tesis;

    public Tesis getTesis() {
        return tesis;
    }

    public void setTesis(Tesis tesis) {
        this.tesis = tesis;
    }
 
   
}
