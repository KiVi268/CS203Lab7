package com.kivi;

import com.kivi.util.DragRectangle;
import com.kivi.util.DrawingShapes;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DrawingShapes().setVisible(true));

        SwingUtilities.invokeLater(() -> new DragRectangle().setVisible(true));
    }
}