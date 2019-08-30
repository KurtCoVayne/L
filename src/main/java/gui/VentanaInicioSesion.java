package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * VentanaInicioSesion
 */
public class VentanaInicioSesion extends JFrame implements ActionListener {
    private static final long serialVersionUID = -5211806330512415667L;
    
    private static final int width = 1024;
    private static final int height = 768;
    
    public JTextField usuarioCampo;
    
    private static JButton botonSeguir;

    public JPasswordField contraseñaCampo;

    private static JLabel adviceField;

    private static final Font helveticaBold12 = new Font("HelveticaNeue", Font.BOLD, 12);
    private static final Font helveticaBold34 = new Font("HelveticaNeue", Font.BOLD, 28);
    private static final Font helvetica32 = new Font("HelveticaNeue", Font.PLAIN, 32);

    FocusListener listenerBotonSeguir = new FocusListener() {
        @Override
        public void focusLost(FocusEvent e) {
        }

        @Override
        public void focusGained(FocusEvent e) {
            setPlaceHolders(); //Placeholder significa marcador de posición
        }
    };
    final FocusListener mFocusListener = new FocusListener() {

        @Override
        public void focusLost(FocusEvent e) {
        }

        @Override
        public void focusGained(FocusEvent e) {
            String passwordText = String.valueOf(contraseñaCampo.getPassword());
            if (passwordText.equals("")) {
                contraseñaCampo.setEchoChar((char) 0);
                contraseñaCampo.setText("Contraseña");
                contraseñaCampo.addFocusListener(pFocusListener);
            }
            usuarioCampo.setText("");
            usuarioCampo.removeFocusListener(this);
        }
    };
    final FocusListener pFocusListener = new FocusListener() {

        @Override
        public void focusLost(FocusEvent e) {

        }

        @Override
        public void focusGained(FocusEvent e) {
            String text = usuarioCampo.getText();
            if (text.equals("Correo") || text.equals("")) {
                usuarioCampo.setText("Correo");
                usuarioCampo.addFocusListener(mFocusListener);
            }
            contraseñaCampo.setText("");
            contraseñaCampo.setEchoChar('*');
            contraseñaCampo.removeFocusListener(this);
        }

    };

    public VentanaInicioSesion(int width, int height) {
        setLayout(null);
        setSize(width, height);
        Color bgColor = new Color(255, 255, 255);
        setBackground(bgColor);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Deje tu logo porque, no sé, ese dibujo me gusta mucho asjasj. Me encantan tus dibujos de verdad.
        ImageIcon logo = new ImageIcon(getClass().getResource("/images/Logo.png"));
        JLabel logoLabel = new JLabel(logo);
        logoLabel.setBounds(333, 13, 360, 350);
        add(logoLabel);

        usuarioCampo = new RoundJTextField(35);
        usuarioCampo.setFont(helvetica32);
        usuarioCampo.setText("Correo");
        usuarioCampo.setBackground(Color.GRAY);
        usuarioCampo.setForeground(new Color(0, 0, 0));
        usuarioCampo.setBounds(345, 404, 440, 84);

        usuarioCampo.addFocusListener(mFocusListener);
        add(usuarioCampo);

        contraseñaCampo = new RoundJPassField(35);
        contraseñaCampo.setFont(helvetica32);
        contraseñaCampo.setEchoChar((char) 0);
        contraseñaCampo.setText("Contraseña");
        contraseñaCampo.setBackground(Color.GRAY);
        contraseñaCampo.setForeground(new Color(0, 0, 0));
        contraseñaCampo.setBounds(345, 516, 440, 84);

        contraseñaCampo.addFocusListener(pFocusListener);
        add(contraseñaCampo);

        adviceField = new JLabel();
        adviceField.setBackground(bgColor);
        adviceField.setForeground(new Color(0, 0, 0));
        adviceField.setBounds(350, 387, 250, 13);
        adviceField.setFont(helveticaBold12);
        adviceField.setText("Los siguientes dos campos son obligatorios"); //Esto es lo que nos dijieron
        add(adviceField);

        botonSeguir = new RoundJButton(35);
        botonSeguir.setFont(helveticaBold34);
        botonSeguir.setBackground(new Color(47, 53, 66));
        botonSeguir.setForeground(new Color(255, 255, 255));
        botonSeguir.setBounds(300, 642, 535, 84);
        botonSeguir.setText("♥ Seguir ♥");
        botonSeguir.addFocusListener(listenerBotonSeguir);
        botonSeguir.addActionListener(this);
        add(botonSeguir);

        setVisible(true);
    }

    public static void main(String[] args) {
    
    }

    public String[] getFields() {
        String[] returnable = new String[2];
        String mail = usuarioCampo.getText();
        char[] _pass = contraseñaCampo.getPassword();
        String pass = String.valueOf(_pass);
        returnable[0] = mail;
        returnable[1] = pass;
        return returnable;
    }

    public void setPlaceHolders() {
        if (usuarioCampo.getText().equals("") || usuarioCampo.getText().equals("Correo")) {
            usuarioCampo.setText("Correo");
            usuarioCampo.addFocusListener(mFocusListener);
        }
        String passwordText = String.valueOf(contraseñaCampo.getPassword());
        if (passwordText.equals("")) {
            contraseñaCampo.setEchoChar((char) 0);
            contraseñaCampo.setText("Contraseña");
            contraseñaCampo.addFocusListener(pFocusListener);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object boton = e.getSource(); //todo en Java es un objeto
        if(boton == botonSeguir){
            dispose();
            new VentanaJuego(width, height);
            //Aquí deberías poner una validacion para comprobar el usuario y contraseña
            
        } 
    }
}
