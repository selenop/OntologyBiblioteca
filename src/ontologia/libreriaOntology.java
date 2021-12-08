/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ontologia;

import conceptos.*;
import predicados.*;
import acciones.*;
import jade.content.onto.*;
import jade.content.schema.*;

/**
 *
 * @author mvsam
 */
public class libreriaOntology extends Ontology {

    public static final String ONTOLOGY_NAME = "ontología de libros";

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

            // Estructura de CONCEPTOS
            ConceptSchema conceptoLibro = creaConceptoLibro();
            ConceptSchema conceptoTesis = creaConceptoTesis();

            // Estructura de PREDICADOS
            PredicateSchema predicadoOfertaLibro = new PredicateSchema("Oferta Libro");
            predicadoOfertaLibro.add("Libro", conceptoLibro);

            PredicateSchema predicadoOfertaTesis = new PredicateSchema("Oferta Tesis");
            predicadoOfertaTesis.add("Tesis", conceptoTesis);

            // Estructura de ACCIONES
            AgentActionSchema accionSolicitarLibro = new AgentActionSchema("Solicitar Libro");
            accionSolicitarLibro.add("Libro", conceptoLibro);
            
            AgentActionSchema accionSolicitarTesis = new AgentActionSchema("Solicitar Tesis");
            accionSolicitarTesis.add("Tesis", conceptoTesis);
            
            AgentActionSchema accionDevolverLibro = new AgentActionSchema("Devolver Libro");
            accionDevolverLibro.add("Libro", conceptoLibro);
            
            AgentActionSchema accionDevolverTesis = new AgentActionSchema("Devolver Tesis");
            accionDevolverTesis.add("Tesis", conceptoTesis);

            //Agregar Esquemas a ONTOLOGIA
            this.add(conceptoLibro, Libro.class);
            this.add(conceptoTesis, Tesis.class);

            this.add(predicadoOfertaLibro, OfertaLibro.class);
            this.add(predicadoOfertaLibro, OfertaLibro.class);
            
            this.add(accionSolicitarLibro, SolicitarLibro.class);
            this.add(accionSolicitarTesis, SolicitarTesis.class);
            this.add(accionDevolverLibro, DevolverLibro.class);
            this.add(accionDevolverTesis, DevolverTesis.class);

        } catch (OntologyException oe) {
            oe.printStackTrace();
        }
    }

    private ConceptSchema creaConceptoLibro() throws OntologyException {
        ConceptSchema conceptoLibro = new ConceptSchema("Libro");
        conceptoLibro.add("Clave", (PrimitiveSchema) getSchema(BasicOntology.INTEGER));
        conceptoLibro.add("Titulo", (PrimitiveSchema) getSchema(BasicOntology.STRING));
        conceptoLibro.add("Autores", (PrimitiveSchema) getSchema(BasicOntology.STRING));
        conceptoLibro.add("Editorial", (PrimitiveSchema) getSchema(BasicOntology.STRING));
        conceptoLibro.add("ISBN", (PrimitiveSchema) getSchema(BasicOntology.STRING));
        conceptoLibro.add("Ejemplares", (PrimitiveSchema) getSchema(BasicOntology.INTEGER));
        conceptoLibro.add("Area", (PrimitiveSchema) getSchema(BasicOntology.STRING));
        conceptoLibro.add("Categoria", (PrimitiveSchema) getSchema(BasicOntology.STRING));

        return conceptoLibro;
    }

    private ConceptSchema creaConceptoTesis() throws OntologyException {
        ConceptSchema conceptoTesis = new ConceptSchema("Tesis");
        conceptoTesis.add("Clave", (PrimitiveSchema) getSchema(BasicOntology.INTEGER));
        conceptoTesis.add("Titulo", (PrimitiveSchema) getSchema(BasicOntology.STRING));
        conceptoTesis.add("Autor", (PrimitiveSchema) getSchema(BasicOntology.STRING));
        conceptoTesis.add("Especialidad", (PrimitiveSchema) getSchema(BasicOntology.STRING));
        conceptoTesis.add("Ejemplares", (PrimitiveSchema) getSchema(BasicOntology.INTEGER));

        return conceptoTesis;
    }
}
