package JavaApplication1;

public class Carita {
    int x,y,r,type;
    String nom;
    int segundos;
    
    public Carita(int x, int y, int r, String nom, int type, int segundos){
        this.x=x; 
        this.y=y;
        this.r=r;
        this.nom=nom;
        this.type=type;
        this.segundos = segundos;
    }
    
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getR(){
        return r;
    }
    public int getType(){
        return type;
    }
    public String getNom(){
        return nom;
    }
    public void CambiarModo(String nuevoModo ){
        switch(nuevoModo){
            case "feliz":
                type = 1;
                break;
            case "triste":
                type = 2;
                break;
            case "enojada":
                type = 3;
                break;
            case "dormida":
                type = 4;
                break;
            case "neutral":
                type = 5;
                break;
        }
    }
    public int getSegundos(){
        return segundos;
    }
    
}
