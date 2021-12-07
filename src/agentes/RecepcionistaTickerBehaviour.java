package agentes;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;

public class RecepcionistaTickerBehaviour extends TickerBehaviour {

    public static String content = "";

    public RecepcionistaTickerBehaviour(Agent a, long period) {
        super(a, period);
        System.out.print("[Recepcionista] Esperando opcion");

    }

    @Override
    protected void onTick() {
        if (content.equals("")) {
            System.out.print(".");
        } else {
            System.out.println();
            
            AID receiverID = new AID();
            
            switch (content) {
                case "Solicitar Libro":
                    receiverID.setLocalName("Bibliotecario");
                    break;
                case "Solicitar Tesis":
                    receiverID.setLocalName("Bibliotecario");
                    break;
                case "Devolver Libro":
                    receiverID.setLocalName("Almacenista");
                    break;
                case "Devolver Tesis":
                    receiverID.setLocalName("Almacenista");
                    break;
                default:
                    throw new AssertionError();
            }
            
            ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
            
            msg.setSender(myAgent.getAID());
            msg.addReceiver(receiverID);
            msg.setContent(content);
            
            System.out.println("[Recepcionista] Mensaje enviado a " + receiverID.getLocalName());
            myAgent.send(msg);
            content = "";
            myAgent.addBehaviour(new RecepcionistaWaitingBehaviour(myAgent));
        }
    }

}
