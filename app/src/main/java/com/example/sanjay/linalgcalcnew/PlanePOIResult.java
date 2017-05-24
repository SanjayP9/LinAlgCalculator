package com.example.sanjay.linalgcalcnew;

/**
 * Created by Sanjay on 5/23/2017.
 */

public class PlanePOIResult {
    public enum IntersectionType {
        AtPoint,
        FormsLine,
        Parallel
    }

    private PlanePOIResult.IntersectionType intersectionType;

    Vector3D point;
    Vector3D lineStart;
    Vector3D lineVect;

    public PlanePOIResult()
    {
        this.intersectionType = IntersectionType.Parallel;
    }

    public PlanePOIResult(Vector3D point) {
        this.intersectionType = IntersectionType.AtPoint;
        this.point = point;
    }

    public PlanePOIResult(Vector3D lineStart, Vector3D lineVect) {
        this.intersectionType = IntersectionType.FormsLine;
        this.lineStart = lineStart;
        this.lineVect = lineVect;
    }

    public IntersectionType getIntersectionType() {
        return intersectionType;
    }

    public void setIntersectionType(IntersectionType intersectionType) {
        this.intersectionType = intersectionType;
    }

    public Vector3D getPoint() {
        return point;
    }

    public void setPoint(Vector3D point) {
        this.point = point;
    }

    public Vector3D getLineStart() {
        return lineStart;
    }

    public void setLineStart(Vector3D lineStart) {
        this.lineStart = lineStart;
    }

    public Vector3D getLineVect() {
        return lineVect;
    }

    public void setLineVect(Vector3D lineVect) {
        this.lineVect = lineVect;
    }
}
