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
        creacionComponentes();
    }
    
    
    private void configuracionVentana(){
        setTitle("Pokemon Match");
        setSize(640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(false);
    }
    
    private void creacionComponentes(){
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));
        
        JLabel lblTitulo = new JLabel("Pokemon Match"); 
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 28));
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblTitulo.setForeground(new Color(200, 50, 50));
      
        
        
        
        JPanel panelJugador1 = new JPanel();
        panelJugador1.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel lblJugador1 = new JLabel("Jugador 1:");
        lblJugador1.setFont(new Font("Arial", Font.BOLD, 18));
        jugador1 = new JTextField(20);
        jugador1.setFont(new Font("Arial", Font.BOLD, 16));
        panelJugador1.add(lblJugador1);
        panelJugador1.add(jugador1);
        
        
        JPanel panelJugador2 = new JPanel();
        panelJugador2.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel lblJugador2 = new JLabel("Jugador 2:");
        lblJugador2.setFont(new Font("Arial", Font.BOLD, 18));
        jugador2 = new JTextField(20);
        jugador2.setFont(new Font("Arial", Font.BOLD, 16));
        panelJugador2.add(lblJugador2);
        panelJugador2.add(jugador2);
        
        
        btnIniciar = new JButton("Iniciar Juego");
        btnIniciar.setFont(new Font("Arial", Font.BOLD, 20));
        btnIniciar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnIniciar.setBackground(new Color(100, 200, 100));
        btnIniciar.setForeground(Color.WHITE);
        btnIniciar.setFocusPainted(false);
        
          btnIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               iniciarJuego();
            }
        });
        
    //panelPrincipal.add(Box.createVerticalStrut(20));
        panelPrincipal.add(lblTitulo);
        panelPrincipal.add(Box.createVerticalStrut(40));
        panelPrincipal.add(panelJugador1);
        panelPrincipal.add(Box.createVerticalStrut(20));
        panelPrincipal.add(panelJugador2);
        panelPrincipal.add(Box.createVerticalStrut(40));
        panelPrincipal.add(btnIniciar);
        
        add(panelPrincipal, BorderLayout.CENTER);
        
        
    }
        
    private void iniciarJuego(){
        String nombreJugador1 = jugador1.getText().trim();
        String nombreJugador2 = jugador2.getText().trim();
        
        if (nombreJugador1.isEmpty() || nombreJugador2.isEmpty())
            JOptionPane.showMessageDialog(rootPane, "Algun jugador no tiene nombre");
        
        if(nombreJugador1.equals(nombreJugador2))
            JOptionPane.showMessageDialog(rootPane, "Los nombres no pueden repetirse");
            
        Jugador jugador1 = new Jugador(nombreJugador1);
        Jugador jugador2 = new Jugador(nombreJugador2);
        
 VentanaJuego ventanaJuego = new VentanaJuego(jugador1, jugador2);
ventanaJuego.setVisible(true);
dispose();
        
        
        
    }
        
        
    }
    
    

