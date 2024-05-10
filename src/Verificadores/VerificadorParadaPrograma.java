package Verificadores;

/**
 * Clase Verificadores.VerificadorParada que verifica si un programa se detiene o no según el checkeo de Verificadores.HaltChecker.

 */
public class VerificadorParadaPrograma {
    public String detener(String programa) {
        int programId = programa.equals("Modelo.Modelo.CuentaAtras") ? 1 : 2;
        String result = HaltChecker.checkHalt(programId, 0);
        return result;
    }
}