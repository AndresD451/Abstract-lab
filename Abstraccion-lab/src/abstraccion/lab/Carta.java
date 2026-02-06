/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstraccion.lab;
import javax.swing.ImageIcon;
/**
 *
 * @author andres
 */
public abstract class Carta {
    protected String id;
    protected boolean descubierta;
    protected ImageIcon imagen;
    
   public Carta(String id){
       this.id=id;
       this.descubierta=false;
   }
   public abstract ImageIcon mostrarCarta();
   public abstract ImageIcon ocultarCarte();
   public boolean estaDescubierta(){
       return descubierta;
   }
   public void setDescubierta(boolean descubierta){
       this.descubierta=descubierta;
   }
   public String getId(){
       return id;
   }
   public void setImagen(ImageIcon imagen){
       this.imagen=imagen;
   }
}
