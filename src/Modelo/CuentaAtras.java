package Modelo;

/**
 * Clase que imprime los números del 10 al 0 haciendo una cuenta atrás.
 */
public class CuentaAtras {
    public String ejecutar() {
        StringBuilder salida = new StringBuilder();
        int num = 10;
        while (num >= 0) {
            salida.append(num).append("\n");
            num--;
        }
        return salida.toString();
    }
}
