package com.example.sanjay.linalgcalcnew;

/**
 * Created by Sanjay on 5/12/2017.
 */

public class Vector3D {
    private Fraction x;
    private Fraction y;
    private Fraction z;

    public Vector3D() {
        this.x = new Fraction();
        this.y = new Fraction();
        this.z = new Fraction();
    }

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

    // Adds two 3-dimensional vectors
    public static Vector3D add(Vector3D u, Vector3D v) {
        return new Vector3D(Fraction.add(u.getX(), v.getX()),
                Fraction.add(u.getY(), v.getY()),
                Fraction.add(u.getZ(), v.getZ()));
    }

    // Subtracts 2 3-dimensional vectors
    public static Vector3D subtract(Vector3D u, Vector3D v) {
        return add(u, scalarMultiply(v, new Fraction(-1, 1)));
    }

    // Multiplies a 3-dimensional vector by a Fraction
    public static Vector3D scalarMultiply(Vector3D vect, Fraction scalar) {
        return new Vector3D(Fraction.multiply(vect.getX(), scalar), Fraction.multiply(vect.getY(), scalar), Fraction.multiply(vect.getZ(), scalar));
    }

    // Multiplies 2 3-dimensional vectors
    public static Vector3D multiply(Vector3D u, Vector3D v) {
        return new Vector3D(Fraction.multiply(u.getX(), v.getX()), Fraction.multiply(u.getY(), v.getY()), Fraction.multiply(u.getZ(), v.getZ()));
    }

    // Checks if two 3-dimensional vectors are exactly the same
    private static boolean equals(Vector3D u, Vector3D v) {
        if ((Fraction.equals(u.getX(), v.getX())) && (Fraction.equals(u.getY(), v.getY())) && (Fraction.equals(u.getZ(), v.getZ()))) {
            return true;
        }
        return false;
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

    // Dot product of two 3-dimensional vectors u1*v1 + u2*v2 + u3*v3
    public static Fraction dotProduct(Vector3D u, Vector3D v) {
        Fraction x = Fraction.multiply(u.getX(), v.getX());
        Fraction y = Fraction.multiply(u.getY(), v.getY());
        Fraction z = Fraction.multiply(u.getZ(), v.getZ());

        Fraction result = Fraction.add(x, y);
        result = Fraction.add(result, z);

        return result;
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


    @Override
    public String toString() {
        return x + " " + y + " " + z;
    }
}
