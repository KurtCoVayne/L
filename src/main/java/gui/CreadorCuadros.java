package punnett;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
public class CreadorCuadros extends JFrame implements ActionListener {
    private static final long serialVersionUID = -3846663349313166808L;
    private static JTextField gen1Campo;
    private static JTextField gen2Campo;
    private static JButton crearCuadro;

    public static void main(String[] args) {
        new CreadorCuadros(1024, 768);
    }

    public CreadorCuadros(int width, int height) {
        setLayout(null);
        setSize(width, height);
        Color bgColor = new Color(255, 255, 255);
        setBackground(bgColor);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Cuadro de punnett");
        Font arial20 = new Font("Arial", Font.PLAIN, 20);

        gen1Campo = new JTextField();
        gen1Campo.setFont(arial20);
        gen1Campo.setBounds(345,328,440,85);
        gen1Campo.setBackground(Color.PINK);
        gen1Campo.setForeground(new Color(0, 0, 0));
        add(gen1Campo);

        gen2Campo = new JTextField();
        gen2Campo.setFont(arial20);
        gen2Campo.setBounds(345,428,440,85);
        gen2Campo.setBackground(Color.PINK);
        gen2Campo.setForeground(new Color(0, 0, 0));
        add(gen2Campo);

        crearCuadro = new RoundJButton(35);
        crearCuadro.setFont(arial20);
        crearCuadro.setBackground(Color.white);
        crearCuadro.setForeground(new Color(0, 0, 0));
        crearCuadro.setBounds(285, 630, 535, 84);
        crearCuadro.setText("Crear cuadro");
        crearCuadro.addActionListener(this);
        add(crearCuadro);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
		if(e.getSource() == crearCuadro){
            if(gen1Campo.getText() == "" || gen2Campo.getText() == "" || gen1Campo.getText().length() > 1 || gen2Campo.getText().length() > 1 || gen1Campo.getText() == gen2Campo.getText()){
                System.err.println("FORMATO INCORRECTO");
            }else{
                new CuadroPunnett(1024,768,gen1Campo.getText().charAt(0),gen2Campo.getText().charAt(0));
                dispose();
            }
        }
	}
}
