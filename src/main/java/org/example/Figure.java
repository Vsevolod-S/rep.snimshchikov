package org.example;

public interface Figure
{
    public abstract double perimeter();
    public abstract double square();
    public abstract void rotation(double angle);
    public abstract void moving(Point newCentre);
    public abstract void scaling (double coeff);
    public abstract Point getCentre();
}