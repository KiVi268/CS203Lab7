package com.kivi.util;
import com.kivi.model.Shape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class DrawingShapes extends JFrame {
    private final JPanel canvas;
    private final ArrayList<com.kivi.model.Shape> shapes;

    public DrawingShapes() {
        shapes = new ArrayList<>();
        //create panel for drawing
        canvas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (com.kivi.model.Shape shape : shapes) {
                    g.setColor(shape.getColor());
                    if (shape.isCircle()) {
                        g.fillOval(shape.getX() - 25, shape.getY() - 25, 70, 70);
                    } else {
                        g.fillRect(shape.getX() - 25, shape.getY() - 25, 70, 70);
                    }
                }
            }
        };
        canvas.setBackground(Color.PINK);

        //create processing mouse clicks
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Color randomColor = new Color((int) (Math.random() * 0x1000000));
                if (SwingUtilities.isLeftMouseButton(e)) {
                    shapes.add(new com.kivi.model.Shape(e.getX(), e.getY(), randomColor, true));
                } else if (SwingUtilities.isRightMouseButton(e)) {
                    shapes.add(new Shape(e.getX(), e.getY(), randomColor, false));
                }
                canvas.repaint();
            }
        });

        // Add Button to clear all
        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(e -> {
            shapes.clear();
            canvas.repaint();
        });


        setLayout(new BorderLayout());
        add(canvas, BorderLayout.CENTER);
        add(clearButton, BorderLayout.EAST);


        setTitle("Drawing Shapes");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}

