package com.example.sanjay.linalgcalcnew;

/**
 * Created by Sanjay on 5/22/2017.
 */

public class LinePOIResult
{
    public enum IntersectionType
    {
        Parallel,
        Skewed,
        Identical,
        AtPoint
    }
    private LinePOIResult.IntersectionType intersectionType;
    private Vector3D poi;

    public LinePOIResult(IntersectionType intersectionType) {
        this.intersectionType = intersectionType;
    }

    public LinePOIResult (Vector3D poi)
    {
       this.intersectionType = IntersectionType.AtPoint;
        this.poi = poi;
    }

    public IntersectionType getIntersectionType() {
        return intersectionType;
    }

    public void setIntersectionType(IntersectionType intersectionType) {
        this.intersectionType = intersectionType;
    }

    public Vector3D getPoi() {
        return poi;
    }

    public void setPoi(Vector3D poi) {
        this.poi = poi;
    }
}
