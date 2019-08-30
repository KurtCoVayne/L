package gui;

import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class RoundJButton extends JButton {
    private static final long serialVersionUID = 1L;
    // @Override public void setBorder(Border border) {
    // // No!
    // }
    private Shape shape;
    private int size;

    public RoundJButton(int size) {
        super();
        this.size = size;
        setOpaque(false); // As suggested by @AVD in comment.
    }
    public RoundJButton(ImageIcon i) {
        super(i);
        this.size = 0;
        setOpaque(false); // As suggested by @AVD in comment.
    }
    protected void paintComponent(Graphics g) {
         g.setColor(getBackground());
         g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, this.size, this.size);
         super.paintComponent(g);
    }
    protected void paintBorder(Graphics g) {
         g.setColor(getBackground());
         g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, this.size, this.size);
    }
    public boolean contains(int x, int y) {
         if (shape == null || !shape.getBounds().equals(getBounds())) {
             shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, this.size, this.size);
         }
         return shape.contains(x, y);
    }

}