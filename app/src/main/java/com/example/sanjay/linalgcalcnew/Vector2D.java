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

    // Adds two 2-dimensional vectors
    public static Vector2D add(Vector2D u, Vector2D v) {
        return new Vector2D(Fraction.add(u.getX(), v.getX()), Fraction.add(u.getY(), v.getY()));
    }

    // Subtracts two 2-dimensional vectors
    public static Vector2D subtract(Vector2D u, Vector2D v) {
        return add(u, scalarMultiply(v, new Fraction(-1, 1)));
    }

    // Multiplies a 2-dimensional vector by a Fraction
    public static Vector2D scalarMultiply(Vector2D vect, Fraction scalar) {
        return new Vector2D(Fraction.multiply(vect.getX(), scalar), Fraction.multiply(vect.getY(), scalar));
    }

    // Multiplies two 2-dimensional vectors
    public static Vector2D multiply(Vector2D u, Vector2D v) {
        return new Vector2D(Fraction.multiply(u.getX(), v.getX()), Fraction.multiply(u.getY(), v.getY()));
    }

    // Projection of vector u onto vector v using formula [(u⋅v)/||v||]⋅v (2D)
    public static Vector2D projection(Vector2D u, Vector2D v) {
        Fraction scalar = Fraction.multiply(dotProduct(u, v), (Fraction.reciprocal(dotProduct(v, v))));

        return new Vector2D(Fraction.multiply(v.getX(), scalar),
                Fraction.multiply(v.getY(), scalar));
    }

    // Dot product of two 2-dimensional vectors u1*v1 + u2*v2
    public static Fraction dotProduct(Vector2D u, Vector2D v) {
        return Fraction.add(Fraction.multiply(u.getX(), v.getX()), Fraction.multiply(u.getY(), v.getY()));
    }

    @Override
    public String toString() {
        return x + "," + y;
    }
}
