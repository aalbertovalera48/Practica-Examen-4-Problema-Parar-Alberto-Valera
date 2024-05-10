package Excepciones;

/**
 * Clase que representa una excepción de la Cuenta de los números hacia átras o al infinito.
 */
public class CuentaException extends Exception {
    public CuentaException(String message, Throwable cause) {
        super(message, cause);
    }
}