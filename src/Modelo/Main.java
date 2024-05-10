package Modelo;

import Controladores.Reverser;
import Vista.Vista;


/**
 * Clase Modelo.Main que ejecuta los programas Countdown, Countup, Verificadores.HaltChecker y Controladores.Reverser.
 */

public class Main {
    public static void main(String[] args) {
        Vista vista = new Vista();
        Modelo modelo = new Modelo(null, vista);
        vista.initControlador(modelo);
        Reverser reverser = new Reverser(vista.getControlador(), modelo);
        vista.show();
    }
}