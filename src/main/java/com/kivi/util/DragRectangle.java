package com.kivi.util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class DragRectangle extends JFrame {
    private final JPanel canvas;
    private int rectX = 100;
    private int rectY = 100;
    private final int rectWidth = 100;
    private final int rectHeight = 100;
    private boolean dragging = false;

    public DragRectangle() {
        canvas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLACK);
                g.fillRect(rectX, rectY, rectWidth, rectHeight);
            }
        };
        canvas.setBackground(Color.PINK);

        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getX() >= rectX && e.getX() <= rectX + rectWidth &&
                        e.getY() >= rectY && e.getY() <= rectY + rectHeight) {
                    dragging = true;
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                dragging = false;
            }
        });

        canvas.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (dragging) {
                    rectX = e.getX() - rectWidth / 2;
                    rectY = e.getY() - rectHeight / 2;
                    canvas.repaint();
                }
            }
        });

        add(canvas);

        setTitle("Drag Rectangle");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}
