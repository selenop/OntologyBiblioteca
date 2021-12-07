package agentes;

import jade.content.lang.Codec;
import jade.content.onto.Ontology;
import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;

public class RecepcionistaWaitingBehaviour extends SimpleBehaviour{

    private boolean finished = false;

    public RecepcionistaWaitingBehaviour(Agent agenteRecepcionista) {
        super(agenteRecepcionista);
    }
    
    @Override
    public void action() {
        System.out.println("[Recepcionista] Esperando fin de operacion...");
        ACLMessage msg = myAgent.blockingReceive();
        
        if (msg.getPerformative() == ACLMessage.INFORM) {
            System.out.println("[Recepcionista] Mensaje recibido: " + msg.getContent());
            System.out.print("[Recepcionista] Esperando opcion");
        }
        finished = true;
    }

    @Override
    public boolean done() {
        return finished;
    }
    
}
