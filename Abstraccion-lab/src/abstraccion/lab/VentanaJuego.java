/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abstraccion.lab;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author diego
 */
public class VentanaJuego extends JFrame {

    private int filas = 6;
    private int columnas = 6;
    private int parejas = 18;
    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador jugadoractual;
    private Carta[][] tablero;
    private JButton[][] botones;
    private ArrayList<Carta> cartas;
    private JLabel Turnoactual;
    private JLabel puntajep1;
    private JLabel puntajep2;
    private Carta carta1;
    private Carta carta2;
    private JButton boton1;
    private JButton boton2;
    private int clicks;
    private boolean procesarturno;

    //constructor de la ventana de juego
    public VentanaJuego(Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.jugadoractual = jugador1;
        this.clicks = 0;
        this.procesarturno = false;
        confVentana();
        componentes();
    }

    //propiedades de la ventana
    private void confVentana() {
        setTitle("Juego de Memoria Pokemon");
        setSize(800, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
    }

    // componentes de la ventana
    private void componentes() {
        //panel superior
        JPanel panelInfo = new JPanel(new GridLayout(3, 1, 5, 5));
        panelInfo.setBackground(new Color(100, 150, 200));
        panelInfo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        Turnoactual = new JLabel("Turno: " + jugadoractual.getPlayer(), SwingConstants.CENTER);
        Turnoactual.setFont(new Font("Arial", Font.BOLD, 24));
        Turnoactual.setForeground(Color.WHITE);

        puntajep1 = new JLabel(jugador1.getPlayer() + ": 0 aciertos", SwingConstants.CENTER);
        puntajep1.setFont(new Font("Arial", Font.BOLD, 20));
        puntajep1.setForeground(new Color(255, 255, 100));

        puntajep2 = new JLabel(jugador2.getPlayer() + ": 0 aciertos", SwingConstants.CENTER);
        puntajep2.setFont(new Font("Arial", Font.BOLD, 20));
        puntajep2.setForeground(new Color(255, 255, 100));

        panelInfo.add(Turnoactual);
        panelInfo.add(puntajep1);
        panelInfo.add(puntajep2);

        //Panel del tablero
        JPanel paneltablero = new JPanel(new GridLayout(filas, columnas, 5, 5));
        paneltablero.setBackground(new Color(50, 50, 50));
        paneltablero.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        botones = new JButton[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                JButton boton = new JButton();
                boton.setFont(new Font("Arial", Font.BOLD, 16));
                boton.setFocusPainted(false);
                boton.setPreferredSize(new Dimension(100, 100));

                int fila = i;
                int columna = j;

                boton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        manejarclick(fila, columna, boton);
                    }
                });

                botones[1][j] = boton;
                paneltablero.add(boton);
            }
        }

        add(panelInfo, BorderLayout.NORTH);
        add(paneltablero, BorderLayout.CENTER);
    }

    public void iniciarJuego() {
        try {
            inicializartablero();
            mezclacarta();
            actualizartablero();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Fallo el inicio " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void inicializartablero() {
        tablero = new Carta[filas][columnas];
        cartas = new ArrayList<>();
        String[] Pokemons = {
            "pikachu", "bulbassur", "caterpie", "charizard", "charmander", "chikorita",
            "cyndaquill", "eevee", "gengar", "lucario", "nidoqueen",
            "piplup", "psyduck", "sandshrew", "snorlax",
            "squirtle", "totodile", "vaporeon", "zapdos"
                
                
        };

        // crear dos cartas de cada pokemon
        for (int i = 0; i < parejas; i++) {
            String id = "Pokemon-" + i;
            cartas.add(new CartaPokemon(id, Pokemons[i]));
            cartas.add(new CartaPokemon(id, Pokemons[i]));
        }
    }

    public void mezclacarta() {
        Collections.shuffle(cartas);

        int indice = 0;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero[i][j] = cartas.get(indice);
                indice++;
            }
        }
    }

    public void actualizartablero() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                Carta carta = tablero[i][j];
                JButton boton = botones[i][j];

                if (carta.estaDescubierta()) {
                    boton.setIcon(carta.mostrarCarta());
                    boton.setText("");
                } else {
                    boton.setIcon(carta.ocultarCarta());
                    boton.setText("?");
                }
            }
        }
    }

    public boolean juegoTerminado() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (!tablero[i][j].estaDescubierta()) {
                    return false;
                }
            }
        }
        return true;
    }

    //manejar clicks
    private void manejarclick(int filas, int columnas, JButton boton) {
        try {
            if (procesarturno) {
                return;
            }
            Carta carta = tablero[filas][columnas];

            if (carta.estaDescubierta()) {
                JOptionPane.showMessageDialog(this, "Esta carta ya ha sido descubierta, elige otra.", "Carta ya descubierta", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (clicks == 0) {
                carta1 = carta;
                boton1 = boton;
                carta1.setDescubierta(true);
                boton.setIcon(carta1.mostrarCarta());
                boton.setText("");
                clicks = 1;
            } else if (clicks == 1) {
                if (boton == boton1) {
                    JOptionPane.showMessageDialog(this, "Selecciona una carta diferente.", "Mismca carta", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                carta2 = carta;
                boton2 = boton;
                carta2.setDescubierta(true);
                boton.setIcon(carta2.mostrarCarta());
                boton.setText("");

                procesarturno = true;

                if (verificarPareja(carta1, carta2)) {
                    Timer timer = new Timer(600, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            jugadoractual.incrementarPuntaje();
                            actualizarpuntaje();
                            JOptionPane.showMessageDialog(VentanaJuego.this, "Excelente" + jugadoractual.getPlayer() + "encontro una pareja, siga jugando", "pareja encontrada", JOptionPane.INFORMATION_MESSAGE);
                            clicks = 0;
                            procesarturno = false;

                            if (juegoterminado()) {
                                finalizarpartida();
                            }
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                } else {
                    Timer timer = new Timer(1200, new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            carta1.setDescubierta(false);
                            carta2.setDescubierta(false);
                            boton1.setIcon(carta1.ocultarCarta());
                            boton1.setText("?");
                            boton2.setIcon(carta1.ocultarCarta());
                            boton2.setText("?");

                            clicks = 0;
                            procesarturno = false;
                            controlarTurnos();
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al procesar carta: " + e.getMessage(), "Rrror", JOptionPane.ERROR_MESSAGE);
            procesarturno = false;
        }
    }

    public boolean verificarPareja(Carta carta1, Carta carta2) {
        return carta1.getId().equals(carta2.getId());
    }

    public void controlarTurnos() {
        if (jugadoractual == jugador1) {
            jugadoractual = jugador2;
        } else {
            jugadoractual = jugador1;
        }
        Turnoactual.setText("Turno: " + jugadoractual.getPlayer());

    }

    public void actualizarpuntaje() {
        puntajep1.setText(jugador1.getPlayer() + ": " + jugador1.getAciertos() + " aciertos");
        puntajep2.setText(jugador1.getPlayer() + ": " + jugador1.getAciertos() + " aciertos");
    }

    public void finalizarpartida() {
        String mensaje;
        String titulo;
        if (jugador1.getAciertos() > jugador2.getAciertos()) {
            mensaje = " ¡" + jugador1.getNombre() + " ha ganado! \\n\\n"
                    + jugador1.getPlayer() + ": " + jugador1.getAciertos() + " aciertos\\n"
                    + jugador2.getPlayer() + ": " + jugador2.getAciertos() + " aciertos";
            titulo = "Tenemos un ganador";
        } else if (jugador2.getAciertos() > jugador1.getAciertos()) {
            mensaje = "¡" + jugador2.getPlayer() + " ha ganado! \\n\\n"
                    + jugador2.getPlayer() + ": " + jugador2.getAciertos() + " aciertos\\n"
                    + jugador1.getPlayer() + ": " + jugador1.getAciertos() + " aciertos";
            titulo = "Tenemos un ganador";
        } else {
            mensaje = "\" ¡Empate! \\\\n\\\\n\"" + "Ambos jugadores tienen " + jugador1.getAciertos() + " aciertos\\n"
                    + "¡Excelente partida!";
            titulo = "Empate";
        }

        int opcion = JOptionPane.showConfirmDialog(this, mensaje + "\\n\\nDESEA JUGAR OTRA PARTIDA", titulo, JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (opcion == JOptionPane.YES_OPTION) {
            dispose();
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    VentanaInicio vn = new VentanaInicio();
                    vn.setVisible(true);
                }
            });
        } else {
            System.exit(0);
        }
    }
}
