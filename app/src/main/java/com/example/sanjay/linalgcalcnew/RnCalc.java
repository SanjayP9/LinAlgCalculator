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

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Fraction[] u = new Fraction[3];
        Fraction[] v = new Fraction[3];

        String temp;

        for (int i = 0; i < u.length; i++) {
            temp = input.nextLine();

            if (temp.contains("/")) {
                u[i] = new Fraction(Character.getNumericValue(temp.charAt(0)), Character.getNumericValue(temp.charAt(2)));
            } else {
                u[i] = new Fraction(Integer.parseInt(temp), 1);
            }
        }

        for (int i = 0; i < v.length; i++) {
            temp = input.nextLine();

            if (temp.contains("/")) {
                v[i]  = new Fraction(Character.getNumericValue(temp.charAt(0)), Character.getNumericValue(temp.charAt(2)));
            } else {
                v[i] = new Fraction(Integer.parseInt(temp), 1);
            }
        }

        Vector3D result = crossProduct(new Vector3D(u[0], u[1], u[2]), new Vector3D(v[0], v[1], v[2]));

        System.out.println(result.toString());
    }

}
