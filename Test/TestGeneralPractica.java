/**
 * Test general de la aplicación de la práctica.
 */
import Controladores.Controlador;
import Controladores.Reverser;
import Excepciones.CuentaException;
import Modelo.Modelo;
import Verificadores.HaltChecker;
import Verificadores.VerificadorParadaPrograma;
import Vista.Vista;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.swing.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGeneralPractica {

    private Vista vista;
    private Modelo modelo;
    private Controlador controlador;

    @BeforeEach
    public void setUp() {
        vista = new Vista();
        modelo = new Modelo(null, vista);
        vista.initControlador(modelo);
        controlador = vista.getControlador();
    }

    @Test
    public void testCuentaAtras() throws InterruptedException {
        JTextArea textArea1 = vista.getTextArea1();
        JButton btnCuentaAtras = vista.getBtnCuentaAtras();

        // Simula hacer clic en el botón de cuenta atrás
        btnCuentaAtras.doClick();

        // Espera un poco para que el hilo de fondo se ejecute y actualice el área de texto
        TimeUnit.SECONDS.sleep(1);

        // Comprueba si el área de texto 1 se ha actualizado correctamente
        String expectedText = ("El proceso se para y Controladores.Reverser entra en un bucle infinito\nEl proceso se para y Controladores.Reverser entra en un bucle infinito\n");
        assertEquals(expectedText, textArea1.getText(), "Cuenta atrás no funciona correctamente");
    }

    @Test
    public void testCuentaInfinito() throws InterruptedException {
        JTextArea textArea2 = vista.getTextArea2();
        JButton btnCuentaInfinito = vista.getBtnCuentaInfinito();

        // Simula hacer clic en el botón de cuenta infinito
        btnCuentaInfinito.doClick();

        // Espera un poco para que el hilo de fondo se ejecute y actualice el área de texto
        TimeUnit.SECONDS.sleep(2);

        // Comprueba si el área de texto 2 se ha actualizado correctamente
        String expectedText = "El proceso no se para. Por lo que Controladores.Reverser se detiene";
        assertEquals(expectedText, textArea2.getText(), "Cuenta infinito no funciona correctamente");
    }

    @Test
    public void testReverser() throws InterruptedException {
        final String[] actualResult = new String[1];
        final CountDownLatch latch = new CountDownLatch(1);

        // Ejecuta Controladores.Reverser en un hilo separado
        new Thread(() -> {
            Reverser reverser = new Reverser(controlador, modelo);
            reverser.ejecutar("Modelo.Modelo.CuentaInfinito");
            actualResult[0] = vista.getTextArea2().getText();
            latch.countDown();
        }).start();

        // Espera a que Controladores.Reverser termine de ejecutarse
        latch.await(1, TimeUnit.SECONDS);

        // Comprueba si Controladores.Reverser se ejecutó correctamente
        String expectedText = "El proceso no se para. Por lo que Controladores.Reverser se detiene";
        assertEquals(expectedText, actualResult[0], "Controladores.Reverser no funciona correctamente");
    }

    @Test
    public void CuentaExceptionTest() {
        Exception cause = new Exception("Esta es la causa");
        CuentaException exception = new CuentaException("Este es el mensaje", cause);

        assertEquals("Este es el mensaje", exception.getMessage());
        assertEquals(cause, exception.getCause());
    }


    @Test
    public void testCheckHalt() {
        assertEquals("parar", HaltChecker.checkHalt(1, 0));
        assertEquals("nunca", HaltChecker.checkHalt(2, 0));
        assertEquals("desconocido", HaltChecker.checkHalt(3, 0));
    }
    @Test
    public void testDetener() {
        VerificadorParadaPrograma verificador = new VerificadorParadaPrograma();

        assertEquals("parar", verificador.detener("Modelo.Modelo.CuentaAtras"));
        assertEquals("nunca", verificador.detener("Modelo.Modelo.CuentaInfinito"));
    }
    @Test
    public void testActualizarVista1() {
        vista.actualizarVista1("Test message");
        assertEquals("Test message\n", vista.getTextArea1().getText());
    }

    @Test
    public void testSetTextArea1() {
        vista.setTextArea1("Test message");
        assertEquals("Test message", vista.getTextArea1().getText());
    }

    @Test
    public void testSetTextArea2() {
        vista.setTextArea2("Test message");
        assertEquals("Test message", vista.getTextArea2().getText());
    }

    @Test
    public void testGetTextArea1() {
        vista.setTextArea1("Test message");
        assertEquals("Test message", vista.getTextArea1().getText());
    }

    @Test
    public void testGetTextArea2() {
        vista.setTextArea2("Test message");
        assertEquals("Test message", vista.getTextArea2().getText());
    }
}



/*@Test
public void testReverser2() throws InterruptedException {
    final String[] actualResult = new String[1];
    final CountDownLatch latch = new CountDownLatch(1);
    JTextArea textArea1 = vista.getTextArea1();
    JButton btnCuentaAtras = vista.getBtnCuentaAtras();

    // Ejecuta Controladores.Reverser en un hilo separado
    new Thread(() -> {
        Controladores.Reverser reverser = new Controladores.Reverser(controlador, modelo);
        reverser.ejecutar("Modelo.Modelo.CuentaAtras");
        actualResult[0] = vista.getTextArea1().getText();
        latch.countDown();
    }).start();

    // Espera a que Controladores.Reverser termine de ejecutarse
    latch.await(1, TimeUnit.SECONDS);

    // Comprueba si Controladores.Reverser se ejecutó correctamente
    String expectedText = ("El proceso se para y Controladores.Reverser entra en un bucle infinito");
    assertEquals(expectedText, actualResult[0], "Controladores.Reverser no funciona correctamente");
}
}
 */

