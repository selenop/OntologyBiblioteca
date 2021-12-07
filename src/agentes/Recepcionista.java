package agentes;

import jade.content.lang.Codec;
import jade.content.lang.sl.SLCodec;
import jade.content.onto.Ontology;
import jade.core.AID;
import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;
import ontologia.libreriaOntology;

public class Recepcionista extends Agent {

    //Agente que maneja las Solicitudes
    private Codec codec = new SLCodec();
    private Ontology ontologia = libreriaOntology.getInstance();

    public Recepcionista() {
    }

    @Override
    protected void setup() {

        //Registro en DF
        DFAgentDescription dfd = new DFAgentDescription();
        ServiceDescription sd = new ServiceDescription();

        sd.setType("Bibliotecario");
        sd.setName("Agente bibliotecario");
        sd.setOwnership("SANSAM");

        dfd.setName(this.getAID());
        dfd.addServices(sd);

        try {
            DFService.register(this, dfd);
        } catch (FIPAException e) {
            System.err.println(getLocalName() + " registration with DF unsucceeded. Reason: " + e.getMessage());
            doDelete();
        }

        getContentManager().registerLanguage(codec);
        getContentManager().registerOntology(ontologia);

        addBehaviour(new RecepcionistaBehaviour(this, codec, ontologia));
    }

    @Override
    protected void takeDown() {
        System.out.println("Baja Bibliotecario");
        try {
            DFService.deregister(this);
        } catch (FIPAException fe) {
            fe.printStackTrace();
        }
    }
}
