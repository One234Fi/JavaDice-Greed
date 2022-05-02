/*
Ethan McCarthy
4/26/2022
Project: Greed
Description: Class to implement the functionality of a die with an arbitrary amount of sides
*/

class Die {
    //constant number of faces
    private final int faceCount;
    
    //value of the die face that is facing up
    private int faceUp = 1;
    
    /**
     * Die constructor
     * @param numFaces The number of sides the die has
     */
    public Die(int numFaces) {
        this.faceCount = numFaces;
    }
    
    //roll the die, update faceUp, and return the result
    public int Roll() {
        faceUp = (int) (Math.random() * faceCount) + 1;
        return faceUp;
    }
}