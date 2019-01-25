package JavaApplication1;
import java.awt.*;
import java.awt.geom.QuadCurve2D;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JComponent;

public class Dibujar extends JComponent{
    ArrayList<Carita> cara;
    /*public Dibujar(ArrayList<Carita> cara){
        this.cara = cara;
        repaint();
    }*/
    
    @Override
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        super.paint(g);
        for(int i=0; i<cara.size(); i++){
            int x = cara.get(i).getX();
            int y = cara.get(i).getY();
            int r = cara.get(i).getR();
            String nom = cara.get(i).getNom();
            int type = cara.get(i).getType();
            if((x-r) >=0 && (y-r) >=0 && ((x+r) <= 1000 && (y+r) <= 600)){
             
                int x2 = (x-r)+(r*45)/100;
                int y2 = (y-r)+(r*50)/100;
                int x3 = (x-r)+(r*120)/100;
                int xN = (x-r)+(r*80)/100;
                int yN = (y-r)+(r*25)/100;
                int r2 = (r*40)/100;
                g.drawOval(x-r,y-r,r*2,r*2);
                g.setFont(new Font("TimesRoman", Font.PLAIN, ((r*15)/100)));
                switch(type){
                    // Feliz
                    case 1:
                        g.fillOval(x2,y2,r2,r2);
                        g.fillOval(x3,y2,r2,r2);
                        g.drawString(nom, xN, yN);
                        int xBF1 = (x-r)+(r*50)/100;
                        int yBF1 = (y-r)+(r*120)/100;
                        int xBF2 = x;
                        int yBF2 = (y-r)+(r*170)/100;
                        int xBF3 = (x-r)+(r*150)/100;
                        QuadCurve2D bocaF1 = new QuadCurve2D.Float(xBF1, yBF1, xBF2, yBF2, xBF3, yBF1);
                        g2d.draw(bocaF1);
                        g2d.fill(bocaF1);
                        break;
                    // Triste
                    case 2:
                        g.fillOval(x2,y2,r2,r2);
                        g.fillOval(x3, y2, r2, r2);
                        g.drawString(nom, xN, yN);
                        int xBT1 = (x-r)+(r*50)/100;
                        int yBT1 = (y-r)+(r*150)/100;
                        int xBT2 = x;
                        int yBT2 = (y-r)+(r*100)/100;
                        int xBT3 = (x-r)+(r*150)/100;
                        QuadCurve2D bocaT1 = new QuadCurve2D.Float(xBT1, yBT1, xBT2, yBT2, xBT3, yBT1);
                        g2d.draw(bocaT1);
                        g2d.fill(bocaT1);
                        break;
                    // Enojado
                    case 3:
                        int yNE = (y-r)+(r*35)/100;
                        g.drawString(nom, xN, yNE);
                        int yBE1 = (y-r)+(r*60)/100;
                        int xBE1 = (x-r)+(r*65)/100;
                        int yBE2 = y;
                        int xBE2 = (x-r)+(r*95)/100;
                        int yBE3 = (y-r)+(r*80)/100;
                        QuadCurve2D ojoE1 = new QuadCurve2D.Float(x2, yBE1, xBE1, yBE2, xBE2, yBE3);
                        g2d.draw(ojoE1);
                        g2d.fill(ojoE1);
                        int xBE3 = (x-r)+(r*110)/100;
                        int xBE4 = (x-r)+(r*140)/100;
                        int xBE5 = (x-r)+(r*160)/100;
                        QuadCurve2D ojoE2 = new QuadCurve2D.Float(xBE3, yBE3, xBE4, yBE2, xBE5, yBE1);
                        g2d.draw(ojoE2);
                        g2d.fill(ojoE2);
                        int xBE6 = (x-r)+(r*50)/100;
                        int yBE4 = (y-r)+(r*150)/100;
                        int xBE7 = x;
                        int yBE5 = (y-r)+(r*100)/100;
                        int xBE8 = (x-r)+(r*150)/100;
                        QuadCurve2D bocaE1 = new QuadCurve2D.Float(xBE6, yBE4, xBE7, yBE5, xBE8, yBE4);
                        g2d.draw(bocaE1);
                        g2d.fill(bocaE1);
                        break;
                    // Dormido
                    case 4:
                        int yND = (y-r)+(r*35)/100;
                        g.drawString(nom, xN, yND);
                        int yBD1 = (y-r)+(r*60)/100;
                        int xBD1 = (x-r)+(r*70)/100;
                        int yBD2 = y;
                        int xBD2 = (x-r)+(r*95)/100;
                        QuadCurve2D ojoD1 = new QuadCurve2D.Float(x2, yBD1, xBD1, yBD2, xBD2, yBD1);
                        g2d.draw(ojoD1);
                        g2d.fill(ojoD1);
                        int xBD3 = (x-r)+(r*110)/100;
                        int xBD4 = (x-r)+(r*135)/100;
                        int xBD5 = (x-r)+(r*160)/100;
                        QuadCurve2D ojoD2 = new QuadCurve2D.Float(xBD3, yBD1, xBD4, yBD2, xBD5, yBD1);
                        g2d.draw(ojoD2);
                        g2d.fill(ojoD2);
                        int xBD6 = (x-r)+(r*80)/100;
                        int yBD4 = (y-r)+(r*120)/100;
                        int rBD1 = (r*40)/100;
                        g.fillOval(xBD6,yBD4,rBD1,rBD1);
                        break;
                    // Neutral
                    case 5:
                        g.fillOval(x2,y2,r2,r2);
                        g.fillOval(x3,y2, r2, r2);
                        g.drawString(nom, xN, yN);
                        int xBN1 = (x-r)+(r*50)/100;
                        int yBN1 = (y-r)+(r*140)/100;
                        g.fillRect(xBN1,yBN1,r,((r*10)/100));
                        break;
                    default:
                        break;
                }
            }else{
                System.out.println("Las Dimensiones de la figura exceden las dimensiones del Canvas");
                System.exit(0);
            }
        }
    }
}