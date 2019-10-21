package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.Border;

/**
 * Level3Sublevel1
 */
public class Level3Sublevel1 extends JFrame implements MouseListener {
    JLabel cuadro0;
    JLabel cuadro1;
    JLabel cuadro2;
    JLabel cuadro3;

    JLabel cuadro4_1;
    JLabel cuadro4_2;
    JLabel cuadro5_1;
    JLabel cuadro5_2;

    JLabel cuadro6;

    JLabel cuadro7_1;
    JLabel cuadro7_2;
    JLabel cuadro8_1;
    JLabel cuadro8_2;

    JLabel guisanteVerdeBoton;
    JLabel guisanteNaranjaBoton;

    ImageIcon guisanteVerde;
    ImageIcon guisanteGris;
    ImageIcon guisanteNaranja;
    ImageIcon guisanteCombinado;

    JLabel guisanteMovible;
    boolean isMousePressed = false;
    boolean flag = false;
    boolean estado;
    int contadorVerdes = 4;
    int contadorNaranjas = 4;
    Timer timer;
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        new Level3Sublevel1(1024, 768);
    }

    public Level3Sublevel1(int width, int height) {
        setLayout(null);
        setSize(width, height);
        Color bgColor = new Color(255, 255, 255);
        setBackground(bgColor);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(this);
        setTitle("cuadro de punnett");
        Font arial20 = new Font("Arial", Font.PLAIN, 20);
        Font arial50 = new Font("Arial", Font.BOLD, 50);

        JLabel titulo = new JLabel("Ubica los guisantes");
        titulo.setBounds(256, 24, 512, 56);
        titulo.setFont(arial50);
        add(titulo);

        guisanteGris = new ImageIcon(getClass().getResource("/images/Gris.png"));
        guisanteCombinado = new ImageIcon(getClass().getResource("/images/Combinado.png"));
        guisanteNaranja = new ImageIcon(getClass().getResource("/images/Naranja.png"));
        guisanteVerde = new ImageIcon(getClass().getResource("/images/Verde.png"));

        Color fg = new Color(47, 53, 66);
        Border border = BorderFactory.createLineBorder(fg, 2);

        guisanteMovible = new JLabel(guisanteCombinado);
        guisanteMovible.setBounds(0, 0, 56, 56);
        guisanteMovible.setVisible(false);
        add(guisanteMovible);

        cuadro0 = new JLabel(guisanteCombinado);
        cuadro0.setBounds(256, 110, 240, 180);
        cuadro0.setBorder(border);
        add(cuadro0);

        cuadro1 = new JLabel(guisanteNaranja);
        cuadro1.setBounds(256 + 240 - 2, 110, 240, 180);
        cuadro1.setBorder(border);
        add(cuadro1);

        cuadro2 = new JLabel(guisanteNaranja);
        cuadro2.setBounds(256 + 240 + 240 - 4, 110, 240, 180);
        cuadro2.setBorder(border);
        add(cuadro2);

        cuadro3 = new JLabel(guisanteVerde);
        cuadro3.setBounds(256, 110 + 180 - 2, 240, 180);
        cuadro3.setBorder(border);
        add(cuadro3);

        cuadro4_1 = new JLabel(guisanteGris);
        cuadro4_1.setBounds(256 + 240 - 2, 110 + 180 - 2, 120, 180);
        cuadro4_1.setBorder(border);
        add(cuadro4_1);
        cuadro4_2 = new JLabel(guisanteGris);
        cuadro4_2.setBounds(256 + +240 + 120 - 2, 110 + 180 - 2, 120, 180);
        cuadro4_2.setBorder(border);
        add(cuadro4_2);

        cuadro5_1 = new JLabel(guisanteGris);
        cuadro5_1.setBounds(256 + 240 + 240 - 2 - 2, 110 + 180 - 2, 120, 180);
        cuadro5_1.setBorder(border);
        add(cuadro5_1);
        cuadro5_2 = new JLabel(guisanteGris);
        cuadro5_2.setBounds(256 + 240 + 240 + 120 - 2 - 2, 110 + 180 - 2, 120, 180);
        cuadro5_2.setBorder(border);
        add(cuadro5_2);

        cuadro6 = new JLabel(guisanteVerde);
        cuadro6.setBounds(256, 110 + 180 + 180 - 2 - 2, 240, 180);
        cuadro6.setBorder(border);
        add(cuadro6);

        cuadro7_1 = new JLabel(guisanteGris);
        cuadro7_1.setBounds(256 + 240 - 2, 110 + 180 + 180 - 2 - 2, 120, 180);
        cuadro7_1.setBorder(border);
        add(cuadro7_1);
        cuadro7_2 = new JLabel(guisanteGris);
        cuadro7_2.setBounds(256 + 240 + 120 - 2, 110 + 180 + 180 - 2 - 2, 120, 180);
        cuadro7_2.setBorder(border);
        add(cuadro7_2);

        cuadro8_1 = new JLabel(guisanteGris);
        cuadro8_1.setBounds(256 + 240 + 240 - 4, 110 + 180 + 180 - 2 - 2, 120, 180);
        cuadro8_1.setBorder(border);
        add(cuadro8_1);
        cuadro8_2 = new JLabel(guisanteGris);
        cuadro8_2.setBounds(256 + 240 + 240 + 120 - 4, 110 + 180 + 180 - 2 - 2, 120, 180);
        cuadro8_2.setBorder(border);
        add(cuadro8_2);

        guisanteVerdeBoton = new JLabel(guisanteVerde);
        guisanteVerdeBoton.setBounds(48, 110 + 75, 150, 150);
        add(guisanteVerdeBoton);

        guisanteNaranjaBoton = new JLabel(guisanteNaranja);
        guisanteNaranjaBoton.setBounds(48, 110 + 75 + 150 + 24, 150, 150);
        add(guisanteNaranjaBoton);

        addMouseListener(this);
        setVisible(true);
    }

    private boolean estaEntreCoordenadas(int x, int y, JComponent componente) {
        if (x >= componente.getX() && x <= componente.getX() + componente.getWidth() && y >= componente.getY()
                && y <= componente.getY() + componente.getHeight()) {
            return true;
        }
        return false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        timer = new Timer(20, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Point posicionMouse = MouseInfo.getPointerInfo().getLocation();
                SwingUtilities.convertPointFromScreen(posicionMouse, guisanteMovible.getParent());
                int x = (int) posicionMouse.getX();
                int y = (int) posicionMouse.getY();

                if (!flag) {
                    if (estaEntreCoordenadas(x, y, guisanteNaranjaBoton)) {
                        guisanteMovible.setIcon(guisanteNaranja);
                        guisanteNaranjaBoton.setIcon(guisanteGris);
                        estado = false;
                    } else if (estaEntreCoordenadas(x, y, guisanteVerdeBoton)) {
                        guisanteMovible.setIcon(guisanteVerde);
                        guisanteVerdeBoton.setIcon(guisanteGris);
                        estado = true;
                    } else {
                        guisanteMovible.setVisible(false);
                        System.out.println("No fue apretado ningun guisante");
                        return;
                    }
                    flag = true;
                }
                guisanteMovible.setVisible(true);
                guisanteMovible.setBounds(x - 60, y - 60, 120, 120);
            }
        });
        timer.start();
        System.out.println("test");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        flag = false;
        Point posicionMouse = MouseInfo.getPointerInfo().getLocation();
        SwingUtilities.convertPointFromScreen(posicionMouse, guisanteMovible.getParent());
        int x = (int) posicionMouse.getX();
        int y = (int) posicionMouse.getY();
        isMousePressed = false;
        guisanteMovible.setVisible(false);
        timer.stop();
        if (!estado) {
            contadorNaranjas--;
            guisanteNaranjaBoton.setIcon(guisanteGris);
        } else {
            contadorVerdes--;
            guisanteVerdeBoton.setIcon(guisanteGris);
        }
        if (estaEntreCoordenadas(x, y, cuadro4_1)) {
            cuadro4_1.setIcon(guisanteMovible.getIcon());
        } else if (estaEntreCoordenadas(x, y, cuadro4_2)) {
            cuadro4_2.setIcon(guisanteMovible.getIcon());
        } else if (estaEntreCoordenadas(x, y, cuadro5_1)) {
            cuadro5_1.setIcon(guisanteMovible.getIcon());
        } else if (estaEntreCoordenadas(x, y, cuadro5_2)) {
            cuadro5_2.setIcon(guisanteMovible.getIcon());
        } else if (estaEntreCoordenadas(x, y, cuadro7_1)) {
            cuadro7_1.setIcon(guisanteMovible.getIcon());
        } else if (estaEntreCoordenadas(x, y, cuadro7_2)) {
            cuadro7_2.setIcon(guisanteMovible.getIcon());
        } else if (estaEntreCoordenadas(x, y, cuadro8_1)) {
            cuadro8_1.setIcon(guisanteMovible.getIcon());
        } else if (estaEntreCoordenadas(x, y, cuadro8_2)) {
            cuadro8_2.setIcon(guisanteMovible.getIcon());
        } else {
            if (!estado) {
                contadorNaranjas++;
                guisanteNaranjaBoton.setIcon(guisanteNaranja);
            } else {
                contadorVerdes++;
                guisanteVerdeBoton.setIcon(guisanteVerde);
            }
        }

        System.out.println("check");

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }
}