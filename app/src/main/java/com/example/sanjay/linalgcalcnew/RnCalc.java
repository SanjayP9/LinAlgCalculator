package com.example.sanjay.linalgcalcnew;

import java.util.Scanner;

/**
 * Created by Sanjay on 5/12/2017.
 */

public class RnCalc {
    private static FractionCalc frac;

    public RnCalc() {
        frac = new FractionCalc();
    }

    public static Vector2D add(Vector2D u, Vector2D v) {
        return new Vector2D(frac.add(u.getX(), v.getX()), frac.add(u.getY(), v.getY()));
    }

    public static Vector3D add(Vector3D u, Vector3D v) {
        return new Vector3D(frac.add(u.getX(), v.getX()),
                frac.add(u.getY(), v.getY()),
                frac.add(u.getZ(), v.getZ()));
    }

    public static Vector2D subtract(Vector2D u, Vector2D v) {
        return add(u, scalarMultiply(v, new Fraction(-1, 1)));
    }

    public static Vector3D subtract(Vector3D u, Vector3D v) {
        return add(u, scalarMultiply(v, new Fraction(-1, 1)));
    }

    public static Vector2D scalarMultiply(Vector2D vect, Fraction scalar) {
        return new Vector2D(frac.multiply(vect.getX(), scalar), frac.multiply(vect.getY(), scalar));
    }

    public static Vector3D scalarMultiply(Vector3D vect, Fraction scalar) {
        return new Vector3D(frac.multiply(vect.getX(), scalar), frac.multiply(vect.getY(), scalar), frac.multiply(vect.getZ(), scalar));
    }

    public static Vector2D multiply(Vector2D u, Vector2D v) {
        return new Vector2D(frac.multiply(u.getX(), v.getX()), frac.multiply(u.getY(), v.getY()));
    }

    public static Vector3D multiply(Vector3D u, Vector3D v) {
        return new Vector3D(frac.multiply(u.getX(), v.getX()), frac.multiply(u.getY(), v.getY()), frac.multiply(u.getZ(), v.getZ()));
    }

    public static Fraction magnitude(Vector3D vector) {
        Fraction result = new Fraction();


        int numMag = (int) Math.pow(vector.getX().getNumerator(), 2) + (int) Math.pow(vector.getY().getNumerator(), 2) + (int) Math.pow(vector.getZ().getNumerator(), 2);
        int denMag = (int) Math.pow(vector.getX().getDenominator(), 2) + (int) Math.pow(vector.getY().getDenominator(), 2) + (int) Math.pow(vector.getZ().getDenominator(), 2);

        if (Math.sqrt(numMag) % 1 == 0) {
            result.setNumerator((int) Math.sqrt(numMag));
        } else {
            result.setNumerator(numMag);
            result.setNumRoot(true);
        }

        if (Math.sqrt(denMag) % 1 == 0) {
            result.setDenominator((int) Math.sqrt(denMag));
        } else {
            result.setDenominator(denMag);
            result.setDenRoot(true);
        }

        return result;
    }

    public static Vector3D crossProduct(Vector3D u, Vector3D v) {
        return new Vector3D(frac.subtract(frac.multiply(u.getY(), v.getZ()), frac.multiply(u.getZ(), v.getY())),
                frac.subtract(frac.multiply(u.getZ(), v.getX()), frac.multiply(u.getX(), v.getZ())),
                frac.subtract(frac.multiply(u.getX(), v.getY()), frac.multiply(u.getY(), v.getX())));

    }

    public static Fraction dotProduct(Vector2D u, Vector2D v) {
        return frac.add(frac.multiply(u.getX(), v.getX()), frac.multiply(u.getY(), v.getY()));
    }

    public static Fraction dotProduct(Vector3D u, Vector3D v) {
        Fraction x = frac.multiply(u.getX(), v.getX());
        Fraction y = frac.multiply(u.getY(), v.getY());
        Fraction z = frac.multiply(u.getZ(), v.getZ());

        Fraction result = frac.add(x, y);
        result = frac.add(result, z);

        return result;
    }

    public static Vector2D projection(Vector2D u, Vector2D v) {
        Fraction scalar = frac.multiply(dotProduct(u, v), (frac.reciprocal(dotProduct(v, v))));

        return new Vector2D(frac.multiply(v.getX(), scalar),
                frac.multiply(v.getY(), scalar));
    }

    // Projection of U onto V
    public static Vector3D projection(Vector3D u, Vector3D v) {
        Fraction scalar = frac.multiply(dotProduct(u, v), (frac.reciprocal(dotProduct(v, v))));

        return new Vector3D(frac.multiply(v.getX(), scalar),
                frac.multiply(v.getY(), scalar),
                frac.multiply(v.getZ(), scalar));
    }

    public static Fraction parallelepipedVolume(Vector3D u, Vector3D v, Vector3D w) {
        return dotProduct(crossProduct(u, v), w);
    }

    public static Fraction pointToPlane(Vector3D p, Plane plane) {
        Vector3D p0;

        if (plane.getConstant().getNumerator() == 0) {
            p0 = new Vector3D();
        } else {
            p0 = new Vector3D(frac.divide(plane.getConstant(), plane.getX()), new Fraction(), new Fraction());
        }

        Vector3D p0p = subtract(p, p0);

        return magnitude(projection(p0p, plane.getNormal()));
    }

    public static void main(String[] args) {
        /*for (int i = 0; i < u.length; i++) {
            temp = input.nextLine();

            if (temp.contains("/")) {
                int slash = temp.indexOf('/');
                u[i] = new Fraction(Integer.parseInt(temp.substring(0, slash)), Integer.parseInt(temp.substring(slash + 1, temp.length())));
            } else {
                u[i] = new Fraction(Integer.parseInt(temp), 1);
            }
        }

        for (int i = 0; i < v.length; i++) {
            temp = input.nextLine();

            if (temp.contains("/")) {
                int slash = temp.indexOf('/');
                v[i] = new Fraction(Integer.parseInt(temp.substring(0, slash - 1)), Integer.parseInt(temp.substring(slash + 1)));
            } else {
                v[i] = new Fraction(Integer.parseInt(temp), 1);
            }
        }*/

        /*Scanner input = new Scanner(System.in);

        Fraction[] u = new Fraction[3];
        Fraction[] v = new Fraction[3];

        String temp;


        input.nextLine();

        u[0] = new Fraction(-45, 33);
        u[1] = new Fraction(89, 30);
        u[2] = new Fraction(7, -5);

        v[0] = new Fraction(654, 4);
        v[1] = new Fraction(46, 3);
        v[2] = new Fraction(85, 6);

        Vector3D result = projection(new Vector3D(u[0], u[1], u[2]), new Vector3D(v[0], v[1], v[2]));

        System.out.println(result.toString());*/
        Fraction[] u = new Fraction[3];

        u[0] = new Fraction(-4, 1);
        u[1] = new Fraction(8, 2);
        u[2] = new Fraction(16, 2);

        System.out.println(magnitude(new Vector3D(u[0], u[1], u[2])));


    }

}
