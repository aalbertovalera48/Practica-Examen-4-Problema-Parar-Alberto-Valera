package Vista; /**
 * Clase Vista.Vista que crea la interfaz gráfica de la aplicación.
 */

import Controladores.Controlador;
import Modelo.Modelo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Vista {
    private Controlador controlador;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JFrame frame;
    private JButton btnCuentaAtras;
    private JButton btnCuentaInfinito;

    public Vista() {
        this.controlador = this.controlador;
        frame = new JFrame("Cuenta Atras e Infinito");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new FlowLayout());

        btnCuentaAtras = new JButton("Cuenta Atras");
        btnCuentaInfinito = new JButton("Cuenta Infinito");

        textArea1 = new JTextArea(10, 40);
        textArea2 = new JTextArea(10, 40);

        btnCuentaAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vista.this.controlador.ejecutarCuentaAtras();
            }
        });

        btnCuentaInfinito.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Vista.this.controlador.ejecutarCuentaInfinito();
            }
        });

        frame.add(btnCuentaAtras);
        frame.add(textArea1);
        frame.add(btnCuentaInfinito);
        frame.add(textArea2);
    }

    public void show() {
        frame.setVisible(true);
    }

    public JButton getBtnCuentaAtras() {
        return btnCuentaAtras;
    }


    public JButton getBtnCuentaInfinito() {
        return btnCuentaInfinito;
    }

    public void actualizarVista1(String mensaje) {
        textArea1.append(mensaje + "\n");
    }

    public void initControlador(Modelo modelo) {
        this.controlador = new Controlador(modelo, this);
        modelo.setControlador(this.controlador);
    }

    public Controlador getControlador() {
        return this.controlador;
    }

    public void setTextArea2(String text) {
        textArea2.setText(text);
    }
    public void setTextArea1(String text) {
        textArea1.setText(text);
    }
    public JTextArea getTextArea1() {
        return textArea1;
    }
    public JTextArea getTextArea2() {
        return textArea2;
    }



}