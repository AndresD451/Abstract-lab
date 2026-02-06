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
    private static ImageIcon reversa;
    public CartaPokemon(String id, String nombrePokemon){
        super(id);
        this.nombrePokemon=nombrePokemon;
        cargarImagenes();
    }
}
