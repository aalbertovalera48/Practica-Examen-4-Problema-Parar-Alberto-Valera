package Verificadores;

/**
 *  Clase Verificadores.HaltChecker que simula la decisión de si un programa se detiene o no.
 */
public class HaltChecker {
    public static String checkHalt(int program, int input) {
        if (program == 1 && input >= 0) {
            return "parar"; // Programa Modelo.Modelo.CuentaAtras no se detiene
        } else if (program == 2) {
            return "nunca"; // Programa Modelo.Modelo.CuentaInfinito se detiene
        } else {
            return "desconocido";
        }
    }
}

