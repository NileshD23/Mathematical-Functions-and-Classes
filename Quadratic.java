/*
created by
Nilesh Domah
5216096
 */

public class Quadratic {

    // private attributes:
    private float A;
    private float B;
    private float C;

    // Quadratic class constructor:
    public Quadratic(float a, float b, float c){
        A = a;
        B = b;
        C = c;
    } // end Quadratic class constructor

    // getter methods for private variables:
    public float getA(){
        return A;
    }

    public float getB(){
        return B;
    }

    public float getC(){
        return C;
    }

    // setter methods for private variables:
    public void setA(float A){
        this.A = A;
    }

    public void setB(float B){
        this.B = B;
    }

    public void setC(float C){
        this.C = C;
    }

    /* method to add 'other' to the current quadratic function
       and return the result as a new 'Quadratic':
     */
    public Quadratic add(Quadratic other){
        Quadratic temp;
        float tempA = A + other.getA();
        float tempB = B + other.getB();
        float tempC = C + other.getC();
        temp = new Quadratic(tempA, tempB, tempC);
        return temp;
    } // end Quadratic add

    /* method to subtract 'other' from the current quadratic function
       and return the result as new 'Quadratic':
     */
    public Quadratic subtract(Quadratic other){
        Quadratic temp;
        float tempA = A - other.getA();
        float tempB = B - other.getB();
        float tempC = C - other.getC();
        temp = new Quadratic(tempA, tempB, tempC);
        return temp;
    } // end Quadratic subtract

    /* method that uses quadratic formula to find the roots of the current
       quadratic function and returns an instance of the 'Roots' class
       containing those roots:
     */
    public Roots findRoots(){
        Complex4 myComplex, myComplex2;
        double real, aA, bB, cC, imaginary;
        Roots myRoot;
        // if b^2 - 4ac is positive:
        if (((B * B) - 4 * ( A * C)) > 0) {
            // real is (- b + sqrt( b^2 - 4ac)) / 2a
            real = ((((-1) * B) + Math.sqrt((B * B) - 4 * A * C )) / (2 * A));
            myComplex = new Complex4(real, 0.0);

            //real is (- b - sqrt( b^2 - 4ac)) / 2a
            real = ((((-1) * B) - Math.sqrt((B * B) - 4 * A * C )) / (2 * A));
            myComplex2 = new Complex4(real, 0.0);
            myRoot = new Roots(myComplex, myComplex2);
        }
        else {
            real = ((-1)* B);
            imaginary = Math.sqrt((-1) * ((B * B) - (4 * A * C)));
            myComplex = new Complex4(real, imaginary);
            imaginary = (-1) * Math.sqrt((-1) * ((B * B) - (4 * A * C)));
            myComplex2 = new Complex4(real, imaginary);
            myRoot = new Roots(myComplex, myComplex2);
        }
        return myRoot;
    } // end Roots

    // toString method to return representation of current quadratic formula:
    public String toString(){
        return (A + "x^2 + " + B + "x + " + C);
    } // end toString

    /* boolean method that will return
       True - if current quadratic formula is equal to 'other'
       False - if otherwise:
     */
    public boolean equals(Object other){
        Quadratic temp;
        boolean same = false;
        if (other instanceof Quadratic){
            temp = (Quadratic) other;
            if (A == temp.getA() && B == temp.getB() && C == temp.getC()){
                same = true;
            }
        }
        return same;
    } // end equals

    // main method for testing:
    public static void main(String[] args){
        Quadratic myQuad1 = new Quadratic(9, -4, 1); // example from PDF
        Quadratic myQuad2 = new Quadratic(2, -9,-4);

        // testing methods:
        System.out.println("My current quadratic function is: ");
        System.out.println(myQuad1.toString());
        System.out.println("The roots of my quadratic function are: ");
        Roots testRoot = myQuad1.findRoots(); // should return "This is my current location"
        System.out.println(testRoot.toString());
        System.out.println("Are both functions equal? (yes - true, no - false):");
        System.out.println(myQuad1.equals(myQuad2));
        System.out.println("Adding both functions equals: ");
        System.out.println(myQuad1.add(myQuad2));
        System.out.println("Subtracting both functions equals: ");
        System.out.println(myQuad1.subtract(myQuad2));
    } // end main

} // end Quadratic class
