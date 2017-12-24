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

    // Distance of a point in 3D space to a plane
    public static Fraction pointToPlane(Vector3D p, Plane plane) {
        Vector3D p0;

        if (plane.getConstant().getNumerator() == 0) {
            p0 = new Vector3D();
        } else {
            p0 = new Vector3D(Fraction.divide(plane.getConstant(), plane.getX()), new Fraction(), new Fraction());
        }

        Vector3D p0p = Vector3D.subtract(p, p0);

        return Vector3D.magnitude(Vector3D.projection(p0p, plane.getNormal()));
    }

    public static PlanePOIResult planeIntersection(Plane p1, Plane p2) {
        if (Vector3D.magnitude(Vector3D.crossProduct(p1.getNormal(), p2.getNormal())).getNumerator() == 0) {
            return new PlanePOIResult();
        }

        Vector3D lineVect = Vector3D.crossProduct(p1.getNormal(), p2.getNormal());

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

    @Override
    public String toString() {
        return this.x + " x " + this.y + " y " + this.z + " " + this.constant;
    }
}
