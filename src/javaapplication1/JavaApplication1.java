/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaApplication1;

import analizadores.Yylex1;
import analizadores.parser;
import java.io.*;
import JavaApplication1.NewJFrame;
import analizadores.Yylex;

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
        if(correcto){
            System.out.println("HOLA; DUBJU");
        }
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
    JavaApplication1( int ed){
        NewJFrame frame = new NewJFrame();
        String path;
        parser ThisParser;
        Yylex1 ThisScanner;
        path = "entrada.txt";
        try{
            ThisScanner = new Yylex1(new FileReader(path));
            ThisParser = new parser(ThisScanner);
            ThisParser.parse();
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
    public void semantico(){
        if(lex && cup){
            error = "Scaneo Completo";
            System.out.println("Semantico");
        String path;
        Yylex ThisScanner;
        path = "entrada.txt";
        try{
            ThisScanner = new Yylex(new FileReader(path));
            //error = "Scaneo completo";
            
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
    
}
