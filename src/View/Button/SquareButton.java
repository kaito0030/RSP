package View.Button;



import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JButton;

public class SquareButton extends JButton {

    public SquareButton(String text) {
        super(text);

        setFocusPainted(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setOpaque(false);
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

        // 影（通常時）
        if (!pressed) {
            g2.setColor(new Color(0,0,0,50));
            g2.fillRoundRect(2, 4, w-4, h-4, 15, 15);
        }

        // 本体（白）
        g2.setColor(Color.WHITE);
        g2.fillRoundRect(0, 0, w, h, 15, 15);

        // 中身をずらす
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

        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(2));

        g2.drawRoundRect(
                offset,
                offset,
                w - 1,
                h - 1,
                15,
                15
        );

        g2.dispose();
    }
}
