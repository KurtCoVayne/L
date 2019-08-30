
package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Principal extends JFrame implements ActionListener {
    // private declara que otra clase puede ver la variable, static como otra clase
    // puede acceder a la variable, y final sirve para declarar una constante

    private static final long serialVersionUID = 3105625355772391585L; // Esto sirve para que el compilador sepa como
                                                                       // manejar los archivos, se llama serialización
                                                                       // de clases y probablemente nunca nos lo
                                                                       // enseñen, yo lo hago, porque me gusta, pero en
                                                                       // netbeans no es necesario
    private static final int width = 1024;
    private static final int height = 768;

    private static JButton registro;
    private static JButton i_sesion;

    private static final Color bgColor = new Color(255, 255, 255); // Background color
    private static final Font arialBold32 = new Font("Arial", Font.BOLD, 32);
    private static final Font arial60 = new Font("Arial", Font.PLAIN, 60);

    public static void main(String[] args) {
        new Principal();
    }

    public Principal() {

        // Inicializando las funciones principales de un JFrame, como su tamaño, su
        // titulo, el color de fondo y que debe hacer cuando le des al botón de salir
        setSize(width, height);
        setTitle("Prueba Genética");
        setLocationRelativeTo(this);
        getContentPane().setBackground(bgColor);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Bajo mi opinion la mejor forma de hacer los cositos en Java es declarando en
        // bloque como el siguiente, la unica condición es que lo primero debe ser la
        // instancia y lo ultimo añadirlo
        JLabel titleLabel = new JLabel("Prueba Genética");
        titleLabel.setForeground(Color.BLACK);// Color de la letra
        titleLabel.setFont(arial60); // letra y su tamaño, está instanciada como una variable al principio
        titleLabel.setBounds(300, 85, 500, 85); // posicion
        add(titleLabel);

        registro = new RoundJButton(35); // hashash Felipe quería bordes redondeados, el numero es el radio del borde
                                         // del boton
        registro.setText("Registro");
        registro.setForeground(Color.BLACK);
        registro.setFont(arialBold32);
        registro.setBackground(Color.gray); // Cambia los colores si quieres, para poner un color distinto tiene que
                                            // poner new Color(r, g, b); donde r g y b son los numero que definen el
                                            // color, buscalos en google
        registro.setBounds(385, 380, 250, 100);
        registro.addActionListener(this);
        add(registro);

        i_sesion = new RoundJButton(35); // hashash Felipe quería bordes redondeados entonces yo le puse una clase que
                                         // cree para mi proyecto, aun así, les sigo recomendando usar imagenes para los
                                         // botones redondeados, así es IMPOSIBLE que Mata Duques les ponga problema
        i_sesion.setText("Iniciar sesión");
        i_sesion.setForeground(Color.BLACK);
        i_sesion.setFont(arialBold32);
        i_sesion.setBackground(Color.gray);
        i_sesion.setBounds(385, 212, 250, 100);
        i_sesion.addActionListener(this);
        add(i_sesion);
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // e es el evento que ocurre jasjasj, el profesor no explico eso
        Object boton = e.getSource(); // todo en Java es un objeto
        if (boton == registro) {
            dispose(); // Dispose es para cerrar una ventana, entonces lo que hago aqui es cerrar la
                       // ventana actual y abrir una nueva
            new VentanaRegistro(width, height);
        } else if (boton == i_sesion) {
            dispose();
            new VentanaInicioSesion(width, height);
            } else if (boton == i_sesion) {
            dispose();
        }
    }
}