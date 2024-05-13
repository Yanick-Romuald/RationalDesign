/*
This class provides a robust implementation for handling rational numbers, including:
    Constructors for initialization.
    Methods for getting the numerator and denominator.
    Overridden equals and hashCode methods for proper equality checks and usage in collections.
    Methods for comparing, adding, and subtracting rational numbers.
    Utility methods for calculating the GCD and simplifying rational numbers.
 */







package com.mycompany.rationaldesign;

import java.util.Objects;

/**
 *
 * @author LENOVO
 */
public class RationalNumber {
    private int numerator;
    private int denominator;
    
    public RationalNumber(){
        this.numerator=0;
        this.denominator=1;
    }
    
    
    
    public RationalNumber(int num){
        this.numerator=num;
        this.denominator=1;
    }
    
    public RationalNumber(int num, int denum){
        this.numerator=num;
        this.denominator=denum;
        if(denum==0){
            throw new IllegalArgumentException("The denominator must not be 0!");
        }
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }
    
    
    /*
    public boolean equals(RationalNumber a, RationalNumber b){
        if (a==b) return true;
        if((a==null)||(b==null)) return false;
        int gcdA = pgcd(a.numerator, a.denominator);
        int gcdB = pgcd(b.numerator, b.denominator);
    
    return a.numerator / gcdA == b.numerator / gcdB && a.denominator / gcdA == b.denominator / gcdB;
    }
*/
    
    @Override
public boolean equals(Object obj) {
    if (this == obj) {
        return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
        return false;
    }
    RationalNumber other = (RationalNumber) obj;
    RationalNumber thisSimplified = simplify(this);
    RationalNumber otherSimplified = simplify(other);
    return thisSimplified.numerator == otherSimplified.numerator && thisSimplified.denominator == otherSimplified.denominator;
}

/*    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.numerator;
        hash = 47 * hash + this.denominator;
        return hash;
    }*/
@Override
public int hashCode() {
    return Objects.hash(numerator, denominator);
}
    
    
    
    public boolean compareSup(RationalNumber a, RationalNumber b){
        if(a.denominator==b.denominator){
            if(a.numerator>b.numerator){
                return true;
            }
            else
            {
                return false;
            }
        }else
            return (a.numerator*b.denominator)>(b.numerator*a.denominator);    
    }
    
    public static RationalNumber add (RationalNumber a, RationalNumber b){
        if(a.denominator ==b.denominator){
            return new RationalNumber((a.numerator + b.numerator),(a.denominator));
        }
        int x=(a.numerator)*(b.denominator)+(a.denominator)*(b.numerator);
        int y = (a.denominator)*(b.denominator);
        
        return new RationalNumber(x,y);
    }
    
    public RationalNumber substract(RationalNumber a, RationalNumber b){
        int x=(a.numerator)*(b.denominator)-(a.denominator)*(b.numerator);
        int y=(a.denominator)*(b.denominator);
        return new RationalNumber(x,y);
    }
    
    public static int pgcd(int a, int b){
        int r=a%b;
        while(r!=0){
            r=a%b;
            a=b;
            b=r;
        }
        
        return a;
    }
    
    public static RationalNumber simplify(RationalNumber a){
        int x=a.numerator/pgcd(a.numerator,a.denominator);
        int y=a.denominator/pgcd(a.numerator,a.denominator);
        return new RationalNumber(x,y);
    }
}
