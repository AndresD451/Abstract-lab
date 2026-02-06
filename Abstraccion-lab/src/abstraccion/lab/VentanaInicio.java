/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abstraccion.lab;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 *
 * @author user
 */
public class VentanaInicio extends JFrame {
    private JTextField jugador1;
    private JTextField jugador2;
    private JButton btnIniciar;
    
    
    public VentanaInicio (){
        configuracionVentana();
    }
    
    
    private void configuracionVentana(){
        setTitle("Juego de Memoria Pokemon");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
    }
    
    
    
    
}
