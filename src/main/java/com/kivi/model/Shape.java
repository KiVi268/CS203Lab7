package com.kivi.model;

import java.awt.*;

public class Shape {
    private int x;
    private int y;
    private Color color;
    private boolean isCircle;

    public Shape(int x, int y, Color color, boolean isCircle) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.isCircle = isCircle;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Color getColor() {
        return color;
    }

    public boolean isCircle() {
        return isCircle;
    }
}
