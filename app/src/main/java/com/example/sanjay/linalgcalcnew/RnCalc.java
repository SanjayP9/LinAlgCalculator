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

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Fraction[] u = new Fraction[3];
        Fraction[] v = new Fraction[3];

        String temp;

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
        input.nextLine();

        u[0] = new Fraction(-45,33);
        u[1] = new Fraction(89,30);
        u[2] = new Fraction(7,-5);

        v[0] = new Fraction(654,4);
        v[1] = new Fraction(46,3);
        v[2] = new Fraction(85,6);

        Vector3D result = projection(new Vector3D(u[0], u[1], u[2]), new Vector3D(v[0], v[1], v[2]));

        System.out.println(result.toString());
    }

}
