package GUI;

import conceptos.*;
import java.util.ArrayList;

public class createDB {
    
    ArrayList<Libro> arrLibros = new ArrayList();
    ArrayList<Tesis> arrTesis = new ArrayList();
    
    public createDB(){
        arrLibros.add(new Libro(1,"Dark Rituals","Santiago Soto","Planeta","1234567891023",5,"Literatura","Thriller"));
        arrLibros.add(new Libro(2,"La Bruja Verde","Arin Murphy","AlfaOmega","1234567891024",4,"Literatura","Thriller"));
        arrLibros.add(new Libro(3,"Como ser una bruja moderna","Gabriela Herstik","RocaEditorial","1234567891025",3,"Literatura","Thriller"));
        arrLibros.add(new Libro(4,"Ocho lugares que me recuerdan a ti","Alberto Villarreal","Planeta","1234567891026",4,"Literatura","Thriller"));
        arrLibros.add(new Libro(5,"Hermoso Final","Kami Garcia","Espasa","1234567891027",3,"Literatura","Thriller"));
    
        arrTesis.add(new Tesis(11,"Agua","Severus Snape"))
        
    }
    
}
