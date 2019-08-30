package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * VentanaJuego
 */
public class VentanaJuego extends JFrame implements ActionListener {
    private static final long serialVersionUID = -3710071963833250552L;
    private static final int width = 1024;
    private static final int height = 768;

    int nivel = 1;
    int subnivel = 0;
    int respuestasUsuario[] = new int[9];
    int preguntasContestadas = 0;
    int respuestasCorrectas[] = {0,0,0,0,0,0,0,0,0};

    private static JCheckBox opcionA;
    private static JCheckBox opcionB;
    private static JCheckBox opcionC;
    private static JCheckBox opcionD;
    private static JButton siguienteBoton;
    private static JLabel tituloPregunta;

    public VentanaJuego(int width, int height) {
        setLayout(null);
        setSize(width, height);
        Color bgColor = new Color(255, 255, 255);
        setBackground(bgColor);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font arial20 = new Font("Arial", Font.PLAIN, 20);
        // contenido = new JLabel("<html><body><p style='max-width: 200px'>Bueno pues se
        // supone que aquí debería ir tu juego, o tu teoría, realmente no sé como lo vas
        // a hacer, lo unico que sé es que ahora el boton de seguir si funciona
        // jasjasjsa, deja tu orgullo, puedes preguntarme cualquier mierda cuando
        // quieras. Creo que aunque yo complico todo, siempre voy a pensar que la
        // comunicación es la cosa más importante que puede existir. Lee los
        // comentarios. Te quiero. Aunque seas una desagradecida y digas que te borre el
        // proyecto >:(</html></body></p>");
        // contenido.setBounds(144, 144, 500, 400);
        // add(contenido);

        // updateLevelWindow(false);
        opcionA = new JCheckBox();
        opcionA.setFont(arial20);
        opcionA.setBackground(new Color(164, 176, 190));
        opcionA.setForeground(Color.BLACK);
        opcionA.setBounds(90, 191, 850, 80);
        opcionA.addActionListener(this);
        add(opcionA);

        opcionB = new JCheckBox();
        opcionB.setFont(arial20);
        opcionB.setBackground(new Color(164, 176, 190));
        opcionB.setForeground(Color.BLACK);
        opcionB.setBounds(90, 291, 850, 80);
        opcionB.addActionListener(this);
        add(opcionB);

        opcionC = new JCheckBox();
        opcionC.setFont(arial20);
        opcionC.setBackground(new Color(164, 176, 190));
        opcionC.setForeground(Color.BLACK);
        opcionC.setBounds(90, 391, 850, 80);
        opcionC.addActionListener(this);
        add(opcionC);

        opcionD = new JCheckBox();
        opcionD.setFont(arial20);
        opcionD.setBackground(new Color(164, 176, 190));
        opcionD.setForeground(Color.BLACK);
        opcionD.setBounds(90, 491, 850, 80);
        opcionD.addActionListener(this);
        add(opcionD);

        siguienteBoton = new RoundJButton(35);
        siguienteBoton.setFont(arial20);
        siguienteBoton.setBackground(new Color(47, 53, 66));
        siguienteBoton.setForeground(new Color(255, 255, 255));
        siguienteBoton.setBounds(640, 660, 280, 60);
        siguienteBoton.setText("Seguir");
        siguienteBoton.addActionListener(this);
        siguienteBoton.setVisible(false);
        siguienteBoton.setEnabled(false);
        add(siguienteBoton);

        tituloPregunta = new JLabel();
        tituloPregunta.setFont(arial20);
        tituloPregunta.setForeground(Color.BLACK);
        tituloPregunta.setBounds(132, 72, 800, 100);
        add(tituloPregunta);

        actualizarSubnivel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object boton = e.getSource();
        if (boton == opcionA) {
            if (opcionA.isSelected()) {
                reiniciarOpciones();
                opcionA.setSelected(true);
                opcionA.setBackground(new Color(123, 237, 159));
                siguienteBoton.setVisible(true);
                siguienteBoton.setEnabled(true);
            } else {
                reiniciarOpciones();
            }
        } else if (boton == opcionB) {
            if (opcionB.isSelected()) {
                reiniciarOpciones();
                opcionB.setSelected(true);
                opcionB.setBackground(new Color(123, 237, 159));
                siguienteBoton.setVisible(true);
                siguienteBoton.setEnabled(true);
            } else {
                reiniciarOpciones();
            }
        } else if (boton == opcionC) {
            if (opcionC.isSelected()) {
                reiniciarOpciones();
                opcionC.setSelected(true);
                opcionC.setBackground(new Color(123, 237, 159));
                siguienteBoton.setVisible(true);
                siguienteBoton.setEnabled(true);
            } else {
                reiniciarOpciones();
            }
        } else if (boton == opcionD) {
            if (opcionD.isSelected()) {
                reiniciarOpciones();
                opcionD.setSelected(true);
                opcionD.setBackground(new Color(123, 237, 159));
                siguienteBoton.setVisible(true);
                siguienteBoton.setEnabled(true);
            } else {
                reiniciarOpciones();
            }
        }else if(boton == siguienteBoton){
            if(opcionA.isSelected()){
                respuestasUsuario[preguntasContestadas] = 0;
            } else if(opcionB.isSelected()){
                respuestasUsuario[preguntasContestadas] = 1;
            } else if(opcionC.isSelected()){
                respuestasUsuario[preguntasContestadas] = 2;
            } else if(opcionD.isSelected()){
                respuestasUsuario[preguntasContestadas] = 3;
            }
            reiniciarOpciones();
            actualizarSubnivel();
            preguntasContestadas++;
        }
    }

    private void reiniciarOpciones() {
        opcionA.setSelected(false);
        opcionB.setSelected(false);
        opcionC.setSelected(false);
        opcionD.setSelected(false);

        opcionA.setBackground(new Color(164, 176, 190));
        opcionB.setBackground(new Color(164, 176, 190));
        opcionC.setBackground(new Color(164, 176, 190));
        opcionD.setBackground(new Color(164, 176, 190));

        siguienteBoton.setVisible(false);
        siguienteBoton.setEnabled(false);
    }

    private void setTitulos(int nivel, int subnivel) {
        final String[] preguntasNivel1 = { "Pregunta Nivel 1-1", "Pregunta Nivel 1-2", "Pregunta Nivel 1-3" };
        final String[] preguntasNivel2 = { "Pregunta Nivel 2-1", "Pregunta Nivel 2-2", "Pregunta Nivel 2-3" };
        final String[] preguntasNivel3 = { "Pregunta Nivel 3-1", "Pregunta Nivel 3-2", "Pregunta Nivel 3-3" };
        String[] opciones = new String[4];
        final String[] opcionesNivel1_1 = { "A. Ejemplo A Nivel 1-1", "B. Ejemplo B Nivel 1-1",
                "C. Ejemplo C Nivel 1-1", "D. Ejemplo D Nivel 1-1" };
        final String[] opcionesNivel1_2 = { "A. Ejemplo A Nivel 1-2", "B. Ejemplo B Nivel 1-2",
                "C. Ejemplo C Nivel 1-1", "D. Ejemplo D Nivel 1-2" };
        final String[] opcionesNivel1_3 = { "A. Ejemplo A Nivel 1-3", "B. Ejemplo B Nivel 1-3",
                "C. Ejemplo C Nivel 1-1", "D. Ejemplo D Nivel 1-3" };

        final String[] opcionesNivel2_1 = { "A. Ejemplo A Nivel 2-1", "B. Ejemplo B Nivel 2-1",
                "C. Ejemplo C Nivel 2-1", "D. Ejemplo D Nivel 2-1" };
        final String[] opcionesNivel2_2 = { "A. Ejemplo A Nivel 2-2", "B. Ejemplo B Nivel 2-2",
                "C. Ejemplo C Nivel 2-2", "D. Ejemplo D Nivel 2-2" };
        final String[] opcionesNivel2_3 = { "A. Ejemplo A Nivel 2-3", "B. Ejemplo B Nivel 2-3",
                "C. Ejemplo C Nivel 2-2", "D. Ejemplo D Nivel 2-3" };

        final String[] opcionesNivel3_1 = { "A. Ejemplo A Nivel 3-1", "B. Ejemplo B Nivel 3-1",
                "C. Ejemplo C Nivel 3-1", "D. Ejemplo D Nivel 3-1" };
        final String[] opcionesNivel3_2 = { "A. Ejemplo A Nivel 3-2", "B. Ejemplo B Nivel 3-2",
                "C. Ejemplo C Nivel 3-2", "D. Ejemplo D Nivel 3-2" };
        final String[] opcionesNivel3_3 = { "A. Ejemplo A Nivel 3-3", "B. Ejemplo B Nivel 3-3",
                "C. Ejemplo C Nivel 3-3", "D. Ejemplo D Nivel 3-3" };
        switch (nivel) {
        case 1:
            if (subnivel == 1) {
                opciones = opcionesNivel1_1;
            } else if (subnivel == 2) {
                opciones = opcionesNivel1_2;
            } else if (subnivel == 3) {
                opciones = opcionesNivel1_3;
            }
            tituloPregunta.setText(preguntasNivel1[subnivel-1]);
            break;
        case 2:
            if (subnivel == 1) {
                opciones = opcionesNivel2_1;
            } else if (subnivel == 2) {
                opciones = opcionesNivel2_2;
            } else if (subnivel == 3) {
                opciones = opcionesNivel2_3;
            }
            tituloPregunta.setText(preguntasNivel2[subnivel-1]);
            break;
        case 3:
            if (subnivel == 1) {
                opciones = opcionesNivel3_1;
            } else if (subnivel == 2) {
                opciones = opcionesNivel3_2;
            } else if (subnivel == 3) {
                opciones = opcionesNivel3_3;
            }
            tituloPregunta.setText(preguntasNivel3[subnivel-1]);
            break;
        }
        opcionA.setText(opciones[0]);
        opcionB.setText(opciones[1]);
        opcionC.setText(opciones[2]);
        opcionD.setText(opciones[3]);
    }

    private void actualizarSubnivel() {
        int MAXIMO_SUBNIVEL = 3;
        int MAXIMO_NIVEL = 3;
        if (nivel == MAXIMO_NIVEL) {
            if (subnivel == MAXIMO_SUBNIVEL) {
                preguntasContestadas = 0;
                evaluar();
                return;
            } else {
                subnivel++;
            }
        } else {
            if (subnivel == MAXIMO_SUBNIVEL) {
                subnivel = 1;
                nivel++;
            } else {
                subnivel++;
            }
        }
        setTitulos(nivel, subnivel);
    }

    private void evaluar() {
        int contadorAciertos = 0;
        for(int i = 0; i < respuestasCorrectas.length; i++){
            if(respuestasUsuario[i] == respuestasCorrectas[i])
                contadorAciertos++;
        }
        System.out.println("El usuario acerto "+contadorAciertos+" preguntas");
    }
}