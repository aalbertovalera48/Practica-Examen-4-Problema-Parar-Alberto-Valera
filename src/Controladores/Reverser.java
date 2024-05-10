package Controladores;

import Modelo.Modelo;
import Verificadores.VerificadorParadaPrograma;
import Vista.Vista;

/**
 * Clase Controladores.Reverser que ejecuta el programa de cuenta atrás o infinito según el resultado de Verificadores.HaltChecker.
 */
public class Reverser {
    private VerificadorParadaPrograma haltChecker;
    private Controlador controlador;
    private Modelo modelo;
    Vista vista = new Vista();

    public Reverser(Controlador controlador, Modelo modelo) {
        this.haltChecker = new VerificadorParadaPrograma();
        this.controlador = controlador;
        this.modelo = modelo;
    }

    public void ejecutar(String programa) {
        String resultado = haltChecker.detener(programa);
        if (resultado.equals("parar")) {
            modelo.ejecutarCuentaAtras();
        } else if (resultado.equals("nunca")) {
            modelo.ejecutarCuentaInfinito();
        } else {
            vista.actualizarVista1("Estado del programa desconocido.");
        }
    }
}