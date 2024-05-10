package Modelo; /**
 * Clase Modelo.Modelo que controla las acciones de la vista y el controlador.
 */

import Controladores.Controlador;
import Vista.Vista;

import javax.swing.*;
import java.util.List;

public class Modelo {
    private Controlador controlador;
    private Vista vista;

    public Modelo(Controlador controlador, Vista vista) {
        this.controlador = controlador;
        this.vista = vista;
    }
    public void setControlador (Controlador controlador){
        this.controlador = controlador;
    }

    public void ejecutarCuentaInfinito () {
        controlador.actualizarVista2("El proceso no se para. Por lo que Controladores.Reverser se detiene");
    }

    public void ejecutarCuentaAtras() {
        SwingWorker<Void, String> worker = new SwingWorker<Void, String>() {
            @Override
            protected Void doInBackground() throws Exception {
                try {
                    while (!isCancelled()) {
                        String message = "El proceso se para y Controladores.Reverser entra en un bucle infinito";
                        publish(message);
                        Thread.sleep(1000);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void process(List<String> chunks) {
                for (String text : chunks) {
                    vista.actualizarVista1(text);
                }
            }
        };
        worker.execute();
    }
    }