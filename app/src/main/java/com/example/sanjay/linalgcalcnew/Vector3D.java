package com.example.sanjay.linalgcalcnew;

/**
 * Created by Sanjay on 5/12/2017.
 */

public class Vector3D {
    private Fraction x;
    private Fraction y;
    private Fraction z;

    public Vector3D(Fraction x, Fraction y, Fraction z) {
        this.x = x;
        this.y = y;
        this.z = z;
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

    public Fraction getZ() {
        return z;
    }

    public void setZ(Fraction z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return x + " " + y + " " + z;
    }
}
