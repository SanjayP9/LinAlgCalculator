package com.example.sanjay.linalgcalcnew;

/**
 * Created by Sanjay on 5/14/2017.
 */

public class Vector2D {
    private Fraction x;
    private Fraction y;

    public Vector2D(Fraction x, Fraction y) {
        this.x = x;
        this.y = y;
    }


    public Fraction getX() {
        return x;
    }

    public void setX(Fraction x) {
        this.x = x;
    }

    public Fraction getY() {
        return y;
    }

    public void setY(Fraction y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return x + "," + y;
    }
}
