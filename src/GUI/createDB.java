package GUI;

import conceptos.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class createDB {
    
    ArrayList<Libro> arrLibros = new ArrayList();
    ArrayList<Tesis> arrTesis = new ArrayList();
    
    public createDB(){
//        arrLibros.add(new Libro(1,"Dark Rituals","Santiago Soto","Planeta","1234567891023",5,"Literatura","Thriller"));
//        arrLibros.add(new Libro(2,"La Bruja Verde","Arin Murphy","AlfaOmega","1234567891024",4,"Literatura","Thriller"));
//        arrLibros.add(new Libro(3,"Como ser una bruja moderna","Gabriela Herstik","RocaEditorial","1234567891025",3,"Literatura","Thriller"));
//        arrLibros.add(new Libro(4,"Ocho lugares que me recuerdan a ti","Alberto Villarreal","Planeta","1234567891026",4,"Literatura","Thriller"));
//        arrLibros.add(new Libro(5,"Hermoso Final","Kami Garcia","Espasa","1234567891027",3,"Literatura","Thriller"));
//    
//        arrTesis.add(new Tesis(11,"Agua","Severus Snape","Biologia"));
//        arrTesis.add(new Tesis(12,"El lado oscuro de la historia","Aiden Sheppard","Historia"));
//        arrTesis.add(new Tesis(13,"Actividad despues de la muerte","Meyde Medler","Medicina"));
//        arrTesis.add(new Tesis(14,"Dioses o mostruos","Attickus Perceo","Historia"));
//        arrTesis.add(new Tesis(15,"Derechos de los animales.","Derek Vega","Etica"));
        
        writeInFileLibros(arrLibros);
        writeInFileTesis(arrTesis);
    }
    
    public void writeInFileLibros(ArrayList<Libro> arrLibros){
        try {
            FileOutputStream fo = new FileOutputStream("bc_libros.dat");
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            oo.writeObject(arrLibros);
            oo.flush();
            oo.close();
            //System.out.println("Vector almacenado en archivo");
        } catch (IOException exception) {
            System.out.println("Error -- " + exception.toString());
        }
    }
    
    public void writeInFileTesis(ArrayList<Tesis> arrTesis){
        try {
            FileOutputStream fo = new FileOutputStream("bc_tesis.dat");
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            oo.writeObject(arrTesis);
            oo.flush();
            oo.close();
            //System.out.println("Vector almacenado en archivo");
        } catch (IOException exception) {
            System.out.println("Error -- " + exception.toString());
        }
    }
    
    public static ArrayList<Libro> readFromFileLibros(){
        ArrayList<Libro> arrLibros;
        
        try {
            FileInputStream fi = new FileInputStream("bc_libros.dat");
            ObjectInputStream oi = new ObjectInputStream(fi);
            arrLibros = (ArrayList) oi.readObject();
            oi.close();
            return arrLibros;
        } catch (Exception exception) {
            System.out.println("Error -- " + exception.toString());
            System.out.println("Error no se ha creado el archivo ");
            return null;
        }
    }
    
    public static ArrayList<Tesis> readFromFileTesis(){
        ArrayList<Tesis> arrTesis;
        
        try {
            FileInputStream fi = new FileInputStream("bc_tesis.dat");
            ObjectInputStream oi = new ObjectInputStream(fi);
            arrTesis = (ArrayList) oi.readObject();
            oi.close();
            return arrTesis;
        } catch (Exception exception) {
            System.out.println("Error -- " + exception.toString());
            System.out.println("Error no se ha creado el archivo ");
            return null;
        }
    }
    
    public static void printArrLibros(ArrayList<Libro> arrLibros, JTable tbl){
        
        DefaultTableModel model = (DefaultTableModel)tbl.getModel();
        model.setRowCount(0);
        
        for (Libro libro : arrLibros) {
            Object[] obj = new Object[3];
            obj[0] = libro.getClave();
            obj[1] = libro.getTitulo();
            obj[2] = libro.getEjemplares();
            model.addRow(obj);
        } 
    }
    
    public static void printArrTesis(ArrayList<Tesis> arrTesis, JTable tbl){
        
        DefaultTableModel model = (DefaultTableModel)tbl.getModel();
        model.setRowCount(0);
        
        for (Tesis tesis : arrTesis) {
            Object[] obj = new Object[3];
            obj[0] = tesis.getClave();
            obj[1] = tesis.getTitulo();
            obj[2] = 1;
            model.addRow(obj);
        } 
    }
    
    public static Libro getLibroPorClave(int cveLibro, ArrayList<Libro> arrLibros){
        for (Libro libro : arrLibros) {
            if(libro.getClave() == cveLibro){
                return libro;
            }
        }
        return null;
    }
    
    public static Tesis getTesisPorClave(int cveTesis, ArrayList<Tesis> arrTesis){
        for (Tesis tesis : arrTesis) {
            if(tesis.getClave() == cveTesis){
                return tesis;
            }
        }
        return null;
    }
    
}
