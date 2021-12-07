package agentes;

import jade.content.lang.Codec;
import jade.content.onto.Ontology;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;
import javax.swing.JOptionPane;

public class AlmacenistaBehaviour extends SimpleBehaviour {

    private boolean finished = false;

    Codec codec;
    Ontology ontologia;

    public AlmacenistaBehaviour(Agent agenteBibliotecario, Codec codec, Ontology ontologia) {
        super(agenteBibliotecario);
        this.codec = codec;
        this.ontologia = ontologia;
    }

    @Override
    public void action() {
        System.out.println("[Almacenista] Esperando petición...");
        ACLMessage msg = myAgent.blockingReceive();

        if (msg.getPerformative() == ACLMessage.INFORM) {
            System.out.println("[Almacenista] Mensaje recibido - " + msg.getContent());
            
            switch (msg.getContent()) {
                case "Devolver Libro":
                    int cveLibro = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la clave del libro a devolver"));
                    //BD
                    break;
                case "Devolver Tesis":
                    int cveTesis = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la clave de la tesis a devolver"));
                    //BD
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }

    @Override
    public boolean done() {
        AID receiverID = new AID();
        receiverID.setLocalName("Recepcionista");

        ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
        msg.setSender(myAgent.getAID());
        msg.addReceiver(receiverID);
        msg.setLanguage(codec.getName());
        msg.setOntology("String");
        msg.setContent("Listo");
        myAgent.send(msg);
        
        System.out.println("[Almacenista] Mensaje enviado a " + receiverID.getLocalName());
        
        return finished;
    }

}
