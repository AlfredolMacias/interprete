/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaApplication1;

import java.util.ArrayList;
/**
 *
 * @author Fredy-pc
 */
public class Cara {
    //Objeto objeto = new Objeto();
   
    static ArrayList<Objeto> lista ;
    public Cara(){
        lista = new ArrayList<Objeto>();
        //lista =  new ArrayList<Objeto>();
    }
    public void DibujarCara(String instruccion, int x, int y, int radio, String nomCara, String modo){
        boolean existe = false;
        boolean se_sale = false;
        boolean choca = false;
        if((x - radio) < 0 || (y-radio) < 0 ){
                System.out.println("X: " + x + "Y: " + y + "Radio: + radio");
                se_sale = true;
        }
        for(Objeto a: lista){
            if(a.get_NombreCara().equals(nomCara)){
                existe = true;
            }
            if(a.getInst().equals("DibujarCara")){
                int x1 = a.get_x()-a.get_radio();
                int y1 = a.get_y()-a.get_radio();
                int x2 = a.get_x()+a.get_radio();
                int y2 = a.get_y()+a.get_radio();
                
                int nx1 = x - radio;
                int ny1 = y - radio;
                int nx2 = x + radio;
                int ny2 = y + radio;
                
                System.out.println("SI Entro");
                System.out.println("X: " + x + " Y; " + y + "Radio: " + radio);
                System.out.println("L1: " + x1 + " L2; " + x2 + " R1: " + y1 + " R2: " +y2);
                if((nx1 >= x1 && nx1 <= x2 && ny1 >= y1 && ny1 <= y2) ||
                        (nx1 >= x1 && nx1 <= x2 && ny2 >= y1 && ny2 <= y2) ||
                        (nx2 >= x1 && nx2 <= x2 && ny2 >= y1 && ny2 <= y2) ||
                        (nx2 >= x1 && nx2 <= x2 && ny1 >= y1 && ny1 <= y2)){
                        choca = true;
                    }
                }
        }
        
        if(existe){
            System.out.println("Error, la cara " + nomCara + " ya existe");
            imprimir("Error, la cara " + nomCara + " ya existe");
        }else if(se_sale){
            System.out.println("Error, la cara está fuera del limite");
        }else if(choca){
            System.out.println("Error, la cara choca con otra existente");
        }else{
            Objeto n = new Objeto(instruccion, x, y, radio, nomCara, modo, 0);
           lista.add(n);       
        }
    } 
    NewJFrame jFrame = new NewJFrame();
    private void imprimir(String j) {
       JavaApplication1.cambiarError(j);
       jFrame.setText();
    }
    
    public static void EliminarCara(String instruccion, String nomCara){
        boolean existe = false;
        for(Objeto a: lista) {
            if(a.get_NombreCara().equals(nomCara)){
                existe = true;
            }
        }
        if(existe){
            lista.add(new Objeto(instruccion,0,0,0, nomCara,"", 0));
        }else{
            System.out.println("Error, la cara " + nomCara + " no existe");
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
              Objeto n = new Objeto(instruccion, 0,0,0, nomCara, modo, 0);
                lista.add(n);        
               //imprimir("Error, la cara " + nomCara + " ya existe");
            }else{
            //System.out.println("SI Entro");
            System.out.println("Error, la cara " + nomCara + " no existe");
            }
        lista.add(new Objeto(instruccion, 0,0,0, nomCara, modo,0));
    }
    public static void Dormir(String instruccion, int segundos){
        lista.add(new Objeto(instruccion,0,0,0,"","", segundos));
    }
    public static void allPeople() {
        for(Objeto a: lista) {
            System.out.println(a.getInst());
        }
    }
    public static void buscarNom(){
        
    }
}
