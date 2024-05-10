package Controladores;

import Modelo.Modelo;
import Vista.Vista;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * La clase Controladores.Controlador se encarga de la interacción entre las clases Modelo.Modelo y Vista.Vista.
 */
public class Controlador {
    private Modelo modelo;
    private Vista vista;

    /**
     * Constructor para la clase Controladores.Controlador.
     *
     * @param modelo el objeto Modelo.Modelo con el que interactuará este Controladores.Controlador
     * @param vista el objeto Vista.Vista con el que interactuará este Controladores.Controlador
     */
    public Controlador(Modelo modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.vista.getBtnCuentaAtras().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        modelo.ejecutarCuentaAtras();
                        return null;
                    }

                    @Override
                    protected void done() {
                        // No hay nada que hacer aquí ya que no estamos devolviendo nada desde doInBackground
                    }
                };
                worker.execute();
            }
        });
        this.vista.getBtnCuentaInfinito().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        modelo.ejecutarCuentaInfinito();
                        return null;
                    }

                    @Override
                    protected void done() {
                        // No hay nada que hacer aquí ya que no estamos devolviendo nada desde doInBackground
                    }
                };
                worker.execute();
            }
        });
    }

    /**
     * Ejecuta la cuenta atrás.
     */
    public void ejecutarCuentaAtras() {
        modelo.ejecutarCuentaAtras();
    }

    /**
     * Ejecuta la cuenta infinita.
     */
    public void ejecutarCuentaInfinito() {
        modelo.ejecutarCuentaInfinito();
    }

    /**
     * Actualiza la primera vista con el mensaje dado.
     *
     * @param mensaje el mensaje a mostrar en la primera vista
     */
    public void actualizarVista1(String mensaje) {
        vista.actualizarVista1(mensaje);
    }

    /**
     * Actualiza la segunda vista con el mensaje dado.
     *
     * @param mensaje el mensaje a mostrar en la segunda vista
     */
    public void actualizarVista2(String mensaje) {
        vista.setTextArea2(mensaje);
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;

    }

    public void setVista(Vista vista) {
        this.vista = vista;
    }
}
