/**
 * Position class to represent the different coordinate points on a plateau
 */

public class Position {

    //Coordinate x and y values
    private int xCoordinate;
    private int yCoordinate;

    /**
     * Constructor for position class
     *
     * @param x takes in x coordinate point value
     * @param y takes in y coordinate point value
     */
    public Position(int x, int y) {
        this.xCoordinate = x;
        this.yCoordinate = y;
    }

    /**
     * Getter for the x coordinate value in a position object
     *
     * @return returns the int x coordinate
     */
    public int getXCoordinate() {
        return xCoordinate;
    }

    /**
     * Getter for the y coordinate value in a position object
     *
     * @return returns the int y coordinate
     */
    public int getYCoordinate() {
        return yCoordinate;
    }

    /**
     * Override of toString(), displays the position objects attributes in string format
     *
     * @return returns the x and y values of the object as a string type
     */
    @Override
    public String toString() {
        return xCoordinate + "," + yCoordinate;
    }

    /**
     * Override of equals(), compares the passed in position with the current position object to check if they are equal
     *
     * @param o takes in the position object as a generic object type
     * @return returns if the passed in position is equal to the current position object
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return xCoordinate == position.xCoordinate &&
                yCoordinate == position.yCoordinate;
    }

    /**
     * Checks if the current position's x coordinate value is greater than the passed in position
     *
     * @param position takes in the bounds position object which is being checked against
     * @return returns if the current position is greater than the passed in position
     */
    public boolean xOutOfBounds(Position position) {
        return xCoordinate > position.xCoordinate;
    }

    /**
     * Checks if the current position's y coordinate value is greater than the passed in position
     *
     * @param position takes in the bounds position object which is being checked against
     * @return returns if the current position is greater than the passed in position
     */
    public boolean yOutOfBounds(Position position) {
        return yCoordinate > position.yCoordinate;
    }


    /**
     * Increases the x coordinates value by 1
     */
    public void increaseX() {
        this.xCoordinate++;
    }

    /**
     * Increases the y coordinates value by 1
     */
    public void increaseY() {
        this.yCoordinate++;
    }

    /**
     * Decreases the x coordinates value by 1
     */
    public void decreaseX() {
        this.xCoordinate--;
    }

    /**
     * Decreases the y coordinates value by 1
     */
    public void decreaseY() {
        this.yCoordinate--;
    }
}
