/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import analizadores.Yylex;
import analizadores.parser;

/**
 *
 * @author Fredy-pc
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            parser p = new parser(new Yylex(new java.io.FileInputStream("entrada.txt")));
            p.parse();
        }catch(Exception e){
        System.out.print(e.getMessage());
        }
    }
    
}
