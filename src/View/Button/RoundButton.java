package View.Button;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JButton;
import javax.swing.plaf.basic.BasicButtonUI;

public class RoundButton extends JButton {

    public RoundButton() {
        super();

        setUI(new BasicButtonUI()); // LAF簡素化
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        setOpaque(false);
        setRolloverEnabled(false);
    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth();
        int h = getHeight();

        boolean pressed = getModel().isPressed();
        int offset = pressed ? 2 : 0;

        // 影
        if (!pressed) {
            g2.setColor(new Color(0,0,0,40));
            g2.fillOval(2, 4, w-4, h-4);
        }

        // 本体
        g2.setColor(Color.WHITE);
        g2.fillOval(0, 0, w, h);

        // 中身
        g2.translate(offset, offset);
        super.paintComponent(g2);

        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth();
        int h = getHeight();

        boolean pressed = getModel().isPressed();
        int offset = pressed ? 2 : 0;

        int stroke = 2;
        int pad = stroke / 2;

        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(stroke));

        g2.drawOval(
                pad + offset,
                pad + offset,
                w - stroke,
                h - stroke
        );

        g2.dispose();
    }

    @Override
    public boolean contains(int x, int y) {
        int r = getWidth() / 2;
        int cx = r;
        int cy = r;
        return (x - cx)*(x - cx) + (y - cy)*(y - cy) <= r*r;
    }

}