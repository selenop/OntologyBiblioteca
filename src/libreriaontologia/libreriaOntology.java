/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreriaontologia;

import jade.content.onto.*;
import jade.content.schema.*;
/**
 *
 * @author mvsam
 */
public class libreriaOntology extends Ontology {
   // Nombre de la ontología
   public static final String ONTOLOGY_NAME = "ontología de libros";
 
  // Vocabulario de la ontología que van a manejar los agentes
  public static final String LIBRO = "Libro";
  public static final String LIBRO_NOMBRE = "nombre";
  public static final String LIBRO_PRECIO = "precio";
 
  public static final String OFERTA = "Oferta";
  public static final String OFERTA_LIBRO = "Libro";
 
  public static final String COMPRAR = "Comprar";
  public static final String COMPRAR_LIBRO = "Libro";
 
  // Instancia de la ontología (que será única)
  private static Ontology instancia = new libreriaOntology();
 
  // Método para acceder a la instancia de la ontología
  public static Ontology getInstance() {
     return instancia;
   }
 
   // Constructor privado
   private libreriaOntology() {
     // frutasOntology extiende la ontología básica
     super(ONTOLOGY_NAME, BasicOntology.getInstance());
 
     try {
       // Añade los elementos
       add(new ConceptSchema(LIBRO), Libro.class);
       add(new PredicateSchema(OFERTA), Oferta.class);
       add(new AgentActionSchema(COMPRAR), Comprar.class);
 
       // Estructura del esquema para el concepto FRUTA
       ConceptSchema cs = (ConceptSchema) getSchema(LIBRO);
       cs.add(LIBRO_NOMBRE, (PrimitiveSchema) getSchema(BasicOntology.STRING));
       cs.add(LIBRO_PRECIO, (PrimitiveSchema) getSchema(BasicOntology.INTEGER));
 
       // Estructura del esquema para el predicado OFERTA
       PredicateSchema ps = (PredicateSchema) getSchema(OFERTA);
       ps.add(OFERTA_LIBRO, (ConceptSchema) getSchema(LIBRO));
 
       // Estructura del esquema para la acción COMPRAR
       AgentActionSchema as = (AgentActionSchema) getSchema(COMPRAR);
       as.add(COMPRAR_LIBRO, (ConceptSchema) getSchema(LIBRO));
     }
     catch (OntologyException oe) {
       oe.printStackTrace();
     }
   }
}