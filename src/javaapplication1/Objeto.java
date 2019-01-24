/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaApplication1;

/**
 *
 * @author Fredy-pc
 */
public class Objeto {
    private int x;
    private int y;
    private int radio;
    private String nomCara;
    private String instruccion;
    private String modo;
    private int segundos;    
    
    Objeto(String instruccion,int x, int y, int radio, String nomCara, String modo, int segundos){
        this.instruccion = instruccion;
        this.x = x;
        this.y = y;
        this.radio = radio;
        this.nomCara = nomCara;
        this.modo = modo;
        this.segundos = segundos;
    }
    public int get_x(){
        return x;
    }
    public int get_y(){
        return y;
    }
    public int get_radio(){
        return radio;
    }
    public String get_NombreCara(){
        return nomCara;
    }
    public String get_Modo(){
        return modo;
    }
    public String getInst(){
        return instruccion;
    }
}
