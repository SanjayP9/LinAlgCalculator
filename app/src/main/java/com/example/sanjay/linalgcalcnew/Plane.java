package com.example.sanjay.linalgcalcnew;

/**
 * Created by Sanjay on 5/21/2017.
 */

public class Plane {

    private Fraction x;
    private Fraction y;
    private Fraction z;
    private Fraction constant;

    public Plane(Fraction x, Fraction y, Fraction z, Fraction constant) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.constant = constant;
    }

    public Vector3D getNormal() {
        return new Vector3D(this.x, this.y, this.z);
    }

    public Fraction getX() {
        return x;
    }

    public Fraction getY() {
        return y;
    }

    public Fraction getZ() {
        return z;
    }

    public Fraction getConstant() {
        return constant;
    }

    @Override
    public String toString() {
        return this.x + " x " + this.y + " y " + this.z + " " + this.constant;
    }
}
