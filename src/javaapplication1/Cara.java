/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaApplication1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author Fredy-pc
 */
public class Cara {
    //Objeto objeto = new Objeto();
    static String mensaje="";
    static ArrayList<Objeto> lista ;
    ArrayList<Carita> carita;
    public Cara(){
        lista = new ArrayList<Objeto>();
        //lista =  new ArrayList<Objeto>();
    }
    private boolean existe;
    /*private NewJFrame NewJFrame;
    public Cara(final NewJFrame NewJFrame) {
        this.NewJFrame = NewJFrame;
    }*/
    
    public void DibujarCara(String instruccion, int x, int y, int radio, String nomCara, String modo){
        existe = false;
        boolean se_sale = false;
        boolean choca = false;
        if((x - radio) < 0 || (y-radio) < 0 || (x + radio) >700 || (y + radio) > 400){
                System.out.println("X: " + x + "Y: " + y + "Radio: + radio");
                se_sale = true;
        }
        for(Objeto a: lista){
            if(a.getInst().equals("DibujarCara")){
                int x1 = a.get_x()-a.get_radio();
                int y1 = a.get_y()-a.get_radio();
                int x2 = a.get_x()+a.get_radio();
                int y2 = a.get_y()+a.get_radio();
                
                int nx1 = x - radio;
                int ny1 = y - radio;
                int nx2 = x + radio;
                int ny2 = y + radio;
                if((nx1 >= x1 && nx1 <= x2 && ny1 >= y1 && ny1 <= y2) ||
                        (nx1 >= x1 && nx1 <= x2 && ny2 >= y1 && ny2 <= y2) ||
                        (nx2 >= x1 && nx2 <= x2 && ny2 >= y1 && ny2 <= y2) ||
                        (nx2 >= x1 && nx2 <= x2 && ny1 >= y1 && ny1 <= y2)){
                        choca = true;
                    }
                }
        }
        
        if(se_sale){
            System.out.println("Error, la cara..." + nomCara + " está fuera del limite");
          mensaje= "Error, la cara " + nomCara +" está fuera del limite";
        }else if(choca){
            System.out.println("Error, la cara choca con otra existente");
          
            mensaje="Error, la cara "+ nomCara + " choca con otra existente";
        }else{
            Objeto n = new Objeto(instruccion, x, y, radio, nomCara, modo, 0, true);
            NewJFrame.ingresarLista(n);
           lista.add(n);
        }
    } 
    private void imprimir(String j) {
       JavaApplication1.cambiarError(j);
       try{
           
       }catch(Exception e){
           System.out.println("Error" + e);
       }
       
    }
    
    public static void EliminarCara(String instruccion, String nomCara){
        boolean existe = false;
        for(Objeto a: lista) {
            if(a.get_NombreCara().equals(nomCara)){
                existe = true;
            }
        }
        if(existe){
            Objeto n = new Objeto(instruccion,0,0,0, nomCara,"", 0, false);
            lista.add(n);
            NewJFrame.ingresarLista(n);
        }else{
            System.out.println("Error, la cara " + nomCara + " no existe");
           // JOptionPane.showMessageDialog(null, "Error, la cara " + nomCara + " no existe",  "Error", JOptionPane.INFORMATION_MESSAGE);
           mensaje= "Error, la cara " + nomCara + " no existe";
        }
        
    }
    public static void CambiarModo(String instruccion, String nomCara, String modo){
        boolean existe = false;
        for(Objeto a: lista) {
            if(a.get_NombreCara().equals(nomCara)){
                existe = true;
            }
        }
        if(existe){
              Objeto n = new Objeto(instruccion, 0,0,0, nomCara, modo, 0, false);
              lista.add(n);
              NewJFrame.ingresarLista(n);
          
            }else{
       
            System.out.println("Error, la cara " + nomCara + " no existe");
            mensaje="Error, la cara " + nomCara + " no existe";
            }
        lista.add(new Objeto(instruccion, 0,0,0, nomCara, modo,0, true));
    }
    public static void Dormir(String instruccion, int segundos){
        Objeto n = new Objeto(instruccion,0,0,0,"","", segundos, false);
        lista.add(n);
        NewJFrame.ingresarLista(n);
    }
}
