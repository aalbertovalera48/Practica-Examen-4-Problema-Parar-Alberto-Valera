package Modelo;

/**
 * Interfaz Modelo.Manejador/ Handler.
 */
public interface Manejador {
    boolean puedeManejar(String programa);
    boolean detener(String programa);
}
