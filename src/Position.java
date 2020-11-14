import java.util.Objects;

public class Position {

    private int xCoordinate;
    private int yCoordinate;

    public Position(int x, int y){
        this.xCoordinate = x;
        this.yCoordinate = y;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    @Override
    public String toString() {
        return xCoordinate + "," + yCoordinate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return xCoordinate == position.xCoordinate &&
                yCoordinate == position.yCoordinate;
    }

    private boolean xOutOfBounds(Position position){
        return position.xCoordinate > xCoordinate || position.xCoordinate < 0;
    }

    private boolean yOutOfBounds(Position position){
        return position.yCoordinate > yCoordinate || position.yCoordinate < 0;
    }
}
