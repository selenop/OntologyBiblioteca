/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones;

import conceptos.Tesis;
import jade.content.AgentAction;

/**
 *
 * @author mvsam
 */
public class SolicitarTesis implements AgentAction {
 
   private Tesis tesis;

    public Tesis getTesis() {
        return tesis;
    }

    public void setTesis(Tesis tesis) {
        this.tesis = tesis;
    }
 
   
}
