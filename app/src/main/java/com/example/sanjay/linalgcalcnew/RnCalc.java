package com.example.sanjay.linalgcalcnew;

import android.support.annotation.BoolRes;

import java.util.Scanner;

/**
 * Created by Sanjay on 5/12/2017.
 */

public class RnCalc {

    private RnCalc() {

    }

    // Adds two 2-dimensional vectors
    public static Vector2D add(Vector2D u, Vector2D v) {
        return new Vector2D(Fraction.add(u.getX(), v.getX()), Fraction.add(u.getY(), v.getY()));
    }

    // Adds two 3-dimensional vectors
    public static Vector3D add(Vector3D u, Vector3D v) {
        return new Vector3D(Fraction.add(u.getX(), v.getX()),
                Fraction.add(u.getY(), v.getY()),
                Fraction.add(u.getZ(), v.getZ()));
    }

    // Subtracts two 2-dimensional vectors
    public static Vector2D subtract(Vector2D u, Vector2D v) {
        return add(u, scalarMultiply(v, new Fraction(-1, 1)));
    }

    // Subtracts 2 3-dimensional vectors
    public static Vector3D subtract(Vector3D u, Vector3D v) {
        return add(u, scalarMultiply(v, new Fraction(-1, 1)));
    }

    // Multiplies a 2-dimensional vector by a Fraction
    public static Vector2D scalarMultiply(Vector2D vect, Fraction scalar) {
        return new Vector2D(Fraction.multiply(vect.getX(), scalar), Fraction.multiply(vect.getY(), scalar));
    }

    // Multiplies a 3-dimensional vector by a Fraction
    public static Vector3D scalarMultiply(Vector3D vect, Fraction scalar) {
        return new Vector3D(Fraction.multiply(vect.getX(), scalar), Fraction.multiply(vect.getY(), scalar), Fraction.multiply(vect.getZ(), scalar));
    }

    // Multiplies two 2-dimensional vectors
    public static Vector2D multiply(Vector2D u, Vector2D v) {
        return new Vector2D(Fraction.multiply(u.getX(), v.getX()), Fraction.multiply(u.getY(), v.getY()));
    }

    // Multiplies 2 3-dimensional vectors
    public static Vector3D multiply(Vector3D u, Vector3D v) {
        return new Vector3D(Fraction.multiply(u.getX(), v.getX()), Fraction.multiply(u.getY(), v.getY()), Fraction.multiply(u.getZ(), v.getZ()));
    }

    // Checks if two 3-dimensional vectors are the same
    private static boolean equals(Vector3D u, Vector3D v) {
        if ((Fraction.equals(u.getX(), v.getX())) && (Fraction.equals(u.getY(), v.getY())) && (Fraction.equals(u.getZ(), v.getZ()))) {
            return true;
        }
        return false;
    }

    // Gets magnitude of a 3-dimensional vector
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

    // Cross product of 2 3-dimensional vectors [u2*v3-u3*v3, u3*v1-u1*v3, u1*v2 - u2*v1]
    public static Vector3D crossProduct(Vector3D u, Vector3D v) {
        return new Vector3D(Fraction.subtract(Fraction.multiply(u.getY(), v.getZ()), Fraction.multiply(u.getZ(), v.getY())),
                Fraction.subtract(Fraction.multiply(u.getZ(), v.getX()), Fraction.multiply(u.getX(), v.getZ())),
                Fraction.subtract(Fraction.multiply(u.getX(), v.getY()), Fraction.multiply(u.getY(), v.getX())));

    }

    // Dot product of two 2-dimensional vectors u1*v1 + u2*v2
    public static Fraction dotProduct(Vector2D u, Vector2D v) {
        return Fraction.add(Fraction.multiply(u.getX(), v.getX()), Fraction.multiply(u.getY(), v.getY()));
    }

    // Dot product of two 3-dimensional vectors u1*v1 + u2*v2 + u3*v3
    public static Fraction dotProduct(Vector3D u, Vector3D v) {
        Fraction x = Fraction.multiply(u.getX(), v.getX());
        Fraction y = Fraction.multiply(u.getY(), v.getY());
        Fraction z = Fraction.multiply(u.getZ(), v.getZ());

        Fraction result = Fraction.add(x, y);
        result = Fraction.add(result, z);

        return result;
    }

    // Projection of vector u onto vector v using formula [(u⋅v)/||v||]⋅v (2D)
    public static Vector2D projection(Vector2D u, Vector2D v) {
        Fraction scalar = Fraction.multiply(dotProduct(u, v), (Fraction.reciprocal(dotProduct(v, v))));

        return new Vector2D(Fraction.multiply(v.getX(), scalar),
                Fraction.multiply(v.getY(), scalar));
    }

    // Projection of vector u onto vector v using formula [(u⋅v)/||v||]⋅v (3D)
    public static Vector3D projection(Vector3D u, Vector3D v) {
        Fraction scalar = Fraction.multiply(dotProduct(u, v), (Fraction.reciprocal(dotProduct(v, v))));

        return new Vector3D(Fraction.multiply(v.getX(), scalar),
                Fraction.multiply(v.getY(), scalar),
                Fraction.multiply(v.getZ(), scalar));
    }

    // Volume of a parallelepiped (u x v)⋅w
    public static Fraction parallelepipedVolume(Vector3D u, Vector3D v, Vector3D w) {
        return dotProduct(crossProduct(u, v), w);
    }

    // Distance of a point in 3D space to a plane
    public static Fraction pointToPlane(Vector3D p, Plane plane) {
        Vector3D p0;

        if (plane.getConstant().getNumerator() == 0) {
            p0 = new Vector3D();
        } else {
            p0 = new Vector3D(Fraction.divide(plane.getConstant(), plane.getX()), new Fraction(), new Fraction());
        }

        Vector3D p0p = subtract(p, p0);

        return magnitude(projection(p0p, plane.getNormal()));
    }

    // Checks if 2 3D vectors are equivalent by finding a common factor in between the two factors
    private static Boolean vectorEquivalence(Vector3D vect1, Vector3D vect2) {
        int x = 0;
        int y = 0;
        int z = 0;
        Fraction ratio;

        if (vect1.getX().getNumerator() != 0 && vect2.getX().getNumerator() != 0) {
            ratio = Fraction.divide(vect1.getX(), vect2.getX());
        } else if (vect1.getY().getNumerator() != 0 && vect2.getY().getNumerator() != 0) {
            ratio = Fraction.divide(vect1.getY(), vect2.getY());
        } else if (vect1.getZ().getNumerator() != 0 && vect2.getZ().getNumerator() != 0) {
            ratio = Fraction.divide(vect1.getZ(), vect2.getZ());
        } else {
            return false;
        }

        Vector3D tempVect1 = scalarMultiply(vect2, ratio);
        Vector3D tempVect2 = scalarMultiply(vect1, new Fraction(1));


        if (equals(tempVect1, tempVect2)) {
            return true;
        }
        return false;
    }

    //
    public static LinePOIResult lineIntersection(Vector3D t0, Vector3D t, Vector3D s0, Vector3D s) {

        if (magnitude(crossProduct(s, t)).getNumerator() == 0) {
            // if t0 and s0 are equivalent then they are Identical if not they are parallel
            if (vectorEquivalence(s0, t0)) {
                return new LinePOIResult(LinePOIResult.IntersectionType.Identical);
            } else {
                return new LinePOIResult(LinePOIResult.IntersectionType.Parallel);
            }

        } else {

        }
        return null;//temp
    }

    public static PlanePOIResult planeIntersection(Plane p1, Plane p2) {
        if (magnitude(crossProduct(p1.getNormal(), p2.getNormal())).getNumerator() == 0) {
            return new PlanePOIResult();
        }

        Vector3D lineVect = crossProduct(p1.getNormal(), p2.getNormal());

        Fraction x = new Fraction();
        Fraction y = new Fraction();
        Fraction z = new Fraction();

        if ((p1.getX().getNumerator() != 0) || (p2.getX().getNumerator() != 0)) {
            x = Fraction.divide(Fraction.subtract(p2.getConstant(), p1.getConstant()), Fraction.subtract(p1.getX(), p2.getX()));
        } else if ((p1.getY().getNumerator() != 0) || (p2.getY().getNumerator() != 0)) {
            y = Fraction.divide(Fraction.subtract(p2.getConstant(), p1.getConstant()), Fraction.subtract(p1.getY(), p2.getY()));
        } else if ((p1.getZ().getNumerator() != 0) || (p2.getZ().getNumerator() != 0)) {
            y = Fraction.divide(Fraction.subtract(p2.getConstant(), p1.getConstant()), Fraction.subtract(p1.getZ(), p2.getZ()));
        }

        return new PlanePOIResult(new Vector3D(x, y, z), lineVect);
    }

    public static PlanePOIResult planeIntersection(Plane p1, Plane p2, Plane p3) {
        return null;//temp
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
        Vector3D u, v, m;

        u = new Vector3D(new Fraction(-4, 1), new Fraction(8, 2), new Fraction(16, 2));
        m = new Vector3D(new Fraction(-8, 1), new Fraction(16, 2), new Fraction(32, 2));
        v = new Vector3D(new Fraction(7, 4), new Fraction(-8, 5), new Fraction(16, 7));

        System.out.println(vectorEquivalence(u, v));


    }

}
