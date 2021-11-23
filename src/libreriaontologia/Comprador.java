/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreriaontologia;

import jade.content.ContentElement;
import jade.content.lang.Codec;
import jade.content.lang.sl.SLCodec;
import jade.content.onto.Ontology;
import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

/**
 *
 * @author mvsam
 */
public class Comprador extends Agent {
 
    private Codec codec = new SLCodec();
    private Ontology ontologia = libreriaOntology.getInstance();
 
    // Clase que describe el comportamiento que permite recibir un mensaje
    // y contestarlo
    class WaitPingAndReplyBehaviour extends SimpleBehaviour {
      private boolean finished = false;
 
      public WaitPingAndReplyBehaviour(Agent a) {
        super(a);
      }
 
      @Override
      public void action() {
 
    System.out.println("\nEsperando oferta del Vendedor....");
 
    MessageTemplate mt = MessageTemplate.and(
            MessageTemplate.MatchLanguage(codec.getName()),
            MessageTemplate.MatchOntology(ontologia.getName()));
        ACLMessage  msg = blockingReceive(mt);
 
        try {
 
        if(msg != null){
        if(msg.getPerformative() == ACLMessage.NOT_UNDERSTOOD){
                System.out.println("Mensaje NOT UNDERSTOOD recibido");
            }
        else{
            if(msg.getPerformative()== ACLMessage.INFORM){
 
            ContentElement ec = getContentManager().extractContent(msg);
            if (ec instanceof Oferta){
                // Recibido un INFORM con contenido correcto
                Oferta of = (Oferta) ec;
                Libro libr = of.getLibro();
                System.out.println("Mensaje recibido:");
                System.out.println("Nombre: " + libr.getNombre());
                System.out.println("Precio: " + libr.getPrecio());
 
                //Compramos
                Comprar compra = new Comprar();
                compra.setLibro(libr);
                ACLMessage msg2 = new ACLMessage(ACLMessage.REQUEST);
                msg2.setLanguage(codec.getName());
                msg2.setOntology(ontologia.getName());
                msg2.setSender(getAID());
                msg2.addReceiver(msg.getSender());
                getContentManager().fillContent(msg2,compra);
                send(msg2);
                System.out.println("Compra solicitada.");
            }
            else{
                // Recibido un INFORM con contenido incorrecto
                ACLMessage reply = msg.createReply();
                reply.setPerformative(ACLMessage.NOT_UNDERSTOOD);
                reply.setContent("( UnexpectedContent (expected ping))");
                send(reply);
            }
            }
            else {
                // Recibida una performativa incorrecta
                ACLMessage reply = msg.createReply();
                reply.setPerformative(ACLMessage.NOT_UNDERSTOOD);
                reply.setContent("( (Unexpected-act "+ACLMessage.getPerformative(msg.getPerformative())+")( expected (inform)))");
                send(reply);
            }
        }
        }else{
        //System.out.println("No message received");
        }
 
         }
         catch (jade.content.lang.Codec.CodecException ce) {
               System.out.println(ce);
        }
        catch (jade.content.onto.OntologyException oe) {
            System.out.println(oe);
        }
     }
 
      @Override
      public boolean done() {
        return finished;
      }
 
  } //Fin de la clase WaitPingAndReplyBehaviour
 
    @Override
  protected void setup() {
 
    getContentManager().registerLanguage(codec);
    getContentManager().registerOntology(ontologia);
    WaitPingAndReplyBehaviour PingBehaviour;
    PingBehaviour = new  WaitPingAndReplyBehaviour(this);
    addBehaviour(PingBehaviour);
 }
}    