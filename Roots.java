/*
created by
Nilesh Domah
5216096
 */

public class Roots {

    // private attributes
    private Complex4 myRoot1 = new Complex4(0, 0);
    private Complex4 myRoot2 = new Complex4(0, 0);

    // Roots constructor:
    public Roots(Complex4 Root1, Complex4 Root2){
        myRoot1 = Root1;
        myRoot2 = Root2;
    } // end Roots constructor

    // toString method for Roots
    public String toString(){
        System.out.println("This is my current location");
        return (myRoot1.toString() + ", " + myRoot2.toString());
    } // end toString

} // end Roots class
