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
 public int puntaje; 
 
 public Jugador(String Player){
     this.Player = Player;      
<<<<<<< HEAD
     puntaje = 0; //igualmente
=======
     
     puntaje = 0;
>>>>>>> 797e3c612495822b53b81bf51082eb8eaf9d604f
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
<<<<<<< HEAD
=======

    String getPlayer() {
        return Player;
    }
>>>>>>> 797e3c612495822b53b81bf51082eb8eaf9d604f
 
 
}
