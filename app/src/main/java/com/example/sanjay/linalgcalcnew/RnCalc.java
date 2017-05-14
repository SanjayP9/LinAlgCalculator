package com.example.sanjay.linalgcalcnew;

import java.util.Scanner;
import java.util.Vector;

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

    public static Fraction dotProduct (Vector2D u, Vector2D v)
    {
        return frac.add(frac.multiply(u.getX(), v.getX()), frac.multiply(u.getY(), v.getY()));
    }

    public static Fraction dotProduct (Vector3D u, Vector3D v)
    {
        Fraction x = frac.multiply(u.getX(), v.getX());
        Fraction y = frac.multiply(u.getY(), v.getY());
        Fraction z = frac.multiply(u.getZ(), v.getZ());

        Fraction result = frac.add(x,y);
        result = frac.add(result, z);

        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Fraction[] u = new Fraction[3];
        Fraction[] v = new Fraction[3];

        String temp;

        for (int i = 0; i < u.length; i++) {
            temp = input.nextLine();

            if (temp.contains("/")) {
                int slash = temp.indexOf('/');
                u[i] = new Fraction(Integer.parseInt(temp.substring(0,slash)),Integer.parseInt(temp.substring(slash+1)));
            } else {
                u[i] = new Fraction(Integer.parseInt(temp), 1);
            }
        }

        for (int i = 0; i < v.length; i++) {
            temp = input.nextLine();

            if (temp.contains("/")) {
                int slash = temp.indexOf('/');
                v[i] = new Fraction(Integer.parseInt(temp.substring(0,slash-1)),Integer.parseInt(temp.substring(slash+1)));
            } else {
                v[i] = new Fraction(Integer.parseInt(temp), 1);
            }
        }

        Fraction result = dotProduct(new Vector3D(u[0], u[1], u[2]), new Vector3D(v[0], v[1], v[2]));

        System.out.println(result.toString());
    }

}
