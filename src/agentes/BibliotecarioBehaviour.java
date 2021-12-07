package agentes;

import jade.content.lang.Codec;
import jade.content.onto.Ontology;
import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;

public class BibliotecarioBehaviour extends SimpleBehaviour{

    private boolean finished = false;

	Codec codec;
	Ontology ontologia;

    public BibliotecarioBehaviour(Agent agenteBibliotecario, Codec codec, Ontology ontologia) {
        super(agenteBibliotecario);
        this.codec = codec;
        this.ontologia = ontologia;
    }
    
    @Override
    public void action() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean done() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
