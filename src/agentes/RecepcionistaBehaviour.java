package agentes;

import jade.content.lang.Codec;
import jade.content.onto.Ontology;
import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;

public class RecepcionistaBehaviour extends SimpleBehaviour{

    private boolean finished = false;

	Codec codec;
	Ontology ontologia;

    public RecepcionistaBehaviour(Agent agenteBibliotecario, Codec codec, Ontology ontologia) {
        super(agenteBibliotecario);
        this.codec = codec;
        this.ontologia = ontologia;
    }
    
    @Override
    public void action() {
        System.out.println("Esperando petición...");
        ACLMessage msg = myAgent.blockingReceive();
        
        if (msg.getPerformative() == ACLMessage.INFORM) {
            if(msg.getContent().equals("Solicitar Libro")){
                System.out.println("Solicitud de libro recibida");
            }
        }
    }

    @Override
    public boolean done() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
