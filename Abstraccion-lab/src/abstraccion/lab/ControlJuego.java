/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstraccion.lab;

/**
 *
 * @author andres
 */
public interface ControlJuego {
    void iniciarJuego();
    void controlarTurnos();
    boolean verificarPareja(Carta carta1, Carta carta2);
    void finalizarPartida();
}
