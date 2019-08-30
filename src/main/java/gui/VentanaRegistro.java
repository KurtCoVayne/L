package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class VentanaRegistro extends JFrame implements ActionListener {

    private static final long serialVersionUID = -5211806330512415667L;
    private static final int width = 1024;
    private static final int height = 768;
    private static JTextField tUser;

    private static JTextField correoCampo;

    private static JPasswordField contraseñaCampo;

    private static JPasswordField confirmarContraseñaCampo;

    private static JLabel adviceField;

    private static final Font ArialBold12 = new Font("Arial", Font.BOLD, 12);
    private static final Font Arial32 = new Font("Arial", Font.PLAIN, 32);
    private static final Font ArialBold38 = new Font("Arial", Font.BOLD, 38);

    private static JButton registrarse;
    // las siguientes lineas de codigo no sé como explicarla, jasjasjas, su utilidad
    // es hacer que cuando le de click a uno de los cosos se quite el texto de
    // muestra como Correo, Usuario, contraseña, etc. 
    FocusListener l = new FocusListener() {

        @Override
        public void focusLost(FocusEvent e) {

        }

        @Override
        public void focusGained(FocusEvent e) {
            reiniciarCampos();
        }
    };

    final FocusListener uFocusListener = new FocusListener() {

        @Override
        public void focusLost(FocusEvent e) {
        }

        @Override
        public void focusGained(FocusEvent e) {
            if (correoCampo.getText().equals("") || correoCampo.getText().equalsIgnoreCase("correo(*)")) {
                correoCampo.setText("Correo(*)");
                correoCampo.addFocusListener(mFocusListener);
            }
            String passValue = String.valueOf(contraseñaCampo.getPassword());
            if (passValue.equals("")) {
                contraseñaCampo.setEchoChar((char) 0);
                contraseñaCampo.setText("Contraseña(*)");
                contraseñaCampo.addFocusListener(pFocusListener);
                contraseñaCampo.setVisible(true);
            }
            String cpassValue = String.valueOf(confirmarContraseñaCampo.getPassword());
            if (cpassValue.equals("")) {
                confirmarContraseñaCampo.setEchoChar((char) 0);
                confirmarContraseñaCampo.setText("Confirmar contraseña(*)");
                confirmarContraseñaCampo.addFocusListener(cpFocusListener);
                confirmarContraseñaCampo.setVisible(true);
            }
            tUser.setText("");
            tUser.removeFocusListener(this);
        }
    };

    final FocusListener mFocusListener = new FocusListener() {

        @Override
        public void focusLost(FocusEvent e) {
        }

        @Override
        public void focusGained(FocusEvent e) {
            if (tUser.getText().equals("") || tUser.getText().equalsIgnoreCase("(*)Nombre de usuario")) {
                tUser.setText("Nombre de usuario(*)");
                tUser.addFocusListener(uFocusListener);
            }
            String passValue = String.valueOf(contraseñaCampo.getPassword());
            if (passValue.equals("")) {
                contraseñaCampo.setEchoChar((char) 0);
                contraseñaCampo.setText("Contraseña(*)");
                contraseñaCampo.addFocusListener(pFocusListener);
                contraseñaCampo.setVisible(true);
            }
            String cpassValue = String.valueOf(confirmarContraseñaCampo.getPassword());
            if (cpassValue.equals("")) {
                confirmarContraseñaCampo.setEchoChar((char) 0);
                confirmarContraseñaCampo.setText("Confirmar contraseña(*)");
                confirmarContraseñaCampo.addFocusListener(cpFocusListener);
                confirmarContraseñaCampo.setVisible(true);
            }
            correoCampo.setText("");
            correoCampo.removeFocusListener(this);
        }
    };

    final FocusListener pFocusListener = new FocusListener() {

        @Override
        public void focusLost(FocusEvent e) {
        }

        @Override
        public void focusGained(FocusEvent e) {
            if (tUser.getText().equals("") || tUser.getText().equalsIgnoreCase("Nombre de usuario(*)")) {
                tUser.setText("Nombre de usuario(*)");
                tUser.addFocusListener(uFocusListener);
            }
            if (correoCampo.getText().equals("") || correoCampo.getText().equalsIgnoreCase("correo(*)")) {
                correoCampo.setText("Correo(*)");
                correoCampo.addFocusListener(mFocusListener);
            }
            String cpassValue = String.valueOf(confirmarContraseñaCampo.getPassword());
            if (cpassValue.equals("")) {
                confirmarContraseñaCampo.setEchoChar((char) 0);
                confirmarContraseñaCampo.setText("Confirmar contraseña(*)");
                confirmarContraseñaCampo.addFocusListener(cpFocusListener);
                confirmarContraseñaCampo.setVisible(true);
            }

            contraseñaCampo.setText("");
            contraseñaCampo.setEchoChar('*');
            contraseñaCampo.removeFocusListener(this);
        }
    };

    final FocusListener cpFocusListener = new FocusListener() {

        @Override
        public void focusLost(FocusEvent e) {
        }

        @Override
        public void focusGained(FocusEvent e) {
            if (tUser.getText().equals("") || tUser.getText().equalsIgnoreCase("correo(*)")) {
                tUser.setText("Nombre de usuario(*)");
                tUser.addFocusListener(uFocusListener);
            }
            if (correoCampo.getText().equals("") || correoCampo.getText().equalsIgnoreCase("nombre de usuario(*)")) {
                correoCampo.setText("Correo(*)");
                correoCampo.addFocusListener(mFocusListener);
            }
            String passValue = String.valueOf(contraseñaCampo.getPassword());
            if (passValue.equals("")) {
                contraseñaCampo.setEchoChar((char) 0);
                contraseñaCampo.setText("Contraseña(*)");
                contraseñaCampo.addFocusListener(pFocusListener);
                contraseñaCampo.setVisible(true);
            }

            confirmarContraseñaCampo.setText("");
            confirmarContraseñaCampo.setEchoChar('*');
            confirmarContraseñaCampo.removeFocusListener(this);
        }
    };

    public VentanaRegistro(int width, int height) {
        setSize(width, height);
        setTitle("Codigo Genetico");
        setLocationRelativeTo(this);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // poniendo lo cositos, deberías acomodarlos mejor, cambiarle el colores,
        // ponerle un mejor titulo a ventana, etc
        tUser = new RoundJTextField(35);
        tUser.setFont(Arial32);
        tUser.setText("Nombre de usuario(*)");
        tUser.setBackground(Color.PINK);
        tUser.setForeground(new Color(0, 0, 0));
        tUser.setBounds(345, 230, 440, 84);
        tUser.addFocusListener(uFocusListener);
        add(tUser);

        correoCampo = new RoundJTextField(35);
        correoCampo.setFont(Arial32);
        correoCampo.setText("Correo(*)");
        correoCampo.setBackground(Color.PINK);
        correoCampo.setForeground(new Color(0, 0, 0));
        correoCampo.setBounds(345, 328, 440, 84);
        correoCampo.addFocusListener(mFocusListener);
        add(correoCampo);

        contraseñaCampo = new RoundJPassField(35);
        contraseñaCampo.setFont(Arial32);
        contraseñaCampo.setEchoChar((char) 0);
        contraseñaCampo.setText("Contraseña(*)");
        contraseñaCampo.setBackground(Color.PINK);
        contraseñaCampo.setForeground(new Color(0, 0, 0));
        contraseñaCampo.setBounds(345, 428, 440, 84);
        contraseñaCampo.addFocusListener(pFocusListener);
        add(contraseñaCampo);

        confirmarContraseñaCampo = new RoundJPassField(35);
        confirmarContraseñaCampo.setFont(Arial32);
        confirmarContraseñaCampo.setEchoChar((char) 0);
        confirmarContraseñaCampo.setText("Confirmar contraseña(*)");
        confirmarContraseñaCampo.setBackground(Color.PINK);
        confirmarContraseñaCampo.setForeground(new Color(0, 0, 0));
        confirmarContraseñaCampo.setBounds(345, 528, 440, 84);
        confirmarContraseñaCampo.addFocusListener(cpFocusListener);
        add(confirmarContraseñaCampo);

        adviceField = new JLabel();
        adviceField.setBackground(Color.white);
        adviceField.setForeground(new Color(0, 0, 0));
        adviceField.setBounds(205, 100, 200, 32);
        adviceField.setFont(Arial32);
        adviceField.setText("Obligatorio(*)");
        add(adviceField);

        registrarse = new RoundJButton(35);
        registrarse.setFont(ArialBold38);
        registrarse.setBackground(Color.white);
        registrarse.setForeground(new Color(0, 0, 0));
        registrarse.setBounds(285, 630, 535, 84);
        registrarse.setText("Registrar");
        registrarse.addFocusListener(l);
        registrarse.addActionListener(this);
        add(registrarse);

        setVisible(true);
    }

    public static void main(String[] args) {
        new VentanaRegistro(width, height);

    }

    public String[] getFields() { // esta función es para obtener que datos hay en los espacios del registro
        String[] returnable = new String[4];
        String user = tUser.getText();
        String mail = correoCampo.getText();
        char[] _pass = contraseñaCampo.getPassword();
        String pass = String.valueOf(_pass);
        char[] _cpass = confirmarContraseñaCampo.getPassword();
        String cpass = String.valueOf(_cpass);
        returnable[0] = user;
        returnable[1] = mail;
        returnable[2] = pass;
        returnable[3] = cpass;
        return returnable;
    }

    public void reiniciarCampos() { // esto hace parte de lo del principio
        if (tUser.getText().equals("") || tUser.getText().equalsIgnoreCase("nombre de usuario")) {
            tUser.setText("Nombre de usuario");
            tUser.addFocusListener(uFocusListener);
        }
        if (correoCampo.getText().equals("") || correoCampo.getText().equalsIgnoreCase("correo")) {
            correoCampo.setText("Correo");
            correoCampo.addFocusListener(mFocusListener);
        }
        String passValue = String.valueOf(contraseñaCampo.getPassword());
        if (passValue.equals("")) {
            contraseñaCampo.setEchoChar((char) 0);
            contraseñaCampo.setText("Contraseña");
            contraseñaCampo.addFocusListener(pFocusListener);
        }
        String cpassValue = String.valueOf(confirmarContraseñaCampo.getPassword());
        if (cpassValue.equals("")) {
            confirmarContraseñaCampo.setEchoChar((char) 0);
            confirmarContraseñaCampo.setText("Confirmar contraseña");
            confirmarContraseñaCampo.addFocusListener(pFocusListener);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object boton = e.getSource(); // todo en Java es un objeto, entonces convertimos la fuente(source) en un boton
        // y checkeamos cuál boton fue presionado
        if (boton == registrarse) {
            dispose();


            // Cuando vayas a crear un usuario intenta guardarlo en la memoria de alguna
            // manera, si necesitas ayuda para esto me puedes preguntar, deja el orgullo e.e
            // aun así es algo bastante complejo, por esa razón no lo puse.
            //Obviamente me refiero a cuando registras un usuario
            new VentanaRegistro(width, height);
        }
    }
}
