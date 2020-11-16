/**
 * Plateau Class which outlines the positions of each of the plateau corners
 */

public class Plateau {

    //Bottom Left Corner constant which is (0,0)
    private final Position bottomLeft;

    //Bottom Left Corner constant which is defined through command input
    private final Position topRight;

    //Top left and bottom right corners which are calculated from the bottom left and top right corner values
    private Position topLeft;
    private Position bottomRight;


    /**
     * Plateau Constructor
     * @param topRight Takes in top right position object
     */
    public Plateau(Position topRight) {
        this.topRight = topRight;
        this.bottomLeft = new Position(0, 0);
        setPlateauCorners();
    }

    /**
     * Getter for the bottom left corner of the plateau
     * @return returns the position object for the bottom left corner of the plateau
     */
    public Position getBottomLeft() {
        return bottomLeft;
    }

    /**
     * Getter for the top right corner of the plateau
     * @return returns the position object for the top right corner of the plateau
     */
    public Position getTopRight() {
        return topRight;
    }

    /**
     * Getter for the top left corner of the plateau
     * @return returns the position object for the top left corner of the plateau
     */
    public Position getTopLeft() {
        return topLeft;
    }

    /**
     * Getter for the bottom right corner of the plateau
     * @return returns the position object for the bottom right corner of the plateau
     */
    public Position getBottomRight() {
        return bottomRight;
    }


    /**
     * Calculates the remaining corners for the plateau based on the bottom left and top right values
     */
    private void setPlateauCorners() {
        this.topLeft = new Position(0, topRight.getYCoordinate());
        this.bottomRight = new Position(topRight.getXCoordinate(), 0);
    }

    /**
     * Override of equals, checks if the passed in plateau is the same as the passed in plateau
     * @param obj takes in the plateau object which will be compared to
     * @return returns if the plateaus are equal
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Plateau p = (Plateau) obj;
        return p.getTopRight().equals(getBottomRight()) && p.getBottomLeft().equals(getBottomLeft());
    }

}
