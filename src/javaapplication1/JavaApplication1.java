/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaApplication1;

import analizadores.Yylex;
import analizadores.parser;
import java.io.*;
import JavaApplication1.NewJFrame;
import analizadores.Yylex;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fredy-pc
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    static boolean correcto = true;
    private static String error;
    String error(){
        return error;
    }
   
    static NewJFrame j = new NewJFrame();
    public static void cambiarError(String f){      
        //System.out.println("Valor de f:  " + f);
        error = f;
        //j.setText();
    }
    public static void DibujarCara(){
            System.out.println("HOLA; DUBJU");
    }
    public static void Dormir(){
        if(correcto){
            System.out.println("HOLA; Dormir");
        }
    }
    public static void CambiarModo(){
        if(correcto){
            System.out.println("HOLA; Cambiar Modo");
        }
    }
    public static void EliminarCara(){
        if(correcto){
            System.out.println("HOLA; Eliminar Cara");
        }
    }
    JavaApplication1(){
        
    }
    static boolean lex = true;
    static boolean cup = true;
    JavaApplication1( int ed) throws FileNotFoundException{
        NewJFrame frame = new NewJFrame();
        String path;
        parser ThisParser;
        Yylex ThisScanner;
        path = "entrada.txt";
        try{
            ThisScanner = new Yylex(new FileReader(path));
            lex = true;
            ThisParser = new parser(ThisScanner);
            ThisParser.parse();
            cup = true;
        }catch(Exception e){
            //frame.error("Error de scaneo" + e.toString());
            System.out.println("Error de scaneo" + e);
            //error = "Error de scaeno " + e;
            correcto = false;
        }
        semantico();
    }
    
    public static void VerLex(){
        System.out.println("HolA Lex ");
        lex = false;
    }
    public static void VerSin(){
        System.out.println("HolA Sin");
        cup = false;
    }
    public void semantico() throws FileNotFoundException{
        if(lex && cup){
            archivoModificado();
            error = "Scaneo Completo";            
            String path;
            Yylex ThisScanner1;
            parser ThisParser1;
            path = "entrada.txt";
            try{
               ThisScanner1 = new Yylex(new FileReader(path));
               ThisParser1 = new parser(ThisScanner1);
               ThisParser1.parse();
            }catch(Exception e){
                //frame.error("Error de scaneo" + e.toString());
                System.out.println("Error de scaneo" + e);
                //error = "Error de scaeno " + e;
                correcto = false;
            }
        }    
    }
    public static void main(String[] args) {
        // TODO code application logic here
        new NewJFrame().setVisible(true);        
    }
    
    public void archivoModificado() throws FileNotFoundException{
        File log= new File("entrada.txt");
        File archivo = new File("entrada3.txt");
         BufferedWriter bw;      
        //file reading
        FileReader fr = new FileReader(log);
        try {
            bw = new BufferedWriter(new FileWriter(archivo));
            String line;
            String s;
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                if(line.contains("Programa")){
                    System.out.println("PRograma");
                    line = line.replace("Programa", "");
                }
                if(line.contains("Inicio")){
                    line = line.replace("Inicio", "\r\n");
                }
                if(line.contains(")")){
                    line = line.replace(")", ")\r\n");
                }
                if(line.contains("Fin")){
                    line = line.replace("Fin", "");
                }
                 bw.write(line );
            }
            bw.close();
            sToken();
        } catch (IOException ex) {
            Logger.getLogger(JavaApplication1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void sToken() throws FileNotFoundException{
        File log= new File("entrada3.txt");
         BufferedWriter bw;      
        //file reading
        FileReader fr = new FileReader(log);
        String line;
        Cara c = new Cara();
        int i = 0;
        try {
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                if(i != 0){
                    StringTokenizer tokens=new StringTokenizer(line, "(,)" );
                    int j = 0;
                    int length = tokens.countTokens();
                    String ins="";
                    System.out.println("Hola: " + length);
                    if(length == 6){
                        int e = 0;
                        String[] array = new String[6];
                        while(tokens.hasMoreTokens()){
                            //System.out.println("E: " + e + "Token: " + tokens.nextToken());
                            array[e] = tokens.nextToken();
                            e++;
                        }
                        String instruccion = array[0];
                        int x = Integer.parseInt(array[1]);
                        int y = Integer.parseInt(array[2]);
                        int radio = Integer.parseInt(array[3]);
                        String nomCara = array[4];
                        String modo = array[5];
                        c.DibujarCara(instruccion, x, y, radio, nomCara, modo);
                    }else if(length == 3){
                        int e = 0;
                        String[] array = new String[3];
                        while(tokens.hasMoreTokens()){
                            array[e] = tokens.nextToken();
                            e++;
                        }
                        String instruccion = array[0];
                        String nomCara = array[1];
                        String modo = array[2];
                        Cara.CambiarModo(instruccion,nomCara, modo);
                    }else if(length == 2){
                        int e = 0;
                        String[] array = new String[2];
                        while(tokens.hasMoreTokens()){
                            array[e] = tokens.nextToken();
                            e++;
                        }
                        if(array[0].equals("EliminarCara")){
                            String instruccion = array[0];                            
                            String nomCara = array[1];
                            System.out.println(instruccion);
                            System.out.println(nomCara);
                            Cara.EliminarCara(instruccion, nomCara);
                        }else{
                            String instruccion = array[0];
                            int segundos = Integer.parseInt(array[1]);
                            Cara.Dormir(instruccion, segundos);
                        }
                    }
                }
                i++;
            }
        } catch (IOException ex) {
            Logger.getLogger(JavaApplication1.class.getName()).log(Level.SEVERE, null, ex);
        }
        Cara.allPeople();
    }
    
   
}
