/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abstraccion.lab;

/**
 *
 * @author user
 */
public class Jugador {
 private String Player;
 public int puntaje; //revisar despues la diferencia de public
 
 public Jugador(String Player){
     this.Player = Player;      
     puntaje = 0; //igualmente
 }
 
 public String obtenerNombrePlayer(){
     return Player;
 }
 
 
 public int mostrarPuntaje(){
     return puntaje;
 }
 
 
 public int incrementarPuntaje(){
     return puntaje++;
 }
 
 public void reiniciarPuntaje(){
     puntaje = 0;
 }
 
 public String toString(){
     return ("Jugador: " +Player + " Puntaje: " + puntaje);
 }
 
 
}
