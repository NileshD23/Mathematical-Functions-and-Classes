/*
created by
Nilesh Domah
 */

public class Random {

    // private attributes:
    private int P1;
    private int P2;
    private int M;
    private int Seed;

    // Random class constructor:
    public Random(int p1, int p2, int m){
        P1 = p1;
        P2 = p2;
        M = m;
        Seed = 0;
    } // end Random class constructor

    // method to set the seed of the random number generator:
    public void setSeed(int seed){
        Seed = seed;
    } // end setSeed

    // method to return the value for M for this random number generator:
    public int getMaximum(){
        return M;
    } // end getMaximum

    /* method that uses the sequential random number algorithm
       to generate the rnew value and return it:
    */
    public int random() {
        int rnew = ((P1 * Seed) + P2) % M;
        Seed = rnew;
        return rnew;
    } // end random

    // method to return a random integer in the lower bound and upper bound range:
    public int randomInteger(int lower, int upper){
        int myLow;
        /* if lower bound is greater than the upper bound
            they get swapped so an error doesn't occur:
        */
        if (lower > upper){
            myLow = upper;
            upper = lower;
            lower = myLow;
        }
        myLow = random();
        while ((myLow < lower) || (myLow > upper)){
            myLow = random();
        }
        return myLow;
    } // end randomInteger

    /* method that randomly returns true or false
       should simulate a 50% chance:
    */
    public boolean randomBoolean(){
        int myLow;
        myLow = random();
        while ((myLow < 0) || (myLow > 1)) {
            myLow = random();
        }
        if (myLow == 1) {
            return true;
        }
        else {
            return false;
        }
    } // end randomBoolean

    // method to get a random double in lower bound and upper bound range:
    public double randomDouble(double lower, double upper){
        double myLow;
        /* if lower bound is greater than the upper bound
            they get swapped so an error doesn't occur:
        */
        if (lower > upper) {
            myLow = upper;
            upper = lower;
            lower = myLow;
        }
        myLow = random() / 1.0E00;
        while ((myLow < lower) || (myLow > upper)){
            myLow = random();
        }
        return myLow;
    } // end randomDouble

    // main method for testing
    public static void main(String[] args){
        Random myRandom = new Random(7919, 65537, 102611); // example from PDF
        myRandom.setSeed(581);
        System.out.println("This is the maximum value: " + myRandom.getMaximum());

        // set bounds for myRandom:
        myRandom.randomInteger(1,5);

        // recursive method to test randomInteger:
        for (int i = 0; i < 10; i++){
            System.out.println("Here is a random integer: " + myRandom.randomInteger(9, 15));
        }

        // recursive method to test randomDouble:
        for (int i = 0; i < 10; i++){
            System.out.println("Here is a random double: " + myRandom.randomDouble(12,6));
        }

        // recursive method to test randomBoolean:
        for (int i = 0; i < 10; i++){
            System.out.println("Here is a random boolean: "  + myRandom.randomBoolean());
        }

        // new randomBoolean test using a new seed:
        int first, second;
        first = second = 0;
        for (int i = 0; i < 125;i++){
            boolean myBool = myRandom.randomBoolean();
            if (myBool == true) {
                first++;
            }
            else {
                second++;
            }
        }

        System.out.println("The true to false ratio is: " + first + " to " + second);

    } // end main

} // end Random class
