package Verificadores;

import Modelo.Manejador;

/**
 * Clase Verificadores.VerificadorParada que implementa la interfaz Modelo.Manejador y verifica si un programa se detiene o no.
 */
// Implementar la clase concreta Verificadores.HaltChecker
public class VerificadorParada implements Manejador {
    private Manejador siguienteManejador;

    @Override
    public boolean puedeManejar(String programa) {
        return true; // Por simplicidad, siempre maneja la solicitud
    }

    @Override
    public boolean detener(String programa) {
        // Por simplicidad, asumimos que el programa siempre se detiene
        return true;
    }

    public void setSiguienteManejador(Manejador siguienteManejador) {
        this.siguienteManejador = siguienteManejador;
    }

    public boolean tieneSiguienteManejador() {
        return siguienteManejador != null;
    }

    public boolean siguiente(String programa) {
        if (siguienteManejador != null && siguienteManejador.puedeManejar(programa)) {
            return siguienteManejador.detener(programa);
        }
        return false;
    }
}
