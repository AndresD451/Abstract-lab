/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstraccion.lab;
import javax.swing.ImageIcon;
import java.awt.Image;
/**
 *
 * @author andres
 */
public class CartaPokemon extends Carta {
    private String nombrePokemon;
    private static ImageIcon reverso;
    public CartaPokemon(String id, String nombrePokemon){
        super(id);
        this.nombrePokemon=nombrePokemon;
        cargarImagenes();
    }
    private void cargarImagenes(){
        try{
            String rutaImagen="/abstraccion/lab/resources/imagenes/"+nombrePokemon.toLowerCase()+".png";
            ImageIcon imagenOriginal=new ImageIcon(getClass().getResource(rutaImagen));
            Image img=imagenOriginal.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
            this.imagen=new ImageIcon(img);
            if(reverso==null){
                ImageIcon reversoOriginal=new ImageIcon(getClass().getResource("/abstraccion/lab/resources/imagenes/reverso.png"));
                Image imgReverso=reversoOriginal.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                reverso=new ImageIcon(imgReverso);
            }
            
        }
        catch(Exception e){
            System.out.println("Error al cargar imagen: "+nombrePokemon);
            this.imagen=new ImageIcon();
            if(reverso==null){
                reverso=new ImageIcon();
            }
            
        }
    }

    @Override
    public ImageIcon mostrarCarta() {
         this.descubierta=true;
         return imagen;
    }

    @Override
    public ImageIcon ocultarCarta(){
        this.descubierta=false;
        return reverso;
    }
    public String getNombrePokemon(){
        return nombrePokemon;
    }
    
}
