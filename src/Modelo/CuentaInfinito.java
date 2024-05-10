package Modelo;

/**
 * Clase que imprime los números del 1 al infinito.
 */
public class CuentaInfinito {
    public String ejecutar() {
        int contador = 0;
        while (true) { // Bucle infinito
            System.out.println(contador);
            contador++;
        }
    }
}